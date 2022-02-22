package hr.java.vjezbe.entitet;

public abstract class Korisnik {
	
	
	private String email;
	private String telefon;
	/**
	 * Abstraktna klasa koja predstavlja korisnike programa
	 * @param email
	 * @param telefon
	 */
	public Korisnik(String email, String telefon) {
		super();
		this.email = email;
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	/**
	 * Abstraktna metoda za ispis kontakta korisnika
	 * @return
	 */
	public abstract String dohvatiKontakt();
	
	
}
	
