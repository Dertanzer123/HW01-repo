package Hw01;

public class node {

	private node link;
	private Object data;
	
	
	node(Object data)
	{
		this.data=data;
		link=null;
	}


	public node getLink() {
		return link;
	}


	public void setLink(node link) {
		this.link = link;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	
	
}
