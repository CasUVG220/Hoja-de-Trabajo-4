import java.util.HashMap;

/**
 * Convierte expresiones Infix a Postfix con pila.
 */
public class InfixConverter {
    private IStack<Character> stack;
    private HashMap<Character, Integer> precedence;

    public InfixConverter(IStack<Character> stackImplementation) {
        this.stack = stackImplementation;
        this.precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
    }

    /**
     * Convierte una expresión infix a postfix.
     * @param expression Expresión infix de forma de cadena
     * @return Expresión en notación postfix separada
     */
    public String convert(String expression) {
        StringBuilder postfix = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();

        for (char token : expression.toCharArray()) {
            if (Character.isDigit(token)) {
                numberBuffer.append(token); // Acumular números 
            } else {
                if (numberBuffer.length() > 0) {
                    postfix.append(numberBuffer).append(" ");
                    numberBuffer.setLength(0); // Resetear el buffer
                }

                if (token == '(') {
                    stack.push(token);
                } else if (token == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.pop(); // Remover '(' de la pila
                } else if (precedence.containsKey(token)) {
                    while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.getOrDefault(token, 0)) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(token);
                }
            }
        }

        if (numberBuffer.length() > 0) {
            postfix.append(numberBuffer).append(" ");
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }
}
