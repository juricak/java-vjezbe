package hr.tvz.java.javafx;

public class Student {

	private String ime;
	private String prezime;
	private String jmbag;

	public Student(String ime, String prezime, String jmbag) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbag = jmbag;
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

	public String getJmbag() {
		return jmbag;
	}

	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}

}
