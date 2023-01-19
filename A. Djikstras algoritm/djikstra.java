import java.util.*;

public class djikstra implements Iterable<Integer>
{
	public class Node
	{
		public Node left, right;
		public Integer size;

		public City name;
		public City origin;

		public Integer dist;

		public Node(City start, Integer distMin, City from)
		{
			this.name = start;
			this.dist = distMin;
			this.origin = from;
			this.size = 0;
		}
	}
	Node root;

	Node[] pathEntry;

	//Integer[] pathEntry;
	int index;
	private final int mod = 541;

	public djikstra()
	{
		this.pathEntry = new Node[54];
		//this.pathEntry = new Integer[54];
		this.index = 0;
	}

	public void swap(Node a, Node b)
	{
		City tempName = a.name;
		City tempOrigin = a.origin;
		Integer temp = a.dist;
		a.name = b.name;
		a.origin = b.origin;
		a.dist = b.dist;
		b.name = tempName;
		b.origin = tempOrigin;
		b.dist = temp;
	}

	private Integer hash(String name)
	{
		int hash = 7;
		for (int i = 0; i < name.length(); i++)
			hash = (hash*31 % mod) + name.charAt(i);
		return hash % mod;
	}

	public void add(City start, int distMin, City from)
	{
		if(start == null)
			return;
		if(root == null)
		{
			root = new Node(start, distMin, from);
			return;
		}
		Node entry = new Node(start,  distMin,  from);
		Node nxt = root;
		add(entry, nxt);
	}

	public void add(Node entry, Node next)
	{
		next.size++;

		if(entry.dist < next.dist)
			swap(entry, next);

		if(next.left == null)
		{
			next.left = entry;
			return;
		}
		else if(next.right == null)
		{
			next.right = entry;
			return;
		}

		if(next.left.dist <= next.right.dist)
			add(entry, next.left);
		else if(next.left.dist > next.right.dist)
			add(entry, next.right);
	}

	public void update(City start, Integer distMin, City from)
	{
		Node entry = new Node( start,  distMin,  from);
		update(entry, root);
	}

	public void update(Node entry, Node next)
	{
		//update
		if(entry.name.name.equals(next.name.name))
		{
			System.out.println(entry.name.name + " == " + next.name.name);
			swap(entry, next);
			return;
		}
	}

	public Node remove()
	{
		if(root == null)
			return null;
		Node nxt = new Node(root.name, root.dist, root.origin);
		if(root.size != 0)
			remove(root);
		else
			root = null;
		return nxt;
	}

	public void remove(Node next)
	{
		if(next == null || (next.left == null && next.right == null))
			return;

		next.size--;
		if(next.right == null  || next.left.dist <= next.right.dist)
		{
			swap(next, next.left);
			if(next.left.size != 0)
				remove(next.left);
			else
				next.left= null;
		}
		else if(next.left == null || next.left.dist > next.right.dist)
		{
			swap(next, next.right);
			if(next.right.size != 0)
				remove(next.right);
			else
				next.right = null;
		}
	}

	public Integer shortest(City from, City to)
	{
		if(from == to || from == null || to == null)
			return 0;
		return shortest(from, 0, null, to);
	}

	public Integer shortest(City from, Integer dist , City next, City to)
	{
		if(from == to)
		{
			System.out.println("DONEDONEDONEDONE");
			return 0;
		}

		System.out.println("from: " + from.name);

		//pathEntry[from.number] = dist;
		//add(from, dist, next);
		for(int i = 0; i < from.neighbors.length; i++)
		{
			if (from.neighbors[i] != null)
			{
				City.Connection conn = from.neighbors[i];
				System.out.println("conn: " + conn.node.name);
				if(pathEntry[conn.node.number] == null)
					add(conn.node, conn.distMin, from);
				else if(pathEntry[conn.node.number] != null)
					update(conn.node, conn.distMin, from, pathEntry[conn.node.number].dist);
			}
		}
		Node entry = remove();
		System.out.println("name: " + entry.name.name + "\t\tdist: " + dist + "\t\tentry: " + entry.dist);
		pathEntry[entry.name.number] = entry;
		pathEntry[entry.name.number].dist = dist + entry.dist;

		shortest(entry.name, pathEntry[entry.name.number].dist, entry.origin, to);

		return 0;
	}


/**********************************************************************/

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

			return nxt.dist;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
}