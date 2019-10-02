package testing;

/**
 * Created by hatim.lokhandwala on 17/05/19.
 */
public class Pair {


	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}
