package hr.java.vjezbe.sortiranje;

import java.util.Comparator;


import hr.java.vjezbe.entitet.Kategorija;

public class KategorijaSorter implements Comparator<Kategorija> {

	
		@Override
		public int compare(Kategorija ka1, Kategorija ka2) {
			
			int comparison = 0;
			comparison = ka1.getSifra().compareTo(ka2.getSifra());
			
			if (comparison == 0) {
				
				comparison = ka1.getNaziv().compareTo(ka2.getNaziv());
				
			}
		     
		        return comparison; 
		    

	}
}


