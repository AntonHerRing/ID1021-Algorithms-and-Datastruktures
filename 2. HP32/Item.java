public class Item
{
	private ItemType type;
	private int value = 0;

	public enum ItemType
	{
		ADD,
		SUB,
		MUL,
		DIV,
		VALUE,
		MOD10,
		SMUL
	}

	public Item(ItemType a, int b)		//konstruktor
	{
		this.type = a;
		this.value = b;
	}

	public Item(Item annan)		//copy konstruktor
	{
		this.type = annan.type;
		this.value = annan.value;
	}

	public ItemType type()
	{
		return this.type;
	}

	public int value()
	{
		return this.value;
	}
}