/**
 * 
 */
package equipo;

import java.util.Comparator;

/**
 * @author Jaime Herrerias
 * @version 1.0
 * Interfafaz compara pases dados
 *
 */
public class ComparadorDePasadores implements Comparator<MedioCentro> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(MedioCentro arg0, MedioCentro arg1) {
		

		if (arg0.getNumPases() < arg1.getNumPases())
			return 1;
		if (arg0.getNumPases() > arg1.getNumPases())
			return -1;
		return 0;

		// return pases;
	}

}
