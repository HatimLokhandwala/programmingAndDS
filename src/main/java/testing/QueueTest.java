package testing;

import java.util.Queue;

/**
 * Created by hatim.lokhandwala on 10/05/19.
 */
public class QueueTest {


	public static void main(String[] args) {
//		Queue q =
		Inherit i = new Inherit();
		i.print();
	}
}

class Inherit{
	final int A;
	final int B;
	{
		A = 1;
		B = 1;

	}
	void print(){
		{
			System.out.println("Asdsa");
		}
		System.out.println(A + " "  + B);
	}

}
