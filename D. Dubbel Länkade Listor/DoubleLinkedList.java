public class DoubleLinkedList
{
	public DoubleLinkedList next;
	public DoubleLinkedList prev;
	public int data;

	public DoubleLinkedList top;
	public DoubleLinkedList bottom;

	public DoubleLinkedList( int item)	//konstruktor
	{
		this.data = item;
		next = null;
		prev = null;

		if(top == null)
			top = this;
	}

	public DoubleLinkedList()	// empty konstruktor
	{
		this.data = 0;
		next = null;
		prev = null;

		if(top == null)
			top = this;
	}


	public int getData()
	{
		return this.data;
	}

	public void append( DoubleLinkedList b)
	{
		if(bottom == null)
			bottom = this;
		b.prev = top;
		top.next = b;
		top = top.next;

	}

	public void detach( DoubleLinkedList delete )
	{
		boolean exists = false;
		DoubleLinkedList temp;

		if(delete.next == null && delete.prev == null)
			return;

		if(delete.prev == null)	//in the front
		{
			bottom = bottom.next;
			bottom.prev = null;
		}
		else if(delete.next == null)	//in the back
		{
			top = top.prev;
			top.next = null;
		}
		else						//between elements
		{
			temp = delete;
			delete = delete.prev;
			delete.next = temp.next;
			temp = temp.next;
			temp.prev = delete;
		}
	}

	public String toString()
	{
		DoubleLinkedList nxt = bottom;
		String str = "[ ";
		while(nxt.next != null)
		{
			str += nxt.getData() + ", ";
			nxt = nxt.next;
		}
		str += nxt.getData() + " ]";

		return str;
	}
}

//single linked time grows larger as it adds the elements back at the top of the list, meaning as the list grows there is more elements it has to go through, (n + k)
//in the double linked list, the elements are added to the front, meaning the length n of the list has no meaning when searching through the k elements.