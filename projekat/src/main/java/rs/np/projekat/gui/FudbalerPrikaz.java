package rs.np.projekat.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.np.projekat.db.FudbalerDT;
import rs.np.projekat.kontroler.Kontroler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI koji sluzi za prikaz fudbalera.
 * 
 * @author mijov
 */
public class FudbalerPrikaz extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Fudbaler kog prikazuje GUI.
	 */
	private FudbalerDT fudbaler;
	
	/**
	 * Instanca kontrolera za komunikaciju sa DBBrokerom.
	 */
	private Kontroler kontroler;
	
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblBrojNaDresu;
	private JLabel lblPozicija;
	private JLabel lblDrzava;
	private JLabel lblKlub;
	private JButton btnSacuvajUJson;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FudbalerPrikaz dialog = new FudbalerPrikaz();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Konstruktor za GUI.
	 * 
	 * @param fudbaler koji se prikazuje na GUI
	 */
	public FudbalerPrikaz(FudbalerDT fudbaler) {
		setBounds(100, 100, 556, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		kontroler = Kontroler.getKontroler();
		this.fudbaler = fudbaler;
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblIme());
		contentPanel.add(getLblPrezime());
		contentPanel.add(getLblBrojNaDresu());
		contentPanel.add(getLblPozicija());
		contentPanel.add(getLblDrzava());
		contentPanel.add(getLblKlub());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(getBtnSacuvajUJson());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		initFudbaler();
	}
	
	/**
	 * Postavlja podatke fudbalera na labele.
	 */
	private void initFudbaler() {
		// TODO Auto-generated method stub
		
		lblIme.setText(fudbaler.getIme());
		lblPrezime.setText(fudbaler.getPrezime());
		lblBrojNaDresu.setText("" + fudbaler.getBrojNaDresu());
		lblDrzava.setText(fudbaler.getDrzava());
		lblKlub.setText(fudbaler.getKlub());
		lblPozicija.setText(fudbaler.getPozicija());
		
		
	}
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime");
			lblIme.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblIme.setBounds(10, 38, 522, 28);
		}
		return lblIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime");
			lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblPrezime.setBounds(10, 81, 522, 28);
		}
		return lblPrezime;
	}
	private JLabel getLblBrojNaDresu() {
		if (lblBrojNaDresu == null) {
			lblBrojNaDresu = new JLabel("Broj na dresu");
			lblBrojNaDresu.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblBrojNaDresu.setBounds(10, 132, 522, 28);
		}
		return lblBrojNaDresu;
	}
	private JLabel getLblPozicija() {
		if (lblPozicija == null) {
			lblPozicija = new JLabel("Pozicija");
			lblPozicija.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblPozicija.setBounds(10, 186, 522, 28);
		}
		return lblPozicija;
	}
	private JLabel getLblDrzava() {
		if (lblDrzava == null) {
			lblDrzava = new JLabel("Drzava");
			lblDrzava.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblDrzava.setBounds(10, 236, 522, 28);
		}
		return lblDrzava;
	}
	private JLabel getLblKlub() {
		if (lblKlub == null) {
			lblKlub = new JLabel("Klub");
			lblKlub.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblKlub.setBounds(10, 289, 522, 28);
		}
		return lblKlub;
	}
	private JButton getBtnSacuvajUJson() {
		if (btnSacuvajUJson == null) {
			btnSacuvajUJson = new JButton("Sacuvaj u JSON");
			btnSacuvajUJson.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean flag = kontroler.sacuvajUJSONFudbalera(fudbaler);
					
					if (flag) {
						JOptionPane.showMessageDialog(rootPane, "Uspesno cuvanje u JSON format.");
					} else {
						JOptionPane.showMessageDialog(rootPane, "Nije uspelo cuvanje. Probajte ponovo.");
					}
				}
			});
			btnSacuvajUJson.setActionCommand("OK");
		}
		return btnSacuvajUJson;
	}
}
