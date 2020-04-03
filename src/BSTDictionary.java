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
		BSTNode<String,SortableString> del = null;
		BSTNode<String,SortableString> root = this.root;
		
		if(key != null)
		{
			while(root != null)
			{
				if(key.compareTo(root.getKey()) == 0)
				{
					del = root;
					break;
				}
				else if(key.compareTo(root.getKey()) < 0)
				{
					parent = root;
					root = root.getLeft();
				}
				else
				{
					parent = root;
					root = root.getRight();
				}
			}
			if(del != null)
			{
				if(del.getLeft() == null && del.getRight() == null)
				{
					//the delete node does not have 
					del=null;
				}
				else if(del.getLeft() != null && del.getRight() == null)
				{
					//the delete node has only one left child
					if(parent.getRight() == del)
					{
						parent.setRight(del.getLeft());
						del = null;
					}
					else
					{
						parent.setLeft(del.getLeft());
						del = null;
					}
				}
				else if(del.getLeft() == null && del.getRight() != null)
				{
					//the delete node has only one left child
					if(parent.getLeft() == del)
					{
						parent.setLeft(del.getRight());
						del = null;
					}
					else
					{
						parent.setRight(del.getRight());
						del = null;
					}
				}
				else
				{
					//the delete node has two child
					BSTNode<String,SortableString> temp = findMin(del.getRight());
					del = temp;
					temp = null;
				}

			}

		}

	}

	public BSTNode<String,SortableString> findMin(BSTNode<String,SortableString> node)
	{
		while(node.getLeft()!=null)
		{
			node = node.getLeft();
		}
		return node;
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
