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
public class Defensa extends Futbolista {
	private int numPenaltis;
	private int jugCortadas;
	private int porteriaACero;

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
	 * 
	 *             Añade un defensa
	 */

	public Defensa(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud, Fecha fecha,
			double sueldoBase, int numPenaltis, int jugCortadas, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException {
		super(nombre, apellido, dorsal, dni, pie, aptitud, sueldoBase, fecha);
		setNumPenaltis(numPenaltis);
		setJugCortadas(jugCortadas);
		setPorteriaACero(porteriaACero);
	}

	/**
	 * @param porteriaACero2
	 * @throws NumeroNegativoException
	 * 
	 * 
	 */
	private void setPorteriaACero(int porteriaACero) throws NumeroNegativoException {
		if (porteriaACero < 0)
			throw new NumeroNegativoException("Porteria a cero no puede ser negativa");
		this.porteriaACero = porteriaACero;

	}

	/**
	 * @param jugCortadas2
	 * @throws NumeroNegativoException
	 */
	private void setJugCortadas(int jugCortadas) throws NumeroNegativoException {
		if (jugCortadas < 0)
			throw new NumeroNegativoException("Las jugadas cortadas no pueden ser negativas");
		this.jugCortadas = jugCortadas;

	}

	/**
	 * @param numPenaltis2
	 * @throws NumeroNegativoException
	 */
	private void setNumPenaltis(int numPenaltis) throws NumeroNegativoException {
		if (numPenaltis < 0)
			throw new NumeroNegativoException("El numero de penaltis realizado no puede ser nagativo");
		this.numPenaltis = numPenaltis;

	}

	/**
	 * 
	 * @return numero de panaltis
	 */
	public int getNumPenaltis() {
		return numPenaltis;
	}

	/**
	 * 
	 * @return jugadas cortadas
	 */
	public int getJugCortadas() {
		return jugCortadas;
	}

	/**
	 * 
	 * @return porteria a cero
	 */
	public int getPorteriaACero() {
		return porteriaACero;
	}

	/**
	 * 
	 * @return
	 * @throws FechaFuturaException
	 * 
	 *             Calcula el salario total del defensa
	 */

	public double getSalarioTotal() throws FechaFuturaException {
		double salarioTotal = this.getSueldoBase();
		double incremento = 0;

		if (this.getNumPenaltis() > 5)
			incremento = -2 / 100.0;
		if (this.getNumPenaltis() > 15)
			incremento = -5 / 100.0;
		salarioTotal += this.getSueldoBase() * incremento;
		incremento = 0;
		if (this.getJugCortadas() > 5)
			incremento = 2 / 100.0;
		if (this.getJugCortadas() > 10)
			incremento = 3 / 100.0;
		else
			incremento = 0;
		salarioTotal += this.getSueldoBase() * incremento;
		incremento = 0;

		if (this.getFecha().calcularAnnosTranscurridos(getFecha()) > 1)
			incremento = 6 / 100.0;
		if (this.getFecha().calcularAnnosTranscurridos(getFecha()) > 2)
			incremento = 12 / 100.0;
		else
			incremento = 24 / 100.0;
		salarioTotal += this.getSueldoBase() * incremento;
		return salarioTotal;

	}

}
