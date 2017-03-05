import java.util.Collections;
import java.util.ArrayList;

public class Deck
{
	public static ArrayList<Card> cards;

	public Deck()
	{
		cards = new ArrayList<Card>();

		for (short a=0; a<=3; a++)
		{
			for (short b=0; b<=12; b++)
			{
				cards.add(new Card(a,b));
			}
		}

		int size = cards.size()-1;
	}

	public static void shuffle()
	{
		Collections.shuffle(cards);
	}

	public static Card drawFromDeck()
	{
		return cards.remove(0);
	}

	public int getTotalCards()
	{
		return cards.size();
	}
}
