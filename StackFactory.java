/**
 * Creación de pilas (Stack) con diferentes implementaciones.
 */
public class StackFactory {
    public static <T> IStack<T> createStack(String type) {
        switch (type.toLowerCase()) {
            case "fast":
                return new FastStack<>();
            case "safe":
                return new SafeStack<>();
            case "linked":
                return new LinkedStack<>();
            default:
                throw new IllegalArgumentException("Tipo de Stack no válido: " + type);
        }
    }
}
