public class Queue
{
	Node bottom;
	Node top;

	public class Node
	{
		public Integer item;
		public Node next;

		public djikstra2.Node nod;

		public Node(Integer item)
		{
			this.item = item;
			this.next = null;
		}

		public Node(djikstra2.Node n)
		{
			this.nod = n;
			this.next = null;
		}
	}

	//konstruktor
	public Queue(Node list)
	{
		if(top == null)
			top = list;
	}

	//tom konstruktor
	public Queue(){}

	public void add(Integer item)
	{
		if(bottom == null && top == null)
		{
			bottom = new Node(item);
			top = bottom;
			return;
		}

		Node nxt = bottom;
		nxt.next = new Node( item);
		bottom.next = nxt.next;
		bottom = bottom.next;
	}

	public void Nadd(djikstra2.Node b)
	{
		Node n = new Node( b );
		if(bottom == null && top == null)
		{
			bottom = n;
			top = bottom;
			return;
		}

		Node nxt = bottom;
		nxt.next = n;
		bottom.next = nxt.next;
		bottom = bottom.next;
	}

	public Integer remove()
	{
		if(top == null)
			return null;
		Integer hold = this.top.item;
		top = top.next;
		return hold;
	}

	public djikstra2.Node Nremove()
	{
		if(top == null || (top == null && bottom == null))
			return null;
		djikstra2.Node hold = this.top.nod;
		top = top.next;
		return hold;
	}

	public String toString()
	{
		if(top == null)
			return "[ ]";

		String str = "[ ";
		Node nxt = top;

		while(nxt.next != null)
		{
			str += nxt.item + ", ";
			nxt = nxt.next;
		}
		str += nxt.item + " ]";
		return str;
	}
}