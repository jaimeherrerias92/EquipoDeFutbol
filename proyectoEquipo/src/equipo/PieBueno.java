/**
 * 
 */
package equipo;



/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public enum PieBueno {
	ZURDO,DIESTRO, AMBIDIESTRO;
	/**
	 * 
	 */
	
	private static final PieBueno[] VALUES = PieBueno.values();
	
	/**
	 * 
	 * @return
	 */
	public static PieBueno[] getValues() {
		return VALUES;
	}
}
