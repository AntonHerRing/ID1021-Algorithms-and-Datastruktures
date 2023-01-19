import java.io.BufferedReader;
import java.io.FileReader;

public class graph
{
	public class Node
	{
		public String from;
		public String to;

		public int min;

		public Node(String start, String destination , int minutes)
		{
			this.from = start;
			this.to = destination;
			this.min = minutes;
		}
	}
}
