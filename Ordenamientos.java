import java.util.Arrays;
import java.util.Random;

public class Ordenamientos {

    //metodo genera arreglos aleatorios con diferentes tamanios
    public static int[][] crearArreglosAleatorios(int[] tamanios) {
        Random random = new Random();
        int tamanoMaximo = tamanios[tamanios.length - 1];
        int[] arregloBase = random.ints(tamanoMaximo, 1, 30001).toArray();

        // Crear un arreglo para cada tamanio en tamanios
        int[][] arreglosResultantes = new int[tamanios.length][];
        for (int i = 0; i < tamanios.length; i++) {
            arreglosResultantes[i] = Arrays.copyOfRange(arregloBase, 0, tamanios[i]);
        }
        return arreglosResultantes;
    }

    // Algoritmo burbuja Plus
    public static void ordenamientoBurbujaPlus(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambio;
        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambio = true;
                }
            }
            if (!intercambio) break; 
        }
    }

    // Algoritmo seleccion
    public static void ordenamientoSeleccion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    // Algoritmo insercion
    public static void ordenamientoInsercion(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int clave = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = clave;
        }
    }

    // Búsqueda binariaa
    public static int busquedaBinariaIterativa(int[] arreglo, int valor) {
        int izquierda = 0, derecha = arreglo.length - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arreglo[medio] == valor) return medio; 
            if (arreglo[medio] < valor) izquierda = medio + 1; 
            else derecha = medio - 1; 
        }
        return -1; 
    }

    // Búsqueda binaria recursiva
    public static int busquedaBinariaRecursiva(int[] arreglo, int izquierda, int derecha, int valor) {
        if (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arreglo[medio] == valor) return medio;
            if (arreglo[medio] < valor) return busquedaBinariaRecursiva(arreglo, medio + 1, derecha, valor);
            return busquedaBinariaRecursiva(arreglo, izquierda, medio - 1, valor);
        }
        return -1; 
    }

    // Medir tiempos de los mtodos de ordenamiento
    public static void calcularTiemposDeOrdenamiento(int[][] arreglos) {
        String[] metodos = {"Burbuja Plus", "Seleccion", "Insercion"};
        for (String metodo : metodos) {
            System.out.println("Metodo: " + metodo);
            for (int[] arreglo : arreglos) {
                int[] copiaArreglo = Arrays.copyOf(arreglo, arreglo.length);
                long inicio = System.nanoTime();

                switch (metodo) {
                    case "Burbuja Plus": ordenamientoBurbujaPlus(copiaArreglo); break;
                    case "Seleccion": ordenamientoSeleccion(copiaArreglo); break;
                    case "Insercion": ordenamientoInsercion(copiaArreglo); break;
                }

                long fin = System.nanoTime();
                System.out.printf("Tamano %d: Tiempo = %.9f seg.\n", copiaArreglo.length, (fin - inicio) / 1e9);
            }
            System.out.println();
        }
    }
}