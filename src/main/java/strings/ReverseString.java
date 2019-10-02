package strings;

/**
 * Created by hatim.lokhandwala on 05/07/19.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
	Given s = "the sky is blue",
	return "blue is sky the".
 eht yks si eulb
 blue is sky the
 */
//	fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq
public class ReverseString {

	public static String reverseWords(String a) {
		long r = 1;
		int len = a.length();
		String[] arr = a.split(" ");
		for(int i = 0; i < arr.length/2 ; i++) {
			String temp = arr[i];
			arr[i] = arr[arr.length - 1 -i];
			arr[arr.length - 1 -i] = temp;
		}
		String output = "";
		for(int i = 0; i < arr.length; i++) {
			output += arr[i] + " ";
		}
		output = output.trim();
		return output;
	}

	public static void main(String[] args) {
		String a = "fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq";
		System.out.println(reverseWords(a));
	}
}
