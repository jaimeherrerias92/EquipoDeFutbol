/**
 * 
 */
package equipo;

import java.util.Comparator;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class ComparadorGolesDesc implements Comparator<Goleadores> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Goleadores arg0, Goleadores arg1) {

		int resultado=0;
		
		if (arg0.getNumGoles()<arg1.getNumGoles()) {
			resultado=1;
		} else {
			if (arg0.getNumGoles()>arg1.getNumGoles()) {
				resultado=-1;
			}
			else {
				resultado=0;
			}
		}
		
		
		return resultado;
	}

}
