package rs.np.projekat.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.np.projekat.domen.Sudija;
import rs.np.projekat.kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI stranica za registraciju.
 * 
 * @author mijov
 */
public class RegistracijaGui extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textFieldIme;
	private JLabel lblPrezime;
	private JTextField textFieldPrezime;
	private JTextField textFieldEmail;
	private JTextField textFieldSifra;
	private JLabel lblEmail;
	private JLabel lblSifra;
	private JButton btnNewButton;
	

	/**
	 * Kontroler preko koga GUI komunicira sa DBBrokerom.
	 */
	private Kontroler kontroler;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistracijaGui frame = new RegistracijaGui();
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
	public RegistracijaGui(PrijavaGui gui) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextFieldIme());
		contentPane.add(getLblPrezime());
		contentPane.add(getTextFieldPrezime());
		contentPane.add(getTextFieldEmail());
		contentPane.add(getTextFieldSifra());
		contentPane.add(getLblEmail());
		contentPane.add(getLblSifra());
		contentPane.add(getBtnNewButton());
	}


	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ime:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(21, 29, 73, 25);
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldIme.setBounds(165, 31, 165, 25);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime:");
			lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPrezime.setBounds(21, 98, 101, 25);
		}
		return lblPrezime;
	}
	private JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldPrezime.setColumns(10);
			textFieldPrezime.setBounds(165, 105, 165, 25);
		}
		return textFieldPrezime;
	}
	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldEmail.setColumns(10);
			textFieldEmail.setBounds(165, 175, 165, 25);
		}
		return textFieldEmail;
	}
	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldSifra.setColumns(10);
			textFieldSifra.setBounds(165, 251, 165, 25);
		}
		return textFieldSifra;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblEmail.setBounds(21, 175, 101, 25);
		}
		return lblEmail;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra:");
			lblSifra.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSifra.setBounds(21, 249, 101, 25);
		}
		return lblSifra;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Registracija");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String ime = textFieldIme.getText();
					String prezime = textFieldPrezime.getText();
					String email = textFieldEmail.getText();
					String sifra = textFieldSifra.getText();
					
					Sudija sudija = new Sudija();
					sudija.setEmail(email);
					sudija.setIme(ime);
					sudija.setPrezime(prezime);
					sudija.setSifra(sifra);
				
					kontroler = Kontroler.getKontroler();
					boolean flag = kontroler.registracija(sudija);
					
					if (flag) {
						JOptionPane.showMessageDialog(rootPane, "Uspesna registracija. Molimo da se prijavite");
						setVisible(false);
						dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Nazalost registacija nije uspela. Molimo probajte ponovo.");
					}
					
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(350, 295, 135, 25);
		}
		return btnNewButton;
	}
}
