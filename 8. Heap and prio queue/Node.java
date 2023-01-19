public class Node
{
	public Integer value;
	public Node next;

	public Node(Integer item)
	{
		this.value = item;
		this.next = null;
	}

	public Node()
	{
		this.value = null;
		this.next = null;
	}
}
