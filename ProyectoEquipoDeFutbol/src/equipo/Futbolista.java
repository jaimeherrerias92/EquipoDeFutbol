/**
 * 
 */
package equipo;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.omg.PortableServer.ThreadPolicyOperations;

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
public class Futbolista implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final private Pattern dniPattern = Pattern.compile("^\\d{8}[- ]?[a-zA-Z&&[^IOUiou]]$");

	static final private Pattern niePattern = Pattern.compile("^[x-zX-Z]\\d{7}[a-zA-Z&&[^IOUiou]]$");
	private static final char[] LETRASDNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
			'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	private String nombre;
	private String apellido;
	private String dni;
	private int dorsal;
	private PieBueno pie;
	private Aptitud aptitud;
	private double sueldoBase;
	private Fecha fecha;

//	public Futbolista(int dorsal) throws NumeroNegativoException {
//		setDorsal(dorsal);
//
//	}
	/**
	 * Crea un nuevo futbolista solo por dni
	 * @param dni
	 * @throws NumeroNegativoException
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException 
	 */
	public Futbolista(String dni) throws NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException {
		setDni(dni);

	}

	public Futbolista(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud,
			double sueldoBase, Fecha fecha) throws DniInvalidoExceptions, CadenaVaciaException,
					AptitudNoValidaExecption, PieNoValidaExecption, NumeroNegativoException, FechaNegativoException {
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
		setAptitud(aptitud);
		setPieBueno(pie);
		setDorsal(dorsal);
		setSalario(sueldoBase);
		setFecha(fecha);

	}
	public int getDorsal(){
		return dorsal;
	}
	/**
	 * @param fecha2
	 * @throws FechaNegativoException
	 */
	private void setFecha(Fecha fecha) throws FechaNegativoException {
		if (fecha.esFuturo()||fecha==null)
			throw new FechaNegativoException("La fecha de entrada al club no puede ser futura o estar vacia");
		else
			this.fecha = fecha;

	}

	/**
	 * @param sueldoBase2
	 * @throws NumeroNegativoException
	 */
	private void setSalario(double sueldoBase) throws NumeroNegativoException{
		if (sueldoBase <= 0)
			throw new NumeroNegativoException("El sueldo no puede ser negativo");
		else
			this.sueldoBase = sueldoBase;
	}

	/**
	 * @param dorsal2
	 * @throws NumeroNegativoException
	 */
	private void setDorsal(int dorsal) throws NumeroNegativoException {
		if (dorsal <= 0)
			throw new NumeroNegativoException("El dorsal no puede ser negativo");
		else
			this.dorsal = dorsal;

	}

	/**
	 * @param pie2
	 * @throws PieNoValidaExecption
	 */
	private void setPieBueno(PieBueno pie) throws PieNoValidaExecption {

		if (pie == null)
			throw new PieNoValidaExecption("El pie no puede estar vacio");
		else
			this.pie = pie;
	}

	/**
	 * Pasa la primera letra de nie a su correspondiente numero
	 * 
	 * @param dni
	 * @return
	 */
	private String cambioLetraValor(String dni) {
		// http://www.interior.gob.es/web/servicios-al-ciudadano/dni/calculo-del-digito-de-control-del-nif-nie
		char digito = dni.charAt(0);
		int valor;
		if (digito == 'X')
			valor = 0;
		else if (digito == 'Y')
			valor = 1;
		else
			valor = 2;
		dni = dni.substring(1);
		dni = valor + dni;
		return dni;

	}

	/**
	 * @param aptitud2
	 * @throws AptitudNoValidaExecption
	 */
	private void setAptitud(Aptitud aptitud) throws AptitudNoValidaExecption {
		if (aptitud == null)
			throw new AptitudNoValidaExecption("La aptitud no puede estar vacia");
		this.aptitud = aptitud;
	}

	/**
	 * @param apellido2
	 * @throws CadenaVaciaException
	 */
	private void setApellido(String apellido) throws CadenaVaciaException {
		apellido = apellido.trim();
		if ((nombre == null) || (nombre.equals(""))) {
			throw new CadenaVaciaException("El apellido no puede estar vacio");
		}
		this.apellido = apellido;

	}
	// public Futbolista(String nombre) throws CadenaVaciaException {
	// setNombre(nombre);
	// }

	/**
	 * @param dni2
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException 
	 */
	private void setDni(String dni) throws DniInvalidoExceptions, CadenaVaciaException {
		dni = dni.trim().toUpperCase();
		if(dni==null)
			throw new CadenaVaciaException("El dni/nif no puede estar vacio");
//		if (!Character.isDigit(dni.charAt(0))){
//			if (!comprobarNIE(dni))
//				throw new DniInvalidoExceptions("Formato NIE no valido. Debe de ser (Z|X|Y)000000A");
//			String nie = cambioLetraValor(dni);
//			if (!dniLetraValida(nie.toUpperCase()))
//				throw new DniInvalidoExceptions("Letra final NIE no valida");
//		}
//			
//		else{
			
			if (!comprobrarDNI(dni))
				throw new DniInvalidoExceptions("Formato NIF no valido. Debe de ser 0000000A");
			String nie = cambioLetraValor(dni);
			if (!dniLetraValida(dni.toUpperCase()))
				throw new DniInvalidoExceptions("Letra final NIE no valida");
			
			
	//	}


		this.dni = dni;

	}

	private boolean dniLetraValida(String dni) {
		return (dni.charAt((dni.length() - 1)) == LETRASDNI[(Integer.parseInt(dni.substring(0, 8))) % 23]);

	}

	/**
	 * @param nombre2
	 * @throws CadenaVaciaException
	 */
	private void setNombre(String nombre) throws CadenaVaciaException {
		nombre = nombre.trim();
		if ((nombre == null) || (nombre.equals(""))) {
			throw new CadenaVaciaException("El nombre no puede estar vacio");
		}
		this.nombre = nombre;

	}

	public static boolean comprobarNIE(String string) {
		return niePattern.matcher(string).matches();
	}

	public static boolean comprobrarDNI(String string) {
		return dniPattern.matcher(string).matches();

	}

	@Override
	public String toString() {
		return "Futbolista [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", dorsal=" + dorsal
				+ ", pie=" + pie + ", aptitud=" + aptitud + ", sueldoBase=" + sueldoBase + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Futbolista)) {
			return false;
		}
		/*if (getClass() != obj.getClass())  
			return false;*/
		Futbolista other = (Futbolista) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public PieBueno getPie() {
		return pie;
	}

	public void setPie(PieBueno pie) {
		this.pie = pie;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Aptitud getAptitud() {
		return aptitud;
	}

	public Fecha getFecha() {
		return fecha;
	}

	
}
