package AME;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import javax.swing.*;

public class similarity extends javax.swing.JFrame 
{
   public static String[] w = new String[1000];
   public static String[] w1 = new String[20000];
   public static String[] w2 = new String[20000];
   public static String temp, str1, str2, st1, st2, input;
   public static int m = 0, n = 0,i;
   String[] doc=new String[50];
   String[] doc1 = new String[50];
   
   private JButton jButton1;
   private JButton jButton2;
   private JButton jButton3;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JScrollPane jScrollPane1;
   private JTextArea jTextArea1;
   
   public similarity() 
   {
        initComponents();
   }

    @SuppressWarnings("unchecked")
    
    private void initComponents() 
    {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jButton3 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(910, 725));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Similarity Calculation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton1.setText("Edit Distance");
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
        	public void actionPerformed(java.awt.event.ActionEvent evt) 
        	{
                jButton1ActionPerformed(evt);
            }
        });
        
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton3.setText("Jaccard");
        jButton3.addActionListener(new java.awt.event.ActionListener() 
        {
        	public void actionPerformed(java.awt.event.ActionEvent evt) 
        	{
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14));
        jLabel1.setText("Given Word                                 Matching Words                                    Similarity");

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(53, 53, 53)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(54, 54, 54)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(544, 544, 544)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(155, 155, 155)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(56, 56, 56)
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(88, 88, 88)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(60, 100, 810, 500);

        jLabel2.setFont(new java.awt.Font("Cambria", 3, 18)); 
        jLabel2.setText("Similarity Function");
        jPanel2.add(jButton3);
        jButton3.setBounds(58,110,120,30);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(370, 40, 160, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, 0, 920, 710);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
    {
      try 
      {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AME","root","");
            
            Statement stmt=con.createStatement();
            Statement stmt1=con.createStatement();
               
            DatabaseMetaData meta = con.getMetaData(); 
   			ResultSet res = meta.getTables(null, null, "edit_distance", null); 
   			if(!res.next())
   			{ 
   				String sql1 = "CREATE TABLE edit_distance " + 
   						"(`Doc_id` int(100), `word1` varchar(5000),`id` int(100), `word2` varchar(2000), `similarity` double)";
   				stmt.executeUpdate(sql1);		
   			} 
   			else
   			{
   				stmt.executeUpdate("TRUNCATE TABLE `edit_distance`"); 			    
   			}
   			
   			ResultSet res2 = meta.getTables(null, null, "new_dictionary", null); 
   			if(!res2.next())
   			{ 
   				String sql1 = "CREATE TABLE new_dictionary " + 
   						"(`Doc_id` int(100),`word1` varchar(5000),`id` int(100), `word2` varchar(5000))";
   				stmt.executeUpdate(sql1);		
   			} 
   			else
   			{
   				stmt.executeUpdate("TRUNCATE TABLE `new_dictionary`"); 			    
   			}
   			close(res2);
            
            
            String files;
            long size=0;
            String str = null;
            BufferedWriter bw=new BufferedWriter(new FileWriter(new File("C:/Users/Public/Documents/similarity.txt")));
            File folder = new File("C:/Users/Public/Documents/Dataset");
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) 
            {
                if (listOfFiles[i].isFile()) 
                {
                    files = listOfFiles[i].getName();
                    size=(long) listOfFiles[i].length();
                    if(files.contains(".txt"))
                    {
                        doc[i]=files;
                        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/Dataset/"+files)));
                        while((str=br.readLine())!=null)
                        {
                            str = str.toLowerCase();
                            StringTokenizer st3=new StringTokenizer(str,"~");
                            while(st3.hasMoreTokens())
                            {
                               st2=st3.nextToken();
                               System.out.println(st2);
                            }
                            bw.write(st2);
                            bw.newLine();
                        }
                        
                    }
                    
                }
            }
            bw.close();
            
            
            String files1;
            long size1=0;
            String str2 = null;
            BufferedWriter bw1=new BufferedWriter(new FileWriter(new File("C:/Users/Public/Documents/input.txt")));
            File folder1 = new File("C:/Users/Public/Documents/Input");
            File[] listOfFiles1 = folder1.listFiles();
            for (int i = 0; i < listOfFiles1.length; i++) 
            {
                if (listOfFiles1[i].isFile()) 
                {
                    files1 = listOfFiles1[i].getName();
                    size1=(long) listOfFiles1[i].length();
                    if(files1.contains(".txt"))
                    {
                        doc1[i]=files1;
                        BufferedReader br1=new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/Input/"+files1)));
                        while((str2=br1.readLine())!=null)
                        {
                            str2 = str2.toLowerCase();
                            StringTokenizer st4=new StringTokenizer(str2,"~");
                            while(st4.hasMoreTokens())
                            {
                               st1=st4.nextToken();
                               System.out.println(st1);
                            }
                            bw1.write(st1);
                            bw1.newLine();
                        }
                        
                    }
                    
                }
            }
            bw1.close();
            
            
            
            
            BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/similarity.txt")));
            String ss;
            while ((ss = br.readLine()) != null) 
            {
               w1[n] = ss;
               System.out.println(w1[n]);
               n++;
            }
            System.out.println(n);
            BufferedReader br1 = new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/input.txt")));
            String ss1;
            while ((ss1 = br1.readLine()) != null) 
            {
               w2[m] = ss1;
               System.out.println(w2[m]);
               m++;
            }
            System.out.println(m);
            
            for (int i = 0; i < n; i++) 
            {
            	str2 = w1[i];
            	for(int j = 0; j < m ; j++)
            	{
            	str1 = w2[j];
                //str1 =searchInput.input;
                EditDistance e = new EditDistance();
                e.run(str1, str2,j+1,i+1);
            	}
            }
            String word1,word2;
            double sim;
            Statement stmt2=con.createStatement();
            ResultSet rs= stmt2.executeQuery("select `word1`, `word2`, `similarity` from edit_distance");
            while(rs.next())
            {
             word1=rs.getString(1);
             word2=rs.getString(2);
             sim=rs.getDouble(3);
             jTextArea1.append(word1+"\t\t"+word2+"\t\t"+sim+"\n");
            }

            JOptionPane.showMessageDialog(null,"Similarity is Calculated");
      } 
      catch (Exception e) 
      {
            System.out.println(e);
      }

    }
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) 
    {
      try 
      {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AME","root","");
            
            Statement stmt=con.createStatement();
            Statement stmt1=con.createStatement();
               
            DatabaseMetaData meta = con.getMetaData(); 
   			ResultSet res1 = meta.getTables(null, null, "jaccard", null); 
   			if(!res1.next())
   			{ 
   				String sql2 = "CREATE TABLE jaccard " + 
   						"(`Doc_id` int(100), `word1` varchar(8000), `id` int(100), `word2` varchar(2000), `similarity` double)";
   				stmt.executeUpdate(sql2);		
   			} 
   			else
   			{
   				stmt.executeUpdate("TRUNCATE TABLE `jaccard`"); 			    
   			}
            
            close(res1);
            
   			ResultSet res2 = meta.getTables(null, null, "new_dictionary", null); 
   			if(!res2.next())
   			{ 
   				String sql1 = "CREATE TABLE new_dictionary " + 
   						"(`Doc_id` int(100),`word1` varchar(8000),`id` int(100), `word2` varchar(8000))";
   				stmt.executeUpdate(sql1);		
   			} 
   			else
   			{
   				stmt.executeUpdate("TRUNCATE TABLE `new_dictionary`"); 			    
   			}
   			close(res2);
   			
            
   			String files;
            long size=0;
            String str = null;
            BufferedWriter bw=new BufferedWriter(new FileWriter(new File("C:/Users/Public/Documents/similarity.txt")));
            File folder = new File("C:/Users/Public/Documents/Dataset");
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) 
            {
                if (listOfFiles[i].isFile()) 
                {
                    files = listOfFiles[i].getName();
                    size=(long) listOfFiles[i].length();
                    if(files.contains(".txt"))
                    {
                        doc[i]=files;
                        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/Dataset/"+files)));
                        while((str=br.readLine())!=null)
                        {
                            str = str.toLowerCase();
                            StringTokenizer st3=new StringTokenizer(str,"~");
                            while(st3.hasMoreTokens())
                            {
                               st2=st3.nextToken();
                               System.out.println(st2);
                            }
                            bw.write(st2);
                            bw.newLine();
                        }
                        
                    }
                    
                }
            }
            bw.close();
            
            
            String files1;
            long size1=0;
            String str2 = null;
            BufferedWriter bw1=new BufferedWriter(new FileWriter(new File("C:/Users/Public/Documents/input.txt")));
            File folder1 = new File("C:/Users/Public/Documents/Input");
            File[] listOfFiles1 = folder1.listFiles();
            for (int i = 0; i < listOfFiles1.length; i++) 
            {
                if (listOfFiles1[i].isFile()) 
                {
                    files1 = listOfFiles1[i].getName();
                    size1=(long) listOfFiles1[i].length();
                    if(files1.contains(".txt"))
                    {
                        doc1[i]=files1;
                        BufferedReader br1=new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/Input/"+files1)));
                        while((str2=br1.readLine())!=null)
                        {
                            str2 = str2.toLowerCase();
                            
                            
                            int k=0,j;
                    		ArrayList<String> wordsList = new ArrayList<String>();
                    		String sCurrentLine;
                    		String[] stopwords = new String[2000];
                    		Set<String> stopWordsSet = new HashSet<String>();
                    		

                            	FileReader fr=new FileReader("C:/Users/Public/Documents/stopwordslist.txt");
                    	        BufferedReader br2= new BufferedReader(fr);
                    	        while ((sCurrentLine = br2.readLine()) != null)
                    	        {
                    	        	stopWordsSet.add(sCurrentLine);
                    	            
                    	        }
                    	        String s = str2;
                    	       
                    	        StringBuilder builder = new StringBuilder(s);
                    	        String[] words = builder.toString().split("\\s");
                    	        
                    	        for (String word : words)
                    	        {
                    	        	String wordCompare = word.toLowerCase();
                    	        	 if(!stopWordsSet.contains(wordCompare))
                    	             {
                    	                 wordsList.add(word);
                    	             }
                    	           
                    	        }
                    	        String inputdata ="";
                    	        for (String str5 : wordsList)
                    	        {
                    	        	inputdata += str5 + " ";
                    	            System.out.print(str5+" ");
                    	        }   
                                //input = jTextField1.getText();
                            	input = inputdata;
                            
                            
                            StringTokenizer st4=new StringTokenizer(input,"~");
                            while(st4.hasMoreTokens())
                            {
                               st1=st4.nextToken();
                               System.out.println(st1);
                            }
                            bw1.write(st1);
                            bw1.newLine();
                        }
                        
                    }
                    
                }
            }
            bw1.close();
            
            
            
            
            BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/similarity.txt")));
            String ss;
            while ((ss = br.readLine()) != null) 
            {
               w1[n] = ss;
               System.out.println(w1[n]);
               n++;
            }
            System.out.println(n);
            BufferedReader br1 = new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/input.txt")));
            String ss1;
            while ((ss1 = br1.readLine()) != null) 
            {
               w2[m] = ss1;
               System.out.println(w2[m]);
               m++;
            }
            System.out.println(m);
   			
   			
            for (int i = 0; i < n; i++) 
            {
            	str2 = w1[i];
            	for(int j = 0; j < m ; j++)
            	{
            	str1 = w2[j];
                //str1 =searchInput.input;
                jaccard jc= new jaccard();
                jc.run(str1, str2,j+1,i+1);
            	}
            }
            String word1,word2;
            double sim;
            Statement stmt2=con.createStatement();
            ResultSet rs= stmt2.executeQuery("select `word1`, `word2`, `similarity` from jaccard");
            while(rs.next())
            {
             word1=rs.getString(1);
             word2=rs.getString(2);
             sim=rs.getDouble(3);
             jTextArea1.append(word1+"\t\t"+word2+"\t\t"+sim+"\n");
            }

            JOptionPane.showMessageDialog(null,"Similarity is Calculated");
      } 
      catch (Exception e) 
      {
            System.out.println(e);
      }

    }

    private void close(ResultSet res1) {
		
		
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
       signature s=new signature();
       s.setVisible(true);
       CloseFrame();
    }
	public void CloseFrame(){
        super.dispose();
    }

   
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new similarity().setVisible(true);
                 try 
                 {
                	 UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                 }
                 catch (ClassNotFoundException ex) 
                 {
                	 java.util.logging.Logger.getLogger(similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 }
                 catch (InstantiationException ex) 
                 {
                	 java.util.logging.Logger.getLogger(similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 } 
                 catch (IllegalAccessException ex) 
                 {
                	 java.util.logging.Logger.getLogger(similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 } 
                 catch (javax.swing.UnsupportedLookAndFeelException ex) 
                 {
                	 java.util.logging.Logger.getLogger(similarity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 }
            }
        });
    }

}
