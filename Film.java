package javamodèle;


public class Film implements Comparable{
	public String id ; 
	public String nom; 
	public enum Genre {ACTION, AVENTURE, DRAME, HORREUR, COMEDIE, DOCUMENTAIRE, POLICIER, WESTERN, ANIME } ; 
	public String genre; 
	public String durée; 
	public String année; 
	public int score; 
	public String extension; 
	public String réalisateur; 
	public	String identité = this.id+"."+this.nom+"."+this.extension; 
	public String critique;
	public String avis_public;
	public String theme;
	public String scénario;
	public String tournage;
	public String genre_score; 
	
	

	public Film(String i, String n, String g, String du, String a, String e, String r, String c, String av, String t, String s, String to, String gs) {
		this.id=i; 
		this.nom=n;
		this.durée=du;  
		this.genre=g; 
		this.année=a; 
		this.extension=e; 
		this.réalisateur=r; 
		this.critique=c;
		this.avis_public=av;
		this.theme=t;
		this.scénario=s;
		this.tournage=to;
		this.genre_score=gs; 

		
		
		
	}
	public static void main(String[] args) throws Exception  {
		Film i= new Film("1","revef","Western","1h30","1203","mp4","SPielberg","4","5","identité","classique","peu","4"); 
	System.out.println(i.avis_public); 
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

