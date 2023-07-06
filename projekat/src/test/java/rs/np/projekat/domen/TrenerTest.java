package rs.np.projekat.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TrenerTest {

	private Trener t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new Trener();
	}

	@AfterEach
	void tearDown() throws Exception {
		t = null;
	}

	@Test
	void testHashCode() {
		// result = 31 * 1 + id
		t.setId(1);
		
		assertEquals(31 * 1 + t.getId(), t.hashCode());
	}

	@Test
	void testTrenerIntStringStringIntInt() {
		Trener t2 = new Trener(1, "TEST", "TEST", 1, 1);
		t.setId(1);
		t.setDrzava(1);
		t.setKlub(1);
		t.setIme("TEST");
		t.setPrezime("TEST");
		
		assertEquals(t.getKlub(), t2.getKlub());
	}

	@Test
	void testToString() {
		assertEquals("Trener [id=" + t.getId() + ", ime=" + t.getIme() + ", prezime=" + t.getPrezime() + ", klub=" + t.getKlub() + "]", t.toString());
	}

	@ParameterizedTest
	@CsvSource({
		"1, 1, true",
		"1, 0, false"
	})
	void testEqualsObject(int id1, int id2, boolean expValue) {
		Trener t2 = new Trener();
		t2.setId(id2);
		t.setId(id1);
		
		assertEquals(expValue, t.equals(t2));
	}

	@Test
	void testSetId() {
		t.setId(1);
		
		assertEquals(1, t.getId());
	}

	@Test
	void testSetIme() {
		t.setIme("TEST");
		
		assertEquals("TEST", t.getIme());
	}

	@Test
	void testSetPrezime() {
		t.setPrezime("TEST");
		
		assertEquals("TEST", t.getPrezime());
	}

	@Test
	void testSetKlub() {
		t.setKlub(1);
		
		assertEquals(1, t.getKlub());
	}
	
	@Test
	void testSetKlubLosArgument() {
		assertThrows(IllegalArgumentException.class , () -> t.setKlub(-1));
	}

	@Test
	void testSetDrzava() {
		t.setDrzava(1);
		
		assertEquals(1, t.getDrzava());
	}
	
	@Test
	void testSetDrzavaLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> t.setDrzava(-1));
	}

}
