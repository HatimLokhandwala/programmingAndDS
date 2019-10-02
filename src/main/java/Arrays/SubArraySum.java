package Arrays;

import java.awt.image.IndexColorModel;
import java.util.Scanner;


public class SubArraySum{
    void checkSum(int a[], int sum, int n){
        int b[][] = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            b[i][i] = a[i];
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                // b[j][j+i-1] = a[]
            }
        }
    }

    public static void main(String args[]){
        int testCases;
        Scanner sc = new Scanner(System.in);
        testCases = sc.nextInt();
        while(testCases>0){
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int a[] = new int[n+1];
            for(int i=1;i<=n;i++){
                a[i] = sc.nextInt();
            }
            
        }
    }
}