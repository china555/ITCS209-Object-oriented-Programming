import java.util.Arrays;

//Name:Kittikorn Keeratikriengkrai
//ID:6188086
//Section: 1


public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	public double Sum;
	public double Avg;
	public double min;
	public double max;					// all attributes that used to created object or used in many method
	public double std;
	public static double[] data;
	public static int length =0;
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
			data = new double[1000];
			length = 0;
			this.Sum = 0;							//set any attribute = 0 for new object
			this.Avg =0;							
			this.max =0;
			this.std = 0;
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
			data[length] = number;				//recieve data from class KalculatorStudentTester by pass parameter.
			length++;							// length = length +1 to count all of data that have passed to this class.						
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		for(int i=0;i<length-1;i++) {
			data[i] = data[i+1];		//this part will remove firstnumber of array
		}								//first thing you will set condition length(array size) - 1 because this array will remove 1 index 
		data[length] =0;				//and get this data = next data
		length--;
		//**************************************
	}

	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		data[length] =0; // delete data in  last index of array. 
		length--;			
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		for(int i=0;i<=length;i++) {
		 this.Sum = this.Sum + data[i];
		}
		return this.Sum;
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(length <= 0) {
			return 0;
		}
		for(int i=0;i<=length;i++) {
			 this.Avg = this.Sum/length;
			}
			return this.Avg;
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		double sum=0;
		for(int i =0;i<length;i++) {
			sum = sum + Math.pow((data[i] - this.Avg),2);
		}
		if(length == 1||length == 0) {
			return this.std =0;
		}
		else {
		return this.std = Math.sqrt(sum/(length-1));
		}
	
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		this.max =0;
		if(length==0){
		return 0;
		}
		else {
			for(int i=0;i<length;i++) {
				if(this.max<data[i]) {
					this.max = data[i];
				}
			}
			return this.max;
		}
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		this.min = data[0];
		if(length==0){
			return 0;
			}
			else {
				for(int i=0;i<length;i++) {
					if(this.min>data[i]) {
						this.min = data[i];
					}
				}
				return min;
			}
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		double[] a= new double[k];
		double temp;
		double[] ex = Arrays.copyOf(data, length);
		if(length <= 1) {
			return null;
		}
		else {
		for(int i = 0;i<length-1;i++) {				//bubble sort
			for(int j=0;j<length-i-1;j++) {
				if(ex[j]<ex[j+1]) {
					temp = ex[j];
					ex[j] = ex[j+1];
					ex[j+1] = temp;
				}
			}
		}
		for(int i =0;i<k;i++) {
			a[i] = ex[i];
		}
		return a;
		}
		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		double arraytemp[] = new double[k];
		double temp =0;
		double[] ex = Arrays.copyOf(data, length);
		if(length <= 1) {
			return null;
		}
		else {
		for(int i=0;i<length-1;i++) {
			for(int j=0;j<length-i-1;j++) {
				if(ex[j]>ex[j+1]) {
					temp = ex[j];                 // bubble sort
					ex[j] = ex[j+1];
					ex[j+1] = temp;
				}
			}
		}
		for(int i=0;i<k;i++) {
			arraytemp[i] = ex[i];
		}
		return arraytemp;
		}
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		if(length < 0) {
			length =0;
		}
		System.out.print("DATA["+length+"] : [");
		for(int i=0;i<length;i++) {
			if(i==length-1) {
				System.out.print(data[i]);
			}
			else {
			System.out.print(data[i]+", ");
			}
		}
		System.out.println("]");
		//**************************************
	}
}
