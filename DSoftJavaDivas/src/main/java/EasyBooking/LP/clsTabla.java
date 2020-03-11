package EasyBooking.LP;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import EasyBooking.LN.Vuelo;
import javax.swing.JTable;

public class clsTabla extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public clsTabla() {
		ArrayList<Vuelo>ListaVuelos=new ArrayList();
		Vuelo v1= new Vuelo("1234","Madrid","SA (CA)", "87223FV",16,"7:20","12:30",345);
		Vuelo v2= new Vuelo("1234","Madrid","SA (CA)", "87223FV",16,"7:20","12:30",345);
		Vuelo v3= new Vuelo("1234","Madrid","SA (CA)", "87223FV",16,"7:20","12:30",345);
		Vuelo v4= new Vuelo("1234","Madrid","SA (CA)", "87223FV",16,"7:20","12:30",345);
		Vuelo v5= new Vuelo("1234","Madrid","SA (CA)", "87223FV",16,"7:20","12:30",345);
		Vuelo v6= new Vuelo("1234","Madrid","SA (CA)", "87223FV",16,"7:20","12:30",345);
		Vuelo v7= new Vuelo("1234","Madrid","SA (CA)", "87223FV",16,"7:20","12:30",345);
		ListaVuelos.add(v1);
		ListaVuelos.add(v2);
		ListaVuelos.add(v3);
		ListaVuelos.add(v4);
		ListaVuelos.add(v5);
		ListaVuelos.add(v6);
		ListaVuelos.add(v7);
		
	
		this.setBackground(new Color(192, 192, 192));
		this.setBounds(219, 155, 1044, 529);
		setLayout(null);
		
		table = new JTable(ListaVuelos.size(),1);
		table.setBounds(50, 33, 952, 480);
		table.setRowHeight(20);
		add(table);
		
		
		
	}
}
