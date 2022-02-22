package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

public abstract class Artikl {
	
	private String naslov;
	private String opis;
	public BigDecimal cijena;
	/**
	 * Abstraktna klasa koja predstavlja artikle na prodaju
	 * @param naslov
	 * @param opis
	 * @param cijena
	 */
	public Artikl(String naslov, String opis, BigDecimal cijena) {
		super();
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public BigDecimal getCijena() {
		return cijena;
	}
	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	/**
	 * Abstraktna metoda za ispis teksta oglasa
	 * @return
	 * @throws NemoguceOdreditiGrupuOsiguranjaException
	 */
	public abstract String tekstOglasa() throws NemoguceOdreditiGrupuOsiguranjaException;
}
