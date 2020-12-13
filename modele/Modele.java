package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Train;

public class Modele 
{
	private static Bdd uneBdd = new Bdd ("localhost:8889", "sncf", "root","root"); 
	//new Bdd ("localhost", "sncf", "root",""); pour PC 
	
	public static ArrayList<Train> selectAllTrains()
	{
		ArrayList<Train> trains = new ArrayList<Train>(); 
		try {
			uneBdd.seConnecter();
			String requete = "select * from train ; "; 
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next())
			{
				int idTrain = desResultats.getInt("idtrain"); 
				int nbWagons = desResultats.getInt("nbwagons"); 
				String designation = desResultats.getString("designation");
				String dateCirculation = desResultats.getString("datecirculation");
				String typeTrain = desResultats.getString("typetrain");
				Train unTrain = new Train(idTrain, nbWagons, designation, dateCirculation, typeTrain);
				trains.add(unTrain);
			}
			desResultats.close();
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete select.");
		}
		return trains;
		
	}

	public static void insertTrain(Train unTrain) {
		
		String requete ="insert into train values (null,'"+
						unTrain.getDesignation()+"','"+unTrain.getDateCirculation()
						+ "',"+unTrain.getNbWagons()+",'"+unTrain.getTypeTrain()
						+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}

	public static void deleteTrain(int idTrain) {
		String requete = "DELETE FROM train WHERE idtrain="+idTrain+";";
		try
		{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : "+requete);
		}
		
	}

	public static Train selectWhere(int idTrain) {
		Train unTrain = null; 
		
		String requete = "select * from train where idtrain = " + idTrain + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet leResultat = unStat.executeQuery(requete); 
			if (leResultat.next())
			{
				int nbWagons = leResultat.getInt("nbwagons"); 
				String designation = leResultat.getString("designation");
				String dateCirculation = leResultat.getString("datecirculation");
				String typeTrain = leResultat.getString("typetrain");
				//instancier le train récupéré de la bdd 
				unTrain = new Train(idTrain, nbWagons, designation, dateCirculation, typeTrain);
			}
			leResultat.close();
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : "+requete);
		}
		
		return unTrain ;
	}

	public static void updateTrain(Train unTrain) {
		
		String requete = "update train set nbwagons = "+unTrain.getNbWagons()
		+" , designation = '"+unTrain.getDesignation()
		+"' , datecirculation = '"+unTrain.getDateCirculation()
		+"' , typetrain = '"+unTrain.getTypeTrain()
		+"' where idtrain= " +unTrain.getIdTrain()+";";
		try
		{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : "+requete);
		}
		
	}

	public static ArrayList<Train> selectAllTrains(String mot) {
		
		ArrayList<Train> trains = new ArrayList<Train>(); 
		String requete = "select * from train where designation like '%" + mot + "%'"
				+ " or typetrain like '%" + mot + "%' " + " or datecirculation like '%" + mot + "%' ;" ;
		try {
			uneBdd.seConnecter();
		
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next())
			{
				int idTrain = desResultats.getInt("idtrain"); 
				int nbWagons = desResultats.getInt("nbwagons"); 
				String designation = desResultats.getString("designation");
				String dateCirculation = desResultats.getString("datecirculation");
				String typeTrain = desResultats.getString("typetrain");
				Train unTrain = new Train(idTrain, nbWagons, designation, dateCirculation, typeTrain);
				trains.add(unTrain);
			}
			desResultats.close();
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return trains;
	}
	
}




















