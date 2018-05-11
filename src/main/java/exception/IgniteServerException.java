package exception;

/**
 * Main server exception.
 *
 * Created by Lakhno Anton
 * at 23:48 11.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class IgniteServerException extends Exception {

	/** {@inheritDoc} */
	public IgniteServerException() {
		super();
	}

	/** {@inheritDoc} */
	public IgniteServerException(String message) {
		super(message);
	}

	/** {@inheritDoc} */
	public IgniteServerException(String message, Throwable cause) {
		super(message, cause);
	}

}
