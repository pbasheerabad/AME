package AME;

import javax.swing.UIManager;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class main extends JFrame 
{
	
	private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton2;
    
   
    
	public main() 
	{
		initComponents();
	}
    
    @SuppressWarnings("unchecked")
    private void initComponents() 
    {
    	jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(800, 600));
    	
        /*addMouseListener(new java.awt.event.MouseAdapter() 
        {
            public void mouseClicked(java.awt.event.MouseEvent event) 
            {
                formMouseClicked(event);
            }
        });*/
        
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton1.setText("Next");
        final JFrame frame = this;
        jButton1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent event) 
            {
            jButton1ActionPerformed(event);
            }

            private void jButton1ActionPerformed(java.awt.event.ActionEvent event) 
            {
            	dictionary d=new dictionary();
                d.setVisible(true);
                
                frame.dispose();
            }
      
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 310, 80, 30);
        
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(125,125,125));
        
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); 
        jLabel1.setText("Efficient Algorithms for ");
      
        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 3, 18)); 
        jLabel2.setText("Approximate Membership Extraction");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(101, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(85, 85, 85)))
            .addGap(84, 84, 84))
        );
        
        jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
             .addGap(208, 208, 208)
             .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(18, 18, 18)
             .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addContainerGap(238, Short.MAX_VALUE))
        );
        
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 600);

        pack();

    }
    private void jPanel1MouseClicked(java.awt.event.MouseEvent event) 
    {
       // dictionary d=new dictionary();
       // d.setVisible(true);
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent event) 
    {   
    }
    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                 main m = new main();
                 m.setVisible(true);
                 try 
                 {
                	 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
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