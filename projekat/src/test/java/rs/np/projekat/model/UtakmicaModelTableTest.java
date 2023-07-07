/**
 * 
 */
package rs.np.projekat.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rs.np.projekat.domen.Utakmica;

/**
 * 
 */
class UtakmicaModelTableTest {
	
	private UtakmicaModelTable m;
	private List<Utakmica> r;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		m = new UtakmicaModelTable();
		r = new ArrayList<>();
	}
	
	void addUtakmica(int num) {
		for (int i = 0; i < num; i++) {
			r.add(new Utakmica());
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		m = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.model.UtakmicaModelTable#getRowCount()}.
	 */
	@ParameterizedTest
	@CsvSource({
		"0, 0, true",
		"1, 0, false",
		"2, 2, true",
		"2, 3, false"
	})
	void testGetRowCount(int num, int size, boolean expVal) {
		addUtakmica(num);
		m.setRezultati(r);
		
		assertEquals(expVal, m.getRowCount() == size);
	}

	/**
	 * Test method for {@link rs.np.projekat.model.UtakmicaModelTable#getColumnCount()}.
	 */
	@Test
	void testGetColumnCount() {
		assertEquals(4, m.getColumnCount());
	}

	/**
	 * Test method for {@link rs.np.projekat.model.UtakmicaModelTable#getValueAt(int, int)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"0, 2, 0",
		"1, 2, 1",
		"1, 3, 0"
	})
	void testGetValueAt(int row, int col, int expVal) {
		addUtakmica(2);
		m.setRezultati(r);
		
		m.getRezultati().get(1).setGolH(1);
		
		assertEquals(expVal, m.getValueAt(row, col));
	}

	/**
	 * Test method for {@link rs.np.projekat.model.UtakmicaModelTable#setRezultati(java.util.List)}.
	 */
	@Test
	void testSetRezultati() {
		addUtakmica(3);
		m.setRezultati(r);
		
		assertEquals(r, m.getRezultati());
	}
}
