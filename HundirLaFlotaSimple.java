import java.util.Scanner;

public class HundirLaFlotaSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int tamaño = 5;
        int numBarcos = 3;
        int intentos = 10;
        
        int[][] tablero = new int[tamaño][tamaño];
        boolean[][] disparos = new boolean[tamaño][tamaño];
        int hundidos = 0;

        for (int i = 0; i < numBarcos; i++) {
            int f = (int) (Math.random() * tamaño);
            int c = (int) (Math.random() * tamaño);
            
            if (tablero[f][c] == 1) {
                i--; 
            } else {
                tablero[f][c] = 1;
            }
        }

        while (intentos > 0 && hundidos < numBarcos) {
            
            System.out.println("\n--- MAPA ---");
            System.out.print("  0 1 2 3 4\n");
            
            for (int i = 0; i < tamaño; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < tamaño; j++) {
                    if (disparos[i][j]) {
                        if (tablero[i][j] == 1) {
                            System.out.print("X ");
                        } else {
                            System.out.print("- ");
                        }
                    } else {
                        System.out.print("? ");
                    }
                }
                System.out.println();
            }

            System.out.println("\nTe quedan " + intentos + " intentos.");
            System.out.print("Fila (0-4): ");
            int f = scanner.nextInt();
            System.out.print("Columna (0-4): ");
            int c = scanner.nextInt();

            if (f >= 0 && f < tamaño && c >= 0 && c < tamaño) {
                
                if (disparos[f][c]) {
                    System.out.println("Ya habias disparado ahi, No cuenta el intento.");
                } else {
                    disparos[f][c] = true;
                    intentos--;

                    if (tablero[f][c] == 1) {
                        System.out.println("TOCADO");
                        hundidos++;
                    } else {
                        System.out.println("Agua");
                    }
                }

            } else {
                System.out.println("Número incorrecto. Debe ser entre 0 y 4.");
            }
        }

        if (hundidos == numBarcos) {
            System.out.println("\nHAS GANADO, Hundiste toda la flota.");
        } else {
            System.out.println("\nHAS PERDIDO, Se acabaron los intentos.");
        }
        
        scanner.close();
    }
}