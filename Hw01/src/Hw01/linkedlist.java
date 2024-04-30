package Hw01;

public class linkedlist {

	private node head;
	
	linkedlist()
	{
		head =null;
	}
	
	public void add(Object data)
	{
		if(head==null) 
		{	
			
			head=new node(data);
		}
		else 
		{
			node temp1=head;
			
			while(temp1.getLink()!=null) 
			{
				temp1=temp1.getLink();
			}
			node newnode= new node(data);
			temp1.setLink(newnode);
		}
	}

	public node getHead() {
		return head;
	}

	public void setHead(node head) {
		this.head = head;
	}
	
}
