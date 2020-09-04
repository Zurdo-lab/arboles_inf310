package bo.edu.uagrm.inf310sb.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import bo.edu.uagrm.inf310sb.exceptions.ExcepcionClaveNoExiste;
import bo.edu.uagrm.inf310sb.exceptions.ExcepcionClaveYaExiste;

/*
 * @author RP
 * @version 1.0.0
 * @param <K>
 * @param <V>
 */

public class ArbolBinarioBusqueda<K extends Comparable<K>, V> implements IArbolBusqueda<K, V> {

	protected NodoBinario<K, V> raiz;

	public ArbolBinarioBusqueda() {

	}

	protected NodoBinario<K, V> nodoVacioParaElArbol() {
		return (NodoBinario<K, V>) NodoBinario.nodoVacio();

	}

	@Override
	public void insertar(K clave, V valor) throws ExcepcionClaveYaExiste {
		if (this.esArbolVacio()) {
			this.raiz = new NodoBinario<K, V>(clave, valor);
			return;
		}
		// En caso de que el arbol no es vacio
		NodoBinario<K, V> nodoActual = this.raiz;
		NodoBinario<K, V> nodoAnterior = this.nodoVacioParaElArbol();
		while (!NodoBinario.esNodoVacio(nodoActual)) {
			nodoAnterior = nodoActual;

			if (clave.compareTo(nodoActual.getClave()) > 0) { // pregunta si la clave > nodoActual.getClave
				nodoActual = nodoActual.getHijoDerecho();

			} else if (clave.compareTo(nodoActual.getClave()) < 0) { // pregunta si la clave < nodoActual.getClave
				nodoActual = nodoActual.getHijoIzquierdo();
			} else {
				throw new ExcepcionClaveYaExiste("La clave que quiere insertar " + "ya existe en su arbol");

			}

		} // si termina el bucle porque el nodo actual es vacio, entonces
			// ya encontre donde insertar la clave y su valor
		NodoBinario<K, V> nuevoNodo = new NodoBinario<K, V>(clave, valor);

		if (clave.compareTo(nodoAnterior.getClave()) > 0) {
			nodoAnterior.setHijoDerecho(nuevoNodo);

		} else {
			nodoAnterior.setHijoIzquierdo(nuevoNodo);
		}

	}

