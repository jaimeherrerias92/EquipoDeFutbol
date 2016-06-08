/**
 * Paquete fechaPorGrupos.
 */
package utilesFechas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;
/**
 * 
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Fecha implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Locale spain = new Locale("sp");
	private GregorianCalendar calendar = new GregorianCalendar(spain);
	private String fecha;
	private static final String COMPROBAR_FECHA = "^([0-2][1-9]|[3][0-1])([-/])([0][1-9]|[1][0-2])([-/])([0-1]\\d\\d\\d|[2][0]\\d\\d)$";

	/**
	 * Costructor de Fecha
	 * 
	 * @param dia
	 *            Dia de la fecha.
	 * @param mes
	 *            Mes de la fecha.
	 * @param anio
	 *            A&ntilde;o de la fecha.
	 * @throws FechaNoValidaException
	 *             si la fecha no es valida.
	 */
	public Fecha(String dia, String mes, String anio) throws FechaNoValidaException {
		if (esValidaFecha(dia, mes, anio)) {
			setCalendar(dia, mes, anio);
		}
	}

	/**
	 * Constructor de Fecha.
	 * 
	 * @param fecha
	 *            Fecha que se almacena.
	 * @throws FormatoNoValidoException
	 *             si el formato no es valido.
	 * @throws FechaNoValidaException
	 *             si la fecha no es valida.
	 */
	public Fecha(String fecha) throws FormatoNoValidoException, FechaNoValidaException {
		this.fecha=fecha;
		if (esValidoFormato(fecha))
			if (esValidaFecha(fecha)){
				this.fecha=fecha;
				setCalendar(fecha);
			}
				
	}

	/**
	 * Metodo que dice si una fecha es futura.
	 * 
	 * @return true si es futura, false en caso contrario.
	 */
	public boolean esFuturo() {
		return calendar.after(GregorianCalendar.getInstance());
	}

	/**
	 * Metodo que calcula los dias transcurridos entre una fecha y la actual.
	 * 
	 * @return Devuelve la cantidad de dias transcurridos.
	 * @throws FechaFuturaException
	 *             si la fecha es futura.
	 */
	public long calcularDiasTranscurridos() throws FechaFuturaException {
		
		
			
		
		
		
		if (esFuturo())
			throw new FechaFuturaException("La fecha es futura.");
		long fechaMilis = calendar.getTimeInMillis();
		long fechaActualMilis = GregorianCalendar.getInstance().getTimeInMillis();
		long diasTranscurridos = fechaActualMilis - fechaMilis;
		return diasTranscurridos = ((((diasTranscurridos / 1000) / 60) / 60) / 24);

	}

	/**
	 * Metodo que dice si el formato de la fecha es valido.
	 * 
	 * @return Devuelve true si es valido.
	 * @throws FormatoNoValidoException
	 *             si el formato no es valido.
	 */
	private boolean esValidoFormato(String fecha) throws FormatoNoValidoException {
		if (!Pattern.matches(COMPROBAR_FECHA, fecha))
			throw new FormatoNoValidoException("El formato de la fecha no es valido.");
		return true;
	}

	/**
	 * Metodo que dice si la fecha es valida.
	 * 
	 * @param dia
	 *            Dia de la fecha.
	 * @param mes
	 *            Mes de la fecha.
	 * @param anio
	 *            Anio de la fecha.
	 * @return Devuelve true si es valida la fecha.
	 * @throws FechaNoValidaException
	 *             si la fecha no es valida.
	 */
	private boolean esValidaFecha(String dia, String mes, String anio) throws FechaNoValidaException {
		setCalendar(dia, mes, anio);
		try {
			calendar.get(Calendar.DAY_OF_WEEK);
		} catch (Exception e) {
			throw new FechaNoValidaException("La fecha no es valida.");
		}
		return true;
	}

	/**
	 * Metodo que establece una fecha.
	 * 
	 * @param dia
	 *            Dia de la fecha.
	 * @param mes
	 *            Mes de la fecha.
	 * @param anio
	 *            Anio de la fecha.
	 */
	private void setCalendar(String dia, String mes, String anio) {
		calendar.setLenient(false);
		int date = Integer.parseInt(dia);
		int month = Integer.parseInt(mes) - 1;
		int year = Integer.parseInt(anio);
		calendar.set(year, month, date);
	}

	/**
	 * Metodo que dice si es valida una fecha.
	 * 
	 * @param fecha
	 *            Fecha que se valida.
	 * @return Devuelve true si es valida la fecha.
	 * @throws FechaNoValidaException
	 *             si no es valida.
	 */
	private boolean esValidaFecha(String fecha) throws FechaNoValidaException {
		setCalendar(fecha);
		try {
			calendar.get(Calendar.DAY_OF_WEEK);
		} catch (Exception e) {
			throw new FechaNoValidaException("La fecha no es valida.");
		}
		return true;
	}

	/**
	 * Metodo que establece una fecha.
	 * 
	 * @param fecha
	 *            Fecha que se establece.
	 */
	private void setCalendar(String fecha) {
		calendar.setLenient(false);
		int dia = Integer.parseInt(fecha.split("[-/]")[0]);
		int mes = Integer.parseInt(fecha.split("[-/]")[1]) - 1;
		int anio = Integer.parseInt(fecha.split("[-/]")[2]);
		calendar.set(anio, mes, dia);
	}

	/**
	 * Metodo que dice si una persona es mayor de edad.
	 * 
	 * @return Devuelve los anios de la persona.
	 * @throws FechaFuturaException
	 *             si la fecha es futura.
	 */
	public boolean esMayorEdad() throws FechaFuturaException {
		if (esFuturo())
			throw new FechaFuturaException("La fecha es futura.");
		long edadMilis = calendar.getTimeInMillis();
		long fechaActualMilis = GregorianCalendar.getInstance().getTimeInMillis();
		long aniosTranscurridos = fechaActualMilis - edadMilis;
		return (((((aniosTranscurridos / 1000) / 60) / 60) / 24) / 365) >= 18;

	}
	
	/**
	 * Calcula la diferencia en años entre dos fechas 
	 * @param fecha de la que calcularemos los años transcurridos
	 * @return diferencia en años
	 */
	public long calcularAnnosTranscurridos(Fecha fecha){
		LocalDate fecha1=LocalDate.of(fecha.calendar.get(GregorianCalendar.YEAR),
				fecha.calendar.get(GregorianCalendar.MONTH)+1,
				fecha.calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2=LocalDate.of(calendar.get(GregorianCalendar.YEAR),
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		return Math.abs(ChronoUnit.YEARS.between(fecha1, fecha2));
	}

	/**
	 * Metodo que suma dos fechas.
	 * 
	 * @param fecha
	 *            Fecha que se suma.
	 * @return La suma de las fechas.
	 */
	public GregorianCalendar sumarFechas(Fecha fecha) {
		GregorianCalendar fechaSuma = new GregorianCalendar();
		fechaSuma.setTimeInMillis(fecha.calendar.getTimeInMillis() + calendar.getTimeInMillis());
		return fechaSuma;

	}

	/**
	 * Metodo que devuelve el dia de la semana en castellano.
	 * 
	 * @return Devuelve el dia de la semana.
	 */
	public String getdiaSemana() {
		String dia = "";
		switch (calendar.get(Calendar.DAY_OF_WEEK) - 1) {
		case 0:
			dia += "Domingo";
			break;
		case 1:
			dia += "Lunes";
			break;
		case 2:
			dia += "Martes";
			break;
		case 3:
			dia += "Miercoles";
			break;
		case 4:
			dia += "Jueves";
			break;
		case 5:
			dia += "Viernes";
			break;
		case 6:
			dia += "Sabado";
		}
		return dia;
	}

	/**
	 * Metodo que devuelve el mes en castellano.
	 * 
	 * @return Devuelve el mes.
	 */
	public String getMesActual() {
		String mes = "";
		switch (calendar.get(Calendar.MONTH)) {
		case 0:
			mes += "Enero";
			break;
		case 1:
			mes += "Febrero";
			break;
		case 2:
			mes += "Marzo";
			break;
		case 3:
			mes += "Abril";
			break;
		case 4:
			mes += "Mayo";
			break;
		case 5:
			mes += "Junio";
			break;
		case 6:
			mes += "Julio";
			break;
		case 7:
			mes += "Agosto";
			break;
		case 8:
			mes += "Septiembre";
			break;
		case 9:
			mes += "Octubre";
			break;
		case 10:
			mes += "Noviembre";
			break;
		case 11:
			mes += "Diciembre";
		}
		return mes;
	}

	@Override
	public String toString() {
		return fecha;
	}

}
