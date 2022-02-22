package hr.java.vjezbe.entitet;

public class PrivatniKorisnik extends Korisnik {
	
	public String ime;
	public String prezime;
	
	/**
	 * Podklasa klase Korisnik.
	 * Predstavlja korisnika kao fizicku osobu.
	 * 
	 * @param email
	 * @param telefon
	 * @param ime
	 * @param prezime
	 */
	
	public PrivatniKorisnik(String email, String telefon, String ime, String prezime) {
		super(email, telefon);
		this.ime = ime;
		this.prezime = prezime;
	}
	
	
	public String getIme() {
		return ime;
	}




	public void setIme(String ime) {
		this.ime = ime;
	}




	public String getPrezime() {
		return prezime;
	}




	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	/**
	 * Nadjacava metodu dohvatiKontakt u klasi Korisnik. Sluzi za ispis informacija osobe.
	 */
	@Override
	public String dohvatiKontakt() {
		
		System.out.println("Kontakt: ");
		
		return " Ime: " + getIme() + "\n Prezime: " + getPrezime() +
				"\n e-mail: "+ getEmail() + "\n Telefon: " + getTelefon();

	}

}
