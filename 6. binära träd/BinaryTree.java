import java.util.*;

public class BinaryTree implements Iterable<Integer>
{

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
		private linkedstack stack = new linkedstack();

		boolean foundleaf = false;

		//konstruktor
		public TreeIterator()
		{
			next = root;
			//begin furthest left
			while(next.left != null || next.right != null)
			{
				stack.push(next);
				next = next.left;
			}
			foundleaf = true;
		}

		@Override
		public boolean hasNext()
		{
			if(next == null)
				return false;
			return true;
		}

		@Override
		public Integer next()	//return next element value
		{
			Integer temp = 0;

			if(foundleaf == false)
				while(next.left != null || next.right != null)
				{
					if(next.left == null)
						next = next.right;

					stack.push(next);
					next = next.left;
				}

			if(next.left == null && next.right == null )
			{
				temp = next.value;
				next = stack.pop();
				foundleaf = true;

				return temp;
			}
			else if( foundleaf == true )
			{
				temp = next.value;
				if( next.right != null)
				{
					next = next.right;
					foundleaf = false;
				}
				else
					next = stack.pop();

				return temp;
			}

			return null;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}
