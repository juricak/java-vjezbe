package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Sucelje koje dodaje nove funkcionalnosti potrebne za prodaju nekretnina.
 * @author Jurica
 *
 */
public interface Nekretnina {
	public static final BigDecimal porezFaktor = new BigDecimal("0.03");
	
public default BigDecimal izracunajPorez(BigDecimal cijena) {
		
	BigDecimal v0 = new BigDecimal(10000.00);
	if (cijena.compareTo(v0) == 0 || cijena.compareTo(v0) == -1) {
		throw new CijenaJePreniskaException(" Cijena ne smije biti manja od 10000kn!");
	}
		BigDecimal porez = cijena.multiply(porezFaktor);
	  
		return porez;
	} 
}
