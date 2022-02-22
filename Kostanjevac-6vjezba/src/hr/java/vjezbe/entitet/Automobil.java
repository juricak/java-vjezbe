package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

public class Automobil extends Artikl implements Vozilo{
	
	public BigDecimal snagaKs;
	
	
	
	/**
	 * Podklasa klase Artikl implementira sucelje Vozilo, predstavlja automobil.
	 * @param naslov
	 * @param opis
	 * @param cijena
	 * @param snagaKs
	 */
	public Automobil(String naslov, String opis, Stanje stanje, BigDecimal cijena, BigDecimal snagaKs) {
		super(naslov, opis, stanje, cijena);
		this.snagaKs = snagaKs;
		
	}

	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}

	

	@Override
	public int izracunajGrupuOsiguranja(BigDecimal snagaKw) throws NemoguceOdreditiGrupuOsiguranjaException {
		
		
		int grupa = 0;		
		
		BigDecimal v0 = new BigDecimal("350");
		BigDecimal v1 = new BigDecimal("60");
		BigDecimal v2 = new BigDecimal("120");
		BigDecimal v3 = new BigDecimal("180");
		BigDecimal v4 = new BigDecimal("240");
		
		if (snagaKw.compareTo(v1) == 0 || snagaKw.compareTo(v1) == -1) {
			grupa = grupa + 1;
		}else if (snagaKw.compareTo(v2) == 0 || snagaKw.compareTo(v2) == -1) {
			grupa = grupa + 2;
		}else if (snagaKw.compareTo(v3) == 0 || snagaKw.compareTo(v3) == -1) {
			grupa = grupa + 3;
		}else if (snagaKw.compareTo(v4) == 0 || snagaKw.compareTo(v4) == -1) {
			grupa = grupa + 4;
		}else if (snagaKw.compareTo(v0) == 0 || snagaKw.compareTo(v0) == -1) {
			grupa = grupa + 5;
		}else {
			throw new NemoguceOdreditiGrupuOsiguranjaException("Nemoguce Odrediti Grupu Osiguranja!!");
		}
		
		
		return grupa;
	}
	
	@Override
	public String tekstOglasa() throws NemoguceOdreditiGrupuOsiguranjaException {
		System.out.println(" Naslov: " + getNaslov());
		System.out.println(" Opis: " + getOpis());
		System.out.println(" Stanje: " + getStanje().name());
		System.out.println(" Snaga: " + getSnagaKs());
		System.out.println(" Cijena: " + getCijena());
		//System.out.println(" Cijena Osiguranja " + izracunajCijenuOsiguranja(izracunajGrupuOsiguranja(izracunajKw(snagaKs))));
		
		return  " Cijena Osiguranja: " + izracunajCijenuOsiguranja(izracunajGrupuOsiguranja(izracunajKw(snagaKs)));
		
		
		}
	}


