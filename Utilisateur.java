package film;

import java.util.ArrayList;

public class Utilisateur {
	public ArrayList<Type> dix_dernier;
	public ArrayList<Type> films;		//une liste avec tout les films visionner
	public Parametre parametre;
	
	Utilisateur(){
		this.dix_dernier=new ArrayList<Type>();		//je dois importer d'un fichier la liste
		this.films=new ArrayList<Type>();
		this.parametre=new Parametre();
	}
	
	

}