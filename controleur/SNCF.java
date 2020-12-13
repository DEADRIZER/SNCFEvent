package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.Modele;
import vue.VueGenerale;
 

public class SNCF {
	private ArrayList<Train> lesTrains ; 
	
	public SNCF ()
	{
		this.lesTrains = Modele.selectAllTrains(); //chargement depuis la bdd 
	}
	 
	public static void main(String[] args) {
		 
		SNCF uneSncf = new SNCF(); 
		
		VueGenerale uneVueGenerale = new VueGenerale(); 
	}
	
	public static void insertTrain (Train unTrain)
	{
		//on doit controler les données avant insertion dans le meodele
		
		Modele.insertTrain(unTrain);
	}

	public static ArrayList<Train> selectAllTrains()
	{
		return Modele.selectAllTrains();
	}
	
	public static ArrayList<Train> selectAllTrains(String mot) {
		return Modele.selectAllTrains(mot);
	}
}
