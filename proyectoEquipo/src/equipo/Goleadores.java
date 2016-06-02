/**
 * 
 */
package equipo;

import equipo.excepciones.AptitudNoValidaExecption;
import equipo.excepciones.CadenaVaciaException;
import equipo.excepciones.DniInvalidoExceptions;
import equipo.excepciones.FechaNegativoException;
import equipo.excepciones.NumeroNegativoException;
import equipo.excepciones.PieNoValidaExecption;
import utilesFechas.Fecha;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Goleadores extends Futbolista {
	private int numGoles;
	/**
	 * @param nombre
	 * @param apellido
	 * @param dorsal
	 * @param dni
	 * @param pie
	 * @param aptitud
	 * @param sueldoBase
	 * @param fecha
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 * @throws AptitudNoValidaExecption
	 * @throws PieNoValidaExecption
	 * @throws NumeroNegativoException
	 * @throws FechaNegativoException
	 * 
	 * Clase intermedia que recoje goleadores ( de mediocentros y delanteros)
	 */
	public Goleadores(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud,
			double sueldoBase, Fecha fecha, int numGoles) throws DniInvalidoExceptions, CadenaVaciaException,
					AptitudNoValidaExecption, PieNoValidaExecption, NumeroNegativoException, FechaNegativoException {
		super(nombre, apellido, dorsal, dni, pie, aptitud, sueldoBase, fecha);
		this.setNumGoles(numGoles);
	}
	public int getNumGoles() {
		return numGoles;
	}
	/**
	 * @param numGoles2
	 * @throws NumeroNegativoException 
	 */
	private void setNumGoles(int numGoles) throws NumeroNegativoException {
		if(numGoles<0)
			throw new NumeroNegativoException("El numero de goles no puede ser negativo");
		this.numGoles=numGoles;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ "Goles="+getNumGoles()+"\n";
	}
	
	

	
}
