package rs.np.projekat.domen;

/**
 * Klasa Drzava predstvalja apstrakciju drzave iz koje je igrac, klub ili trener.
 * 
 *  Atributi:
 * 	<ul>
 * 		<li>id: Integer</li>
 * 		<li>naziv: String</li>
 * 	</ul>
 * 
 * @author mijov
 */
public class Drzava {

	/**
	 * Id drzave.
	 */
	private int id;
	
	/**
	 * Naziv drzave.
	 */
	private String naziv;

	public Drzava(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public Drzava() {
		super();
	}

	public int getId() {
		return id;
	}

	/**
	 * Postavlja id drzave.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja naziv drzave.
	 * 
	 * @param naziv
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
