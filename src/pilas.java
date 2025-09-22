import java.util.Scanner;

//SE GREGA PRIMERA PARTE DEL CODIGO
class Pila<T> {
    private Nodo<T> cima;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
//SE AGREGA SEGUNDA PARTE DEL CODIGO
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public T peek() {
        return isEmpty() ? null : cima.dato;
    }

    public boolean isEmpty() {
        return cima == null;
    }
}

//SE AGREGA TERCERA PARTE DEL CODIGO
public class pilas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pila<String> pilaPrincipal = new Pila<>();
        Pila<String> pilaDeshacer = new Pila<>();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== EDITOR DE TEXTO =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

//Se agrega primera parte de la continuacion realizado en grupo
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese texto: ");
                    String texto = scanner.nextLine();
                    pilaPrincipal.push(texto);

                    pilaDeshacer = new Pila<>();
                    break;

                case "2":
                    if (!pilaPrincipal.isEmpty()) {
                        String textoDeshecho = pilaPrincipal.pop();
                        pilaDeshacer.push(textoDeshecho);
                        System.out.println("Última acción deshecha.");
                    } else {
                        System.out.println("No hay acciones para deshacer.");
                    }
                    break;
//se agrega segunda parte de la continuacion realizado en grupo
                case "3":
                    if (!pilaDeshacer.isEmpty()) {
                        String textoRehecho = pilaDeshacer.pop();
                        pilaPrincipal.push(textoRehecho);
                        System.out.println("Acción rehecha.");
                    } else {
                        System.out.println("No hay acciones para rehacer.");
                    }
                    break;

                case "4":
                    String actual = pilaPrincipal.peek();
                    if (actual != null) {
                        System.out.println("Texto actual: " + actual);
                    } else {
                        System.out.println("No hay texto escrito.");
                    }
                    break;