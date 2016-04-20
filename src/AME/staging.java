package AME;

import java.io.*;
import java.sql.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.UIManager;


public class staging extends javax.swing.JFrame 
{
	public static String str1;
	int stt1;
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton4;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
	String[] doc=new String[15];
    public staging() 
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
        jButton4 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(910, 725));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(125,125,125));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dictionary Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(0, 0, 0))); 

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        jButton4.setText("Next");
        jButton4.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton4ActionPerformed(evt);
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
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(21, 21, 21))
        );
        jPanel1.add(jPanel2);
        jPanel2.setBounds(50, 90, 790, 570);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); 
        jLabel1.setText("Dictionary Table Data");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(350, 40, 350, 40);

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
   			ResultSet res = meta.getTables(null, null, "dictionary", null); 
   			if(!res.next())
   			{ 
   				String sql1 = "CREATE TABLE dictionary " + 
   						"(`id` int(100),`Title` varchar(2000))";
   				stmt.executeUpdate(sql1);		
   			} 
   			else
   			{
   				stmt.executeUpdate("TRUNCATE TABLE `dictionary`"); 			    
   			}
               
               String files;
               long size=0;
               int a = 0;
               String str = null;
               File folder = new File("C:/Users/Public/Documents/Dataset");
               int count=0;
               File[] listOfFiles = folder.listFiles();
               for (int i = 0; i < listOfFiles.length; i++) 
               {
                    if (listOfFiles[i].isFile()) 
                    {
                    	
                        files = listOfFiles[i].getName();
                        size=(long) listOfFiles[i].length();
                        if(files.contains(".txt"))
                        {
                        	System.out.println("value of i = "+i);
                            doc[i]=files;
                            BufferedReader br=new BufferedReader(new FileReader(new File("C:/Users/Public/Documents/Dataset/"+files)));
                            while((str=br.readLine())!=null)
                            {   
                            	a = a+1;
                            	str = str.toLowerCase();
                                StringTokenizer st=new StringTokenizer(str,"~");
                                while(st.hasMoreTokens())
                                {
                                //stt1=Integer.parseInt(str1);
                                	str1=st.nextToken();
                                	System.out.println(str1);
                                }
                                stmt1.executeUpdate("INSERT INTO `AME`.`dictionary` (`id`, `Title`) VALUES ('"+a+"', '"+str1+"')");
                            }

                        }
                         
                    }
               }

               JOptionPane.showMessageDialog(this,"Dataset is loaded into Dictionary table");
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
     }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        try 
        {
        String s[] = new String[1000];
        int j = 0;
        int r = 0;
        int count = 0;
        String k = "dictionary";
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
     
        for (int i = 0; i <count; i++) 
        {
            t.insertRow(i, new Object[]{""});
        }
        String ss = "SHOW COLUMNS FROM `" + k + "`";
        ResultSet rs1 = stat.executeQuery(ss);
        //rs1.next();
        while (rs1.next()) 
        {
            t.addColumn(rs1.getString(1));
        }
        String s1 = "SELECT * FROM  `" + k + "`";
        rs1 = stat.executeQuery(s1);
        while (rs1.next()) 
        {
            for (int i1 = 0; i1 <=1; i1++) 
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
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        input i=new input();
        i.setVisible(true);
        CloseFrame();
    }   
    public void CloseFrame(){
        super.dispose();
    }
}