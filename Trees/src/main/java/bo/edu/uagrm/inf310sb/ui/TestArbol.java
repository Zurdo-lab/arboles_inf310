package bo.edu.uagrm.inf310sb.ui;

import java.util.Scanner;

import javax.swing.JOptionPane;

import bo.edu.uagrm.inf310sb.exceptions.ExcepcionClaveYaExiste;
import bo.edu.uagrm.inf310sb.trees.ArbolBinarioBusqueda;
import bo.edu.uagrm.inf310sb.trees.IArbolBusqueda;

/*
 * @author RP
 * @version 1.0.0
 */

public class TestArbol {

	public static void main(String[] args) throws ExcepcionClaveYaExiste {
		IArbolBusqueda<Integer, String> arbolDePrueba = new ArbolBinarioBusqueda<>();
		/*
		 * try (Scanner entrada=new Scanner(System.in)){
		 * System.out.println("Elija un tipo de Arbol(ABB,AVL,MVias):"); String
		 * tipoArbol=entrada.next(); tipoArbol=tipoArbol.toUpperCase();
		 * 
		 * switch (tipoArbol) { case "ABB": arbolDePrueba=new ArbolBinarioBusqueda<>();
		 * break; case "AVL": //arbolDePrueba=new AVL<>(); break; case "MVias":
		 * //arbolDePrueba=new ArbolMViasBusqueda<>(); break; default:
		 * System.out.println("Tipo de arbol invalido,eligiendo ArbolBinarioBusqueda");
		 * arbolDePrueba=new ArbolBinarioBusqueda<>(); } Integer[] key=
		 * {54,5,65,19,82,18,72}; String [] value=
		 * {"Crhistian Sosa","Julio Gonsales","Liz Llanos","Oliver Cartagena",
		 * "Gabriel Coca","Luis Vazquez","Alejandro Cruz"};
		 * 
		 * for (Integer akey:key) { for (String avalue:value) {
		 * arbolDePrueba.insertar(akey, avalue);
		 * 
		 * } } System.out.println(arbolDePrueba);
		 * 
		 * }
		 */
		int nivel = 0;
		arbolDePrueba.insertar(54, "Crhistian Sosa");
		arbolDePrueba.insertar(5, "Julio Gonsales");
		arbolDePrueba.insertar(65, "Liz Llanos");
		arbolDePrueba.insertar(19, "Oliver Cartagena");
		arbolDePrueba.insertar(82, "Gabriel Coca");
		arbolDePrueba.insertar(18, "Luis Vazquez");
		arbolDePrueba.insertar(72, "Alejandro Cruz");
		arbolDePrueba.insertar(32, "Carlos Angola");
		arbolDePrueba.insertar(3, "Ronny Ramirez");
		//arbolDePrueba.insertar(70, "Ronny Pineda");
		//arbolDePrueba.insertar(69, "Ronny P");
		System.out.println("***ARBOL BINARIO***");
		// System.out.println(arbolDePrueba);

		System.out.println("Recorrido Por Niveles: " + arbolDePrueba.recorridoPorNiveles());
		System.out.println("Recorrido En PreOrden: " + arbolDePrueba.recorridoEnPreOrden());
		System.out.println("Dato encontrado: " + arbolDePrueba.buscar(65));
		System.out.println("Altura: " + arbolDePrueba.altura());
		// JOptionPane.showMessageDialog(null, "Dato encontrado: " +
		// arbolDePrueba.buscar(65));
		System.out.println("Nodos en el arbol: " + arbolDePrueba.size());
		
		System.out.println("--------------------TAREA2---------------------------");
		if (arbolDePrueba instanceof ArbolBinarioBusqueda) {
			System.out.println("1.-Cantidad de Nodos Hojas (Recursivo): "
					+ ((ArbolBinarioBusqueda) arbolDePrueba).cantidadDeNodosHojasR());
			System.out.println("2.-Cantidad de Nodos Hojas (Iterativo): "
					+ ((ArbolBinarioBusqueda) arbolDePrueba).cantidadDeNodosHojas());
			System.out.println("3.-Cantidad de Nodos Hojas de un Nivel N(Recursivo): "
					+ ((ArbolBinarioBusqueda) arbolDePrueba).cantidadDeNodoHojasEnNivelR(2));
			System.out.println("4.-Cantidad de Nodos Hojas de un Nivel N(Iterativo): "
					+ ((ArbolBinarioBusqueda) arbolDePrueba).cantidadDeNodoHojasEnNivel(2));
			System.out.println("5.-Cantidad de Nodos Hojas Antes de un Nivel N(Iterativo): "
					+ ((ArbolBinarioBusqueda) arbolDePrueba).cantidadDeNodoHojasAntesNivel(2));
			System.out.println("6.-Es Balanceado (Recursivo): "
					+ ((ArbolBinarioBusqueda) arbolDePrueba).isBalanced());
			//System.out.println("7.-Es Balanceado (Iterativo): "
			//		+ ((ArbolBinarioBusqueda) arbolDePrueba).isBalancedIterative());
			//System.out.println("8.-Reconstruir un Arbol Binario con InOrden & PreOrden.-): "
			//		+ ((ArbolBinarioBusqueda) arbolDePrueba).);
			//System.out.println("9.-Sucesor InOrden: "
			//		+ ((ArbolBinarioBusqueda) arbolDePrueba).sucesorInOrden(5));
			//System.out.println("10.-Predecesor InOrden: "
			//		+ ((ArbolBinarioBusqueda) arbolDePrueba).predecesorInOrden(5));
			System.out.println("Lo tengo la pregunta 9 y 10 pero no me dio tiempo llamarlo el metodo");
			//System.out.println("11.-Eliminar AVL: "
			//		+ ((ArbolBinarioBusqueda) arbolDePrueba).eliminar(5);
			System.out.println("12.-Cantidad de Nodos Completo de un Nivel N: "
					+ ((ArbolBinarioBusqueda) arbolDePrueba).cantidadDeAmbosNodosEnNivel(2));

		}

	}

}
