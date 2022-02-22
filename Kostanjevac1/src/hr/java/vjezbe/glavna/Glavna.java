package hr.java.vjezbe.glavna;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.Prodaja;



public class Glavna {


public static void main(String[] args) {
		
		Scanner tipkovnica = new Scanner(System.in);
		System.out.println("Unesite broj korisnika koji želite unijeti:");
		Integer brojKorisnika = tipkovnica.nextInt();
		
		Korisnik[] korisnici = new Korisnik[brojKorisnika];
		
		for (int i=1; i<=brojKorisnika; i++) {
			
			Korisnik noviKorisnik = unesiKorisnika(tipkovnica, i);
			korisnici[i-1] = noviKorisnik;
			}
		
		System.out.println("Unesite broj kategorija koji želite unijeti:");
		Integer brojKategorija = tipkovnica.nextInt();
		
		Kategorija[] kategorije = new Kategorija[brojKategorija];
		
		for (int i=1; i<=brojKategorija; i++) {
			
			Kategorija novaKategorija = unesiKategoriju(tipkovnica, i);
			kategorije[i-1] = novaKategorija;
		}
		
		System.out.println("Unesite broj artikala koji su aktivno na prodaju:");
		Integer brojAktivnihProdaja = tipkovnica.nextInt();
		
		Prodaja[] dostupniArtikli = new Prodaja[brojAktivnihProdaja];
		
		for (int i=1; i<=brojAktivnihProdaja; i++) {
			
			System.out.println("Odaberite korisnika:");
			
			for (int j=1; j<=korisnici.length; j++) {
				
				System.out.println( j + "." + korisnici[j-1].getIme() + "  " + korisnici[j-1].getPrezime());
				
			}
			
			System.out.println("Odabir >>");
			Integer korisnikIndex = tipkovnica.nextInt();
			
			
			
			System.out.println("Odaberite kategoriju:");
			
			for (int j=1; j<=kategorije.length; j++) {
				
				System.out.println(j + ". " + kategorije[j-1].getNaziv() );
				
			}
			
			System.out.println("Odabir >>");
			Integer kategorijeIndex = tipkovnica.nextInt(); 
			
			Korisnik odabraniKorisnik = korisnici[korisnikIndex-1]; 
			Kategorija odabranaKategorija = kategorije[kategorijeIndex-1];
			Artikl[] odabraniArtikli = odabranaKategorija.getArtikli();
			
			for(int k=1; k<=odabraniArtikli.length; k++) {
				
				
				System.out.println(k + ". " + odabraniArtikli[k-1].getNaslov());

			}
			
			System.out.println("Odabir >>");
			Integer artiklIndex = tipkovnica.nextInt(); 
			
			
			LocalDate datumObjave = LocalDate.now();
			
			Prodaja novaProdaja = new Prodaja(odabraniArtikli[artiklIndex-1],odabraniKorisnik,datumObjave);
			dostupniArtikli[i-1] = novaProdaja;  
		
		}
		for(Prodaja prodajaArtikl : dostupniArtikli) {
			
			Artikl odabraniArtikli = prodajaArtikl.getArtikl();
			Korisnik odabraniKorisnik = prodajaArtikl.getKorisnik();
			System.out.println("Naslov: " + odabraniArtikli.getNaslov());
			System.out.println("Opis: " + odabraniArtikli.getOpis());
			System.out.println("Cijena: " + odabraniArtikli.getCijena());
			System.out.println("Datum objave: " + prodajaArtikl.getDatumObjave());
			System.out.println("Kontakt: " + odabraniKorisnik.getIme()+ " " + odabraniKorisnik.getPrezime() + ", e-mail: " + odabraniKorisnik.getEmail() + ", telefon: " + odabraniKorisnik.getTelefon());
			
			
		}
		
		tipkovnica.close();
		
	}

	private static Kategorija unesiKategoriju(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite naziv " + i + " kategorije.");
		String naziv = tipkovnica.next();
		System.out.println("Unesite broj artikala koji želite unijeti za unesenu kategoriju:");
		Integer brojArtikla = tipkovnica.nextInt();
		
		Artikl[] artikli = new Artikl[brojArtikla];
		
		
		for (int j=1; j<=brojArtikla; j++) {
			
			System.out.println("Unesite naslov " + j + " artikla.");
			String naslov = tipkovnica.next();
			System.out.println("Unesite opis " + j + " artikla.");
			String opis = tipkovnica.next();
			System.out.println("Unesite cijenu " + j + " artikla.");
			BigDecimal cijena = tipkovnica.nextBigDecimal();
			
			Artikl noviArtikl = new Artikl(naslov, opis, cijena);
			artikli[j-1] = noviArtikl;
			
		}
		Kategorija novaKategorija = new Kategorija(naziv, artikli);
		return novaKategorija;
		
		
		
	}

	private static Korisnik unesiKorisnika(Scanner tipkovnica, int i) {
		
		System.out.println("Unesite ime " + i + " korisnika.");
		String ime = tipkovnica.next();
		System.out.println("Unesite prezime " + i + " korisnika.");
		String prezime = tipkovnica.next();
		System.out.println("Unesite e-mail " + i + " korisnika.");
		String email = tipkovnica.next();
		System.out.println("Unesite telefon " + i + " korisnika.");
		String telefon = tipkovnica.next();
		
		Korisnik korisnik = new Korisnik(ime, prezime, email, telefon);
		return korisnik;
	}
	
	

}
