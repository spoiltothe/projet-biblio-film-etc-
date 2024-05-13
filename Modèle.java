package javamodelefinal;
import java.util.ArrayList;






import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;
import java.io.*; 
import java.util.Scanner;
import java.util.Set;
import javax.swing.ImageIcon;
import java.lang.Comparable; 
public class Modèle extends Observable implements Serializable  {
private static final long serialVersionUID = 1L;
public ArrayList<Film> catalogue;
public ArrayList<Film> films_favoris; 
public String genre_fav;
public int durée_fav;
public int année_fav; 
public String série_fav;
public String réalisateur_fav; 
public String recent_id; 
public ArrayList<ImageIcon> images;
public DossierReader liens;  
		
		
public Modèle() throws FileNotFoundException,IOException {
      CSVReader csv = new CSVReader();
      this.liens = new DossierReader(); 
      this.catalogue = csv.lire();  
      this.films_favoris=new ArrayList<Film>();
      this.images = this.liens.charger(); 
     
			
			
      
			
		
		   
			 
				
			
			
		}




public ArrayList<ImageIcon> getImages(){
	return images;
}
		@Override
public String toString() {
    String s = ""; 
	for (int i=0; i<this.catalogue.size(); i++) {
		s += this.catalogue.get(i).toString() + "\n"; 
	}
	return s; 
}


