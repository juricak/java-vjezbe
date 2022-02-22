package hr.java.vjezbe.glavna;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
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
import hr.java.vjezbe.sortiranje.ArtiklSorter;
import hr.java.vjezbe.sortiranje.KategorijaSorter;



public class Glavna {

private static final Logger logger = LoggerFactory.getLogger(Glavna.class);
public static void main(String[] args) throws NemoguceOdreditiGrupuOsiguranjaException {
		
		Scanner tipkovnica = new Scanner(System.in);
		System.out.println("Unesite broj korisnika koji želite unijeti:");
		Integer brojKorisnika = unesiIntBroj(tipkovnica);
		
		List<Korisnik> korisnici = new ArrayList<>();
		for (int i=1; i<=brojKorisnika; i++) {
				unesiKorisnika(tipkovnica, i, korisnici);
			}
		
		System.out.println("Unesite broj Kategorija koji želite unijeti:");
		Integer brojKategorija = unesiIntBroj(tipkovnica);
		tipkovnica.nextLine();
		
		List<Kategorija> kategorije = new ArrayList<>();
		
		
		for (int k=1; k<=brojKategorija; k++) {
			
			
			
			kategorije.add(unesiKategoriju(tipkovnica, k));
			
			
		}

		System.out.println("Unesite broj artikala koji su aktivno na prodaju:");
		Integer brojAktivnihProdaja = unesiIntBroj(tipkovnica);
		tipkovnica.nextLine();
		
		//Prodaja[] dostupniArtikli = new Prodaja[brojAktivnihProdaja]; ??
		List<Prodaja> dostupniArtikli = new ArrayList<>();
				
		for (int k=1; k<=brojAktivnihProdaja; k++) {
			
			System.out.println("Odaberite korisnika:");
			
			Iterator<Korisnik> iteratorKor = korisnici.iterator();
			int c = 1;
			while(iteratorKor.hasNext()) {
				
				System.out.println( c + "." + iteratorKor.next().dohvatiKontakt());
				c++;
			}
			System.out.println("Odabir >>");
			Integer korisnikIndex = unesiIntBroj(tipkovnica);
			

		System.out.println("Odaberite kategoriju:");
		c = 1;
		Iterator<Kategorija> iteratorKat = kategorije.iterator();
		while(iteratorKat.hasNext()) {
			
			System.out.println(c + ". " +  iteratorKat.next().getNaziv());
			c++;
		}
		System.out.println("Odabir >>");
		Integer kategorijeIndex = unesiIntBroj(tipkovnica);
		//odabirKategorije(tipkovnica, kategorije);
		
		Korisnik odabraniKorisnik = korisnici.get(korisnikIndex-1);   
		Kategorija odabranaKategorija = kategorije.get(kategorijeIndex-1);
		//Artikl[] odabirArtikli = odabranaKategorija.getArtikli();
		List<Artikl> odabirArtikli = new ArrayList<>();
		odabirArtikli.addAll(odabranaKategorija.getArtikli());
		
		System.out.println("Odaberite artikl: ");
		c = 1;
		Iterator<Artikl> iteratorArt = odabirArtikli.iterator();
		while(iteratorArt.hasNext()) {
			
			System.out.println( c + ". " + iteratorArt.next().getNaslov());
			c++;
		}
		System.out.println("Odabir >>");
		Integer artiklIndex = unesiIntBroj(tipkovnica);
		

		LocalDate datumObjave = LocalDate.now();
		
		Artikl odabraniArtikli = odabirArtikli.get(artiklIndex-1);
		Prodaja novaProdaja = new Prodaja(odabraniArtikli,odabraniKorisnik,datumObjave);
		dostupniArtikli.add(novaProdaja); 
		
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
		
		for (Kategorija kategorija : kategorije) {
			List<Artikl> arti = kategorija.getArtikli().stream().collect(Collectors.toList());
			System.out.println("__________________________________________________");
			System.out.println(" Kategorija: " + kategorija.getNaziv());
			System.out.println("__________________________________________________");
			Collections.sort(arti, new ArtiklSorter());
			for (Artikl art : arti) 
				try {
					System.out.println( art.tekstOglasa());
					System.out.println("__________________________________________________");
						}catch(NemoguceOdreditiGrupuOsiguranjaException ex1) {
							System.out.println(" Cijena Osiguranja: Previše kw, nije moguce odrediti grupu osiguranja!");
							logger.error("Pogreška prilikom odredivanja cijene osiguranja!", ex1);
						}catch(CijenaJePreniskaException ex2) {
							System.out.println(" Porez: Pogreška prilikom odredivanja iznosa poreza! Cijena ne smije biti manja od 10000kn");
							logger.error("Pogreška prilikom odredivanja iznosa poreza!", ex2);
						}
				
		}
		System.out.println("__________________________________________________");
		System.out.println("Ispis mape:");
		System.out.println("__________________________________________________");
		Map<String, Set<Artikl>> mapaKategorija = new HashMap<>();
		for (Kategorija kategorija : kategorije) {
			mapaKategorija.put(kategorija.getNaziv(), kategorija.getArtikli());
		}
		
		for(Map.Entry<String, Set<Artikl>> ispis: mapaKategorija.entrySet() ) {
			String key = ispis.getKey();
            Set<Artikl> values = ispis.getValue();
            System.out.println("__________________________________________________");
            System.out.println(" Kategorija: " + key);
            System.out.println("__________________________________________________");
            for(Artikl ispisArtikl : values) {
            	
            	try {
					System.out.println( ispisArtikl.tekstOglasa());
						}catch(NemoguceOdreditiGrupuOsiguranjaException ex1) {
							System.out.println(" Cijena Osiguranja: Previše kw, nije moguce odrediti grupu osiguranja!");
							logger.error("Pogreška prilikom odredivanja cijene osiguranja!", ex1);
						}catch(CijenaJePreniskaException ex2) {
							System.out.println(" Porez: Pogreška prilikom odredivanja iznosa poreza! Cijena ne smije biti manja od 10000kn");
							logger.error("Pogreška prilikom odredivanja iznosa poreza!", ex2);
						}
            	System.out.println("__________________________________________________");
            }
		}
		// Sortirane kategorije
		System.out.println("SORTIRANE KATEGORIJE 1");
		Collections.sort(kategorije, new KategorijaSorter());
		for (Kategorija kategorija : kategorije) {
			Set<Artikl> arti = kategorija.getArtikli();
			System.out.println("__________________________________________________");
			System.out.println(" Kategorija: " + kategorija.getNaziv());
			System.out.println(" Sifra: " + kategorija.getSifra());
			System.out.println("__________________________________________________");
			for (Artikl art : arti) {
				try {
					System.out.println( art.tekstOglasa());
					System.out.println("__________________________________________________");
						}catch(NemoguceOdreditiGrupuOsiguranjaException ex1) {
							System.out.println(" Cijena Osiguranja: Previše kw, nije moguce odrediti grupu osiguranja!");
							logger.error("Pogreška prilikom odredivanja cijene osiguranja!", ex1);
						}catch(CijenaJePreniskaException ex2) {
							System.out.println(" Porez: Pogreška prilikom odredivanja iznosa poreza! Cijena ne smije biti manja od 10000kn");
							logger.error("Pogreška prilikom odredivanja iznosa poreza!", ex2);
						}
		}
	}
		//Mapa kategorija po sifri
		System.out.println("MAPA KATEGORIJA GRUPIRANIH PO SIFRI");
		Map<String, List<Kategorija>> mapaKategorijaSifra = new HashMap<>();
		for (Kategorija kategorija : kategorije) {
			String test = null;
			List<Kategorija> kate = new ArrayList<>();
			do {
				kate.add(kategorija);	
			}while (kategorija.getSifra().equals(test));
			test = kategorija.getSifra();
			mapaKategorijaSifra.put(kategorija.getSifra(), kate);
			}
		for(Map.Entry<String, List<Kategorija>> ispis: mapaKategorijaSifra.entrySet()) {
			String key = ispis.getKey();
            List<Kategorija> values = ispis.getValue();
            System.out.println("__________________________________________________");
            System.out.println(" Sifra: " + key);
            System.out.println("__________________________________________________");
            for (Kategorija ispisKategorija : values) {
            	
            	System.out.println(ispisKategorija.getNaziv());
            	ispisKategorija.getArtikli(); // za kasnije ako treba napraviti ispis sadrzaja kategorije
            	
            }
		}
	tipkovnica.close();
		
}
/**
 * Metoda za unos stanja artikla 
 * @param tipkovnica
 * @return Stanje
 */
private static Stanje unosStanja(Scanner tipkovnica) {
	
	for (int i = 0; i < Stanje.values().length; i++) {
			System.out.println((i + 1) + ". " + Stanje.values()[i]);
		}
		Integer stanjeRedniBroj = null;
		while (true) {
			System.out.print("Odabir stanja artikla >> ");
			stanjeRedniBroj = unesiIntBroj(tipkovnica);
		if (stanjeRedniBroj >= 1
				&& stanjeRedniBroj <= Stanje.values().length)
		 {
				return Stanje.values()[stanjeRedniBroj - 1];
		} else {
				System.out.println("Neispravan unos!");
		}
		}

}

/**
 * Metoda predstavlja odabr vrste korisnika i finalizira unos
 * @param tipkovnica
 * @param i
 * @param korisnici
 * @return Polje korisnici
 */
	private static List<Korisnik> unesiKorisnika(Scanner tipkovnica, int i, List<Korisnik> korisnici) {
		
		boolean nastaviPetlju = false;
		do {
			try {
		
		System.out.println("Odaberite tip korisnika "+ i +":");
		System.out.println("1. Privatni");
		System.out.println("2. Poslovni");
		System.out.println("Odabir >>");
		
		Integer tipKorisnika = unesiIntBroj(tipkovnica);
		
		
		if(tipKorisnika == 1) {
			korisnici.add(unesiPrivatnogKorisnika(tipkovnica, i));
			nastaviPetlju = false;
		} else if(tipKorisnika == 2) {
			korisnici.add(unesiPoslovnogKorisnika(tipkovnica, i));
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
		System.out.println("Unesite sifru "+ k +". kategorije: ");
		String sifra = tipkovnica.nextLine();
		
		System.out.println("Unesite broj artikala koji želite unijeti:");
		Integer brojArtikl = unesiIntBroj(tipkovnica);
		tipkovnica.nextLine();
		
		
		Set<Artikl> artikli = new HashSet<>();
		
		for (int i=1; i<=brojArtikl; i++ ) {
			
			boolean nastaviPetlju = false;
			do {
				try {
			
			System.out.println("Odaberite tip"+ i +". artikla:");
			System.out.println("1.  Usluga");
			System.out.println("2.  Automobil");
			System.out.println("3.  Stan");
			System.out.println("Odabir >>");
			
			Integer tipArtikla = unesiIntBroj(tipkovnica); 
			tipkovnica.nextLine();
			
			if(tipArtikla == 1) {
				artikli.add(unesiUslugu(tipkovnica, i)); 
				nastaviPetlju = false;
			}else if (tipArtikla == 2) {
				artikli.add(unesiAutomobil(tipkovnica, i)); 
				nastaviPetlju = false;
			}else if (tipArtikla == 3) {
				artikli.add(unesiStan(tipkovnica, i)); 
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
		Kategorija kategorija = new Kategorija(naziv, artikli, sifra);
		tipkovnica.nextLine();
		return kategorija;
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
		System.out.println("Unesite stanje " + i + " stana.");
		Stanje stanje = unosStanja(tipkovnica);
		System.out.println("Unesite cijenu " + i + " stana.");
		BigDecimal cijena = unesiBigDecimalBroj(tipkovnica);
		System.out.println("Unesite kvadraturu " + i + " stana.");
		int kvadratura = unesiIntBroj(tipkovnica);
		
		Artikl stan = new Stan(naslov, opis, stanje, cijena, kvadratura);
		
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
		System.out.println("Unesite stanje " + i + " automobila.");
		Stanje stanje = unosStanja(tipkovnica);
		System.out.println("Unesite cijena " + i + " automobila.");
		BigDecimal cijena = unesiBigDecimalBroj(tipkovnica);
		System.out.println("Unesite snagu " + i + " automobila.");
		BigDecimal snagaKs = unesiBigDecimalBroj(tipkovnica);
		
		Artikl automobil = new Automobil(naslov, opis, stanje, cijena, snagaKs);
		
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
		System.out.println("Unesite stanje " + i + " usluge.");
		Stanje stanje = unosStanja(tipkovnica);
		System.out.println("Unesite cijena " + i + " usluge.");
		BigDecimal cijena = unesiBigDecimalBroj(tipkovnica);
		
		Artikl usluga = new Usluga(naslov, opis, stanje, cijena);
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
