package com.libo.stack.array;

public class StackX {
	
	private int maxSize ;
	private long[] stackArray ;
	private int top ;
	
	public StackX(int s) {
		maxSize = s ;
		stackArray = new long[maxSize];
		top = -1 ;
	}
	
	public void push(long value){
		stackArray[++top] = value ;
	}

	public long pop(){
		return stackArray[top--] ;
	}
	
	public long peek(){
		return stackArray[top] ;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == maxSize - 1);
	}
	
	public static void main(String[] args) {
		StackX stack = new StackX(10);
		stack.push(10l);
		stack.push(40l);
		stack.push(20l);
		stack.push(90l);
		stack.push(800);
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
	}
}
