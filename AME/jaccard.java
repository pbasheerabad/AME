package AME;
import java.awt.List;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//import com.mysql.jdbc.log.Log;


public class jaccard 
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
        int c = 0;
        double s = 0;
        DatabaseMetaData meta = con.getMetaData(); 
		
		
        ResultSet rs = st.executeQuery("Select Count(*) AS rowcount from dictionary");
        /*rs.next();
        int count = rs.getInt("rowcount");
        rs.close();
        System.out.println("count = "+count);*/
        while(rs.next())
        {
       	 	s = (double)jaccard_coefficient(word1, word2);
            //System.out.println( "word1=="+word1+"\t word2==="+word2+"\t similarity==="+s );
            sim.add(word1+":"+word2+":"+s);
            st.executeUpdate("INSERT INTO `ame`.`jaccard` (`Doc_id`, `word1`,`id`, `word2`, `similarity`) VALUES ('"+i+"','"+word1+"','"+k+"', '"+word2+"', '"+s+"');");
            if (s!=0)
            {
            	try
            	{
            	st1.executeUpdate("INSERT INTO `ame`.`new_dictionary` (Doc_id, word1,id, word2)"+" VALUES ("+i+", '"+word1+"','"+k+"', '"+word2+"');");
            	}
            	catch (SQLException e) 
            	{
            		e.printStackTrace();
            	}
            	
            }
        }
    }
    catch(Exception e)
    {
   	 //System.err.println(e);
    }
	}
    private static void close(ResultSet res) 
    {
		
	}
	private static double jaccard_coefficient(String s1, String s2) 
	{
        double j_coefficient;
        ArrayList<String> j1 = new ArrayList<String>();
        ArrayList<String> j2 = new ArrayList<String>();
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        
            s1="$"+s1+"$";
            s2="$"+s2+"$";
            int j=0;
            int i=4;
        
            while(i<=s1.length())
            {
                j1.add(s1.substring(j, i));
                    j++;
                    i++;
            }    
            j=0;
            i=4;
            while(i<=s2.length())
            {
                j2.add(s2.substring(j, i));
                    j++;
                    i++;
            }    
 
           /* Iterator<String> itr1 = j1.iterator();
            while (itr1.hasNext()) 
            {
                  String element = itr1.next();
                  System.out.print(element + " ");
            }
            System.out.println();
            Iterator<String> itr2 = j2.iterator();
            while (itr2.hasNext()) 
            {
                  String element = itr2.next();
                  System.out.print(element + " ");
            }
            System.out.println();*/
            
                
                set2.addAll(j2);
                set2.addAll(j1);
                set1.addAll(j1);
                set1.retainAll(j2);
                
                    
                //System.out.println("Union="+set2.size());
                //System.out.println("Intersection="+set1.size());
                if(set1.size() == 0)
                {
                	return(0);
                	
                }
                else
                {
	                j_coefficient=((double)set1.size())/((double)set2.size());
	                return(j_coefficient);
                }
    }

    }