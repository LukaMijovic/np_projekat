package rs.np.projekat;

import java.sql.SQLException;

import rs.np.projekat.db.DBBroker;
import rs.np.projekat.domen.Sudija;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("Hello World!");
        
        DBBroker db = new DBBroker();
        Sudija s = new Sudija();
        s.setEmail("marko@test.com");
        s.setSifra("marko123");
        
        try {
			db.uspostaviKonekciju();
			Sudija res = db.prijavi(s);
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
