/**
 * Clase que evalúa expresiones en notación Postfix
 */
public class PostfixEvaluator {
    private IStack<Double> stack;

    public PostfixEvaluator(IStack<Double> stackImplementation) {
        this.stack = stackImplementation;
    }

    /**
     * Evalúa la expresion psotfix
     * @param expression Postfix en cadena
     * @return Resultado de la evaluación
     */
    public double evaluate(String expression) {
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(token.charAt(0), operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double applyOperator(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+': return operand1 + operand2;
            case '-': return operand1 - operand2;
            case '*': return operand1 * operand2;
            case '/': return operand1 / operand2;
            case '^': return Math.pow(operand1, operand2);
            default: throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }
}
