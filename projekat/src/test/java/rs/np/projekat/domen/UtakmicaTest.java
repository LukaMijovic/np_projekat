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
class UtakmicaTest {

	private Utakmica u;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		u = new Utakmica();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		u = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Utakmica#setIdH(int)}.
	 */
	@Test
	void testSetIdH() {
		u.setIdH(1);
		
		assertEquals(1, u.getIdH());
	}
	
	@Test
	void testSetIdHLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			u.setIdH(-1);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Utakmica#setIdA(int)}.
	 */
	@Test
	void testSetIdA() {
		u.setIdA(1);
		
		assertEquals(1, u.getIdA());
	}
	
	@Test
	void testSetIdALosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			u.setIdA(-1);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Utakmica#setGolH(int)}.
	 */
	@Test
	void testSetGolH() {
		u.setGolH(1);
		
		assertEquals(1, u.getGolH());
	}
	
	@Test
	void testGolHLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			u.setGolH(-1);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Utakmica#setGolA(int)}.
	 */
	@Test
	void testSetGolA() {
		u.setGolA(1);
		
		assertEquals(1, u.getGolA());
	}

	@Test
	void testGolALosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			u.setGolA(-1);
		});
	}
	
	/**
	 * Test method for {@link rs.np.projekat.domen.Utakmica#setSudija(int)}.
	 */
	@Test
	void testSetSudija() {
		u.setSudija(1);
		
		assertEquals(1, u.getSudija());
	}
	
	@Test
	void testSudijaLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			u.setSudija(-1);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Utakmica#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals("Utakmica [idH=" + u.getIdH() + ", idA=" + u.getIdA() + ", golH=" + u.getGolH() + ", golA=" + u.getGolA() + "]", u.toString());
	}

}
