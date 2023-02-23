package serverBs;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{

	private ServerSocket servidor;
	private Socket cliente, envio;
	private ObjectInputStream recibir;
	private ObjectOutputStream enviar;
	private int port;
	private CandidatoDAO canDao;
	private Archivo arr;
	
	public Servidor(int portt) {
		// TODO Auto-generated constructor stub
		try {
			servidor = null;
			cliente = null;
			recibir = null;
			enviar = null;
			envio = null;
			port = portt;
			arr = new Archivo();
			canDao = new CandidatoDAO(arr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void run() {
		try {
			servidor = new ServerSocket(port);
			System.out.println("Esperando..");
			cliente = servidor.accept();
			System.out.println("Aceptado");
			recibir = new ObjectInputStream(cliente.getInputStream());
			
			String aux = (String) recibir.readObject();
			if (aux.contains("CREAR _ ")) {
				
				String nombre = aux.substring(aux.indexOf('_')+2, aux.indexOf('/')-1);
				aux = aux.substring(aux.indexOf('_')+2, aux.length());
				String apellido = aux.substring(aux.indexOf('/')+2,aux.indexOf('_')-1);
				aux = aux.substring(aux.indexOf('/')+2,aux.length());
				String cargo = aux.substring(aux.indexOf('_')+2, aux.indexOf('/')-1);
				aux = aux.substring(aux.indexOf('_')+2,aux.length());
				long cedula = Long.parseLong(aux.substring(aux.indexOf('/')+2, aux.indexOf('_')-1));
				aux = aux.substring(aux.indexOf('/')+2,aux.length());
				int edad = Integer.parseInt(aux.substring(aux.indexOf('_')+2, aux.length()));
				
				System.out.println(canDao.agregar_Candidato(nombre, apellido, cargo, cedula, edad));
//				System.out.println("Se agrego");
				
			}else if (aux.contains("BUSCAR _ ")) {
				
				envio = new Socket(cliente.getInetAddress(), this.port + 1);
				enviar = new ObjectOutputStream(envio.getOutputStream());
				
				if (canDao.buscarUnCandidato(Long.parseLong(aux.substring(aux.indexOf('/')+2, aux.indexOf('_')-1))) == null) {
					enviar.writeObject(null);
					enviar.close();
				}else {
					CandidatoDTO can = canDao.buscarUnCandidato(Long.parseLong(aux.substring(aux.indexOf('/')+2, aux.indexOf('_')-1)));
					enviar.writeObject(can.getNombre() + " / " + can.getApellido() + " _ " + can.getCargo() + " / " + can.getCedula() + " _ " + can.getEdad());
					enviar.close();
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor ser = new Servidor(5001);
		ser.start();

	}
	
}
