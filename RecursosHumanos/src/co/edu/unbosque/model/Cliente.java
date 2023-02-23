package co.edu.unbosque.model;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread {

	private Socket cliente;
	private ObjectInputStream recibir;
	private ObjectOutputStream enviar;
	private int port, opcion;
	private String address, datos;

	public Cliente(String aux, int aux2) {
		// TODO Auto-generated constructor stub

		cliente = null;
		recibir = null;
		enviar = null;
		opcion = 0;
		address = aux;
		port = aux2;

	}

	public void enviar(String persona) {
		try {
			cliente = new Socket(address, port);
			enviar = new ObjectOutputStream(cliente.getOutputStream());
			enviar.writeObject(persona);
			enviar.close();
			cliente.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String recibir() {
		String ret = "";
		try {
			cliente = new Socket(address, port);
			recibir = new ObjectInputStream(new BufferedInputStream(cliente.getInputStream()));
			ret = (String)recibir.readObject();
			recibir.close();
			cliente.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			switch (opcion) {
			case 1: {
				String aux = "CREAR _ " + datos; 
				this.enviar(aux);
				suspend();
			}
//			case 2: {
//				String aux = "BUSCAR _ " + datos; 
//				this.enviar(aux);
//				suspend();
//			}
			}

	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		Cliente cli = new Cliente("localhost", 5001);
//		cli.start();
//		while (true) {
//			System.out.println("1) Crear \n 2) Eliminar 3) Ver");
//			int pt = sc.nextInt();
//			switch (pt) {
//			case 1: {
//				sc.nextLine();
//				String nombre = sc.nextLine();
//				String apellido = sc.nextLine();
//				String cargo = sc.nextLine();
//				Long cedula = sc.nextLong();
//				int edad = sc.nextInt();
//				
//				String aux = "CREAR _ " + nombre + " / " + apellido + " _ " + cargo + " / " + cedula + " _ " + edad; 
//				cli.enviar(aux);
//				break;	
//			}
//			}
//
//		}
//
//	}
	
	public void setOpcion(int opcion) {
		
		this.opcion = opcion;
		
	}
	public void setDatos(String datos) {
		
		this.datos = datos;
		
	}
	
}