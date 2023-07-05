package rs.np.projekat.kontroler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import rs.np.projekat.db.DBBroker;
import rs.np.projekat.db.FudbalerDT;
import rs.np.projekat.domen.Drzava;
import rs.np.projekat.domen.Fudbaler;
import rs.np.projekat.domen.Klub;
import rs.np.projekat.domen.Pozicija;
import rs.np.projekat.domen.Sudija;
import rs.np.projekat.domen.Utakmica;

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
	 * Id sudije koji je ulogovan.
	 */
	private int ulogovaniSudija;
	
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
		
		ulogovaniSudija = sudija.getId();
		
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

	/**
	 * Vraca nazive timova na osnovu id.
	 * 
	 * @param idH
	 * @param idA
	 * @return nazive timova kao Stringove.
	 */
	public String[] vratiTimove(int idH, int idA) {
		String[] timovi = {};
		
		this.db = DBBroker.getDBBroker();
		try {
			this.db.uspostaviKonekciju();
			
			timovi = db.vratiTimove(idH, idA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return timovi;
	}

	/**
	 * Vraca rezultate svih utakmica sa prosledjenim kriterijumom.
	 * 
	 * @param kriterijum
	 * @return rezultati utakmica kao lista utakmica.
	 */
	public List<Utakmica> vratiRezultate(HashMap<String, String> kriterijum) {
		List<Utakmica> rezultati = new LinkedList<>();
		
		this.db = DBBroker.getDBBroker();
		
		try {
			this.db.uspostaviKonekciju();
			
			rezultati = db.vratiRezultate(kriterijum, ulogovaniSudija);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rezultati;
	}

	/**
	 * Vraca sve drzave iz baze podataka.
	 * 
	 * @return drzave kao listu Drzava.
	 */
	public List<Drzava> vratiDrzave() {
		// TODO Auto-generated method stub
		List<Drzava> drzave = new ArrayList<>();
		
		db = DBBroker.getDBBroker();
		
		try {
			db.uspostaviKonekciju();
			
			drzave = db.vratiDrzave();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return drzave;
	}

	/**
	 * Vraca sve pozicije koje igrac moze zauzeti na terenu.
	 * 
	 * @return pozicije kao listu Pozicija.
	 */
	public List<Pozicija> vratiPozicije() {
		// TODO Auto-generated method stub
		List<Pozicija> pozicije = new ArrayList<>();
		
		db = DBBroker.getDBBroker();
		
		try {
			db.uspostaviKonekciju();
			
			pozicije = db.vratiPozicije();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pozicije;
	}

	/**
	 * Vraca dostupne klubove u kojima igrac moze potencijano igrati.
	 * 
	 * @return klubovi kao lista Klubova.
	 */
	public List<Klub> vratiKlubove() {
		// TODO Auto-generated method stub
		List<Klub> klubovi = new ArrayList<>();
		
		db = DBBroker.getDBBroker();
		
		try {
			db.uspostaviKonekciju();
			
			klubovi = db.vratiKlubove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return klubovi;
	}

	/**
	 * Unosi novog fudbalera.
	 * 
	 * @param fudbaler
	 * @return true ako je uspesno unet ili false ako nije.
	 */
	public boolean unesiFudbalera(Fudbaler fudbaler) {
		boolean flag = false;
		
		db = DBBroker.getDBBroker();
		try {
			db.uspostaviKonekciju();
			flag = db.unesiFudbalera(fudbaler);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	/**
	 * Vraca id sudije koji je trenutno ulogovan.
	 * 
	 * @return
	 */
	public int getUlogovaniSudija() {
		return ulogovaniSudija;
	}

	/**
	 * Postavlja integer koji predstavlja ulogovnaog sudije.
	 * 
	 * @param ulogovaniSudija
	 */
	public void setUlogovaniSudija(int ulogovaniSudija) {
		this.ulogovaniSudija = ulogovaniSudija;
	}

	/**
	 * Unosi prosledjenu utakmicu u bazu.
	 * 
	 * @param utakmica
	 * @return true ako je uspesno unosenje ili false ako nije.
	 */
	public boolean unesiUtakmicu(Utakmica utakmica) {
		boolean flag = false;
		
		db = DBBroker.getDBBroker();
		try {
			db.uspostaviKonekciju();
			flag = db.unesiUtakmicu(utakmica);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	/**
	 * Vraca fudbalera koji se poklapa sa zadatim kriterijumom.
	 * 
	 * @param ime
	 * @param prezime
	 * @return fudbaler koji se poklapa sa zadatim kriterijumom.
	 */
	public FudbalerDT vratiFudbalera(String ime, String prezime) {
		// TODO Auto-generated method stub
		try {
			db.uspostaviKonekciju();
			
			return db.vratiFudbalera(ime, prezime);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
