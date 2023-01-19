import java.util.*;

public class djikstra2
{
	public class Node
	{
		public City name;
		public City origin;

		public Integer dist;

		public Node(City start, Integer distMin, City from)
		{
			this.name = start;
			this.dist = distMin;
			this.origin = from;
		}
	}
	Node[] heap;

	private static int root = 0;
	int length = 0;
	int current = 0;

	Node[] pathEntry;

	int shortest;

	int index;

	public djikstra2()
	{
		this.pathEntry = new Node[54];
		this.heap = new Node[54];
		int shortest = 0;
		current = -1;
		length = heap.length - 1;
		this.index = 0;
	}

	public void swap(int prevpos, int newpos)
	{
		Node temp = heap[prevpos];
		heap[prevpos] = heap[newpos];
		heap[newpos] = temp;
	}

	public void add(City start, int distMin, City from)
	{
		Node data = new Node(start, distMin, from);

		current++;
		if(heap[root] == null)
		{
			heap[root] = data;
			return;
		}
		heap[current] = data;

		int parent = 0;
		int pointer = current;
		while(true)
		{
			if(pointer != 0)
				if(current % 2 == 0 )
					parent = (pointer - 2) / 2;
				else
					parent = (pointer - 1) / 2;

			if(heap[pointer].dist < heap[parent].dist)
			{
				swap(pointer , parent);
				pointer = parent;
			}
			else
				return;
		}
	}

	public Node remove()
	{
		Node save = heap[root];
		int pointer = root;
		int left = 0;
		int right = 0;

		heap[root] = heap[current];
		heap[current] = null;
		current--;

		while(left <= current && right <= current)
		{
			left = (pointer * 2) + 1;
			right = (pointer * 2) + 2;

			if(heap[left] != null && right > current)
			{
				swap(pointer , left);
				pointer = left;
				continue;
			}
			else if(heap[right] != null && left > current)
			{
				swap(pointer , right);
				pointer = right;
				continue;
			}

			if(left <= current && right <= current &&  heap[left].dist > heap[right].dist)
			{
				swap(pointer , right);
				pointer = right;
			}
			else if(left <= current && right <= current && heap[left].dist <= heap[right].dist)
			{
				swap(pointer , left);
				pointer = left;
			}
			else
				break;
		}
		return save;
	}

	public void update(City from, Integer dist , City next)
	{
		int i;
		for(i = 0; i < heap.length; i++)
			if(heap[i] != null && heap[i].name.number == from.number && dist < heap[i].dist)
			{
				heap[i] = new Node(from, dist, next);
				break;
			}
		if(i >= heap.length)
			return;

		int parent = 0;
		int pointer = i;

		while(true)
		{
			if(pointer != 0)
				if(i % 2 == 0 )
					parent = (pointer - 2) / 2;
				else
					parent = (pointer - 1) / 2;
			if(heap[pointer].dist < heap[parent].dist)
			{
				swap(pointer , parent);
				pointer = parent;
			}
			else
				return;
		}
	}

	public String toString()
	{
		String str = "[ ";
		for(int i = root; i < current; i++)
			str += heap[i].dist + ", ";
		str += heap[current].dist + "]";
		return str;
	}

	public boolean search(City stad)
	{
		for(int i = 0; i < heap.length; i++)
			if(heap[i] != null && heap[i].name.number == stad.number)
				return true;
		return false;

		}

	public Integer shortest(City from, City to)
	{
		if(from == to || from == null || to == null)
			return 0;
		add(from, 0, null);
		return shortest( 0, to);
	}

	public Integer shortest(Integer dist, City to)
	{

		//if(heap[root] == null)
		//	return 0;
		if(heap[root].name.number == to.number)
		{
			shortest = heap[root].dist;
			return 0;
		}
		Node entry = remove();

		pathEntry[entry.name.number] = entry;
		for(int i = 0; i < entry.name.neighbors.length; i++)
			if (entry.name.neighbors[i] != null)
			{
				City.Connection conn = entry.name.neighbors[i];
				boolean inQueue = search(conn.node);

				if(pathEntry[conn.node.number] == null && inQueue == false)
					add(conn.node, conn.distMin + entry.dist, entry.name);
				else if(inQueue == true)
					update(conn.node, conn.distMin + entry.dist, entry.name);
			}
		shortest(entry.dist, to);

		return shortest;
	}
}

