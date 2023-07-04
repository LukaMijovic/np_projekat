package rs.np.projekat.gui;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.np.projekat.domen.Utakmica;
import rs.np.projekat.kontroler.Kontroler;
import rs.np.projekat.model.UtakmicaModelTable;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * Main GUI stranica iz koje se pokrecu sve ostale sistemske operacije.
 * 
 * @author mijov
 */
public class MainGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Kontroler koji spaja gui sa bazom podataka.
	 */
	private Kontroler kontroler;
	private JTable table;
	
	/**
	 * Model tabele u koju ubacujemo rezultate utakmice.
	 */
	private UtakmicaModelTable model;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainGui frame = new MainGui();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTable());
		initTableUtakmice(null);
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setBounds(10, 286, 473, -275);
		}
		return table;
	}
	
	/**
	 * Ubacuje u tabelu sve utakmice koje zadovoljavaju dati kriterijum.
	 * 
	 * @param kriterijum
	 */
	private void initTableUtakmice(HashMap<String, String> kriterijum) {
		
		model = new UtakmicaModelTable();
		System.out.println(model.getRowCount() + " je trenutni broj redova");
		
		List<Utakmica> rezultati = kontroler.getKontroler().vratiRezultate(kriterijum);
		
		model.setRezultati(rezultati);
		System.out.println(model.getRowCount() + " je trenutni broj redova");
		
		table.setModel(model);
		table.setVisible(true);
	}
}
