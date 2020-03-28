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
	public void insert(Sortable key, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Sortable key) {
		// TODO Auto-generated method stub

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
