package rs.np.projekat.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FudbalerTest {
	
	private Fudbaler f;

	@BeforeEach
	void setUp() throws Exception {
		f = new Fudbaler();
	}

	@AfterEach
	void tearDown() throws Exception {
		f = null;
	}

	@Test
	void testHashCode() {
		f.setId(1);
		
		assertEquals(31 * 1 + 1, f.hashCode());
	}

	@Test
	void testSetId() {
		f.setId(1);
		
		assertEquals(1, f.getId());
	}

	@Test
	void testSetIme() {
		f.setIme("TEST");
		
		assertEquals("TEST", f.getIme());
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
			f.setIme(ime);
		});
	}

	@Test
	void testSetPrezime() {
		f.setPrezime("TEST");
		
		assertEquals("TEST", f.getPrezime());
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
			f.setIme(prezime);
		});
	}

	@Test
	void testSetBrojNaDresu() {
		f.setBrojNaDresu(1);
		
		assertEquals(1, f.getBrojNaDresu());
	}
	
	@ParameterizedTest
	@CsvSource({
		"0",
		"100"
	})
	void testSetBrojNaDresuLosArgument(int broj) {
		assertThrows(IllegalArgumentException.class, () -> {
			f.setBrojNaDresu(broj);
		});
	}

	@Test
	void testSetKlub() {
		f.setKlub(1);
		
		assertEquals(1, f.getKlub());
	}
	
	@Test
	void testSetKlubLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			f.setKlub(-1);
		});
	}

	@Test
	void testSetDrzava() {
		f.setDrzava(1);
		
		assertEquals(1, f.getDrzava());
	}
	
	@Test
	void testSetDrzavaLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			f.setDrzava(-1);
		});
	}

	@Test
	void testSetPozicija() {
		f.setPozicija(1);
		
		assertEquals(1, f.getPozicija());
	}
	
	@Test
	void testSetPozicijaLosArgument() {
		assertThrows(IllegalArgumentException.class, () -> {
			f.setPozicija(-1);
		});
	}

	@ParameterizedTest
	@CsvSource({
		"1, 1, true",
		"0, 1, false"
	})
	void testEqualsObject(int id1, int id2, boolean expVal) {
		f.setId(id1);
		Fudbaler f2 = new Fudbaler();
		f2.setId(id2);
		
		assertEquals(expVal, f.equals(f2));
	}

	@Test
	void testToString() {
		assertEquals("Fudbaler [ime=" + f.getIme() + ", prezime=" + f.getPrezime() + ", brojNaDresu=" + f.getBrojNaDresu() + ", klub=" + f.getKlub() + "]", f.toString());
	}

}
