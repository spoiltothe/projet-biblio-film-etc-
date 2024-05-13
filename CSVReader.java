package javamodelefinal;
 
import java.io.BufferedReader;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSVReader {
public ArrayList<List<String>> data;
public ArrayList<Film> films; 
public CSVReader() { 
	this.films = new ArrayList<Film>(); 
	this.data = new ArrayList<List<String>>(); 
}

public ArrayList<Film> lire() throws IOException{
	File csvfile= new File("D:\\Users\\\\test.csv"); 
	BufferedReader br = new BufferedReader(new FileReader(csvfile)); 
	String line = ""; 
	try {
		while ((line = br.readLine()) != null) {
	
			String[] ensemble = line.split(";");
			data.add(Arrays.asList(ensemble));  
			
			 
			 
			 
		     
		}
		br.close(); 
	
	}
	
		 catch (FileNotFoundException e) {
				e.printStackTrace(); 
			}
	


	for (int i=1; i<this.data.size(); i++) {
		Film f = new Film(data.get(i).get(0),data.get(i).get(1),data.get(i).get(2),data.get(i).get(3),data.get(i).get(4),data.get(i).get(5),data.get(i).get(6),data.get(i).get(7),data.get(i).get(8),data.get(i).get(9),data.get(i).get(10),data.get(i).get(11) );
		this.films.add(f);
	}
			
		
		
	
	
	return this.films; 
	
}

public static void main(String[] args) throws Exception  {
	
	
}

}




