import java.util.*;

public class QuicksortBench
{
	public static void main( String args[])
	{
		//int[] n = {100, 1000, 2000, 4000, 8000, 16000, 32000, 64000};
		//int[] n = {100, 200, 300, 400, 500, 600,700,800,900,1000};
		int[] n = {100,1000, 2000, 3000, 4000, 5000, 6000,7000,8000,9000,10000,20000};



		Random rng = new Random();

		int max = 1000;

		long t01 = 0;
		double total1 = 0;

		long t02 = 0;
		double total2 = 0;
		for(int loop = 0; loop < n.length; loop++)
		{
			for(int k = 0; k < max; k++)
			{

				int[] array = new int[n[loop]];

				for(int i = 0; i < array.length; i++)
					array[i] = rng.nextInt(n[loop] * 10);

				Node nod = new Node(array[0]);
				for(int i = 1; i < array.length; i++)
				{
					Node temp = new Node(array[i]);
					nod.add(temp);
				}

				t01 = System.nanoTime();
				Quicksortarray.sort(array);
				total1 += (System.nanoTime() - t01);

				t02 = System.nanoTime();
				QuicksortList2.sort(nod);
				total2 += (System.nanoTime() - t02);
			}
			System.out.println(n[loop] + ". \tTotal array: " + total1/max/1000 + " us");
			System.out.println(n[loop] + ". \tTotal lista: " + total2/max/1000 + " us");
		t01 = 0;
		total1 = 0;
		t02 = 0;
		total2 = 0;
		}
	}
}