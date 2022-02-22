package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Automobil extends Artikl implements Vozilo{
	
	public BigDecimal snagaKs;
	
	
	
	
	public Automobil(String naslov, String opis, BigDecimal cijena, BigDecimal snagaKs) {
		super(naslov, opis, cijena);
		this.snagaKs = snagaKs;
		
	}

	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}

	

	@Override
	public int izracunajGrupuOsiguranja(BigDecimal snagaKw) {
		
		
		int grupa = 0;		
		
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
		}else {
			grupa = grupa + 5;
		}
		
		
		return grupa;
	}
	
	@Override
	public String tekstOglasa() {
		
		
		return " Naslov: " + getNaslov() + "\n Opis: " + getOpis() + "\n Snaga: " + getSnagaKs() + "\n Cijena: " + getCijena() + "\n Cijena Osiguranja " + izracunajCijenuOsiguranja(izracunajGrupuOsiguranja(izracunajKw(snagaKs)));
	}

}
