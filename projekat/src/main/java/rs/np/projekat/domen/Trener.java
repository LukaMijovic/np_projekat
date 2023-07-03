package rs.np.projekat.domen;

/**
 * Klasa Trener predstavlja trenera nekog kluba.
 * 
 * Atributi:
 * 	<ul>
 * 		<li>id: Integer</li>
 * 		<li>ime: String</li>
 * 		<li>prezime: String</li>
 * 		<li>klub: Integer</li>
 * 		<li>drzava: Integer</li>
 * 	</ul>
 * 
 * @author mijov
 */
public class Trener {

	/**
	 * Id trenera. Predstavlja primarni kljuc.
	 */
	private int id;
	
	/**
	 * Ime trenera kao String.
	 */
	private String ime;
	
	/**
	 * Prezime trenera kao String.
	 */
	private String prezime;
	
	/*
	 * Id kluba u kom se nalazi igrac.
	 */
	private int klub;
	
	/**
	 * Id drzave iz koje je igrac.
	 */
	private int drzava;

	public Trener(int id, String ime, String prezime, int klub, int drzava) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.klub = klub;
		this.drzava = drzava;
	}

	public Trener() {
		super();
	}

	/**
	 * Override metode toString klase Object. Vraca atribute klase Trener u String formatu.
	 */
	@Override
	public String toString() {
		return "Trener [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", klub=" + klub + "]";
	}

	/**
	 * Generise hashCode klase na osnovu id.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Proverava da li su 2 trenera ista na osnovu id.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trener other = (Trener) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	/**
	 * Postavlja id Trenera.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime Trenera kao string.
	 * 
	 * @param ime
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime Trenera kao string.
	 * 
	 * @param prezime
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getKlub() {
		return klub;
	}

	/**
	 * Postavlja id kluba u kom se nalazi Trener.
	 * 
	 * @param klub
	 * @throws IllegalArgumentException kada se prosledi id kluba manji od 0.
	 */
	public void setKlub(int klub) throws IllegalArgumentException {
		if (klub < 0) {
			throw new IllegalArgumentException("Id kluba ne moze biti negativan.");
		}
		
		this.klub = klub;
	}

	public int getDrzava() {
		return drzava;
	}

	/**
	 * Postavja id drzave iz koje je Trener.
	 * 
	 * @param drzava
	 * @throws IllegalArgumentException kada se prosledi id drzave manji od 0.
	 */
	public void setDrzava(int drzava) throws IllegalArgumentException {
		if (drzava < 0) {
			throw new IllegalArgumentException("Id drzave ne moze biti negativan.");
		}
		
		this.drzava = drzava;
	}

}
