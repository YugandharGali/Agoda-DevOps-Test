package devops;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PowerSum {

	// Complete the powerSum function below.
	static int powerSum(int X, int N) {
		return powerCalculate(X, N, 1);
	}

	private static int powerCalculate(int x, int n, int baseNum) {
		int numPow = (int) Math.pow(baseNum, n);
		if (numPow > x)
			return 0;
		else if (numPow == x)
			return 1;
		else
			return (powerCalculate(x, n, baseNum + 1) + powerCalculate(x - numPow, n, baseNum + 1));

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int X = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = powerSum(X, N);
		System.out.println("Output: " + result);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();
	}
}