
import javax.swing.JOptionPane;

public class CalculadoraAvanzada {
	/**
	 * Una calculadora científica compuesta por 14 métodos incluido main
	 * 
	 * @author Kimia
	 */

	// Declarando Las variables estáticas
	static double num1;
	static double num2;

	public static void main(String[] args) {
		start();
	}

	/**
	 * El método para empezar el programa si el usuario selecciona el botón
	 * "Comenzar" llamamos al método menuResutado, en otro caso terminar el programa
	 */
	public static void start() {

		String[] botones = { "Comenzar", "Cancelar" };
		int botonSelect = JOptionPane.showOptionDialog(null, "Calculadora científica", "Calculadora",
				JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
		switch (botonSelect) {
		case -1:
			System.exit(0);
		case 0:
			menuPrincipal();
		case 1:
			System.exit(0);
		}
	}

	/**
	 * El menú principal es el menú con el que puedes ir al menú de cálculo o
	 * terminar el programa
	 */
	public static void menuPrincipal() {
		int botonSelect = 1;
		String[] botones = { "Terminar", "Menú" };

		while (botonSelect == 1) {
			String resultado = toString(menu());
			// Mostrando el resultado
			botonSelect = JOptionPane.showOptionDialog(null, resultado, "Respuesta", JOptionPane.NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, botones, botones[1]);
			// Seleccionar los botones y llamando al método de cada uno
			switch (botonSelect) {
			case -1:
				System.exit(0);
			case 0:
				System.exit(0);
			}
		}
	}

	/**
	 * El menú principal con los botones
	 * 
	 * @return devolviendo el resultado de la operación
	 */
	public static double menu() {
		double devolver = 0;
		String[] botonesMenu = { "Suma", "Resta", "Multiplicar", "Dividir" };

		int botonSelect = JOptionPane.showOptionDialog(null, "Elige un botón", "Calculadora", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, botonesMenu, null);
		entrada();
		// Seleccionar los botones y llamando al método de cada uno
		switch (botonSelect) {
		case -1:
			System.exit(0);
		case 0:
			devolver = suma(num1, num2);
			break;
		case 1:
			devolver = resta(num1, num2);
			break;
		case 2:
			devolver = multiplicar(num1, num2);
			break;
		case 3:
			devolver = dividir(num1, num2);
			break;
		}
		return devolver;
	}

	/**
	 * Método para quitar la parte decimal del resultado si es entero y convertirlos
	 * en String para poder devolverlos
	 * 
	 * @param doble Recibe un double
	 * @return devuelve un String
	 */
	public static String toString(double doble) {
		String stringRes = "";

		if (doble == Math.floor(doble)) {
			int resInt = (int) Math.floor(doble);
			stringRes = "" + resInt;
		} else {
			stringRes = "" + doble;
		}
		return stringRes;
	}

	/**
	 * Generando entradas para los néumeros
	 *
	 */
	public static void entrada() {
		num1 = Double.parseDouble(JOptionPane.showInputDialog("Escribe un número"));
		num2 = Double.parseDouble(JOptionPane.showInputDialog("Escribe otro número"));
	}

	/**
	 * @param num  Recibiendo 2 números y sumándolos
	 * @param num1
	 * @return Devuelve la suma
	 */
	public static double suma(double num, double num1) {
		double suma = num + num1;
		return suma;
	}

	/**
	 * @param num  Recibiendo 2 números y restandolos
	 * @param num1
	 * @return Devuelve la resta
	 */
	public static double resta(double num, double num1) {
		double resta = num - num1;
		return resta;
	}

	/**
	 * @param num  Recibiendo 2 números y multiplicándolos
	 * @param num1
	 * @return Devuelve la multiplicación
	 */
	public static double multiplicar(double num, double num1) {
		double multi = num * num1;
		return multi;
	}

	/**
	 * @param num  Recibiendo 2 números dobles y dividiéndolos
	 * @param num1
	 * @return devuleve la división
	 */
	public static double dividir(double num, double num1) {
		double dividir = 0;
		// Creando una excepción propia y lanzandolo en el caso de que el segundo número
		// sea 0
		if (num1 == 0) {
			ArithmeticException e = new ArithmeticException("No se puede dividir entre 0");
			throw e;
		} else {
			dividir = num / num1;
		}
		return dividir;
	}

}
