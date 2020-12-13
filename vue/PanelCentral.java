package vue;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelCentral extends JPanel
{
	public PanelCentral(Color uneCouleur)
	{
		this.setBackground(uneCouleur);
		this.setBounds(200, 80, 550, 240);
		this.setLayout(null);
		
		//par defaut : tous les panels sont non visibles 
		this.setVisible(false);
	}
}
