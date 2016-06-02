/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * 
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Fichero {
	/**
	 * 
	 */
	private static final String EQP = ".eqp";
	public static File fichero = new File("Sin.titulo.eqp");
	/**
	 * Guarda el fichero
	 * @param object
	 * @param archivo
	 * @throws IOException
	 */
	public static void guardar(Object object, File archivo) throws IOException {
		archivo = annadirExtension(archivo);
		try (ObjectOutputStream salida = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(archivo, false)))) {
			salida.writeObject(object);
		}

	}
	/**
	 * Lee el fichero
	 * @param archivo
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object leer(File archivo) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(archivo)))) {
			return (Object) ois.readObject();
		}
	}
	/**
	 * A�ade la extension .EQP
	 */
	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(EQP))
			return new File(archivo + EQP);
		return archivo;
	}
	/**
	 * Si existe el archivo
	 * @param archivo
	 * @return
	 */
	public static boolean confirmarExistencia(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}
}


