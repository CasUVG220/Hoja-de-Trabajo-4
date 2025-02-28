/**
 * Singleton que evalua expresiones Postfix.
 */
public class CalculatorSingleton {
    private static CalculatorSingleton instance;
    private PostfixEvaluator evaluator;

    private CalculatorSingleton() {
        IStack<Double> stack = StackFactory.createStack("fast");
        evaluator = new PostfixEvaluator(stack);
    }

    public static CalculatorSingleton getInstance() {
        if (instance == null) {
            instance = new CalculatorSingleton();
        }
        return instance;
    }

    public double evaluate(String postfixExpression) {
        return evaluator.evaluate(postfixExpression);
    }
}
