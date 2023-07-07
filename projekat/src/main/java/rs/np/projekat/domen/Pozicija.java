package rs.np.projekat.domen;

/**
 * Klasa Pozocija predstavlja poziciju igraca tokom utakmice.
 * 
 * Atributi:
 * 	<ul>
 * 		<li>id: Integer</li>
 * 		<li>naziv: String</li>
 * 	</ul>
 * 
 * @author mijov
 */
public class Pozicija {
	
	/**
	 * Id pozicije.
	 */
	private int id;
	
	/**
	 * Naziv pozicije.
	 */
	private String naziv;

	public Pozicija() {
		super();
	}

	public Pozicija(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	/**
	 * Vraca id pozicije
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id pozicije.
	 * 
	 * @param id pozicije
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Vraca naziv pozicije
	 * 
	 * @return naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja naziv pozicije.
	 * 
	 * @param naziv pozicije
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * Vraca string atrubita (naziv).
	 */
	@Override
	public String toString() {
		return naziv;
	}

	
}
