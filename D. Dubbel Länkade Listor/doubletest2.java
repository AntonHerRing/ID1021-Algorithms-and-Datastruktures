import java.util.*;

public class doubletest2
{
	public static void main(String args[])
	{
		DoubleLinkedList Afirst;

		Random rng = new Random();

		long t01 = 0;
		double t_total1 = 0;

		long t02 = 0;
		double t_total2 = 0;

		int[] n = {10, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600};
		int k = 10000;



		for(int loop = 0; loop < n.length; loop++)
		{
			DoubleLinkedList[] nodes = new DoubleLinkedList[n[loop]];

			DoubleLinkedList Alist = new DoubleLinkedList();
			Afirst = Alist;

			int[] sequence = new int[n[loop]];
			for (int i = 0; i < n[loop]; i++)
				sequence[i] = rng.nextInt(n[loop]*10);


			for(int i = 0; i < n[loop]; i++)	//add to list
			{
				DoubleLinkedList add = new DoubleLinkedList(sequence[i]);
				Afirst.append(add);
				nodes[i] = add;			//adds list node to array
			}

			for(int i = 0; i < k; i++)
			{
				int index = rng.nextInt(nodes.length);
				DoubleLinkedList remove = nodes[index];

				t02 = System.nanoTime();
				Afirst.detach(remove);		//detach random number from sequence;
				t_total2 += System.nanoTime() - t02;

				t01 = System.nanoTime();
				Afirst.append(remove);		//add back removed element
				t_total1 += System.nanoTime() - t01;
			}
			System.out.println("Double: " + n[loop] + ". \tAdding: " + t_total1/k + " ns\t  " + "   Removing: " + t_total2/k + " ns");

			t_total1 = 0;
			t_total2 = 0;

			LinkedList Bfirst;

			t01 = 0;
			t_total1 = 0;

			t02 = 0;
			t_total2 = 0;

			LinkedList[] Snodes = new LinkedList[n[loop]];

			LinkedList Blist = new LinkedList();
			Bfirst = Blist;
			for(int i = 0; i < n[loop]; i++)
			{
				LinkedList add = new LinkedList(sequence[i]);
				Bfirst.append(add);
				Snodes[i] = add;
			}

			for(int i = 0; i < k; i++)
			{
				int index = rng.nextInt(Snodes.length);
				LinkedList remove = Snodes[index];				//System.out.println(remove);

				t02 = System.nanoTime();
				Bfirst.detach(remove);	//detach random number from sequence;
				t_total2 += System.nanoTime() - t02;

				t01 = System.nanoTime();
				Bfirst.append(remove);		//add back removed element
				t_total1 += System.nanoTime() - t01;

			}
			System.out.println("Single: " + n[loop] + ". \tAdding: " + t_total1/k + " ns\t  " + "   Removing: " + t_total2/k + " ns");

			t_total1 = 0;
			t_total2 = 0;
		}
	}
}