package lct.amazon;

//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
// 
//Constraints:
//-231 <= x <= 231 - 1

public class ReverseInteger {

	public int reverse(int x) {

		int temp = 0;

		while (x != 0) {
			int tempDigit = (x % 10);	
			x = (x / 10);
            if (temp > Integer.MAX_VALUE/10 || (temp == Integer.MAX_VALUE / 10 && tempDigit > 7)) return 0;
            if (temp < Integer.MIN_VALUE/10 || (temp == Integer.MIN_VALUE / 10 && tempDigit < -8)) return 0;
            		
			temp = temp*10 + tempDigit;
		}
		return temp;
	}
	
	public int reverseStringB(int x) {
        String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }
    }

	public static void main(String[] args) {

		int x = -123;
		int y = 1534236469;
		
		ReverseInteger ri = new ReverseInteger();
		
		System.out.println(ri.reverse(x));
		System.out.println(ri.reverse(y));
		
		System.out.println(ri.reverseStringB(x));
		System.out.println(ri.reverseStringB(y));

	}

}
