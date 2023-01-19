public class prioQueue2
{
	Node top;
	Node bottom;

	public prioQueue2(Node queue)
	{
		if(top == null)
		{
			top = queue;
			bottom = top;
		}
	}

	public void add(Node nod)
	{
		if(nod.value <= top.value)
		{
			Node temp = nod;
			temp.next = top;
			top = temp;
			return;
		}
		else if(nod.value >= bottom.value)
		{
			Node temp = nod;
			bottom.next = temp;
			bottom = temp;
			return;
		}

		Node nxt = top.next;
		Node prev = top;

		while( nxt != null)
		{
			if(nod.value <= nxt.value && nod.value > prev.value)
			{
				Node temp = prev.next;
				prev.next = nod;
				prev.next.next = temp;
				return;
			}

			prev = nxt;
			nxt = nxt.next;
		}
	}

	public Node remove()
	{
		Node temp = top;
		top = top.next;

		return temp;
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