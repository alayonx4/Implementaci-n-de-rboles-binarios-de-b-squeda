
public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        // Insertar nodos
        arbol.insertarNodo(5, arbol.regresaRaiz());
        arbol.insertarNodo(7, arbol.regresaRaiz());
        arbol.insertarNodo(8, arbol.regresaRaiz());

        // Imprimir el árbol de forma horizontal
        arbol.imprimirHorizontal(arbol.regresaRaiz(), 0);

        // Buscar un nodo
        Nodo nodoBuscado = arbol.buscarNodo(arbol.regresaRaiz(), 5);
        if (nodoBuscado != null) {
            System.out.println("Nodo encontrado: " + nodoBuscado.dato);
        } else {
            System.out.println("Nodo no encontrado");
        }

        // Recorrer el árbol en preorden
        arbol.preorden(arbol.regresaRaiz());

        // Recorrer el árbol en inorden
        arbol.inorden(arbol.regresaRaiz());

        // Recorrer el árbol en postorden
        arbol.postorden(arbol.regresaRaiz());

        // Eliminar un nodo
        arbol.eliminarNodo(arbol.regresaRaiz(), 10);
    }
}