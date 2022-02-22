package hr.java.vjezbe.glavna;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.entitet.Usluga;
import hr.java.vjezbe.iznimke.CijenaJePreniskaException;
import hr.java.vjezbe.iznimke.NeispravanNaslovException;
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;



public class Glavna {

private static final Logger logger = LoggerFactory.getLogger(Glavna.class);
public static void main(String[] args) throws NemoguceOdreditiGrupuOsiguranjaException {
		
		Scanner tipkovnica = new Scanner(System.in);
		System.out.println("Unesite broj korisnika koji želite unijeti:");
		Integer brojKorisnika = unesiIntBroj(tipkovnica);
		Korisnik[] korisnici = new Korisnik[brojKorisnika];

		for (int i=1; i<=brojKorisnika; i++) {
				unesiKorisnika(tipkovnica, i, korisnici);
			}
		
		System.out.println("Unesite broj Kategorija koji želite unijeti:");
		Integer brojKategorija = unesiIntBroj(tipkovnica);
		tipkovnica.nextLine();
		
		Kategorija[] kategorije = new Kategorija[brojKategorija];
		
		for (int k=1; k<=brojKategorija; k++) {
			
			
			Kategorija novaKategorija = unesiKategoriju(tipkovnica, k);
			kategorije[k-1] = novaKategorija;
			
		}

		System.out.println("Unesite broj artikala koji su aktivno na prodaju:");
		Integer brojAktivnihProdaja = unesiIntBroj(tipkovnica);
		tipkovnica.nextLine();
		
		Prodaja[] dostupniArtikli = new Prodaja[brojAktivnihProdaja];
		
		for (int k=1; k<=brojAktivnihProdaja; k++) {
			
			System.out.println("Odaberite korisnika:");
			
			for (int i=1; i<=korisnici.length; i++) {
				
				System.out.println( i + "." + korisnici[i-1].dohvatiKontakt());
				
			}
			System.out.println("Odabir >>");
			Integer korisnikIndex = unesiIntBroj(tipkovnica);
			//odabirKorisnika(tipkovnica, korisnici);

		System.out.println("Odaberite kategoriju:");
		
		for (int i=1; i<=kategorije.length; i++) {
			
			System.out.println(i + ". " + kategorije[i-1].getNaziv() );
		}
		System.out.println("Odabir >>");
		Integer kategorijeIndex = unesiIntBroj(tipkovnica);
		//odabirKategorije(tipkovnica, kategorije);
		
		Korisnik odabraniKorisnik = korisnici[korisnikIndex-1];
		Kategorija odabranaKategorija = kategorije[kategorijeIndex-1];
		Artikl[] odabirArtikli = odabranaKategorija.getArtikli();
		
		for(int i=1; i<=odabirArtikli.length; i++) {
			
			System.out.println("Odaberite artikl: ");
			System.out.println(i + ". " + odabirArtikli[i-1].getNaslov());

		}
		System.out.println("Odabir >>");
		Integer artiklIndex = unesiIntBroj(tipkovnica);
		//odabirArtikla(tipkovnica, odabraniArtikli);

		LocalDate datumObjave = LocalDate.now();
		
		Artikl odabraniArtikli = odabirArtikli[artiklIndex-1];
		Prodaja novaProdaja = new Prodaja(odabraniArtikli,odabraniKorisnik,datumObjave);
		dostupniArtikli[k-1] = novaProdaja;
		
		}
		
		for(Prodaja prodajaArtikl : dostupniArtikli) {
			
			Artikl odabraniArtikli = prodajaArtikl.getArtikl();
			Korisnik odabraniKorisnik = prodajaArtikl.getKorisnik();
			System.out.println("__________________________________________________");
			try {
			System.out.println(odabraniArtikli.tekstOglasa());
				}catch(NemoguceOdreditiGrupuOsiguranjaException ex1) {
					System.out.println(" Cijena Osiguranja: Previše kw, nije moguce odrediti grupu osiguranja!");
					logger.error("Pogreška prilikom odredivanja cijene osiguranja!", ex1);
				}catch(CijenaJePreniskaException ex2) {
					System.out.println(" Porez: Pogreška prilikom odredivanja iznosa poreza! Cijena ne smije biti manja od 10000kn");
					logger.error("Pogreška prilikom odredivanja iznosa poreza!", ex2);
				}
			System.out.println(" Datum objave: "+prodajaArtikl.getDatumObjave());
			System.out.println(odabraniKorisnik.dohvatiKontakt());
			System.out.println("__________________________________________________");
			
		}  
		
		
	tipkovnica.close();
		
}

/**
 * Metoda predstavlja odabr vrste korisnika i finalizira unos
 * @param tipkovnica
 * @param i
 * @param korisnici
 * @return Polje korisnici
 */
	private static Korisnik[] unesiKorisnika(Scanner tipkovnica, int i, Korisnik[] korisnici) {
		
		boolean nastaviPetlju = false;
		do {
			try {
		
		System.out.println("Odaberite tip korisnika "+ i +":");
		System.out.println("1. Privatni");
		System.out.println("2. Poslovni");
		System.out.println("Odabir >>");
		
		Integer tipKorisnika = unesiIntBroj(tipkovnica);
		
		
		if(tipKorisnika == 1) {
			korisnici[i-1] = (PrivatniKorisnik) unesiPrivatnogKorisnika(tipkovnica, i);
			nastaviPetlju = false;
		} else if(tipKorisnika == 2) {
			korisnici[i-1] = (PoslovniKorisnik) unesiPoslovnogKorisnika(tipkovnica, i);
			nastaviPetlju = false;
		}else {
			throw new ArrayIndexOutOfBoundsException("Ne postoji opcija pod tim brojem.");
			
		}
			}catch(ArrayIndexOutOfBoundsException ex1) {
				System.out.println("Ne postoji opcija pod tim brojem.");
				logger.info("Nevazeci odabir tipa korisnika!");
				logger.info(ex1.getMessage(), ex1);
				nastaviPetlju = true;
			}
		} while(nastaviPetlju == true);
		return  korisnici;	
}
/**
 * Metoda za unos cijelih brojeva
 * @param tipkovnica
 * @return cijeli broj
 */
	private static Integer unesiIntBroj(Scanner tipkovnica) {
		
		boolean nastaviPetlju = false;
		Integer broj = 0;
		brojLoop:
		do {
			try {
				broj = tipkovnica.nextInt();
				logger.info("Unesen je broj " + broj);
				nastaviPetlju = false;
				break brojLoop;
			}catch(InputMismatchException ex1) {
				System.out.println("Morate unijeti cijeli broj.");
				tipkovnica.nextLine();
				logger.error("Pogreška prilikom unosa int tipa podatka", ex1);
				//logger.error(ex1.getMessage(), ex1);
				nastaviPetlju = true;
				
			}
		} while(nastaviPetlju == true);
		return broj;
	
}
/** 
 * Metoda za unos brojeva s dvije decimale
 * @param tipkovnica
 * @return broj
 */
	private static BigDecimal unesiBigDecimalBroj(Scanner tipkovnica) {

		
		boolean nastaviPetlju = false;
		BigDecimal broj = new BigDecimal(0);
		brojLoop:
		do {
			try {
				broj = tipkovnica.nextBigDecimal();
				logger.info("Unesen je broj " + broj);
				nastaviPetlju = false;
				break brojLoop;
			}catch(InputMismatchException ex1) {
				System.out.println("Morate unijeti broj.");
				tipkovnica.nextLine();
				logger.info("Pogreška prilikom unosa BigDecimal tipa podatka ", ex1);
				nastaviPetlju = true;
			}
		} while(nastaviPetlju == true);
		return broj;
	
}
	/**
	 * Metoda za unos kategorije i finaliziranje unosa artikala
	 * @param tipkovnica
	 * @param k
	 * @return Polja kategorije
	 */
	private static Kategorija unesiKategoriju(Scanner tipkovnica, int k) {
		System.out.println("Unesite naziv "+ k +". kategorije: ");
		String naziv = tipkovnica.nextLine();
		
		System.out.println("Unesite broj artikala koji želite unijeti:");
		Integer brojArtikl = unesiIntBroj(tipkovnica);
		tipkovnica.nextLine();
		
		Artikl[] artikli = new Artikl[brojArtikl];
		
		for (int i=1; i<=brojArtikl; i++ ) {
			
			boolean nastaviPetlju = false;
			do {
				try {
			
			System.out.println("Odaberite tip artikla"+ i +":");
			System.out.println("1.  Usluga");
			System.out.println("2.  Automobil");
			System.out.println("3.  Stan");
			System.out.println("Odabir >>");
			
			Integer tipArtikla = unesiIntBroj(tipkovnica); 
			tipkovnica.nextLine();
			
			if(tipArtikla == 1) {
				artikli[i-1] = (Usluga) unesiUslugu(tipkovnica, i);
				nastaviPetlju = false;
			}else if (tipArtikla == 2) {
				artikli[i-1] = (Automobil) unesiAutomobil(tipkovnica, i);
				nastaviPetlju = false;
			}else if (tipArtikla == 3) {
				artikli[i-1] = (Stan) unesiStan(tipkovnica, i);
				nastaviPetlju = false;
			}else {
				throw new NullPointerException("Ne postoji opcija pod tim brojem.");
			}
			}catch(NullPointerException ex1) {
				System.out.println("Ne postoji opcija pod tim brojem.");
				logger.error("Ne postoji opcija pod tim brojem.", ex1);;
				nastaviPetlju = true;
			}
		} while(nastaviPetlju == true);			
		}
		Kategorija kategorije = new Kategorija(naziv, artikli);
		return kategorije;
}
	
/**
 * Metoda za unos stanova
 * @param tipkovnica
 * @param i
 * @return objekt stan
 */
	private static Stan unesiStan(Scanner tipkovnica, int i) {
		
		
		String naslov = unesiNaslov(tipkovnica, i);
		System.out.println("Unesite opis " + i + " stana.");
		String opis = tipkovnica.next();
		System.out.println("Unesite cijenu " + i + " stana.");
		BigDecimal cijena = unesiBigDecimalBroj(tipkovnica);
		System.out.println("Unesite kvadraturu " + i + " stana.");
		int kvadratura = unesiIntBroj(tipkovnica);
		
		Artikl stan = new Stan(naslov, opis, cijena, kvadratura);
		
		return (Stan) stan;
	}

/**
 * Metoda provjerava dali je unesen naslov po zadanim specifikacijama (najmanje 3 slova, bez brojeva)
 * @param tipkovnica
 * @param i
 * @return naslov
 */
private static String unesiNaslov(Scanner tipkovnica, int i) {
	boolean nastaviPetlju = false;
	
	String test = null;
	
	do {
		try {
		nastaviPetlju = false;
		System.out.println("Unesite naslov " + i + " stana.");
		test = tipkovnica.next();
		logger.info("Unesen je naslov... " + test);
		if (! test.matches("[ a-zA-Z]{3,30}")) {
			nastaviPetlju = true;
			throw new NeispravanNaslovException("Neispravan naslov!!!");
		}
		} catch(NeispravanNaslovException ex1){
			System.out.println("Morate unijeti pravilni naslov.Naslov mora sadržavati najmanje 3 znaka bez brojeva");
			tipkovnica.nextLine();
			logger.error("Unesen je neispravan naslov!! Naslov mora sadržavati najmanje 3 znaka bez brojeva!", ex1);
		}
	}while (nastaviPetlju == true);
	return test;
}

/**
 * Metoda za unos automobila
 * @param tipkovnica
 * @param i
 * @return objekt automobil
 */
	private static Automobil unesiAutomobil(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite naslov " + i + " automobila.");
		String naslov = tipkovnica.next();
		System.out.println("Unesite opis " + i + " automobila.");
		String opis = tipkovnica.next();
		System.out.println("Unesite cijena " + i + " automobila.");
		BigDecimal cijena = unesiBigDecimalBroj(tipkovnica);
		System.out.println("Unesite snagu " + i + " automobila.");
		BigDecimal snagaKs = unesiBigDecimalBroj(tipkovnica);
		
		Artikl automobil = new Automobil(naslov, opis, cijena, snagaKs);
		
	return (Automobil) automobil;
}
/**
 * Metoda za unos usluge
 * @param tipkovnica
 * @param i
 * @return objekt usluga
 */
	private static Usluga unesiUslugu(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite naslov " + i + " usluge.");
		String naslov = tipkovnica.next();
		System.out.println("Unesite opis " + i + " usluge.");
		String opis = tipkovnica.next();
		System.out.println("Unesite cijena " + i + " usluge.");
		BigDecimal cijena = unesiBigDecimalBroj(tipkovnica);
		
		Artikl usluga = new Usluga(naslov, opis, cijena);
	return (Usluga) usluga;
}
/**
 * Metoda za unos poslovnih korisnika
 * @param tipkovnica
 * @param i
 * @return objekt poslovniKorisnik
 */
	private static PoslovniKorisnik unesiPoslovnogKorisnika(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite naziv " + i + " firme.");
		String naziv = tipkovnica.next();
		System.out.println("Unesite web " + i + " firme.");
		String web = tipkovnica.next();
		System.out.println("Unesite e-mail " + i + " firme.");
		String email = tipkovnica.next();
		System.out.println("Unesite telefon " + i + " firme.");
		String telefon = tipkovnica.next();
		
		Korisnik korisnici = new PoslovniKorisnik(email, telefon, naziv, web);
	return (PoslovniKorisnik) korisnici; 
}

		
/**
 * Metoda za unos privatnih korisnika
 * @param tipkovnica
 * @param i
 * @return objekt privatniKorisnik
 */
	private static Korisnik unesiPrivatnogKorisnika(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite ime " + i + " korisnika.");
		String ime = tipkovnica.next();
		System.out.println("Unesite prezime " + i + " korisnika.");
		String prezime = tipkovnica.next();
		System.out.println("Unesite e-mail " + i + " korisnika.");
		String email = tipkovnica.next();
		System.out.println("Unesite telefon " + i + " korisnika.");
		String telefon = tipkovnica.next();
		
		Korisnik korisnici = new PrivatniKorisnik(email, telefon, ime, prezime);
		return (PrivatniKorisnik) korisnici;
	}
	
	

}
