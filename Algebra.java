// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;
		for (int i =0; i<x2; i++) // רץ X2 פעמים
		{
			sum++;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int minus = x1;
		for (int i =0; i<x2; i++) // רץ X2 פעמים
		{
			minus--;
		}
		return minus;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int multiply =0;
		for (int i =0; i<x2; i++)
		{
			multiply = plus(multiply, x1); // מריץ את פעולת החיבור X2 פעמים
		}
		return multiply;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int power = 1; //
		for (int i=0;i<n;i++)
		{
			power = times (x,power); //מריץ את פעולת הכפל N פעמים
		}
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int multi = x2;
		int count=0; //  
		while (multi<=x1) // בודק כמה פעמים שלמות X1 "נכנס" בX2		{
		{
		multi = plus(multi, x2); 
			count++;
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		int divider = div(x1, x2); // משתמש בפונקציית החלוקה לבדווק כמה פעמים שלמות X2 נכנס בX1
		int timer = times(divider, x2); // המספר השלם ללא השארית
		int modular = minus(x1, timer);// חישוב השארית
		return modular;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int num = 0;
		while (times(num, num)<x)
		{
			num++;
		}
		if (times(num, num)>x)
		{
			num --;
		}
		return num;
	}	  	  
}