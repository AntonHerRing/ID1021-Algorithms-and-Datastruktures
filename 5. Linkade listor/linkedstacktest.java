public class linkedstacktest
{
	public static void main( String args[] )
	{
		linkedstack stack = new linkedstack();

		stack.push(5); //sp = 1
		stack.push(10);	//sp = 2
		stack.push(1);

		System.out.println("stack size: " + stack.stackSize());

		int y = stack.pop();	//sp = 1
		System.out.println("y: " + y);
		int x = stack.pop();
		System.out.println("x: " + x);
		int z = stack.pop();
		System.out.println("z: " + z);
		stack.push( x + y );
		int xy = stack.pop();

		System.out.println("x + y: " + xy);

		stack.push( xy + z );
		int xyz = stack.pop();

		System.out.println("x + y + z: " + xyz);

		System.out.println("stack size: " + stack.stackSize());
	}
}