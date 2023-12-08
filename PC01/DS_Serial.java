import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JTextArea;
import java.util.Arrays;



public class DS_Serial {

private static JFrame WDW1 = new JFrame("Programa 1: Numeros pares");
private static JFrame WDW2 = new JFrame("Programa 2: Numeros impares");
private static JFrame WDW3 = new JFrame("Programa 3: Numeros de Fibonacci");
private static JFrame WDW4 = new JFrame("Programa 4: Numeros primos");

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

private static final int N = 150000;
private static final int MAX_ELEMENT = 1000000;

private static int[] V = new int[N];

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
    private static void LoadVector() {
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            V[i] = r.nextInt(MAX_ELEMENT);
        }
        Arrays.sort(V);
    }

    //==============================================================================
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger AI1 = new AtomicInteger(1);
        AtomicInteger AI2 = new AtomicInteger(1);
        AtomicInteger AI3 = new AtomicInteger(1);
        AtomicInteger AI4 = new AtomicInteger(1);
        LoadVector();

        ConfigurarControles(WDW1, 375, 800, 20, 10, SP1, TA1, LBL1Start, LBL1Finish);
        ConfigurarControles(WDW2, 375, 800, 395, 10, SP2, TA2, LBL2Start, LBL2Finish);
        ConfigurarControles(WDW3, 375, 800, 770, 10, SP3, TA3, LBL3Start, LBL3Finish);
        ConfigurarControles(WDW4, 375, 800, 1145,10, SP4, TA4, LBL4Start, LBL4Finish);
        
        //-------------------------------------------------
        long inicio = System.currentTimeMillis();
        LBL1Start.setText("Time Execution: " + inicio / 1000 + " segundos");
        
        Library.imprimirPares(MAX_ELEMENT, TA1);

        AI1.set(0);
        long fin = System.currentTimeMillis() - inicio;
        LBL1Finish.setText("Time Execution: " + fin / 1000 + " segundos");
        System.out.println("\n"); 
  

        //-------------------------------------------------
        inicio = System.currentTimeMillis();
        LBL2Start.setText("Time Execution: " + inicio / 1000 + " segundos");
        
        Library.imprimirImpares(MAX_ELEMENT, TA2);

        AI2.set(0);
        fin = System.currentTimeMillis() - inicio;
        LBL2Finish.setText("Time Execution: " + fin / 1000 + " segundos");
        System.out.println("\n"); 
  

        //-------------------------------------------------
        inicio = System.currentTimeMillis();
        LBL3Start.setText("Time Execution: " + inicio / 1000 + " segundos");
        
        Library.imprimirFibonacci(45, TA3);

        AI3.set(0);
        fin = System.currentTimeMillis() - inicio;
        LBL3Finish.setText("Time Execution: " + fin / 1000 + " segundos");
        System.out.println("\n"); 
      

        //-------------------------------------------------
        inicio = System.currentTimeMillis();
        LBL4Start.setText("Time Execution: " + inicio / 1000 + " segundos");
        
        Library.generarPrimos(MAX_ELEMENT, TA4);

        AI4.set(0);
        fin = System.currentTimeMillis() - inicio;
        LBL4Finish.setText("Time Execution: " + fin / 1000 + " segundos");
        System.out.println("\n"); 

    }

}