import java.util.*;

public class QuicksortList2
{
	public static void main(String args[])
	{
		int[] n = {100, 200, 300, 400, 500, 600,700,800,900,1000};

		int[] x = {65, 37,43, 80, 93, 100, 74, 24, 6, 28, 63, 75, 9, 32,};

		Random rng = new Random();

				int[] array = new int[30];

				for(int i = 0; i < array.length; i++)
					array[i] = rng.nextInt(20 * 10);

				Node nod = new Node(array[0]);
				for(int i = 1; i < x.length; i++)
				{
					Node temp = new Node(array[i]);
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

		if(list == null || list == n || list.next == n)
			return list;

		Node pivot = partition( list, n);

		if(pivot != null && pivot.next != null)
			sort(pivot.next, n );
		if( pivot != null && list != null)
			sort(list, pivot);

		return list;
	}

	public static Node partition( Node list, Node n)
	{
		Node PivotNod = list;

		int temp = 0;

		Node nxt = list;
		while( nxt != n && nxt != null)
		{
			if(nxt.value < n.value)
			{
				PivotNod = list;
				temp = list.value;
				list.value = nxt.value;
				nxt.value = temp;

				list = list.next;att
			}
			nxt = nxt.next;
		}

		temp = list.value;
		list.value = n.value;
		n.value = temp;

		return PivotNod;
	}
}