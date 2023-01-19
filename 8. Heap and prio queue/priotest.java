import java.util.*;

public class priotest
{
	public static void main( String args[] )
	{
		/*Node nod1 = new Node(5);
		Node nod2 = new Node(10);
		Node nod3 = new Node(4);
		Node nod4 = new Node(3);
		Node nod5 = new Node(12);
		Node nod6 = new Node(11);
		Node nod7 = new Node(9);
		Node nod8 = new Node(6);
		Node nod9 = new Node(13);
		Node nod10 = new Node(19);

		prioQueue pq = new prioQueue(nod1);
		//prioQueue2 pq = new prioQueue2(nod1);
		System.out.println(pq);

		pq.add(nod2);
		pq.add(nod3);
		pq.add(nod4);

		pq.add(nod5);
		pq.add(nod6);
		pq.add(nod7);
		pq.add(nod8);
		pq.add(nod9);
		pq.add(nod10);

		System.out.println(pq);
		Node min = pq.remove();
		System.out.println(min.value);
		System.out.println(pq);
		 min = pq.remove();
		System.out.println(min.value);
		System.out.println(pq);
		 min = pq.remove();
		System.out.println(min.value);
		System.out.println(pq);
		 min = pq.remove();
		System.out.println(min.value);
		System.out.println(pq);*/


		Random rng = new Random();

		int max = 1000;

		//int[] n ={10, 100, 200, 400, 800, 1600, 3200, 6400, 12800};
		int[] n ={10, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 20000, 40000};

		long t01 = 0;
		double t_total1 = 0;

		long t02 = 0;
		double t_total2 = 0;

		long t03 = 0;
		double t_total3 = 0;

		long t04 = 0;
		double t_total4 = 0;

		System.out.println("start");

		for(int loop = 0; loop < n.length; loop++)
		{
			t01 = 0;
			t_total1 = 0;

			t03 = 0;
			t_total3 = 0;

			t02 = 0;
			t_total2 = 0;

			t04 = 0;
			t_total4 = 0;


			int data = rng.nextInt(n[loop] * 100) + 1;
			Node start1 = new Node(data);
			Node start2 = new Node(data);
			prioQueue pq = new prioQueue(start1);
			prioQueue2 pq2 = new prioQueue2(start2);

			for(int i = 1; i < n[loop]; i++)
			{
				data = rng.nextInt(n[loop] * 100) + 1;
				Node temp1 = new Node(data);
				Node temp2 = new Node(data);
				pq.add(temp1);
				pq2.add(temp2);
			}
			//System.out.println(pq);
			//System.out.println(pq2);

			for(int k = 0; k < max; k++)
			{
				data = rng.nextInt(n[loop] * 100) + 1;
				Node temp1 = new Node(data);
				Node temp2 = new Node(data);

				t01 = System.nanoTime();
				Node a = pq.remove();
				pq.add(temp1);
				t_total1 += System.nanoTime() - t01;

				t02 = System.nanoTime();
				Node b = pq2.remove();
				pq2.add(temp2);
				t_total2 += System.nanoTime() - t02;

				//t03 = System.nanoTime();

				//t_total3 += System.nanoTime() - t03;

				//t04 = System.nanoTime();

				//t_total4 += System.nanoTime() - t04;
			}
			System.out.println(n[loop] + ". \tqueue1: " + t_total1/max +"\tqueue2: " + t_total2/max);
			//System.out.println(n[loop] + ". \tAdd1: " + t_total3/max +"\tAdd2: " + t_total4/max);
		}
	}
}