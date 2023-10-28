import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 0;
        int[] x = new int[n+1];
        int[] v = new int[n+1];
        int[] r = new int[n+1];
        while (k != n){
            int r1 = scanner.nextInt(), v1 = scanner.nextInt() , x1 = scanner.nextInt() ;
            r[k] = r1;
            v[k] = v1;
            x[k] = x1;
            k++;
        }
        double minTime = 1000000000;
        for(int i = 0 ;  i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if((v[i] > v[j] && x[i] < x[j]) || (v[i] < v[j] && x[i] > x[j])){
                    double d = distance(r[i] , r[j] , x[i] , x[j]);
                    double time = d /abs(v[i] - v[j]);
                    if(time < minTime) minTime = time;
                    if(minTime == 0.00) break;
                }
            }
        }
        if(minTime == 1000000000) System.out.println("Collision-Free System");
        else System.out.printf("%.2f" , minTime);
    }

     public static double distance(int r1, int r2, int x1, int x2){
        return abs(abs(x2 - x1) - 2 * sqrt(r1 * r2));
    }
}