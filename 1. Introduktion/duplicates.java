import java.util.Random;

class duplicates
{
	public static void main(String args[])
	{
			int[] n = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
			int k = 1000; //10000

			double time = access(n[0],k);

			for(int i = 0; i < n.length; i++)
			{
				time = access(n[i],k);
				System.out.println(n[i] + ":\t" + time/1000 + " us");
			}
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

	private static double access(int n, int k)
	{
		int[] keys = new int[n];
		int[] array = new int[n];

		Random rnd = new Random();
		int sum = 0;

		double t_total = 0;

		for(int j = 0; j < k; j++)
		{
			// fill the keys array with random number from 0 to 10*n
			//for(int i = 0; i < n; i++)
			//	keys[i] = rnd.nextInt(10*n);

			// fill the array with with random number from 0 to 10*n
			//for(int i = 0; i < n; i++)
			//	array[i] = rnd.nextInt(10*n);

			keys = sorted(10*n);
			array = sorted(10*n);

			long t0 = System.nanoTime();
			for(int ki = 0; ki < n; ki++)
			{
				for(int i = 0; i < n; i++)
				{
					if(keys[ki] == array[i])
					{
						sum++;
						break;
					}
				}
			}
			t_total += (System.nanoTime() - t0);
		}
		//return (double)t_total/((double)k*(double)n*(double)n);
		return t_total / k;
	}
}