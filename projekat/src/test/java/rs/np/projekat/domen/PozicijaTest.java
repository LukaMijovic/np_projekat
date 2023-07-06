/**
 * 
 */
package rs.np.projekat.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.projekat.domen.Pozicija;

/**
 * 
 */
class PozicijaTest {

	private Pozicija p;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		p = new Pozicija();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		p = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Pozicija#Pozicija(int, java.lang.String)}.
	 */
	@Test
	void testPozicijaIntString() {
		Pozicija p2 = new Pozicija(4, "TEST");
		p.setId(4);
		p.setNaziv("TEST");
		
		assertEquals(p.getNaziv(), p2.getNaziv());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Pozicija#setId(int)}.
	 */
	@Test
	void testSetId() {
		p.setId(1);
		
		assertEquals(1, p.getId());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Pozicija#setNaziv(java.lang.String)}.
	 */
	@Test
	void testSetNaziv() {
		p.setNaziv("TEST");
		
		assertEquals("TEST", p.getNaziv());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Pozicija#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(p.getNaziv(), p.toString());
	}

}
