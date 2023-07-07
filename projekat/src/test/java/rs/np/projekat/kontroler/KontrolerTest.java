/**
 * 
 */
package rs.np.projekat.kontroler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.projekat.db.FudbalerDT;
import rs.np.projekat.domen.Fudbaler;
import rs.np.projekat.domen.Sudija;
import rs.np.projekat.domen.Utakmica;

/**
 * 
 */
class KontrolerTest {

	private Kontroler k;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		k = Kontroler.getKontroler();
		k.getDb().uspostaviKonekciju();
		k.getDb().getConn().setAutoCommit(false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		k.getDb().zatvoriKonekciju();
		k = null;
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#prijavi(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testPrijavi() {
		String email = "test@test.com";
		String sifra = "test123";
		
		Sudija s = new Sudija();
		s.setIme("Test");
		s.setPrezime("Testic");
		s.setEmail(email);
		s.setSifra(sifra);
		
		k.registracija(s);
		
		assertEquals(s.getIme(), k.prijavi(email, sifra).getIme());
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#registracija(rs.np.projekat.domen.Sudija)}.
	 */
	@Test
	void testRegistracija() {
		Sudija s = new Sudija();
		s.setEmail("test@test.com");
		s.setSifra("test123");
		s.setIme("Test");
		s.setPrezime("Testic");
		
		assertEquals(true, k.registracija(s));
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#vratiTimove(int, int)}.
	 */
	@Test
	void testVratiTimove() {
		int idH = 1;
		int idA = 2;
		
		assertEquals(2, k.vratiTimove(idH, idA).length);
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#vratiRezultate(java.util.HashMap)}.
	 */
	@Test
	void testVratiRezultate() {
		int id = 1;
		k.setUlogovaniSudija(id);
		
		assertTrue(k.vratiRezultate(null).size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#vratiDrzave()}.
	 */
	@Test
	void testVratiDrzave() {
		assertTrue(k.vratiDrzave().size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#vratiPozicije()}.
	 */
	@Test
	void testVratiPozicije() {
		assertTrue(k.vratiPozicije().size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#vratiKlubove()}.
	 */
	@Test
	void testVratiKlubove() {
		assertTrue(k.vratiKlubove().size() > 0);
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#unesiFudbalera(rs.np.projekat.domen.Fudbaler)}.
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
		
		assertEquals(true, k.unesiFudbalera(f));
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#setUlogovaniSudija(int)}.
	 */
	@Test
	void testSetUlogovaniSudija() {
		k.setUlogovaniSudija(1);
		
		assertEquals(1, k.getUlogovaniSudija());
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#unesiUtakmicu(rs.np.projekat.domen.Utakmica)}.
	 */
	@Test
	void testUnesiUtakmicu() {
		Utakmica u = new Utakmica();
		u.setIdH(1);
		u.setIdA(2);
		u.setSudija(1);
		u.setGolA(1);
		u.setGolH(1);
		
		assertEquals(true, k.unesiUtakmicu(u));
	}

	/**
	 * Test method for {@link rs.np.projekat.kontroler.Kontroler#vratiFudbalera(java.lang.String, java.lang.String)}.
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
		
		k.unesiFudbalera(f);
		
		FudbalerDT f2 = k.vratiFudbalera(f.getIme(), f.getPrezime());
		
		assertEquals(f.getBrojNaDresu(), f2.getBrojNaDresu());
	}

}
