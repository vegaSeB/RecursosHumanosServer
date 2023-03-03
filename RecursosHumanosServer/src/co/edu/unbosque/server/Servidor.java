package co.edu.unbosque.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.CandidatoDTO;
import co.edu.unbosque.modelPersistence.Archivo;
import co.edu.unbosque.modelPersistence.CandidatoDAO;

public class Servidor extends Thread{

	private ServerSocket servidor;
	private Socket cliente, respuesta;
	private ObjectInputStream recibir;
	private ObjectOutputStream enviar;
	private int port;
	private CandidatoDAO canDao;
	private Archivo arr;
	private String loc;

	public Servidor(int portt) {
		// TODO Auto-generated constructor stub
		try {
			servidor = null;
			cliente = null;
			recibir = null;
			enviar = null;
			port = portt;
			arr = new Archivo();
			canDao = new CandidatoDAO(arr);
			loc = "localhost";

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void run() {
		while (true) {
			try {
				servidor = new ServerSocket(port);
				System.out.println("Esperando..");
				cliente = servidor.accept();
				System.out.println("Aceptado");
				recibir = new ObjectInputStream(cliente.getInputStream());
				String aux = (String) recibir.readObject();
				if (aux.contains("CREAR _ ")) {
					String nombre = aux.substring(aux.indexOf('_') + 2, aux.indexOf('/') - 1);
					aux = aux.substring(aux.indexOf('_') + 2, aux.length());
					String apellido = aux.substring(aux.indexOf('/') + 2, aux.indexOf('_') - 1);
					aux = aux.substring(aux.indexOf('/') + 2, aux.length());
					String cargo = aux.substring(aux.indexOf('_') + 2, aux.indexOf('/') - 1);
					aux = aux.substring(aux.indexOf('_') + 2, aux.length());
					long cedula = Long.parseLong(aux.substring(aux.indexOf('/') + 2, aux.indexOf('_') - 1));
					aux = aux.substring(aux.indexOf('/') + 2, aux.length());
					int edad = Integer.parseInt(aux.substring(aux.indexOf('_') + 2, aux.length()));

					canDao.agregar_Candidato(nombre, apellido, cargo, cedula, edad);
					System.out.println("Se agrego");

				} else if (aux.contains("PROBAR _ ")) {
					respuesta = new Socket(loc, port + 1);
					String pt = aux.substring(aux.indexOf('_') + 2, aux.length());
					long cedula = Long.parseLong(pt);
					if (canDao.buscarUnCandidato(cedula) == null) {
						enviar = new ObjectOutputStream(respuesta.getOutputStream());
						enviar.writeObject(null);
					} else {
						CandidatoDTO salida = canDao.buscarUnCandidato(cedula);
						enviar = new ObjectOutputStream(respuesta.getOutputStream());
						enviar.writeObject(salida);
					}
				} else if (aux.contains("ELIMINAR _")) {
					long eliminar = Long.parseLong(aux.substring(aux.indexOf('_') + 2, aux.length()));
					canDao.eliminarUsuario(eliminar);
				} else if (aux.contains("LISTA")) {
					respuesta = new Socket(loc, port + 2);
					enviar = new ObjectOutputStream(respuesta.getOutputStream());
					enviar.writeObject(canDao.getLst());
				} else if (aux.contains("Modificar _")) {
					String nombre = aux.substring(aux.indexOf('_') + 2, aux.indexOf('/') - 1);
					aux = aux.substring(aux.indexOf('_') + 2, aux.length());
					String apellido = aux.substring(aux.indexOf('/') + 2, aux.indexOf('_') - 1);
					aux = aux.substring(aux.indexOf('/') + 2, aux.length());
					String cargo = aux.substring(aux.indexOf('_') + 2, aux.indexOf('/') - 1);
					aux = aux.substring(aux.indexOf('_') + 2, aux.length());
					long cedula = Long.parseLong(aux.substring(aux.indexOf('/') + 2, aux.indexOf('_') - 1));
					aux = aux.substring(aux.indexOf('/') + 2, aux.length());
					int edad = Integer.parseInt(aux.substring(aux.indexOf('_') + 2, aux.indexOf('/')-1));
					aux = aux.substring(aux.indexOf("/")+2, aux.length());
					canDao.eliminarUsuario(Long.parseLong(aux));
					canDao.agregar_Candidato(nombre, apellido, cargo, cedula, edad);
				}

				servidor.close();
				enviar.close();
				recibir.close();
				cliente.close();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
}
