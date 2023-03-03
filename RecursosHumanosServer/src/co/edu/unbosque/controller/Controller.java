package co.edu.unbosque.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.CandidatoDTO;
import co.edu.unbosque.modelPersistence.Archivo;
import co.edu.unbosque.modelPersistence.CandidatoDAO;
import co.edu.unbosque.server.Servidor;

public class Controller {

	public Controller() {
		
		Servidor s = new Servidor(5000);
		s.start();
		
	}
	
}
