import java.util.*;

public class linkedtest2
{
	public static void main( String args[] )
	{
		Random rng = new Random();

		long t0 = 0;
		double t_total = 0;

		LinkedList Afirst;
		LinkedList Bfirst;

		double prev = 0;

		int[] n = {1, 10, 20, 40, 80, 160, 320, 640, 1280, 2560};

		/*for(int loop = 0; loop < n.length; loop++)
		{
			prev = t_total/1000;
			t_total = 0;
			for(int k = 0; k < 1000; k++)
			{
				t0 = System.nanoTime();
				Aarray = new int[n[loop]];
				for(int i = 0; i < n[loop]; i++)
					Aarray[i] = rng.nextInt(100);
				t_total += System.nanoTime() - t0;
			}

			System.out.println("NOE: " + (n[loop]) + "    \tTime:\t " + (t_total/1000) + " ns" + "\tcost: " + (t_total/1000 - prev) + "ns");
		}*/

		for(int loop = 0; loop < n.length; loop++)
		{
			prev = t_total/1000;
			t_total = 0;
			for(int k = 0; k < 1000; k++)
			{
				t0 = System.nanoTime();
				LinkedList a = new LinkedList();
				Afirst = a;		//remember iniztial position
				for(int i = 1; i <= n[loop]; i++)
				{
					LinkedList Aset = new LinkedList(rng.nextInt(100));
					a.append(Aset);
					a = a.next;
				}
				t_total += System.nanoTime() - t0;

				a = Afirst;
			}
			System.out.println("NOE: " + (n[loop]) + "    \tTime:\t " + (t_total/1000) + " ns" + "\tcost: " + (t_total/1000 - prev) + "ns");
		}
	}

	public static int[] array_append( int[] array1, int[] array2)
	{
		int length = array1.length + array2.length;

		int[] both = new int[length];

		int i;
		for(i = 0; i < array1.length; i++)
			both[i] = array1[i];
		for(int h = i + 1; h < length; h++)
			both[h] = array1[h - i];

		return both;
	}
}