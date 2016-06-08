/* 
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
public class Portero extends Futbolista implements Asalariado {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int golesEncajados;
	private int numParadas;
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
	 */
	public Portero(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud, Fecha fecha,
			double sueldoBase, int numParadas, int golesEncajados, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException {
		super(nombre, apellido, dorsal, dni, pie, aptitud, sueldoBase, fecha);
		setNumParadas(numParadas);
		setGolesEncajados(golesEncajados);
		setporteriaACero(porteriaACero);

	}

	/**
	 * @param porteriaACero2
	 * @throws NumeroNegativoException
	 */
	private void setporteriaACero(int porteriaACero) throws NumeroNegativoException {
		if (porteriaACero < 0)
			throw new NumeroNegativoException("Porteria a cero no puede ser negativa");
		this.porteriaACero = porteriaACero;

	}

	/**
	 * @param golesEncajados
	 * @throws NumeroNegativoException
	 */
	private void setGolesEncajados(int golesEncajados) throws NumeroNegativoException {
		if (golesEncajados < 0)
			throw new NumeroNegativoException("Los goles encajados no pueden ser negativos");
		this.golesEncajados = golesEncajados;

	}

	/**
	 * @param numParadas
	 * @throws NumeroNegativoException
	 */
	private void setNumParadas(int numParadas) throws NumeroNegativoException {
		if (numParadas < 0)
			throw new NumeroNegativoException("Las paradas no pueden ser negativos");
		this.numParadas = numParadas;
	}

	public int getPorteriaACero() {
		return porteriaACero;
	}

	public void setPorteriaACero(int porteriaACero) {
		this.porteriaACero = porteriaACero;
	}

	public int getGolesEncajados() {
		return golesEncajados;
	}

	public int getNumParadas() {
		return numParadas;
	}

	public double getSalarioTotal() throws FechaFuturaException {
		double salarioTotal = this.getSueldoBase();
		double incremento = 0;
		if (this.getGolesEncajados() > 20)
			incremento = -5 / 100.0;
		else if (this.getGolesEncajados() > 30)
			incremento = -7 / 100.0;
		else
			incremento = 0;

		salarioTotal += getSueldoBase() * incremento;
		
		
		if (this.getNumParadas() > 20)
			incremento = 5 / 100.0;
		else if (this.getNumParadas() > 30)
			incremento = 7 / 100.0;
		salarioTotal +=  this.getSueldoBase() * incremento;

		incremento = 0;

		if (this.getFecha().calcularAnnosTranscurridos(getFecha())>1)
			incremento = 6 / 100.0;
		else if (this.getFecha().calcularAnnosTranscurridos(getFecha())>2)
			incremento = 12 / 100.0;
		else
			incremento = 24 / 100.0;
		salarioTotal += getSueldoBase() * incremento;

		return salarioTotal;
	}

}
