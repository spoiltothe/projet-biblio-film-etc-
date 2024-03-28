package film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public abstract class Type {
	public int score,duree;
	public enum Critere{ACTION, ADVENTURE, HISTORIQUE, FANTAISIE, HORROR, ROMANTIQUE, COMEDIE};
	
	public ArrayList<Critere> criteres;
	
	
	public int recommendation_score(Utilisateur u){
		//PriorityQueue<Integer> test= new PriorityQueue(Collections.reverseOrder());
		int score_dix=0;
		for (int i=0;i<10;i++) {
			//score_dix=0;
			for (int j=0; j<u.dix_dernier.get(i).criteres.size();j++) {
				if (this.criteres.contains(u.dix_dernier.get(i).criteres.get(j))) {
					score_dix=score_dix+this.score;
				}
			}
		}
		return score_dix;
		
	}
	

}