package Hw01;

public class linkedlist {

	private node head;

	linkedlist() {
		head = null;
	}

	public void add(Object data) {
		if (head == null) {

			head = new node(data);
		} else {
			node temp1 = head;

			while (temp1.getLink() != null) {
				temp1 = temp1.getLink();
			}
			node newnode = new node(data);
			temp1.setLink(newnode);
		}
	}
	public int search(Object data)
	{
		node temp=head;
		int index=0;
		while(temp!=null) 
		{
			if(temp.getData().equals(data)) 
			{
				return index;
			}
			temp=temp.getLink();
			index++;
		}
		return -1;
		
		
	}
	
	public void setelement(int index,Object data) 
	{
		node temp=head;
		
		while(temp!=null&&index>0)
		{
			index--;
			temp=temp.getLink();
		}
		
		temp.setData(data);
	}
	public boolean discardelement(int index) {

		if (head == null) {
			return false;
		}
		if (index == 0) {
			head = head.getLink();
			return true;
		}

		node temp = head;
		for (int i = 1; i < index; i++) {
			if (temp == null) {
				return false;
			}
			temp = temp.getLink();
		}
		if (temp == null || temp.getLink() == null) {
			return false;
		}
		if (temp.getLink().getLink() != null) {
			temp.setLink(temp.getLink().getLink());
		} else {
			temp.setLink(null);
		}
		return true;
	}
	public Object getelement(int index)
	{
		node temp=head;
		for (int i = 0; i < index; i++) {
			if (temp == null) {
				System.out.println("index is out of bounds");
				return false;
			}
			temp = temp.getLink();
		}
		if (temp == null) {
			System.out.println("index is out of bounds");
			return false;
		}
		return temp.getData();
	}
	public void display()
	
	{
		node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.getData()+" ");
			temp=temp.getLink();
		}
		
	}
	public boolean checkbook(Object data,int size)
	{
		node temp1= head;
		int count=0;
		while(temp1!=null)
		{
			if(temp1.getData().equals(data))
			{
				count++;
			}
			temp1=temp1.getLink();
			
		}
		if (count==size)
		{
			return true;
		}
		return false;
		
	}
	public int size() {
		int size = 0;
		node temp = head;
		while (temp != null) {
			temp = temp.getLink();
			size++;
		}
		return size;
	}

	public node getHead() {
		return head;
	}

	public void setHead(node head) {
		this.head = head;
	}

}
