import java.util.*;

public class linkedtest
{
	public static void main( String args[] )
	{
		Random rng = new Random();

		long t0 = 0;
		double t_total = 0;

		LinkedList Afirst;
		LinkedList Bfirst;

		double prev = 0;

		int max = 2000000;

		int n[] = {1, 0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220};

		for(int loop = 0; loop < n.length; loop++)
		{
			prev = t_total/max;
			t_total = 0;
			for(int k = 0; k < max; k++)
			{
				int[] Aarray = new int[20 + n[loop]];
				int[] Barray = new int[10];

				for(int i = 0; i < 20 + n[loop]; i++)
					Aarray[i] = rng.nextInt(100);

				for(int i = 0; i < 10; i++)
					Barray[i] = rng.nextInt(100);

				t0 = System.nanoTime();
				int[] Both = array_append(Aarray, Barray);
				t_total += System.nanoTime() - t0;
			}

			System.out.println("number of elements: " + (10 + 20 + n[loop]) + "\t Time:\t " + (t_total/max) + " ns" + "\tcost: " + (t_total/max - prev) + "ns");
		}

		/*System.out.print("[ ");
		for(int i = 0; i < Both.length - 1; i++)
			System.out.print(Both[i] + ",");
		System.out.println(Both[Both.length - 1] + " ]");*/
		/*int max = 10000;

		for(int loop = 0; loop < 230; loop += 20)
		{
			prev = t_total/max;
			t_total = 0;
			for(int k = 0; k < max; k++)
			{
				LinkedList b = new LinkedList();
				Bfirst = b;
				for(int i = 1; i <= 20 + loop; i++)
				{
					LinkedList Bset = new LinkedList(rng.nextInt(100));
					b.append(Bset);
					b = b.next;
				}
				b = Bfirst;

				LinkedList a = new LinkedList();
				Afirst = a;		//remember iniztial position
				for(int i = 1; i <= 10 ; i++)
				{
					LinkedList Aset = new LinkedList(rng.nextInt(100));
					a.append(Aset);
					a = a.next;
				}
				a = Afirst;

				t0 = System.nanoTime();
				a.append(b);
				t_total += System.nanoTime() - t0;


			}

			System.out.println("number of elements: " + (10 + 20 + loop) + "\t Time:\t " + (t_total/max) + " ns" + "\tcost: " + (t_total/max - prev) + "ns");
			//System.out.println("number of elements: " + (10 + 20 + loop) + "\t Time:\t " + (t_total/1000) + " ns");
		}*/
	}

	public static int[] array_append( int[] array1, int[] array2)
	{
		int length = array1.length + array2.length;

		int[] both = new int[length];

		int i;
		for(i = 0; i < array1.length; i++)
			both[i] = array1[i];
		for(int h = i + 1; h < length; h++)
			both[h] = array2[h - i];

		return both;
	}
}