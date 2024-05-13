package javamodelefinal;

import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class DossierReader {
public ArrayList<ImageIcon> liens;

public DossierReader() {
	this.liens = new ArrayList<ImageIcon>(); 
}

public ArrayList<ImageIcon> charger() {
	 File dossier = new File("D:\\\\Users\\\\Affiches_films"); 
     File[] fichiers = dossier.listFiles();
     System.out.println(fichiers);
     if (fichiers != null) {
         for (File fichier : fichiers) {
             if (fichier.isFile()) {
                 ImageIcon imageIcon = new ImageIcon(fichier.getAbsolutePath());
                 System.out.println(imageIcon); 
                 this.liens.add(imageIcon);
                 
             }
         }
     }
     return this.liens; 
}

public static void main(String[] args) throws Exception  {
	DossierReader d = new DossierReader(); 
	d.charger(); 
	
}
}
