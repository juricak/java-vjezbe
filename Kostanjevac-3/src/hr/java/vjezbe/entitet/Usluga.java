package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Usluga extends Artikl {
/**
 * Podklasa klase artikl.
 * 
 * Predstavlja vrstu artikla, usluga na prodaju
 * 
 * @param naslov
 * @param opis
 * @param cijena
 */
	public Usluga(String naslov, String opis, BigDecimal cijena) {
		super(naslov, opis, cijena);
	}
	/**
	 * Nadjacana metoda za ispis teksta oglasa iz abstraktne klase Artikl
	 */
	@Override
	public String tekstOglasa() {
		return "Naslov: " + getNaslov() + "\n Opis: " + getOpis()  + "\n Cijena: " + getCijena();
	
	}

}
