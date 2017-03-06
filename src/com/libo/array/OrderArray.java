package com.libo.array;


/**
 * ����������ŵ��ȱ��
 * �ŵ㣺�����ٶȱ���˳������Ҫ��ܶ�
 * ȱ�㣺����ͨ����һ�����������Ҫ�ƶ����к�����������ڳ��洢�ռ� 
 * 
 * ���������ڲ��ҷǳ�Ƶ��������º����ã������ǲ����ɾ��Ƶ��ʱ���޷���Ч������
 * 
 * ע��ѧϰ���ֲ����㷨
 */
public class OrderArray {

	private long[] a ;
	private int nElems ;
	
	public OrderArray(int max) {
		a = new long[max];
		nElems = 0 ;
	}
	
	/**
	 * ʹ�ö��ֲ��ҷ������������е�����
	 */
	public int find(long searchKey){
		int lowerBound = 0 ;
		int upperBound = nElems - 1 ;
		int curIndex ;
		while(true){
			curIndex = (lowerBound + upperBound) / 2 ;
			if(a[curIndex] == searchKey){ 
				return curIndex ;
			}else if(lowerBound > upperBound){ //���һ�αȽ�lower�����upper���ҵ���curindex,�ڽ���һ�εĻ�lower�����upper
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
	 * ����ǰ��Ҫ�ж������Ƿ��Ѿ���
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
	 * ����ǰ��Ҫ�ж������Ƿ��Ѿ���
	 */
	public boolean delete(long value){
		int j = find(value); //ע��˴�
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
