package com.libo.stack.link;

/**
 * 连接点一般包含节点数据和指向其他节点的引用
 */
public class Link {

	public int iData ;
	public double dData ;
	public Link next ;
	
	public Link(int i , double d){
		this.iData = i ;
		this.dData = d ;
		next = null ;
	}
	
	public void display(){
		System.out.println("{" + iData + "," + dData +"}");
	}
}
