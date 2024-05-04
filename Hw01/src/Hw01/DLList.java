package Hw01;

public class DLList {

	private DLNode head;
	private DLNode tail;

	public DLList() {
		head = null;
		tail = null;
	}

	public void add(String name, int score) {
		DLNode newnode = new DLNode(name, score);
		if (head == null) {

			head = newnode;
			tail = newnode;
		} else {
			

			if(score<head.getScore()) 
			{
				newnode.setNext(head);
				head.setPrevious(newnode);
				head=newnode;
			}
			else 
			{DLNode temp1 = head;
			
			while(temp1.getNext()!=null&&score>temp1.getNext().getScore())
			{
				temp1=temp1.getNext();
			}
			newnode.setPrevious(temp1);
			newnode.setNext(temp1.getNext());
				if(temp1.getNext()==null) 
				{
					tail=newnode;
				}
				else 
				{
					temp1.getNext().setPrevious(newnode);
				}
				temp1.setNext(newnode);
				
			}
		}

	}

	public DLNode getHead() {
		return head;
	}

	public void setHead(DLNode head) {
		this.head = head;
	}

	public DLNode getTail() {
		return tail;
	}

	public void setTail(DLNode tail) {
		this.tail = tail;
	}

	public void discardExtras() {
		DLNode temp = head;
		for (int i = 0; i < 9; i++) {

			if (temp == null) {
				break;
			}
			temp = temp.getNext();
		}
		if (temp != null && temp.getNext() != null) {
			temp.setNext(null);
			tail = temp;
		}
	}

	public void display() {
		DLNode temp = head;

		while (temp != null) {
			System.out.println(temp.getName() + " " + temp.getScore());
			temp = temp.getNext();
		}

	}

}
