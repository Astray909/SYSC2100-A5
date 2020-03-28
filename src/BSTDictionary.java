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
		// TODO Auto-generated method stub
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
