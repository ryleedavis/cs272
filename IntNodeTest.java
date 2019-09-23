/**
 * @author: Rylee Davis
 * cs272 lab4
 */
package myprograms;

public class IntNodeTest 
{

	public static void main(String[] args)
	{
		//new IntNode
		IntNode node1 = new IntNode(2,null); //sets head to 2, otherwise 0
		
		//addNodeAfterThis
		System.out.println("Adds nodes 1, 2, and 3 to list: ");
		node1.addNodeAfterThis(1);
		node1.addNodeAfterThis(2);
		node1.addNodeAfterThis(3);
		
		//toString
		System.out.println(node1.toString());
		
		//removeNodeAfterThis
		System.out.println("\nRemoves node 3 from list: ");
		node1.removeNodeAfterThis();
		
		//toString
		System.out.println(node1.toString());
		
		//listLength
		System.out.println("\nLength of list:");
		System.out.println(node1.listLength(node1));
		
		//search
		System.out.println("\nSearch list for 2: ");
		System.out.println(node1.search(node1, 2));
		
		//gets and sets
		node1.setData(5);
		node1.setLink(node1.getLink());

		System.out.println("\nTesting get methods: ");
		System.out.println("data: " + node1.getData());
		System.out.println("link: " + node1.getLink());
		
		
	}//end main
	
}//end class
