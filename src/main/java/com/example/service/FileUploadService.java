package com.example.service;

import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.helper.fileUploadHelper;

@Service
public class FileUploadService {

	@Autowired
	private fileUploadHelper helper;

	public List<String> getLine( String key,String value) throws IOException{
	
		Scanner sc=new Scanner(System.in);
		String string = helper.getPath().toString();
		System.out.println("path: --> "+string);
		
		FileReader reader=new FileReader(string); 
		BufferedReader b=new BufferedReader(reader);

		String keyValuePair = '"'+key+'"'+":"+'"'+value+'"';
	
		//FOR INTEGER VALUE (JSON)
		if(key.equals("age")) {
			 keyValuePair = '"'+key+'"'+":"+value;
				
		}
			int lineNumber=0;
			int count=1;
			String[] arr = new String[10];
			int i=0;
			System.out.println("Line number for "+keyValuePair);
	
			while(b.ready()) 
		{
				String str=b.readLine();
				lineNumber++;
				if(str.contains(keyValuePair))
				{
					System.out.println(lineNumber);
					arr[i]=" no : "+lineNumber;
					i++;
				}
		}
			b.close();
	    
	
		List<String> list=new ArrayList<String>();
		for(int k=0;k<arr.length;k++)
		{
			if(arr[k] !=null) {
				list.add(arr[k]);
			}
		}
	
		return list;
	}
	
	
	
	
	
		
		
	
public List<String> getJsonObject(String key,String value) throws IOException, ParseException {
	
	JSONParser jsonParser=new JSONParser();
	String string = helper.getPath().toString();
	FileReader reader=new FileReader(string); 
    Object obj=jsonParser.parse(reader);
    JSONObject empJsonObj=(JSONObject)obj;
    System.out.println(helper.getRootJson());
	JSONArray arr=(JSONArray) empJsonObj.get(helper.getRootJson());
	JSONArray resultArr = new JSONArray();

	    int count=0;
	    String curly="{";
	    String resultLine="";
	    String[] arrLine = new String[10];
	    List<String> list=new ArrayList<String>();
 for(int i=0;i<arr.size();i++)    
   {
	    int lineNumber=0;
	    JSONObject user=(JSONObject) arr.get(i);
        String fname=(String) user.get(key);
    if(fname.equals(value))
    {
         System.out.println("Value : "+fname);
         System.out.println(user);
         count=i;
         int k=0;
	     FileReader readerLine=new FileReader(string); 
		 BufferedReader b=new BufferedReader(readerLine);
		 System.out.println(b.ready());
          while(b.ready()) 
		   {
     		  
				String str=b.readLine();
				lineNumber++;
				if(str.contains(curly))
				{
					
					//System.out.println(lineNumber);
					arrLine[k]=" no : "+lineNumber;
					k++;
					
				}
		    }
    	 resultLine=arrLine[count+1];
		 list.add( resultLine);
	     resultArr.add(user);
	     System.out.println("RESULT JSON OBJECT LINENUMBER = "+list);
	    System.out.println("RESULT JSON"+resultArr);
         
       }
	                 
   	}

return list;	
}



public List<String> getJsonObject2(String key,String value,String key1,String value1) throws IOException, ParseException {
	
	JSONParser jsonParser=new JSONParser();
	String string = helper.getPath().toString();
	FileReader reader=new FileReader(string); 
	Object obj=jsonParser.parse(reader);
    JSONObject empJsonObj=(JSONObject)obj;
	JSONArray arr=(JSONArray) empJsonObj.get(helper.getRootJson());
    System.out.println(arr);
    JSONArray resultArr = new JSONArray();
    int count=0;
  
    String curly="{";
    String resultLine="";
    String[] arrLine = new String[10];
    List<String> list=new ArrayList<String>();
    for(int i=0;i<arr.size();i++)
    {
    	  int lineNumber=0;
        JSONObject user=(JSONObject) arr.get(i);
        String fname=(String) user.get(key);
        if(fname.equals(value)) 
          {
    	    fname=(String) user.get(key1);
    	    if(fname.equals(value1))
    	      {
                 System.out.println("Value : "+fname);
    	         System.out.println(user);
    	         count=i;
    	         int k=0;
    		     FileReader readerLine=new FileReader(string); 
    			 BufferedReader b=new BufferedReader(readerLine);
    			 System.out.println(b.ready());
    	     	 while(b.ready()) 
    			   {
    	     		  
    					String str=b.readLine();
    					lineNumber++;
    					if(str.contains(curly))
    					{
    						
    						//System.out.println(lineNumber);
    						arrLine[k]=" no : "+lineNumber;
    						k++;
    						
    					}
    			    }
    	    	 resultLine=arrLine[count+1];
    			 list.add( resultLine);
    		     resultArr.add(user);
    		     System.out.println("RESULT JSON OBJECT LINENUMBER = "+list);
    		    System.out.println("RESULT JSON"+resultArr);
    	         
    	      }
          }
        
    }
   
return list;

}


public List<String> getJsonObject3(String key,String value,String key1,String value1,String key2,String value2) throws IOException, ParseException {
	
	JSONParser jsonParser=new JSONParser();
	String string = helper.getPath().toString();
	FileReader reader=new FileReader(string); 
    Object obj=jsonParser.parse(reader);
    JSONObject empJsonObj=(JSONObject)obj;
	JSONArray arr=(JSONArray) empJsonObj.get(helper.getRootJson());
    JSONArray resultArr = new JSONArray();
    int count=0;
    String curly="{";
    String resultLine="";
    String[] arrLine = new String[10];
    List<String> list=new ArrayList<String>();
    for(int i=0;i<arr.size();i++)
    {
    	 int lineNumber=0;
         JSONObject user=(JSONObject) arr.get(i);
         JSONObject resultObj = null;
         String fname=(String) user.get(key);
      if(fname.equals(value)) 
       {
    	  fname=(String) user.get(key1);
    	  if(fname.equals(value1))
    	    {
    		  fname=(String) user.get(key2);
    		  if(fname.equals(value2))
    		    {
    			  System.out.println("Value : "+fname);
     	          System.out.println(user);
     	         count=i;
    	         int k=0;
    		     FileReader readerLine=new FileReader(string); 
    			 BufferedReader b=new BufferedReader(readerLine);
    			 System.out.println(b.ready());
    	     	 while(b.ready()) 
    			   {
    	     		  
    					String str=b.readLine();
    					lineNumber++;
    					if(str.contains(curly))
    					{
    						
    						//System.out.println(lineNumber);
    						arrLine[k]=" no : "+lineNumber;
    						k++;
    						
    					}
    			    }
    	    	 resultLine=arrLine[count+1];
    			 list.add( resultLine);
    		     resultArr.add(user);
    		     System.out.println("RESULT JSON OBJECT LINENUMBER = "+list);
    		    System.out.println("RESULT JSON"+resultArr);
     	        }
    		    
    	     }
        }
    }

return list;	
}




}
