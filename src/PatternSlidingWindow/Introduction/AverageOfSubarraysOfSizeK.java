package PatternSlidingWindow.Introduction;

import java.util.Arrays;

public class AverageOfSubarraysOfSizeK {
	// Brute force approach => Time complexity O(N*K)
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
	// The efficient way to solve this problem using sliding window => Time
	// complexity O(N)
	public static double[] findAveragesOptimized(int k, int[] arr) {
		double[] result = new double[arr.length - k + 1];
		double windowSum = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd <= arr.length - 1; windowEnd++) {
			windowSum += arr[windowEnd];
			if (windowEnd >= k - 1) {
				result[windowStart] = windowSum / k;
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		double[] bruteForceResult = AverageOfSubarraysOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
		System.out.println("Using brute force: ");
		System.out.println("Averages of subarrays of size K: " + Arrays.toString(bruteForceResult));

		double[] slidingwindowResult1 = AverageOfSubarraysOfSizeK.findAveragesOptimized(5,
				new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
		System.out.println("Using sliding window: ");
		System.out.println("Averages of subarrays of size K: " + Arrays.toString(slidingwindowResult1));
	}

}
