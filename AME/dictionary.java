package AME;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import javax.swing.*;

public class dictionary extends javax.swing.JFrame 
{
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    
	String[] doc=new String[15];
    public static String s,name;
    public static int column,n;
    public dictionary() 
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    
    private void initComponents() 
    {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jTextArea2 = new JTextArea();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(910, 725));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(125,125,125));
        jPanel3.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dictionary Content", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(51, 51, 51))); 

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        jButton3.setText("Show");
        jButton3.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton3ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(175, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(172, 172, 172))
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(25, Short.MAX_VALUE))
        );
        
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(36, Short.MAX_VALUE))
            );
        
        jPanel3.add(jPanel2);
        jPanel2.setBounds(460, 140, 410, 470);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18));
        jLabel1.setText("Dictionary");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(385, 42, 200, 22);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dataset Files", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        jButton1.setText("List");
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton1ActionPerformed(evt);
            }
        });
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(157, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(153, 153, 153))
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(34, 34, 34)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(32, Short.MAX_VALUE))
        );
        
        jPanel3.add(jPanel1);
        jPanel1.setBounds(20, 140, 410, 470);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton2ActionPerformed(evt);
            }
        });
        
        jPanel3.add(jButton2);
        jButton2.setBounds(730, 640, 80, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 960, 690);

        pack();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	try
    	{
    		jTextArea1.append("\n\nFilename\t\tFilesize\n________\t\t_______");
            String files; int k=0;
            HashMap hm=new HashMap();
            long size=0;
            File folder = new File("C:/Users/Public/Documents/Dataset/");
            File[] listOfFiles = folder.listFiles();
            n=listOfFiles.length;
            for (int i = 0; i < listOfFiles.length; i++) 
            {
                if (listOfFiles[i].isFile()) 
                {
                    files = listOfFiles[i].getName();
                    size=(long) listOfFiles[i].length();
                    if(files.contains(".txt"))
                    {
                        doc[i]=files;
                        jTextArea1.append("\n\n"+files+"\t\t"+size);
                        System.out.println("C:/Users/Public/Documents/Dataset/"+files);
                        hm.put(files, k);
                        k++;
                    }
                 }
            }
            jTextArea1.append("\n\n");
            Set s = hm.entrySet();
            Iterator i = s.iterator();
            while (i.hasNext()) 
            {
                    String s1=i.next().toString();
                    StringTokenizer st=new StringTokenizer(s1,"=");
                    while(st.hasMoreTokens())
                    {
                        String n1=st.nextToken();
                        String n2=st.nextToken();
                    }

                }
    	}
    	catch(Exception e)
    	{
            System.out.println(e.getMessage());
        }

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	try
        {
          String files; int k=0;
          HashMap hm=new HashMap();
          long size=0;
          File folder = new File("C:/Users/Public/Documents/Dataset/");

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
                      jTextArea2.append("\n\n"+files+"\n----------");
                      String str;
                      while((str=br.readLine())!=null)
                      {
                          jTextArea2.append("\n"+str);
                      }
                      System.out.println("C:/Users/Public/Documents/Dataset/"+files);
                      hm.put(files, k);
                      k++;
                   }
               }
          }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	staging s = new staging();
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
                new dictionary().setVisible(true);
                 try 
                 {
                	 UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                 }
                 catch (ClassNotFoundException ex) 
                 {
                	 java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 }
                 catch (InstantiationException ex) 
                 {
                	 java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 } 
                 catch (IllegalAccessException ex) 
                 {
                	 java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 } 
                 catch (javax.swing.UnsupportedLookAndFeelException ex) 
                 {
                	 java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                 }
            
            }
        });
    }
}