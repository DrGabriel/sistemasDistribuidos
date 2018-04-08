package faculdade.sistemasDistribuidos.trabalho1;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RepositorioNotasRMI extends UnicastRemoteObject implements RepositorioNotasInterface
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected RepositorioNotasRMI() throws RemoteException{
		super();
	}
	public void cadastrar_nota(String mat, String cod_disc, BigDecimal nota) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	public BigDecimal consultar_nota(String mat, String cod_disc) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public List<BigDecimal> consultar_notas(String mat) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal consular_cr(String mat) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
