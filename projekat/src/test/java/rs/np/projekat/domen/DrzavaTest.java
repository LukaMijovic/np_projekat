/**
 * 
 */
package rs.np.projekat.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class DrzavaTest {

	private Drzava d;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		d = new Drzava();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		d = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Drzava#Drzava(int, java.lang.String)}.
	 */
	@Test
	void testDrzavaIntString() {
		Drzava d2 = new Drzava(1, "TEST");
		d.setNaziv("TEST");
		d.setId(1);
		
		assertEquals(d.getNaziv(), d2.getNaziv());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Drzava#setId(int)}.
	 */
	@Test
	void testSetId() {
		d.setId(1);
		
		assertEquals(1, d.getId());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Drzava#setNaziv(java.lang.String)}.
	 */
	@Test
	void testSetNaziv() {
		d.setNaziv("TEST");
		
		assertEquals("TEST", d.getNaziv());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Drzava#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(d.getNaziv(), d.toString());
	}

}
