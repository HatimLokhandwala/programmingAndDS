import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 16/07/19.
 */
public class Solution {
	/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


		final static String FIZZ = "Fizz";
		final static String BUZZ = "Buzz";
		final static String FIZZBUZZ = "FizzBuzz";
		static void printDetails(int N) {
			for(int i=1; i<=N;i++) {
				String output = "";
				if(i%3 == 0){
					output += FIZZ;
				}
				if(i%5 == 0){
					output += BUZZ;
				}
				if(output.isEmpty()) {
					System.out.println(i);
				} else {
					System.out.println(output);
				}

			}
		}
		public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

			// Write your code here
			Scanner sc = new Scanner(System.in);
			int testCases = sc.nextInt();
			int N = 0;
			while(testCases > 0) {
				testCases--;
				N = sc.nextInt();
				printDetails(N);

			}
		}
	}

