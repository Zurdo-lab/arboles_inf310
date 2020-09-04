package bo.edu.uagrm.inf310sb.trees;

import java.util.List;

import bo.edu.uagrm.inf310sb.exceptions.ExcepcionClaveNoExiste;
import bo.edu.uagrm.inf310sb.exceptions.ExcepcionClaveYaExiste;

/*
 * @author RP
 * @version 1.0.0
 */

public interface IArbolBusqueda<K extends Comparable<K>, V> {
	void insertar(K clave, V valor) throws ExcepcionClaveYaExiste;

	V eliminar(K clave) throws ExcepcionClaveNoExiste;

	V buscar(K clave);

	boolean contiene(K clave);

	int size();

	int altura();

	void vaciar();

	boolean esArbolVacio();

	int nivel();

	List<K> recorridoEnInOrden();

	List<K> recorridoEnPreOrden();

	List<K> recorridoEnPostOrden();

	List<K> recorridoPorNiveles();

}
