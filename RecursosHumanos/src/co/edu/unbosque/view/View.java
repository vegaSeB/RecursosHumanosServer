package co.edu.unbosque.view;

import javax.swing.JOptionPane;

import co.edu.unbosque.controller.Controller;

public class View{
	
	FramePrincipal principal;
	FrameCrear crear;
	FrameListar lista;
	FrameCandidato candidato;
	FrameEliminar eliminar;
	
	/**
	 * Este es el metodo constructor de la clase, en este se inicializan todos los elementos graficos, asigna el action listener
	 *  a todos los elementos, además de configurar el frame
	 *  
	 *  @param con: es el action listener de los elementos graficos
	 */
	public View(Controller con) {
		
		this.principal = new FramePrincipal(con);
		this.crear = new FrameCrear(con);
		this.lista = new FrameListar(con,con);
		this.candidato = new FrameCandidato(con);
		this.eliminar = new FrameEliminar(con);
		
		
	}
	
	/**
	 * Este es el get, permite llamar al frame principal
	 *  
	 *  @return retorna el frame principal
	 */
	public FramePrincipal getPrincipal() {
		return principal;
	}
	
	/**
	 * Este es el get, permite llamar al frame crear
	 *  
	 *  @return retorna el frame crear
	 */
	public FrameCrear getCrear() {
		return crear;
	}
	
	/**
	 * Este es el get, permite llamar al frame lista
	 *  
	 *  @return retorna el frame lista
	 */
	public FrameListar getLista() {
		return lista;
	}
	
	/**
	 * Este es el get, permite llamar al frame candidato
	 *  
	 *  @return retorna el frame candidato
	 */
	public FrameCandidato getCandidato() {
		return candidato;
	}
	
	/**
	 * Este es el get, permite llamar al frame eliminar
	 *  
	 *  @return retorna el frame eliminar
	 */
	public FrameEliminar getEliminar() {
		return eliminar;
	}

	/**
	 * Genera un joptionpane para buscar una cedula
	 *  
	 *  @return retorna la cedula que se ingresa en forma de String
	 */
	public String buscar(){
		
		return JOptionPane.showInputDialog(null, "Ingrese la cedula de la persona a buscar");
		
	}
	public void mostrar(String msg) {
		
		JOptionPane.showMessageDialog(null, msg);
		
	}
	public void error(String err) {
		
		JOptionPane.showInternalMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE, null);
		
	}

}
