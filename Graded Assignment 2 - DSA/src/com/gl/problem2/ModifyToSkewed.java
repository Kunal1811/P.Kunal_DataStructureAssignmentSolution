package com.gl.problem2;


public class ModifyToSkewed {
	static Node root;
	
	static Node headNode = null;
	static Node prevNode = null;
	
	
	//Node class to define and a parametrized constructor to initialize each node
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	
	/*static void findNewRoot(Node root) {
		if(root==null)
			function(root);
		findNewRoot(root.left); 
		findNewRoot(root.right);
		
	}
	
	static void function(Node newRoot) {
		Node root2 = new Node(newRoot);
	}
	*/
	
	static void convertTree(Node root)
	{
	    // Base Case
	    if (root==null)
	        return;
	 
	    //System.out.println("going left of: "+root.data);
	    convertTree(root.left);
	    
	 
	    Node rightNode = root.right;
	    
	   /*
	    *try {
		*    System.out.println("righNode is: "+rightNode.data);
	    *}
	    *catch(Exception e) {
	    *	System.out.println("0");
	    *}
	    *
	    *System.out.println("righNode is: "+rightNode.data);
	    */
	    
	    // Initializes head of new skewed tree as the leftmost node in the BST
	    if (headNode == null)
	    {
	        headNode = root;
	        root.left = null;
	        prevNode = root;
	        
	        /*System.out.println("Current headnode is: "+headNode.data);
	         * System.out.println("Current prevnode is: "+prevNode.data);
	         */
	    }
	    else
	    {
	    	//Attaches the successor node to the right of the new root node
	        prevNode.right = root;
	        root.left = null;
	        prevNode = root;
	        
	        /*System.out.println("Current headnode is: "+headNode.data);
	         * System.out.println("Current prevnode is: "+prevNode.data);
	         */
	       
	    }
	 
	    //System.out.println("going right of: "+root.data);
	    convertTree(rightNode);
	    
	}
	
	
	static void display(Node root) {
		if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        display(root.right);  
	}
	
	public static void main(String[] args) {
		//ModifyToSkewed tree = new ModifyToSkewed();
		
		//Hardcoding tree's node values
		root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(10);
		root.right = new Node(60);
		root.right.left = new Node(55);
		
		convertTree(root);
		
		System.out.println("The tree after being skewed is as follow: ");
		display(headNode);
		//inorder(root);
		
	}

}
