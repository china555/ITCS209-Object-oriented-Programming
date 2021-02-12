//Name:Chulajak Watanyoo
//ID:6188044
//Section:1


public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	//**************************************
	public double[] chun;
	public double[] eiei;
	public double[] zumo;
	public static int kk;
	/**
	 * 
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		chun = new double[10000];
		kk =0;
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
	  chun[kk]=number;
	  kk++;
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(kk==0)
		{
			
		}
		else 
		{
			for(int oo=0;oo<kk;oo++)
			{
				chun[kk]=chun[kk+1];
				
			}
			kk=kk-1;
		}
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(kk==0)
		{
			
		}
		else 
		{
			
			kk=kk-1;
		}
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
		double sum=0;
		
		if(kk==0)
		{
			return 0;
		}
		else 
		{
		for(int i=0;i<=kk;i++)
		{
		 sum=chun[i]+sum;
		
		}
		return sum;
		//**************************************
	        }
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		double average=0;
		if(kk==0)
		{
			return 0;
		}
		else
		{	
		 average=getSum()/kk;	
		}
		
		return average;
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
		double std=0;
		if(kk<2)
		{
			return 0;
		}
		else
		{
		for(int i=0;i<kk;i++)
		{
			std=std+Math.pow(chun[i]-getAvg(),2);
			
		}
		
		std=Math.sqrt(std/(kk-1));
		return std;
		//**************************************
	}
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		double max=chun[0];
		if(kk==0)
		{
			return 0;
		}
		for(int i=0;i<kk;i++)
		{
			if(max<chun[i])
			{
				max=chun[i];
				
			}
		}
		return max;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		double min=chun[0];
		if(kk==0)
		{
			return 0;
		}
		for(int i=kk;i>kk;i--)
		{
			if(min>chun[i])
			{
				min=chun[i];
				
			}
		}
		return min;
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
		double temp=0;
		eiei = new double[k];
		double[] temparr = chun.clone();
		if(kk<k)
		{
			return null;
		}
		for(int i=0;i<kk-1;i++)
		{
			for(int j=0;j<kk-1;j++)
			{
				if(temparr[j]>temparr[j+1])
				{
					temp=temparr[j+1];
					temparr[j+1]=temparr[j];
					temparr[j]=temp;
				}
			}
			
		}
		for(int i=0;i<k;i++)
		{
			eiei[i]=temparr[(kk)-(i+1)];
		}
		return eiei;
	}
		//**************************************
	
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
			zumo = new double[k];
			double[] temparr = chun.clone();
				double temp=0;
				if(kk<k)
				{
					return null;
				}
				for(int i=0;i<kk-1;i++)
				{
					for(int j=0;j<kk-1;j++)
					{
						if(temparr[j]>temparr[j+1])
						{
							temp=temparr[j];
							temparr[j]=chun[j+1];
							temparr[j+1]=temp;
						}
					}
					
				}
				for(int i=0;i<k;i++)
				{
					zumo[i]=temparr[i];
				}
				return zumo;
		
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
        //**INSERT YOUR CODE HERE***
		System.out.print("Data[" +kk +"] : "  );
        System.out.print("[");
        for(int i = 0 ; i < kk; i++) {
            if(i == kk - 1) {
                System.out.print(chun[i]);
            }else {
                System.out.print(chun[i] + ", " );
            }
        }
        System.out.print("]");
        System.out.println();
      }
}
    
