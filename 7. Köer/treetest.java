import java.util.*;

public class treetest
{
	public static void main( String args[] )
	{
		BinaryTree tree = new BinaryTree(10, 10); //key: 10 	value: 11

	/*	tree.add(7, 7);
		tree.add(9, 9);
		tree.add(5, 5);
		tree.add(15, 15);
		tree.add(19, 19);
		tree.add(14, 14);

		tree.add(4, 4);
		tree.add(6, 6);
		tree.add(8, 8);
		tree.add(13, 13);
		tree.add(16, 16);
		tree.add(20, 20);*/

		tree.add(5,5);
		tree.add(15,15);
		tree.add(3,3);
		tree.add(7,7);
		tree.add(12,12);
		tree.add(20,20);

		System.out.print("[");
		for (int i : tree)
			System.out.print( i + ", ");
		System.out.println(" ]");

		/*tree.add(31, 31);
		tree.add(2, 2);

		System.out.print("[");
		for (int i : tree)
			System.out.print( i + ", ");
		System.out.println(" ]");

		//tree.root.print();*/

		/*Random rng = new Random();

		int[] n = {50 ,100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600};

		long t0 = 0;
		double t_total = 0;

		int max = 10000;

		for(int loop = 0; loop < n.length; loop++)
		{
			for(int k = 0; k < max; k++)
			{
				Integer[] keys = new Integer[n[loop]];
				for(int i = 0; i < n[loop]; i++)
					keys[i] = rng.nextInt(n[loop]*10);
				BinaryTree tree = new BinaryTree(keys[0], keys[0]);

				//System.out.println("root: " + keys[0] );

				/*System.out.print("[ ");
				for(int i = 1; i < n[loop] - 1; i++)
					System.out.print( keys[i] + ", " );
				System.out.println(keys[n[loop] - 1] + " ]");

				for(int i = 1; i < n[loop]; i++)
				{
					tree.add(keys[i], keys[i]);
				}
				Integer in = keys[rng.nextInt(n[loop] - 1)];

				t0 = System.nanoTime();
				int x = tree.lookup(in);
				t_total += System.nanoTime() - t0;

				//System.out.println("find key: " + in );
				//System.out.println(tree.printTo(in));
			}
			System.out.println(n[loop] +": " + t_total/max + " ns");

			t0 = 0;
			t_total = 0;
		}*/
	}
}
