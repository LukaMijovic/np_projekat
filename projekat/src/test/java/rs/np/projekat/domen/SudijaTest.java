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
class SudijaTest {

	private Sudija s;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		s = new Sudija();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#hashCode()}.
	 */
	@Test
	void testHashCode() {
		s.setId(1);
		
		assertEquals(31 * 1 + 1, s.hashCode());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#Sudija(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testSudijaStringStringStringString() {
		Sudija s2 = new Sudija("TEST", "TEST", "TEST@test", "TESTTEST");
		s.setEmail("TEST@test");
		s.setIme("TEST");
		s.setPrezime("TEST");
		s.setSifra("TESTTEST");
		
		assertEquals(s.getEmail(), s2.getEmail());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#setIme(java.lang.String)}.
	 */
	@Test
	void testSetIme() {
		s.setIme("TEST");
		
		assertEquals("TEST", s.getIme());
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
	void testSetImeLosArgument(String ime) {
		assertThrows(IllegalArgumentException.class, () -> {
			s.setIme(ime);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#setPrezime(java.lang.String)}.
	 */
	@Test
	void testSetPrezime() {
		s.setPrezime("TEST");
		
		assertEquals("TEST", s.getPrezime());
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
	void testSetPrezimeLosArgument(String prezime) {
		assertThrows(IllegalArgumentException.class, () -> {
			s.setPrezime(prezime);
		});
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#setEmail(java.lang.String)}.
	 */
	@Test
	void testSetEmail() {
		s.setEmail("TEST@test");
		
		assertEquals("TEST@test", s.getEmail());;
	}

	@ParameterizedTest
	@CsvSource(
		value = {
			"test.com",
		}
	)
	void testSetEmailLosArgument(String email) {
		assertThrows(IllegalArgumentException.class, () -> {
			s.setEmail(email);
		});
	}
	
	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#setSifra(java.lang.String)}.
	 */
	@Test
	void testSetSifra() {
		s.setSifra("TESTTEST");
		
		assertEquals("TESTTEST", s.getSifra());
	}
	
	@ParameterizedTest
	@CsvSource(
		value = {
			"TEST",
			"''"
		}
	)
	void testSetSifraLosArgument(String sifra) {
		assertThrows(IllegalArgumentException.class, () -> {
			s.setSifra(sifra);
		});
	}
	

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#equals(java.lang.Object)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"1, 1, true",
		"0, 1, false"
	})
	void testEqualsObject(int id1, int id2, boolean expVal) {
		s.setId(id1);
		Sudija s2 = new Sudija();
		s2.setId(id2);
		
		assertEquals(expVal, s.equals(s2));
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals("Sudija [id=" + s.getId() + ", ime=" + s.getIme() + ", prezime=" + s.getPrezime() + "]", s.toString());
	}

	/**
	 * Test method for {@link rs.np.projekat.domen.Sudija#setId(int)}.
	 */
	@Test
	void testSetId() {
		s.setId(1);
		
		assertEquals(1, s.getId());
	}

}
