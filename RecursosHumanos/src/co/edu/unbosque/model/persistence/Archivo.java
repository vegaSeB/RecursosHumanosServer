package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.CandidatoDTO;

public class Archivo {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo = new File("./data/candidatos.dat");
	
	/**
	 * Este es el metodo constructor de la clase, tiene definido el tama�o de la
	 * pantalla e inicializa el codigo de la misma.
	 */
	public Archivo() {
		if (archivo.exists()) {
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * El metodo escribirEnArchivo es el encargado de permitir escribir en un
	 * archivo cuando sea requerido por el programa
	 * 
	 * @param amigos: Lista de usuarios
	 */
	public void escribirEnArchivo(ArrayList<CandidatoDTO> can) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(can);
			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * El metodo leerArchivo es el encargado de permitir al programa leer un archivo
	 * cada vea que sea necesario
	 * 
	 * @return Retorna el ArrayList de Usuarios
	 */
	public ArrayList<CandidatoDTO> leerArchivo() {
		ArrayList<CandidatoDTO> salida = new ArrayList<CandidatoDTO>();
		if (archivo.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(archivo));
				salida = (ArrayList<CandidatoDTO>) entrada.readObject();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return salida;
	}

	/**
	 * Este es el metodo get su funcion basicamente es permitir obtener la
	 * informacion de la componente
	 * 
	 * @return Retorna la informacion de la componente correspondiente
	 */
	public ObjectInputStream getEntrada() {
		return entrada;
	}

	/**
	 * Este es el metodo set su funcion basicamente es permitir obtener la
	 * informacion de la componente y permitir editarla
	 * 
	 */
	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	/**
	 * Este es el metodo get su funcion basicamente es permitir obtener la
	 * informacion de la componente
	 * 
	 * @return Retorna la informacion de la componente correspondiente
	 */
	public ObjectOutputStream getSalida() {
		return salida;
	}

	/**
	 * Este es el metodo set su funcion basicamente es permitir obtener la
	 * informacion de la componente y permitir editarla
	 * 
	 */

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	/**
	 * Este es el metodo get su funcion basicamente es permitir obtener la
	 * informacion de la componente
	 * 
	 * @return Retorna la informacion de la componente correspondiente
	 */
	public File getArchivo() {
		return archivo;
	}

	/**
	 * Este es el metodo set su funcion basicamente es permitir obtener la
	 * informacion de la componente y permitir editarla
	 * 
	 */
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

}
