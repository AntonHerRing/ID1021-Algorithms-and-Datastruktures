public class linkedstack
{
	private int size = 0;		//stack pointer
	private linkedstack sp;

	public linkedstack nextstack;
	public int stack;

	public linkedstack()
	{
		this.nextstack = null;
		this.sp = nextstack;
		this.stack = 0;
	}

	public linkedstack(int item)
	{
		this.nextstack = null;
		this.sp = nextstack;
		this.stack = item;
	}

	public int stackSize()
	{
		return size;
	}

	public void push(int item)
	{
		size++;
		linkedstack nxt = new linkedstack(item);
		nxt.nextstack = sp;
		sp = nxt;
	}

	public int pop()
	{
		int item = 0;
		size--;

		if(size > -1)
		{
			linkedstack nxt = sp;
			item = sp.stack;
			sp = sp.nextstack;
			return item;
		}
		size = 0;
		return 0;
	}
}