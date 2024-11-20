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
		int plus = 0;
		for (int i = 0; i < x1; i++) {
			if (x1 > 0) plus++; 
			else plus--; 
		}		
		for (int i = 0; i < x2; i++) {
			if (x2 > 0) plus++; 
			else plus--; 
		}
		return plus;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int minus = 0;
		for (int i = 0; i < x1; i++) {
			if (x1 > 0) minus++; 
			else minus--;	
		}		
		for (int i = 0; i < x2; i++) {
			if (x2 > 0) minus--; 
			else minus++;	
		}		
		return minus;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int times = 0;
		for (int i = 0; i < x1; i++) {
			times += x2;
		}
		return times;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		for (int i = 0; i < n; i++) {
			pow = times(pow, x);
		}
		return pow;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int div = 0;
		int i = 0;
		if (x1 >= x2) {
			while (i + x2 <= x1) {
				i += x2;
				div++;
			}
		}
		return div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divResult = div(x1, x2);
		int timesResult = times(divResult, x2);
		return minus(x1, timesResult);
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int sqrt = 0;
		int i = 0;
		while (times(i, i) <= x) {
			sqrt = i;
			i++;
		}
		return sqrt;
	}
}
