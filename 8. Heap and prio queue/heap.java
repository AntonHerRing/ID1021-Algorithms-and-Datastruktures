import java.util.*;

public class heap implements Iterable<Integer>
{
	public class Node
	{
		public Integer value;
		public Integer size;

		Node left, right;

		public Node(Integer data)
		{
			this.value = data;
			size = 0;
		}
	}

	Node root;

	public heap(Integer data)
	{
		root = new Node(data);
	}

	public int add(Integer data)
	{
		Node nod = new Node(data);
		if(root == null)
		{
			root = nod;
			return 0;
		}
		Node nxt = root;
		int depth = 1;

		//continue until node added
		while(true)
		{
			//increase size
			nxt.size++;
			//current is bigger
			if(nxt.value > nod.value)
				swap(nod, nxt);
			//spot found
			if(nxt.left == null)
			{
				nxt.left = nod;
				return depth;
			}
			else if(nxt.right == null)
			{
				nxt.right = nod;
				return depth;
			}
			//if not found
			if(nxt.left.size <= nxt.right.size)
				nxt = nxt.left;
			else if(nxt.left.size > nxt.right.size)
				nxt = nxt.right;
			depth++;
		}
	}

	public Integer remove()
	{
		Integer save = root.value;
		//empty or 1 left
		if(root == null)
			return null;
		else if(root.size == 0)
		{
			root = null;
			return save;
		}
		Node nxt = root;

		//if more
		while(nxt.right != null || nxt.left != null)
		{
			//decrease size
			nxt.size--;

			if(nxt.right == null  || nxt.left.value <= nxt.right.value)
			{
				nxt.value = nxt.left.value;
				if(nxt.left.size != 0)
					nxt = nxt.left;
				else
				{
					nxt.left = null;
					break;
				}
			}
			else if(nxt.left == null || nxt.left.value > nxt.right.value)
			{
				nxt.value = nxt.right.value;
				if(nxt.right.size != 0)
					nxt = nxt.right;
				else
				{
					nxt.right = null;
					break;
				}
			}
		}

		return save;
	}

			/*if( nxt.right == null )
			{
				nxt.value = nxt.left.value;
				if(nxt.left.size != 0)
					nxt = nxt.left;
				else
				{
					nxt.left = null;
					break;
				}
				continue;
			}
			else if( nxt.left == null )
			{
				nxt.value = nxt.right.value;
				if(nxt.right.size != 0)
					nxt = nxt.right;
				else
				{
					nxt.right = null;
					break;
				}
				continue;
			}*/

	//gives root element new value, +incr
	public int push(Integer incr)
	{
		Node nxt = root;
		nxt.value += incr;
		int depth = 0;

		while(nxt.right != null || nxt.left != null)
		{
			if( nxt.right == null && nxt.left.value <= nxt.value)
			{
				swap(nxt, nxt.left);
				nxt = nxt.left;
				depth++;
				continue;
			}
			else if( nxt.left == null && nxt.right.value <= nxt.value)
			{
				swap(nxt, nxt.right);
				nxt = nxt.right;
				depth++;
				continue;
			}
			else if( nxt.right == null && nxt.left.value > nxt.value)
				return depth;
			else if( nxt.left == null && nxt.right.value > nxt.value)
				return depth;

			if(	nxt.left.value >= nxt.value && nxt.value < nxt.right.value ||
				nxt.left.value > nxt.value && nxt.value <= nxt.right.value)
				return depth;
			else if(nxt.left.value <= nxt.right.value)
			{
				swap(nxt, nxt.left);
				nxt = nxt.left;
				depth++;
			}
			else if(nxt.left.value > nxt.right.value)
			{
				swap(nxt, nxt.right);
				nxt = nxt.right;
				depth++;
			}
		}
		return depth;
	}

	public void swap(Node a, Node b)
	{
		Integer temp = a.value;
		a.value = b.value;
		b.value = temp;
	}

	/***************************************************************************/

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
