package rs.np.projekat.gui;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.np.projekat.db.FudbalerDT;
import rs.np.projekat.domen.Fudbaler;
import rs.np.projekat.domen.Utakmica;
import rs.np.projekat.kontroler.Kontroler;
import rs.np.projekat.model.UtakmicaModelTable;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
	
	/**
	 * Model tabele u koju ubacujemo rezultate utakmice.
	 */
	private UtakmicaModelTable model;
	private JTable table;
	private JButton btnNoviFudbaler;
	private JButton btnUnosRezultata;
	private MainGui self = this;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JButton btnPretrazi;
	
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
		setBounds(100, 100, 575, 525);
		setBounds(100, 100, 574, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTable());
		contentPane.add(getBtnNoviFudbaler());
		contentPane.add(getBtnUnosRezultata());
		contentPane.add(getTextFieldIme());
		contentPane.add(getTextFieldPrezime());
		contentPane.add(getBtnPretrazi());
		initTableUtakmice(null);
	}
	
	/**
	 * Ubacuje u tabelu sve utakmice koje zadovoljavaju dati kriterijum.
	 * 
	 * @param kriterijum
	 */
	public void initTableUtakmice(HashMap<String, String> kriterijum) {
		
		model = new UtakmicaModelTable();
		System.out.println(model.getRowCount() + " je trenutni broj redova");
		
		List<Utakmica> rezultati = kontroler.getKontroler().vratiRezultate(kriterijum);
		
		model.setRezultati(rezultati);
		System.out.println(model.getRowCount() + " je trenutni broj redova");
		table.setModel(model);
	}
	
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(10, 10, 540, 145);
		}
		return table;
	}
	private JButton getBtnNoviFudbaler() {
		if (btnNoviFudbaler == null) {
			btnNoviFudbaler = new JButton("Novi fudbaler");
			btnNoviFudbaler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FudbalerForma gui = new FudbalerForma();
					gui.setVisible(true);
				}
			});
			btnNoviFudbaler.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNoviFudbaler.setBounds(10, 339, 138, 21);
		}
		return btnNoviFudbaler;
	}
	private JButton getBtnUnosRezultata() {
		if (btnUnosRezultata == null) {
			btnUnosRezultata = new JButton("Unos rezultata");
			btnUnosRezultata.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UtakmicaForm gui = new UtakmicaForm(self);
					gui.setVisible(true);
					
				}
			});
			btnUnosRezultata.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnUnosRezultata.setBounds(180, 339, 138, 21);
		}
		return btnUnosRezultata;
	}
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldIme.setBounds(353, 246, 152, 25);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	private JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldPrezime.setColumns(10);
			textFieldPrezime.setBounds(353, 281, 152, 25);
		}
		return textFieldPrezime;
	}
	private JButton getBtnPretrazi() {
		if (btnPretrazi == null) {
			btnPretrazi = new JButton("Pretrazi");
			btnPretrazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String ime = textFieldIme.getText();
					String prezime = textFieldPrezime.getText();
					
					FudbalerDT f = kontroler.getKontroler().vratiFudbalera(ime, prezime);
					
					FudbalerPrikaz gui = new FudbalerPrikaz(f);
					gui.setVisible(true);
					
				}
			});
			btnPretrazi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnPretrazi.setBounds(386, 316, 119, 21);
		}
		return btnPretrazi;
	}
}
