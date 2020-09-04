package bo.edu.uagrm.inf310sb.trees;

import bo.edu.uagrm.inf310sb.exceptions.ExcepcionClaveYaExiste;

/*
 * @author RP
 * @version 1.0.0
 * @param <K>
 * @param <V>
 */

public class AVL<K extends Comparable<K>, V> extends ArbolBinarioBusqueda<K, V> {
	
	@Override
	public void insertar(K clave, V valor) throws ExcepcionClaveYaExiste {
		raiz = insertar(raiz, clave, valor);
	}

	private NodoBinario<K, V> insertar(NodoBinario<K, V> nodoActual, K clave, V valor) throws ExcepcionClaveYaExiste {
		// TODO Auto-generated method stub
		return null;
	}

}
