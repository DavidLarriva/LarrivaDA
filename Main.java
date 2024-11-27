import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Tamanios de los arreglos, porque queremos probar con diferentes longitudes
        int[] tamaniosArreglos = {10, 100, 1000, 5000, 10000, 30000};

        // Arreglos generados aleatorioss
        int[][] coleccionArreglos = Ordenamientos.crearArreglosAleatorios(tamaniosArreglos);

        // Valores que vamos a buscar en los arreglos
        
        int[] valoresABuscar = {9, 98, 957, 4000, 9876, 29475};

        // Aqui estamos metiendo valores iniciales en los arreglos
        for (int i = 0; i < tamaniosArreglos.length; i++) {
            if (valoresABuscar[i] < coleccionArreglos[i].length) {
                coleccionArreglos[i][0] = valoresABuscar[i];
            }
        }

        Scanner input = new Scanner(System.in);
        int xd;

        do {
            // Menu bonito con bordes
            System.out.println("  --------------------------------------------");
            System.out.println(" |                   MENU                     |");
            System.out.println(" |--------------------------------------------|");
            System.out.println(" | 1. Generar nuevos arreglos aleatorios      |");
            System.out.println(" | 2. Ordenar los arreglos                    |");
            System.out.println(" | 3. Realizar busquedas binarias             |");
            System.out.println(" | 4. Salir                                   |");
            System.out.println("  --------------------------------------------");
            System.out.println();

            xd = input.nextInt();

            switch (xd) {
                case 1:
                System.out.println();
                    coleccionArreglos = Ordenamientos.crearArreglosAleatorios(tamaniosArreglos);
                    System.out.println("Arreglos generados");
                    break;

                case 2:
                    // Vamos a ordenar los arreglos con diferentes metodos
                    System.out.println();
                    Ordenamientos.calcularTiemposDeOrdenamiento(coleccionArreglos);
                    break;

                case 3:
                    //  busqueda binaria normal y recursiva
                    System.out.println();
                    for (int i = 0; i < tamaniosArreglos.length; i++) {
                        int[] copiaArreglo = Arrays.copyOf(coleccionArreglos[i], coleccionArreglos[i].length);



                        Arrays.sort(copiaArreglo); 
                        int valor = valoresABuscar[i];

                        // Busqueda binaria normal
                        long inicioNormal = System.nanoTime();
                        int resultadoBusquedaNormal = Ordenamientos.busquedaBinariaIterativa(copiaArreglo, valor);
                        long finNormal = System.nanoTime();
                        System.out.printf("Arreglo de tamano %d, valor %d: Busqueda binaria normal, tiempo = %.9f seg\n",
                                tamaniosArreglos[i], valor, (finNormal - inicioNormal) / 1e9);

                        // Busqueda binaria recursiva
                        long inicioRecursivo = System.nanoTime();
                        int resultadoBusquedaRecursiva = Ordenamientos.busquedaBinariaRecursiva(copiaArreglo, 0, copiaArreglo.length - 1, valor);
                        long finRecursivo = System.nanoTime();
                        System.out.printf("Arreglo de tamano %d, valor %d: Busqueda binaria recursiva, tiempo = %.9f seg\n",
                                tamaniosArreglos[i], valor, (finRecursivo - inicioRecursivo) / 1e9);
                    }
                    break;

                case 4:
                    System.out.println();
                    
                    System.out.println("Saliendo del programa.........");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (xd != 4);

        input.close();
    }
}