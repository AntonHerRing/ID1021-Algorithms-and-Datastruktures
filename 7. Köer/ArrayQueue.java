public class ArrayQueue
{
	//konstruktor

	Integer[] queue;

	int i;	//first element
	int k;	//last element

	int length;

	boolean ibeforek = true;

	public ArrayQueue(int size)
	{
		this.queue = new Integer[size];
		this.i = 0;
		this.k = 0;
		this.length = queue.length;
	}

	public ArrayQueue()
	{
		this.queue = new Integer[8];
		this.i = 0;
		this.k = 0;
		this.length = queue.length;
	}

	public void add( Integer data )
	{
		if( k == length && i != 0)					//wrap around k
		{
			ibeforek = false;
			k = 0;
		}
		//first time / empty
		if( k == i && ibeforek == true)			//tom
			queue[k++] = data;
		else if( k == i && ibeforek == false )	//full kan orsaka problem om i = 0
			return;
		else if( k < length)
			queue[k++] = data;
	}

	public Integer remove()
	{
		Integer element = 0;
		if( i == length && ibeforek == false)						//wrap around i
		{
			ibeforek = true;
			i = 0;
			element = queue[i];
			queue[i++] = null;
		}
		else if( k == i && ibeforek == true)	//tom kan orsaka problem om k = 0
			return null;
		else if( i < length)
		{
			element = queue[i];
			queue[i++] = null;
		}

		return element;
	}

	public String toString()
	{
		String str = "[ ";
		int index = i;	//first element

		for(int h = 0; h < length - 1; h++)
		{
			if(index == length)
				index = 0;

			if(queue[index] != null)
				str += queue[index] + ", ";

			index++;
			if(index == length)
				index = 0;
		}
		if(queue[index] != null)
			str += queue[index] ;
		return str + " ]";
	}
}
