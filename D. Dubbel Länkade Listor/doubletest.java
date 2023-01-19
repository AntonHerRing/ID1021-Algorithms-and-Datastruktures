import java.util.*;

public class doubletest
{
	public static void main(String args[])
	{
		DoubleLinkedList list = new DoubleLinkedList(10);
		DoubleLinkedList a = new DoubleLinkedList(11);
		DoubleLinkedList b = new DoubleLinkedList(12);
		DoubleLinkedList c = new DoubleLinkedList(13);
		DoubleLinkedList d = new DoubleLinkedList(14);

		list.append(a);
		list.append(b);
		list.append(c);
		list.append(d);

		System.out.println(list);	// [ 14,  13, 12, 11, 10 ]

		list.detach(d);

		System.out.println(list);	// [ 13, 12, 11, 10 ]

		list.detach(c);

		System.out.println(list);

		list.detach(a);

		System.out.println(list);

		list.detach(list);

		System.out.println(list);

		DoubleLinkedList x = new DoubleLinkedList(15);
		list.append(x);

		System.out.println(list);

		/*DoubleLinkedList Afirst;

		Random rng = new Random();

		long t01 = 0;
		double t_total1 = 0;

		long t02 = 0;
		double t_total2 = 0;

		int[] n = {1, 10, 20, 40, 80, 160, 320, 640, 1280, 2560};
		//int[] n = {10, 20};
		int k = 10000;

		int[] sequence = new int[k];
		for (int i = 0; i < k; i++)
			sequence[i] = rng.nextInt(n[1]*10);

		for(int loop = 0; loop < n.length; loop++)
		{
			DoubleLinkedList Alist = new DoubleLinkedList();
			Afirst = Alist;
			for(int i = 0; i < n[loop]; i++)
			{
				DoubleLinkedList add = new DoubleLinkedList(rng.nextInt(n[loop]*10));
				Afirst.append(add);
			}

			for(int i = 0; i < k; i++)
			{
				int put = sequence[rng.nextInt(sequence.length)];
				DoubleLinkedList set = new DoubleLinkedList(put);
				t01 = System.nanoTime();
				Afirst.append(set);
				t_total1 += System.nanoTime() - t01;
			}

			for(int i = 0; i < k; i++)
			{
				int remove = sequence[rng.nextInt(sequence.length)];
				t02 = System.nanoTime();
				Afirst.detach(remove);	//detach random number from sequence;
				t_total2 += System.nanoTime() - t02;

				DoubleLinkedList addback = new DoubleLinkedList(remove);
				Afirst.append(addback);		//add back removed element
			}
			System.out.println(n[loop] + ". \tAdding: " + t_total1/k + " ns\t  " + "   Removing: " + t_total2/k + " ns");

			t_total1 = 0;
			t_total2 = 0;
		}

		System.out.println("\n");



		LinkedList Bfirst;

		 t01 = 0;
		 t_total1 = 0;

		 t02 = 0;
		 t_total2 = 0;

		for(int loop = 0; loop < n.length; loop++)
		{
			LinkedList Blist = new LinkedList();
			Bfirst = Blist;
			for(int i = 0; i < n[loop]; i++)
			{
				LinkedList add = new LinkedList(rng.nextInt(n[loop]*10));
				Bfirst.append(add);
			}

			for(int i = 0; i < k; i++)
			{
				int put = sequence[rng.nextInt(sequence.length)];
				LinkedList set = new LinkedList(put);

				t01 = System.nanoTime();
				Bfirst.append(set);
				t_total1 += System.nanoTime() - t01;
			}

			for(int i = 0; i < k; i++)
			{
				int remove = sequence[rng.nextInt(sequence.length)];

				t02 = System.nanoTime();
				Bfirst.detach(remove);	//detach random number from sequence;
				t_total2 += System.nanoTime() - t02;

				LinkedList addback = new LinkedList(remove);
				Bfirst.append(addback);		//add back removed element
			}
			System.out.println(n[loop] + ". \tAdding: " + t_total1/k + " ns\t  " + "   Removing: " + t_total2/k + " ns");

			t_total1 = 0;
			t_total2 = 0;
		}*/
	}
}