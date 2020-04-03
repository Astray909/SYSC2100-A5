/**
 * 
 */

/**
 * @author Jia Chen Huang
 * @version March 27, 2020
 *
 */
public class BSTDictionary<E, K extends Sortable> implements Dictionary {
	BSTNode<String, SortableString> root;
	BSTNode<String, SortableString> currNode;


	public BSTDictionary()
	{
		root = null;
	}

	/**
	 * 
	 */
	public BSTDictionary(BSTNode<String, SortableString> root) {
		// TODO Auto-generated constructor stub
		this.root = root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Search for note from key
	 * 
	 * @param Sortable key: the key to be searched
	 * @return returns null if not found, return element of node as String if found
	 */
	public Object search(Sortable key) {
		if(currNode != null)
		{
			if(currNode.getKey().compareTo(key) == 0)
			{
				String str = (String) currNode.getElement();
				currNode = root;
				return str;
			}
			else if (key.compareTo(currNode.getKey()) < 0)
			{
				currNode = currNode.getLeft();
				return search(key);
			}
			else
			{
				currNode=currNode.getRight();
				return search(key);
			}
		}
		currNode = root;
		return null;
	}

	@Override
	/**
	 * Insert element to the specific location indicated by the key
	 * 
	 * @param Sortable key: the key that indicates where to be inserted
	 * @param Object element: the element to be inserted
	 */
	public void insert(Sortable key, Object element) {
		// TODO Auto-generated method stub
		BSTNode<String, SortableString> temp = new BSTNode<String,SortableString>((SortableString)key,(String)element,null,null);
		if(root == null)
		{
			root = temp;
			currNode = root;
		}
		else if(temp.getKey().compareTo(currNode.getKey()) < 0)
		{
			if(currNode.getLeft() != null)
			{
				currNode = currNode.getLeft();
				insert(key,element);
			}
			else
			{
				currNode.setLeft(temp);
				currNode = root;
			}
		}
		else if(temp.getKey().compareTo(currNode.getKey()) > 0)
		{
			if(currNode.getRight() != null)
			{
				currNode = currNode.getRight();
				insert(key,element);
			}
			else
			{
				currNode.setRight(temp);
				currNode = root;
			}
		}

	}

	@Override
	/**
	 * delete the node indicated by the key
	 * @param Sortable key: the key that indicates which node to delete
	 */
	public void delete(Sortable key) {
		BSTNode<String,SortableString> parent = null;
		BSTNode<String,SortableString> n = root;
		BSTNode<String,SortableString> temp = null;

		if(key == null)
		{
			System.out.println("The Key is invalid");
			return;//return if key is invalid
		}

		while(n != null)// find the node pointed by key
		{
			if(key.compareTo(n.getKey()) == 0)
			{
				break;
			}
			else if(key.compareTo(n.getKey()) < 0)
			{
				parent = n;
				n = n.getLeft();
			}
			else if(key.compareTo(n.getKey()) > 0)
			{
				parent = n;
				n = n.getRight();
			}
		}

		if(n == null)
		{
			return;
		}

		else if(n.getLeft() == null && n.getRight() == null)
		{
			//has no child, delete n
			n=null;
		}
		else if(n.getLeft() != null && n.getRight() == null)
		{
			if(parent.getRight() == n)//has one left child
			{
				parent.setRight(n.getLeft());
				n = null;
			}
			else
			{
				parent.setLeft(n.getLeft());
				n = null;
			}
		}
		else if(n.getLeft() == null && n.getRight() != null)
		{
			if(parent.getLeft() == n)//has one right child
			{
				parent.setLeft(n.getRight());
				n = null;
			}
			else
			{
				parent.setRight(n.getRight());
				n = null;
			}
		}
		else
		{
			//has two children
			temp = minvalue(n.getRight());
			n = temp;
			n = null;
		}
	}

	/**
	 * find min value of a sub tree
	 * @param node: indicates subtree
	 * @return curr: smallest value
	 */
	public BSTNode<String,SortableString> minvalue(BSTNode<String,SortableString> node)
	{
		BSTNode<String,SortableString> curr = node;
		while(curr.getLeft()!=null)
		{
			curr = curr.getLeft();
		}
		return curr;
	}

	@Override
	public void printTree() {
		// TODO Auto-generated method stub

	}

	@Override
	public int depth() {
		// TODO Auto-generated method stub
		return 0;
	}

}
