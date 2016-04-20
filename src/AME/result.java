package AME;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import org.jfree.ui.RefineryUtilities;

public class result extends javax.swing.JFrame 
{
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
   
    public result() 
    {
        initComponents();
    }
    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new result().setVisible(true);
            }
        });
    }
    
    private void initComponents() 
    {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel3 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(910, 725));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Cambria", 3, 18));
        jLabel1.setText("Best Matched Results");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 40, 400, 22);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton1.setText("Search Results");
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton1ActionPerformed(evt);
            }
        });
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
            ));
            jScrollPane1.setViewportView(jTable1);
            
            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(359, 359, 359)
                            .addComponent(jButton1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                               // .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))))
                    .addContainerGap(61, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(64, 64, 64)
                    //.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE))
            );
            
            jPanel1.add(jPanel2);
            jPanel2.setBounds(30, 100, 840, 550);

            getContentPane().add(jPanel1);
            jPanel1.setBounds(0, 0, 920, 690);

            pack();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        try 
        {

            String s[] = new String[1000];
            int j = 0;
            int r = 0;
            String k = "signature";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/AME", "root", "");
            Statement stat = con.createStatement();
            Statement st = con.createStatement();
            javax.swing.table.DefaultTableModel t = new javax.swing.table.DefaultTableModel();
            jTable1.setModel(t);
            int count = 0;
            String string = "SELECT COUNT(*) FROM "+k;
            ResultSet res = st.executeQuery(string);
	        while (res.next())
	        {
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
            
            //String max = "Select MAX(`Weight`) from `" + k + "`";
            //int val = 1;
            //ResultSet rs2 = stat.executeQuery(max);
           /* while (rs2.next()) 
            {
            	 val =  rs2.getString(1);
            }*/
            
            String s1 = "SELECT * FROM  `" + k + "` where `Weight` > '1'";
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
    
    
}
    

