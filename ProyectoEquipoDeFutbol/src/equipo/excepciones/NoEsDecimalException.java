/**
 * 
 */
package equipo.excepciones;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class NoEsDecimalException extends NumberFormatException {

	public NoEsDecimalException(String s) {
		super("No es un decimal");
		
	}

	
}
