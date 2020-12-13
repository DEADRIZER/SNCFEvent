package controleur;

public class Train 
{
	private int idTrain, nbWagons;
	private String designation, dateCirculation , typeTrain;
	
	public Train(int idTrain, int nbWagons, String designation, String dateCirculation, String typeTrain) {
		this.idTrain = idTrain;
		this.nbWagons = nbWagons;
		this.designation = designation;
		this.dateCirculation = dateCirculation;
		this.typeTrain = typeTrain;
	}
	
	public Train() {
		this.idTrain = 0;
		this.nbWagons = 0;
		this.designation = "";
		this.dateCirculation = "";
		this.typeTrain = "";
	}

	public int getIdTrain() {
		return idTrain;
	}

	public void setIdTrain(int idTrain) {
		this.idTrain = idTrain;
	}

	public int getNbWagons() {
		return nbWagons;
	}

	public void setNbWagons(int nbWagons) {
		this.nbWagons = nbWagons;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDateCirculation() {
		return dateCirculation;
	}

	public void setDateCirculation(String dateCirculation) {
		this.dateCirculation = dateCirculation;
	}

	public String getTypeTrain() {
		return typeTrain;
	}

	public void setTypeTrain(String typeTrain) {
		this.typeTrain = typeTrain;
	}
	

	
	
	
}
