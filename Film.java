package javamodèle;

import java.io.Serializable;

public class Film implements Comparable,Serializable{
	private static final long serialVersionUID = 1L;
	public String id ; 
	public String nom; 
	public enum Genre {ACTION, AVENTURE, DRAME, HORREUR, COMEDIE, DOCUMENTAIRE, POLICIER, WESTERN, ANIME } ; 
	public String genre; 
	public String durée; 
	public String année; 
	public int score; 
	public String réalisateur; 
	public	String identité = this.id+"."+this.nom+".";
	public String critique;
	public String avis_public;
	public String theme;
	public String scénario;
	public String tournage;
	public String genre_score; 
	public boolean favori; 
	
	

	public Film(String i, String n, String g, String du, String a,  String r, String c, String av, String t, String s, String to, String gs) {
		this.id=i; 
		this.nom=n;
		this.durée=du;  
		this.genre=g; 
		this.année=a; 
	 
		this.réalisateur=r; 
		this.critique=c;
		this.avis_public=av;
		this.theme=t;
		this.scénario=s;
		this.tournage=to;
		this.genre_score=gs; 
		this.favori=false; 

		
		
		
	}
	@Override
	public String toString() {
		return "id : "+ this.id + " nom : " + this.nom +  " durée : "+ this.durée + " genre :" + this.genre + " année : "+ this.année + " réalisateur :" + this.réalisateur;
			
	}
	
	public double getScore() {
		return (Double.parseDouble(critique)+Double.parseDouble(avis_public)+Double.parseDouble(theme)+Double.parseDouble(scénario)+Double.parseDouble(tournage)+Double.parseDouble(genre_score))/6; 
	}
	public static void main(String[] args) throws Exception  {
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

