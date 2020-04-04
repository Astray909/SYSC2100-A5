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
			if (key.compareTo(currNode.getKey()) < 0)
			{
				currNode = currNode.getLeft();
				return search(key);
			}
			else if (key.compareTo(currNode.getKey()) > 0)
			{
				currNode=currNode.getRight();
				return search(key);
			}
			else
			{
				String str = (String) currNode.getElement();
				currNode = root;
				return str;
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

		//search the corresponding space to insert the node
		if (key.compareTo(currNode.getKey()) < 0)
		{
			if (currNode.getLeft() != null)
			{
				currNode = currNode.getLeft();
				insert(key, element);
			}
			else if(currNode.getLeft() == null)
			{
				currNode.setLeft(temp);
				currNode = root;
			}
		}
		else if (key.compareTo(currNode.getKey()) > 0)
		{
			if (currNode.getRight() != null)
			{
				currNode = currNode.getRight();
				insert(key, element);
			} 
			else if(currNode.getRight() == null)
			{
				currNode.setRight(temp);
				currNode = root;
			}
		}


	}

	@Override
	/**
	 * delete the node indicated by the key
	 * 
	 * 
	 * I did not fully understand this part, I asked a friend who took this course last year for help, I will follow up with the
	 * professor for deletion.
	 * 
	 * 
	 * @param Sortable key: the key that indicates which node to delete
	 */
	public void delete(Sortable key) {
		BSTNode<String,SortableString> parent = null;
		BSTNode<String,SortableString> N = null;
		BSTNode<String,SortableString> curr = root;

		if(key != null)
		{
			while(curr != null)
			{
				if(key.compareTo(curr.getKey()) == 0)
				{
					N = curr;
					break;
				}
				else if(key.compareTo(curr.getKey()) < 0)
				{
					parent = curr;
					curr = curr.getLeft();
				}
				else
				{
					parent = curr;
					curr = curr.getRight();
				}
			}
		}
		if(N != null)
		{
			if(N.getLeft() != null && N.getRight() != null){

				BSTNode<String,SortableString> tempNode = minvalue(N.getRight());
				N.key = tempNode.getKey();
				N.element = tempNode.getElement();
				tempNode = null;

			}else if(N.getLeft() != null && N.getRight() == null){
				parent.setLeft(N.getLeft());
				N = null;
			}
			else if(N.getLeft() == null && N.getRight() != null){
				parent.setRight(N.getRight());
				N = null;
			}else{ 
				N = null;
			}
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
	/**
	 * printout the full BST tree
	 */
	public void printTree() {
		// TODO Auto-generated method stub
		printOut(root);
		System.out.println("");
	}

	/**
	 * print out tree by parsing through it
	 * @param root: root of the tree
	 */
	private static void printOut(BSTNode<String,SortableString> root) {
		if (root == null)
		{
			return;
		}
		printOut(root.left);
		System.out.print(root.getKey() + " ");
		printOut(root.right);
	}

	@Override
	/**
	 * returns the depth of the BST tree
	 */
	public int depth() {
		// TODO Auto-generated method stub
		return depthBST(root);
	}

	/**
	 * finds the depth of the BST tree
	 * @param node: the root node
	 * @return: depth of tree
	 */
	private int depthBST(BSTNode<String, SortableString> node) {
		// TODO Auto-generated method stub
		if (node == null)
		{
			return 0;//return 0 if root is null
		}
		
		int left = depthBST(node.getLeft());
		int right = depthBST(node.getRight());
		
		if (left < right)
		{
			return right +1;
		}
		else
		{
			return left +1;
		}
	}

}
