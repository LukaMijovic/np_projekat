package rs.np.projekat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
     * @return
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
     * @param pomocni
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
     * @return
     */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Registruje novog sudiju.
	 * 
	 * @param sudija
	 * @return
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
	 * @param idH
	 * @param idA
	 * @return niz naziva timova kao Stringove.
	 */
	public String[] vratiTimove(int idH, int idA) {
		
		String[] timovi = {"/", "/"};
		
		String query = String.format("SELECT naziv FROM klub WHERE id = '%s' OR id = '%s'", idH, idA);
		System.out.println(query);
		
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			if (rs != null) {
				
				int count = 0;
				
				while (rs.next()) {
					timovi[count++] = rs.getString("naziv");
				}
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
	 * @param kriterijum
	 * @return rezultate utakmica kao lista utakmica.
	 */
	public List<Utakmica> vratiRezultate(HashMap<String, String> kriterijum) {
		
		String query = "SELECT * FROM utakmica";
		
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
					int stadion = rs.getInt("stadion");
					
					Utakmica u = new Utakmica();
					u.setIdH(idH);
					u.setIdA(idA);
					u.setGolA(golA);
					u.setGolH(golH);
					u.setStadion(stadion);
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
	
}
