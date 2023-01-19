public class heapArray
{
	Integer[] heap;
	int root = 0;

	int length = 0;
	int current = 0;

	public heapArray( Integer data)
	{
		heap = new Integer[15];
		if(heap[root] == null)
		{
			heap[root] = data;
			current = 0;
		}
		length = heap.length - 1;
	}

	public heapArray( Integer data, int size)
	{
		heap = new Integer[size];
		if(heap[root] == null)
		{
			heap[root] = data;
			current = 0;
		}
		length = heap.length - 1;
	}

	public void add(Integer data)
	{
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

			if(heap[pointer] < heap[parent])
			{
				swap(pointer , parent);
				pointer = parent;
			}
			else
				return;
		}
	}

	public Integer remove()
	{
		Integer save = heap[root];
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
			if(right <= current && heap[right] == null)
			{
				swap(pointer , left);
				pointer = left;
				continue;
			}
			else if(left <= current && heap[left] == null)
			{
				swap(pointer , right);
				pointer = right;
				continue;
			}

			if(left <= current && right <= current &&  heap[left] > heap[right])
			{
				swap(pointer , right);
				pointer = right;
			}
			else if( left <= current && right <= current && heap[left] < heap[right])
			{
				swap(pointer , left);
				pointer = left;
			}
			else
				break;
		}

		return save;
	}

	public void swap(int prevpos, int newpos)
	{
		Integer temp = heap[prevpos];
		heap[prevpos] = heap[newpos];
		heap[newpos] = temp;
	}

	public String toString()
	{
		String str = "[ ";
		for(int i = root; i < current; i++)
			str += heap[i] + ", ";
		str += heap[current] + "]";
		return str;
	}
}