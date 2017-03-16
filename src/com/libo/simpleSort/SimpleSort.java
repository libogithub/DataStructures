package com.libo.simpleSort;

public class SimpleSort {
	
	private long[] a ;
	private int nElems ;
	
	public SimpleSort(int max){
		a = new long[max];
		nElems = 0 ;
	}
	
	public void insert(long value){
		a[nElems] = value ;
		nElems++;
	}
	
	public void display(){
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	/**
	 * 冒泡排序算法
	 */
	public void bubbleSort(){
		for (int out = nElems - 1; out > 0 ; out--) {
			for (int in = 0; in < out; in++) {
				if(a[in] > a[in+1]){
					swap(in, in+1);
				}
			}
		}
	}
	
	/**
	 * 选择排序，选择排序实际上是对冒泡排序做了一个简单的优化，减少了数据的交换次数，比较次数不变
	 * 1：外层循环每次记录最左边的数据从下标0开始
	 * 2：内层循环从外层循环的下标加1开始，每次内存循环结束都是获得最小数据的下标
	 * 3：内层循环完成后与外层循环的下标进行交换
	 */
	public void selectSort(){
		int out, in ,min ;
		for (out = 0; out < nElems - 1 ; out++) {
			min = out ;
			for (in = out + 1; in < nElems; in++) {
				if(a[in] < a[min]){
					min = in ;
				}
			}
			swap(out, min);
		}
	}
	
	public void insertSort(){
		int out , in ;
		for (out = 1; out < nElems; out++) {
			long temp = a[out];
			in = out ;
			while(in > 0 && a[in -1] >= temp ){
				a[in] = a[in -1] ;
				--in ;
			}
			a[in] = temp;
		}
	}
	
	public void swap(int i , int j){
		long temp = a[i] ;
		a[i] = a[j];
		a[j] = temp ;
	}
	

	public static void main(String[] args) {
		SimpleSort simpleSort = new SimpleSort(10);
		simpleSort.insert(8);
		simpleSort.insert(1);
		simpleSort.insert(4);
		simpleSort.insert(7);
		simpleSort.insert(5);
		
		simpleSort.display();
		System.out.println();
//		simpleSort.bubbleSort();
//		simpleSort.selectSort();
		simpleSort.insertSort();
		
		simpleSort.display();
	}

}
