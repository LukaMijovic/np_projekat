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
class StadionTest {

	private Stadion s;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		s = new Stadion();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Stadion#Stadion(int, java.lang.String, int)}.
	 */
	@Test
	void testStadionIntStringInt() {
		Stadion s2 = new Stadion(1, "TEST", 1);
		s.setId(1);
		s.setKapacitet(1);
		s.setNaziv("TEST");
		
		assertEquals(s.getNaziv(), s2.getNaziv());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Stadion#setId(int)}.
	 */
	@Test
	void testSetId() {
		s.setId(1);
		
		assertEquals(1, s.getId());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Stadion#setNaziv(java.lang.String)}.
	 */
	@Test
	void testSetNaziv() {
		s.setNaziv("TEST");
		
		assertEquals("TEST", s.getNaziv());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Stadion#setKapacitet(int)}.
	 */
	@Test
	void testSetKapacitet() {
		s.setKapacitet(1);
		
		assertEquals(1, s.getKapacitet());
	}
	
	@Test
	void testSetKapacitetLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			s.setKapacitet(-1);
		});
	}
	

}
