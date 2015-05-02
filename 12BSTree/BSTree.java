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

    private int determineDirection(BSTreeNode<T> curr){
	//An attempt to balance the tree.
	//It'll look for an appropriate replacement on the side with
	//the greatest height
	int direction = -1;
	if(getHeight(curr.getLeft())>getHeight(curr.getRight())){
	    //this means go right first
	    if(curr.getLeft()!=null){
		direction = 0;
	    }
	}else{
	    //this means go left first
	    direction = 1;
	}
	return direction;
    }

    private BSTreeNode<T> findReplacement(int direction, BSTreeNode<T> curr){
	if(direction==-1){
	    if(isLeaf(curr)){
		return null;
	    }
	    if(determineDirection(curr)==0){
		return findReplacement(0,curr.getLeft());
	    }else{
		return findReplacement(1,curr.getRight());
	    }  
	}
	if(!isLeaf(curr)){
	    if(direction==0){
		return findReplacement(direction,curr.getRight());
	    }else{
		return findReplacement(direction,curr.getLeft());
	    }
	}else{
	    return curr;
	}
    }
    private BSTreeNode<T> findReplaced(BSTreeNode<T> curr, T c){
	if(curr.getData().compareTo(c)==0){
	    return curr;
	}else if(c.compareTo(curr.getData())<0){
	    return findReplaced(curr.getLeft(),c);
	}else{
	    return findReplaced(curr.getRight(),c);
	}
    }

    private BSTreeNode<T> findReplacedPredecessor(BSTreeNode<T> curr, T c){
	if(curr.getLeft().getData().compareTo(c)==0 || curr.getRight().getData().compareTo(c)==0){
	    return curr;
	}else if(c.compareTo(curr.getData())<0){
	    return findReplacedPredecessor(curr.getLeft(),c);
	}else{
	    return findReplacedPredecessor(curr.getRight(),c);
	}
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
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	//The node where c is found
	BSTreeNode<T> toReplace=findReplaced(curr,c);
	//The node meant to replace c
	BSTreeNode<T> replacement = findReplacement(-1,toReplace);
	if(c==root){
	    root=null;
	}
	//c's parent
	BSTreeNode<T> predecessor = findReplacedPredecessor(curr,c);
	//replaces c with its replacement
	if(predecessor.getLeft().getData().compareTo(c)==0){
	    predecessor.setLeft(replacement);
	}else{
	    predecessor.setRight(replacement);
	}
	//removes the node used to replace c
	if(replacement!=null){
	    //the replacement's parent
	    predecessor = findReplacedPredecessor(curr,replacement.getData());
	    //replaces the replacement with its replacement (null)
	    if(predecessor.getLeft().getData().compareTo(c)==0){
		predecessor.setLeft(replacement);
	    }else{
		predecessor.setRight(replacement);
	    }
	}
	//System.out.println("returning root");
	return root;
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

   
    public static void main( String[] args ) {
	BSTree<Integer> tree = new BSTree<Integer>();
	tree.add(new Integer(50));
	System.out.println(tree.toString());
	tree.add(new Integer(20));
	System.out.println(tree.toString());
	tree.add(new Integer(70));
	System.out.println(tree.toString());
	tree.add(new Integer(10));
	System.out.println(tree.toString());
	tree.add(new Integer(33));
	System.out.println(tree.toString());
	tree.add(new Integer(93));
	System.out.println(tree.toString());
	tree.add(new Integer(60));
	System.out.println(tree.toString());
	tree.add(new Integer(71));
	System.out.println(tree.toString());

	BSTree<Integer> tree50 = tree;
	BSTree<Integer> tree20 = tree;
	BSTree<Integer> tree10 = tree;
	BSTree<Integer> tree33 = tree;
	BSTree<Integer> tree70 = tree;
	BSTree<Integer> tree60 = tree;
	BSTree<Integer> tree93 = tree;
	BSTree<Integer> tree71 = tree;

	System.out.println("removing...");
	//tree50.remove(new Integer(50));
	//System.out.println(tree50.toString());
	//tree20.remove(new Integer(20));
	//System.out.println(tree20.toString());
	//tree10.remove(new Integer(10));
	//System.out.println(tree10.toString());
	//tree33.remove(new Integer(33));
	//System.out.println(tree33.toString());
	//tree70.remove(new Integer(70));
	//System.out.println(tree70.toString());
	//tree60.remove(new Integer(60));
	//System.out.println(tree60.toString());
	//tree93.remove(new Integer(93));
	//System.out.println(tree93.toString());
	tree71.remove(new Integer(71));
	System.out.println(tree71.toString());

    }

}
