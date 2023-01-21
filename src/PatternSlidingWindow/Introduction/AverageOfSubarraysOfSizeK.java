package PatternSlidingWindow.Introduction;

import java.util.Arrays;

public class AverageOfSubarraysOfSizeK {

	public static double[] findAverages(int k, int[] arr) {
		double[] result = new double[arr.length - k + 1];
		for (int i = 0; i <= arr.length - k; i++) {
			double sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += arr[j];
			}
			result[i] = sum / k;
		}
		return result;
	}

	public static void main(String[] args) {
		double[] result = AverageOfSubarraysOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
		System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
	}

}
