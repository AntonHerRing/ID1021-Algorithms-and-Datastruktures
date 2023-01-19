public class testprogram
{

	public static void main( String args[] )
	{
		Item[] test = new Item[28];
		test[0] = new Item(Item.ItemType.VALUE, 0); 	//y1
		test[1] = new Item(Item.ItemType.VALUE, 2);
		test[2] = new Item(Item.ItemType.SMUL, 0);
		test[3] = new Item(Item.ItemType.VALUE, 0);		//y2
		test[4] = new Item(Item.ItemType.ADD, 0);
		test[5] = new Item(Item.ItemType.VALUE, 0);		//m1
		test[6] = new Item(Item.ItemType.VALUE, 2);
		test[7] = new Item(Item.ItemType.SMUL, 0);
		test[8] = new Item(Item.ItemType.VALUE, 3);		//m2
		test[9] = new Item(Item.ItemType.ADD, 0);
		test[10] = new Item(Item.ItemType.VALUE, 2); 	//d1
		test[11] = new Item(Item.ItemType.VALUE, 2);
		test[12] = new Item(Item.ItemType.SMUL, 0);
		test[13] = new Item(Item.ItemType.VALUE, 9);	//d2
		test[14] = new Item(Item.ItemType.ADD, 0);
		test[15] = new Item(Item.ItemType.VALUE, 0); 	//s1
		test[16] = new Item(Item.ItemType.VALUE, 2);
		test[17] = new Item(Item.ItemType.SMUL, 0);
		test[18] = new Item(Item.ItemType.VALUE, 1);	//s2
		test[19] = new Item(Item.ItemType.ADD, 0);
		test[20] = new Item(Item.ItemType.VALUE, 1); 	//s3
		test[21] = new Item(Item.ItemType.VALUE, 2);
		test[22] = new Item(Item.ItemType.SMUL, 0);
		test[23] = new Item(Item.ItemType.ADD, 0);
		test[24] = new Item(Item.ItemType.ADD, 0);
		test[25] = new Item(Item.ItemType.ADD, 0);
		test[26] = new Item(Item.ItemType.ADD, 0);
		test[27] = new Item(Item.ItemType.MOD10, 0);


		//Stack stack = new Stack();

		//int i = stack.pop();

		Calculator cal = new Calculator(test);

		/*while( cal.ip < test.length )		//test to see stacksize
		{
			cal.step();
			System.out.println("stack: " + cal.showStack());
		}*/

		/*int repition = 10000;
		double t_total = 0;


		for(int i = 0; i < 10000; i++)
		{
			System.out.println("run: " + i);
			cal = new Calculator(test);
			long t0 = System.nanoTime();
			cal.run();
			t_total += (System.nanoTime() - t0);
		}


		System.out.println("tid: " + t_total/10000 + " ns");*/


		System.out.println("value: " + cal.run());
	}
}