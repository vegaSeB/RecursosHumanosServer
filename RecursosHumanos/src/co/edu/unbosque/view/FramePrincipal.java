package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;

import co.edu.unbosque.controller.Controller;

public class FramePrincipal extends JFrame {
	
	private JButton ingresar;
	private JButton listar;
	private JButton eliminar;
	private JButton modificar;
	private JButton buscar;
	private JLabel imagen, botones, vacio;
	public static final String INGRESAR = "INGRESAR";
	public static final String LISTAR = "LISTAR";
	public static final String ELIMINAR = "ELIMINAR";
	public static final String BUSCAR = "BUSCAR";
	public static final String MODIFICAR = "MODIFICAR";

	/**
	 * Este es el metodo constructor de la clase, en este se inicializan todos los elementos graficos, asigna el action listener
	 *  a todos los elementos, además de configurar el frame
	 *  
	 *  @param con: es el action listener de los elementos graficos
	 */
	public FramePrincipal(Controller con) {
		
		
		ingresar = new JButton("Ingresar");
		ingresar.setActionCommand(INGRESAR);
		ingresar.addActionListener(con);
		listar = new JButton("Listar");
		listar.setActionCommand(LISTAR);
		listar.addActionListener(con);
		eliminar = new JButton("Eliminar");
		eliminar.setActionCommand(ELIMINAR);
		eliminar.addActionListener(con);
		buscar = new JButton("Buscar");
		buscar.setActionCommand(BUSCAR);
		buscar.addActionListener(con);
		modificar = new JButton("Modificar");
		modificar.setActionCommand(MODIFICAR);
		modificar.addActionListener(con);
		botones = new JLabel();
		botones.setLayout(new GridLayout(2,3,10,10));
		vacio = new JLabel();
		imagen = new JLabel();
		imagen.setBackground(Color.WHITE);
		imagen.setIcon(new ImageIcon("src/co/edu/unbosque/util/istockphoto-1301592032-1024x1024.jpg"));
		imagen.setOpaque(true);
		
		botones.add(ingresar);
		botones.add(vacio);
		botones.add(buscar);
		botones.add(eliminar);
		botones.add(listar);
		botones.add(modificar);
		
		this.setSize(1000, 1000);
 		this.add(imagen);
		this.add(botones);
		this.setLayout(new GridLayout(2,1,25,25));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}
	
}
