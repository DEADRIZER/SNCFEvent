package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueGenerale extends JFrame implements ActionListener
{
	private JLabel lbTitre = new JLabel("Gestion des trains");
	private JButton btAjout = new JButton("Ajouter Train"); 
	private JButton btLister = new JButton("Lister les trains"); 
	private JButton btSupprimer= new JButton("Supprimer Train");
	private JButton btModifier= new JButton("Modifier Train");
	private JButton btRechercher = new JButton("Rechercher Train"); 
	private JButton btQuitter = new JButton("Quitter"); 
	
	//instanciation des panels 
	private static PanelAjout unPanelAjout = new PanelAjout() ; 
	private static PanelLister unPanelLister = new PanelLister() ; 
	private static PanelSupprimer unPanelSupprimer = new PanelSupprimer() ; 
	private static PanelModifier unPanelModifier= new PanelModifier() ; 
	private static PanelRechercher unPanelRechercher= new PanelRechercher() ; 
	
	
	public VueGenerale()
	{
		this.setTitle("Gestion des trains à la SNCF");
		this.setBounds(200, 200, 800, 400);
		this.getContentPane().setBackground(Color.cyan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		//placements des objets graphiques
		this.lbTitre.setBounds(250, 40, 150, 20);
		this.add(this.lbTitre); 
		
		this.btAjout.setBounds(20, 80, 120, 20);
		this.add(this.btAjout); 
		
		this.btLister.setBounds(20, 110, 120, 20);
		this.add(this.btLister);
		
		this.btSupprimer.setBounds(20, 140, 120, 20);
		this.add(this.btSupprimer);
		
		this.btModifier.setBounds(20, 170, 120, 20);
		this.add(this.btModifier);
		
		this.btRechercher.setBounds(20, 200, 120, 20);
		this.add(this.btRechercher);
		
		this.btQuitter.setBounds(20, 230, 120, 20);
		this.add(this.btQuitter);
		
		//rendre les boutons ecoutables 
		this.btQuitter.addActionListener(this);
		this.btAjout.addActionListener(this);
		this.btLister.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btRechercher.addActionListener(this);
		
		//ajouter les panels dans la Jframe 
		this.add(VueGenerale.unPanelAjout); 
		this.add(VueGenerale.unPanelLister); 
		this.add(VueGenerale.unPanelModifier); 
		this.add(VueGenerale.unPanelSupprimer); 
		this.add(VueGenerale.unPanelRechercher);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter) {
			int retour = JOptionPane.showConfirmDialog(this,  "Voulez-vous quitter l'application ?", 
																	"Quitter l'application", JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				this.dispose(); 
			}
		}
		else if (e.getSource() == this.btAjout)
		{
			unPanelAjout.setVisible(true);
			unPanelLister.setVisible(false);
			unPanelModifier.setVisible(false);
			unPanelSupprimer.setVisible(false);
			unPanelRechercher.setVisible(false);
		}
		else if (e.getSource() == this.btLister)
		{
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(true);
			unPanelModifier.setVisible(false);
			unPanelSupprimer.setVisible(false);
			unPanelRechercher.setVisible(false);
		}
		else if (e.getSource() == this.btSupprimer)
		{
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(false);
			unPanelModifier.setVisible(false);
			unPanelSupprimer.setVisible(true);
			unPanelRechercher.setVisible(false);
		}
		else if (e.getSource() == this.btModifier)
		{
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(false);
			unPanelModifier.setVisible(true);
			unPanelSupprimer.setVisible(false);
			unPanelRechercher.setVisible(false);
		}
		else if (e.getSource() == this.btRechercher)
		{
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(false);
			unPanelModifier.setVisible(false);
			unPanelSupprimer.setVisible(false);
			unPanelRechercher.setVisible(true);
		}
	}
}















