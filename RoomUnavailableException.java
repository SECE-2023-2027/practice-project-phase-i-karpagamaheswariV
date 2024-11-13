package exception;

public class RoomUnavailableException extends Exception {
	private static final long serialVersion=1L;
	 public RoomUnavailableException(String message) {
	        super(message);
	    }
}
