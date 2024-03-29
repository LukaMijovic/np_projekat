package rs.np.projekat.domen;

/**
 * Klasa Stadion predstavlja stadion nekog kluba (ili vise klubova).
 * 
 *  Atributi:
 * 	<ul>
 * 		<li>id: Integer</li>
 * 		<li>naziv: String</li>
 * 		<li>kapacitet: Integer</li>
 * 	</ul>
 * 
 * @author mijov
 */
public class Stadion {

	/**
	 * Id stadiona, predstavalja PK.
	 */
	private int id;
	
	/**
	 * Naziv stadiona.
	 */
	private String naziv;
	
	/**
	 * Kapacitet stadiona.
	 */
	private int kapacitet;

	public Stadion(int id, String naziv, int kapacitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kapacitet = kapacitet;
	}

	public Stadion() {
		super();
	}

	/**
	 * Vraca id stadiona
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id stadiona.
	 * 
	 * @param id stadiona kao int
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Vraca naziv stadiona
	 * 
	 * @return naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja naziv stadiona.
	 * 
	 * @param naziv stadiona kao String
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * Vraca kapacitet stadiona kao int
	 * 
	 * @return kapacitet
	 */
	public int getKapacitet() {
		return kapacitet;
	}

	/**
	 * Postavlja kapacitet stadiona.
	 * 
	 * @param kapacitet stadiona koji se postavlja
	 * @throws IllegalArgumentException kada je kapacitet manji od 0.
	 */
	public void setKapacitet(int kapacitet) throws IllegalArgumentException {
		if (kapacitet < 0) {
			throw new IllegalArgumentException("Kapacitet ne moze biti negativan!");
		}
		
		this.kapacitet = kapacitet;
	}
	
	
}
