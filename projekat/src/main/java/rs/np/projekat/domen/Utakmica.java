package rs.np.projekat.domen;

/**
 * Klasa utakmica predstavlja apstrakciju jedne utakmice izmedju 2 kluba.
 * 
 * @author mijov
 */
public class Utakmica {

	/**
	 * Id kluba domacina.
	 */
	private int idH;
	
	/**
	 * Id kluba gosta.
	 */
	private int idA;
	
	/**
	 * Broj golova datih od strane domacina.
	 */
	private int golH;
	
	/**
	 * Broj golova datih od strane gosta.
	 */
	private int golA;
	
	/**
	 * Id stadiona na kom se igra utakmica.
	 */
	private int stadion;
	
	/**
	 * Id sudije koji je sudio utakmicu.
	 */
	private int sudija;

	public Utakmica() {
		super();
	}

	/**
	 * Vraca id kluba domacina.
	 * 
	 * @return idH : Integer.
	 */
	public int getIdH() {
		return idH;
	}

	/**
	 * Postavlja id kluba domacina.
	 * 
	 * @param idH
	 * @throws IllegalArgumentException kada je id kluba negativan.
	 */
	public void setIdH(int idH) throws IllegalArgumentException {
		if (idH < 0) {
			throw new IllegalArgumentException("Id kluba ne moze biti negativan.");
		}
		
		this.idH = idH;
	}

	/**
	 * Vraca id kluba gosta.
	 * 
	 * @return idA : Integer.
	 */
	public int getIdA() {
		return idA;
	}

	/**
	 * Postavlja id id kluba gosta.
	 * 
	 * @param idA
	 * @throws IllegalArgumentException kada je id kluba negativan.
	 */
	public void setIdA(int idA) throws IllegalArgumentException {
		if (idA < 0) {
			throw new IllegalArgumentException("Id kluba ne moze biti negativan.");
		}
		
		this.idA = idA;
	}

	/**
	 * Vraca broj goloba domacina.
	 * 
	 * @return golH : Integer.
	 */
	public int getGolH() {
		return golH;
	}

	/**
	 * Postavlja broj postignutih golova domacina.
	 * 
	 * @param golH
	 * @throws IllegalArgumentException kada je broj golova negativan.
	 */
	public void setGolH(int golH) throws IllegalArgumentException {
		if (golH < 0) {
			throw new IllegalArgumentException("Broj golova ne moze biti negativan.");
		}
		
		this.golH = golH;
	}

	/**
	 * Vraca broj goloba domacina.
	 * 
	 * @return golA : Integer.
	 */
	public int getGolA() {
		return golA;
	}

	/**
	 * Postavlja broj postignutih golova gosta.
	 * 
	 * @param golA
	 * @throws IllegalArgumentException kada je broj golova negativan.
	 */
	public void setGolA(int golA) throws IllegalArgumentException {
		if (golA < 0) {
			throw new IllegalArgumentException("Broj golova ne moze biti negativan.");
		}
		this.golA = golA;
	}

	/**
	 * Vraca id stadiona na kom se igra utakmica
	 * 
	 * @return
	 */
	public int getStadion() {
		return stadion;
	}

	/**
	 * Postavlja id stadiona na kom se igra utakmica.
	 * 
	 * @param stadion
	 */
	public void setStadion(int stadion) throws IllegalArgumentException {
		if (stadion < 0) {
			throw new IllegalArgumentException("Id stadiona ne moze biti negativan.");
		}
		
		this.stadion = stadion;
	}

	/**
	 * Vraca id sudije koji je sudio utakmicu.
	 * 
	 * @return sudija : Integer.
	 */
	public int getSudija() {
		return sudija;
	}

	/**
	 * Postavlja id sudije koji sudi utakmicu.
	 * 
	 * @param sudija
	 */
	public void setSudija(int sudija) throws IllegalArgumentException {
		if (sudija < 0) {
			throw new IllegalArgumentException("Id sudije ne moze biti negativan.");
		}
		
		this.sudija = sudija;
	}
	
}
