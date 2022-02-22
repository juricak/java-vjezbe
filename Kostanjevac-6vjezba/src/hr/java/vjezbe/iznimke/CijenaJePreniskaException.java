package hr.java.vjezbe.iznimke;

public class CijenaJePreniskaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2555341954833609776L;

	public CijenaJePreniskaException() {
		super("Dogodila se pogreška u radu programa!");
		}
		public CijenaJePreniskaException(String message) {
		super(message);
		}
		public CijenaJePreniskaException(String message, Throwable cause) {
		super(message, cause);
		}
		public CijenaJePreniskaException(Throwable cause) {
		super(cause);
		}
}
