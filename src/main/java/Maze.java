import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 06/04/19.
 */
public class Maze {
	private static void solve(String path, int index){

		path = path.replace("S", "A").replace("E", "S").replace("A", "E");
		System.out.println("Case #" + index + ": " + path);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCount = sc.nextInt();
		int count =1;
		while(count <= testCount){
			int pathLength = sc.nextInt();
			String enemyPath = sc.next();
			solve(enemyPath, count);
			count++;
		}
	}
}
