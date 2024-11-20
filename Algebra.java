public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(2,3));   
	    System.out.println(minus(7,2));  
   		System.out.println(minus(2,7));  
 		System.out.println(times(3,4));  
   		System.out.println(plus(2,times(4,2)));  
   		System.out.println(pow(5,3));      
   		System.out.println(pow(3,5));      
   		System.out.println(div(12,3));   
   		System.out.println(div(5,5));    
   		System.out.println(div(25,7));   
   		System.out.println(mod(25,7));   
   		System.out.println(mod(120,6));  
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int plus(int x1, int x2) {
		int plus = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				plus++;
			}
		} else {
			for (int i = 0; i < -x2; i++) {
				plus--;
			}
		}
		return plus;
	}

	public static int minus(int x1, int x2) {
		return plus(x1, -x2);
	}

	public static int times(int x1, int x2) {
		int result = 0;
		boolean isNegative = false;
		if (x1 < 0) {
			x1 = plus(~x1, 1);
			isNegative = !isNegative;
		}
		if (x2 < 0) {
			x2 = plus(~x2, 1);
			isNegative = !isNegative;
		}
		for (int i = 0; i < x1; i++) {
			result = plus(result, x2);
		}
		if (isNegative) {
			result = plus(~result, 1);
		}
		return result;
	}

	public static int pow(int x, int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result = times(result, x);
		}
		return result;
	}

	public static int div(int x1, int x2) {
		int result = 0;
		boolean isNegative = false;
		if (x1 < 0) {
			x1 = plus(~x1, 1);
			isNegative = !isNegative;
		}
		if (x2 < 0) {
			x2 = plus(~x2, 1);
			isNegative = !isNegative;
		}
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			result = plus(result, 1);
		}
		if (isNegative) {
			result = plus(~result, 1);
		}
		return result;
	}

	public static int mod(int x1, int x2) {
		int divResult = div(x1, x2);
		int timesResult = times(divResult, x2);
		return minus(x1, timesResult);
	}

	public static int sqrt(int x) {
		int sqrt = 0;
		int i = 0;
		while (times(i, i) <= x) {
			sqrt = i;
			i = plus(i, 1);
		}
		return sqrt;
	}
}
