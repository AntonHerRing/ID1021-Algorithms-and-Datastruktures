import java.util.Random;

class Arrays
{
	public static void main(String[] args)
	{
		int n = 100;

		double test = access(n);

		double time = access(n);

		System.out.println("time: " + time + " ns");
	}

	private static double access(int n)
	{
		int k = 1_000_000;
		int l = n;

		Random rnd = new Random();

		int[] indx = new int[l];
		// fill the indx array with random number from 0 to n (not including n)
		for(int i = 0; i < l; i++)
			indx[i] = rnd.nextInt(n);

		int[] array = new int[n];
		// fill the array with dummy values (why not 1)
		for(int i = 0; i < n; i++)
			array[i] = 1;

		int sum = 0;
		long t0 = System.nanoTime();
		for (int j = 0; j < k; j++)
		{
			for (int i = 0; i < l; i++)
			{
				// access the array with the index given by indx[i]
				// sum up the result
				sum += indx[i];
			}
		}
		long t_access = (System.nanoTime() - t0);

		t0 = System.nanoTime();
		// do the same loop iteration but only do a dummy add operation
		int dummySum = 0;
		for (int j = 0; j < k; j++)
		{
			for (int i = 0; i < l; i++)
			{
				//dummySum += array[i];
				dummySum += 1;
			}
		}
		long t_dummy = (System.nanoTime() - t0);

		return ((double)(t_access - t_dummy))/((double)k*(double)l);
	}
}