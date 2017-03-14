package com.libo.queue;

public class Queue {

	private int maxSize ;
	private long[] queArray ;
	private int rear ;
	private int front ;
	private int nItems ;
	
	public Queue(int s){
		maxSize = s ;
		queArray = new long[maxSize] ;
		nItems = 0 ;
		rear = -1 ;
		front = 0 ;
	}
	
	/**
	 * 插入时是从队列尾部插入，插入前需要判断队列是否已经满了，如果没有满就从头部插入
	 */
	public void insert(long v){
		if(rear == maxSize - 1){
			rear = -1 ;
		}
		queArray[++rear] = v ;
		nItems ++ ;
	}
	
	/**
	 * 移除是从头部移除，因此在头部下标已经到达数组末端时，是需要重新从头部开始移除
	 */
	public long remove(){
		long temp = queArray[front++];
		if(front == maxSize){
			front = 0 ;
		}
		nItems -- ;
		return temp;
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isFull(){
		return (nItems == maxSize) ;
	}
	
	public boolean isEmpty(){
		return (nItems == 0) ;
	}
	
	public int size(){
		return nItems ;
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		while(!queue.isEmpty()){
			System.out.println(queue.remove()+"");
		}
	}
	
}
