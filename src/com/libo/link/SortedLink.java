package com.libo.link;

/**
 * 有序链表
 */
public class SortedLink {
	
	private Link first ;
	
	public SortedLink(){
		first = null ;
	}
	
	
	public void insert(int id , double dd){
		Link newLink = new Link(id, dd);
		Link current = first ;
		Link previous = null ;
		
		while (current != null && id > current.iData) {
			previous = current ;
			current = current.next ;
		}
		
		if(previous == null ){
			first = newLink ;
		}else{
			previous.next = newLink ;
		}
		newLink.next = current ;
	}
	
	public Link remove(){
		Link temp = first ;
		first = first.next ;
		return temp ;
	}
	
	public void displayList(){
		Link currentLink = first;
		while(currentLink != null){
			currentLink.display();
			currentLink = currentLink.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		SortedLink sortedLink = new SortedLink();
		sortedLink.insert(5, 5d);
		sortedLink.insert(7, 7d);
		sortedLink.insert(1, 1d);
		sortedLink.insert(3, 3d);
		sortedLink.insert(2, 2d);
		sortedLink.insert(9, 9d);
		
		sortedLink.displayList();
		
		sortedLink.remove() ;
		
		
		sortedLink.displayList();
		
	}
	
}
