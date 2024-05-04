package Hw01;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	int playerbook;
	int compbook;

	boolean flag1;

	String compname;
	String playername;

	DLList namelist;
	String line;
	
	String path="your path";

	game() throws InterruptedException, IOException {

		while (true) {//this big loop is for if you want to play again

		

			compname = "Bob";

			compbook = 0;
			playerbook = 0;

			playerlist = new linkedlist();
			computerlist = new linkedlist();
			tablelist = new linkedlist();
			int card;
			linkedlist cards = new linkedlist();
			for (int i = 0; i < 6; i++) {
				cards.add(0);
			}

			System.out.println("can i take your name");
			System.out.print("  :");
			playername = scanner.next();
			while (playername == null || playername.equals("") || playername.trim().equals("")
					|| playername.trim().equals(null)) {
				System.out.println("you should enter something valid for your name");
				System.out.print("  :");
				playername = scanner.next().trim();
			}

			for (int i = 0; i < 24; i++) {
				while (true) {
					card = rnd.nextInt(6) + 1;
					if ((int) (cards.getelement(card - 1)) < 4) {
						cards.setelement(card - 1, (int) cards.getelement(card - 1) + 1);
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
				if (computerlist.size() == 0 || playerlist.size() == 0) {
					break;
				}
				turnnumber++;
			}
			if (compbook < playerbook) {
				System.out.println(playername + " won wow thats fantastic i'll write your name in my list");
				
				Thread.sleep(2000);
				namelist = new DLList();

				FileReader fr1 = new FileReader(path);
				BufferedReader br1 = new BufferedReader(fr1);
				while ((line = br1.readLine()) != null) {
					namelist.add(line.trim().split(" ")[0], Integer.parseInt(line.trim().split(" ")[1].trim()));
				}
				br1.close();
				fr1.close();
				
				namelist.add(playername, turnnumber);
				namelist.discardExtras();
				System.out.println("yea its done do you wanna see it");
				line = scanner.next().trim();
				if (line.toLowerCase().equals("yes")) {
					namelist.display();
				} else {
					System.out.println("okey then");
				}
				
				
				FileWriter fw1=new FileWriter(path);
				BufferedWriter bw1=new BufferedWriter(fw1);
				
				DLNode temp=namelist.getHead();
				while(temp!=null) 
				{
					bw1.write(temp.getName().trim()+" "+temp.getScore());
					bw1.newLine();
					temp=temp.getNext();
				}
				
				
				
				bw1.close();
				fw1.close();
				

			} else if (compbook == playerbook) {
				System.out.println("that was a good game its stealmate");
			} else {
				System.out.println("sorry dude but our good old " + compname + " is better than you");
			}
			Thread.sleep(1000);
			System.out.println("do you wanna play again");
			line = scanner.next().trim();
			if (line.toLowerCase().equals("yes")) {
				System.out.println("yes my man");
				Thread.sleep(500);
			} else {
				System.out.println("okey then");
				break;
			}
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
		System.out.print(playername + " : ");
		playerlist.display();
		System.out.println("             book : " + playerbook);
		System.out.print("                                             ");

		 displaylowintel(tablelist.size(), '%');//(1)these for hiding computers and table cards if you want to see them you should  comment (1)'s and free(2)'s
		//tablelist.display();//(2)

		System.out.println();
		System.out.print(compname + "    : ");

		 displaylowintel(computerlist.size(), '#');//(1)
		//computerlist.display();//(2)

		System.out.println("             book : " + compbook);
		if (flag1)// when flag1 is true then it mean players turn else it means computers turn
		{

			do {
				System.out.println("you should chose an card that you have in your hand");
				input = Integer.parseInt(scanner.next());
			} while (playerlist.search(input) == -1);
			System.out.println("you chosed : " + input);
			if (computerlist.search(input) != -1) {
				while (computerlist.search(input) != -1) {
					playerlist.add(input);
					computerlist.discardelement(computerlist.search(input));
				}

			} else {
				System.out.println("you go fish");
				System.out.println("you got " + drawcard(true));
				flag1 = false;
				Thread.sleep(500);
			}

			for (int i = 1; i < 7; i++) {
				if (playerlist.checkbook(i, 4)) {
					while (playerlist.search(i) != -1) {
						playerlist.discardelement(playerlist.search(i));
					}
					System.out.println("Book baby " + i + " " + i + " " + i + " " + i);
					playerbook++;
					Thread.sleep(500);
				}
			}

		} else {

			do {
				input = rnd.nextInt(6) + 1;
			} while (computerlist.search(input) == -1);

			System.out.println(compname + " chooses : " + input);
			Thread.sleep(1000);
			if (playerlist.search(input) != -1) {
				System.out.println("you gotta give them");
				Thread.sleep(500);
				while (playerlist.search(input) != -1) {
					computerlist.add(input);
					playerlist.discardelement(playerlist.search(input));
				}
			} else {
				System.out.println(compname + " goes fish");
				if (input == drawcard(false)) {
					System.out.println(compname + " got " + input);
				}
				flag1 = true;

			}
			for (int i = 1; i < 7; i++) {
				if (computerlist.checkbook(i, 4)) {
					while (computerlist.search(i) != -1) {
						computerlist.discardelement(computerlist.search(i));
					}
					System.out.println(compname + " make an " + i + " " + i + " " + i + " " + i);
					compbook++;
				}
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
