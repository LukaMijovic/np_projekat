package rs.np.projekat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import rs.np.projekat.domen.Drzava;
import rs.np.projekat.domen.Fudbaler;
import rs.np.projekat.domen.Klub;
import rs.np.projekat.domen.Pozicija;
import rs.np.projekat.domen.Sudija;
import rs.np.projekat.domen.Utakmica;

/**
 * Klasa DBBroker uspostavlja konekciju sa bazom podataka.
 * 
 * Atributi:
 * 	<ul>
 * 		<li>conn: Connection</li>
 * 	</ul>
 * 
 * Metode:
 * 	<ul>
 * 		<li>uspostaviKonekciju: void</li>
 * 		<li>zatvoriKonekciju: void</li>
 * 		<li>prijavi: Sudija</li>
 * 	</ul>
 * 
 * @author mijov
 */
public class DBBroker {

	/**
	 * Instanca klase Connection. Sluzi da preko nje DBBroker komunicira sa bazom.
	 */
    private Connection conn;
    
    /**
     * Instanca DBBrokera kao singlton patern.
     */
    private static DBBroker instanca;
    
    private DBBroker() {
    	
    }
    
    /**
     * Vraca instancu DBBrokera.
     * 
     * @return instanca
     */
    public static DBBroker getDBBroker() {
    	if (instanca == null) {
    		instanca = new DBBroker();
    	}
    	
    	return instanca;
    }
    
    /**
     * Uspostavlja konekciju sa bazom.
     * 
     * @throws SQLException kada nije uspesno povezivanje sa bazom.
     */
    public void uspostaviKonekciju() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/np_projekat";
            String username = "root";
            String password = "napoleon00";
            
            //System.out.println(username + " " + password);
            
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("conn je inicjalizovan");
            conn.setAutoCommit(true);
            
