public class pathtest3
{
	public static void main(String args[])
	{
		/*Map map = new Map("trains.csv");
		City stad = map.lookup("Malmö");
		//djikstra path = new djikstra();
		djikstra2 path = new djikstra2();

		path.add(stad, 0, null);

		City stad2 = stad.neighbors[0].node;
		path.add(stad2, stad.neighbors[0].distMin, stad);

		City stad3 = stad2.neighbors[0].node;
		System.out.println("stad3: " + stad3.name + "\t\tdist: " + stad2.neighbors[0].distMin);
		path.add(stad3, stad2.neighbors[0].distMin, stad2);

		City stad4 = stad3.neighbors[0].node;
		path.add(stad4, stad3.neighbors[0].distMin, stad3);

		City stad5 = stad4.neighbors[0].node;
		path.add(stad5, stad4.neighbors[0].distMin, stad4);


		System.out.println(path);

		stad3 = stad2.neighbors[0].node;
		System.out.println("stad3: " + stad3.name + "\t\tdist: " + 20);
		path.remove();
		path.update(stad3, 1, stad2);



		//djikstra2.Node bort = path.remove();
		//bort = path.remove();

		System.out.println(path);

		/*System.out.print("[");
		for (int i : path)
			System.out.print( i + ", ");
		System.out.println(" ]");

		/*bort = path.remove();
		bort = path.remove();

		if(bort.name != null)
			System.out.print("namn: " + bort.name.name);
		if(bort.origin != null)
			System.out.print("\t\torigin: " + bort.origin.name );
		System.out.println("\t\tdist: " + bort.dist);

		//System.out.println("test: " + path.root.left.left.dist);

		System.out.print("[");
		for (int i : path)
			System.out.print( i + ", ");
		System.out.println(" ]");*/

		Map map = new Map("trains.csv");
		City stad = map.lookup("Malmö");
		djikstra2 path = new djikstra2();
		Paths p = new Paths();

		String from = "Malmö";
		String to = "Kiruna";

		long t0 = System.nanoTime();
		Integer dist = path.shortest(map.lookup(from), map.lookup(to));
		long time = (System.nanoTime() - t0)/1_000;
		Integer dist2 = p.Fshortest(map.lookup(from), map.lookup(to));

		System.out.println("shortest: " + dist + " min (" + time/1000 + " ms)");
		System.out.println("shortest: " + dist+ " min (" + time + " us)");

		System.out.println(to + " & " + dist +  " & " + time +  " \\" + "\\");

		System.out.println("shortest: " + dist2);



		/*for(int i = 0; i < map.cities.length; i++)
			if(map.cities[i] != null)
				if(path.pathEntry[map.cities[i].number] != null)
					System.out.println(from + " to " + map.cities[i].name + " & " + path.pathEntry[map.cities[i].number].dist + " \\" + "\\");
		System.out.println();*/

	}
}