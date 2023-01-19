import java.util.*;

class BenchSort
{
	public static void main( String args[] )
	{
		Random rng = new Random();
		Scanner in = new Scanner(System.in);

		//int[] n = {10, 100, 200, 400, 800, 1000, 2000};
		int[] n = {100, 200, 300, 400, 500, 600,700,800,900,1000};
		//int[] n = {10, 20, 30, 40, 50, 60,70,80,90,100};
		//int[] n = {200,400,600,800,1000,1200,1400,1600,1800,2000,2200};
		//int[] n = {100, 1000, 2000, 4000, 8000, 16000, 32000, 64000};

		int[] x = {65, 37, 74, 24, 6, 28, 63, 75};

		selection_sort( x );

		//show unsorted array
		/*System.out.print("[ ");
		for(int i = 0; i < x.length - 1; i++)
		{
			System.out.print(x[i] + ", ");
		}
		System.out.println(x[x.length - 1] + " ] ");*/

		int[] array = new int[n[0]];

		for(int i = 0; i < array.length; i++)
		{
			array[i] = rng.nextInt(n[1] * 10);
		}

		System.out.println("");
		System.out.println("Choose Algorithm:\n 1. Selection Sort\t 2. Insertion Sort\t 3. Merge Sort");
		System.out.println("");

		int choose = in.nextInt();

		long t0 = 0;
		double total = 0;

		//t0 = System.nanoTime();
		int limit = 1000;
		int test = 0;

		//selection_sort( array );

		for(int h = 0; h < n.length; h++)
		{
			for(int k = 0; k < limit; k++)
			{
				array = new int[n[h]];
				for(int i = 0; i < array.length; i++)
				{
					array[i] = rng.nextInt(n[h] * 10);
				}

				switch(choose)
				{
					case 1:
					t0 = System.nanoTime();
					selection_sort( array );
					total += (System.nanoTime() - t0);
					break;

					case 2:
					t0 = System.nanoTime();
					insertion_sort( array );
					total += (System.nanoTime() - t0);
					break;

					case 3:
					t0 = System.nanoTime();
					sort( array );
					total += (System.nanoTime() - t0);
					break;

					case 4:
					t0 = System.nanoTime();
					insertion_sort2( array );
					total += (System.nanoTime() - t0);
					break;
				}
			}
			System.out.println( n[h] +". Time:\t " + total/limit/1000 + " us");
			total = 0;
		}
		/*
		int[] org = {1, 4, 10, 45, 50, 2, 5, 26, 40, 49};
		int[] aux = new int[org.length];
		int lo = 0;
		int hi = org.length - 1;
		int mid = (lo + hi)/2;

		//merge(org, aux, lo, mid, hi);
		sort(array);*/

		//show sorted array
		/*array = new int[100];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = rng.nextInt(100 * 10);
		}
		sort(array);*/

		/*System.out.print("[ ");
		for(int i = 0; i < array.length - 1; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1] + " ] ");

		//System.out.println("Time: " + total/limit/1000 + " us");*/

	}

	public static int[] selection_sort( int[] array )
	{
		int temp = 0;
		for(int i = 0; i < array.length - 1; i++)
		{

			int first = i;

			for(int j = i; j < array.length; j ++)
			{
				if(array[first] > array[j])
					first = j;
			}
			temp = array[first];
			array[first] = array[i];
			array[i] = temp;
		}
		return array;
	}

	public static int[] insertion_sort( int[] array )
	{
		int index = 1;
		int temp = 0;

		for(int i = 0; i < array.length; i++)
		{
			index = i + 1;

			for(int j = i; j >= 0 && index < array.length; j--)
			{
				if(array[index - 1] > array[index])
				{
					temp = array[index - 1];
					array[index - 1] = array[index];
					array[index] = temp;

					index--;
				}
				else
					break;

			}
		}
		return array;
	}

	public static int[] insertion_sort2( int[] array )
	{
		int temp = 0;
		int j = 0;

		for(int i = 1; i < array.length; i++)
		{
			temp = array[i];

			for(j = i - 1; j >= 0 && temp <= array[j]; j--)
				array[j + 1] = array[j];
			array[j + 1] = temp;
		}
		return array;
	}

	private static void merge(int[] org, int[] aux, int lo, int mid, int hi)
	{
		// copy all items from lo to hi from org to aux
		for ( int c = lo; c <= hi; c++ )
			aux[c] = org[c];

		// let's do the merging

		int i = lo; 	// the index in the first part
		int j = mid + 1; 	// the index in the second part

		// for all indeces from lo to hi
		for ( int k = lo; k <= hi; k++)
		{
			// if i is greater than mid, move the j item to the org array, update j
			// else if j is greate than hi, move the i item to the org array, update i
			// else if the i item is smaller than the j item,
			// move it to the org array, update i
			// else you can move the j item to the org array, update j
			if(i > mid)
				org[k] = aux[j++];
			else if(j > hi)
				org[k] = aux[i++];
			else if(aux[i] < aux[j])
				org[k] = aux[i++];
			else
				org[k] = aux[j++];
		}
	}

	public static void sort(int[] org)
	{
		if (org.length == 0)
			return;
		int[] aux = new int[org.length];
		sort(org, aux, 0, org.length - 1);
	}

	private static void sort(int[] org, int[] aux, int lo, int hi)
	{
		if (lo != hi)
		{
			int mid = (hi + lo)/2;
			// sort the items from lo to mid
			sort(org, aux, lo, mid);
			// sort the items from mid+1 to hi
			sort(org, aux, mid + 1, hi);
			// merge the two sections using the additional array
			merge(org, aux, lo, mid, hi);
		}
	}

	public static void Arprint( int[] array )
	{
		System.out.print("[ ");
		for(int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.println( array[array.length - 1] + " ]");
	}
}