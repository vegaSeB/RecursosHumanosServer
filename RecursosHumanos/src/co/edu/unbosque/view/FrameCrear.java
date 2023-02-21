package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.*;

import co.edu.unbosque.controller.Controller;

public class FrameCrear extends JFrame {
	
	private JButton crear, atras;
	private JTextField nombre, apellido, cedula, edad, cargo;
	private JLabel Tnombre, Tapellido, Tcedula, Tedad, Tcargo,datos,botones;
	public static final String CREAR = "CREAR";
	public static final String MODIFICAR = "MODIFICAR2";
	public static final String ATRAS = "ATRAS";
	
	
	/**
	 * Este es el metodo constructor de la clase, en este se inicializan todos los elementos graficos, asigna el action listener
	 *  a todos los elementos, además de configurar el frame
	 *  
	 *  @param con: es el action listener de los elementos graficos
	 */
	public FrameCrear(Controller con) {
		
		crear = new JButton("Crear");
		crear.setActionCommand(CREAR);
		crear.addActionListener(con);
		atras = new JButton("Atras");
		atras.setActionCommand(ATRAS);
		atras.addActionListener(con);
		nombre = new JTextField();
		apellido = new JTextField();
		cedula = new JTextField();
		edad = new JTextField();
		cargo = new JTextField();
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
		botones.add(crear);
		
		
		this.setSize(1000, 500);
 		this.add(datos);
		this.add(botones);
		this.setLayout(new GridLayout(2,1,25,25));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}

	/**
	 * Este es el get, permite llamar al boton crear
	 *  
	 *  @return retorna el boton de crear
	 */
	public JButton getCrear() {
		return crear;
	}

	/**
	 * Este es el set, permite cambiar al boton atras
	 *  
	 *  @param cargo: el label que remplazaría al boton
	 */
	public void setCrear(JButton crear) {
		this.crear = crear;
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
	 *  @return retorna el label del nombre
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
	 *  @return retorna el label del apellido
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
	 *  @return retorna el label de la cedula
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
	 *  @return retorna el label del cargo
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
	 *  @return retorna el boton de atras
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
	 * Este es el get, permite llamar el text field donde esta escrito el nombre
	 *  
	 *  @return retorna el text field
	 */
	public JTextField getNombre() {
		return nombre;
	}

	/**
	 * Este es el set, permite cambiar al text field del nombre
	 *  
	 *  @param cargo: el text field que remplazaría al del nombre
	 */
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este es el get, permite llamar text field donde esta escrito el apellido
	 *  
	 *  @return retorna el text field
	 */
	public JTextField getApellido() {
		return apellido;
	}

	/**
	 * Este es el set, permite cambiar al text field del apellido
	 *  
	 *  @param cargo: el text field que remplazaría al del apellido
	 */
	public void setApellido(JTextField apellido) {
		this.apellido = apellido;
	}

	/**
	 * Este es el get, permite llamar al text field donde esta escrita la cedula
	 *  
	 *  @return retorna el text field
	 */
	public JTextField getCedula() {
		return cedula;
	}

	/**
	 * Este es el set, permite cambiar al text field de la cedula
	 *  
	 *  @param cargo: el text field que remplazaría al de la cedula
	 */
	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	/**
	 * Este es el get, permite llamar el text field donde esta escrita la edad
	 *  
	 *  @return retorna text field de la edad
	 */
	public JTextField getEdad() {
		return edad;
	}

	/**
	 * Este es el set, permite cambiar al text field de la edad
	 *  
	 *  @param cargo: el text field que remplazaría al de la edad
	 */
	public void setEdad(JTextField edad) {
		this.edad = edad;
	}

	/**
	 * Este es el get, permite llamar text field donde esta escrito el cargo
	 *  
	 *  @return retorna el text field del cargo
	 */
	public JTextField getCargo() {
		return cargo;
	}

	/**
	 * Este es el set, permite cambiar al text field de cargo
	 *  
	 *  @param cargo: el text field que remplazaría al del cargo
	 */
	public void setCargo(JTextField cargo) {
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
	
	/**
	 * El metodo cambia el texto y la accion del boton crear
	 */
	public void modificar() {
		
		crear.setText("Modificar");
		crear.setActionCommand(MODIFICAR);
		
	}
	
	/**
	 * El metodo hace que el texto y accion de crear vuelvan a lo normal
	 */
	public void reset() {
		
		crear.setText("Crear");
		crear.setActionCommand(CREAR);
		
	}
	
}
