package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.SNCF;
import controleur.Tableau;
import controleur.Train;

public class PanelLister extends PanelCentral
{
	private JTable tbTrains = null; 
	private static Tableau unTableau = null; 
	
	public PanelLister()
	{
		super(Color.yellow);
		
		
		String entetes [] = {"Id Train", "Désignation", "Date Circulation","Nb Wagons", "Type Train" };
		unTableau = new Tableau (this.getDonnees(), entetes);
		
		this.tbTrains = new JTable( unTableau);
				
				
		JScrollPane uneScroll = new JScrollPane(this.tbTrains); 
		uneScroll.setBounds(10, 10, 520, 200);
		this.add(uneScroll);
	}
	
	public Object[][] getDonnees (){
		ArrayList<Train> lesTrains = SNCF.selectAllTrains();
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
	public static Tableau getMonTableau () {
		return unTableau; 
	}
	
}