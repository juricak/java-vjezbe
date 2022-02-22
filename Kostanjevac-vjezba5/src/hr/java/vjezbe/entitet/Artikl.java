package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

public abstract class Artikl {
	
	private String naslov;
	private String opis;
	private Stanje stanje;
	public BigDecimal cijena;
	/**
	 * Abstraktna klasa koja predstavlja artikle na prodaju
	 * @param naslov
	 * @param opis
	 * @param cijena
	 */
	public Artikl(String naslov, String opis, Stanje stanje, BigDecimal cijena) {
		super();
		this.naslov = naslov;
		this.opis = opis;
		this.stanje = stanje;
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

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
		result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((stanje == null) ? 0 : stanje.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (cijena == null) {
			if (other.cijena != null)
				return false;
		} else if (!cijena.equals(other.cijena))
			return false;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} else if (!naslov.equals(other.naslov))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (stanje == null) {
			if (other.stanje != null)
				return false;
		} else if (!stanje.equals(other.stanje))
			return false;
		return true;
	}
	
}