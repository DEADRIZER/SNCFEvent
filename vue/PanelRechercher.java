package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.SNCF;
import controleur.Tableau;
import controleur.Train;

public class PanelRechercher  extends PanelCentral implements ActionListener
{
	private JTextField txtMot = new JTextField(); 
	private JButton btOk = new JButton ("Ok"); 
	private Tableau unTableau = null; 
	private JTable tbTrains = null; 
	
	public PanelRechercher()
	{
		super(Color.blue);
		this.txtMot.setBounds(200, 10, 100, 20);
		this.add(this.txtMot); 
		
		this.btOk.setBounds(320, 10, 60, 20);
		this.add(this.btOk); 
		
		//rendre le bouton ok cliquable 
		this.btOk.addActionListener(this);
		
	}
	
	public Object[][] getDonnees (String mot){
		ArrayList<Train> lesTrains = SNCF.selectAllTrains(mot);
		Object[][] matrice = new Object[lesTrains.size()][5];
		int i = 0; 
		for (Train unTrain : lesTrains) {
			matrice [i][0] = unTrain.getIdTrain(); 
			matrice [i][1] = unTrain.getDesignation();
			matrice [i][2] = unTrain.getDateCirculation();
			matrice [i][3] = unTrain.getNbWagons();
			matrice [i][4] = unTrain.getTypeTrain();
			i++;
		}
		return matrice; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btOk) {
			String mot = this.txtMot.getText(); 
			
			String entetes [] = {"Id Train", "Désignation", "Date Circulation","Nb Wagons", "Type Train" };
			unTableau = new Tableau (this.getDonnees(mot), entetes);
			
			this.tbTrains = new JTable( unTableau);
						
			JScrollPane uneScroll = new JScrollPane(this.tbTrains); 
			uneScroll.setBounds(10, 50, 520, 170);
			this.add(uneScroll);
			
		}
		
	}
}
