package com.libo.binaryTree;

public class Tree {
	
	private Node root ;
	
	public Node find(int key){
		Node current = root ;
		while (current.iData != key) {
			if(key < current.iData){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if(current == null){
				return null ;
			}
		}
		return current ;
	}
	
	/**
	 * 新插入的节点肯定在叶子结点
	 */
	public void insert(int id ,double dd){
		Node newNode = new Node(id, dd);
		if(root == null){
			root = newNode ;
		}else{
			Node current = root ;
			Node parent ;
			while (true) {
				parent = current ;
				if(id < current.iData){
					current = current.leftChild ;
					if(current == null){
						parent.leftChild = newNode ;
						return ;
					}
				}else{
					current = current.rightChild ;
					if(current == null){
						parent.rightChild = newNode ;
						return ;
					}
				}
			}
		}
	}
	
	/**
	 * 中序遍历树,中序便利会让所有关键字按照升序排列
	 */
	public void inOrder(Node localRoot){
		if(localRoot != null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public Node minNode(){
		Node current,last = null;
		current = root;
		while (current != null) {
			last = current ;
			current = current.leftChild;
			
		}
		return last;
	}
	
	public Node maxNode(){
		Node current,last = null;
		current = root;
		while (current != null) {
			last = current ;
			current = current.rightChild;
			
		}
		return last;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
