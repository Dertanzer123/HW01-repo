package Hw01;

import java.util.Random;
import java.util.Scanner;

public class game {

	linkedlist playerlist;
	linkedlist computerlist;
	linkedlist tablelist;
	Random rnd = new Random();

	int turnnumber;

	Scanner scanner = new Scanner(System.in);


	int input;
	

	boolean flag1;

	String compname;
	
	game() throws InterruptedException {

		compname="Bob";
		playerlist = new linkedlist();
		computerlist = new linkedlist();
		tablelist = new linkedlist();
		int card;
		int[] cards = new int[6];
		for (int i = 0; i < 6; i++) {
			cards[i] = 0;
		}

		for (int i = 0; i < 24; i++) {
			while (true) {
				card = rnd.nextInt(6) + 1;
				if (cards[card - 1] < 4) {
					cards[card - 1]++;
					tablelist.add(card);
					break;
				}
			}

		}

		for (int i = 0; i < 14; i++) {
			drawcard(i % 2 == 0);// i think the thing i made here is sooooo cool rn

		}

		turnnumber = 1;

		flag1 = true;

		while (true) {
			display();

			turnnumber++;
		}

	}

	public int drawcard(boolean secgec)// if secgec=true then player else if false then computer draws an card
	{

		int int1 = rnd.nextInt(tablelist.size());

		int out;

		if (secgec) {
			playerlist.add(tablelist.getelement(int1));
		} else {
			computerlist.add(tablelist.getelement(int1));
		}
		out = (int) tablelist.getelement(int1);
		tablelist.discardelement(int1);
		return out;
	}

	public void display() throws InterruptedException

	{
		System.out.println("Turn : " + turnnumber + "                          Table");
		System.out.print("YoU      : ");
		playerlist.display();
		System.out.println();
		System.out.print("                                    ");

		// displaylowintel(tablelist.size(), '%');
		tablelist.display();

		System.out.println();
		System.out.print(compname+"    : ");

		// displaylowintel(computerlist.size(), '#');
		computerlist.display();

		System.out.println();
		if(flag1)//when flag1 is true then it mean players turn else it means computers turn
		{
		System.out.println("you should chose an card");
		input =Integer.parseInt(scanner.next()) ;
		System.out.println("you chosed : " + input);
		if (computerlist.search(input) != -1) {
			while (computerlist.search(input) != -1) {
				playerlist.add(input);
				computerlist.discardelement(computerlist.search(input));
			}
		} else {
			System.out.println("you go fish");
			System.out.println("you got " + drawcard(true));
			flag1=false;
		}
		}
		else 
		{
			input =rnd.nextInt(6)+1;
			
			System.out.println(compname+" chooses : "+input);
			Thread.sleep(1000);
			if(playerlist.search(input)!=-1) 
			{
				System.out.println("you gotta give them");
				Thread.sleep(500);
				while(playerlist.search(input)!=-1) 
				{
					computerlist.add(input);
					playerlist.discardelement(playerlist.search(input));
				}
			}
			else 
			{
				System.out.println(compname+" goes fish");
				if(input==drawcard(false)) 
				{
					System.out.println(compname+" got "+input);
				}
				flag1=true;
				
			}
			
			
		}
		System.out.println("---------------------------------");

	}

	public void displaylowintel(int size, char symbol) {

		for (int i = size; i > 0; i--) {
			System.out.print(symbol + " ");
		}
	}

}
