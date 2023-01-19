public class Node
{
	public Integer key;
	public Integer value;
	public Node left, right;

	public Node(Integer key, Integer value)
	{
		this.key = key;
		this.value = value;
		this.left = this.right = null;
	}

	public void print()
	{
		if(left != null)
			left.print();
		System.out.println(" key: " + key + "\tvalue: " + value);
		if(right != null)
			right.print();
	}
}