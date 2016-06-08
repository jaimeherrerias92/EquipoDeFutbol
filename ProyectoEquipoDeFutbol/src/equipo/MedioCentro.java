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
import utilesFechas.FechaFuturaException;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class MedioCentro extends Goleadores implements Asalariado {
	private int numPases;
	/**
	 * @param nombre
	 * @param apellido
	 * @param dorsal
	 * @param dni
	 * @param pie
	 * @param aptitud
	 * @param sueldoBase
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 * @throws AptitudNoValidaExecption
	 * @throws PieNoValidaExecption
	 * @throws NumeroNegativoException
	 * @throws FechaNegativoException 
	 */
	public MedioCentro(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud,Fecha fecha,
			double sueldoBase,int numPases, int numGoles) throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption,
					PieNoValidaExecption, NumeroNegativoException, FechaNegativoException {
		super(nombre, apellido, dorsal, dni, pie, aptitud, sueldoBase, fecha,numGoles);
		
		setNumPases(numPases);		
	}

	public int getNumPases() {
		return numPases;
	}

	/**
	 * @param numPases2
	 * @throws NumeroNegativoException 
	 */
	
	

	private void setNumPases(int numPases) throws NumeroNegativoException {
		if(numPases<0)
			throw new NumeroNegativoException("El numero de pases no puede ser negativo");
		this.numPases=numPases;
		
	}
	
	
	public double getSalarioTotal() throws FechaFuturaException {
		double salarioTotal = this.getSueldoBase();
		double incremento = 0;

		if (this.getNumPases() > 20) {
			incremento = 5 / 100.0;
		} else if (this.getNumPases() > 30) {
			incremento = 7 / 100.0;
		} else {
			incremento = 0;
		}

		salarioTotal +=  this.getSueldoBase() * incremento;
		incremento = 0;
		if (this.getNumGoles() > 5)
			incremento = 2 / 100.0;
		else if (this.getNumGoles() > 10)
			incremento = 3 / 100.0;
		else
			incremento = 0;
		salarioTotal +=  this.getSueldoBase() * incremento;
		incremento = 0;
		
		
		if(this.getFecha().calcularAnnosTranscurridos(getFecha())>1)
			incremento = 6 / 100.0;
		else if(this.getFecha().calcularAnnosTranscurridos(getFecha())>2)
			incremento = 12/100.0;
		else
			incremento=24/100.0;
		salarioTotal +=  this.getSueldoBase() * incremento;
		return salarioTotal;

	}

}
