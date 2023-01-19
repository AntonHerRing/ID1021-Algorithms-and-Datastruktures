import java.util.*;

class duplicates2
{
	public static void main(String args[])
	{
		Scanner in = new Scanner( System.in );

		int[] n = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
		int k = 10000; //10000

		System.out.println("choose method: \n 1. binary \t 2. Special");
		int choice = in.nextInt();

		double time = access(n[0],k);
		time = binary_access(n[0],k);
		//double time = binary_access(n,k);

		for(int i = 0; i < n.length; i++)
		{
			switch(choice)
			{
				case 1:
					time = access(n[i],k);
					System.out.println(n[i] + ":\t" + time/1000 + " us");
				break;

				case 2:
					time = binary_access(n[i],k);
					System.out.println(n[i] + ":\t" + time + " ns");
				break;
			}
		}
	}

	private static double access(int n, int k)
	{
		int[] keys = new int[n];
		int[] array = new int[n];

		Random rnd = new Random();
		int sum = 0;

		double t_total = 0;
		boolean tf = false;

		for(int j = 0; j < k; j++)
		{
			keys = sorted(10*n);
			array = sorted(10*n);

			long t0 = System.nanoTime();
			for(int ki = 0; ki < n; ki++)
			{
				tf = binary_search(array, keys[ki]);
			}
			t_total += (System.nanoTime() - t0);
		}
		return t_total / k;
	}

	private static int[] sorted(int n)
	{
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = 0;
		for (int i = 0; i < n ; i++)
		{
			nxt += rnd.nextInt(10) + 1;
			array[i] = nxt;
		}
		return array;
	}

	public static boolean binary_search(int[] array, int key)
	{
		int first = 0;
		int last = array.length - 1;

		while(true)
		{
			int index = ( first + last ) / 2;

			if((last - first) == 1) 	//if last two elements, break
				break;

			if(array[index] == key)	//return true
			{
				return true;
			}

			if (array[index] < key && index < last)		//key bigger then index, go bigger
			{
				first = index;
				continue;
			}

			if (array[index] > key && index > first)	//key smaller then index, go smaller
			{
				last = index ;
				continue;
			}
			break;
		}
		return false;
	}

	private static double binary_access(int n, int k)
	{
		int[] keys = new int[n];	//first
		int[] array = new int[n];	//second

		Random rnd = new Random();
		int sum = 0;

		double t_total = 0;
		boolean tf = false;

		for(int j = 0; j < k; j++)
		{
			keys = sorted(10*n); //first
			array = sorted(10*n);//second


			int index = 0;
			int ki = 0;
			long t0 = System.nanoTime();
			while(true)
			{
				if(array[index + 1] == keys[ki + 1])
				{
					tf = true;
					break;
				}
				if(array[index + 1] < keys[ki + 1])
				{
					index++;
					continue;
				}
				if(array[index + 1] > keys[ki + 1])
				{
					ki++;
					continue;
				}
				break;
			}
			t_total += (System.nanoTime() - t0);
		}
		return t_total / k;
	}
}
