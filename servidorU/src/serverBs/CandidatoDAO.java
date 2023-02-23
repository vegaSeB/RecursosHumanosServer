package serverBs;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CandidatoDAO {

	private Archivo archivo;
	private ArrayList<CandidatoDTO> lst;

	public CandidatoDAO(Archivo archivo) {
		this.archivo = archivo;
	}

	public CandidatoDTO buscarUnCandidato(long cedula) {
		cargarBase();
		CandidatoDTO encontrado = null;
		if (lst.size() != 0) {
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).getCedula() == cedula) {
					encontrado = lst.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}

	public String agregar_Candidato(String nombre, String apellido, String cargo, long cedula, int edad) {
		cargarBase();
		CandidatoDTO agregar = new CandidatoDTO(nombre, apellido, cargo, cedula, edad);
		String res = "";

		if (buscarUnCandidato(cedula) == null) {
			lst.add(agregar);
			archivo.escribirEnArchivo(lst);
			res = "El candidato se creó correctamente";
		} else {
			JOptionPane.showMessageDialog(null, "El candidato ya se encuentra registrado");
			res = "El candidato ya existe";
		}
		return res;
	}

	public String eliminarUsuario(long cedula) {
		cargarBase();
		String aux = cedula + "";
		String res = "";
		if (!aux.equals("")) {
			if (buscarUnCandidato(cedula) != null) {
				try {
					CandidatoDTO e = buscarUnCandidato(cedula);
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

	public String modificar_Candidato(String nombre, String apellido, String cargo, long cedula, int edad) {
		cargarBase();
		CandidatoDTO agregar = new CandidatoDTO(nombre, apellido, cargo, cedula, edad);

		String aux = cedula + "";
		String res = "";

		if (!aux.equals("")) {
			if (buscarUnCandidato(cedula) != null) {
				try {
					CandidatoDTO e = buscarUnCandidato(cedula);
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
	
	public void cargarBase() {
		lst = archivo.leerArchivo();
	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public ArrayList<CandidatoDTO> getLst() {
		return lst;
	}

	public void setLst(ArrayList<CandidatoDTO> lst) {
		this.lst = lst;
	}
	
}
