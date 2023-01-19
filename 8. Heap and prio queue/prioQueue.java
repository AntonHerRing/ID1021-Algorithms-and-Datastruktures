public class prioQueue
{
	Node top;
	Node bottom;

	public prioQueue(Node queue)
	{
		if(top == null)
		{
			top = queue;
			bottom = top;
		}
	}

	public void add(Node nod)
	{
		if(nod.value <= top.value )
		{
			Node temp = nod;
			temp.next = top;
			top = temp;
		}
		else if(nod.value > top.value)
		{
			if(top.value < nod.value && nod.value < bottom.value)
			{
				Node temp = nod;
				temp.next = top.next;
				top.next = temp;
			}
			else if(nod.value >= bottom.value)
			{
				Node temp = nod;
				bottom.next = temp;
				bottom = temp;
			}
		}
	}

	public Node remove()
	{
		Node prev = null;
		Node min = top;
		Node nxt = top.next;

		while( nxt.next != null)
		{
			if(nxt.next.value < min.value)
			{
				min = nxt.next;
				prev = nxt;

			}
			nxt = nxt.next;
		}

		if(prev != null)
		{
			Node temp = prev.next;
			prev.next = temp.next;
		}
		else
			top = top.next;

		return min;
	}

	public String toString()
	{
		String str = "[ ";
		Node nxt = top;

		while(nxt.next != null)
		{
			str += nxt.value;
			if(nxt.next != null)
				str += ", ";
			nxt = nxt.next;
		}
		str += nxt.value + " ]";

		return str;
	}

}