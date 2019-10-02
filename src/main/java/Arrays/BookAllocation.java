package Arrays;
import java.util.Scanner;
/**
 * Created by hatim.lokhandwala on 13/07/19.
 */
/** there are n books and m students (n >= m)
 * Given pages in each of the n books
 * allocates books to m students in contiguous manner such that
 * maximum no. of pages obtained by any student is minimized
 */
public class BookAllocation {

		private static boolean  checkValidCombination(int[] pages, int k, int m) {
			int count = 1;
			int sum = 0;
			for (int page : pages) {
				if (sum + page > k) {
					sum = page;
					count++;
				} else {
					sum += page;
				}
			}
			return count <= m;
		}


		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n; //books
			int m; //students
			n = sc.nextInt();
			m = sc.nextInt();
			int[] pages = new int[n]; //hold pages in the book
			int low = Integer.MIN_VALUE;
			int high = 0;
			for(int i=0; i<n;i++) {
				pages[i] = sc.nextInt();
				low = Math.max(low, pages[i]);
				high += pages[i];

			}
			int ans = 0;
			while(low <= high) {
				int mid = low + (high - low + 1) / 2;
				boolean res = checkValidCombination(pages, mid, m);
				if(res) {
					ans = mid;
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			//print o/p
			System.out.println(ans);
		}
}






