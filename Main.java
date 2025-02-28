import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal para leer expresiones de un archivo, convertirlas y evaluarlas.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCalc DinoPythons3000, seleccione el Stack que desea:");
        System.out.println("1. FastStack (ArrayList)");
        System.out.println("2. SafeStack (Vector)");
        System.out.println("3. LinkedStack (Lista enlazada)");
        System.out.print("Opción: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        String stackType = option == 1 ? "fast" : option == 2 ? "safe" : "linked";

        System.out.println("\nProcesando expresiones desde datos.txt\n");

        IStack<Character> charStack = StackFactory.createStack(stackType);
        InfixConverter converter = new InfixConverter(charStack);
        CalculatorSingleton calculator = CalculatorSingleton.getInstance();

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                processExpression(line, converter, calculator);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void processExpression(String infix, InfixConverter converter, CalculatorSingleton calculator) {
        System.out.println("\nInfix: " + infix);
        String postfix = converter.convert(infix);
        System.out.println("Postfix: " + postfix);
        double result = calculator.evaluate(postfix);
        System.out.println("Resultado: " + result);
    }
}
