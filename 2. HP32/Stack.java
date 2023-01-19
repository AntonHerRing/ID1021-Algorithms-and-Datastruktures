public class Stack	//dynamic static
{
	private int sp = 0;		//stack pointer
	private int[] stack;
	int SIZE = 100;

	public Stack()
	{
		this.stack = new int[SIZE];
	}

	public int stackSize()
	{
		return stack.length;
	}

	public void push(int item) throws IllegalArgumentException
	{
		if( sp > (SIZE - 1))
		{
			sp = SIZE - 1;
			throw new IllegalArgumentException("Illeagal stack push expression.");
		}

		this.stack[++sp] = item;		//addsn item, increases sp by 1
	}

	public int pop() throws IllegalArgumentException
	{
		if( sp < 0)
		{
			sp = 0;
			throw new IllegalArgumentException("Illeagal stack pop expression.");
		}

		return this.stack[sp--];		//removes item, decreases sp by 1
	}

}