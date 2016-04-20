/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wdfidf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

/**
 *
 * @author VolAl02
 */
public class WDFIDF {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Wilkommen!");
        WDFIDF wd = new WDFIDF();
        wd.wdfidf();
    }

    private void wdfidf() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        /**
         * G(t,d) = TF(t,d) * IDF(t)
         * WDF * IDF
         * WDF(t,d) = (ld[Freq(t,d)+1]/ld L)
         * IDF(t) = (ld N / n) +1
         */
        
        System.out.println("Häufigkeit des Terms im Dokument: ");
        String value1 = reader.readLine();
        double freqTD = Double.parseDouble(value1); // Häufigkeit des Terms im Dokument
        
        System.out.println("Anzahl der Wörter im Dokument: ");
        String value2 = reader.readLine();
        double L = Double.parseDouble(value2); // Anzahl der Wörter im Dokument
        double WDF = (log2(freqTD, 2) + 1) / log2(L, 2);
        System.out.println("WDF: " + WDF*100 + "%");
        
        System.out.println("Anzahl der Dokumente in der Datenbank: ");
        String value3 = reader.readLine();
        double N = Double.parseDouble(value3); // Anzahl der Dokument in der Datenbank
        System.out.println("Anzahl der Dokumente, in denen der Term vorkommt: ");
        String value4 = reader.readLine();
        double n = Double.parseDouble(value4); // Anzahl der Dokumente, in denen der Term vorkommt
        double IDF = (log2((N / n), 2)); // ohne Stoppwortliste --> mit wäre + 1
        System.out.println("IDF: " + IDF);
        
        double G = WDF * IDF;
        System.out.println("G: " + G);
    }
    public Double log2(double x, double base) {
        System.out.println("x: " + Math.log(x) + ", base: " + Math.log(base));
        double result = ((Math.log(x) / Math.log(base)));
        System.out.println("result: " + result);
        return result;
    }
}
