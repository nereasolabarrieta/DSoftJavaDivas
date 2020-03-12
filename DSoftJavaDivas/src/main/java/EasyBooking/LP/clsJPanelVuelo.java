package EasyBooking.LP;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class clsJPanelVuelo extends JPanel {

	/**
	 * Create the panel.
	 */
	public clsJPanelVuelo() {
		setLayout(null);
		
		JLabel lblPrecio = new JLabel("802,20\u20AC");
		lblPrecio.setBounds(31, 16, 69, 20);
		add(lblPrecio);

	}
}
