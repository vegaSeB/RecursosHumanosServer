package co.edu.unbosque.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Thread {

	private Socket cliente;
	private ServerSocket servidor; 
	private ObjectInputStream recibir;
	private ObjectOutputStream enviar;
	private int port;
	private String address, persona;

	public Cliente(String aux, int aux2) {
		// TODO Auto-generated constructor stub

		cliente = null;
		recibir = null;
		enviar = null;
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

	public Object recibir(String cedula) {
		
		Object salida = true;
		
		try {
			cliente = new Socket(address, port);
			enviar = new ObjectOutputStream(cliente.getOutputStream());
			enviar.writeObject(cedula);

			
			servidor = new ServerSocket(port+1);
			cliente = servidor.accept();
			recibir = new ObjectInputStream(cliente.getInputStream());
			CandidatoDTO aux = (CandidatoDTO) recibir.readObject();
			if (aux == null) {
				cliente.close();
				enviar.close();
				servidor.close();
				recibir.close();
				salida = null;
			} else {
				cliente.close();
				enviar.close();
				servidor.close();
				recibir.close();
				salida =  aux;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return salida;
	}
	
	public ArrayList<CandidatoDTO> tomarLista(){
		ArrayList<CandidatoDTO> lst = new ArrayList<>();
		try {
			cliente = new Socket(address, port);
			enviar = new ObjectOutputStream(cliente.getOutputStream());
			enviar.writeObject("LISTA");

			
			servidor = new ServerSocket(port+2);
			cliente = servidor.accept();
			recibir = new ObjectInputStream(cliente.getInputStream());
			lst = (ArrayList<CandidatoDTO>) recibir.readObject();
			
			cliente.close();
			enviar.close();
			servidor.close();
			recibir.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lst;
	}
	
}