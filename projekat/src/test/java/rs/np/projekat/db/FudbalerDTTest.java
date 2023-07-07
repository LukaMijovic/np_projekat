/**
 * 
 */
package rs.np.projekat.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class FudbalerDTTest {

	private FudbalerDT f;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		f = new FudbalerDT(null, null, 0, null, null, null);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		f = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.db.FudbalerDT#FudbalerDT(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFudbalerDT() {
		FudbalerDT f2 = new FudbalerDT("Test", "Testic", 10, "ST", "Srbija", "FK Partizan");
		
		assertTrue(f2.getClass() == FudbalerDT.class && f2 != null);
	}

}
