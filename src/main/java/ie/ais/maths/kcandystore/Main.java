package ie.ais.maths.kcandystore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int array_limit = 1000;
	private static final long moduo = 1000000000;
	private static final int test_limit = 200;
	private double[][] longArray = new double[2*array_limit-1][array_limit];
	
	
	public Main() {
		initTwoDimensionalLongArray();
	}

	public static void main(String[] args)
	{
		Main main1 = new Main();
		String input;
		int t;
		System.out.println("Enter values following with pressing ENTER");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
			input = bufferedReader.readLine();
		} catch (IOException e) {
        	System.err.println("Something is wrong");
        	return;
		}
		if (!main1.isNumber200(input.trim()))	
  		{
	        	System.err.println("Something is wrong");
	        	throw new NumberFormatException("Wrong Number");
  		}
		
		t = Integer.parseInt(input);
		
		if (t > test_limit)	
  		{
	        	System.err.println("Number of test exceeded "+ t);
	        	return;
  		}
		main1.mainLoop(t);

	}

	public void mainLoop(int t) {
		while (t-- != 0)
		{
			int n;
			int k;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String input = null;
			try {
				input = bufferedReader.readLine();
			} catch (IOException e) {
				System.err.println("Something is wrong" + e.getMessage());
				return;
			}
			if (!isNumber(input.trim()))	
			{
				System.err.println("Something is wrong");
				throw new NumberFormatException("Wrong Number");
			}
			n = Integer.parseInt(input);
			if (n >= array_limit)	
	  		{
		        	System.err.println("Number of array exceeded "+ n);
		        	return;
	  		}
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = bufferedReader.readLine();
			} catch (IOException e) {
				System.err.println("Something is wrong" + e.getMessage());
				return;
			}
			if (!isNumber(input.trim()))	
			{
				System.err.println("Something is wrong");
				throw new NumberFormatException("Wrong Number");
			}
			k = Integer.parseInt(input);
			if (k >=  array_limit)	
	  		{
		        	System.err.println("Number of array exceeded "+ k);
		        	return;
	  		}
			iteration(n,k);
		}
		
	}

	private void iteration(int n, int k) {
		double r = longArray[n + k - 1][k];
		r = r % moduo;
		System.out.println((long)r);
	}

	private void initTwoDimensionalLongArray() {
		for (int i = 0;i < 2*array_limit-1;++i)
		{
			for (int j = 0;j < array_limit;++j)
			{
				longArray[i][j] = 0;
			}
		}
		for (int i = 1;i < 2*array_limit -1;++i)
		{
			longArray[i][0] = 1;
			longArray[i][1] = i;
			try {
				for (int j = 2; (j< array_limit && j <= i); ++j)
				{
					longArray[i][j] = longArray[i - 1][j] + longArray[i - 1][j - 1];
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("error:: "+i);
				System.err.println(e.getMessage());
			}
		}
	}

	private boolean isNumber(String toTest) {
	    return toTest.matches("^[1-9]{1}\\d{0,3}$");
	}
	
	private  boolean isNumber200(String toTest) {
	    return toTest.matches("^[1-9]{1}\\d{0,2}$");
	}
}
