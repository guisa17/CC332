import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JTextArea;


public class DS_Thread {

private static JFrame WDW1 = new JFrame("Thread #01");
private static JFrame WDW2 = new JFrame("Thread #02");
private static JFrame WDW3 = new JFrame("Thraed #03");
private static JFrame WDW4 = new JFrame("Thread #04");

private static JScrollPane SP1;
private static JScrollPane SP2;
private static JScrollPane SP3;
private static JScrollPane SP4;

private static JTextArea TA1 = new JTextArea();
private static JTextArea TA2 = new JTextArea();
private static JTextArea TA3 = new JTextArea();
private static JTextArea TA4 = new JTextArea();

private static Font fntLABEL = new Font("Arial", Font.BOLD, 24);
private static Font fntTEXT = new Font("Lucida Console", Font.BOLD, 18);

private static JLabel LBL1Start = new javax.swing.JLabel();
private static JLabel LBL1Finish = new javax.swing.JLabel();
private static JLabel LBL2Start = new javax.swing.JLabel();
private static JLabel LBL2Finish = new javax.swing.JLabel();
private static JLabel LBL3Start = new javax.swing.JLabel();
private static JLabel LBL3Finish = new javax.swing.JLabel();
private static JLabel LBL4Start = new javax.swing.JLabel();
private static JLabel LBL4Finish = new javax.swing.JLabel();

private static final int NUM_THREADS = 4;
public static final int N = 1000;
public static final int M = 1000;
public static int[][] DS = new int[N][M];
private static final int COMB = N * (N - 1) / 2;
private static int[] LEFT_COL = new int[COMB];
private static int[] RIGHT_COL = new int[COMB];
// private static Thread[] threads = new Thread[NUM_THREADS];


    //==============================================================================
    public static void ConfigurarControles(JFrame WDW, 
                                            int WW,
                                            int HH,
                                            int LEFT,
                                            int TOP, 
                                            JScrollPane SP,
                                            JTextArea TA, 
                                            JLabel LBLStart, 
                                            JLabel LBLFinish
                                            ) {
        
        WDW.setSize(WW, HH);
        WDW.setLocation(LEFT, TOP);
        WDW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WDW.setLayout(null); //
        WDW.setVisible(true);

        LBLStart.setBounds(25, 20, 300, 40);
        LBLFinish.setBounds(25, 400, 300, 400);

        LBLStart.setFont(fntLABEL);
        LBLFinish.setFont(fntLABEL);

        TA.setEditable(false);
        TA.setBounds(35, 60, 300, 500);
        TA.setBackground(Color.WHITE);
        TA.setFont(fntTEXT);
        TA.setForeground(Color.GREEN);
        TA.setBackground(Color.BLACK);

        SP = new JScrollPane(TA);
        SP.setBounds(25, 50, 300, 500);

        WDW.add(LBLStart);
        WDW.add(SP);
        WDW.add(LBLFinish);
        WDW.setVisible(true);
                                                
    }

    //==============================================================================
    private static void LoadDataSet() {
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DS[i][j] = r.nextInt(50);
            }
        }
    }

    private static void LoadVectors() {
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                LEFT_COL[k] = i;
                RIGHT_COL[k] = j;
                k++;
            }
        }
    }


    //==============================================================================
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger AI1 = new AtomicInteger(1);
        AtomicInteger AI2 = new AtomicInteger(1);
        AtomicInteger AI3 = new AtomicInteger(1);
        AtomicInteger AI4 = new AtomicInteger(1);
        
        LoadDataSet();
        LoadVectors();

        ConfigurarControles(WDW1, 375, 800, 20, 10, SP1, TA1, LBL1Start, LBL1Finish);
        ConfigurarControles(WDW2, 375, 800, 395, 10, SP2, TA2, LBL2Start, LBL2Finish);
        ConfigurarControles(WDW3, 375, 800, 770, 10, SP3, TA3, LBL3Start, LBL3Finish);
        ConfigurarControles(WDW4, 375, 800, 1145,10, SP4, TA4, LBL4Start, LBL4Finish);
        
        //-------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                long inicio = System.currentTimeMillis();
                LBL1Start.setText("Thread #01");
                
                for (int k = 0; k < COMB; k += NUM_THREADS) {
                    float medida = Library.Pearson(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.DistEuclidiana(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Hamming(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Spearman(LEFT_COL[k], RIGHT_COL[k]);
                    
                    TA1.append("(i, j): " + LEFT_COL[k] + " " + RIGHT_COL[k] + " => val: " + medida + "\n");
                }

                AI1.set(0);
                long fin = System.currentTimeMillis() - inicio;
                LBL1Finish.setText("Time Execution: " + fin / 1000 + " segundos");
                System.out.println("\n"); 
            }
        }).start();

        //-------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                long inicio = System.currentTimeMillis();
                LBL2Start.setText("Thread #02");
                
                for (int k = 1; k < COMB; k += NUM_THREADS) {
                    float medida = Library.Pearson(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.DistEuclidiana(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Hamming(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Spearman(LEFT_COL[k], RIGHT_COL[k]);

                    TA2.append("(i, j): " + LEFT_COL[k] + " " + RIGHT_COL[k] + " => val: " + medida + "\n");
                }

                AI2.set(0);
                long fin = System.currentTimeMillis() - inicio;
                LBL2Finish.setText("Time Execution: " + fin / 1000 + " segundos");
                System.out.println("\n"); 
            }
        }).start();

        //-------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                long inicio = System.currentTimeMillis();
                LBL3Start.setText("Thread #03");
                
                for (int k = 2; k < COMB; k += NUM_THREADS) {
                    float medida = Library.Pearson(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.DistEuclidiana(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Hamming(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Spearman(LEFT_COL[k], RIGHT_COL[k]);

                    TA3.append("(i, j): " + LEFT_COL[k] + " " + RIGHT_COL[k] + " => val: " + medida + "\n");
                }

                AI3.set(0);
                long fin = System.currentTimeMillis() - inicio;
                LBL3Finish.setText("Time Execution: " + fin / 1000 + " segundos");
                System.out.println("\n"); 
            }
        }).start();

        //-------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                long inicio = System.currentTimeMillis();
                LBL4Start.setText("Thread #04s");
                
                for (int k = 3; k < COMB; k += NUM_THREADS) {
                    float medida = Library.Pearson(LEFT_COL[k], RIGHT_COL[k]);  
                    // float medida = Library.DistEuclidiana(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Hamming(LEFT_COL[k], RIGHT_COL[k]);
                    // float medida = Library.Spearman(LEFT_COL[k], RIGHT_COL[k]);

                    TA4.append("(i, j): " + LEFT_COL[k] + " " + RIGHT_COL[k] + " => val: " + medida + "\n");
                }

                AI4.set(0);
                long fin = System.currentTimeMillis() - inicio;
                LBL4Finish.setText("Time Execution: " + fin / 1000 + " segundos");
                System.out.println("\n"); 
            }
        }).start();
    }
}
