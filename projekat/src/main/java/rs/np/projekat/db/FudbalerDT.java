package rs.np.projekat.db;

/**
 * Klasa namenjena za transfer podataka Fudbalera ali u formatu u kom se moze prikazati na GUI.
 * 
 * @author mijov
 */
public class FudbalerDT {

	/**
	 * Ime fudbalera.
	 */
	private final String ime;

	/**
	 * Prezime fudbalera.
	 */
	private final String prezime;
	
	/**
	 * Broj na dresu.
	 */
	private final int brojNaDresu;
	
	/**
	 * Pozicija koji igra fudbaler.
	 */
	private final String pozicija;
	
	/**
	 * Drzava porekla fudbalera.
	 */
	private final String drzava;
	
	/**
	 * Klub u kom igra fudbaler.
	 */
	private final String klub;

	public FudbalerDT(String ime, String prezime, int brojNaDresu, String pozicija, String drzava, String klub) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brojNaDresu = brojNaDresu;
		this.pozicija = pozicija;
		this.drzava = drzava;
		this.klub = klub;
	}

	/**
	 * Vraca ime igraca.
	 * 
	 * @return ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Vraca prezime igraca.
	 * 
	 * @return prezime
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Vraca broj na dresu igraca.
	 * 
	 * @return brojNaDresu
	 */
	public int getBrojNaDresu() {
		return brojNaDresu;
	}

	/**
	 * Vraca poziciju igraca.
	 * 
	 * @return pozicija
	 */
	public String getPozicija() {
		return pozicija;
	}

	/**
	 * Vraca drzavu igraca.
	 * 
	 * @return drzava
	 */
	public String getDrzava() {
		return drzava;
	}

	/**
	 * Vraca klub igraca.
	 * 
	 * @return klub
	 */
	public String getKlub() {
		return klub;
	}
	
}
