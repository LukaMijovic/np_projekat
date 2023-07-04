package rs.np.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import rs.np.projekat.domen.Drzava;

/**
 * Model za ComboBox koji sluzi za popunjavanje ComboBoxa sa instancama drzava.
 * 
 * @author mijov
 */
public class DrzavaModelComboBox extends DefaultComboBoxModel<String>{

	/**
	 * Lista dostupnih drzava
	 */
	private List<Drzava> drzave;
	
	/**
	 * Trenutno izabrana drzava u ComboBoxu.
	 */
	private Drzava izabrana;
	
	public DrzavaModelComboBox() {
		drzave = new ArrayList<>();
	}

	public List<Drzava> getDrzave() {
		return drzave;
	}

	public void setDrzave(List<Drzava> drzave) {
		this.drzave = drzave;
	}
	
	@Override
	public void setSelectedItem(Object anObject) {
		for (Drzava d : drzave) {
			if (anObject.equals(d.getNaziv())) {
				System.out.println("Nasao: " + d.getNaziv());
				izabrana = d;
			}
		}
	}
	
	@Override
	public Object getSelectedItem() {
		return izabrana;
	}
	
	@Override
	public int getSize() {
		return drzave.size();
	}
}
