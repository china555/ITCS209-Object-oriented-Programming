
public class Optimal {
	public static void main(String[] args) {
		int all[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		int[] temp = new int[3];
		int[] count = new int[3];
		temp[0] = all[0];
		temp[1] = all[1];
		temp[2] = all[2];
		
		//for(int j=0;j<all.length;j++) {
			for(int i=0;i<3;i++) {
				for(int k =0;k<all.length;k++) {
					if(temp[i]==all[k]) {
						count[i]++;
					}
				}
				System.out.println(count[i]+"//");
			}
			
		//}
	}

}
