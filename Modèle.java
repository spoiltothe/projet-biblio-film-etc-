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
public class Modèle extends Observable {
	
		PriorityQueue<Film> catalogue;
		
		
		public Modèle() throws FileNotFoundException,IOException {
			CSVReader csv = new CSVReader();
			
			
			this.catalogue = csv.lire();  
			
		
		   
			 
				
			
			
		}
		
	public void ajoutFilm(Film f) {
		this.catalogue.add(f); 
		
	}

	public void trierid(String id2) {
		PriorityQueue<Film> filtre = new PriorityQueue<Film>();
		Iterator<Film> elements = this.catalogue.iterator();
		
		while(elements.hasNext()) {
			if (elements.next().id.equalsIgnoreCase(id2)) {
				filtre.add(elements.next()); 
			}
		}
		
		this.setChanged();
		this.notifyObservers(filtre);
	}

	public void triernom(String n) {
		PriorityQueue<Film> filtre = new PriorityQueue<Film>();
		Iterator<Film> elements = this.catalogue.iterator();
		
		while(elements.hasNext()) {
			if (elements.next().id.equalsIgnoreCase(n)) {
				filtre.add(elements.next()); 
			}
		}
		this.setChanged();
		this.notifyObservers(filtre);
	}

	public void triergenre(String g) {
		PriorityQueue<Film> filtre = new PriorityQueue<Film>();
		Iterator<Film> elements = this.catalogue.iterator();
		
		while(elements.hasNext()) {
			if (elements.next().id.equalsIgnoreCase(g)) {
				filtre.add(elements.next()); 
			}
		}
		
		this.setChanged();
		this.notifyObservers(filtre);
	}

	public void trierdurée(String du) {
		PriorityQueue<Film> filtre = new PriorityQueue<Film>();
		Iterator<Film> elements = this.catalogue.iterator();
		
		while(elements.hasNext()) {
			if (elements.next().id.equalsIgnoreCase(du)) {
				filtre.add(elements.next()); 
			}
		}
		
		this.setChanged();
		this.notifyObservers(filtre);
	}

	public void trierannée(String an) {
		PriorityQueue<Film> filtre = new PriorityQueue<Film>();
		Iterator<Film> elements = this.catalogue.iterator();
		
		while(elements.hasNext()) {
			if (elements.next().id.equalsIgnoreCase(an)) {
				filtre.add(elements.next()); 
			}
		}
		
		this.setChanged();
		this.notifyObservers(filtre);
	}

	public void trierextension(String extent) {
		PriorityQueue<Film> filtre = new PriorityQueue<Film>();
		Iterator<Film> elements = this.catalogue.iterator();
		
		while(elements.hasNext()) {
			if (elements.next().id.equalsIgnoreCase(extent)) {
				filtre.add(elements.next()); 
			}
		}
		this.setChanged();
		this.notifyObservers(filtre);
	}

	public void trierréa(String réa) {
		PriorityQueue<Film> filtre = new PriorityQueue<Film>();
		Iterator<Film> elements = this.catalogue.iterator();
		
		while(elements.hasNext()) {
			if (elements.next().id.equalsIgnoreCase(réa)) {
				filtre.add(elements.next()); 
			}
		}
		this.setChanged();
		this.notifyObservers(filtre);
	}




	public static void main(String[] args) throws Exception  {
		Modèle x = new Modèle();
	    System.out.println(x.catalogue); 		
	}


}

