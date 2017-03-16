package com.libo.link;

/**
 * 链表比数组优越的很重要的一点就是，链表需要多少内存就可以分配内存，并且可以扩展到所有可用的内存
 * 数组的大小在它创建时候已经固定。而且数据需要在内存中创建一个连续的内存空间。
 */
public class LinkList {
	
	private Link first ;
	
	public LinkList(){
		first = null ;
	}
	
	public boolean isEmpty(){
		return (first == null) ;
	}
	
	public void insertFirst(int id , Double dd){
		Link newLink = new Link(id, dd);
		newLink.next = first ;
		first = newLink ;
	}
	
	public Link deleteFirst(){
		Link temp = first ;
		first = first.next;
		return temp ;
	}
	
	
	public Link find(int key){
		Link currentLink = first;
		while(currentLink.iData != key){
			if(currentLink.next == null){
				return null ;
			}else{
				currentLink = currentLink.next;
			}
		}
		return currentLink ;
	}
	
	public Link deleteLink(int key){
		Link current = first ;
		Link previos = null ; 
		while(current.iData != key){
			if(current.next == null){
				return null ;
			}else{
				previos = current ;
				current = current.next ;
			}
		}
		if(current == first){ //当地一个节点就是要删除的key时
			first = first.next ;
		}else{
			previos.next = current.next ;
		}
		return current ;
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
		LinkList linkList = new LinkList();
		linkList.insertFirst(1, 1d);
		linkList.insertFirst(2, 2d);
		linkList.insertFirst(3, 3d);
		linkList.insertFirst(4, 4d);
		linkList.insertFirst(5, 5d);
		
		Link f = linkList.find(3);
		if(f != null){
			System.out.println("找到节点");
		}else{
			System.out.println("未找到节点");
		}
		
		linkList.displayList();
		
		linkList.deleteFirst();
		linkList.displayList();
		
		linkList.deleteLink(2);
		linkList.displayList();
		
	}

}
