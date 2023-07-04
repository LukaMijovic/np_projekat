package rs.np.projekat.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.np.projekat.domen.Sudija;
import rs.np.projekat.kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI stranica za prijavu.
 * 
 * @author mijov
 */
public class PrijavaGui extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JTextField textFieldEmail;
	private JLabel lblSifra;
	private JTextField textFieldSifra;
	private JButton btnNewButtonPrijava;
	
	/**
	 * Kontroler koji spaja gui sa bazom podataka.
	 */
	private Kontroler kontroler;
	private JButton btnRegistarcija;
	private PrijavaGui self = this;

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
	public PrijavaGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLayeredPane_1());
		contentPane.add(getTextFieldEmail());
		contentPane.add(getLblSifra());
		contentPane.add(getTextFieldSifra());
		contentPane.add(getBtnNewButtonPrijava());
		contentPane.add(getBtnRegistarcija());
	}
	private JLayeredPane getLayeredPane_1() {
		if (layeredPane == null) {
			layeredPane = new JLayeredPane();
			layeredPane.setBounds(304, 16, 1, 1);
		}
		return layeredPane;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Email:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(24, 10, 62, 30);
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldEmail.setBounds(96, 20, 193, 19);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra:");
			lblSifra.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSifra.setBounds(24, 78, 62, 30);
		}
		return lblSifra;
	}
	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldSifra.setColumns(10);
			textFieldSifra.setBounds(96, 88, 193, 19);
		}
		return textFieldSifra;
	}
	private JButton getBtnNewButtonPrijava() {
		if (btnNewButtonPrijava == null) {
			btnNewButtonPrijava = new JButton("Prijava");
			btnNewButtonPrijava.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String email = textFieldEmail.getText();
					String sifra = textFieldSifra.getText();
					
					kontroler = Kontroler.getKontroler();
					Sudija sudija = kontroler.prijavi(email, sifra);
					
					if (sudija != null) {
						JOptionPane.showMessageDialog(rootPane, "Uspesna prijava " + sudija.getIme());
						setVisible(false);
						
						MainGui mainGui = new MainGui();
						mainGui.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(rootPane, "Neuspesna prijava");
					}
					
				}
			});
			btnNewButtonPrijava.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButtonPrijava.setBounds(24, 143, 125, 21);
		}
		return btnNewButtonPrijava;
	}
	private JButton getBtnRegistarcija() {
		if (btnRegistarcija == null) {
			btnRegistarcija = new JButton("Registarcija");
			btnRegistarcija.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					RegistracijaGui gui = new RegistracijaGui(self);
					gui.setVisible(true);
					
				}
			});
			btnRegistarcija.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnRegistarcija.setBounds(24, 203, 174, 21);
		}
		return btnRegistarcija;
	}
	
	/**
	 * Vraca trenutnu instancu kontrolera.
	 * 
	 * @return kontroler : Kontroler.
	 */
	public Kontroler getKontroler() {
		return kontroler;
	}
	
	/**
	 * Postavlja kontroler.
	 * 
	 * @param kontroler
	 */
	public void setKontroler(Kontroler kontroler) {
		this.kontroler = kontroler;
	}
}
