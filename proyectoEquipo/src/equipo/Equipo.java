/**
 * 
 */
package equipo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

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
public class Equipo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Futbolista> listaJugadores = new ArrayList<Futbolista>();

	/**
	 * Añadimos un jugador portero
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

	public void addPortero(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud,
			Fecha fecha, double sueldoBase, int numParadas, int golesEncajados, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {
		Portero portero = new Portero(nombre, apellido, dorsal, dni, pie, aptitud, fecha, sueldoBase, numParadas,
				golesEncajados, porteriaACero);
		if (listaJugadores.contains(portero))
			throw new JugadorYaExisteExeption("El portero ya se ha creado");
		if (existeDorsal(dorsal))
			throw new JugadorYaExisteExeption("El dorsal ya esta en uso");

		listaJugadores.add(portero);

	}

	/**
	 * Añadimos un jugador defensa
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
	public void addDefensa(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud ap,
			Fecha fecha, double sueldoBase, int numPenaltis, int jugCortadas, int porteriaACero)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {

		Defensa defensa = new Defensa(nombre, apellido, dorsal, dni, pie, ap, fecha, sueldoBase, numPenaltis,
				jugCortadas, porteriaACero);
		if (listaJugadores.contains(defensa))
			throw new JugadorYaExisteExeption("El defensa ya se ha creado");
		if (existeDorsal(dorsal))
			throw new JugadorYaExisteExeption("El dorsal ya esta en uso");
		else
			listaJugadores.add(defensa);

	}

	public boolean existeDorsal(int dorsal) {
		for (Futbolista f : listaJugadores) {
			if (f.getDorsal() == dorsal)
				return true;
		}
		return false;

	}

	Futbolista get(String dni)
			throws JugadorNoExiste, NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException {
		int index = listaJugadores.indexOf(new Futbolista(dni));
		if (index != -1)
			return listaJugadores.get(index);
		throw new JugadorNoExiste("El jugador no existe");
	}

	Futbolista get1(String dni)
			throws JugadorNoExiste, NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException {
		int index = listaJugadores.indexOf(new Futbolista(dni));
		if (index == -1)
			throw new JugadorNoExiste("El jugador no existe");
		return listaJugadores.get(index);
	}

	/**
	 * Añadimos un jugador mediocentro
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
	public void addMedioCentro(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud ap,
			Fecha fecha, double sueldoBase, int numPases, int numGoles)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {
		MedioCentro medio = new MedioCentro(nombre, apellido, dorsal, dni, pie, ap, fecha, sueldoBase, numPases,
				numGoles);

		if (listaJugadores.contains(medio))
			throw new JugadorYaExisteExeption("El medioCentro ya se ha creado");
		if (existeDorsal(dorsal))
			throw new JugadorYaExisteExeption("El dorsal ya esta en uso");
		else
			listaJugadores.add(medio);

	}

	/**
	 * Añadimos un jugador delantero
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
	 */
	public void addDelantero(String nombre, String apellido, int dorsal, String dni, PieBueno pie, Aptitud aptitud,
			Fecha fecha, double sueldoBase, int numGoles, int numAsistencias)
					throws DniInvalidoExceptions, CadenaVaciaException, AptitudNoValidaExecption, PieNoValidaExecption,
					NumeroNegativoException, FechaNegativoException, JugadorYaExisteExeption, JugadorNoExiste {
		Delantero delantero = new Delantero(nombre, apellido, dorsal, dni, pie, aptitud, fecha, sueldoBase, numGoles,
				numAsistencias);
		if (listaJugadores.contains(delantero))
			throw new JugadorYaExisteExeption("El delantero ya se ha creado");
		if (existeDorsal(dorsal))
			throw new JugadorYaExisteExeption("El dorsal ya esta en uso");
		else
			listaJugadores.add(delantero);

	}

	/**
	 * DEVUELVE UN jugador por dni
	 * 
	 * @param dni
	 * @return
	 * @throws NumeroNegativoException
	 * @throws DniInvalidoExceptions
	 * @throws JugadorNoExiste
	 * @throws CadenaVaciaException
	 */

	Futbolista mostrarDni(String dni)
			throws NumeroNegativoException, DniInvalidoExceptions, JugadorNoExiste, CadenaVaciaException {
		Futbolista f = new Futbolista(dni);
		int indice = listaJugadores.indexOf(f);
		if (indice != -1)
			return f;
		throw new JugadorNoExiste("El jugador no existe");

	}

	/**
	 * 
	 * @param dni
	 * @return lo elimina
	 * @throws JugadorNoExiste
	 * @throws NumeroNegativoException
	 * @throws DniInvalidoExceptions
	 * @throws CadenaVaciaException
	 */
	public void eliminarPorDni(String dni)
			throws JugadorNoExiste, NumeroNegativoException, DniInvalidoExceptions, CadenaVaciaException {
		Futbolista f = new Futbolista(dni);
		if (listaJugadores.contains(f))
			listaJugadores.remove(f);
		throw new JugadorNoExiste("El jugador no existe");

	}

	/**
	 * Muestra los porteros
	 * 
	 * @return
	 */
	public ArrayList<Futbolista> mostrarPorteros() {
		ArrayList<Futbolista> porteros = new ArrayList<Futbolista>();

		for (Futbolista f : listaJugadores)
			if (f.getClass() == Portero.class)
				porteros.add((Portero) f);
		return porteros;

	}

	/**
	 * Muestra los defensas
	 * 
	 * @return
	 */
	public ArrayList<Futbolista> mostrarDefensa() {
		ArrayList<Futbolista> defensas = new ArrayList<Futbolista>();

		for (Futbolista f : listaJugadores)
			if (f.getClass() == Defensa.class)
				defensas.add((Defensa) f);
		return defensas;

	}

	/**
	 * muestra los mediocentros
	 * 
	 * @return
	 */
	public ArrayList<Futbolista> obtenerMedios() {
		ArrayList<Futbolista> medioCentros = new ArrayList<Futbolista>();

		for (Futbolista f : listaJugadores)
			if (f.getClass() == MedioCentro.class)
				medioCentros.add((MedioCentro) f);

		return medioCentros;

	}

	/**
	 * muestra los delanteros
	 * 
	 * @return
	 */
	public ArrayList<Futbolista> obtenerDelanteros() {
		ArrayList<Futbolista> delanteros = new ArrayList<Futbolista>();

		for (Futbolista f : listaJugadores)
			if (f.getClass() == Delantero.class)
				delanteros.add((Delantero) f);
		return delanteros;

	}

	/**
	 * 
	 * @return arraylist de maximos goleadores
	 */
	public ArrayList<Goleadores> maximosGoleadores() {

		ArrayList<Goleadores> listaGoleadores = new ArrayList<Goleadores>();
		for (Futbolista f : listaJugadores)
			if ((f.getClass() == Delantero.class) || (f.getClass() == MedioCentro.class))
				listaGoleadores.add((Goleadores) f);

		Collections.sort(listaGoleadores, new ComparadorGolesDesc());

		return listaGoleadores;

	}

	/**
	 * 
	 * @return arrayList de maximos pasadores
	 */
	public ArrayList<MedioCentro> maximosPasadores() {

		ArrayList<MedioCentro> listaPasadores = new ArrayList<MedioCentro>();
		for (Futbolista f : listaJugadores)
			if ((f.getClass() == MedioCentro.class))
				listaPasadores.add((MedioCentro) f);

		Collections.sort(listaPasadores, new ComparadorDePasadores());

		return listaPasadores;

	}

	@Override
	public String toString() {
		return "Equipo [listaJugadores=" + listaJugadores + "]";
	}

	/**
	 * Vacia la lista de jugadores
	 */
	public void vaciar() {
		listaJugadores.clear();
	}

	/**
	 * @return numero de jugadores en la lista
	 * 
	 */
	public int size() {

		return listaJugadores.size();
	}

	/**
	 * @return
	 * 
	 */
	public ArrayList<Futbolista> getFutbolistas() {
		return listaJugadores;

	}

}
