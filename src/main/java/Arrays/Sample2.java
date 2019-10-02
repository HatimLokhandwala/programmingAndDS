package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hatim.lokhandwala on 01/09/19.
 */
public class Sample2 {
	static void sample(Exception n) {
		System.out.println("integer");
	}

	static void sample(ArithmeticException s) {
		System.out.println("string");
	}

	static void sample(Object o) {
		System.out.println("object");
	}
	public static void main(String[] args) {
			sample(null);
			Random r = new Random();

//		System.out.println(Math.random());
		System.out.println(r.nextInt(6) );
		System.out.println(r.nextInt(6) );
		System.out.println(r.nextInt(6) );
		System.out.println(r.nextInt(6) );
			System.out.println("here");

	}
}
