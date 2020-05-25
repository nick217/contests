package codechef.dsa_learning_series.contest7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 	Link: https://www.codechef.com/LRNDSA07/problems/KPRIME
 * 	Alice and Bob are studying for their class test together. The topic of the test is Prime Numbers. 
 * 	The preparation is getting too boring for their liking. To make it interesting, they turn it into a game. 
 * 	The winner will get an ice-cream treat from the other.
 * 	The game is called Count K-Primes. A number is a k-prime if it has exactly k distinct prime factors. 
 * 	The game is quite simple. Alice will give three numbers A, B & K to Bob. Bob needs to tell Alice the number of K-prime 
 * 	numbers between A & B (both inclusive). If Bob gives the correct answer, he gets a point. If not, Alice gets a point. 
 * 	They play this game T times.
 * 	Bob hasn't prepared so well. But he really wants to win the game. He wants you to tell him the correct answer.
	
	Input
	First line of input contains a single integer T, the number of times they play. 
	Each game is described in a single line containing the three numbers A,B & K.

	Output
	For each game, output on a separate line the number of K-primes between A & B.

	Constraints:
	1 ≤ T ≤ 10000
	2 ≤ A ≤ B ≤ 100000
	1 ≤ K ≤ 5

	Example:
	Input
	4
	2 5 1
	4 10 2
	14 15 2
	2 20 3

	Output
	4
	2
	2
	0
 */
public class CountK_Primes {

	public static void main(String[] args) throws java.lang.Exception {
		int max_value = 100000;
		boolean isPrime[] = new boolean[max_value + 1];
		int factors[] = new int[max_value + 1];
		int dp[][] = new int[6][max_value + 1];
		Arrays.fill(isPrime, true);

		for (int p = 2; p <= max_value; p++) {
			if (isPrime[p] == true) {
				factors[p] = 1;
				int j = p;
				while (p + j <= max_value) {
					isPrime[p + j] = false;
					factors[p + j]++;
					j += p;
				}
			}
		}

		for (int i = 2; i <= max_value; i++) {
			for (int j = 1; j <= 5; j++) {
				dp[j][i] = dp[j][i - 1];
			}
			int factor_count = factors[i];
			if (factor_count >= 1 && factor_count <= 5) {
				dp[factor_count][i]++;
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String params[] = br.readLine().split(" ");
			int A = Integer.parseInt(params[0]);
			int B = Integer.parseInt(params[1]);
			int K = Integer.parseInt(params[2]);

			System.out.println(dp[K][B] - dp[K][A - 1]);
		}
	}
}
