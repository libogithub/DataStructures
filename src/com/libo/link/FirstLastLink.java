package com.libo.link;

/**
 * 
 * 双端链表，注意是不是双向链表
 * 双端列表只能有助于查找最后一个元素，对于删除最后一个元素依然没有办法，
 * 因为没有保存倒数第二个元素(双向链表解决了这个问题)。
 * 
 * 双端链表可以实现队列
 */
public class FirstLastLink {
	private Link first ;
	private Link last ;
	
	public FirstLastLink() {
		first = null ;
		last = null ;
	}
	
	public boolean isEmpty(){
		return first == null ;
	}
	
	public void insertFirst(int id , Double dd){
		Link newLink = new Link(id, dd);
		if(isEmpty()){ //注意当插入第一个节点是，需要把尾部的节点也指向第一个节点
			last = newLink ;
		}
		newLink.next = first ;
		first = newLink ;
	}
	
	public void insertLast(int id , Double dd){
		Link newLink = new Link(id, dd);
		if(isEmpty()){
			first = newLink ;
		}else{
			last.next = newLink ;
		}
		last = newLink ;
	}
	
	public double deleteFirst(){
		double temp = first.dData ;
		if(first.next == null){ //只存在一个节点时候需要把尾部指向null，因为删除掉以后链表中就没有数据了
			last = null ;
		}
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
		FirstLastLink firstLastLink = new FirstLastLink();
		firstLastLink.insertFirst(0, 0d);
		firstLastLink.insertFirst(1, 1d);
		firstLastLink.insertFirst(2, 2d);
		firstLastLink.insertFirst(3, 3d);
		
		firstLastLink.insertLast(7, 7d);
		firstLastLink.insertLast(8, 8d);
		firstLastLink.insertLast(9, 9d);
		firstLastLink.insertLast(10, 10d);
		
		firstLastLink.displayList();
	}
	
	
}
