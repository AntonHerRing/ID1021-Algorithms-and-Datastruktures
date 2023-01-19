import java.util.*;

public class BinaryTree implements Iterable<Integer>
{
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
	}

	Node root;

	int size = 0;

	public BinaryTree()		//empty konstruktor
	{
		root = null;
	}

	public BinaryTree(Integer key, Integer value)
	{
		root = new Node(key, value);
	}

	public int getSize()
	{
		return size;
	}

	public String printTo(Integer key)
	{
		Node nxt = this.root;
		String str = "[ ";

		int i = 0;
		while(nxt != null)
		{
			str += nxt.value;
			if(key < nxt.key)			//left
				nxt = nxt.left;
			else if(key > nxt.key)		//right
				nxt = nxt.right;
			else if(key.equals( nxt.key ))		//found
				break;
			str += ", ";
		}
		return str + " ]";
	}

	public void add(Integer key, Integer value)
	{
		Node nxt = root;

		//first time
		if(nxt == null)
		{
			root = new Node(key, value);
			return;
		}
		else if(nxt.left == null && key < nxt.key)
		{
			nxt.left = new Node(key, value);
			return;
		}
		else if(nxt.right == null && key > nxt.key)
		{
			nxt.right = new Node(key, value);
			return;
		}


		while(nxt.left != null && key < nxt.key || nxt.right != null && key > nxt.key)
		{
			if(key < nxt.key) 			//left
				nxt = nxt.left;
			else if(key > nxt.key)		//right
				nxt = nxt.right;
			else if(key.equals( nxt.key ))	//replace
				break;
		}

		if(nxt.left == null && key < nxt.key)
			nxt.left = new Node(key, value);
		else if(nxt.right == null && key > nxt.key)
			nxt.right = new Node(key, value);
		else
			nxt.value = value;

		size++;
	}

	public Integer lookup(Integer key)
	{
		Node nxt = this.root;

		while(nxt != null)
		{
			if(key < nxt.key) 			//left
				nxt = nxt.left;
			else if(key > nxt.key)		//right
				nxt = nxt.right;
			else if(key.equals( nxt.key ))	//found
				return nxt.value;
		}
		return null;
	}

	//Iterator part

	public Iterator<Integer> iterator()
	{
		return new TreeIterator();
	}

	public class TreeIterator implements Iterator<Integer>
	{
		private Node next;
		private Queue ko = new Queue();
		boolean first = true;

		//konstruktor
		public TreeIterator()
		{
			next = root;
			//ko.Nadd(next);
		}

		@Override
		public boolean hasNext()
		{
			if(ko.top == null && next == null)
				return false;
			return true;
		}

		@Override
		public Integer next()	//return next element value
		{
			Node nxt = next;
			if(nxt.left != null)
				ko.Nadd(nxt.left);
			if(nxt.right != null)
				ko.Nadd(nxt.right);

			next = ko.Nremove();

			return nxt.value;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}
