package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;
/**
 * Sucelje koje dodaje nove funkcionalnosti potrebne za prodaju vozila.
 * @author Jurica
 *
 */
public interface Vozilo {
	
	public static final BigDecimal kwConversion = new BigDecimal("0.74");
	
	
	public default BigDecimal izracunajKw(BigDecimal snagaKs) {
		
		BigDecimal snagaKw = snagaKs.multiply(kwConversion);
		
		
		  
		return snagaKw;
	} 
	
	public int izracunajGrupuOsiguranja(BigDecimal snagaKw) throws NemoguceOdreditiGrupuOsiguranjaException;
	
	public default BigDecimal izracunajCijenuOsiguranja(int grupa) {
		
		BigDecimal cijenaOsiguranja = new BigDecimal(0);
		BigDecimal v1 = new BigDecimal(300.00);
		BigDecimal v2 = new BigDecimal(400.00);
		BigDecimal v3 = new BigDecimal(600.00); 
		BigDecimal v4 = new BigDecimal(900.00);
		BigDecimal v5 = new BigDecimal(1500.00);
		
		switch (grupa) {
		case 1:
			cijenaOsiguranja = cijenaOsiguranja.add(v1);
		break;
		case 2:
			cijenaOsiguranja = cijenaOsiguranja.add(v2);
		break;
		case 3:
			cijenaOsiguranja = cijenaOsiguranja.add(v3);
		break;
		case 4:
			cijenaOsiguranja = cijenaOsiguranja.add(v4);
		break;
		case 5:
			cijenaOsiguranja = cijenaOsiguranja.add(v5);
		break;
		default:
		System.out.println("greška");
		break;
			
		
		}
		
		return cijenaOsiguranja;
}

	
}

	

