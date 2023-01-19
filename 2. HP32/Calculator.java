public class Calculator
{
	Item[] expr;
	int ip;
	Stack stack;
	//DynStack stack;

	public Calculator(Item[] expr)
	{
		this.expr = expr;
		this.ip = 0;
		this.stack = new Stack();
		//this.stack = new DynStack();
	}

	public int run()
	{
		while( ip < expr.length )
		{
			step();
		}
		return stack.pop();
	}

	public int showStack()
	{
		return this.stack.stackSize();
	}

	public void step()
	{
		Item nxt = expr[ip++];

		switch(nxt.type())	//type contains the operation enum ex ADD/SUB... v
		{
			case VALUE:{
				stack.push(nxt.value());
				break;
			}

			case ADD:{
				int y = stack.pop();
				int x = stack.pop();
				stack.push( x + y );
				break;
			}

			case SUB:{
				int y = stack.pop();
				int x = stack.pop();
				stack.push( x - y );
				break;
			}

			case MUL:{
				int y = stack.pop();
				int x = stack.pop();
				stack.push( x * y );
				break;
			}

			case DIV:{
				int y = stack.pop();
				int x = stack.pop();
				stack.push( x / y );
				break;
			}

			case MOD10:{
				int x = stack.pop();
				stack.push( 10 - (x % 10) );
				break;
			}

			case SMUL:{
				int y = stack.pop();
				int x = stack.pop();
				if(x * y < 9)
				{
					stack.push(x * y);
				}
				else
				{
					stack.push((x * y) % 10);
				}
				break;
			}
		}
	}
}