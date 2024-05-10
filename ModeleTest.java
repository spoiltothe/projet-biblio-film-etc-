package javamodelefinal;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class ModeleTest {
    private Modèle modele; 
    private ArrayList<Film> ex; 
	@Before
	public void setUp() throws Exception {
		modele = new Modèle(); 
		ex = new ArrayList<Film>(); 
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testtrierid() {
		modele.trierid("1");
		ex.add(new Film("1","Fight Club","drame","2h19","1999","David Fincher","9.6","8","6","5","7","7")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	@Test
	public void testtriernom() {
		modele.triernom("rambo");
		ex.add(new Film("33","Rambo","action","1h33","1982","Ted Kotcheff","8.6","8.8","5","7","7","6")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testtriergenre() {
		modele.triergenre("drame");
		ex.add(new Film("1","Fight Club","drame","2h19","1999","David Fincher","9.6","8","6","5","7","7")); 
		ex.add(new Film("2","Forrest Gump","drame","2h22","1994","Robert Zemeckis","7.6","9.4","8","7","5","7")); 
		ex.add(new Film("3","Roméo + Juliette","drame","2h00","1996","Baz Luhrmann","7.4","7.8","7","7","7","7")); 
		ex.add(new Film("4","Le Pianiste","drame","2h30","2002","Roman Polaski","9.5","9.4","8","7.5","6","7")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testtrierduréeasc() {
		modele.trierdurée("1h30", "asc");;
		ex.add(new Film("19","Arthur: Malédiction","horreur","1h27","2022","Luc Besson","1","1.1","1","1","2","4")); 
		ex.add(new Film("20","Le tombeau des lucioles","animation","1h29","1988","Isao Takahata","10","9.7","9","9","8.5","8")); 
		ex.add(new Film("22","mon Voisin Totoro","animation","1h26","1988","Hayao Himazaki","9.3","9.4","7.5","8","8.5","8")); 
		ex.add(new Film("37","Massacre à la tronçonneuse (1974)","horreur","1h23","1974","Tobe Hooper","8.9","8.7","6","6.5","7","5")); 
		ex.add(new Film("38","Le Project Blair Witch","horreur","1h21","1999","Eduardo Sánchez,Daniel Myrick","8.6","7.9","5","8","9","5"));
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testtrierduréedesc() {
		modele.trierdurée("2h30", "desc");;
		ex.add(new Film("6","Pulp Fiction","comédie","2h34","1994","Quentin Tarantino","9.2","9.2","7","7.5","9","6.5")); 
		ex.add(new Film("13","Avatar","science-fiction","2h42","2009","James Cameron","8.2","8.6","8","7","9.5","7")); 
		ex.add(new Film("14","2001: l'Odyssée de l'Espace","science-fiction","2h40","1968","Stanley Kubrick","9.2","8.4","6","6.5","9","7")); 
		ex.add(new Film("26","Le seigneur des Anneaux: La Communauté de l'anneau","aventure","2h58","2001","Peter Jackson","9.1","8.5","6","8.5","9","7")); 
		ex.add(new Film("29","Le Seigneur des Anneaux: le Retour du Roi","aventure","3h21","2003","Peter Jackson","9.4","8.5","6","7.5","8.5","7"));
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testtrierannéeasc() {
		modele.trierannée("1972", "asc");
		ex.add(new Film("11","Orange Mécanique","science-fiction","2h16","1971","Stanley Kubrick","8.7","8.7","5","6.5","7.5","7")); 
		ex.add(new Film("14","2001: l'Odyssée de l'Espace","science-fiction","2h40","1968","Stanley Kubrick","9.2","8.4","6","6.5","9","7")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testtrierannéedesc() {
		modele.trierannée("2020", "desc");
		ex.add(new Film("19","Arthur: Malédiction","horreur","1h27","2022","Luc Besson","1","1.1","1","1","2","4")); 
		ex.add(new Film("34","Five Nights At Freddy's","horreur","1h50","2023","Emma Tammi","3.2","8.9","5","7.5","7.5","5")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testtrierréalisateur() {
		modele.trierréa("Emma tammi");
		ex.add(new Film("34","Five Nights At Freddy's","horreur","1h50","2023","Emma Tammi","3.2","8.9","5","7.5","7.5","5")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	
	@Test
	public void testresetid() {
		modele.triergenre("drame");
		modele.trierid("4");
		modele.reset_id();
		ex.add(new Film("1","Fight Club","drame","2h19","1999","David Fincher","9.6","8","6","5","7","7")); 
		ex.add(new Film("2","Forrest Gump","drame","2h22","1994","Robert Zemeckis","7.6","9.4","8","7","5","7")); 
		ex.add(new Film("3","Roméo + Juliette","drame","2h00","1996","Baz Luhrmann","7.4","7.8","7","7","7","7")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}

	
	@Test
	public void testresetgenre() {
		modele.trierdurée("1h30", "asc");
		modele.triergenre("horreur");
		modele.reset_genre();
		ex.add(new Film("20","Le tombeau des lucioles","animation","1h29","1988","Isao Takahata","10","9.7","9","9","8.5","8")); 
		ex.add(new Film("22","mon Voisin Totoro","animation","1h26","1988","Hayao Himazaki","9.3","9.4","7.5","8","8.5","8")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	
	@Test
	public void testresetdureeasc() {
		modele.triergenre("aventure");
		modele.trierdurée("2h30", "asc");
		modele.reset_durée("asc");
		ex.add(new Film("26","Le seigneur des Anneaux: La Communauté de l'anneau","aventure","2h58","2001","Peter Jackson","9.1","8.5","6","8.5","9","7")); 
		ex.add(new Film("29","Le Seigneur des Anneaux: le Retour du Roi","aventure","3h21","2003","Peter Jackson","9.4","8.5","6","7.5","8.5","7"));
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testresetdureedesc() {
		modele.trierréa("Steven Spielberg");
		modele.trierdurée("2h00", "desc");
		modele.reset_durée("desc");
		ex.add(new Film("24","Les Aventuriers de l'Arche perdue","aventure","1h55","1981","Steven Spielberg","10","9.1","6.5","7.5","9","6")); 
		ex.add(new Film("27","Indiana Jones et le Temple maudit","aventure","1h58","1984","Steven Spielberg","7.7","8.5","6.5","7","8.5","6"));
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testresetanneeasc() {
		modele.triergenre("comédie");
		modele.trierannée("1994", "asc");
		modele.reset_annee("asc");
		ex.add(new Film("7","Le Fabuleux destin d'Amélie Poulain","comédie","2h02","2001","Jean-Pierre Jeunet","8.1","9","7","8.5","7","6")); 
		ex.add(new Film("8","Austins Powers: International Man of Mystery","comédie","1h34","1997","Jary Roach","7.3","8.7","5","6.5","7","6"));
		ex.add(new Film("10","L'auberge espagnol","comédie","2h02","2002","Cédric Klapisch","7.6","8","7","7","6.5","6"));
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testresetanneedesc() {
		modele.triergenre("horreur");
		modele.trierannée("2020", "desc");
		modele.reset_annee("desc");
		ex.add(new Film("35","Shining","horreur","2h26","1980","Stanley Kubrick","8.3","8.8","7.5","7","6.5","6")); 
		ex.add(new Film("36","Scream (1996)","horreur","1h51","1996","Wes Craven","8.1","8.6","7.5","7","8","5")); 
		ex.add(new Film("37","Massacre à la tronçonneuse (1974)","horreur","1h23","1974","Tobe Hooper","8.9","8.7","6","6.5","7","5")); 
		ex.add(new Film("38","Le Project Blair Witch","horreur","1h21","1999","Eduardo Sánchez,Daniel Myrick","8.6","7.9","5","8","9","5")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	@Test
	public void testresetrealisateur() {
		modele.triergenre("aventure");
		modele.trierréa("Steven Spielberg");
		modele.reset_réa(); 
		ex.add(new Film("26","Le seigneur des Anneaux: La Communauté de l'anneau","aventure","2h58","2001","Peter Jackson","9.1","8.5","6","8.5","9","7")); 
		ex.add(new Film("29","Le Seigneur des Anneaux: le Retour du Roi","aventure","3h21","2003","Peter Jackson","9.4","8.5","6","7.5","8.5","7"));
		ex.add(new Film("39","Super Mario Bros","aventure","1h44","1993","Annabel Jankel,Rocky Morton","2.9","6.1","4","5","4","6")); 
		Assert.assertEquals(true,modele.films_favoris.toString().contentEquals(ex.toString()));
	}
	
	
	
	
	
	
	




}



