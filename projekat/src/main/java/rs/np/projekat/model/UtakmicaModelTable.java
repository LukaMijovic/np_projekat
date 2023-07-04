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

	private List<Utakmica> rezultati;
	private String[] kolone = {"Domacin", "Gost", "Golovi domacina", "Golovi gosta"};
	private Class[] klase = {String.class, String.class, Integer.class, Integer.class};
	private Kontroler kontroler;
	
	public UtakmicaModelTable() {
		this.rezultati = new ArrayList<>();
		this.kontroler = Kontroler.getKontroler();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rezultati.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

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

	public List<Utakmica> getRezultati() {
		return rezultati;
	}

	public void setRezultati(List<Utakmica> rezultati) {
		this.rezultati = rezultati;
	}

	public String[] getKolone() {
		return kolone;
	}
	public Class[] getKlase() {
		return klase;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return klase[columnIndex];
	}
}
