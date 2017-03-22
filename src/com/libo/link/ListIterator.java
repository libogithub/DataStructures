package com.libo.link;

public class ListIterator {
	
	private Link current ;
	private Link previous ;
	private LinkList ourList ;

	public ListIterator(LinkList list) {
		ourList = list ;
		reset();
	}

	public void reset() {
		current =  ourList.getFirst();
		previous = null ;
	}
	
	public boolean atEnd(){
		return current.next == null ;
	}
	
	public Link getCurrent(){
		return current ;
	}
	
	public void nextLink(){
		previous = current ;
		current = current.next ;
	}
	
	public void insertAfter(int id ,long dd){
		Link newLink = new Link(id, dd);
		if(ourList.isEmpty()){
			ourList.setFirst(newLink);
			current = newLink ;
		}else{
			newLink.next = current.next;
			current.next = newLink ;
			nextLink();
		}
	}
	
	public void insertBefore(int id ,long dd){
		Link newLink = new Link(id, dd);
		if(previous == null){
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);
			reset();
		}else{
			newLink.next = previous.next ;
			previous.next = newLink ;
			current = newLink ;
		}
	}

}
