/**
 * 
 */
package equipo;

import java.io.File;

import java.io.PipedInputStream;
import java.util.ArrayList;

import equipo.excepciones.AptitudNoValidaExecption;
import equipo.excepciones.CadenaVaciaException;
import equipo.excepciones.DniInvalidoExceptions;
import equipo.excepciones.FechaNegativoException;
import equipo.excepciones.JugadorNoExiste;
import equipo.excepciones.JugadorYaExisteExeption;
import equipo.excepciones.NumeroNegativoException;
import equipo.excepciones.PieNoValidaExecption;
import utilesFechas.Fecha;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Gestion {
	private static Equipo e = new Equipo();
	public static Fichero fichero = new Fichero();
	private static boolean modificado;
	private static File archivoSeleccionado;
	
	
	/**
	 * Devuelve el equipo
	 * @return
	 */
	public static Equipo getEquipo(){
		return e;
	}
	
	/**
	 * devuelve un arrayList con los maximos goleadores
	 * @return
	 */
	public static ArrayList<Goleadores> getGoleadores(){
		return e.maximosGoleadores();
	}
	/**
	 * Devuelve un arrayList ordenado por numero de pases
	 * @return
	 */
	public static ArrayList<MedioCentro> getPasadores(){
		return e.maximosPasadores();
	}
	/**
	 * 
	 * @param e
	 */
	public static void setEquipo(Equipo e) {
		Gestion.e = e;
	}
	/**
	 * Numero de goleadores uqe hay en el arrayList
	 * @return
	 */

	public static int numGoleadores(){
		return e.maximosGoleadores().size();
	}
	
	/**
	 * 
	 * @return
	 */
	public static File getArchivoSeleccionado() {
		return archivoSeleccionado;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * 
	 * @param modif
	 */
	public static void setModificado(boolean modif) {
		modificado = modif;
	}
	/**
	 * 
	 * @param archivoSeleccionado
	 */
	public static void setArchivoSeleccionado(File archivoSeleccionado) {
		Gestion.archivoSeleccionado = archivoSeleccionado;
	}
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dorsal
	 * @param dni
	 * @param pie
	 * @param aptitud
	 * @param fecha
	 * @param sueldoBase
	 * @param numGoles
	 * @param numAsistencias
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 * @throws AptitudNoValidaExecption
	 * @throws PieNoValidaExecption
	 * @throws NumeroNegativoException
	 * @throws FechaNegativoException
	 * @throws JugadorYaExisteExeption
	 * @throws JugadorNoExiste
	 * 
	 * Añade un delantero 
	 */
	
	public static void addDelantero(String nombre, String apellido, int dorsal, String dni, PieBueno pie,
			Aptitud aptitud, Fecha fecha, double sueldoBase, int numGoles, int numAsistencias)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {
		e.addDelantero(nombre, apellido, dorsal, dni, pie, aptitud, fecha, sueldoBase, numGoles, numAsistencias);

	}
	/**
	 * Numero de futbolistas
	 * @return
	 */
	public static int numFutbolistas(){
		return e.size();
	}
	/**
	 * 
	 * @param dni
	 * @return
	 * @throws JugadorNoExiste
	 * @throws NumeroNegativoException
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 */
	
	public static Futbolista getFutbolista(String dni) throws JugadorNoExiste, NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException{
		return e.get(dni);
	}
	
	
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dorsal
	 * @param dni
	 * @param pie
	 * @param ap
	 * @param fecha
	 * @param sueldoBase
	 * @param numPases
	 * @param numGoles
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 * @throws AptitudNoValidaExecption
	 * @throws PieNoValidaExecption
	 * @throws NumeroNegativoException
	 * @throws FechaNegativoException
	 * @throws JugadorYaExisteExeption
	 * @throws JugadorNoExiste
	 */
	public static void addMedio(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud ap,
			Fecha fecha, double sueldoBase, int numPases, int numGoles)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {
		e.addMedioCentro(nombre, apellido, dorsal, dni, pie, ap, fecha, sueldoBase, numPases, numGoles);
	}
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dorsal
	 * @param dni
	 * @param pie
	 * @param ap
	 * @param fecha
	 * @param sueldoBase
	 * @param numPenaltis
	 * @param jugCortadas
	 * @param porteriaACero
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 * @throws AptitudNoValidaExecption
	 * @throws PieNoValidaExecption
	 * @throws NumeroNegativoException
	 * @throws FechaNegativoException
	 * @throws JugadorYaExisteExeption
	 * @throws JugadorNoExiste
	 */
	public static void addDefensa(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud ap,
			Fecha fecha, double sueldoBase, int numPenaltis, int jugCortadas, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption, NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste{
		e.addDefensa(nombre, apellido, dorsal, dni, pie, ap, fecha, sueldoBase, numPenaltis, jugCortadas, porteriaACero);
	}
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dorsal
	 * @param dni
	 * @param pie
	 * @param aptitud
	 * @param fecha
	 * @param sueldoBase
	 * @param numParadas
	 * @param golesEncajados
	 * @param porteriaACero
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 * @throws AptitudNoValidaExecption
	 * @throws PieNoValidaExecption
	 * @throws NumeroNegativoException
	 * @throws FechaNegativoException
	 * @throws JugadorYaExisteExeption
	 * @throws JugadorNoExiste
	 */
	
	public static void addPortero(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud,
			Fecha fecha, double sueldoBase, int numParadas, int golesEncajados, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption, NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste{
		e.addPortero(nombre, apellido, dorsal, dni, pie, aptitud, fecha, sueldoBase, numParadas, golesEncajados, porteriaACero);
	}
	
	/**
	 * 
	 * @param dni
	 * @throws JugadorNoExiste
	 * @throws NumeroNegativoException
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 */
	
	public static void eliminar(String dni) throws JugadorNoExiste, NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException {
		e.eliminarPorDni(dni);
	}
	/**
	 * 
	 * @return
	 */
	public static String mostrarJugadores(){
		return e.toString();
	}
	/**
	 * 
	 * @return  muestra numero de porteros
	 */
	public static int mostrarNumeroDePorteros(){
		return e.mostrarPorteros().size();
	}
	/**
	 * 
	 * @return muestra numero de defensas
	 */
	public static int mostrarNumeroDeDefensas(){
		return e.mostrarDefensa().size();
	}
	/**
	 * 
	 * @return muestra numero de medios
	 */
	public static int mostrarNumeroDeMedios(){
		return e.obtenerMedios().size();
	}
	/**
	 * 
	 * @return devuelve el arrayList de porteros
	 */
	public static ArrayList<Futbolista> getPortero(){
		return e.mostrarPorteros();
	}
	/**
	 * 
	 * @return devuelve el arrayList de delanteros
	 */
	public static ArrayList<Futbolista> getDelantero(){
		return e.obtenerDelanteros();
	}
	/**
	 * 
	 * @return devuelve el arrayList de defensas
	 */
	public static ArrayList<Futbolista> getDefensa(){
		return e.mostrarDefensa();
	}
	/**
	 *  devuelve el arrayList de medios
	 * @return
	 */
	public static ArrayList<Futbolista> getMedio(){
		return e.obtenerMedios();
	}
	/**
	 * 
	 * @return devuelve el numero de delanteros
	 */
	public static int mostrarNumeroDeDelanteros(){
		return e.obtenerDelanteros().size();
	}
	/**
	 * 
	 * @param dni
	 * @return
	 * @throws NumeroNegativoException
	 * @throws DniInvalidoExceptions
	 * @throws JugadorNoExiste
	 * @throws CadenaVaciaException
	 */
	public static String mostrarPorDni(String dni) throws NumeroNegativoException, DniInvalidoExceptions, JugadorNoExiste, CadenaVaciaException{
		return e.mostrarDni(dni).toString();
	}


	/**
	 * @return
	 */
	public static int numPasadores() {
		return e.maximosPasadores().size();
	}
	
}
