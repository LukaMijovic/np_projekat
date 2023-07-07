package rs.np.projekat.domen;

/**
 * Klasa Klub predstavlja jedan klub koji moze da odigra utakmicu i ima svoje igrace.
 * 
 *  Atributi:
 * 	<ul>
 * 		<li>id: Integer</li>
 * 		<li>naziv: String</li>
 * 		<li>brojW: Integer</li>
 * 		<li>brojL: Integer</li>
 * 		<li>brojD: Integer</li>
 * 		<li>stadion: Integer</li>
 * 		<li>drzava: Integer</li>
 * 		<li>trener: Integer</li>
 * 	</ul>
 * 
 * @author mijov
 */
public class Klub {

	/**
	 * Id kluba kao int.
	 */
	private int id;
	
	/**
	 * Naziv kluba kao string.
	 */
	private String naziv;
	
	/**
	 * Broj pobeda kluba.
	 */
	private int brojW;
	
	/**
	 * Broj poraza kluba.
	 */
	private int brojL;
	
	/**
	 * Broj neresenih rezultata kluba.
	 */
	private int brojD;
	
	/**
	 * Id stadiona na kom klub igra.
	 */
	private int stadion;
	
	/**
	 * Id trenera kluba.
	 */
	private int trener;
	
	/**
	 * Drzava iz koje je klub.
	 */
	private int drzava;

	public Klub(int id, String naziv, int brojW, int brojL, int brojD, int stadion, int trener, int drzava) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.brojW = brojW;
		this.brojL = brojL;
		this.brojD = brojD;
		this.stadion = stadion;
		this.trener = trener;
		this.drzava = drzava;
	}

	public Klub() {
		super();
	}

	/**
	 * Vraca id kluba
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id kluba.
	 * 
	 * @param id kluba
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Vraca naziv kluba
	 * 
	 * @return naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja naziv kluba.
	 * 
	 * @param naziv kluba koji se postavlja
	 * @throws IllegalArgumentException kada je naziv kluba null ili prazan string.
	 */
	public void setNaziv(String naziv) throws IllegalArgumentException {
		if (naziv == null || naziv.length() == 0) {
			throw new IllegalArgumentException("Naziv kluba ne moze biti null ili prazan string");
		}
		
		this.naziv = naziv;
	}

	public int getBrojW() {
		return brojW;
	}

	/**
	 * Postavlja broj pobeda.
	 * 
	 * @param brojW broj pobeda
	 * @throws IllegalArgumentException kada je broj pobeda negativan.
	 */
	public void setBrojW(int brojW) throws IllegalArgumentException {
		if (brojW < 0) {
			throw new IllegalArgumentException("Broj pobeda ne moze biti negativan broj.");
		}
		
		this.brojW = brojW;
	}

	/**
	 * Vraca broj poraza kluba
	 * 
	 * @return brojL
	 */
	public int getBrojL() {
		return brojL;
	}

	/**
	 * Postavlja broj poraza.
	 * 
	 * @param brojL broj poraza kluba
	 * @throws IllegalArgumentException kada je broj poraza negativan.
	 */
	public void setBrojL(int brojL) throws IllegalArgumentException {
		if (brojL < 0) {
			throw new IllegalArgumentException("Broj poraza ne moze biti negativan broj.");
		}
		
		this.brojL = brojL;
	}

	public int getBrojD() {
		return brojD;
	}

	/**
	 * Postavlja broj neresenih rezultata.
	 * 
	 * @param brojD broj neresnih rezultata kluba
	 * @throws IllegalArgumentException kada je broj neresenih rezultata negativan.
	 */
	public void setBrojD(int brojD) throws IllegalArgumentException {
		if (brojD < 0) {
			throw new IllegalArgumentException("Broj neresenih rezulata ne moze biti negativan broj.");
		}
		
		this.brojD = brojD;
	}

	/**
	 * Vraca id stadiona na kom klub igra.
	 * 
	 * @return stadion
	 */
	public int getStadion() {
		return stadion;
	}

	/**
	 * Postavlja id stadiona na kom klub igra.
	 * 
	 * @param stadion id stadiona na kom klub igra.
	 * @throws IllegalArgumentException kad je id kluba negativan.
	 */
	public void setStadion(int stadion) throws IllegalArgumentException {
		if (stadion < 0) {
			throw new IllegalArgumentException("Id stadiona na kom klub igra ne moze biti negativan.");
		}
		
		this.stadion = stadion;
	}

	/**
	 * Vraca id trenera
	 * 
	 * @return trener
	 */
	public int getTrener() {
		return trener;
	}

	
	/**
	 * Postavlja id trenera koji trenira klub.
	 * 
	 * @param trener id trenera koji trenira klub
	 * @throws IllegalArgumentException kada je id trenera negativan.
	 */
	public void setTrener(int trener) throws IllegalArgumentException {
		if (trener < 0) {
			throw new IllegalArgumentException("Id trenera koji trenira klub ne moze biti negativan.");
		}
		
		this.trener = trener;
	}

	public int getDrzava() {
		return drzava;
	}

	/**
	 * Id drzave iz koje je klub.
	 * 
	 * @param drzava id drzave iz koje je klub.
	 * @throws IllegalArgumentException kada je id drzave negativan.
	 */
	public void setDrzava(int drzava) throws IllegalArgumentException {
		if (drzava < 0) {
			throw new IllegalArgumentException("Id drzave ne moze biti negativan.");
		}
		
		this.drzava = drzava;
	}

	/**
	 * Override metode hashCode klase Object koji kreira hashcode na osnovu id.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Poredi dve instance kluba na osnovu kluba.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Klub other = (Klub) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Override toString metode klase Object tako sto vraca string od atributa naziv.
	 */
	@Override
	public String toString() {
		return naziv;
	}
	
	
}
