package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CandidatoDTO;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.CandidatoDAO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener, MouseWheelListener {

	private View vi;
	private Archivo arr;
	private CandidatoDAO canDAO;
	private ArrayList<CandidatoDTO> lst;
	private int op;
	private long eliminar;

	/**
	 * Este es el metodo constructor de la clase controller, aqui se inicializan objetos de la vista y el modelo 
	 */
	public Controller() {

		vi = new View(this);
		vi.getPrincipal().setVisible(true);
		arr = new Archivo();
		canDAO = new CandidatoDAO(arr);
		lst = arr.leerArchivo();
		op = 0;
		eliminar = 0;
	}

	
	@Override
	/**
	 * El action performed se encarga de que al momento de hacer una accion, en este caso un click en cualquier boton de los frames
	 * 
	 * @param e: la accion que se realiza
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		String pt = e.getActionCommand();

		System.out.println("Largo = " + lst.size());

		if (pt.equals("INGRESAR")) {
			vi.getPrincipal().setVisible(false);
			vi.getCrear().setVisible(true);
			op = 1;
		} else if (pt.equals("BUSCAR")) {
			op = 3;
			vi.getPrincipal().setVisible(false);
			String aux = vi.buscar();
			if (aux.contentEquals("")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else {
				if (canDAO.buscarUnCandidato(Long.parseLong(aux), lst) == null) {
					JOptionPane.showMessageDialog(null, "La cedula no coincide con ningun candidato");
					vi.getPrincipal().setVisible(true);
				} else {
					CandidatoDTO del = canDAO.buscarUnCandidato(Long.parseLong(aux), lst);
					vi.getCandidato().getNombre().setText(del.getNombre());
					vi.getCandidato().getApellido().setText(del.getApellido());
					vi.getCandidato().getCargo().setText(del.getCargo());
					vi.getCandidato().getCedula().setText(del.getCedula() + "");
					vi.getCandidato().getEdad().setText(del.getEdad() + "");
					vi.getCandidato().setVisible(true);
				}
			}
		} else if (pt.equals("ELIMINAR")) {
			op = 2;
			vi.getPrincipal().setVisible(false);
			String aux = vi.buscar();
			if (aux == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else if (aux.contentEquals("")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else {
				if (canDAO.buscarUnCandidato(Long.parseLong(aux), lst) == null) {
					JOptionPane.showMessageDialog(null, "La cedula no coincide con ningun candidato");
					vi.getPrincipal().setVisible(true);
				} else {
					CandidatoDTO del = canDAO.buscarUnCandidato(Long.parseLong(aux), lst);
					vi.getEliminar().getNombre().setText(del.getNombre());
					vi.getEliminar().getApellido().setText(del.getApellido());
					vi.getEliminar().getCargo().setText(del.getCargo());
					vi.getEliminar().getCedula().setText(del.getCedula() + "");
					vi.getEliminar().getEdad().setText(del.getEdad() + "");
					eliminar = Long.parseLong(aux);
					vi.getEliminar().setVisible(true);
				}
			}
		} else if (pt.equals("CREAR")) {
			String nombre = vi.getCrear().getNombre().getText();
			String apellido = vi.getCrear().getApellido().getText();
			String cargo = vi.getCrear().getCargo().getText();
			String ced="";
			try {
				ced = vi.getCrear().getCedula().getText();				
			} catch ( NumberFormatException e2) {
				JOptionPane.showInternalMessageDialog(null, "La cedula no esta en formato valido", "ERROR", JOptionPane.ERROR_MESSAGE, null);
				return;
			}
			String ed = vi.getCrear().getEdad().getText();
			if (nombre.contentEquals("") || apellido.contentEquals("") || cargo.contentEquals("")
					|| ced.contentEquals("") || ed.contentEquals("")) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
			} else if (Integer.parseInt(vi.getCrear().getEdad().getText()) < 0
					|| Integer.parseInt(vi.getCrear().getEdad().getText()) > 100) {
				JOptionPane.showMessageDialog(null, "La edad no es valida");
			} else {
				long cedula = Long.parseLong(vi.getCrear().getCedula().getText());
				int edad = Integer.parseInt(vi.getCrear().getEdad().getText());
				canDAO.agregar_Candidato(nombre, apellido, cargo, cedula, edad, lst);
				vi.getCrear().getNombre().setText("");
				vi.getCrear().getApellido().setText("");
				vi.getCrear().getCargo().setText("");
				vi.getCrear().getCedula().setText("");
				vi.getCrear().getEdad().setText("");

				vi.getPrincipal().setVisible(true);
				vi.getCrear().setVisible(false);

			}
		} else if (pt.equals("ATRAS")) {
			if (op == 1) {
				vi.getCrear().getNombre().setText("");
				vi.getCrear().getApellido().setText("");
				vi.getCrear().getCargo().setText("");
				vi.getCrear().getCedula().setText("");
				vi.getCrear().getEdad().setText("");
				vi.getCrear().reset();
				vi.getPrincipal().setVisible(true);
				vi.getCrear().setVisible(false);
			} else if (op == 2) {
				vi.getEliminar().getNombre().setText("");
				vi.getEliminar().getApellido().setText("");
				vi.getEliminar().getCargo().setText("");
				vi.getEliminar().getCedula().setText("");
				vi.getEliminar().getEdad().setText("");
				vi.getPrincipal().setVisible(true);
				vi.getEliminar().setVisible(false);
			} else if (op == 3) {
				vi.getCandidato().getNombre().setText("");
				vi.getCandidato().getApellido().setText("");
				vi.getCandidato().getCargo().setText("");
				vi.getCandidato().getCedula().setText("");
				vi.getCandidato().getEdad().setText("");
				vi.getPrincipal().setVisible(true);
				vi.getCandidato().setVisible(false);
				
			}else if (op == 4) {
				
				vi.getLista().setVisible(false);
				vi.getLista().limpiarTodo();
				vi.getPrincipal().setVisible(true);
				
			}
		} else if (pt.equals("ELIMINAR2")) {
			canDAO.eliminarUsuario(eliminar, lst);
			vi.getEliminar().getNombre().setText("");
			vi.getEliminar().getApellido().setText("");
			vi.getEliminar().getCargo().setText("");
			vi.getEliminar().getCedula().setText("");
			vi.getEliminar().getEdad().setText("");
			vi.getPrincipal().setVisible(true);
			vi.getEliminar().setVisible(false);

		}
		else if (pt.equals("LISTAR")) {
			
			op = 4;
			for(int i = 0; i < lst.size(); i++) {
				
				vi.getLista().rellenarDatos(lst.get(i).getNombre()+ " " + lst.get(i).getApellido(), lst.get(i).getCargo(), lst.get(i).getEdad(), lst.get(i).getCedula());
				
			}
			
			vi.getLista().generarScroll();
			vi.getPrincipal().setVisible(false);
			vi.getLista().setVisible(true);
			
		}else if(pt.equals("MODIFICAR")) {
			
			op = 1;
			
			vi.getPrincipal().setVisible(false);
			String aux = vi.buscar();
			if (aux == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else if (aux.contentEquals("")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else {
				if (canDAO.buscarUnCandidato(Long.parseLong(aux), lst) == null) {
					JOptionPane.showMessageDialog(null, "La cedula no coincide con ningun candidato");
					vi.getPrincipal().setVisible(true);
				} else {
			CandidatoDTO mod = canDAO.buscarUnCandidato(Long.parseLong(aux), lst);
			
			vi.getCrear().getNombre().setText(mod.getNombre());
			vi.getCrear().getApellido().setText(mod.getApellido());
			vi.getCrear().getCargo().setText(mod.getCargo());
			vi.getCrear().getCedula().setText(mod.getCedula()+"");
			vi.getCrear().getEdad().setText(mod.getEdad()+"");
			
			vi.getCrear().modificar();
			vi.getPrincipal().setVisible(false);
			vi.getCrear().setVisible(true);
			
				}
			}
			
		}else if(pt.equals("MODIFICAR2")) {
			
			String nombre = vi.getCrear().getNombre().getText();
			String apellido = vi.getCrear().getApellido().getText();
			String cargo = vi.getCrear().getCargo().getText();
			String ced = vi.getCrear().getCedula().getText();
			String ed = vi.getCrear().getEdad().getText();
			if (nombre.contentEquals("") || apellido.contentEquals("") || cargo.contentEquals("")
					|| ced.contentEquals("") || ed.contentEquals("")) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
			} else if (Integer.parseInt(vi.getCrear().getEdad().getText()) < 0
					|| Integer.parseInt(vi.getCrear().getEdad().getText()) > 100) {
				JOptionPane.showMessageDialog(null, "La edad no es valida");
			}else {
				
				canDAO.modificar_Candidato(nombre, apellido, cargo, Long.parseLong(ced), Integer.parseInt(ed), lst);
				
			}
			
			vi.getCrear().getNombre().setText("");
			vi.getCrear().getApellido().setText("");
			vi.getCrear().getCargo().setText("");
			vi.getCrear().getCedula().setText("");
			vi.getCrear().getEdad().setText("");
			
			vi.getPrincipal().setVisible(true);
			vi.getCrear().setVisible(false); 
				}
			}

	@Override
	/**
	 * EL metodo decide que hacer en caso de que la rueda del mouse se mueva
	 * 
	 * @param e: la accion de mover la rueda del mouse
	 */
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(vi.getLista())) {
			
			if(e.getWheelRotation() > 0) {
				vi.getLista().movimientoScroll(e.getUnitsToScroll(), 1);
			}else {
				vi.getLista().movimientoScroll(e.getUnitsToScroll(), 2);
			}
			
		}
		
	}

}
