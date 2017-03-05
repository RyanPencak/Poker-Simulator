public class Card
{
	public Card(short suit, short value)
	{
		this.suit = suit;
		this.value = value;
	}

	public static String rankAsString(int __value) 
	{
	        return values[__value];
	}

	public short getValue()
	{
		return value;
	}

	public short getSuit()
	{
		return suit;
	}

	public String toString()
	{
		return values[value] + " of " + suits[suit];
	}

	public boolean sameSuit(Card card)
	{
		return false;
	}

	private short value;
	private short suit;

	private static String[] suits = { "hearts", "spades", "diamonds", "clubs" };
	private static String[] values = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
}
