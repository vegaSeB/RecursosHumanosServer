package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.edu.unbosque.controller.Controller;

public class FrameEliminar extends JFrame {

	private JButton eliminar, atras;
	private JLabel Tnombre, Tapellido, Tcedula, Tedad, Tcargo,datos, botones, nombre, apellido, cedula, edad, cargo;
	public static final String ATRAS = "ATRAS";
	public static final String ELIMINAR = "ELIMINAR2";
	
	/**
	 * Este es el metodo constructor de la clase, en este se inicializan todos los elementos graficos, asigna el action listener
	 *  a todos los elementos, además de configurar el frame
	 *  
	 *  @param con: es el action listener de los elementos graficos
	 */
	public FrameEliminar(Controller con) {
		
		eliminar = new JButton("Eliminar");
		eliminar.setActionCommand(ELIMINAR);
		eliminar.addActionListener(con);
		atras = new JButton("Atras");
		atras.setActionCommand(ATRAS);
		atras.addActionListener(con);
		nombre = new JLabel("");
		apellido = new JLabel("");
		cedula = new JLabel("");
		edad = new JLabel("");
		cargo = new JLabel("");
		Tnombre = new JLabel("Nombre:");
		Tapellido = new JLabel("Apellido:");
		Tcedula = new JLabel("Cedula:");
		Tedad = new JLabel("Edad:");
		Tcargo = new JLabel("Cargo:");
		datos = new JLabel();
		datos.setLayout(new GridLayout(5,2));
		datos.add(Tnombre);
		datos.add(nombre);
		datos.add(Tapellido);
		datos.add(apellido);
		datos.add(Tcedula);
		datos.add(cedula);
		datos.add(Tedad);
		datos.add(edad);
		datos.add(Tcargo);
		datos.add(cargo);
		botones = new JLabel();
		botones.setLayout(new GridLayout(1,2));
		botones.add(atras);
		botones.add(eliminar);
		
		
		this.setSize(300, 800);
 		this.add(datos);
		this.add(botones);
		this.setLayout(new GridLayout(2,1,25,25));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}

	/**
	 * Este es el get, permite llamar al boton eliminar
	 *  
	 *  @return retorna el boton de eliminar
	 */
	public JButton getEliminar() {
		return eliminar;
	}

	/**
	 * Este es el set, permite cambiar al boton eliminar
	 *  
	 *  @param cargo: el remplazo del boton
	 */
	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	/**
	 * Este es el get, permite llamar al boton atras
	 *  
	 *  @return retorna el boton de atras
	 */
	public JButton getAtras() {
		return atras;
	}

	/**
	 * Este es el set, permite cambiar al boton atras
	 *  
	 *  @param cargo: el label que remplazaría al boton
	 */
	public void setAtras(JButton atras) {
		this.atras = atras;
	}

	/**
	 * Este es el get, permite llamar al label del nombre
	 *  
	 *  @return retorna el label del texto del cargo
	 */
	public JLabel getTnombre() {
		return Tnombre;
	}

	/**
	 * Este es el set, permite cambiar al label del nombre
	 *  
	 *  @param cargo: el label que remplazaría al del cargo
	 */
	public void setTnombre(JLabel tnombre) {
		Tnombre = tnombre;
	}

	/**
	 * Este es el get, permite llamar label del apellido
	 *  
	 *  @return retorna el label del texto del apellido
	 */
	public JLabel getTapellido() {
		return Tapellido;
	}

	/**
	 * Este es el set, permite cambiar al label del apellido
	 *  
	 *  @param cargo: el label que remplazaría al del apellido
	 */
	public void setTapellido(JLabel tapellido) {
		Tapellido = tapellido;
	}

	/**
	 * Este es el get, permite llamar label de la cedula
	 *  
	 *  @return retorna el label del texto de la cedula
	 */
	public JLabel getTcedula() {
		return Tcedula;
	}

