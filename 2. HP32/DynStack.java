public class DynStack	//static
{
	private int sp = 0;		//stack pointer
	private int[] stack;

	public DynStack()
	{
		this.stack = new int[4];
	}

	public void push(int item) throws IllegalArgumentException
	{
		if(sp > stack.length - 1)
			stack_extend();

		this.stack[sp++] = item;		//addsn item, increases sp by 1
	}

	public int pop() throws IllegalArgumentException
	{
		if( sp < 0)
		{
			sp = 0;
			throw new IllegalArgumentException("Illeagal stack pop expression.");
		}

		if(sp < stack.length / 4 && sp > 0) //cut length in half if sp is 1/4 as big as before. if bigger then 0
			stack_decrease();

		return this.stack[--sp];		//removes item, decreases sp by 1
	}

	public int stackSize()
	{
		return stack.length;
	}

	private void stack_extend()
	{
		int[] tempstack = new int[stack.length * 2];	//större än stack

		for(int i = 0; i < stack.length; i++)			//gå upp till mindre
		{
			tempstack[i] = stack[i];
		}
		stack = tempstack;
	}

	private void stack_decrease()
	{
		int[] tempstack = new int[stack.length / 2];	//mindre än stack

		for(int i = 0; i < tempstack.length; i++)		//gå upp till mindre
		{
			tempstack[i] = stack[i];
		}
		stack = tempstack;
	}

}