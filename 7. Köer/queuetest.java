public class queuetest
{
	public static void main(String args[])
	{
		Queue ko = new Queue();
		ArrayQueue Ako = new ArrayQueue(4);
		DynArrayQueue DyAko = new DynArrayQueue(4);

		/*ko.add( 10 );
		ko.add( 11 );
		ko.add( 12 );*/

		/*ko.add(10);
		ko.add(11);
		ko.add(12);*/

		/*Ako.add(10);
		Ako.add(11);
		Ako.add(12);*/

		DyAko.add(10);
		DyAko.add(11);
		DyAko.add(12);
		DyAko.add(13);

		System.out.println(DyAko.remove());
		System.out.println(DyAko.remove());

		System.out.println(DyAko);

		DyAko.add(14);
		DyAko.add(15);
		DyAko.add(16);

		DyAko.add(17);
		System.out.println(DyAko);

		DyAko.add(18);
		DyAko.add(19);
		System.out.println(DyAko);



		/*System.out.println(ko);
		System.out.println(ko.remove());
		System.out.println(ko.remove());
		System.out.println(ko.remove());
		System.out.println(ko.remove());
		System.out.println(ko);*/

	}
}