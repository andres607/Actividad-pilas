import java.util.Scanner;

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

