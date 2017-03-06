package com.libo.array;


/**
 * 有序数组的优点的缺点
 * 优点：查找速度比无顺序数组要快很多
 * 缺点：和普通数组一样插入操作需要移动所有后面的数据来腾出存储空间 
 * 
 * 有序数组在查找非常频繁的情况下很有用，但若是插入和删除频繁时则无法高效工作。
 * 
 * 注意学习二分查找算法
 */
public class OrderArray {

	private long[] a ;
	private int nElems ;
	
	public OrderArray(int max) {
		a = new long[max];
		nElems = 0 ;
	}
	
	/**
	 * 使用二分查找法，查找数组中的数据
	 */
	public int find(long searchKey){
		int lowerBound = 0 ;
		int upperBound = nElems - 1 ;
		int curIndex ;
		while(true){
			curIndex = (lowerBound + upperBound) / 2 ;
			if(a[curIndex] == searchKey){ 
				return curIndex ;
			}else if(lowerBound > upperBound){ //最后一次比较lower会等于upper并且等于curindex,在进行一次的话lower会大于upper
				return nElems ;	
			}else{
				if(a[curIndex] < searchKey ){
					lowerBound = curIndex + 1;
				}else if(a[curIndex] > searchKey ){
					upperBound = curIndex - 1;
				}
			}
		}
	}
	
	/**
	 * 插入前需要判断数组是否已经满
	 */
	public void insert(long value){
		int j ;
		for (j = 0; j < nElems; j++) {
			if(a[j] > value){
				break;
			}
		}
		for (int k = nElems; k > j; k--) {
			a[k] = a[k-1];
		}
		a[j] = value ;
		nElems++;
	}
	
	/**
	 * 插入前需要判断数组是否已经满
	 */
	public boolean delete(long value){
		int j = find(value); //注意此处
		if(j == nElems){
			return false ;
		}else{
			for (int i = j; i < nElems; i++) {
				a[i] = a[i+1];
			}
			nElems--;
			return true;
		}
	}
	
	public void display(){
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		OrderArray orderArray = new OrderArray(10);
		orderArray.insert(4);
		orderArray.insert(2);
		orderArray.insert(8);
		orderArray.insert(90);
		orderArray.insert(9);
		
		orderArray.display();
		
		System.out.println("index "+orderArray.find(8));
		
		
		orderArray.delete(90);
		
		orderArray.display();
	}
	
	
}
