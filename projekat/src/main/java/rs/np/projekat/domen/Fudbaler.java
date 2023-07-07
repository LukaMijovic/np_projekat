package rs.np.projekat.domen;

/**
 * Klasa Fudbaler predstavlja igraca sa svim njegovim osobinama.
 * 
 * @author mijov
 */
public class Fudbaler {

	/**
	 * Id fudbalera.
	 */
	private int id;
	
	/**
	 * Ime fudbalera kao String.
	 */
	private String ime;
	
	/**
	 * Prezime fudbalera kao String.
	 */
	private String prezime;
	
	/**
	 * Broj na dresu fudbalera 1-99.
	 */
	private int brojNaDresu;
	
	/**
	 * Id kluba u kom igra fudbaler.
	 */
	private int klub;
	
	/**
	 * Id drzave iz koje je fudbaler.
	 */
	private int drzava;
	
	/**
	 * Id pozicije na kojoj igra fudbaler.
	 */
	private int pozicija;

	/**
	 * Vraca id fudbalera.
	 * 
	 * @return id : Integer.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id fudbalera.
	 * 
	 * @param id fudbalera 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Vraca ime fudbalera.
	 * 
	 * @return ime : String.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime fudbalera.
	 * 
	 * @param ime fudbalera koje se postavlja
	 * @throws IllegalArgumentException kada je ime null ili prazan string.
	 */
	public void setIme(String ime) throws IllegalArgumentException {
		if (ime == null || ime.length() == 0) {
			throw new IllegalArgumentException("Ime ne moze biti null ili prazan string.");
		}
		
		this.ime = ime;
	}

	/**
	 * Vraca prezime fudbalera.
	 * 
	 * @return prezime : String.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime fudbalera.
	 * 
	 * @param prezime fudbalera koje se postavlja
	 * @throws IllegalArgumentException kada je prezime null ili prazan string.
	 */
	public void setPrezime(String prezime) throws IllegalArgumentException {
		if (prezime == null || prezime.length() == 0) {
			throw new IllegalArgumentException("prezime ne moze biti null ili prazan string.");
		}
		
		this.prezime = prezime;
	}

	/**
	 * Vraca broj na dresu fudbalera.
	 * 
	 * @return brojNaDresu : Integer.
	 */
	public int getBrojNaDresu() {
		return brojNaDresu;
	}

	/**
	 * Postavlja broj na dresu fudbalera.
	 * 
	 * @param brojNaDresu fudbalera koji se postavlja
	 * @throws IllegalArgumentException kada je broj van okvira 1-99.
	 */
	public void setBrojNaDresu(int brojNaDresu) throws IllegalArgumentException {
		if (brojNaDresu < 1 || brojNaDresu > 99) {
			throw new IllegalArgumentException("Broj na dresu ne moze biti van okvira 1-99.");
		}
		
		this.brojNaDresu = brojNaDresu;
	}

	/**
	 * Vraca id kluba u kom igra fudbaler.
	 * 
	 * @return klub : Integer.
	 */
	public int getKlub() {
		return klub;
	}

	/**
	 * Postavlja id kluba u kom igra fudbaler.
	 * 
	 * @param klub id kluba koji se dodeljuje fudbaleru
	 * @throws IllegalArgumentException kada je id kluba negativan broj.
	 */
	public void setKlub(int klub) throws IllegalArgumentException {
		if (klub < 0) {
			throw new IllegalArgumentException("Id kluba ne moze biti negativan.");
		}
		
		this.klub = klub;
	}

	/**
	 * Vraca id drzave iz koje je fudbaler.
	 * 
	 * @return drzava : Integer.
	 */
	public int getDrzava() {
		return drzava;
	}

	/**
	 * Postavlja id drzave iz koje je fudbaler.
	 * 
	 * @param drzava id drzave iz koje je fudbaler
	 * @throws IllegalArgumentException kada je id drzave negativan broj.
	 */
	public void setDrzava(int drzava) throws IllegalArgumentException {
		if (drzava < 0) {
			throw new IllegalArgumentException("Id drzave ne moze biti negativan.");
		}
		
		this.drzava = drzava;
	}

	/**
	 * Vraca id pozicije.
	 * 
	 * @return pozicija : Integer.
	 */
	public int getPozicija() {
		return pozicija;
	}

	/**
	 * Vraca id pozicije na kojoj igra igrac.
	 * 
	 * @param pozicija id pozicije koju igra fudbaler
	 * @throws IllegalArgumentException kada je id pozicije negativan broj.
	 */
	public void setPozicija(int pozicija) throws IllegalArgumentException {
		if (pozicija < 0) {
			throw new IllegalArgumentException("Id pozicije ne moze biti negativan.");
		}
		
		this.pozicija = pozicija;
	}

	/**
	 * Kreira hashcode na osnovu id.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Proverava jednakost 2 Fudbalera na osnovu id.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fudbaler other = (Fudbaler) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Vraca string sa imenom, prezimenom, brojem na dresu i id kluba.
	 */
	@Override
	public String toString() {
		return "Fudbaler [ime=" + ime + ", prezime=" + prezime + ", brojNaDresu=" + brojNaDresu + ", klub=" + klub
				+ "]";
	}
	
}
