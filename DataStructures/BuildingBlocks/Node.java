package DataStructures.BuildingBlocks;

public class Node<T extends Comparable<T>> implements Comparable {
	private T data;
	private	Node<T> next;

	public Node(T t)
	{
		data = t;
	}

	public void setNext(Node<T> n)
	{
		next = n;
	}

	public void setData(T t)
	{
		data = t;
	}

	public T getData()
	{
		return data;
	}

	public Node<T> getNext()
	{
		return next;
	}

	public String toString()
	{
		return data.toString();
	}

	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Node))
			throw new ClassCastException();

		return this.getData().compareTo((T) ((Node) o).getData());
	}
}