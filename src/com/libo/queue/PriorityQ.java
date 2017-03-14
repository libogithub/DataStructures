package com.libo.queue;

/**
 * 优先队列是对队列的进一步抽象，比如五个人排队，其中有一个是老年人，那么老年人就会自动被排到最前面。
 */
public class PriorityQ {
	
	private int maxSize ;
	private int nItems ;
	private long[] queArray ;
	
	public PriorityQ(int s){
		maxSize = s ;
		queArray = new long[maxSize] ;
		nItems = 0 ;
	}
	
	public void insert(long value){
		if(nItems == 0){
			queArray[nItems++] = value ;
		}else{
			int i ;
			for (i = nItems - 1 ; i >= 0; i--) {
				if(queArray[i] < value){
					queArray[i+1] = queArray[i] ;
				}else{
					break ;
				}
			}
			queArray[i+1] = value ;
			nItems ++ ;
		}
	}
	
	public long remove(){
		return queArray[--nItems] ;
	}
	
	public long peekMin(){
		return queArray[nItems-1] ;
	}
	
	public boolean isFull(){
		return (nItems == maxSize) ;
	}
	
	public boolean isEmpty(){
		return (nItems == 0) ;
	}
	
	public static void main(String[] args) {
		PriorityQ priorityQ = new PriorityQ(5);
		priorityQ.insert(40);
		priorityQ.insert(20);
		priorityQ.insert(10);
		priorityQ.insert(60);
		priorityQ.insert(30);
		
		while (!priorityQ.isEmpty()) {
			System.out.print(priorityQ.remove() + " ");
		}
	}

}
