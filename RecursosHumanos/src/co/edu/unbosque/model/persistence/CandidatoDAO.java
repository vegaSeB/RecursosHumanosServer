package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CandidatoDTO;

public class CandidatoDAO {

	private Archivo archivo;

	public CandidatoDAO(Archivo archivo) {
		this.archivo = archivo;
	}

	public CandidatoDTO buscarUnCandidato(long cedula, ArrayList<CandidatoDTO> candidatos) {
		CandidatoDTO encontrado = null;
		if (candidatos.size() != 0) {
			for (int i = 0; i < candidatos.size(); i++) {
				if (candidatos.get(i).getCedula() == cedula) {
					encontrado = candidatos.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}

	public String agregar_Candidato(String nombre, String apellido, String cargo, long cedula, int edad,
			ArrayList<CandidatoDTO> lst) {

		CandidatoDTO agregar = new CandidatoDTO(nombre, apellido, cargo, cedula, edad);
		String res = "";
		
		if (buscarUnCandidato(cedula, lst) == null) {
			lst.add(agregar);
			archivo.escribirEnArchivo(lst);
			res = "El candidato se creó correctamente";
		} else {

			res = "El candidato ya existe";
		}
		return res;
	}
	
	public String eliminarUsuario(long cedula, ArrayList<CandidatoDTO> lst) {
		String aux = cedula + "";
		String res = ""; 
		if (!aux.equals("")) {
			if (buscarUnCandidato(cedula, lst) != null) {
				try {
					CandidatoDTO e = buscarUnCandidato(cedula, lst);
					lst.remove(e);
					archivo.getArchivo().delete();
					archivo.getArchivo().createNewFile();
					archivo.escribirEnArchivo(lst);
					res = "El candidato se elimino correctamente";
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				res = "El candidato ingresado no se encuentra registrado";
			}
		}
		return res;
	}
	
	public String modificar_Candidato(String nombre, String apellido, String cargo, long cedula, int edad,
			ArrayList<CandidatoDTO> lst) {

		CandidatoDTO agregar = new CandidatoDTO(nombre, apellido, cargo, cedula, edad);
		
		String aux = cedula + "";
		String res = "";
		
		if (!aux.equals("")) {
			if (buscarUnCandidato(cedula, lst) != null) {
				try {
					CandidatoDTO e = buscarUnCandidato(cedula, lst);
					lst.set(lst.indexOf(e), agregar);
					archivo.getArchivo().delete();
					archivo.getArchivo().createNewFile();
					archivo.escribirEnArchivo(lst);
					 res = "El candidato se modifico correctamente";
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				res = "El candidato ingresado no se encuentra registrado";
			}
		}
		return res;
	}
	
}
