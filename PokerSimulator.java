import java.util.ArrayList;

public class PokerSimulator
{
		public static void main(String[] args)
			{
				Deck d1 = new Deck();
				Deck d2 = new Deck();
				
				ArrayList<Card> c1 = new ArrayList<Card>();
				ArrayList<Card> c2 = new ArrayList<Card>();

				d1.shuffle();
				
				System.out.println("Your Deck");
				for(int i=1;i<=5;i++)
				{
					Card dealt= Deck.drawFromDeck();
					c1.add(dealt);
					System.out.println("Card " + i + ": " + dealt.toString());
				}
				//c1.remove(0);
				
				// Oponent Deck
				for(int i=1;i<=5;i++)
				{
					c2.add(Deck.drawFromDeck());
				}

			}

	private String suit;
	private String value;
}
