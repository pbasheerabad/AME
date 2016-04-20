package AME;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class signature extends javax.swing.JFrame
{
	public static String str1;
	int stt1;
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
	
	public signature() 
	   {
	        initComponents();
	   }
	
	@SuppressWarnings("unchecked")
	
	private void initComponents() 
    {
		jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(910, 725));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Signature Sets", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(0, 0, 0))); 

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton2.setText("Show");
        jButton2.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton2ActionPerformed(evt);
            }
        });
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
            ));
            jScrollPane1.setViewportView(jTable1);

            jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14));
            jButton1.setText("Load");
            jButton1.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    jButton1ActionPerformed(evt);
                }
            });
            
            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(574, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
                .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            );
            jPanel1.add(jPanel2);
            jPanel2.setBounds(50, 90, 790, 570);

            jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); 
            jLabel1.setText("Signature Sets of Potential Matches");
            jPanel1.add(jLabel1);
            jLabel1.setBounds(300, 40, 370, 40);

            getContentPane().add(jPanel1);
            jPanel1.setBounds(0, 0, 920, 710);

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
	   			ResultSet res1 = meta.getTables(null, null, "signature", null); 
	   			if(!res1.next())
	   			{ 
	   				String sql2 = "CREATE TABLE signature " + 
	   						"(`Doc_id` int(100), `Input Data` varchar(20000),`rid` int(100),`Dictionary Data` varchar(10000), `Matched Tokens` varchar(10000), `Weight` double)";
	   				stmt.executeUpdate(sql2);		
	   			} 
	   			else
	   			{
	   				stmt.executeUpdate("TRUNCATE TABLE `signature`"); 			    
	   			}
	            
	            close(res1);
	            
	            String word1,word2;
	            int docid;
	            int rid;
	           // word1 = searchInput.input;
	            Statement stmt2=con.createStatement();
	            
	            ResultSet rs= stmt2.executeQuery("select distinct `Doc_id`, `word1`,`id`, `word2` from new_dictionary");
	            while(rs.next())
	            {
	             docid=rs.getInt(1);
	             word1=rs.getString(2);
	             rid=rs.getInt(3);
	             word2=rs.getString(4);
	             run(word1, word2, docid, rid);
	            }
	            JOptionPane.showMessageDialog(this, "Signature set is built");
	      }
		catch (Exception e) 
	      {
	            System.out.println(e);
	      }
    }
	
	private void close(ResultSet res1) 
	{
	
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {
		try
		{
			String s[] = new String[1000];
	        int j = 0;
	        int r = 0;
	        int count = 0;
	        String k = "signature";
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/AME", "root", "");
	        Statement stat = con.createStatement();
	        Statement st = con.createStatement();
	        javax.swing.table.DefaultTableModel t = new javax.swing.table.DefaultTableModel();
	        jTable1.setModel(t);
	        ResultSet res = st.executeQuery("SELECT COUNT(*) FROM "+k);
	        while (res.next()){
	        count = res.getInt(1);
	        }
     
	        for (int i = 0; i < count; i++) 
	        {
	        	t.insertRow(i, new Object[]{""});
	        }
	        String ss = "SHOW COLUMNS FROM `" + k + "`";
	        ResultSet rs1 = stat.executeQuery(ss);
	        while (rs1.next()) 
	        {
	            t.addColumn(rs1.getString(1));
	        }
	        String s1 = "SELECT * FROM  `" + k + "`";
	        rs1 = stat.executeQuery(s1);
	        while (rs1.next()) 
	        {
	        	for (int i1 = 0; i1 < 6; i1++) 
	        	{
                s[i1] = rs1.getString(i1 + 1);
                System.out.println(s[i1]);
                t.setValueAt(s[i1], r, j++);
	        	}
	        	r++;
	        	j = 0;
	        }
		} 
		catch (Exception e) 
		{
        System.out.println(e.getMessage());
		}
    }
        
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	result r=new result();
        r.setVisible(true);
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
            new signature().setVisible(true);
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
public static void run( String word1, String word2, int i, int k) 
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
	
    ArrayList<String> j1 = new ArrayList<String>();
    ArrayList<String> j2 = new ArrayList<String>();
    HashSet<String> set1 = new HashSet<String>();
    HashSet<String> set2 = new HashSet<String>();
    String str1[];
    String str2[];
    String word3 = word1.replaceAll(Pattern.quote(","),"");
    String word4 = word3.replaceAll(Pattern.quote("."),"");
    ResultSet rs = st.executeQuery("Select Count(*) AS rowcount from new_dictionary");
    System.out.println("Word1= "+ word4);
    System.out.println("Word2= "+ word2);
    System.out.println("i= "+i);
    System.out.println("k= "+k);
    while(rs.next())
    {
    	str1 = word4.split(" ");
    	str2 = word2.split(" ");
    	for (int x = 0; x < str1.length; x++)
    	{
    		j1.add(str1[x]);
    	}
    	for (int x = 0; x < str2.length; x++)
    	{
    		j2.add(str2[x]);
    	}
    	
    	/*Iterator<String> itr1 = j1.iterator();
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


        //Iterator<String> iterator = set1.iterator();
        String hashStringOut = "";
        //iterator.next();
        //for(;iterator.hasNext();)
        
        for(String iterator : set1)
        {
        	 hashStringOut += iterator;
        	 hashStringOut += ", ";
        	 
        }
        if(set1.size()>0)
        {
        	st1.executeUpdate("INSERT INTO `ame`.`signature` (`Doc_id`, `Input Data`,`rid`,`Dictionary Data`, `Matched Tokens`, `Weight`) VALUES ('"+i+"','"+word4+"','"+k+"','"+word2+"','{"+hashStringOut+"}', '"+set1.size()+"');");
        }
    }
    
	}
	catch(Exception e)
	{
  	 System.err.println(e);
	}
	}
}