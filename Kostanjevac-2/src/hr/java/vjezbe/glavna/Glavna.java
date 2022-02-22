package hr.java.vjezbe.glavna;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.entitet.Usluga;



public class Glavna {


public static void main(String[] args) {
		
		Scanner tipkovnica = new Scanner(System.in);
		System.out.println("Unesite broj korisnika koji želite unijeti:");
		Integer brojKorisnika = tipkovnica.nextInt();
		tipkovnica.nextLine();
		
		Korisnik[] korisnici = new Korisnik[brojKorisnika];
		
		
		
		for (int i=1; i<=brojKorisnika; i++) {
			System.out.println("Odaberite tip korisnika"+ i +":");
			System.out.println("1. Privatni");
			System.out.println("2. Poslovni");
			System.out.println("Odabir >>");
			
			Integer tipKorisnika = tipkovnica.nextInt();
			tipkovnica.nextLine();
			
			if(tipKorisnika == 1) {
				korisnici[i-1] = (PrivatniKorisnik) unesiPrivatnogKorisnika(tipkovnica, i);
			} else if(tipKorisnika == 2) {
				korisnici[i-1] = (PoslovniKorisnik) unesiPoslovnogKorisnika(tipkovnica, i);
			}else {
				System.out.println("pogreška");
			}
			
			}
		System.out.println("Unesite broj Kategorija koji želite unijeti:");
		Integer brojKategorija = tipkovnica.nextInt();
		tipkovnica.nextLine();
		
		Kategorija[] kategorije = new Kategorija[brojKategorija];
		
		for (int i=1; i<=brojKategorija; i++) {
			
			Kategorija novaKategorija = unesiKategoriju(tipkovnica, i);
			kategorije[i-1] = novaKategorija;
			
		}
		
		
		System.out.println("Unesite broj artikala koji su aktivno na prodaju:");
		Integer brojAktivnihProdaja = tipkovnica.nextInt();
		tipkovnica.nextLine();
		
		Prodaja[] dostupniArtikli = new Prodaja[brojAktivnihProdaja];
		
		for (int i=1; i<=brojAktivnihProdaja; i++) {
			
			System.out.println("Odaberite korisnika:");
			
			for (int j=1; j<=korisnici.length; j++) {
				
				System.out.println( i + "." + korisnici[i-1].dohvatiKontakt());
				
			}
			
			System.out.println("Odabir >>");
			Integer korisnikIndex = tipkovnica.nextInt();
			tipkovnica.nextLine();
			
			
		
		
		System.out.println("Odaberite kategoriju:");
		
		for (int j=1; j<=kategorije.length; j++) {
			
			System.out.println(j + ". " + kategorije[j-1].getNaziv() );
		}
		
		System.out.println("Odabir >>");
		Integer kategorijeIndex = tipkovnica.nextInt();
		tipkovnica.nextLine();
		
		
		Korisnik odabraniKorisnik = korisnici[korisnikIndex-1];
		Kategorija odabranaKategorija = kategorije[kategorijeIndex-1];
		Artikl[] odabraniArtikli = odabranaKategorija.getArtikli();
		
		for(int k=1; k<=odabraniArtikli.length; k++) {
			
			System.out.println("Odaberite artikl: ");
			System.out.println(i + ". " + odabraniArtikli[i-1].getNaslov());
			

		}
		
		System.out.println("Odabir >>");
		Integer artiklIndex = tipkovnica.nextInt(); 
		tipkovnica.nextLine();
		

		
		LocalDate datumObjave = LocalDate.now();
		
		Prodaja novaProdaja = new Prodaja(odabraniArtikli[artiklIndex-1],odabraniKorisnik,datumObjave);
		dostupniArtikli[i-1] = novaProdaja;
		
		}
		
		for(Prodaja prodajaArtikl : dostupniArtikli) {
			
			Artikl odabraniArtikli = prodajaArtikl.getArtikl();
			Korisnik odabraniKorisnik = prodajaArtikl.getKorisnik();
			System.out.println("__________________________________________________");
			System.out.println(" Datum objave: "+odabraniArtikli.tekstOglasa());
			System.out.println(prodajaArtikl.getDatumObjave());
			System.out.println(odabraniKorisnik.dohvatiKontakt());
			System.out.println("__________________________________________________");
			
		}  
		
		
	tipkovnica.close();
		
}

	private static Kategorija unesiKategoriju(Scanner tipkovnica, int k) {
		System.out.println("Unesite naziv "+ k +". kategorije: ");
		String naziv = tipkovnica.nextLine();
		
		System.out.println("Unesite broj artikala koji želite unijeti:");
		Integer brojArtikl = tipkovnica.nextInt();
		tipkovnica.nextLine();
		
		Artikl[] artikli = new Artikl[brojArtikl];
		
		for (int i=1; i<=brojArtikl; i++ ) {
			
			System.out.println("Odaberite tip artikla"+ i +":");
			System.out.println("1.  Usluga");
			System.out.println("2.  Automobil");
			System.out.println("Odabir >>");
			
			Integer tipArtikla = tipkovnica.nextInt();
			tipkovnica.nextLine();
			
			if(tipArtikla == 1) {
				artikli[i-1] = (Usluga) unesiUslugu(tipkovnica, i);
			}else if (tipArtikla == 2) {
				artikli[i-1] = (Automobil) unesiAutomobil(tipkovnica, i);
			}else {
				System.out.println("pogreška");
			}			
		}
		Kategorija novaKategorija = new Kategorija(naziv, artikli);
		return novaKategorija;
}

	private static Automobil unesiAutomobil(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite naslov " + i + " automobila.");
		String naslov = tipkovnica.next();
		System.out.println("Unesite opis " + i + " automobila.");
		String opis = tipkovnica.next();
		System.out.println("Unesite cijena " + i + " automobila.");
		BigDecimal cijena = tipkovnica.nextBigDecimal();
		System.out.println("Unesite snagu " + i + " automobila.");
		BigDecimal snagaKs = tipkovnica.nextBigDecimal();
		
		Artikl automobil = new Automobil(naslov, opis, cijena, snagaKs);
		
	return (Automobil) automobil;
}

	private static Usluga unesiUslugu(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite naslov " + i + " usluge.");
		String naslov = tipkovnica.next();
		System.out.println("Unesite opis " + i + " usluge.");
		String opis = tipkovnica.next();
		System.out.println("Unesite cijena " + i + " usluge.");
		BigDecimal cijena = tipkovnica.nextBigDecimal();
		
		Artikl usluga = new Usluga(naslov, opis, cijena);
	return (Usluga) usluga;
}

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
		return (Korisnik) korisnici;
	}
	
	

}
