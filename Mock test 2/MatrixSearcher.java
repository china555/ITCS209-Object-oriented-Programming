
public class MatrixSearcher {
	
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1, 4, 4, 7, 8, 10, 10, 10, 11, 11},
						{12, 13, 14, 15, 15, 17, 17, 18, 18, 18},
						{18, 22, 23, 23, 24, 24, 24, 25, 27, 28},
						{28, 28, 29, 29, 29, 30, 31, 31, 32, 32},
						{32, 33, 33, 35, 36, 37, 38, 39, 39, 42},
						{42, 43, 43, 43, 44, 45, 49, 52, 52, 54},
						{54, 55, 55, 56, 58, 60, 60, 61, 62, 62},
						{64, 67, 68, 68, 70, 71, 72, 72, 73, 75},
						{76, 77, 78, 81, 81, 84, 84, 85, 86, 86},
						{86, 87, 90, 90, 91, 95, 96, 97, 97, 98}};
		
		
		System.out.println("Contains 55?:"+binaryFind(matrix, 55));
		System.out.println("Contains 1?:"+binaryFind(matrix, 1));
		System.out.println("Contains -1?:"+binaryFind(matrix, -1));
		System.out.println("Contains 98?:"+binaryFind(matrix, 98));
		System.out.println("Contains 100?:"+binaryFind(matrix, 100));
	}
	public static boolean binaryFind(int[][] matrix, int target ) {
		int temp[] = new int[100];
		int count =0;
		for(int i =0;i<10;i++) {
			for(int j=0;j<10;j++) {
				temp[count] = matrix[i][j];
				count++;
			}
		}
		int start = 0;
		int end = temp.length-1;
		if(help(start, end, target, temp)) {
			return true;
		}
		
		return false;
	}
	public static boolean help(int start,int end,int target,int temp[]) {
		if(start > end) {
			return false;
		}
		int mid = start+(end-start)/2;
		if(temp[mid]==target) {
			return true;
		}
		
		if(target > temp[mid]) {
			start = mid+1;
			
			return help(start, end, target, temp);
		}
		
		else {
			end = mid-1;
			
			return help(start, end, target, temp);
		}
		
	}
	
}
