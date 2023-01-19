public class LinkedList
{
	public int node;
	public LinkedList next;

	private int iterator = 0;
	private LinkedList top;
	private LinkedList bottom;


	public LinkedList(int item) //konstruktor
	{
		this.node = item;
		next = null;

		if(bottom == null)
			bottom = this;
	}

	public LinkedList() // empty konstruktor
	{
		this.node = 0;
		next = null;

		if(bottom == null)
			bottom = this;
	}

	public int getNode()
	{
		return this.node;
	}

	public void setNode( int item)
	{
		this.node = item;
	}

	public void append(LinkedList b)
	{
		if(b != null)
		{
			if(top == null)
				top = this;
			LinkedList nxt = this;
			while (nxt.next != null)
			{
				nxt = nxt.next;
			}
			nxt.next = b;
			top = nxt.next;
		}
	}

	public void detach( int delete)
	{
		boolean exists = false;
		LinkedList nxt = this;
		LinkedList temp;
		iterator = 0;

		if(delete != nxt.getNode())	//skips if first
			while(nxt != null)	//find value	nxt.next != null
			{
				if(delete == nxt.next.getNode())
				{
					exists = true;
					break;
				}
				nxt = nxt.next;
				iterator++;
			}
			else
			{
				exists = true;
				iterator = -1;
			}

		if(exists == false){}
		else if(iterator == -1 )	//in the front
		{
			bottom = bottom.next;
		}
		else if(nxt.next.next == null)						//in the back
		{
			nxt.next = nxt.next.next;
		}
		else										//between
		{
			nxt.next = nxt.next.next;
		}
	}

	public void detach( LinkedList delete)
	{
		boolean exists = false;
		LinkedList nxt = this;
		LinkedList temp;
		iterator = 0;

		if(delete != nxt)	//skips if first
			while(nxt != null)	//find value	nxt.next != null
			{
				if(delete == nxt)
				{
					exists = true;
					break;
				}
				nxt = nxt.next;
				iterator++;
			}
			else
			{
				exists = true;
				iterator = -1;
			}

		if(exists == false){}
		else if(iterator == -1 )	//in the front
		{
			bottom = bottom.next;
		}
		else if(nxt.next.next == null)						//in the back
		{
			nxt.next = nxt.next.next;
		}
		else										//between
		{
			nxt.next = nxt.next.next;
		}
	}

	public String toString()
	{
		LinkedList nxt = bottom;
		String str = "[ ";
		while(nxt.next != null)
		{
			str += nxt.getNode() + ", ";
			nxt = nxt.next;
		}
		str += nxt.getNode() + " ]";

		return str;
	}
}