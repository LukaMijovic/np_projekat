/**
 * 
 */
package rs.np.projekat.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 
 */
class KlubTest {

	private Klub k;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		k = new Klub();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#hashCode()}.
	 */
	@Test
	void testHashCode() {
		k.setId(1);
		
		assertEquals(31 * 1 + 1, k.hashCode());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#Klub(int, java.lang.String, int, int, int, int, int, int)}.
	 */
	@Test
	void testKlubIntStringIntIntIntIntIntInt() {
		Klub k2 = new Klub(1, "TEST", 1, 1, 1, 1, 1, 1);
		k.setBrojD(1);
		k.setBrojL(1);
		k.setBrojW(1);
		k.setDrzava(1);
		k.setId(1);
		k.setNaziv("TEST");
		k.setStadion(1);
		k.setTrener(1);
		
		assertEquals(k.getNaziv(), k2.getNaziv());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setId(int)}.
	 */
	@Test
	void testSetId() {
		k.setId(1);
		
		assertEquals(1, k.getId());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setNaziv(java.lang.String)}.
	 */
	@Test
	void testSetNaziv() {
		k.setNaziv("TEST");
		
		assertEquals("TEST", k.getNaziv());
	}

	@ParameterizedTest
	@CsvSource(
		value = {
			"null",
			"''"
		},
		nullValues = {
			"null"
		}
	)
	void testSetNazivLosArgument(String naziv) {
		assertThrows(IllegalArgumentException.class, () -> {
			k.setNaziv(naziv);
		});
	}
	
	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setBrojW(int)}.
	 */
	@Test
	void testSetBrojW() {
		k.setBrojW(1);
		
		assertEquals(1, k.getBrojW());
	}
	
	@Test
	void testSetBrojWLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			k.setBrojW(-1);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setBrojL(int)}.
	 */
	@Test
	void testSetBrojL() {
		k.setBrojL(1);
		
		assertEquals(1, k.getBrojL());
	}

	@Test
	void testSetBrojLLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			k.setBrojL(-1);
		});
	}
	
	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setBrojD(int)}.
	 */
	@Test
	void testSetBrojD() {
		k.setBrojD(1);
		
		assertEquals(1, k.getBrojD());
	}

	@Test
	void testSetBrojDLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			k.setBrojD(-1);
		});
	}
	
	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setStadion(int)}.
	 */
	@Test
	void testSetStadion() {
		k.setStadion(1);
		
		assertEquals(1, k.getStadion());
	}
	
	@Test
	void testSetStadionLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			k.setStadion(-1);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setTrener(int)}.
	 */
	@Test
	void testSetTrener() {
		k.setTrener(1);
		
		assertEquals(1, k.getTrener());
	}

	@Test
	void testSetTrenerLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			k.setTrener(-1);
		});
	}
	
	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#setDrzava(int)}.
	 */
	@Test
	void testSetDrzava() {
		k.setDrzava(1);
		
		assertEquals(1, k.getDrzava());
	}
	
	@Test
	void testSetDrzavaLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			k.setDrzava(-1);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#equals(java.lang.Object)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"1, 1, true",
		"0, 1, false"
	})
	void testEqualsObject(int id1, int id2, boolean expVal) {
		k.setId(id1);
		Klub k2 = new Klub();
		k2.setId(id2);
		
		assertEquals(expVal, k.equals(k2));
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Klub#toString()}.
	 */
	@Test
	void testToString() {
		k.setNaziv("TEST");
		
		assertEquals(k.getNaziv(), k.toString());
	}

}
