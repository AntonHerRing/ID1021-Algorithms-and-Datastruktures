import java.util.*;

public class sorted
{
	public static void main( String args[] )
	{
		Scanner in = new Scanner(System.in);
		Random rng = new Random();

		System.out.println("choose algorithm: \n 1. unsorted  \t 2. sorted \t 3. binary");
		int choice = in.nextInt();

		//int[] array = new int[n];

		/*System.out.print("[ ");
		for(int i = 0; i < n; i++)
		{
			System.out.print(array[i]);
			System.out.print(" , ");
		}
		System.out.println(" ...] ");*/

		//int[] n = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000,65536000};
		int[] n = {50 ,100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600};

		int[] array = sorted(n[0]);
		int key = rng.nextInt(n[0]);

		long t0 = 0;
		double total = 0;
		boolean ft;
		double min = 0;

		t0 = System.nanoTime();
		ft = search_unsorted(array, key);
		min = Double.POSITIVE_INFINITY;

		for(int i = 0; i < n.length; i++)
		{
			array = sorted(n[i]);
			key = rng.nextInt(n[i]);
			switch(choice)
			{
				case 1:
				for(int k = 0; k < n[i]; k++)
					array[k] = rng.nextInt(n[i]);

				for(int k = 0; k < 100000; k++)
				{
					t0 = System.nanoTime();
					ft = search_unsorted(array, key);
					total += (System.nanoTime() - t0);
				}
				break;

				case 2:
				for(int k = 0; k < 100000; k++)
				{
					t0 = System.nanoTime();
					ft = search_sorted(array, key);
					total += (System.nanoTime() - t0);
				}
				break;

				case 3:
				for(int k = 0; k < 100000; k++)
				{
					t0 = System.nanoTime();
					ft = binary_search(array, key);
					total += (System.nanoTime() - t0);
				}
			}
			System.out.println(n[i] + ":\t" + total/100000 + " ns");
		}
		//System.out.println(binary_search(array, key) ? "yes" : "No" );

	}

	public static boolean search_unsorted(int[] array, int key)
	{
		for (int index = 0; index < array.length ; index++)
		{
			if (array[index] == key)
			{
				return true;
			}
		}
		return false;
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

	public static boolean search_sorted(int[] array, int key)
	{
		for (int index = 0; index < array.length ; index++)
		{
			if (array[index] > key)
				break;

			if (array[index] == key)
			{
				return true;
			}
		}
		return false;
	}

	public static boolean binary_search(int[] array, int key)
	{
		int first = 0;
		int last = array.length - 1;

		while(true)
		{
			//show array
		/*for(int i = first; i <= last; i++)
		{
			System.out.print(array[i]);
			System.out.print("( " + i);
			System.out.print(" ), ");
		}
		System.out.println(" ...] ");*/


			//jump to middle
			int index = ( first + last ) / 2;

			if((last - first) == 1) 	//if last two elements, break
				break;

			if(array[index] == key)	//return true
			{
				return true;
			}

			if (array[index] < key && index < last)		//key bigger then index, go bigger
			{
				first = index + 1;
				continue;
			}

			if (array[index] > key && index > first)	//key smaller then index, go smaller
			{
				last = index - 1 ;
				continue;
			}
			break;
		}
		return false;
	}
}