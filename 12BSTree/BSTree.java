import java.io.*;
import java.util.*;
import java.lang.Math;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if(isEmpty()){
	    root = t;
	    //System.out.println("here0");
	    return t;
	}
	if(curr==null){
	    //System.out.println("here1");
	    return t;
	}else if(curr!=null){
	    if(t.compareTo(curr)<0){//if value to add is less than current
		//System.out.println("here2");
		curr.setLeft(add(curr.getLeft(),t));
	    }else{//if value to add is greater than current
		//System.out.println("here3");
		curr.setRight(add(curr.getRight(),t));
	    }
	    //System.out.println("here4");
	    return curr;
	}
	//System.out.println("here5");
	return root;
    }


    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ){
        //find c
	boolean found = false;
	BSTreeNode<T> current = curr;
	while(!found){
	    if(current.getLeft()!=null){
		if(c.equals(current.getLeft().getData()) && isLeaf(current.getLeft())){
		    current.setLeft(null);
		    found = true;
		}
	    }
	    if(current.getRight()!=null){
		if(c.equals(current.getRight().getData()) && isLeaf(current.getLeft())){
		    current.setRight(null);
		    found = true;
		}
	    }
	    if(c.equals(current.getData())){
		current = replaceRoot(current);
		found = true;
	    }else if(c.compareTo(current.getData())<0){
		current = current.getLeft();
	    }else{
		current = current.getRight();
	    }
	}
	return root;
    }
    private BSTreeNode<T> replaceRoot(BSTreeNode<T> rt){
	if(isLeaf(rt)){
	    System.out.println("here");
	    return null;
	}else if(rt.getRight()==null){
	    return rt.getLeft();
	}else if(rt.getLeft()==null){
	    return rt.getRight();
	}else{
	    boolean goLeft = getHeight(rt.getLeft())>getHeight(rt.getRight());
	    BSTreeNode<T> replacement = null;
	    BSTreeNode<T> current = rt;
	    int index = 0;
	    if(goLeft){
		index = getHeight(rt.getLeft());
	    }else{
		index = getHeight(rt.getRight());
	    }
	    for(int i=0; i<index; i++){
		if(current==null){
		    rt.setData(replacement.getData());
		    return rt;
		}else if(isLeaf(current)){
		    replacement = current;
		}else{
		    int leftDist = 0;
		    int rightDist = 0;
		    if(current.getRight()==null){
			leftDist = current.getLeft().getData().compareTo(rt.getData())*-1;
			rightDist = leftDist+1;
		    }else if(current.getLeft()==null){
			rightDist = current.getRight().getData().compareTo(rt.getData());
			leftDist = rightDist+1;
		    }else{
			leftDist = current.getLeft().getData().compareTo(rt.getData())*-1;
			rightDist = current.getRight().getData().compareTo(rt.getData());
		    }
		    if(leftDist<rightDist || (i==0 && goLeft)){
			if(isLeaf(current.getLeft())){
			    replacement = current.getLeft();
			    current.setLeft(null);
			}
			current = current.getLeft();
		    }else{
			if(isLeaf(current.getRight())){
			    replacement = current.getRight();
			    current.setRight(null);
			}
			current = current.getRight();
		    }
		}
	    }
	    rt.setData(replacement.getData());
	    return rt;
	}
    }

    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    /**

     * stolen from: Dennis Yatunin

     * (no not really stolen from, donated by)

     */


    public int getHeight(){
	return getHeight(root);
    }

    public int getHeightTest(){
	return getHeight(root.getLeft());
    }

    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
	}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }

    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.
      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 

		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * 

		       Math.pow(2, height - targetLevel + 1) - 

		       wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
		
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
	return result;
    }
   
    public static BSTree<Integer> testTree(){
	BSTree<Integer> tree = new BSTree<Integer>();
	tree.add(new Integer(50));
	tree.add(new Integer(20));
	tree.add(new Integer(70));
	tree.add(new Integer(10));
	tree.add(new Integer(33));
	tree.add(new Integer(93));
	tree.add(new Integer(60));
	tree.add(new Integer(71));
	return tree;
    }

    public static void main( String[] args ) {
	BSTree<Integer> tree50 = testTree();
	BSTree<Integer> tree20 = testTree();
	BSTree<Integer> tree10 = testTree();
	BSTree<Integer> tree33 = testTree();
	BSTree<Integer> tree70 = testTree();
	BSTree<Integer> tree60 = testTree();
	BSTree<Integer> tree93 = testTree();
	BSTree<Integer> tree71 = testTree();

	System.out.println(tree50);

	System.out.println("removing 50");
	tree50.remove(new Integer(50));
	System.out.println(tree50.toString());

	System.out.println("removing 20");
	tree20.remove(new Integer(20));
	System.out.println(tree20.toString());

	System.out.println("removing 10");
	tree10.remove(new Integer(10));
	System.out.println(tree10.toString());

	System.out.println("removing 33");
	tree33.remove(new Integer(33));
	System.out.println(tree33.toString());

	System.out.println("removing 70");
	tree70.remove(new Integer(70));
	System.out.println(tree70.toString());

	System.out.println("removing 60");
	tree60.remove(new Integer(60));
	System.out.println(tree60.toString());

	System.out.println("removing 93");
	tree93.remove(new Integer(93));
	System.out.println(tree93.toString());

	System.out.println("removing 71");
	tree71.remove(new Integer(71));
	System.out.println(tree71.toString());

    }

}
