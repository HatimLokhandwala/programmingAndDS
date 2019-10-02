import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hatim.lokhandwala on 09/05/19.
 */

class A{
	void sample(){
		System.out.println("in super");
	}
}

class B extends A{
	@Override
	void sample(){
		System.out.println("in child");
	}

	void sampleTesting(){
		System.out.println("in other child method");
	}
}

public class Testing {
	public static void main(String[] args) {
		A a;
		a = new A();
		a.sample();

		a = new B();
		a.sample();
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new LinkedList<>();

		Queue q = new Queue(2);
		try{
			q.add(10);
			q.add(20);
			q.add(30);

		}
		catch (Exception e){
			System.out.println(e);
		}
		try{
			System.out.println(q.delete());
			System.out.println(q.delete());
			System.out.println(q.delete());
		}
		catch (Exception e){
			System.out.println(e);
		}
		RotationQueue q1 = new RotationQueue(3);
		try{
			q1.add(10);
			q1.add(20);
			q1.add(30);

		}
		catch (Exception e){
			System.out.println(e);
		}
		finally {
			q1.print();

		}
		try{
//			q1.delete();
//			q1.delete();
			System.out.println("Removed " + q1.delete());
			System.out.println("Removed " + q1.delete());
//			q1.delete();
			q1.add(40);

		}
		catch (Exception e){
			System.out.println(e);
		}
		finally {
			q1.print();
		}
	}
}


class Queue{
	private int size;
	int a[];
	int rear, front;
	Queue(int size){
		this.size = size;
		a = new int[this.size];
		rear = 0;
		front  = 0;
	}


	boolean isEmpty(){
		return rear == front;
	}

	boolean isFull(){
		return rear == size;
	}

	void add(int elem) throws Exception {
		if(isFull()) throw new Exception("Queue full");
		a[rear++] = elem;
	}

	int delete() throws Exception {
		if(isEmpty()) throw new Exception("Queue Empty");
		return a[front++];
	}

	void print(){
		for(int index = 0; index < front; index++){
			System.out.println(a[index]);
		}
	}

}


class RotationQueue{
	private int size;
	int a[];
	int rear, front;
	RotationQueue(int size){
		this.size = size;
		a = new int[this.size];
		rear = 0;
		front  = 0;
	}


	boolean isEmpty(){
		return rear == front;
	}

	boolean isFull(){
		return (rear == size-1 && front ==0 ) || (front == rear + 1);
	}

	void add(int elem) throws Exception {
		if(isFull()) throw new Exception("Queue full inserting elem" + elem);
		a[rear++] = elem;
		if(rear%size == 0 ) rear =0;
	}

	int delete() throws Exception {
		if(isEmpty()) throw new Exception("Queue Empty front " + front  + " rear " + rear);
		int elem = a[front++];
		if(front % size==0) front = 0;
		return elem;
	}

	void print(){
		System.out.println("-----");

		for(int index = front; index<size;index++){
			System.out.println(a[index]);
		}
		for(int index = 0; index<rear;index++) {
			System.out.println(a[index]);

		}
		System.out.println("-----");

	}




}