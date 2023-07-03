package rs.np.projekat;

import java.sql.SQLException;

import rs.np.projekat.db.DBBroker;
import rs.np.projekat.domen.Sudija;
import rs.np.projekat.gui.PrijavaGui;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        PrijavaGui gui = new PrijavaGui();
        gui.setVisible(true);
    }
}
