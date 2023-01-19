import java.util.Random;

class search
{
	public static void main(String args[])
	{
		int n = 100000;
		int m = 5;
		int k = 10000;


		double min = access(n,m,k);
		double max = access(n,m,k);

		double median = 0;

		double time = 0;

		/*for(int i = 0; i < 1000; i++)
		{
			time = access(n,m,k);

			/*if(time < min)
				min = time;
			else if(time > max)
				max = time;

			median += (min+max)/2;
		}
		System.out.println("min time: " + min/1000 + " us" + "\nmax time: " + max/1000 + " us" + "\nmed time: " + median/1000/1000 + " us");
		*/
		System.out.println("time: " + min + " ns");
	}

	private static double access(int n, int m, int k)
	{
		int[] keys = new int[m];
		int[] array = new int[n];

		Random rnd = new Random();
		int sum = 0;

		double t_total = 0;

		for (int j = 0; j < k; j++)
		{
			// fill the keys array with random number from 0 to 10*n
			for(int i = 0; i < m; i++)
				keys[i] = rnd.nextInt(10*n);

			// fill the array with with random number from 0 to 10*n
			for(int i = 0; i < n; i++)
				array[i] = rnd.nextInt(10*n);

			long t0 = System.nanoTime();
			for (int ki = 0; ki < m; ki++)
			{
				int key = keys[ki];
				for (int i = 0; i < n ; i++)
				{
					if (array[i] == key)
					{
						sum++;
						break;
					}
				}
			}
			t_total += (System.nanoTime() - t0);
		}
		return (double)t_total/((double)k*(double)n*(double)m);
	}
}