	public ArrayList<Film> trierid(String id2) {
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).id.equalsIgnoreCase(id2) && !this.films_favoris.contains(this.catalogue.get(i))) {
				this.films_favoris.add(this.catalogue.get(i)); 
			}
		}
		
	    this.recent_id=id2;  
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		this.notifyObservers(this.recent_id);
	    return this.films_favoris;
	 
	}

	public ArrayList<Film> triernom(String n) {

		
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).nom.equalsIgnoreCase(n) && !this.films_favoris.contains(this.catalogue.get(i))) {
				this.films_favoris.add(this.catalogue.get(i)); 
				this.catalogue.get(i).favori=true; 
			}
			
		}
		
	    this.série_fav= n; 
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		this.notifyObservers(this.série_fav);
		return this.films_favoris; 
 
	}

	public  ArrayList<Film> triergenre(String g) { 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).genre.equalsIgnoreCase(g) && !this.films_favoris.contains(this.catalogue.get(i))) {
				this.films_favoris.add(this.catalogue.get(i)); 
				this.catalogue.get(i).favori=true; 
			}
			
			
		}
		
	    this.genre_fav=g; 
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		this.notifyObservers(this.genre_fav); 
		return this.films_favoris;
	 
	}

	public  ArrayList<Film> trierdurée(String d, String classement_tri) {
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
				if (duréei<=durée && !this.films_favoris.contains(this.catalogue.get(i))) {
					this.films_favoris.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				
				
			}
		
			if (classement_tri.equalsIgnoreCase("desc")) {
				if (duréei>durée && !this.films_favoris.contains(this.catalogue.get(i))) {
					this.films_favoris.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				
			}
			
		}
		
		
		
	    this.durée_fav=durée; 
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		this.notifyObservers(this.durée_fav); 
		return this.films_favoris;
	}
	

	public  ArrayList<Film> trierannée(String an, String classement_tri) {
		int ann = Integer.parseInt(an); 
		 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			int anni = Integer.parseInt(this.catalogue.get(i).année);
			
			
			if (classement_tri.equalsIgnoreCase("asc")) {
				if (anni<=ann && !this.films_favoris.contains(this.catalogue.get(i))) {
					this.films_favoris.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				
			}
			
			if (classement_tri.equalsIgnoreCase("desc")) {
				if (anni>=ann && !this.films_favoris.contains(this.catalogue.get(i))) {
					this.films_favoris.add(this.catalogue.get(i)); 
					this.catalogue.get(i).favori=true; 
				}
				
			}	
	}
		
		
		
		this.année_fav=ann; 
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		this.notifyObservers(this.année_fav);
		return this.films_favoris;
	}
	

	public  ArrayList<Film> trierréa(String réa) {
		 
		
		for (int i=0; i<this.catalogue.size(); i++) {
			if (this.catalogue.get(i).réalisateur.equalsIgnoreCase(réa) && !this.films_favoris.contains(this.catalogue.get(i))) {
				this.films_favoris.add(this.catalogue.get(i)); 
				this.catalogue.get(i).favori=true; 
			}
			
				
			
			
		}
	    
	    
	    this.réalisateur_fav=réa;
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		this.notifyObservers(this.réalisateur_fav);
		return this.films_favoris;
	}
	
	
	public  ArrayList<Film> reset_id( ) {
		for (int i=0; i<this.films_favoris.size(); i++) {
			if (this.films_favoris.get(i).id.equalsIgnoreCase(this.recent_id)) {
				this.films_favoris.get(i).favori=false; 
				this.films_favoris.remove(i); 
				i-=1; 
				
			}
		}
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		return this.films_favoris;
		
	}
	
	
	
	public  ArrayList<Film> reset_nom( ) {
		for (int i=0; i<this.films_favoris.size(); i++) {
			if (this.films_favoris.get(i).nom.equalsIgnoreCase(this.série_fav)) {
				this.films_favoris.get(i).favori=false; 
				this.films_favoris.remove(i); 
				i-=1; 
				
			}
		}
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		return this.films_favoris;
		
	}

	public ArrayList<Film> reset_genre() {
		for (int i=0; i<this.films_favoris.size(); i++) {
			if (this.films_favoris.get(i).genre.equalsIgnoreCase(this.genre_fav)) {
				this.films_favoris.get(i).favori=false; 
				this.films_favoris.remove(i); 
				i-=1; 
				
			}
		}
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		return this.films_favoris;
	
	}
	
	public  ArrayList<Film> reset_durée(String ordre) {
		
		
		for (int i=0; i<this.films_favoris.size(); i++) {
			String r = this.films_favoris.get(i).durée; 
			String[] hm1 = r.split("h"); 
			int heuresi = Integer.parseInt(hm1[0]);
			int minutesi = Integer.parseInt(hm1[1]);
			int duréei = heuresi*60+minutesi;  
			if (ordre=="asc") {
			    if (duréei<=this.durée_fav) {
				this.films_favoris.get(i).favori=false; 
				this.films_favoris.remove(i); 
				i-=1; 
				
			}
			}
			if (ordre=="desc") { 
				if (duréei>this.durée_fav) {
					this.films_favoris.get(i).favori=false; 
					this.films_favoris.remove(i); 
					i-=1; 
				}
			}
		
		}
	
		
	this.setChanged();
	this.notifyObservers(this.films_favoris);
	return this.films_favoris;	
		
}

	public  ArrayList<Film> reset_annee(String ordre) {
		for (int i=0; i<this.films_favoris.size(); i++) {
			int anneei = Integer.parseInt(this.films_favoris.get(i).année); 
			if (ordre=="asc") {
				if (anneei<=this.année_fav) {
					this.films_favoris.get(i).favori=false; 
					this.films_favoris.remove(i);
					i-=1; 
				}
			}
			if (ordre=="desc") {
				if (anneei>this.année_fav) {
					this.films_favoris.get(i).favori=false; 
					this.films_favoris.remove(i);
					i-=1; 
				}
			}
		}
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		return this.films_favoris;
	
	}

	public  ArrayList<Film> reset_réa() {
		for (int i=0; i<this.films_favoris.size(); i++) {
			if (this.films_favoris.get(i).réalisateur.equalsIgnoreCase(réalisateur_fav)) {
				this.films_favoris.get(i).favori=false; 
				this.films_favoris.remove(i); 
				i-=1; 
				
			}
		}
		this.setChanged();
		this.notifyObservers(this.films_favoris);
		return this.films_favoris;
	
	}





	public static void main(String[] args) throws Exception  {
	
		 Modèle m =new Modèle(); 
	
		
		 System.out.println(m.images); 		 
		 
		 
		
		 
		 
	

		 
		
		 
	
	
		
	 
		 
		
	    		
	}}





