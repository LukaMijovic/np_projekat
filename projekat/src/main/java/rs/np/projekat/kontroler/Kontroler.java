package rs.np.projekat.kontroler;

import java.sql.SQLException;

import rs.np.projekat.db.DBBroker;
import rs.np.projekat.domen.Sudija;

/**
 * Klasa Kontroler sadrzi svu logiku povezivanja GUI sa DBBrokerom.
 * 
 * @author mijov
 */
public class Kontroler {

	/**
	 * Instanca kontrolera kao singleton patern.
	 */
	private static Kontroler instanca;
	
	/**
	 * Instanca DBBrokera kako bi Kontroler komunicirao sa bazom.
	 */
	private DBBroker db;
	
	private Kontroler() {
		
	}
	
	/**
	 * Vraca instancu kontrolera ako je vec kreirana ranije, a kreira instancu ako nije kreirana ranije.
	 * 
	 * @return instanca : Kontroler.
	 */
	public static Kontroler getKontroler() {
		if (instanca == null) {
			instanca = new Kontroler();
		}
		
		return instanca;
	}
	
	/**
	 * Prijavljuje sudiju na sistem.
	 * 
	 * @param email
	 * @param sifra
	 * @return
	 */
	public Sudija prijavi(String email, String sifra) {
		//boolean flagUspeh = false;
		
		this.db = DBBroker.getDBBroker();
		
		Sudija sudija = null;
		
		try {
			
			this.db.uspostaviKonekciju();	

			
			Sudija pomocni = new Sudija();
			pomocni.setEmail(email);
			pomocni.setSifra(sifra);
			
			sudija = db.prijavi(pomocni);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sudija;
		//return flagUspeh;
	}
	
	/**
	 * Registruje novog sudiju.
	 * 
	 * @param sudija
	 * @return true ako je uspesna registracija ili false ako je neuspesna.
	 */
	public boolean registracija(Sudija sudija) {
		boolean flag = false;
		
		this.db = DBBroker.getDBBroker();
		
		try {
				
			this.db.uspostaviKonekciju();	
			
			
			flag = db.registracija(sudija);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}
}
