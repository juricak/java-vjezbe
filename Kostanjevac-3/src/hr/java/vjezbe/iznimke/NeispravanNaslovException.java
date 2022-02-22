package hr.java.vjezbe.iznimke;

public class NeispravanNaslovException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4392590942899211524L;
	public NeispravanNaslovException() {
		super("Dogodila se pogreška u radu programa!");
		}
		public NeispravanNaslovException(String message) {
		super(message);
		}
		public NeispravanNaslovException(String message, Throwable cause) {
		super(message, cause);
		}
		public NeispravanNaslovException(Throwable cause) {
		super(cause);
		}

}
