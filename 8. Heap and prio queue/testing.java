import java.util.*;

public class testing
{
	public static void main( String args[] )
	{
		Random rng = new Random();

		int k = 100;

		int data = rng.nextInt(k*100) + 1;
		Node start2 = new Node(data);
		prioQueue2 pq2 = new prioQueue2(start2);

		for(int i = 1; i < k; i++)
		{
			data = rng.nextInt(k*100) + 1;
			Node temp2 = new Node(data);
			pq2.add(temp2);
		}
			System.out.println(pq2);

			Node b = pq2.remove();
			System.out.println(pq2);

			pq2.add(b);
			System.out.println(pq2);

	}
}