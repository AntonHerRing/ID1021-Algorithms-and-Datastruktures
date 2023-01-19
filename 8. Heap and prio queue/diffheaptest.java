import java.util.*;

public class diffheaptest
{
	public static void main( String args[] )
	{

		Random rng = new Random();

		int max = 1000000;

		//int[] n ={10, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 20000, 40000};
		//int[] n ={10, 100, 200, 400, 800, 1600, 3200, 6400, 12800};
		int[] n ={100, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};

		long t01 = 0;
		double t_total1 = 0;

		long t02 = 0;
		double t_total2 = 0;

		long t03 = 0;
		double t_total3 = 0;

		long t04 = 0;
		double t_total4 = 0;

		for(int loop = 0; loop < n.length; loop++)
		{
			t01 = 0;
			t_total1 = 0;

			t03 = 0;
			t_total3 = 0;

			t02 = 0;
			t_total2 = 0;

			t04 = 0;
			t_total4 = 0;


			int data = rng.nextInt(n[loop] * 10) + 1;
			heap hp = new heap(data);
			heapArray Ahp = new heapArray(data, n[loop]);

			for(int i = 1; i < n[loop]; i++)
			{
				data = rng.nextInt(n[loop] * 10) + 1;
				hp.add(data);
				Ahp.add(data);
			}

			for(int k = 0; k < max; k++)
			{
				data = rng.nextInt(n[loop] * 10) + 1;

				t01 = System.nanoTime();
				int a = hp.remove();
				hp.add(data);
				t_total1 += System.nanoTime() - t01;


				t02 = System.nanoTime();
				int b = Ahp.remove();
				Ahp.add(data);
				t_total2 += System.nanoTime() - t02;
			}
			System.out.println(n[loop] + ". \tHeap: " + t_total1/max +"\tHeapArray: " + t_total2/max);
		}
	}
}