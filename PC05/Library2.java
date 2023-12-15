
public class Library2 {
    
    //===========================================================
    public static int Hamming(int i, int j) {
        int distancia = 0;
        for (int k = 0; k < DS_Serial.M; k++) {
            if (DS_Serial.DS[i][k] != DS_Serial.DS[j][k]) {
                distancia++;    
            }
        }
        return distancia;
    }


    //===========================================================
    public static float DistEuclidiana(int i, int j) {
        int distancia = 0;
        for (int k = 0; k < DS_Serial.M; k++) {
            distancia += (DS_Serial.DS[i][k] - DS_Serial.DS[j][k]) * 
                         (DS_Serial.DS[i][k] - DS_Serial.DS[j][k]);
        }
        return (float) Math.sqrt(distancia);
    }


    //===========================================================
    public static float Pearson(int i, int j) {
        return DotProduct(i, j) / (Norm(i) * Norm(j));
    }

    private static float DotProduct(int i, int j) {
        float acm = 0;
        for (int k = 0; k < DS_Serial.M; k++) {
            acm += DS_Serial.DS[i][k] * DS_Serial.DS[j][k];
        }
        return acm;
    }

    private static float Norm(int k) {
        float norm = 0;
        for (int i = 0; i < DS_Serial.M; i++) {
            norm += DS_Serial.DS[k][i] * DS_Serial.DS[k][i];
        }
        return norm;
    }


    //===========================================================
    public static float Spearman(int i, int j) {
        int[] rankI = Rango(DS_Serial.DS[i]);
        int[] rankJ = Rango(DS_Serial.DS[j]);
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