	/**
	 * Este es el set, permite cambiar al label de la cedula
	 *  
	 *  @param cargo: el label que remplazaría al de la cedula
	 */
	public void setTcedula(JLabel tcedula) {
		Tcedula = tcedula;
	}

	/**
	 * Este es el get, permite llamar label de la edad
	 *  
	 *  @return retorna el label de la edad
	 */
	public JLabel getTedad() {
		return Tedad;
	}

	/**
	 * Este es el set, permite cambiar al label de la edad
	 *  
	 *  @param cargo: el label que remplazaría al de la edad
	 */
	public void setTedad(JLabel tedad) {
		Tedad = tedad;
	}

	/**
	 * Este es el get, permite llamar label del cargo
	 *  
	 *  @return retorna el label de cargo
	 */
	public JLabel getTcargo() {
		return Tcargo;
	}

	/**
	 * Este es el set, permite cambiar al label del cargo
	 *  
	 *  @param cargo: el label que remplazaría al del cargo
	 */
	public void setTcargo(JLabel tcargo) {
		Tcargo = tcargo;
	}

	/**
	 * Este es el get, permite llamar label de datos donde se encuentran todos los demás labels
	 *  
	 *  @return retorna el label de datos
	 */
	public JLabel getDatos() {
		return datos;
	}

	/**
	 * Este es el set, permite cambiar al label del nombre
	 *  
	 *  @param cargo: el label que remplazaría al del nombre
	 */
	public void setDatos(JLabel datos) {
		this.datos = datos;
	}
	
	/**
	 * Este es el get, permite llamar label donde esta escrito el nombre
	 *  
	 *  @return retorna el label de la cedula
	 */
	public JLabel getNombre() {
		return nombre;
	}

	/**
	 * Este es el set, permite cambiar al label del nombre
	 *  
	 *  @param cargo: el label que remplazaría al del nombre
	 */
	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este es el get, permite llamar label donde esta escrito el apellido
	 *  
	 *  @return retorna el label de la cedula
	 */
	public JLabel getApellido() {
		return apellido;
	}

	/**
	 * Este es el set, permite cambiar al label del apellido
	 *  
	 *  @param cargo: el label que remplazaría al del apellido
	 */
	public void setApellido(JLabel apellido) {
		this.apellido = apellido;
	}

	/**
	 * Este es el get, permite llamar label donde esta escrita la cedula
	 *  
	 *  @return retorna el label de la cedula
	 */
	public JLabel getCedula() {
		return cedula;
	}

	/**
	 * Este es el set, permite cambiar al label de la edad
	 *  
	 *  @param cargo: el label que remplazaría al de la cedula
	 */
	public void setCedula(JLabel cedula) {
		this.cedula = cedula;
	}

	/**
	 * Este es el get, permite llamar label donde esta escrita la edad
	 *  
	 *  @return retorna el label de la edad
	 */
	public JLabel getEdad() {
		return edad;
	}

	/**
	 * Este es el set, permite cambiar al label de la edad
	 *  
	 *  @param cargo: el label que remplazaría al de la edad
	 */
	public void setEdad(JLabel edad) {
		this.edad = edad;
	}

	/**
	 * Este es el get, permite llamar label donde esta escrito el cargo
	 *  
	 *  @return retorna el label del cargo
	 */
	public JLabel getCargo() {
		return cargo;
	}

	/**
	 * Este es el set, permite cambiar al label de cargo
	 *  
	 *  @param cargo: el label que remplazaría al del cargo
	 */
	public void setCargo(JLabel cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Este es el get, permite llamar label donde se encuentran los botones
	 *  
	 *  @return retorna el label
	 */
	public JLabel getBotones() {
		return botones;
	}

	/**
	 * Este es el set, permite cambiar al label de los botones
	 *  
	 *  @param cargo: el label que remplazaría al label
	 */
	public void setBotones(JLabel botones) {
		this.botones = botones;
	}
}
