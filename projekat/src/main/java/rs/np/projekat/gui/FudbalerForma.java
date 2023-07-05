package rs.np.projekat.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.np.projekat.domen.Drzava;
import rs.np.projekat.domen.Fudbaler;
import rs.np.projekat.domen.Klub;
import rs.np.projekat.domen.Pozicija;
import rs.np.projekat.kontroler.Kontroler;
import rs.np.projekat.model.DrzavaModelComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Graficka forma za unos novog fudbalera.
 * 
 * @author mijov
 */
public class FudbalerForma extends JFrame {

	private JPanel contentPane;

	/**
	 * Veza izmedju forme i DBBrokera.
	 */
	private Kontroler kontroler;
	
	/**
	 * Izabrana drzava.
	 */
	private Drzava drzava;
	
	private JLabel lblNewLabel;
	private JTextField textFieldIme;
	private JLabel lblPrezime;
	private JTextField textFieldPrezime;
	private JLabel lblBrojNaDresu;
	private JSpinner spinnerBrojNaDresu;
	private JComboBox<?> comboBoxDrzava;
	private JComboBox comboBoxPozicija;
	private JComboBox comboBoxKlub;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FudbalerForma frame = new FudbalerForma();
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
	public FudbalerForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextFieldIme());
		contentPane.add(getLblPrezime());
		contentPane.add(getTextFieldPrezime());
		contentPane.add(getLblBrojNaDresu());
		contentPane.add(getSpinnerBrojNaDresu());
		contentPane.add(getComboBoxDrzava());
		contentPane.add(getComboBoxPozicija());
		contentPane.add(getComboBoxKlub());
		contentPane.add(getBtnNewButton());
		
		initDrzavaComboBox();
		initPozicijaComboBox();
		initKlubComboBox();
	}
	
	private void initKlubComboBox() {
		// TODO Auto-generated method stub
		List<Klub> klubovi = kontroler.getKontroler().vratiKlubove();
		
		comboBoxKlub.setModel(new DefaultComboBoxModel(klubovi.toArray()));
		
	}

	private void initPozicijaComboBox() {
		// TODO Auto-generated method stub
		List<Pozicija> pozicije = kontroler.getKontroler().vratiPozicije();
		
		comboBoxPozicija.setModel(new DefaultComboBoxModel(pozicije.toArray()));
	}

	/**
	 * Inicijalizuje ComboBox sa drzavama.
	 */
	private void initDrzavaComboBox() {
		// TODO Auto-generated method stub
		DrzavaModelComboBox model = new DrzavaModelComboBox();
		
		List<Drzava> drzave = kontroler.getKontroler().vratiDrzave();
		model.setDrzave(drzave);
		comboBoxDrzava.setModel(new DefaultComboBoxModel(drzave.toArray()));
		
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ime");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(10, 33, 88, 18);
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldIme.setBounds(103, 32, 195, 19);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime");
			lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPrezime.setBounds(10, 91, 88, 20);
		}
		return lblPrezime;
	}
	private JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldPrezime.setColumns(10);
			textFieldPrezime.setBounds(103, 92, 195, 19);
		}
		return textFieldPrezime;
	}
	private JLabel getLblBrojNaDresu() {
		if (lblBrojNaDresu == null) {
			lblBrojNaDresu = new JLabel("Broj na dresu");
			lblBrojNaDresu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblBrojNaDresu.setBounds(10, 154, 158, 26);
		}
		return lblBrojNaDresu;
	}
	private JSpinner getSpinnerBrojNaDresu() {
		if (spinnerBrojNaDresu == null) {
			spinnerBrojNaDresu = new JSpinner();
			spinnerBrojNaDresu.setFont(new Font("Tahoma", Font.PLAIN, 18));
			spinnerBrojNaDresu.setBounds(156, 143, 56, 37);
		}
		return spinnerBrojNaDresu;
	}
	private JComboBox getComboBoxDrzava() {
		if (comboBoxDrzava == null) {
			comboBoxDrzava = new JComboBox();
			comboBoxDrzava.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxDrzava.setBounds(10, 226, 158, 21);
		}
		return comboBoxDrzava;
	}
	private JComboBox getComboBoxPozicija() {
		if (comboBoxPozicija == null) {
			comboBoxPozicija = new JComboBox();
			comboBoxPozicija.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxPozicija.setBounds(10, 286, 158, 21);
		}
		return comboBoxPozicija;
	}
	private JComboBox getComboBoxKlub() {
		if (comboBoxKlub == null) {
			comboBoxKlub = new JComboBox();
			comboBoxKlub.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxKlub.setBounds(10, 344, 158, 21);
		}
		return comboBoxKlub;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Potvrdi");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ime = textFieldIme.getText();
					String prezime = textFieldPrezime.getText();
					int brojNaDresu = (int) spinnerBrojNaDresu.getValue();
					int pozicija = comboBoxPozicija.getSelectedIndex();
					int drzava = comboBoxDrzava.getSelectedIndex();
					int klub = comboBoxKlub.getSelectedIndex();
					
					Fudbaler fudbaler = new Fudbaler();
					fudbaler.setBrojNaDresu(brojNaDresu);
					fudbaler.setDrzava(drzava + 1);
					fudbaler.setIme(ime);
					fudbaler.setKlub(klub + 1);
					fudbaler.setPozicija(pozicija + 1);
					fudbaler.setPrezime(prezime);
					
					boolean flag = kontroler.getKontroler().unesiFudbalera(fudbaler);
					
					if (flag) {
						JOptionPane.showMessageDialog(rootPane, "Uspeno unet fudbaler!");
						setVisible(false);
						dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Nesto ste pogresili, fudbaler nije unet. Molimo probajte ponovo.");
					}
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton.setBounds(268, 416, 158, 21);
		}
		return btnNewButton;
	}
}
