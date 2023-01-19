import java.util.*;

public class Quicksortarray
{
	public static void main( String args[])
	{
		//int[] n = {100, 1000, 2000, 4000, 8000, 16000, 32000, 64000};
		//int[] n = {100, 200, 300, 400, 500, 600,700,800,900,1000};
		int[] n = {1000, 2000, 3000, 4000, 5000, 6000,7000,8000,9000,10000};

		int[] x = {65, 37, 74, 24, 6, 28, 63, 75};

		Arprint(x);
		sort(x);
		Arprint(x);

		Random rng = new Random();

		int max = 1000;

	}

	public static void sort(int[] array)
	{
		if (array.length == 0)
			return;
		sort(array, 0, array.length - 1);
	}

	public static int[] sort( int[] array, int i, int j)
	{
		if(i < j)
		{
			int pivot = partition( array, i, j);

			sort(array, i, pivot - 1);
			sort(array, pivot + 1, j);
		}

		return array;
	}

	public static int partition( int[] array, int i, int j)
	{

		int temp = 0;
		int pivot = i;

		while( i <= j )
		{
			if(array[i] > array[j])
			{
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}

			if(array[i] <= array[pivot])
				i++;
			if(array[j] > array[pivot])
				j--;

		}

		temp = array[pivot];
		array[pivot] = array[j];
		array[j] = temp;

		/*********************

  	  int temp  = 0;
  	  int k = i+1;

  	  for(int r = i + 1; r < j ;r++)
  	  {
  	      //swap values if a[j]<=a[r](i.e. pivot)
  	      if(array[r]<=array[i])
  	      {
  	          temp=array[r];
  	          array[r]=array[k];
  	          array[k]=temp;
  	          k++;
  	      }
  	  }

  	  //place pivot at its position by swapping
  	  temp=array[k-1];
  	  array[k-1]=array[i];
  	  array[i]=temp;
  	  **/
  	  return j;

		//return pivot;
	}

	public static void Arprint( int[] array )
	{
		System.out.print("[ ");
		for(int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.println( array[array.length - 1] + " ]");
	}
}