            System.out.println("Usepsna konekcija sa bazom");
        } catch (SQLException ex) {
            throw new SQLException("Neuspesno povezivanje sa bazom.");
        }
    } 
    
    /**
     * Raskida vezu sa bazom.
     * 
     * @throws Exception kada zatvaranje konekcije nije uspelo.
     */
    public void zatvoriKonekciju() throws Exception {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije");
        }
    }
    
    /**
     * Metoda salje bazi podatke sudije i pronalazi sudiju sa prosledjenim mejlom i sifrom kako bi sudija mogao da se prijavi na sistem.
     * 
     * @param pomocni instanca Sudije.
     * @return sudiju koji ima prosledjen mejl i sifru ili null ako ga nije pronasao.
     */
    public Sudija prijavi(Sudija pomocni) {
    	
    	String query = String.format("SELECT * FROM sudija WHERE email = '%s' AND sifra = '%s'", pomocni.getEmail(), pomocni.getSifra());
    	System.out.println(query);
    	
    	Sudija sudija = null;
    	
    	try {
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			if (rs != null) {
				if (rs.next()) {
					int id = rs.getInt("id");
					String ime = rs.getString("ime");
					String prezime = rs.getString("prezime");
					String email = rs.getString("email");
					String sifra = rs.getString("sifra");
					
					sudija = new Sudija();
					sudija.setId(id);
					sudija.setIme(ime);
					sudija.setPrezime(prezime);
					sudija.setEmail(email);
					sudija.setPrezime(prezime);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return sudija;
    }

    /**
     * Vraca instancu konekcije.
     * 
     * @return conn
     */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Registruje novog sudiju.
	 * 
	 * @param sudija sudija koji se registruje
	 * @return true ako je registracija uspesna ili false ako nije
	 */
	public boolean registracija(Sudija sudija) {
		boolean flag = false;
		
		String query = String.format("INSERT INTO sudija (ime, prezime, email, sifra) VALUES ('%s', '%s', '%s', '%s')", sudija.getIme(), sudija.getPrezime(), sudija.getEmail(), sudija.getSifra());
		System.out.println(query);

		Statement stat;
		try {
			stat = conn.createStatement();
			int result = stat.executeUpdate(query);
			
			if (result != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}
	

	/**
	 * Vraca nazive timova na osnovu njihovih id.
	 * 
	 * @param idH id domacina
	 * @param idA id gosta
	 * @return niz naziva timova kao Stringove.
	 */
	public String[] vratiTimove(int idH, int idA) {
		
		String[] timovi = {"/", "/"};
		
		String queryH = String.format("SELECT naziv FROM klub WHERE id = '%s'", idH);
		String queryA = String.format("SELECT naziv FROM klub WHERE id = '%s'", idA);
		System.out.println(queryH);
		System.out.println(queryA);
		
		try {
			Statement stat = conn.createStatement();
			ResultSet rsH = stat.executeQuery(queryH);
			
			if (rsH != null) {
				if (rsH.next())
					timovi[0] = rsH.getString("naziv");
			}
			
			ResultSet rsA = stat.executeQuery(queryA);
			
			if (rsA != null) {
				if (rsA.next())
					timovi[1] = rsA.getString("naziv");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return timovi;
		
	}

	/**
	 * Vraca rezultate utakmica po zadatom kriterijumu.
	 * 
	 * @param kriterijum po kom se radi pretraga.
	 * @param id sudije koji vrsi pretragu
	 * @return rezultate utakmica kao lista utakmica.
	 */
	public List<Utakmica> vratiRezultate(HashMap<String, String> kriterijum, int id) {
		
		String query = "SELECT * FROM utakmica WHERE sudija = " + id;
		
//		
//		if (kriterijum.get("idH") != null) {
//			query += " idH = " + kriterijum.get("idH") + " AND";
//		}
//		if (kriterijum.get("idA") != null) {
//			query += " idA = " + kriterijum.get("idA");
//		}
		
		System.out.println(query);
		
		List<Utakmica> rezultati = new LinkedList<>();
		
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			if (rs != null) {
				while (rs.next()) {
					int idH = rs.getInt("idH");
					int idA = rs.getInt("idA");
					int sudija = rs.getInt("sudija");
					int golH = rs.getInt("golH");
					int golA = rs.getInt("golA");
					
					Utakmica u = new Utakmica();
					u.setIdH(idH);
					u.setIdA(idA);
					u.setGolA(golA);
					u.setGolH(golH);
					u.setSudija(sudija);
					
					System.out.println(u);
					rezultati.add(u);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rezultati;
		
	}

	/**
	 * Vraca drzave iz baze podataka
	 * 
	 * @return drzave kao listu Drzava.
	 */
	public List<Drzava> vratiDrzave() {
		List<Drzava> drzave = new ArrayList<>();
		
		String query = "SELECT * FROM drzava";
		
		try {
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String naziv = rs.getString("naziv");
					
					Drzava pomocna = new Drzava(id, naziv);
					System.out.println(pomocna);
					drzave.add(pomocna);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return drzave;
	}

	/**
	 * Vraca sve moguce pozicije igraca na terenu.
	 * 
	 * @return pozicije kao lista pozicija.
	 */
	public List<Pozicija> vratiPozicije() {
		// TODO Auto-generated method stub
		List<Pozicija> pozicije = new ArrayList<>();
		
		String query = "SELECT * FROM pozicija";
		
		try {
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String naziv = rs.getString("naziv");
					
					Pozicija pomocna = new Pozicija(id, naziv);
					System.out.println(pomocna);
					pozicije.add(pomocna);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pozicije;
	}

	
	/**
	 * Vraca dostupne klubove.
	 * 
	 * @return klubove kao listu Klubova.
	 */
	public List<Klub> vratiKlubove() {
		List<Klub> klubovi = new ArrayList<>();
		
		String query = "SELECT * FROM klub";
		
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					int brojW = rs.getInt("brojW");
					int brojL = rs.getInt("brojL");
					int brojD = rs.getInt("brojD");
					String naziv = rs.getString("naziv");
					int stadion = rs.getInt("stadion");
					int trener = rs.getInt("trener");
					int drzava = rs.getInt("drzava");
					
					Klub klub = new Klub(id, naziv, brojW, brojL, brojD, stadion, trener, drzava);
					klubovi.add(klub);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return klubovi;
	}

	/**
	 * Unosi fudbalera u bazu podataka.
	 * 
	 * @param fudbaler koji se unosi
	 * @return true ako je uspesno fudbaler unet, false ako nije.
	 */
	public boolean unesiFudbalera(Fudbaler fudbaler) {
		boolean flag = false;
		
		String query = String.format("INSERT INTO fudbaler (ime, prezime, brojNaDresu, pozicija, drzava, klub) VALUES ('%s', '%s', '%d', '%d', '%d', '%d')", 
										fudbaler.getIme(), 
										fudbaler.getPrezime(), 
										fudbaler.getBrojNaDresu(), 
										fudbaler.getPozicija(), 
										fudbaler.getDrzava(), 
										fudbaler.getKlub()
									);
		System.out.println(query);
		
		try {
			Statement stat = conn.createStatement();
			int result = stat.executeUpdate(query);
			
			if (result != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	/**
	 * Unosi novu utakmicu u bazu podataka i azurira posledice te utakmice.
	 * 
	 * @param utakmica koja se unosi
	 * @return true ako je uspesno ubacivanje u bazu ili false ako nije.
	 */
	public boolean unesiUtakmicu(Utakmica utakmica) {
		boolean flag = false;
		
		String query = String.format("INSERT INTO utakmica (idH, idA, sudija, golH, golA) VALUES ('%d', '%d', '%d', '%d', '%d')", 
										utakmica.getIdH(),
										utakmica.getIdA(),
										utakmica.getSudija(),
										utakmica.getGolH(),
										utakmica.getGolA()
									);
		System.out.println(query);
		
		try {
			Statement stat = conn.createStatement();
			int result = stat.executeUpdate(query);
			
			if (result != 0) {
				flag = true;
				
				azurirajUspeh(utakmica.getIdH(), utakmica.getIdA(), utakmica.getGolH(), utakmica.getGolA());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	/**
	 * Azurira pobede, poraze ili neresene rezultate klubova koji su odigrali utakmicu.
	 * 
	 * @param idH id domacina
	 * @param idA id gosta
	 * @param golH broj golova domacina
	 * @param golA broj golova gosta
	 */
	private void azurirajUspeh(int idH, int idA, int golH, int golA) {
		// TODO Auto-generated method stub
		if (golH > golA) {
			
			String queryH = String.format("UPDATE klub SET brojW = brojW + 1 WHERE id = '%d'", idH);
			String gueryA = String.format("UPDATE klub SET brojL = brojL + 1 WHERE id = '%d'", idA);
			try {
				Statement stat = conn.createStatement();
				stat.executeUpdate(queryH);
				stat.executeUpdate(gueryA);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (golH == golA) {
			String queryH = String.format("UPDATE klub SET brojD = brojD + 1 WHERE id = '%d'", idH);
			String gueryA = String.format("UPDATE klub SET brojD = brojD + 1 WHERE id = '%d'", idA);
			
			try {
				Statement stat = conn.createStatement();
				stat.executeUpdate(queryH);
				stat.executeUpdate(gueryA);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String queryH = String.format("UPDATE klub SET brojL = brojL + 1 WHERE id = '%d'", idH);
			String gueryA = String.format("UPDATE klub SET brojW = brojW + 1 WHERE id = '%d'", idA);
			
			try {
				Statement stat = conn.createStatement();
				stat.executeUpdate(queryH);
				stat.executeUpdate(gueryA);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Vraca fudbalera sa zadatim imenom i prezimenom.
	 * 
	 * @param ime fudbalera
	 * @param prezime fudbalera
	 * @return fudbalera koji ima zadato ime i prezime
	 */
	public FudbalerDT vratiFudbalera(String ime, String prezime) {
		String query = String.format("SELECT f.ime, f.prezime, f.brojNaDresu, p.naziv AS 'pozicija', d.naziv AS 'drzava', k.naziv AS 'klub'"
				+ " FROM fudbaler f"
				+ " LEFT JOIN pozicija p ON (f.pozicija = p.id)"
				+ " LEFT JOIN drzava d ON (f.drzava = d.id)"
				+ " LEFT JOIN klub k ON (f.klub = k.id)"
				+ " WHERE f.ime = '%s' AND f.prezime = '%s'",
					ime, prezime
		);
		
		System.out.println(query);
		
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			if (rs != null) {
				if (rs.next()) {
					int brojNaDresu = rs.getInt("brojNaDresu");
					String pozicija = rs.getString("pozicija");
					String drzava = rs.getString("drzava");
					String klub = rs.getString("klub");
					
					FudbalerDT f = new FudbalerDT(ime, prezime, brojNaDresu, pozicija, drzava, klub);
					
					return f;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