	@Override
	public V eliminar(K clave) throws ExcepcionClaveNoExiste {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V buscar(K clave) {
		NodoBinario<K, V> nodoActual = this.raiz;

		while (!NodoBinario.esNodoVacio(nodoActual)) {

			if (clave.compareTo(nodoActual.getClave()) > 0) { // pregunta si la clave > nodoActual.getClave
				nodoActual = nodoActual.getHijoDerecho();

			} else if (clave.compareTo(nodoActual.getClave()) < 0) { // pregunta si la clave < nodoActual.getClave
				nodoActual = nodoActual.getHijoIzquierdo();
			} else {
				return nodoActual.getValor();
			}
		} // endWhile
			// la clave no esta en el arbol, por lo tanto no hay valor que devolver
		return null;

	}

	@Override
	public boolean contiene(K clave) {
		return this.buscar(clave) != null;
	}

	@Override
	public int size() {
		if (this.esArbolVacio()) {
			return 0;
		}
		int contadorDeNodos = 0;
		Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
		colaDeNodos.offer(this.raiz);
		while (!colaDeNodos.isEmpty()) {
			NodoBinario<K, V> nodoActual = colaDeNodos.poll();
			contadorDeNodos = contadorDeNodos + 1;

			if (!nodoActual.esVacioHijoIzquierdo()) {
				colaDeNodos.offer(nodoActual.getHijoIzquierdo());
			}
			if (!nodoActual.esVacioHijoDerecho()) {
				colaDeNodos.offer(nodoActual.getHijoDerecho());
			}
		}
		return contadorDeNodos;
	}

	@Override
	public int altura() {
		return alturaR(this.raiz);
	}

	protected int alturaR(NodoBinario<K, V> nodoActual) {
		if (NodoBinario.esNodoVacio(nodoActual)) {
			return 0;
		}
		int alturaIzq = alturaR(nodoActual.getHijoIzquierdo());
		int alturaDer = alturaR(nodoActual.getHijoDerecho());
		return alturaIzq > alturaDer ? alturaIzq + 1 : alturaDer + 1;
	}

	@Override
	public void vaciar() {
		this.raiz = this.nodoVacioParaElArbol();

	}

	@Override
	public boolean esArbolVacio() {
		return NodoBinario.esNodoVacio(this.raiz);
	}

	@Override
	public int nivel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<K> recorridoEnInOrden() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<K> recorridoEnPreOrden() {
		List<K> recorrido = new LinkedList<>();
		if (this.esArbolVacio()) {
			return recorrido;
		}
		Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
		pilaDeNodos.push(this.raiz);
		while (!pilaDeNodos.isEmpty()) {
			NodoBinario<K, V> nodoActual = pilaDeNodos.pop();
			recorrido.add(nodoActual.getClave());

			if (!nodoActual.esVacioHijoDerecho()) {
				pilaDeNodos.push(nodoActual.getHijoDerecho());
			}

			if (!nodoActual.esVacioHijoIzquierdo()) {
				pilaDeNodos.push(nodoActual.getHijoIzquierdo());
			}

		}
		return recorrido;
	}

	@Override
	public List<K> recorridoEnPostOrden() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<K> recorridoPorNiveles() {
		List<K> recorrido = new LinkedList<>();
		if (this.esArbolVacio()) {
			return recorrido;
		}
		Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
		colaDeNodos.offer(this.raiz);
		while (!colaDeNodos.isEmpty()) {
			NodoBinario<K, V> nodoActual = colaDeNodos.poll();
			recorrido.add(nodoActual.getClave());

			if (!nodoActual.esVacioHijoIzquierdo()) {
				colaDeNodos.offer(nodoActual.getHijoIzquierdo());
			}
			if (!nodoActual.esVacioHijoDerecho()) {
				colaDeNodos.offer(nodoActual.getHijoDerecho());
			}
		}
		return recorrido;
	}

	public String toString() {
		return generarCadenaDeArboles(this.raiz, " ", true);
	}

	private String generarCadenaDeArboles(NodoBinario<K, V> nodoActual, String prefijo, boolean ponerCodo) {
		return "";
	}

//-------------------------------TAREA2------------------------------------------

	// 1
	public int cantidadDeNodosHojasR() {
		return cantidadDeNodosHojasR(this.raiz);
	}

	protected int cantidadDeNodosHojasR(NodoBinario<K, V> nodoActual) {
		if (NodoBinario.esNodoVacio(nodoActual)) {
			return 0;
		}

		if (nodoActual.esHoja()) {
			return 1;
		}
		int contadorIzq = cantidadDeNodosHojasR(nodoActual.getHijoIzquierdo());
		int contadorDer = cantidadDeNodosHojasR(nodoActual.getHijoDerecho());
		return contadorIzq + contadorDer;
	}

	// 2
	public int cantidadDeNodosHojas() {
		if (this.esArbolVacio()) {
			return 0;
		}
		int contador = 0;
		Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
		colaDeNodos.offer(this.raiz);
		while (!colaDeNodos.isEmpty()) {
			NodoBinario<K, V> nodoActual = colaDeNodos.poll();
			if (nodoActual.esHoja()) {
				contador++;
			}
			if (!nodoActual.esVacioHijoIzquierdo()) {
				colaDeNodos.offer(nodoActual.getHijoIzquierdo());
			}
			if (!nodoActual.esVacioHijoDerecho()) {
				colaDeNodos.offer(nodoActual.getHijoDerecho());
			}

		}

		return contador;

	}

	// 3
	public int cantidadDeNodoHojasEnNivelR(int nivel) {
		return cantidadDeNodoHojasEnNivelR(this.raiz, nivel, 0);
	}

	protected int cantidadDeNodoHojasEnNivelR(NodoBinario<K, V> nodoActual, int nivel, int nivelActual) {
		if (NodoBinario.esNodoVacio(nodoActual)) {
			return 0;
		}

		if (nivelActual == nivel) {
			if (nodoActual.esHoja()) {
				return 1;
			}
		}
		int contadorIzq = cantidadDeNodoHojasEnNivelR(nodoActual.getHijoIzquierdo(), nivel, nivelActual + 1);
		int contadorDer = cantidadDeNodoHojasEnNivelR(nodoActual.getHijoDerecho(), nivel, nivelActual + 1);
		return contadorIzq + contadorDer;
	}

	// 4
	public int cantidadDeNodoHojasEnNivel(int nivel) {
		if (this.esArbolVacio()) {
			return 0;
		}
		int contador = 0;
		int nivelActual = 0;
		Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
		colaDeNodos.offer(raiz);
		while (!colaDeNodos.isEmpty()) {
			int nroDeNodosDelNivel = colaDeNodos.size();
			while (nroDeNodosDelNivel > 0) {
				NodoBinario<K, V> nodoActual = colaDeNodos.poll();
				if (nivel == nivelActual && nodoActual.esHoja()) {
					contador++;
				}
				if (!nodoActual.esVacioHijoIzquierdo()) {
					colaDeNodos.offer(nodoActual.getHijoIzquierdo());
				}
				if (!nodoActual.esVacioHijoDerecho()) {
					colaDeNodos.offer(nodoActual.getHijoDerecho());
				}
				nroDeNodosDelNivel--;
			}
			nivelActual++;
		}
		return contador;
	}

	// 5
	public int cantidadDeNodoHojasAntesNivel(int nivel) {
		if (this.esArbolVacio()) {
			return 0;
		}
		int contador = 0;
		int nivelActual = 0;
		Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
		colaDeNodos.offer(raiz);
		while (!colaDeNodos.isEmpty()) {
			int nroDeNodosDelNivel = colaDeNodos.size();
			while (nroDeNodosDelNivel > 0) {
				NodoBinario<K, V> nodoActual = colaDeNodos.poll();
				if (nivelActual <= nivel && nodoActual.esHoja()) {
					contador++;
				}
				if (!nodoActual.esVacioHijoIzquierdo()) {
					colaDeNodos.offer(nodoActual.getHijoIzquierdo());
				}
				if (!nodoActual.esVacioHijoDerecho()) {
					colaDeNodos.offer(nodoActual.getHijoDerecho());
				}
				nroDeNodosDelNivel--;
			}
			nivelActual++;
		}
		return contador;
	}

	// 6
	public boolean isBalanced() {
		return isBalanced(this.raiz);
	}

	protected boolean isBalanced(NodoBinario<K, V> nodoActual) {
		if (NodoBinario.esNodoVacio(nodoActual)) {
			return true;
		}

		int alturaIzq = alturaR(nodoActual.getHijoIzquierdo());
		int alturaDer = alturaR(nodoActual.getHijoDerecho());
		int diferenciaDeAltura = alturaIzq - alturaDer;
		if (diferenciaDeAltura > 1) {
			return false;
		}
		if (diferenciaDeAltura < -1) {
			return false;
		}
		return true;
	}

	// 7
	/*public boolean isBalancedIterative() {
		if (this.esArbolVacio()) {
			return true;
		}
		Stack<NodoBinario<K, V>> pila = new Stack<>();
		Stack<NodoBinario<K, V>> pilaDeSalida = new Stack<>();
		pila.push(this.raiz);
		while (!pila.isEmpty()) {
			NodoBinario<K, V> nodoActual = pila.pop();
			pilaDeSalida.push(nodoActual);
			if (!nodoActual.esVacioHijoIzquierdo()) {
				pila.push(nodoActual.getHijoIzquierdo());
			}
			if (!nodoActual.esVacioHijoDerecho()) {
				pila.push(nodoActual.getHijoDerecho());
			}
		}
		while (!pilaDeSalida.isEmpty()) {
			pilaDeSalida.pop();
		}
		return true;
	}*/
	//8
		

	// 9
	protected K sucesorInOrden(NodoBinario<K, V> nodoActual) {
		NodoBinario<K, V> nodoAnterior = nodoActual.getHijoDerecho();
		while (!NodoBinario.esNodoVacio(nodoAnterior.getHijoIzquierdo())) {
			nodoAnterior = nodoAnterior.getHijoIzquierdo();
		}
		return nodoAnterior.getClave();
	}

	// 10
	protected K predecesorInOrden(NodoBinario<K, V> nodoActual) {
		NodoBinario<K, V> nodoAnterior = nodoActual.getHijoIzquierdo();
		while (!NodoBinario.esNodoVacio(nodoAnterior.getHijoDerecho())) {
			nodoAnterior = nodoAnterior.getHijoDerecho();
		}
		return nodoAnterior.getClave();
	}

	// 12
	public int cantidadDeAmbosNodosEnNivel(int nivel) {
		return cantidadDeAmbosNodosEnNivel(this.raiz, nivel, 0);
	}

	protected int cantidadDeAmbosNodosEnNivel(NodoBinario<K, V> nodoActual, int nivel, int nivelActual) {
		if (NodoBinario.esNodoVacio(nodoActual)) {
			return 0;
		}
		int i = 0;
		if (nivelActual >= nivel) {
			if (nodoActual.esNodoCompleto()) {
				i++;
			}
		}

		int contadorIzq = cantidadDeAmbosNodosEnNivel(nodoActual.getHijoIzquierdo(), nivel, nivelActual + 1);
		int contadorDer = cantidadDeAmbosNodosEnNivel(nodoActual.getHijoDerecho(), nivel, nivelActual + 1);
		i = i + contadorIzq + contadorDer;
		return i;

	}

}
