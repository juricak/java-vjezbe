package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import test.comparator.Aircraft;
import test.comparator.CompDep;

public class Main {

	

	public static void main(String[] args) {
		
		
	/*	Vector v = new Vector();
		
		
		v.add(16);
		v.add(6);
		v.add(26);
		v.add(6);
		v.add(46);
		v.add(6);
		v.add(6);
		v.add(76);
		v.add(6);
		v.add(6);
		v.add(26);
		v.add(6);
		v.add(86);
		v.add(62);
		v.add(6);
		
		
		System.out.println(v.capacity()); */
		List<Aircraft> list = new ArrayList<Aircraft>();
		
		Aircraft aircraft;
		
		list.add(aircraft = new Aircraft("bf 109", 450, 900));
		list.add(aircraft = new Aircraft("mustang", 500, 1200));
		list.add(aircraft = new Aircraft("me 262", 650, 1500));
		list.add(aircraft = new Aircraft("b 17", 400, 9000));
		list.add(aircraft = new Aircraft("spitfire", 450, 1000));
		list.add(aircraft = new Aircraft("stork", 200, 500));
		
		
		Comparator<Aircraft> com = new CompDep();
		Collections.sort(list, com);
		//Collections.reverse(list);
		
		for (Aircraft air : list) {
		System.out.println(air.getName() + " " + air.getSpeed() + " " + air.getWeight() + " ");

		}
		
	}

}
