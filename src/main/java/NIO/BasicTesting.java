package NIO;

import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

/**
 * Created by hatim.lokhandwala on 08/07/19.
 */
public class BasicTesting {

	public static void main(String[] args) {
		IntBuffer intBuffer = IntBuffer.allocate(20);
		int[] arr = {10, 20, 30};
		intBuffer.put(arr);
		intBuffer.flip(); //read
		System.out.println(intBuffer.get());
		System.out.println(intBuffer.get());
		intBuffer.compact(); //write

		arr = new int[4];
		arr[0] = 520;
		arr[1] = 60;

		intBuffer.put(arr);
		intBuffer.flip();
		System.out.println(intBuffer.get());
		System.out.println(intBuffer.get());

	}
}