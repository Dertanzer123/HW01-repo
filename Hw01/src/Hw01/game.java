package Hw01;

import java.util.Random;

public class game {

	linkedlist playerlist;
	linkedlist computerlist;
	linkedlist tablelist;
	Random rnd=new Random();
	
	int turnnumber;
	
	game()
	{
		playerlist=new linkedlist();
		computerlist=new linkedlist();
		tablelist =new linkedlist();
		int card;
		int[] cards=new int[6];
		
		
		for(int i=0;i<24;i+=0)
		{
			while(true) {
			card=rnd.nextInt(6)+1;
			if(cards[card]<4) 
			{
			cards[card]++;
			tablelist.add(card);
			}
			}
			
		}
		for(int i=0;i<14;i++)
		{
			drawcard(i%2==0);// i think the thing i made here is sooooo cool rn 
			
		}
		
		
		
	}
	public void drawcard(boolean secgec)//if secgec=true then player else if false then computer draws an card
	{
		
		
		int int1=rnd.nextInt(tablelist.size());
		
		if(secgec) 
		{
			playerlist.add(tablelist.getelement(int1));
		}
		else 
		{
			computerlist.add(tablelist.getelement(int1));
		}
		tablelist.discardelement(int1);
	}
	public void display()
	
	{
		System.out.println(turnnumber+"                          Table");
		System.out.print("YoU      : ");
		playerlist.display();
		System.out.print("Computer : ");
		computerlist.display();
		System.out.println("---------------------------------");
	
	}
	
	
	
	
	
	
}
