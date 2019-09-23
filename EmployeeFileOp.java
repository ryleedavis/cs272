//Rylee Davis
//cs272 
//Lab1 EmployeFileOp.java
//August 28, 2019

package myprograms;

import java.io.*;

class EmployeeInformation 
{
	 String name;
	 int number;
	 String state;
	 int zip;
	 int age;
	 String sex;
	
	//ageGetter or isLessThan30 function
	
	//Get CSVString
}

public class EmployeeFileOp 
{
	private static EmployeeInformation[] numEmployees = null;
//	public int getAge()
//	{
//		return age;
//	}//end getAge()
	
		
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
	        
			System.out.println("Finish reading pairs from file "+ fname);
			
		}//end read
			
			public static void write(String fname)
			{
//				if( <= 30)
				try 
				{
					File file = new File(fname);
					
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
					bw.write(numEmployees.length + "\n");
					
					for(int i =  0;i < numEmployees.length;i++)
					{
						//System.out.println("i = " + i + ":" + numEmployees[i].name+ "," + numEmployees[i].number...);
						bw.write(numEmployees[i].name + "," + numEmployees[i].number + "," + numEmployees[i].state + "," + numEmployees[i].zip + "," + numEmployees[i].age + "," + numEmployees[i].sex + "\n" );
					
					}//end for
					
					//close the writers
					if(bw != null)
						bw.close();
					if(fw != null)
						fw.close();
					
					
//					bw.close();
//					fw.close();
					
					
				}//end try 
				catch (IOException e) 
				{
					e.printStackTrace();
				}//end catch
				
				System.out.println("Finish writing pairs to file "+ fname);
			}//end write
			
			public static void main(String[] args) 
			{			
				numEmployees = null;		//clear the memory
				read("core_dataset.csv");		//read back the 100 pairs
				write("young_employee.csv"); //write the pairs to another file
			}//end main

}//end class
