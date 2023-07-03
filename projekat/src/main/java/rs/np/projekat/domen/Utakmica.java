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
	
}
