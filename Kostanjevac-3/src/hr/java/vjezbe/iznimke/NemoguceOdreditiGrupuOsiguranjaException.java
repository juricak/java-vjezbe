package hr.java.vjezbe.iznimke;

public class NemoguceOdreditiGrupuOsiguranjaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2970828597421605572L;
	public NemoguceOdreditiGrupuOsiguranjaException() {
		super("Dogodila se pogre�ka u radu programa!");
		}
		public NemoguceOdreditiGrupuOsiguranjaException(String message) {
		super(message);
		}
		public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause) {
		super(message, cause);
		}
		public NemoguceOdreditiGrupuOsiguranjaException(Throwable cause) {
		super(cause);
		}
}


