
package uni.aed.cc232a20224041gpc1;
import model.Persona;



public class SortObject {

    private Comparable[] heap;
    
    public void iniciarDatos(Comparable[] datos) {
        heap = new Comparable[datos.length];
        for (int i = 0; i < datos.length; i++) {
            heap[i] = datos[i];
        }
    }

    public Comparable[] heapSort() {
        HeapSortConstruct(heap); 
        return HeapSortExtract(heap); 
    }

    private void HeapSortConstruct(Comparable[] X) {
        int current, maxChildIndex;
        boolean hecho;
        for (int i = (X.length - 2) / 2; i >= 0; i--) {
            current = i;
            hecho = false;
            while (!hecho) { 
                if (2 * current + 1 > X.length - 1)
                    hecho = true;
                else { 
                    maxChildIndex = HeapSortMaxChild(X, current, X.length - 1);
                    if (X[current].compareTo(X[maxChildIndex]) < 0) {
                        intercambio(X, current, maxChildIndex);
                        current = maxChildIndex;
                    } else
                        hecho = true;
                }
            }
        }
    }

    private int HeapSortMaxChild(Comparable[] X, int loc, int end) {
        int izq = 2 * loc + 1; // Nodo izquierdo
        int der = 2 * loc + 2; // Nodo derecho
        if (der <= end && X[izq].compareTo(X[der]) < 0)
            return der;
        else
            return izq;
    }

    private void intercambio(Comparable[] X, int p, int q) {
        Comparable temp = X[p];
        X[p] = X[q];
        X[q] = temp;
    }

    private Comparable[] HeapSortExtract(Comparable[] X) {
        Comparable[] Y = new Comparable[X.length];
        for (int i = X.length - 1; i >= 0; i--) {
            Y[i] = X[0];
            X[0] = X[i];
            X[i] = Y[i];
        }
        return Y;
    }

    
    
   
}