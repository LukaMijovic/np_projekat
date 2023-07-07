package rs.np.projekat.model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.np.projekat.domen.Utakmica;
import rs.np.projekat.kontroler.Kontroler;

/**
 * Model tabele za utakmice.
 * Nasledjuje AbstractTableModel. 
 *
 *
 * @author mijov
 */
public class UtakmicaModelTable extends AbstractTableModel {

	/**
	 * Lista utakmica
	 */
	private List<Utakmica> rezultati;
	
	/**
	 * Niz naziva kolona tabele
	 */
	private String[] kolone = {"Domacin", "Gost", "Golovi domacina", "Golovi gosta"};
	
	/**
	 * Niz klasa kojima pripadaju kolone
	 */
	private Class[] klase = {String.class, String.class, Integer.class, Integer.class};
	
	/**
	 * Veza izmedju GUI-ja i baze
	 */
	private Kontroler kontroler;
	
	public UtakmicaModelTable() {
		this.rezultati = new ArrayList<>();
		this.kontroler = Kontroler.getKontroler();
	}
	
	/**
	 * Vraca broj redova
	 * 
	 * @return broj redova tabele
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rezultati.size();
	}

	/**
	 * Vraca broj kolona
	 * 
	 * @return broj kolona tabele
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	/**
	 * Vraca vrednost koja se nalazi u zadatoj koloni i redu.
	 * 
	 * @param rowIndex indeks reda koji se trazi
	 * @param columnIndex indeks kolone koja se trazi
	 * 
	 * @return zadrzaj zadate celije
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (rezultati == null) {
			return "/";
		}
		
		Utakmica pomocna = rezultati.get(rowIndex);
		
		String[] timovi = kontroler.vratiTimove(pomocna.getIdH(), pomocna.getIdA());
		
		switch (columnIndex) {
			case 0:
				return timovi[0];
			case 1:
				return timovi[1];
			case 2:
				return pomocna.getGolH();
			case 3:
				return pomocna.getGolA();
			default:
				return "/";
		}
	}

	/**
	 * Vraca listu utakmica
	 * 
	 * @return rezultati
	 */
	public List<Utakmica> getRezultati() {
		return rezultati;
	}

	/**
	 * Postavlja listu utakmica
	 * 
	 * @param rezultati koji se postavljaju
	 */
	public void setRezultati(List<Utakmica> rezultati) {
		this.rezultati = rezultati;
	}

	/**
	 * Vraca niz kolona
	 * 
	 * @return kolone
	 */
	public String[] getKolone() {
		return kolone;
	}
	
	/**
	 * Vraca niz klasa kolona
	 * 
	 * @return klase
	 */
	public Class[] getKlase() {
		return klase;
	}

	/**
	 * Vraca ime kolone
	 * 
	 * @param column indeks kolone
	 * 
	 * @return naziv kolone
	 */
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}
	
	/**
	 * Vraca naziv klase zadate kolone
	 * 
	 * @param columnIndex indeks kolone koja se trazi
	 * 
	 * @return klasa kolone
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return klase[columnIndex];
	}
}
