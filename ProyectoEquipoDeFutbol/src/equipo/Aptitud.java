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
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Aptitud aptitud : getValues()) {
			opcionesMenu[i++] = aptitud.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
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
