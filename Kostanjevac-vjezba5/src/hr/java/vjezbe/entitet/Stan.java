package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;


public class Stan extends Artikl implements Nekretnina {
	
	private Integer kvadratura;
/**
 * Podklasa klase Artikl implementira sucelje Nekretnina, predstavlja stan.
 * @param naslov
 * @param opis
 * @param cijena
 * @param kvadratura
 */
public Stan(String naslov, String opis, Stanje stanje, BigDecimal cijena, Integer kvadratura) {
	super(naslov, opis, stanje, cijena);
	this.kvadratura = kvadratura;
}
	

	
public Integer getKvadratura() {
	return kvadratura;
}



public void setKvadratura(Integer kvadratura) {
	this.kvadratura = kvadratura;
}



/**
 * Nadjacana metoda za ispis teksta oglasa iz abstraktne klase Artikl.
 * Moze baciti CijenaJePreniskaException
 */
	@Override
	public String tekstOglasa() throws  CijenaJePreniskaException {
		
		System.out.println(" Naslov: " + getNaslov());
		System.out.println(" Opis: " + getOpis());
		System.out.println(" Stanje: " + getStanje().name());
		System.out.println(" Cijena: " + getCijena());
		
		return  " Porez: " + izracunajPorez(getCijena());
	}





}
