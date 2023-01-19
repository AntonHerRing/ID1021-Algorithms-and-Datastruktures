import java.util.*;

public class QuicksortList
{
	public static void main(String args[])
	{
		int[] n = {100, 200, 300, 400, 500, 600,700,800,900,1000};

		int[] x = {65, 37,43, 80, 93, 100, 74, 24, 6, 28, 63, 75, 9, 32,};

		Node nod = new Node(x[0]);
		for(int i = 1; i < x.length; i++)
		{
			Node temp = new Node(x[i]);
			nod.add(temp);
		}


		System.out.println(nod);
		sort(nod);
		System.out.println(nod);

	}

	public static void sort(Node list)
	{
		if (list == null)
			return;
		sort(list, list.bottom);
	}

	public static Node sort( Node list, Node n)
	{
		Node pivot = list;

		if(list != n && list != null)
		{
			pivot = partition( list, n);

			System.out.println("  ");
			sort(list.top, pivot );

			System.out.println(" - ");
			sort(pivot.next, n );

			System.out.println(" past ");

			System.out.println(" n " + n.value);
			System.out.println(" top " + list.top);


		}

		return list;
	}

	public static Node partition( Node list, Node n)
	{
		if(list == null || n == null || list.next == n.next)
			return list;

		Node temp = null;
		Node pivot = list;

		Node nxt = list;
		while(  nxt.next != null && nxt.next != n.next)
		{
			if(pivot.value > nxt.next.value)
			{
				temp = nxt.next;
				nxt.next = nxt.next.next;

				temp.next = list.top;
				list.top = temp;
			}
			else if(pivot.value < nxt.next.value)
			{
				nxt = nxt.next;
			}
			System.out.println(list.top);
		}

		return pivot;
	}
}