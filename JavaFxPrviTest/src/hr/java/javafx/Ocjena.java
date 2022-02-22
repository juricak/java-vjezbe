package hr.java.javafx;

public enum Ocjena {
	
	NEDOVOLJAN(1), DOVOLJAN(2), DOBAR(3), VRLO_DOBAR(4), IZVRSTAN(5);
	
	private Integer broj;
	
	private Ocjena(Integer broj) {
		this.broj = broj;
	}
	
	public Integer getBroj() {
		return broj;
	}

}
