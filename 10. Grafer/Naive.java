import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Naive
{
	public static void main(String[] args)
	{
		Map map = new Map("trains.csv");

		Paths path = new Paths();

		//System.out.println("begin");

		String from = "Malmö";
		String to = "Hallsberg";

		System.out.println(from);
		System.out.println(to);

		try (FileInputStream fis = new FileInputStream("Malmö");
       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
       BufferedReader br = new BufferedReader(isr))
       {
		   System.out.println(br.readLine());
		   from = br.readLine();
       } catch (Exception e){}

		System.out.println(from);
		System.out.println(to);

		//String to = "H�ssleholm";
		Integer max = 300;

		System.out.println(map.lookup(from).name);
		System.out.println(map.lookup(to).name);

		long t0 = System.nanoTime();
		Integer dist = map.shortest(map.lookup(from), map.lookup(to), max, max);
		//Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
		//Integer dist = path.Fshortest(map.lookup(from), map.lookup(to));
		long time = (System.nanoTime() - t0)/1_000;

		System.out.println("shortest: " + dist + " min (" + time/1000 + " ms)");
		System.out.println("shortest: " + dist+ " min (" + time + " us)");

		System.out.print("[ ");
		for(int i = 0; i < path.path.length - 1; i++)
			if(path.path[i] != null)
				System.out.print(path.path[i].name + " - ");
		if(path.path[path.path.length - 1] != null)
			System.out.println(path.path[path.path.length - 1].name + " - ");
	}
}