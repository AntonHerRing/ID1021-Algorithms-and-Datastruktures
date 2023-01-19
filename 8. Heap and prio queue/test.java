import java.util.*;

public class test
{
	public static void main(String args[])
	{
		Random rng = new Random();

		int k = 20;

		/*Integer data = rng.nextInt(k) + 1;
		System.out.println(data);
		Node start1 = new Node(data);
		Node start2 = new Node(data);

		prioQueue pq = new prioQueue(start1);
		prioQueue2 pq2 = new prioQueue2(start2);

		for(int i = 1; i < k; i++)
		{
			data = rng.nextInt(k) + 1;
			System.out.println(data);
			Node temp1 = new Node(data);
			pq.add(temp1);
			System.out.println("pq1:\t" + pq + "+ " + data);

			Node temp2 = new Node(data);
			pq2.add(temp2);
			System.out.println("pq2:\t" + pq2+ "+ " + data);
		}
		System.out.println();

		System.out.println("pq1:\t" + pq);
		System.out.println("pq2:\t" + pq2);*/

			int data = rng.nextInt(k * 10) + 1;
			heap hp = new heap(data);
			heapArray Ahp = new heapArray(data, k);

			for(int i = 1; i < k; i++)
			{
				data = rng.nextInt(k * 10) + 1;
				hp.add(data);
				Ahp.add(data);
			}

			printBoth(hp ,Ahp);

			hp.remove();
			Ahp.remove();
			printBoth(hp, Ahp);
			hp.remove();
			Ahp.remove();
			hp.remove();
			Ahp.remove();
			printBoth(hp, Ahp);
			hp.remove();
			Ahp.remove();

			data = rng.nextInt(k * 10) + 1;
			System.out.println(data);
			hp.add(data);
			Ahp.add(data);

			printBoth(hp, Ahp);
	}

	public static void printBoth(heap hp, heapArray Ahp)
	{
		System.out.println(Ahp);
		System.out.print("[");
		for (int i : hp)
			System.out.print( i + ", ");
		System.out.println(" ]");
	}
}

