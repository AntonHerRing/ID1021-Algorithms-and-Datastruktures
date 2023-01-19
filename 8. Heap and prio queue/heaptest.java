import java.util.*;

public class heaptest
{
	public static void main(String args[])
	{
		/*heap hp = new heap(5);

		hp.add(4);
		hp.add(3);
		hp.add(1);
		hp.add(10);
		hp.add(9);
		hp.add(2);

		System.out.print("[");
		for (int i : hp)
			System.out.print( i + ", ");
		System.out.println(" ]");

		hp.remove();
		hp.remove();
		hp.push(20);
				System.out.print("[");
				for (int i : hp)
					System.out.print( i + ", ");
		System.out.println(" ]");

		hp.push(12);
				System.out.print("[");
				for (int i : hp)
					System.out.print( i + ", ");
		System.out.println(" ]");

		hp.push(10);
				System.out.print("[");
				for (int i : hp)
					System.out.print( i + ", ");
		System.out.println(" ]");

		hp.push(10);
		hp.push(11);
		hp.push(18);
		hp.remove();

		System.out.print("[");
		for (int i : hp)
			System.out.print( i + ", ");
		System.out.println(" ]");/*

		/*System.out.println(hp);
		hp.add(4);
		System.out.println(hp);
		hp.add(3);
		System.out.println(hp);
		hp.add(1);
		System.out.println(hp);
		hp.add(10);
		System.out.println(hp);
		hp.add(9);
		System.out.println(hp);
		hp.add(2);

		System.out.println(hp);

		int k = hp.remove();
		System.out.println(hp);

		k = hp.remove();
		System.out.println(hp);

		k = hp.remove();
		System.out.println(hp);

		k = hp.remove();
		System.out.println(hp);*/

		int n = 64;
		int max = 20;

		Random rng = new Random();

		int data = rng.nextInt(100) + 1;
		heap hp = new heap(data);

		int[] adddepth = new int[n];

		for(int i = 1; i < n; i++)
		{
			data = rng.nextInt(100) + 1;
			adddepth[i] = hp.add(data);
		}

		System.out.print("[");
		for (int i : hp)
			System.out.print( i + ", ");
		System.out.println(" ]");

		System.out.print("[ ");
		for(int i = 0; i < n - 1; i++)
		{
			System.out.print(adddepth[i] + ", ");
		}
		System.out.println(adddepth[n - 1] + " ]");

		int[] depth = new int[max];


		for(int i = 0; i < max; i++)
		{
			int push = rng.nextInt(10) + 11;
			depth[i] = hp.push(push);
		}


		System.out.print("[ ");
		for(int i = 0; i < max - 1; i++)
		{
			System.out.print(depth[i] + ", ");
		}
		System.out.print(depth[max - 1] + " ]");
	}
}