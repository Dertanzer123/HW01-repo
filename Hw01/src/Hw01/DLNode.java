package Hw01;

public class DLNode {

	private String name;
	private int score;
	
	private DLNode previous;
	private DLNode next;
	
	public DLNode(String name,int score) 
	{
		this.name=name;
		this.score=score;
		previous=null;
		next=null;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public DLNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLNode previous) {
		this.previous = previous;
	}

	public DLNode getNext() {
		return next;
	}

	public void setNext(DLNode next) {
		this.next = next;
	}
	
	
	
	
}
