import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 06/04/19.
 */
public class Number {

	public static void parseAndConvert(BigInteger inputNumber, int index){
		BigInteger ten = new BigInteger("10");
		BigInteger four = new BigInteger("4");
		BigInteger zero = new BigInteger("0");
		BigInteger tempNumber = inputNumber;
		String number1Str = "";
		while(!tempNumber.equals(zero)){
			if(tempNumber.remainder(ten).equals(four)){
				number1Str = "3" + number1Str;
			}
			else{
				number1Str = "0" + number1Str;
			}
			tempNumber = tempNumber.divide(ten);
		}
		BigInteger number1 = new BigInteger(number1Str);
		BigInteger number2 = inputNumber.subtract(number1);
		System.out.println("Case #" + index + ": " + number1 + " " + number2 );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCount = sc.nextInt();
		int count =1;
		while(count <= testCount){
			BigInteger bigInteger = sc.nextBigInteger();
			parseAndConvert(bigInteger, count);
			count++;
		}

	}
}
