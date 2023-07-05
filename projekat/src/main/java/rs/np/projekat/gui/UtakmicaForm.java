package rs.np.projekat.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.np.projekat.domen.Klub;
import rs.np.projekat.domen.Utakmica;
import rs.np.projekat.kontroler.Kontroler;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI forma za unos nove utakmice.
 * 
 * @author mijov
 */
public class UtakmicaForm extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Referenca na kontroler koji povezuje GUI sa Bazom.
	 */
	private Kontroler kontroler;
	
	/**
	 * Referenca na GUI koji kreira ovu formu.
	 */
	private MainGui parent;
	
	private JComboBox comboBoxH;
	private JComboBox comboBoxA;
	private JSpinner spinnerH;
	private JSpinner spinnerA;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UtakmicaForm frame = new UtakmicaForm();
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
	public UtakmicaForm(MainGui parent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.parent = parent;
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getComboBoxH());
		contentPane.add(getComboBoxA());
		contentPane.add(getSpinnerH());
		contentPane.add(getSpinnerA());
		contentPane.add(getBtnNewButton());
		
		initTimoviCombobox();
	}
	
	/**
	 * Popunjava ComboBoxeve timova koji mogu da igraju jedan protiv drugog.
	 */
	private void initTimoviCombobox() {
		// TODO Auto-generated method stub
		List<Klub> klubovi = kontroler.getKontroler().vratiKlubove();
		
		comboBoxH.setModel(new DefaultComboBoxModel(klubovi.toArray()));

		comboBoxA.setModel(new DefaultComboBoxModel(klubovi.toArray()));
		
	}
	private JComboBox getComboBoxH() {
		if (comboBoxH == null) {
			comboBoxH = new JComboBox();
			comboBoxH.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxH.setBounds(23, 24, 134, 21);
		}
		return comboBoxH;
	}
	private JComboBox getComboBoxA() {
		if (comboBoxA == null) {
			comboBoxA = new JComboBox();
			comboBoxA.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxA.setBounds(259, 24, 134, 21);
		}
		return comboBoxA;
	}
	private JSpinner getSpinnerH() {
		if (spinnerH == null) {
			spinnerH = new JSpinner();
			spinnerH.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinnerH.setBounds(108, 77, 49, 33);
		}
		return spinnerH;
	}
	private JSpinner getSpinnerA() {
		if (spinnerA == null) {
			spinnerA = new JSpinner();
			spinnerA.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinnerA.setBounds(259, 77, 49, 33);
		}
		return spinnerA;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Potvrdi");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int idH = comboBoxH.getSelectedIndex() + 1;
					int idA = comboBoxA.getSelectedIndex() + 1;
					int golH = (int) spinnerH.getValue();
					int golA = (int) spinnerA.getValue();
					int sudija = kontroler.getKontroler().getUlogovaniSudija();
					
					Utakmica utakmica = new Utakmica();
					utakmica.setGolA(golA);
					utakmica.setGolH(golH);
					utakmica.setIdA(idA);
					utakmica.setIdH(idH);
					utakmica.setSudija(sudija);
					
					boolean flag = kontroler.getKontroler().unesiUtakmicu(utakmica);
					
					if (flag) {
						JOptionPane.showMessageDialog(rootPane, "Uspesno uneta utakmica!");
						parent.initTableUtakmice(null);
						setVisible(false);
						dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Neuspeno unosenje utakmice. Probajte ponovo.");
					}
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(341, 232, 85, 21);
		}
		return btnNewButton;
	}
}
