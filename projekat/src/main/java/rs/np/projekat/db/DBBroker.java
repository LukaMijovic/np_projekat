package rs.np.projekat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rs.np.projekat.domen.Sudija;

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
	
}
