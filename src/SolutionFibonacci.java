import java.util.Scanner;

public class SolutionFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input the number: ");
		Scanner sc = new Scanner(System.in);		
		int n = sc.nextInt();
		
		long matrixA[ ][ ]= {{1, 1}, {1, 0}};
		  
		long[][] matrixResult = MatrixPower(n, matrixA);
		
		System.out.println(matrixResult[0][1]);
	}
	
	/*
	 *  calculate the product of two matrix
	 *  @param matrixA(left)
	 *  @param matrixB(right)
	 *  @return multiplication result
	 */
	public static long[][] MatrixMultiply(long[][] matrixA,  long[][] matrixB) {
		long MatrixResult[][]  = new long [2][2];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				MatrixResult[i][j] = 0;
				for (int k = 0; k < 2; k++) {
					MatrixResult[i][j] = MatrixResult[i][j] + matrixA[i][k] * matrixB[k][j];
				}
			}
		}		
		return MatrixResult;
	}
	
	/*
	 * Matrix power operation
	 * Use divide and conquer algorithm to reduce complexity 
	 * @param exponent
	 * @param base matrix
	 * @return result of power operation
	 */
	public static long[][] MatrixPower(long n, long[][] matrixA) {
		long tempMatrix[][]  = new long [2][2];
		
		//  power is 1
		if (n == 1) {
			return matrixA;			
		}
		//  power is even
		else if (n % 2 == 0) {
			tempMatrix = MatrixPower(n / 2, matrixA);
			tempMatrix = MatrixMultiply(tempMatrix, tempMatrix);		
		}
		//  power is odd
		else if (n % 2 == 1) {
			tempMatrix = MatrixPower( (n-1) / 2, matrixA);
			tempMatrix = MatrixMultiply(tempMatrix, tempMatrix);
			tempMatrix = MatrixMultiply(tempMatrix, matrixA);
		}
		return tempMatrix;
	}
}
