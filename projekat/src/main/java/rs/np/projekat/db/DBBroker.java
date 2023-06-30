package rs.np.projekat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
     * Uspostavlja konekciju sa bazom.
     * 
     * @throws SQLException kada nije uspesno povezivanje sa bazom.
     */
    public void uspostaviKonekciju() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/sports_blog";
            String username = "root";
            String password = "napoleon00";
            
            System.out.println(username + " " + password);
            
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
	
}
