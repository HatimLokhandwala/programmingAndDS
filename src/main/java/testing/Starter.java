package testing;

import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Created by hatim.lokhandwala on 10/05/19.
 */
class Employee{
	int age;
	String name;
	Employee(int age, String name){
		this.name = name;
		this.age = age;

	}

//	@Override
//	public boolean equals(Object obj) {
//		Employee other = (Employee)obj ;
//		return this.age == other.age && this.name.equals(other.name);
//	}
//

	@Override
	public int hashCode() {
		int hashcode = 31* this.age;
		hashcode = 31 * hashcode + this.name.hashCode();
		return  hashcode;
	}
}
public class Starter {

	static void hashmap(){
		HashMap<Employee, String> candidateMap= new HashMap<>();
		Employee hatim = new Employee(26, "hatim");
		Employee hatim1 = new Employee(26, "hatim");
		Employee hatim2 = new Employee(26, "hatim");
		candidateMap.put(hatim, "hatim");
		candidateMap.put(new Employee(23, "rameshg"), "ramesh");
//		System.out.println(candidateMap.containsKey(hatim1));
		System.out.println(candidateMap.size());
		System.out.println(candidateMap.keySet().size());
		candidateMap.put(hatim1, "hussain");
		candidateMap.put(hatim2, "hussain23");
		System.out.println(candidateMap.keySet().size());
		Set<Map.Entry<Employee,String >> entrySet = candidateMap.entrySet();
		for(Map.Entry<Employee, String> entry: candidateMap.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println(entrySet.size());
//		candidateMap.
		int count=0;
		for(Employee employee: candidateMap.keySet()){
			System.out.println(count++);
			System.out.println("Here " + candidateMap.get(employee).toString());
		}
		System.out.println(candidateMap.get(hatim));
		System.out.println(candidateMap.get(hatim));
		System.out.println(candidateMap.get(hatim1));
		System.out.println(candidateMap.containsKey(hatim1));
	}
	public static void main(String args[]){
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.x - o2.x);
		pq.add(new Pair(40,10));
		pq.add(new Pair(20,4));
		System.out.println(pq.peek());

		HashMap<Integer,Pair> hdMap = new HashMap<>();
		hdMap.put(1,new Pair(10,20));
//		hdMap.put(1,24);
//		for(Integer key :hdMap.keySet()){
//			System.out.println(key + " " + hdMap.get(key));
//		}
		Pair p = hdMap.get(1);
		p.y = 30;
		System.out.println(hdMap.get(1));
		Pair arr[] = new Pair[100];
//		Arrays.sort(arr, (o1, o2) -> o1.y - o2.y);
		Node<Integer> node = new Node<>(1, null, null);
		Node<Integer> node1 = new Node<>(13, node, null);
		hashmap();
		List<Integer> a = new ArrayList<>();
		a.add(20);
		a.add(12312);
		Iterator it = a.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}



