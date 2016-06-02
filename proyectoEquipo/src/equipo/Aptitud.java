/**
 * 
 */
package equipo;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public enum Aptitud {
	DESTRUCTOR, CABEZEADOR, PASADOR, CAZAGOLES, MURODEFENSIVO, REGATEADOR;
	
	
	private static final Aptitud[] VALUES = Aptitud.values();
	private Aptitud ap;
	
	
	/**
	 * 
	 * @return
	 */
	public static Aptitud[] getValues() {
		return VALUES;
	}
	
	
	public Aptitud getAptitud(){
		return ap;
	}
}
