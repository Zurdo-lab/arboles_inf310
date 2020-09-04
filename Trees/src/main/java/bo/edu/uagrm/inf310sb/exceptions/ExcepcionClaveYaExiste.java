package bo.edu.uagrm.inf310sb.exceptions;

/*
 * @author RP
 * @version 1.0.0
 */

public class ExcepcionClaveYaExiste extends Exception {
	public ExcepcionClaveYaExiste() {
		super("La clave ya existe en el arbol");
	}

	public ExcepcionClaveYaExiste(String mensaje) {
		super(mensaje);
	}
}
