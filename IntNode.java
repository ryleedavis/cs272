/**
 * @author Rylee Davis
 * cs272 lab4
 */

package myprograms;

public class IntNode 
{
	//instance variables
	private int data;
	private IntNode link;
	
	
	//no argument constructor
	public IntNode()
	{
		data = 0;
		link = null;
		
	}//end IntNode()
	
	/**
	 *@pre _node is type integer and points to the head
	 *@post creates new node that contains data and link to the next node
	 *
	 *@param _data is the initial data of new node
	 *@param _node is reference the new node points to
	 */
	//constructor
	public IntNode(int _data, IntNode _node)
	{
		data = _data;
		link = _node;
		
	}//end IntNode()
	
	//accessor for Data
	public int getData()
	{
		return data;
	}//end getData()
	
	//mutator for Data
	public void setData(int _data)
	{
		data = _data;
	}//end setData()
	
	//accessor for link
	public IntNode getLink()
	{
		return link;
	}//end getLink()
	
	//mutator for link
	public void setLink(IntNode _link)
	{
		link = _link;
	}//end setLink()
	
	//calls and prints nodes
	public String toString()
	{
		String temp = String.format("%s", this.getData()); 
		IntNode cursor = this.getLink();
		
		while( cursor != null)
		{
			temp = temp + " -> " + cursor.getData();
			cursor = cursor.getLink();
			
		}//end while
		
		return temp;
	}//end toString

	/**
	 * @pre new data is an integer
	 * @post new node is created and placed after head
	 * 
	 * @param newdata is the data that is going to be placed in new node
	 */
	//method to add node after current node
	public void addNodeAfterThis(int newdata)
	{
		IntNode temp2 = new IntNode(newdata, this.getLink());
		this.setLink(temp2);
		
	}//end addNode
	
	/**
	 * @pre node cannot be end of list
	 * @post newest node is removed from list
	 */
	//method to remove node after current node
	public void removeNodeAfterThis()
	{
		setLink(getLink().getLink());
		
	}//end removeNode
	
	/**
	 *@param head is the starting point of the linked list
	 *@return an integer value telling the number of nodes in the list
	 */
	//method to get number of nodes in the list starting from a given node head
	public static int listLength(IntNode head)
	{
		IntNode cursor = head;
		int count = 0;
		
		while(cursor != null)
		{
			count++;
			cursor = cursor.link;
			
		}//end while
		
		return count;
	}//end listLength
	
	/**
	 * @pre the head is not null
	 * 
	 * @param head is the starting point of linked list
	 * @param data is the data to search for
	 * @return returns true if data exists in list starting with head, otherwise returns false
	 */
	//method to search whether linked list contains given value data
	public static boolean search(IntNode head, int data)
	{
		IntNode cursor = head;
		while(cursor != null)
		{
			if(cursor.getData() == data)
			{
				return true;
			}//end if
			
			cursor = cursor.getLink();
		}//end while
		
		return false; //DONT FORGET TO COMMENT OUT
	}//end search	

}//end class
