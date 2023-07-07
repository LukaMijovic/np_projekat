/**
 * 
 */
package rs.np.projekat.db;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rs.np.projekat.domen.Drzava;
import rs.np.projekat.domen.Fudbaler;
import rs.np.projekat.domen.Klub;
import rs.np.projekat.domen.Pozicija;
import rs.np.projekat.domen.Sudija;
import rs.np.projekat.domen.Utakmica;

/**
 * 
 */
class DBBrokerTest {

	private DBBroker db;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		db = DBBroker.getDBBroker();
		db.uspostaviKonekciju();
		db.getConn().setAutoCommit(false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		db.zatvoriKonekciju();
		db = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#prijavi(rs.np.projekat.domen.Sudija)}.
	 */
	@Test
	void testPrijavi() {
		Sudija s = new Sudija();
		s.setEmail("test@test.com");
		s.setSifra("test123");
		s.setIme("Test");
		s.setPrezime("Testic");
		s.setId(0);
		
		db.registracija(s);
		Sudija s2 = db.prijavi(s);
		
		assertEquals(s.getEmail(), s2.getEmail());
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#registracija(rs.np.projekat.domen.Sudija)}.
	 */
	@Test
	void testRegistracija() {
		Sudija s = new Sudija("Test", "Testic", "test@test.com", "test123");
		
		assertEquals(true, db.registracija(s));
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#vratiTimove(int, int)}.
	 */
	@Test
	void testVratiTimove() {
		int idH = 1;
		int idA = 2;
		
		String[] timovi = db.vratiTimove(idH, idA);
	
		assertEquals(2, timovi.length);
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#vratiRezultate(java.util.HashMap, int)}.
	 */
	@Test
	void testVratiRezultate() {
		List<Utakmica> r = db.vratiRezultate(null, 1);
		
		assertTrue(r.size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#vratiDrzave()}.
	 */
	@Test
	void testVratiDrzave() {
		List<Drzava> d = db.vratiDrzave();
		
		assertTrue(d.size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#vratiPozicije()}.
	 */
	@Test
	void testVratiPozicije() {
		List<Pozicija> p = db.vratiPozicije();
		
		assertTrue(p.size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#vratiKlubove()}.
	 */
	@Test
	void testVratiKlubove() {
		List<Klub> k = db.vratiKlubove();
		
		assertTrue(k.size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#unesiFudbalera(rs.np.projekat.domen.Fudbaler)}.
	 */
	@Test
	void testUnesiFudbalera() {
		Fudbaler f = new Fudbaler();
		f.setBrojNaDresu(10);
		f.setDrzava(1);
		f.setIme("Test");
		f.setKlub(1);
		f.setPozicija(2);
		f.setPrezime("Testic");
		
		assertEquals(true, db.unesiFudbalera(f));
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#unesiUtakmicu(rs.np.projekat.domen.Utakmica)}.
	 */
	@Test
	void testUnesiUtakmicu() {
		Utakmica u = new Utakmica();
		u.setIdH(1);
		u.setIdA(2);
		u.setSudija(1);
		u.setGolA(1);
		u.setGolH(1);
		
		assertEquals(true, db.unesiUtakmicu(u));
	}

	/**
	 * Test method for {@link rs.np.projekat.db.DBBroker#vratiFudbalera(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testVratiFudbalera() {
		Fudbaler f = new Fudbaler();
		f.setBrojNaDresu(10);
		f.setDrzava(1);
		f.setIme("Test");
		f.setKlub(1);
		f.setPozicija(2);
		f.setPrezime("Testic");
		
		db.unesiFudbalera(f);
		
		FudbalerDT f2 = db.vratiFudbalera(f.getIme(), f.getPrezime());
		
		assertEquals(f.getBrojNaDresu(), f2.getBrojNaDresu());
	}

}
