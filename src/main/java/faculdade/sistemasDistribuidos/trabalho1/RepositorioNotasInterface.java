package faculdade.sistemasDistribuidos.trabalho1;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RepositorioNotasInterface extends Remote {
	public void cadastrar_nota (String mat, String cod_disc, BigDecimal nota) throws RemoteException;
	public BigDecimal consultar_nota(String mat,String cod_disc) throws RemoteException;
	public List<BigDecimal> consultar_notas(String mat) throws RemoteException;
	public BigDecimal consular_cr(String mat) throws RemoteException;

}
