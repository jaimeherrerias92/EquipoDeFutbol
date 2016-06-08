/**
 * 
 */
package equipo.excepciones;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class JugadorYaExisteExeption extends Exception {

	/**
	 * @param string
	 */
	public JugadorYaExisteExeption(String string) {
		super(string);
	}
}
