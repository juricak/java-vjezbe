package hr.java.vjezbe.entitet;


import java.util.Set;

public class Kategorija  {
	
	private String naziv;
	public Set<Artikl> artikli;
	private String sifra;
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Artikl> getArtikli() {
		return artikli;
	}

	public void setArtikli(Set<Artikl> artikli) {
		this.artikli = artikli;
	}
	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		Kategorija other = (Kategorija) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

/**
 * Klasa Kategorija sluzi za grupiranje artikala
 * @param naziv
 * @param artikli
 */
	public Kategorija(String naziv, Set<Artikl> artikli, String sifra) {
		super();
		this.naziv = naziv;
		this.artikli = artikli;
		this.setSifra(sifra);
	}



}
