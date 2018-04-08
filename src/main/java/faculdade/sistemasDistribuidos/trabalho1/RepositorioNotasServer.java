package faculdade.sistemasDistribuidos.trabalho1;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class RepositorioNotasServer {
	public RepositorioNotasServer(){
		try{

			RepositorioNotasInterface repo = new RepositorioNotasRMI();
			Naming.rebind("//localhost/RepositorioNotas", (Remote) repo);
			System.out.println("Servidor iniciado em rmi://localhost/RepositorioNotas");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RepositorioNotasServer();
	}

}
