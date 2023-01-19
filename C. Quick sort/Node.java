public class Node
{
	public int value;
	public Node next;

	public Node bottom;	//head
	public Node top;		//tail

	public Node first;

	//konstruktor
	public Node( int item )
	{
		this.value = item;
		this.next = null;

		if(bottom == null && top == null)
		{
			bottom = this;
			top = bottom;
			return;
		}
	}

	public int getbottomValue()
	{
		return bottom.value;
	}

	public void add( Node n )
	{

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

	public String toString()
	{
		if(top == null)
				return "[ ]";
		//Node nxt = top;
		Node nxt = this;

		String str = "[ ";
		while( nxt.next != null)
		{
			str += nxt.value + ", ";
			nxt = nxt.next;
		}
		str += nxt.value + " ]";
		return str;
	}
}