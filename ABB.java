
public class ABB {
    public Nodo raiz;

    ABB() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public Nodo regresaRaiz() {
        return this.raiz;
    }
  public Nodo insertarNodo(int valor, Nodo nodoRef) {
    if (nodoRef == null) {
        nodoRef = new Nodo();
        nodoRef.dato = valor;
        nodoRef.izquierdo = null;
        nodoRef.derecho = null;
        if (raiz == null) {
            raiz = nodoRef;
        }
    } else if (valor <= nodoRef.dato)
        nodoRef.izquierdo = insertarNodo(valor, nodoRef.izquierdo);
    else if (valor > nodoRef.dato)
        nodoRef.derecho = insertarNodo(valor, nodoRef.derecho);
    return nodoRef;
}
    
    public void imprimirHorizontal (Nodo nodo, int nivel) {
        if (nodo == null) return;
        imprimirHorizontal(nodo.derecho, nivel + 1);
        if (nivel != 0) {
            for (int i = 0; i < nivel - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + nodo.dato);
        } else
            System.out.println(nodo.dato);
        imprimirHorizontal(nodo.izquierdo, nivel + 1);
    }

    public Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null || nodo.dato == valor)
            return nodo;
        if (nodo.dato > valor)
            return buscarNodo(nodo.izquierdo, valor);
        else
            return buscarNodo(nodo.derecho, valor);
    }

    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inorden(nodo.derecho);
        }
    }

    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    public Nodo eliminarNodo(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (valor < nodo.dato)
            nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);
        else if (valor > nodo.dato)
            nodo.derecho = eliminarNodo(nodo.derecho, valor);
        else {
            if (nodo.izquierdo == null)
                return nodo.derecho;
            else if (nodo.derecho == null)
                return nodo.izquierdo;
            nodo.dato = minValor(nodo.derecho);
            nodo.derecho = eliminarNodo(nodo.derecho, nodo.dato);
        }
        return nodo;
    }

    public int minValor(Nodo nodo) {
        int minv = nodo.dato;
        while (nodo.izquierdo != null) {
            minv = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return minv;
    }
}