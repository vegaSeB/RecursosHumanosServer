package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CandidatoDTO;
import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener, MouseWheelListener {

	private View vi;
	private int op;
	private long eliminar;
	private Cliente clt;
	private String cedModificar;

	/**
	 * Este es el metodo constructor de la clase controller, aqui se inicializan
	 * objetos de la vista y el modelo
	 */
	public Controller() {

		vi = new View(this);
		vi.getPrincipal().setVisible(true);
		op = 0;
		clt = new Cliente("localhost", 5000);
		clt.run();
		eliminar = 0;
	}

	@Override
	/**
	 * El action performed se encarga de que al momento de hacer una accion, en este
	 * caso un click en cualquier boton de los frames
	 * 
	 * @param e: la accion que se realiza
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		String pt = e.getActionCommand();

		if (pt.equals("INGRESAR")) {
			vi.getPrincipal().setVisible(false);
			vi.getCrear().setVisible(true);
			op = 1;
		} else if (pt.equals("BUSCAR")) {
			op = 3;
			vi.getPrincipal().setVisible(false);
			String aux = vi.buscar();
			if (aux.contentEquals("")) {
				vi.mostrar("Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else {
				CandidatoDTO nuevo = (CandidatoDTO) clt.recibir("PROBAR _ " + aux);
				if (nuevo == null) {
					vi.mostrar("La cedula no coincide con ningun candidato");
					vi.getPrincipal().setVisible(true);
				} else {
					vi.getCandidato().getNombre().setText(nuevo.getNombre());
					vi.getCandidato().getApellido().setText(nuevo.getApellido());
					vi.getCandidato().getCargo().setText(nuevo.getCargo());
					vi.getCandidato().getCedula().setText(nuevo.getCedula() + "");
					vi.getCandidato().getEdad().setText(nuevo.getEdad() + "");
					vi.getCandidato().setVisible(true);
				}
			}
		} else if (pt.equals("CREAR")) {
			String nombre = vi.getCrear().getNombre().getText();
			String apellido = vi.getCrear().getApellido().getText();
			String cargo = vi.getCrear().getCargo().getText();
			String ced = vi.getCrear().getCedula().getText();
			String ed = vi.getCrear().getEdad().getText();
			if (nombre.contentEquals("") || apellido.contentEquals("") || cargo.contentEquals("")
					|| ced.contentEquals("") || ed.contentEquals("")) {
				vi.error("Por favor ingrese todos los datos");
			} else if (soloNumeros(ced) == false) {
				vi.error("La cedula no debe contener caracteres especiales");
			} else if (soloNumeros(ed) == false) {
				vi.error("La edad no debe contener caracteres especiales");
			} else if (Integer.parseInt(vi.getCrear().getEdad().getText()) < 0
					|| Integer.parseInt(vi.getCrear().getEdad().getText()) > 100) {
				vi.error("La edad no es valida");
			} else if (soloLetras(nombre) == false) {
				vi.error("El nombre solo debe contener letras");
			} else if (soloLetras(apellido) == false) {
				vi.error("El apellido solo debe contener letras");
			} else if (soloLetras(cargo) == false) {
				vi.error("El cargo solo debe tener letra");
			} else {
				long cedula = Long.parseLong(vi.getCrear().getCedula().getText());
				int edad = Integer.parseInt(vi.getCrear().getEdad().getText());
				
				String aux = "CREAR _ " + nombre + " / " + apellido + " _ " + cargo + " / " + cedula + " _ " + edad;
				clt.enviar(aux);
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

			} else if (op == 4) {

				vi.getLista().setVisible(false);
				vi.getLista().limpiarTodo();
				vi.getPrincipal().setVisible(true);

			}
		} else if (pt.equals("ELIMINAR")) {
			op = 2;
			vi.getPrincipal().setVisible(false);
			String aux = vi.buscar();
			if (aux == null) {
				vi.error("Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else if (aux.contentEquals("")) {
				vi.error("Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else if (soloNumeros(aux) == false) {
				vi.error("La cedula no debe contener caracteres especiales");
			} else {
				
				CandidatoDTO del = (CandidatoDTO) clt.recibir("PROBAR _ " + aux);
				
				if (del == null) {
					vi.error("La cedula no coincide con ningun candidato");
					vi.getPrincipal().setVisible(true);
				} else {
					vi.getEliminar().getNombre().setText(del.getNombre());
					vi.getEliminar().getApellido().setText(del.getApellido());
					vi.getEliminar().getCargo().setText(del.getCargo());
					vi.getEliminar().getCedula().setText(del.getCedula() + "");
					vi.getEliminar().getEdad().setText(del.getEdad() + "");
					eliminar = Long.parseLong(aux);
					vi.getEliminar().setVisible(true);
				}
			}
		} else if (pt.equals("ELIMINAR2")) {
			clt.enviar("ELIMINAR _ " + eliminar);
			vi.getEliminar().getNombre().setText("");
			vi.getEliminar().getApellido().setText("");
			vi.getEliminar().getCargo().setText("");
			vi.getEliminar().getCedula().setText("");
			vi.getEliminar().getEdad().setText("");
			vi.getPrincipal().setVisible(true);
			vi.getEliminar().setVisible(false);

		} else if (pt.equals("LISTAR")) {
			ArrayList<CandidatoDTO> lst = clt.tomarLista();
			System.out.println("lst = " + lst.size());
			
			op = 4;
			
			for (int i = 0; i < lst.size(); i++) {

				vi.getLista().rellenarDatos(lst.get(i).getNombre() + " " + lst.get(i).getApellido(),
						lst.get(i).getCargo(), lst.get(i).getEdad(), lst.get(i).getCedula());

			}

			vi.getLista().generarScroll();
			vi.getPrincipal().setVisible(false);
			vi.getLista().setVisible(true);

		} else if (pt.equals("MODIFICAR")) {
			op = 1;
			vi.getPrincipal().setVisible(false);
			String aux = vi.buscar();
			if (aux == null) {
				vi.error("Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else if (aux.contentEquals("")) {
				vi.error("Debe ingresar algun valor");
				vi.getPrincipal().setVisible(true);
			} else {
				CandidatoDTO mod= (CandidatoDTO) clt.recibir("PROBAR _ " + aux);
				if (mod == null) {
					vi.error("La cedula no coincide con ningun candidato");
					vi.getPrincipal().setVisible(true);
				} else {
					vi.getCrear().getNombre().setText(mod.getNombre());
					vi.getCrear().getApellido().setText(mod.getApellido());
					vi.getCrear().getCargo().setText(mod.getCargo());
					vi.getCrear().getCedula().setText(mod.getCedula() + "");
					vi.getCrear().getEdad().setText(mod.getEdad() + "");

					cedModificar = aux;
					
					vi.getCrear().modificar();
					vi.getPrincipal().setVisible(false);
					vi.getCrear().setVisible(true);

				}
			}

		} else if (pt.equals("MODIFICAR2")) {

			String nombre = vi.getCrear().getNombre().getText();
			String apellido = vi.getCrear().getApellido().getText();
			String cargo = vi.getCrear().getCargo().getText();
			String ced = vi.getCrear().getCedula().getText();
			String ed = vi.getCrear().getEdad().getText();
			if (nombre.contentEquals("") || apellido.contentEquals("") || cargo.contentEquals("")
					|| ced.contentEquals("") || ed.contentEquals("")) {
				vi.error("Por favor ingrese todos los datos");
			} else if (Integer.parseInt(vi.getCrear().getEdad().getText()) < 0
					|| Integer.parseInt(vi.getCrear().getEdad().getText()) > 100) {
				vi.error("La edad no es valida");
			} else {
				
				clt.enviar("Modificar _ " + nombre + " / " + apellido + " _ " + cargo + " / " + ced + " _ " + ed + " / " + cedModificar);
				

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
		if (e.getSource().equals(vi.getLista())) {

			if (e.getWheelRotation() > 0) {
				vi.getLista().movimientoScroll(e.getUnitsToScroll(), 1);
			} else {
				vi.getLista().movimientoScroll(e.getUnitsToScroll(), 2);
			}

		}
	}
	
	public boolean soloNumeros(String pt) {
		try {
			Long aux = Long.parseLong(pt);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean soloLetras(String pt) {
		if (!pt.matches("[a-zA-Z ]*")) {
			return false;
		} else {
			return true;
		}
	}

}
