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
			DLNode temp1 = head;
			while (temp1.getNext() != null && temp1.getScore() > score) {
				temp1 = temp1.getNext();
			}
			if (temp1.getScore() > score)// means tail
			{
				temp1.setNext(newnode);
				newnode.setPrevious(temp1);
				tail = newnode;
			} else // means in between
			{
				if (temp1.getNext() != null) {
					temp1.getNext().setPrevious(newnode);
					newnode.setNext(temp1.getNext());
				}
				temp1.setNext(newnode);
				newnode.setPrevious(temp1);
			
			}

		}

	}
	

}
