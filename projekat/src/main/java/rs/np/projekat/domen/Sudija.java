package rs.np.projekat.domen;

/**
 * Klasa Sudija predstavlja jednog sudiju sa utakmice koji nakon utakmice zapisuje rezultat i statistike igraca.
 * 
 * Atributi:
 * 	<ul>
 * 		<li>id: Integer</li>
 * 		<li>ime: String</li>
 * 		<li>prezime: String</li>
 * 		<li>email: String</li>
 * 		<li>sifra: String</li>
 * 	</ul>
 * 
 * @author mijov
 */
public class Sudija {
	
	/**
	 * ID sudije iz baze.
	 */
	private int id;

	/**
	 * Ime sudije. Zapisano u String formatu.
	 */
	private String ime;
	
	/**
	 * Prezime sudije. Zapisano u String formatu.
	 */
	private String prezime;
	
	/**
	 * Email sudije. Zapisan u String formatu. Sluzi za logovanje sudije.
	 */
	private String email;
	
	/**
	 * Sifra sudije. Zapisana u String formatu. Sluzi za logovanje sudije.
	 */
	private String sifra;

	public Sudija(String ime, String prezime, String email, String sifra) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.sifra = sifra;
	}

	public Sudija() {
		super();
	}

	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime sudije. Ime ne sme biti NULL ili 0 karaktera.
	 * 
	 * @param ime
	 * @throws IllegalArgumentException kada je ime 0 karaktera ili NULL.
	 */
	public void setIme(String ime) throws IllegalArgumentException {
		if (ime == null || ime.length() == 0) {
			throw new IllegalArgumentException("ime ne moze biti NULL ili 0 karaktera");
		}
		
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime sudije. Prezime ne sme biti NULL ili 0 karaktera.
	 * 
	 * @param prezime
	 * @throws IllegalArgumentException kada je prezime 0 karaktera ili NULL.
	 */
	public void setPrezime(String prezime) throws IllegalArgumentException {
		if (prezime == null || prezime.length() == 0) {
			throw new IllegalArgumentException("Prezime ne moze biti NULL ili 0 karaktera");
		}
		
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * Postavlja mejl sudije.
	 * 
	 * @param email
	 * @throws IllegalArgumentException kada mejl nije adekvatnog formata.
	 */
	public void setEmail(String email) throws IllegalArgumentException {
		if (!email.contains("@")) {
			throw new IllegalArgumentException("Nije validan format mejla!");
		}
		
		this.email = email;
	}

	public String getSifra() {
		return sifra;
	}

	/**
	 * Postavlja sifru sudije. Sifra mora biti najmanje 5 karaktera.
	 * 
	 * @param sifra
	 * @throws IllegalArgumentException kada je sifra manja od 5 karaktera.
	 */
	public void setSifra(String sifra) throws IllegalArgumentException {
		if (sifra.length() < 5) {
			throw new IllegalArgumentException("Prekratka sifra! Sifra mora biti najmanje 5 karaktera");
		}
		
		this.sifra = sifra;
	}

	/**
	 * Generise hashCode sudije koristeci id.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Poredi 2 instance sudije po id.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sudija other = (Sudija) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sudija [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	
}
