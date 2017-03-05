import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Hand
{
	/*public static void main(String[] args)
		{
			Deck d = new Deck();
			ArrayList<Card> h = new ArrayList<Card>();

			d.shuffle();
			
			for(int i=0;i<5;i++)
			{
				Card dealt= Deck.drawFromDeck();
				h.add(dealt);
				System.out.println("Card: " + dealt.toString());
			}

		}*/

	public Hand(Deck d)
	{
		values = new int[6];
		cards = new Card[5];

			int groupValue = 0;
			int[] orderedValue = new int[5];
			int sameCards = 1;
			int sameCards2 = 1;
			int smallGroupValues = 0;

			for (int x=13; x>=1; x--)
			{
				if (values[x] > sameCards)
				{
					sameCards = values[x];
					groupValue = x;
			    }
			}

		int largeGroupValue = 0;
		int smallGroupValue = 0;

			for (int x=13; x>=1; x--)
		    {
		    	if (values[x] > sameCards)
		        {
		        	if (sameCards != 1)
					{
						sameCards2 = sameCards;
						smallGroupValue = largeGroupValue;
		            }
                    sameCards = values[x];
					 largeGroupValue = x;
		         }
				else if (values[x] > sameCards2)
				{
					sameCards2 = values[x];
					smallGroupValue = x;
				}
			}

		boolean flush=true;

		for (int x=0; x<4; x++)
		{
			if (cards[x].getSuit() != cards[x+1].getSuit())
				flush=false;
		}

		int topStraightValue=0;
		boolean straight=false;

		for (int x=1; x<=9; x++)
		{
			if (values[x]==1 && values[x+1]==1 && values[x+2]==1 && values[x+3]==1 && values[x+4]==1)
			{
				straight=true;
				topStraightValue=x+4;
				break;
			}
		}

		if (values[10]==1 && values[11]==1 && values[12]==1 && values[13]==1 && values[1]==1)
		{
			straight=true;
		    topStraightValue=14;
		}

		for (int x=0; x<=5; x++)
		        {
		            values[x]=0;
		        }

		        if ( sameCards==1 )
		        {
		            values[0]=1;
		            values[1]=orderedValue[0];
		            values[2]=orderedValue[1];
		            values[3]=orderedValue[2];
		            values[4]=orderedValue[3];
		            values[5]=orderedValue[4];
		        }

		        if (sameCards==2 && sameCards2==1)
		        {
		            values[0]=2;
		            values[1]=largeGroupValue;
		            values[2]=orderedValue[0];
		            values[3]=orderedValue[1];
		            values[4]=orderedValue[2];
		        }

		        if (sameCards==2 && sameCards2==2)
		        {
		            values[0]=3;
		            values[1]= largeGroupValue>smallGroupValue ? largeGroupValue : smallGroupValue;
		            values[2]= largeGroupValue<smallGroupValues ? largeGroupValue : smallGroupValue;
		            values[3]=orderedValue[0];
		        }

		        if (sameCards==3 && sameCards2!=2)
		        {
		            values[0]=4;
		            values[1]= largeGroupValue;
		            values[2]=orderedValue[0];
		            values[3]=orderedValue[1];
		        }
		        if (straight && !flush)
		        {
		            values[0]=5;
		            values[1]=topStraightValue;
		        }

		        if (flush && !straight)
		        {
		            values[0]=6;
		            values[1]=orderedValue[0];
		            values[2]=orderedValue[1];
		            values[3]=orderedValue[2];
		            values[4]=orderedValue[3];
		            values[5]=orderedValue[4];
		        }

		        if (sameCards==3 && sameCards2==2)
		        {
		            values[0]=7;
		            values[1]=largeGroupValue;
		            values[2]=smallGroupValue;
		        }

		        if (sameCards==4)
		        {
		            values[0]=8;
		            values[1]=largeGroupValue;
		            values[2]=orderedValue[0];
		        }

		        if (straight && flush)
		        {
		            values[0]=9;
		            values[1]=topStraightValue;
		        }
	}

	public void display()
	    {
	        String score;
			score="";
	        switch(values[0])
	        {
				case 1:
	                score="high card";
	                break;
	            case 2:
	                score="pair of " + Card.rankAsString(values[1]) + "\'s";
	                break;
	            case 3:
	                score="two pair " + Card.rankAsString(values[1]) + " " + Card.rankAsString(values[2]);
	                break;
	            case 4:
	                score="three of a kind " + Card.rankAsString(values[1]) + "\'s";
	                break;
	            case 5:
	                score=Card.rankAsString(values[1]) + " high straight";
	                break;
	            case 6:
	                score="flush";
	                break;
	            case 7:
	                score="full house " + Card.rankAsString(values[1]) + " over " + Card.rankAsString(values[2]);
	                break;
	            case 8:
	                score="four of a kind " + Card.rankAsString(values[1]);
	                break;
	            case 9:
	                score="straight flush " + Card.rankAsString(values[1]) + " high";
	                break;
	        }

	        score= "               " + score;
			System.out.println(score);
	    }

	void removeCard()
	{
		ArrayList<Card> h = new ArrayList<Card>();
		int count = 0;
		
		for(int i=5; i>=0;i--)
		{
			String input = JOptionPane.showInputDialog(null , "Remove Card " + i + "? Input y for Yes or n for No.");

			if(input.equals("y"))
				h.remove(i);
				count ++;
		}
		
		for(int i=0; i<count; i++)
		{
			h.add(Deck.drawFromDeck());
		}
	}

	void displayAll()
	{
		for(int x=0;x<5;x++)
			System.out.println(cards[x]);
	}

	private Card[] cards;
	private int[] values;
	private String suit;
	private String value;
}