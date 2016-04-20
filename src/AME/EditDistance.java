package AME;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class EditDistance 
{
	public static ArrayList sim=new ArrayList();

    public static void run( String word1, String word2, int i, int k ) 
    {
    	try
        {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AME","root","");
	         Statement st=con.createStatement();
	         Statement st1=con.createStatement();
	         Statement st2=con.createStatement();
	         Statement st3=con.createStatement();
	        
	         int c=0;
	         double s = 0;

	         ResultSet rs = st.executeQuery("Select Count(*) from dictionary");
	         
         
	         while(rs.next()) 
	         {
	        	 s = (double) similarity(word1, word2);
	             System.out.println( "word1=="+word1+"\t word2==="+word2+"\t Edit Distance==="+s );
	             sim.add(word1+":"+word2+":"+s);
	             st.executeUpdate("INSERT INTO `ame`.`edit_distance` (`Doc_id`, `word1`,`id`, `word2`, `similarity`) VALUES ('"+i+"','"+word1+"','"+k+"', '"+word2+"', '"+s+"');");
	             if(s>0.09)
	             {
	            	c = c+1;
	             	st.executeUpdate("INSERT INTO `ame`.`new_dictionary` (Doc_id, word1, id, word2)"+" VALUES ("+i+", '"+word1+"',"+k+",'"+word2+"');");
	             }
	         }
           
        }
	     catch(Exception e)
	     {
	    	// System.err.println(e);
	     }         
    }
    public static double similarity(String s1, String s2) 
    {
    	String longer = s1, shorter = s2;
    	if (s1.length() < s2.length()) 
       	{
    		longer = s2; shorter = s1;
       	}
        int longerLength = longer.length();
        if (longerLength == 0) 
        { 
        	return 1.0; 
        }
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    }

    public static int editDistance(String s1, String s2) 
    {
    	s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) 
        {
        	int lastValue = i;
        	for (int j = 0; j <= s2.length(); j++) 
        	{
        		if (i == 0)
        			costs[j] = j;
        	    else 
        	    {
        	    	if (j > 0) 
        	    		{
        	        		int newValue = costs[j - 1];
        	        		if (s1.charAt(i - 1) != s2.charAt(j - 1))
        	        			newValue = Math.min(Math.min(newValue, lastValue),
        	                costs[j]) + 1;
        	        		costs[j - 1] = lastValue;
        	        		lastValue = newValue;
        	        	}
        	    }
        	 }
        	 if (i > 0)
        		 costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }
}
