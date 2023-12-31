
public class Library {
    
    //===========================================================
    public static int Hamming(int i, int j) {
        int distancia = 0;
        for (int k = 0; k < DS_Thread.M; k++) {
            if (DS_Thread.DS[i][k] != DS_Thread.DS[j][k]) {
                distancia++;    
            }
        }
        return distancia;
    }


    //===========================================================
    public static float DistEuclidiana(int i, int j) {
        int distancia = 0;
        for (int k = 0; k < DS_Thread.M; k++) {
            distancia += (DS_Thread.DS[i][k] - DS_Thread.DS[j][k]) * 
                         (DS_Thread.DS[i][k] - DS_Thread.DS[j][k]);
        }
        return (float) Math.sqrt(distancia);
    }


    //===========================================================
    public static float Pearson(int i, int j) {
        return DotProduct(i, j) / (Norm(i) * Norm(j));
    }

    private static float DotProduct(int i, int j) {
        float acm = 0;
        for (int k = 0; k < DS_Thread.M; k++) {
            acm += DS_Thread.DS[i][k] * DS_Thread.DS[j][k];
        }
        return acm;
    }

    private static float Norm(int k) {
        float norm = 0;
        for (int i = 0; i < DS_Thread.M; i++) {
            norm += DS_Thread.DS[k][i] * DS_Thread.DS[k][i];
        }
        return norm;
    }


    //===========================================================
    public static float Spearman(int i, int j) {
        int[] rankI = Rango(DS_Thread.DS[i]);
        int[] rankJ = Rango(DS_Thread.DS[j]);
        int n = rankI.length;

        int[] rankDiff = new int[n];
        for (int k = 0; k < n; k++) {
            rankDiff[k] = rankI[k] - rankJ[k];
        }

        float distancia = 0;
        for (int k = 0; k < n; k++) {
            distancia += rankDiff[k] * rankDiff[k];
        }
        distancia /= n;
        return distancia;
    }

    private static int[] Rango(int[] arr) {
        int n = arr.length;
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    rank[i]++;
                } else if (arr[i] > arr[j]) {
                    rank[j]++;
                }
            }
        }
        return rank;
    }
}
