public class LLNode<T extends Comparable<T>>
{
	private T data;
	private	LLNode next;

	public LLNode(T t)
	{
		data = t;
	}

	public void setNext(LLNode n)
	{
		next = n;
	}

	public T getData()
	{
		return data;
	}

	public LLNode getNext()
	{
		return next;
	}

	public String toString()
	{
		return data.toString();
	}
}