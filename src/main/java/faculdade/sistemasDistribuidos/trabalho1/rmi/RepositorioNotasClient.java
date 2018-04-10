package faculdade.sistemasDistribuidos.trabalho1.rmi;

import java.math.BigDecimal;
import java.rmi.Naming;

public class RepositorioNotasClient {
	public static void main(String[] args) {
		try{
			RepositorioNotasInterface repo = (RepositorioNotasInterface) Naming.lookup("rmi://localhost/RepositorioNotas");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
