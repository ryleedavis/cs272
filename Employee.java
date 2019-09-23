//Rylee Davis
//cs272 
//lab2 Employee.java
//Sept. 3, 2019

package myprograms;

public class Employee 
{
	int size = 3;
	
	//instance variables
	private String name;
	private int no;
	private int age;
	private String state;
	private int zip;
	
	//array of integers to employee's advisors, where each employee can have up to 3
	int[] advisors = new int[size];
	
	//no argument constructor that sets variables to null and 0
	public Employee()
	{
		name = null;
		no = 0;
		age = 0;
		state = null;
		zip = 0;
		advisors = null;
		
	}//end Employee constructor
	
	//copy constructor copies all instance variables from source object into a new object
	//Object is superclass; Employee subclass
	public Employee(Object obj)
	{
		if ((obj != null) && (obj instanceof Employee))
		{
			Employee e2 = (Employee)obj;
			
			this.name = new String(e2.name);
			this.no = e2.no;
			this.age = e2.age;
			this.state = new String(e2.state);
			this.zip = e2.zip;
			this.advisors = new int[size];
			
			for(int i = 0; i <= size; i++)
			{
				this.advisors = e2.advisors;
				
			}//end for		
			
		}//end if
		
	}//end copy constructor
	 
	//accessors and mutators
	//get functions just return the needed variable
	//set functions set the variable equal to the parameter entered
	public String getName()
	{
		return name;
	}//getName
	
	public void setName(String n)
	{
		name = n;
	}//setName
	
	public int getNo()
	{
		return no;
	}//getNo
	
	public void setNo(int n)
	{
		no = n;
	}//setNo
	
	public int getAge()
	{
		return age;
	}//getAge
	
	public void setAge(int a)
	{
		age = a;
	}//setAge
	
	public String getState()
	{
		return state;
	}//getState
	
	public void setState(String s)
	{
		state = s;
	}//setState
	
	public int getZip()
	{
		return zip;
	}//getZip
	
	public void setZip(int z)
	{
		zip = z;
	}//setZip
	
	
	public void setAdvisors(int[] ad)
	{
		
		if(ad.length > 3)
		{
			throw new IllegalArgumentException("Employee is limited to 3 advisors.");
		}//end if
		else
		{
			advisors = new int[ad.length];
			advisors = ad;
		}//end else
	}//setAdvisors
	
	public int[] getAdvisors()
	{
		return advisors;
	}//getAdvisors
	
	//used for string representation of objects
	//also checks number of advisors each employee has
	public String toString()
	{
		
		//return "Name: " + name + "\nNO: " + no + "\nAge: " + age + "\nState: " + state + "\nZip: " + zip + "\nAdvisors: " + advisors;
		
		int advisors2[] = new int[advisors.length];
		for(int i = 0; i < advisors.length; i++)
		{
			advisors2[i] = advisors[i];
			
		}//end for
		
		if(advisors2.length == 0)
		{
			return name + ", " + no + ", " + age + ", " + state +", " + zip + ", " + "No advisors";
		}
		
		if(advisors2.length == 1)
		{
			return name + ", " + no + ", " + age + ", " + state +", " + zip + ", " + advisors2[0];
		}
		
		if(advisors2.length == 2)
		{
			return name + ", " + no + ", " + age + ", " + state +", " + zip + ", " + advisors2[0] + ", " + advisors2[1];
		}
		else
		{
			return name + ", " + no + ", " + age + ", " + state +", " + zip + ", " + advisors2[0] + ", " + advisors2[1] + ", " + advisors2[2];
		}
		
	}//toString
	
	//equals compares the contents of employee no and getNo
	//returns true if they are equal, and false if they are not equal
	public boolean equals(Employee obj)
	{
		if ((obj != null) && (obj instanceof Employee))
		{
			Employee e2 = (Employee)obj;
			
			if(e2.no == getNo())
			{
				return true;
			}//end if
			else
			{
				return false;
			}//end else
				
		}//end if
		
		else
		{
			return false;
		}//end else
		
	}//end equals
	
	
	//parameters are 2 employee objects. if neither e1 or e2 are equal to null, read the array. 
	//if e1 is not equal to e2, array advisors2 at element is equal to advisors2 at count + 1
	//else e1 at element is equal to advisors2 at count - 1
	public static int[] getAllAdvisors(Employee e1, Employee e2)
	{
		int count = 0;
		int[] advisors2 = new int[count];
		
		if(e1 != null && e2 != null)
		{			
			for(int i = 0; i > e1.advisors.length; i++)
			{
				for(int j = 0; j > e2.advisors.length; j++)
				{
					if(e1.advisors[i] != e2.advisors[j])
					{
						advisors2[j] = advisors2[count + 1];
						count++;
					}//end if
					
					else
					{
						e1.advisors[j] = advisors2[count - 1];
						count--;
					}//end else
					
				}//end e2
				
			}//end e1 
			
		}//end if
		
	return advisors2;
	}//getAllAdvisors
	
	
	public static void main(String[] args)
	{
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		int e1Ad[] = new int[] {2, 4, 6};
		int e2Ad[] = new int[] {1, 2, 3};
		
		//set functions
		e1.setName("Rylee Davis");
		e1.setNo(800612218);
		e1.setAge(21);
		e1.setState("New Mexico");
		e1.setZip(88310);
		e1.setAdvisors(e1Ad);
		
		//sets e1.setAdvisors equal to array e1Ad
		System.out.println("Testing getAdvisors method:");
		System.out.print("Employee1 Advisors: ");
		for(int i = 0; i < e1Ad.length; i++)
		{
			e1.getAdvisors();
			System.out.print(e1.advisors[i] + " ");
		}//end for
		
		//sets e2.setAdvisors equal to e2Ad
		e2.setAdvisors(e2Ad);
		System.out.print("\nEmployee2 Advisors: ");
		for(int i = 0; i < e2Ad.length; i++)
		{
			e2.getAdvisors();
			System.out.print(e2.advisors[i] + " ");
		}
		
		System.out.println("\n\nTesting toString method:");
		System.out.println("Employee 1: " + e1.toString());
		System.out.println("Employee 2: " + e2.toString() + "\n");
		
		System.out.println("Testing get functions:");
		System.out.println(e1.getName());
		System.out.println(e1.getNo());
		System.out.println(e1.getAge());
		System.out.println(e1.getState());
		System.out.println(e1.getZip());
		
		
		System.out.println("\nTesting equals method:");
		System.out.println(e1.equals(e2));
		System.out.println(getAllAdvisors(e1,e2));
	
	}//end main

}//end class Employee
