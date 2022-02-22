package hr.java.vjezbe.entitet;

public class PoslovniKorisnik extends Korisnik {
	
	public String naziv;
	public String web;

	/**
	 * Podklasa klase Korisnik.
	 * Predstavlja korisnika kao pravnu osobu.
	 * @param email
	 * @param telefon
	 * @param naziv
	 * @param web
	 */
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

/**
 * Nadjacava metodu dohvatiKontakt u klasi Korisnik. Sluzi za ispis informacija firme.
 */
	@Override
	public String dohvatiKontakt() {
		
		System.out.println("Kontakt: ");
		
		return " Naziv: " + getNaziv() + "\n Web: " + getWeb() +
				"\n e-mail: "+ getEmail() + "\n Telefon: " + getTelefon();

	}

}
