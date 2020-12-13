package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.SNCF;
import controleur.Train;


public class PanelAjout extends PanelCentral implements ActionListener
{
	
	private JTextField txtDesignation = new JTextField(); 
	private JTextField txtDate = new JTextField(); 
	private JTextField txtNbwagons = new JTextField(); 
	private JComboBox<String> txtType = new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	
	public PanelAjout()
	{
		super(Color.gray);
		
		this.setLayout(new GridLayout(5,2));
		
		this.add(new JLabel("Désignation : ")); 
		this.add(this.txtDesignation); 
		
		this.add(new JLabel("Date Circulation : ")); 
		this.add(this.txtDate);
		
		this.add(new JLabel("Nb Wagons : ")); 
		this.add(this.txtNbwagons);
		
		this.add(new JLabel("Type Train : ")); 
		this.add(this.txtType);
		
		this.txtType.addItem("tgv");
		this.txtType.addItem("intercités");
		this.txtType.addItem("corail");
		this.txtType.addItem("transilien");
		
		this.add(this.btAnnuler); 
		this.add(this.btEnregistrer);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() ==this.btAnnuler) {
			 this.txtDesignation.setText("");
			 this.txtDate.setText("");
			 this.txtNbwagons.setText("");
			 
		 }else if(e.getSource()== this.btEnregistrer) {
			 String designation = this.txtDesignation.getText(); 
			 String date = this.txtDate.getText(); 
			 String type = this.txtType.getSelectedItem().toString(); 
			 int nbWagons = 0 ; 
			 
			 try {
				 nbWagons= Integer.parseInt(this.txtNbwagons.getText()); 
			 }
			 catch (NumberFormatException exp) {
				 JOptionPane.showMessageDialog(this, "Erreur sur le format du nombre");
			 }
			 if (nbWagons<=0 || nbWagons > 25) {
				 this.txtNbwagons.setBackground(Color.red);
				 this.txtNbwagons.setText("");
			 }else {
					 Train unTrain = new Train (0, nbWagons, designation,date, type );
					 //enregistrer le train dans la base 
					 SNCF.insertTrain(unTrain);
					 
					 //insertion de la ligne dans le panel lister : rendre l'affichage dynamique 
					 Object []ligne = {0, designation, date, nbWagons, type};
					 PanelLister.getMonTableau().insertLigne(ligne);
					 
					 JOptionPane.showMessageDialog(this, "Insertion réussie");
					 this.setVisible(false);
					 this.txtNbwagons.setBackground(Color.white);
					 this.txtDesignation.setText("");
					 this.txtDate.setText("");
					 this.txtNbwagons.setText("");
			 	   }
		 }
		
	}
}


