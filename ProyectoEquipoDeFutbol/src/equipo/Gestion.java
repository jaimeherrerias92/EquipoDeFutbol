/**
 * 
 */
package equipo;

import java.io.File;
import java.io.IOException;
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
	
	
	
	public static Equipo getEquipo(){
		return e;
	}
	
	
	public static ArrayList<Goleadores> getGoleadores(){
		return e.maximosGoleadores();
	}
	
	public static ArrayList<MedioCentro> getPasadores(){
		return e.maximosPasadores();
	}
	public static void setEquipo(Equipo e) {
		Gestion.e = e;
		setModificado(false);
	}


	public static int numGoleadores(){
		return e.maximosGoleadores().size();
	}
	public static File getArchivoSeleccionado() {
		return archivoSeleccionado;
	}
	
	
	public static boolean isModificado() {
		return modificado;
	}


	private static void setModificado(boolean modif) {
		modificado = modif;
	}
	
	private static void setArchivoSeleccionado(File archivoSeleccionado) {
		Gestion.archivoSeleccionado = archivoSeleccionado;
	}
	
	
	
	public static void addDelantero(String nombre, String apellido, int dorsal, String dni, PieBueno pie,
			Aptitud aptitud, Fecha fecha, double sueldoBase, int numGoles, int numAsistencias)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {
		e.addDelantero(nombre, apellido, dorsal, dni, pie, aptitud, fecha, sueldoBase, numGoles, numAsistencias);
		setModificado(true);

	}
	public static int numFutbolistas(){
		return e.size();
	}
	
	
	public static Futbolista getFutbolista(String dni) throws JugadorNoExiste, NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException{
		return e.get(dni);
	}
	
	
	
	
	public static void addMedio(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud ap,
			Fecha fecha, double sueldoBase, int numPases, int numGoles)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {
		e.addMedioCentro(nombre, apellido, dorsal, dni, pie, ap, fecha, sueldoBase, numPases, numGoles);
	}
	
	public static void addDefensa(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud ap,
			Fecha fecha, double sueldoBase, int numPenaltis, int jugCortadas, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption, NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste{
		e.addDefensa(nombre, apellido, dorsal, dni, pie, ap, fecha, sueldoBase, numPenaltis, jugCortadas, porteriaACero);
		setModificado(true);

	}
	
	public static void addPortero(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud,
			Fecha fecha, double sueldoBase, int numParadas, int golesEncajados, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption, NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste{
		e.addPortero(nombre, apellido, dorsal, dni, pie, aptitud, fecha, sueldoBase, numParadas, golesEncajados, porteriaACero);
		setModificado(true);

	}
	
	public static void eliminar(String dni) throws JugadorNoExiste, NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException {
		e.eliminarPorDni(dni);
		setModificado(true);

	}
	
	public static String mostrarJugadores(){
		return e.toString();
	}
	public static int mostrarNumeroDePorteros(){
		return e.mostrarPorteros().size();
	}
	
	public static int mostrarNumeroDeDefensas(){
		return e.mostrarDefensa().size();
	}
	
	public static int mostrarNumeroDeMedios(){
		return e.obtenerMedios().size();
	}
	
	public static ArrayList<Futbolista> getPortero(){
		return e.mostrarPorteros();
	}
	public static ArrayList<Futbolista> getDelantero(){
		return e.obtenerDelanteros();
	}
	public static ArrayList<Futbolista> getDefensa(){
		return e.mostrarDefensa();
	}
	public static ArrayList<Futbolista> getMedio(){
		return e.obtenerMedios();
	}
	public static int mostrarNumeroDeDelanteros(){
		return e.obtenerDelanteros().size();
	}
	public static String mostrarPorDni(String dni) throws NumeroNegativoException, DniInvalidoExceptions, JugadorNoExiste, CadenaVaciaException{
		return e.mostrarDni(dni).toString();
	}


	/**
	 * @return
	 */
	public static int numPasadores() {
		// TODO Auto-generated method stub
		return e.maximosPasadores().size();
	}


	/**
	 * @param equipo
	 * @param file
	 * @throws IOException 
	 */
	public static void guardar(Equipo equipo, File file) throws IOException {
		Fichero.guardar(Gestion.getEquipo(), file);
		Gestion.setArchivoSeleccionado(file);
		setModificado(false);
	}
	
}
