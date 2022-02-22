package test.comparator;

import java.util.Comparator;

public class CompDep implements Comparator<Aircraft> {

	

	@Override
	public int compare(Aircraft o1, Aircraft o2) {
		
		if (o1.getSpeed().compareTo(o2.getSpeed()) == 0) {
			return o1.getName().compareTo(o2.getName());
		}else {
			
			return o2.getSpeed().compareTo(o1.getSpeed());
		}
	}

}
