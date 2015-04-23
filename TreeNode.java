public class TreeNode<T>{
    private T data;
    private TreeNode<T> LChild, RChild;

    public T getData(){
	return data;
    }
    public T getLeft(){
	return LChild;
    }
    public T getRight(){
	return RChild;
    }
    public void setData(T d){
	data = d;
    }
    public void setLeft(TreeNode<T> n){
	LChild = n;
    }
    public void setRight(TreeNode<T> n){
	RChild = n
    }
}