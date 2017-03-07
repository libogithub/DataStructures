package com.libo.array;

/**
 * 数组基本操作
 */
public class HighArray {

	private long[] a ;
	private int nElems ;
	
	public HighArray(int max) {
		a = new long[max];
		nElems = 0 ;
	}
	
	public boolean find(long searchKey){
		int i ;
		for (i = 0; i < nElems; i++) {
			if(a[i] == searchKey){
				break;
			}
		}
		if(i == nElems){
			return false ;
		}else{
			return true ;
		}
	}
	
	public void insert(long value){
		a[nElems++] = value ;
	}
	
	public boolean delete(long value){
		int i ;
		for (i = 0; i < nElems; i++) {
			if(a[i] == value){
				break;
			}
		}
		if(i == nElems){
			return false ;
		}else{
			for (int j = i; j < nElems;j++ ) {
				a[j] = a[j+1];
			}
			nElems-- ;
			return true ;
		}
	}
	
	public void display(){
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	
	public static void main(String[] args) {
		HighArray highArray = new HighArray(10);
		highArray.insert(1);
		highArray.insert(2);
		highArray.insert(3);
		highArray.insert(4);
		
		highArray.display();
		
		System.out.println();
		
		if(highArray.find(2)){
			System.out.println("Found "+ 2);
		}else{
			System.out.println("Can't Found "+ 2);
		}
		
		highArray.delete(3);
		
		highArray.display();
	}
	
}
