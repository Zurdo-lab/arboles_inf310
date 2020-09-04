package bo.edu.uagrm.inf310sb.exceptions;

/*
 * @author RP
 * @version 1.0.0
 */

public class ExcepcionClaveNoExiste extends Exception {
	public ExcepcionClaveNoExiste() {
		super("La clave no existe en el arbol");
	}

	public ExcepcionClaveNoExiste(String mensaje) {
		super(mensaje);
	}
}
