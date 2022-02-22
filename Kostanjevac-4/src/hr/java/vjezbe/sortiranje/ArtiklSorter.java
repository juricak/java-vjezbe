package hr.java.vjezbe.sortiranje;

import java.util.Comparator;

import hr.java.vjezbe.entitet.Artikl;

public class ArtiklSorter implements Comparator<Artikl> {

	@Override
	public int compare(Artikl ar1, Artikl ar2) {
		
		int comparison = 0;
		comparison = ar1.getNaslov().compareTo(ar2.getNaslov());
		
		if (comparison == 0) {
			
			comparison = ar1.getOpis().compareTo(ar2.getOpis());
			
		}
	     
	        return comparison; 
	    

}
}