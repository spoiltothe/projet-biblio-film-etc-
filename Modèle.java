package javamodèle;
import java.util.ArrayList;




import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;
import java.io.*; 
import java.util.Scanner;
import java.util.Set; 
import java.lang.Comparable; 
public class Modèle extends Observable implements Serializable {
private static final long serialVersionUID = 1L;
public ArrayList<Film> catalogue;
public PriorityQueue<Film> fims_favoris; 
public String genre_fav;
public int durée_fav;
public int année_fav; 
public String série_fav;
public String réalisateur_fav; 
		
		
public Modèle() throws FileNotFoundException,IOException {
      CSVReader csv = new CSVReader();
      this.catalogue = csv.lire();  
      this.fims_favoris=new PriorityQueue<Film>(); 
			
			
      
			
		
		   
			 
				
			
			
		}
		@Override
public String toString() {
    String s = ""; 
	for (int i=0; i<this.catalogue.size(); i++) {
		s += this.catalogue.get(i).toString() + "\n"; 
	}
	return s; 
}
		
	public void ajoutFilm(Film f) {
		this.catalogue.add(f); 
		
	}

	public void trierid(String id2) {
		ArrayList<Film> filtre = new ArrayList<Film>(); 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).id.equalsIgnoreCase(id2)) {
				filtre.add(this.catalogue.get(i)); 
			}
		}
		
	
		this.setChanged();
		this.notifyObservers(filtre);
	 
	}

	public void triernom(String n) {
		ArrayList<Film> filtre = new ArrayList<Film>(); 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).nom.equalsIgnoreCase(n)) {
				filtre.add(this.catalogue.get(i)); 
				this.catalogue.get(i).favori=true; 
			}
			else {
				this.catalogue.get(i).favori= false; 
			}
		}
		
	    this.série_fav= n; 
		this.setChanged();
		this.notifyObservers(filtre);
		this.notifyObservers(this.série_fav);
 
	}

	public void triergenre(String g) { 
		ArrayList<Film> filtre = new ArrayList<Film>(); 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).genre.equalsIgnoreCase(g)) {
				filtre.add(this.catalogue.get(i)); 
				this.catalogue.get(i).favori=true; 
			}
			
			else {
				this.catalogue.get(i).favori= false; 
			}
		}
		
	    this.genre_fav=g; 
		this.setChanged();
		this.notifyObservers(filtre);
		this.notifyObservers(this.genre_fav); 
	 
	}

	public void trierdurée(String d, String classement_tri) {
		ArrayList<Film> filtre = new ArrayList<Film>(); 
		String[] hm = d.split("h");
		int heures = Integer.parseInt(hm[0]);
		int minutes = Integer.parseInt(hm[1]);
		int durée = heures*60+minutes; 
		
		
		
		for (int i=0; i<this.catalogue.size(); i++) {
			String r = this.catalogue.get(i).durée; 
			String[] hm1 = r.split("h"); 
			int heuresi = Integer.parseInt(hm1[0]);
			int minutesi = Integer.parseInt(hm1[1]);
			int duréei = heuresi*60+minutesi;  
			if (classement_tri.equalsIgnoreCase("asc")) {
				if (duréei<=durée) {
					filtre.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				else {
					this.catalogue.get(i).favori=false; 
				}
				
			}
		
			if (classement_tri.equalsIgnoreCase("desc")) {
				if (duréei>durée) {
					filtre.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				else {
					this.catalogue.get(i).favori=false; 
				}
			}
			
		}
		
		
		
	    this.durée_fav=durée; 
		this.setChanged();
		this.notifyObservers(filtre);
		this.notifyObservers(this.durée_fav); 
		
	}
	

	public void trierannée(String an, String classement_tri) {
		int ann = Integer.parseInt(an); 
		
		
		ArrayList<Film> filtre = new ArrayList<Film>(); 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			int anni = Integer.parseInt(this.catalogue.get(i).année);
			
			
			if (classement_tri.equalsIgnoreCase("asc")) {
				if (anni<=ann) {
					filtre.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				else {
					this.catalogue.get(i).favori=false; 
				}
			}
			
			if (classement_tri.equalsIgnoreCase("desc")) {
				if (anni>=ann) {
					filtre.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				else {
					this.catalogue.get(i).favori=false; 
				}
			}	
	}
		
		
		
		this.année_fav=ann; 
		this.setChanged();
		this.notifyObservers(filtre); 
		this.notifyObservers(this.année_fav);
		
	}
	

	public void trierréa(String réa) {
		ArrayList<Film> filtre = new ArrayList<Film>(); 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).réalisateur.equalsIgnoreCase(réa)) {
				filtre.add(this.catalogue.get(i)); 
				this.catalogue.get(i).favori=true; 
			}
			
				
			
			else {
				this.catalogue.get(i).favori=false; 
			}
			
		}
	    
	    
	    this.réalisateur_fav=réa;
		this.setChanged();
		this.notifyObservers(filtre);
		this.notifyObservers(this.réalisateur_fav);
		
	}




	public static void main(String[] args) throws Exception  {
	
		 Modèle m =new Modèle(); 
	
		 for (int i=0; i<m.catalogue.size(); i++) {
			 System.out.println(m.catalogue.get(i).nom + " , "+ m.catalogue.get(i).getScore()); 
			 }
		 }
		
	 
		 
		
	    		
	}




