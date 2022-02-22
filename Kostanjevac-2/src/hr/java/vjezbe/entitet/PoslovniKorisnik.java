package hr.java.vjezbe.entitet;

public class PoslovniKorisnik extends Korisnik {
	
	public String naziv;
	public String web;

	
	public PoslovniKorisnik(String email, String telefon, String naziv, String web) {
		super(email, telefon);
		this.naziv = naziv;
		this.web = web;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}


	@Override
	public String dohvatiKontakt() {
		
		
		return " Naziv: " + getNaziv() + "\n Web: " + getWeb() +
				"\n e-mail: "+ getEmail() + "\n Telefon: " + getTelefon();

	}

}
