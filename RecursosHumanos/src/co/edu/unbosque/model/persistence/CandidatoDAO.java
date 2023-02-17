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

	public boolean agregar_Candidato(String nombre, String apellido, String cargo, long cedula, int edad,
			ArrayList<CandidatoDTO> lst) {

		CandidatoDTO agregar = new CandidatoDTO(nombre, apellido, cargo, cedula, edad);
		
		if (buscarUnCandidato(cedula, lst) == null) {
			lst.add(agregar);
			archivo.escribirEnArchivo(lst);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El candidato ya se encuentra registrado");
			return false;
		}
	}
	
	public void eliminarUsuario(long cedula, ArrayList<CandidatoDTO> lst) {
		String aux = cedula + "";
		if (!aux.equals("")) {
			if (buscarUnCandidato(cedula, lst) != null) {
				try {
					CandidatoDTO e = buscarUnCandidato(cedula, lst);
					lst.remove(e);
					archivo.getArchivo().delete();
					archivo.getArchivo().createNewFile();
					archivo.escribirEnArchivo(lst);
					JOptionPane.showMessageDialog(null, "El candidato se elimino correctamente");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "El candidato ingresado no se encuentra registrado");
			}
		}
	}
	
	public void modificar_Candidato(String nombre, String apellido, String cargo, long cedula, int edad,
			ArrayList<CandidatoDTO> lst) {

		CandidatoDTO agregar = new CandidatoDTO(nombre, apellido, cargo, cedula, edad);
		
		String aux = cedula + "";
		
		if (!aux.equals("")) {
			if (buscarUnCandidato(cedula, lst) != null) {
				try {
					CandidatoDTO e = buscarUnCandidato(cedula, lst);
					lst.set(lst.indexOf(e), agregar);
					archivo.getArchivo().delete();
					archivo.getArchivo().createNewFile();
					archivo.escribirEnArchivo(lst);
					JOptionPane.showMessageDialog(null, "El candidato se modifico correctamente");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "El candidato ingresado no se encuentra registrado");
			}
		}
	}
	
}
