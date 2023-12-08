import javax.swing.JTextArea;

public class Library {
    
    //===========================================================
    public static void imprimirPares(int N, JTextArea TA) {
        for (int i = 1; i <= N; i++) {
            TA.append("Par " + i + ": " + 2 * i + "\n");
        }
    }

    //==============================================================================
    public static void imprimirImpares(int N, JTextArea TA) {
        for (int i = 1; i <= N; i++) {
            TA.append("Impar " + i + ": " +  (2 * i - 1) + "\n");
        }
    }

    //==============================================================================
    public static long fibR(int n) {
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else return fibR(n - 2) + fibR(n - 1);
    }

    public static void imprimirFibonacci(int N, JTextArea TA) {
        for (int i = 1; i <= N; i++) {
            TA.append("Fib(" + i + ") = " + fibR(i) + "\n");
        }
    }

    //==============================================================================
    public static void generarPrimos(int N, JTextArea TA) {
        int i = 1;
        for (long numero = 2; numero <= N; numero++) {
            if (esPrimo(numero)) {
                TA.append("Primo " + i + ": " + numero + "\n");
                i++;
            }
        }
    }

    public static boolean esPrimo(long numero) {
        if (numero <= 1) return false;
        if (numero <= 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;

        int i = 5;
        while (i * i <= numero) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }
}
