public class linkedstack
{
	private int size = 0;		//stack pointer
	private linkedstack sp;

	public linkedstack nextstack;
	public Node stack;

	public linkedstack()
	{
		this.nextstack = null;
		this.sp = nextstack;
		this.stack = null;
	}

	public linkedstack(Node item)
	{
		this.nextstack = null;
		this.sp = nextstack;
		this.stack = item;
	}

	public int stackSize()
	{
		return size;
	}

	public void push(Node item)
	{
		size++;
		linkedstack nxt = new linkedstack(item);
		nxt.nextstack = sp;
		sp = nxt;
	}

	public Node pop()
	{
		Node item = null;
		size--;

		if(size > -1)
		{
			linkedstack nxt = sp;
			item = sp.stack;
			sp = sp.nextstack;
			return item;
		}
		size = 0;
		return null;
	}
}