package myprograms;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//Rylee Davis
//cs272 lab3
//Sept. 9, 2019

public class EmployeeSet 
{
	//instance variables
	private int datacap; //capacity of array data
	private int size; //counts number of employees
	private Employee[] data; //Employee array
	
	
	
	//no-argument constructor that initializes EmployeeSet instance, sets it capacity to 10, 
	//and creates new array to store 10 Employee objects
	public EmployeeSet()
	{
		size = 0;
		datacap = 10;
		data = new Employee[datacap];		
		
	}//end constructor
	
	/*
	 * @precondition: the obj should not be null and should be an instance of EmployeeSet
	 * 
	 * copy constructor that creates new EmployeeSet instance and copies the content of the given object to the new instance
	 */
	public EmployeeSet(Object obj)
	{
		if((obj != null) && (obj instanceof EmployeeSet))
		{
			EmployeeSet es2 = new EmployeeSet();
			
			this.size = es2.size;
			this.datacap = es2.datacap;
			
			for(int i = 0; i <= 10; i++)
			{
				this.data = es2.data;
				
			}//end for
				
		}//end if
		
	}//end copy constructor
	
	
	//method to get Employee Set
	public Employee[] getES()
	{
		return data;
	}//end
	
	//method which returns the actual number of elements in collection
	public int size()
	{
//		for(int i = 0; i < datacap; i++)
//		{
//			if(data[i] != null)
//			{
//				size++;
//				
//			}//end if
//			
//		}//end for
		
		return size;
	}//end size()
	
	//returns length of the whole array
	public int capacity()
	{
		datacap = data.length;
		return datacap;
	}//end capacity
	
	/*
	 * @precondition: the employee object a should not be null
	 * 
	 * method which adds given Employee obj to first available space of the new employee array
	 */
	public void add(Employee a)
	{
		if(a == null)
		{
			throw new IllegalArgumentException("Employee object cannot be null");
		}//end if
		
		//if size is less than capacity, array data of size is equal to 
		if(size < data.length)
		{
			data[size] = a;
			size++;
		}//end if
		
		else
		{
			ensureCapacity(capacity() * 2);
			data[size()] = a;
		}//end else
		
	}//end add()
	
	//method to check whether this collection contains the input parameter
	public boolean contains(Employee a)
	{
		if(a == null)
		{
			return false;
		}//if
		
		else
		{
			for(int i = 0; i < size; i++)
			{
				if(data[i].equals(a))
				{
					return true;
				}//end if
				
			}//end for
			
		}//end else
		
	return false;
	}//end contains()
	
	//method to remove from the collection the employee with the given employee number eno
	public boolean remove(int eno)
	{
		if(eno == 0)
		{
			return false;
		}//end if
		
		int i;
		for(i = 0; (i < size) && (eno != data[i].getNo()); i++);
		
			if(i == size)
			{
				return false;
			}//end if
			
			else
			{
				size--;
				data[i] = data[size];
				return true;
			}//end else
		
	}//end remove
	
	/*
	 * @precondition: the input parameter minimumCapacity should be positive
	 * 
	 * Guarantees the capacity of the collection. If capacity is smaller than input parameter, method sets the capacity to 
	 * minimumCapacity and enlarges the array
	 */
	public void ensureCapacity(int minimumCapacity)
	{
		if(minimumCapacity < 0)
		{
			throw new IllegalArgumentException("minimumCapacity should be positive");
		}//end if
		
		if(datacap <= minimumCapacity)
		{
			Employee temp[] = new Employee[minimumCapacity];
			
			for(int i = 0; i < size; i++)
			{
				temp[i] = data[i];
			}//end for
			
			data = temp;
			datacap = datacap * 2; //doubles array size
			
		}//end if
		
	}//end ensureCapacity
	
	/*
	 * @precondition: the employee object a should not be null and the objects in the 
	 * collection's employee array are already in ascending order of employee numbers
	 */
	public void addOrdered(Employee a)
	{
		if(a == null)
		{
			throw new IllegalArgumentException("Employee object should not be null");
		}//end if
		
		if(size >= capacity())
		{
			ensureCapacity(capacity() * 2);
		}//end
		
		Arrays.sort(data);
		System.out.printf(Arrays.toString(data));
		
		
	}//end addOrdered
	
	private static EmployeeInformation[] numEmployees = null;
	
	public static void read(String fname) //function read
	{		
		int no = 0; 
		String line = "";
		try 
		{
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String input; 
            int counter = 0;
            
            while((input = bufferedReader.readLine()) != null)
            {
            	counter++;
            	
            }//end while
            
            System.out.println("Count: " + counter);

            while((line = bufferedReader.readLine()) != null) //will read until end ?
            {
                //parse line
                if(no==0)
                {
                	int totalNumber = Integer.parseInt(line);
                	numEmployees = new EmployeeInformation[totalNumber];
                }//end if
                
                else
                {
                	String[] linestr = line.split(","); //use comma as separator
                	if(linestr.length!= 6) continue;
                	
                	if(no > numEmployees.length)
                	{
                		System.out.println("There are too many employees in the file. ");
                			break;
                	}//end if
                	
                	numEmployees[no-1] = new EmployeeInformation();	                	
                	numEmployees[no-1].name = linestr[0];
                	numEmployees[no-1].number = Integer.parseInt(linestr[1]); 
                	numEmployees[no-1].state = linestr[2];
                	numEmployees[no-1].zip = Integer.parseInt(linestr[3]);
                	numEmployees[no-1].age = Integer.parseInt(linestr[4]);
                	numEmployees[no-1].sex = linestr[5];
                	
                }//end else
                	
              }//end while
            
                no++;
                
             bufferedReader.close(); // Always close files.
            }//end try  	
		catch(FileNotFoundException ex) 
		{
            System.out.println("Unable to open file '" +  fname + "'");                
        }//end catch
		
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + fname + "'");                  
        }//end catch
		
	}//end read
	
	public static void main(String[] args) 
	{
		//read("/home/ugrad25/rdavis/cs272/myprograms/core_dataset.csv");
		
		//declaring new employee objects
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		//declaring new employeeset object
		EmployeeSet es1 = new EmployeeSet();
		
		//set functions
		e1.setName("Rylee Davis");
		e1.setNo(800612218);
		e1.setAge(21);
		e1.setState("New Mexico");
		e1.setZip(88310);
		
		e2.setName("Employee Name");
		e2.setNo(800123456);
		e2.setAge(34);
		e2.setState("California");
		e2.setZip(90210);
	
		//print all get() functions
		System.out.println(e1.getName());
		System.out.println(e1.getNo());
		System.out.println(e1.getAge());
		System.out.println(e1.getState());
		System.out.println(e1.getZip());
		
		//add employee e1 to employeeset es1
		es1.add(e1);
		
		//print capacity and size after adding e1
		System.out.println("\nCapacity of es1: " + es1.capacity());
		System.out.println("Size of es1: " + es1.size());
		
		//does es1 contain e1 and e2
		System.out.println("\nEmployeeSet es1 contains e1: " + es1.contains(e1));
		System.out.println("EmployeeSet es1 contains e2: " + es1.contains(e2));
		
		es1.add(e2);
		
		//print capacity and size after adding e2
		System.out.println("\nAdd e2 to EmployeeSet: ");
		System.out.println("Capacity: " + es1.capacity());
		System.out.println("Size: " + es1.size());
		
		//does remove employee with the following number
		System.out.println(es1.remove(800612218));
		
		System.out.println("\nCapacity: " + es1.capacity());
		System.out.println("Size: " + es1.size());
		
	}//end main

}//end class