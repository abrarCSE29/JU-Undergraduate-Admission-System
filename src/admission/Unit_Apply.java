/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admission;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abrar
 */
public class Unit_Apply extends javax.swing.JFrame {

    /**
     * Creates new form Unit_Apply
     */
    
    String Mobile;
    public Unit_Apply() {
        initComponents();
        setElg();
        setLocationRelativeTo(null);
    }
    
    public Unit_Apply(String s) {
            initComponents();
            Mobile = s;
            setElg();
            payment();
            setLocationRelativeTo(null);
    }
    
    
    public void payment()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
          String sql = "SELECT * FROM `std` WHERE username = ?";
          PreparedStatement st = con.prepareStatement(sql);
          st.setString(1,Mobile);
          
          ResultSet rs = st.executeQuery();
          
          while(rs.next())
          {
             if(rs.getString("a").contains("900"))
             {
                 pA.setText("900");
                 btA.setEnabled(false);
                 if(rs.getString("pymA").contains("900"))
                 {
                    sA.setBackground(Color.green);
                    sA.setText("PAID");
                 }
                 else
                 {
                    sA.setBackground(Color.red);
                    sA.setText("UNPAID");
                 }
                 
             }
             else
             {
                 pA.setText("Not Applied");
             }
             
             if(rs.getString("b").contains("900"))
             {
                 pB.setText("900");
                 btB.setEnabled(false);
                 if(rs.getString("pymB").contains("900"))
                 {
                    sB.setBackground(Color.green);
                    sB.setText("PAID");
                 }
                 else
                 {
                    sB.setBackground(Color.red);
                    sB.setText("UNPAID");
                 }
             }
             else
             {
                 pB.setText("Not Applied");
             }
             
             if(rs.getString("c").contains("900"))
             {
                 pC.setText("900");
                 btC.setEnabled(false);
                 
                 if(rs.getString("pymC").contains("900"))
                 {
                    sC.setBackground(Color.green);
                    sC.setText("PAID");
                 }
                 else
                 {
                    sC.setBackground(Color.red);
                    sC.setText("UNPAID");
                 }
                 
             }
             else
             {
                 pC.setText("Not Applied");
             }
             
             if(rs.getString("d").contains("600"))
             {
                 pD.setText("600");
                 btD.setEnabled(false);
                 
                 if(rs.getString("pymD").contains("600"))
                 {
                    sD.setBackground(Color.green);
                    sD.setText("PAID");
                 }
                 else
                 {
                    sD.setBackground(Color.red);
                    sD.setText("UNPAID");
                 }
                 
                 
             }
             else
             {
                 pD.setText("Not Applied");
             }
             
             if(rs.getString("e").contains("900"))
             {
                 pE.setText("900");
                 btE.setEnabled(false);
                 
                 if(rs.getString("pymE").contains("900"))
                 {
                    sE.setBackground(Color.green);
                    sE.setText("PAID");
                 }
                 else
                 {
                    sE.setBackground(Color.red);
                    sE.setText("UNPAID");
                 }
                 
    
             }
             else
             {
                 pE.setText("Not Applied");
             }
          }
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    public void setElg()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            String sql = "SELECT * FROM std WHERE username= ?";
            
            PreparedStatement st;
            
            st=con.prepareStatement(sql);
            st.setString(1,Mobile);
            ResultSet  rs = st.executeQuery();
            
            
            while(rs.next())
            {
                String sfac,hfac;
                
                sfac=rs.getString("scfac");
                hfac=rs.getString("hcfac");
                
                double sgpa = 0,hgpa = 0;
                try
                {
                    sgpa = Double.parseDouble(rs.getString("scgpa"));
                    hgpa = Double.parseDouble(rs.getString("hcgpa"));
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
                
                
                
                if(sfac.contains("SCIENCE") && hfac.contains("SCIENCE"))
                {
                    if(sgpa>=4.00 && hgpa>=4.00)
                    {
                        txtA.setText("YES");
                        txtB.setText("YES");
                        txtC.setText("YES");
                        txtD.setText("YES"); 
                        txtE.setText("YES");
                    }
                    else
                    {
                        txtA.setText("NO");
                        btA.setEnabled(false);
                        if(sgpa>=3.50 && hgpa>=3.50)
                        {
                            txtB.setText("YES");
                            txtC.setText("YES");
                        }
                        txtD.setText("NO");
                        btD.setEnabled(false);
                        txtE.setText("NO");
                        btE.setEnabled(false);
                    }
   
                }
                else if((sfac.contains("BUSINESS") && hfac.contains("BUSINESS")) || (sfac.contains("SCIENCE") && hfac.contains("BUSINESS")))
                {
                     txtA.setText("NO");
                     txtD.setText("NO");
                     btA.setEnabled(false);
                     btD.setEnabled(false);
                     
                    if(sgpa>=3.50 && hgpa>=3.50)
                    {
                        txtB.setText("YES");
                        txtC.setText("YES");
                    }
                    else
                    {
                        txtB.setText("NO");
                        txtC.setText("NO");
                        btB.setEnabled(false);
                        btC.setEnabled(false);
                    }
                    
                    if(sgpa>=3.75 && hgpa>=3.75)
                    {
                        txtE.setText("YES");
                    }
                    else
                    {
                        txtE.setText("NO");
                        btE.setEnabled(false);
                    }
                }   
            }
            
            
           con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtA = new javax.swing.JTextField();
        txtB = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        txtD = new javax.swing.JTextField();
        txtE = new javax.swing.JTextField();
        btB = new java.awt.Button();
        btA = new java.awt.Button();
        btC = new java.awt.Button();
        btD = new java.awt.Button();
        btE = new java.awt.Button();
        pA = new java.awt.TextField();
        pB = new java.awt.TextField();
        pC = new java.awt.TextField();
        pD = new java.awt.TextField();
        pE = new java.awt.TextField();
        sA = new javax.swing.JTextField();
        sB = new javax.swing.JTextField();
        sC = new javax.swing.JTextField();
        sD = new javax.swing.JTextField();
        sE = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Base.setBackground(new java.awt.Color(153, 255, 153));
        Base.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UNIT SELECTION");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(523, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(459, 459, 459))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
        );

        Base.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 80));

        Body.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("UNIT");
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Eligibility");
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apply");
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Payment");
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Status");
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("A");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("B");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("C");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("D");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("E");

        txtA.setEditable(false);
        txtA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtA.setBorder(null);

        txtB.setEditable(false);
        txtB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtB.setBorder(null);
        txtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBActionPerformed(evt);
            }
        });

        txtC.setEditable(false);
        txtC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtC.setBorder(null);

        txtD.setEditable(false);
        txtD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtD.setBorder(null);

        txtE.setEditable(false);
        txtE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtE.setBorder(null);

        btB.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btB.setLabel("Apply");
        btB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBActionPerformed(evt);
            }
        });

        btA.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btA.setLabel("Apply");
        btA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAActionPerformed(evt);
            }
        });

        btC.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btC.setLabel("Apply");
        btC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCActionPerformed(evt);
            }
        });

        btD.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btD.setLabel("Apply");
        btD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDActionPerformed(evt);
            }
        });

        btE.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btE.setLabel("Apply");
        btE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEActionPerformed(evt);
            }
        });

        pA.setEditable(false);
        pA.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        pB.setEditable(false);
        pB.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        pC.setEditable(false);
        pC.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        pD.setEditable(false);
        pD.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        pE.setEditable(false);
        pE.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        sA.setEditable(false);
        sA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sA.setBorder(null);
        sA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sAMouseEntered(evt);
            }
        });
        sA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sAActionPerformed(evt);
            }
        });

        sB.setEditable(false);
        sB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sB.setText("\n");
        sB.setBorder(null);
        sB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sBMouseClicked(evt);
            }
        });
        sB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sBActionPerformed(evt);
            }
        });

        sC.setEditable(false);
        sC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sC.setText("\n");
        sC.setBorder(null);
        sC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sCMouseClicked(evt);
            }
        });

        sD.setEditable(false);
        sD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sD.setText("\n");
        sD.setBorder(null);
        sD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sDMouseClicked(evt);
            }
        });

        sE.setEditable(false);
        sE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sE.setText("\n");
        sE.setBorder(null);
        sE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sEMouseClicked(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9))
                            .addComponent(jLabel11))))
                .addGap(107, 107, 107)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtD, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtB, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtE))
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)))
                .addGap(9, 9, 9)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(110, 110, 110)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sA)
                    .addComponent(sB)
                    .addComponent(sC)
                    .addComponent(sD)
                    .addComponent(sE))
                .addGap(284, 284, 284))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(65, 65, 65))
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addGap(79, 79, 79)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(BodyLayout.createSequentialGroup()
                                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyLayout.createSequentialGroup()
                                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        Base.add(Body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1280, 670));

        getContentPane().add(Base, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1280, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void btAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAActionPerformed
         try {                                    
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(Mobile);
            String sql = "UPDATE `std` SET `a`=? WHERE `username`="+Mobile;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,"900");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successful");
            payment();
            
        } catch (SQLException ex) {
            Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btAActionPerformed

    private void btBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBActionPerformed
        
        
        
        
        try {                                    
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(Mobile);
            String sql = "UPDATE `std` SET `b`=? WHERE `username`="+Mobile;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,"900");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successful");
            payment();
            
        } catch (SQLException ex) {
            Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
            
    }//GEN-LAST:event_btBActionPerformed

    private void btCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCActionPerformed
        
         try {                                    
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(Mobile);
            String sql = "UPDATE `std` SET `c`=? WHERE `username`="+Mobile;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,"900");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successful");
            payment();
            
        } catch (SQLException ex) {
            Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btCActionPerformed

    private void btEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEActionPerformed
        
         try {                                    
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(Mobile);
            String sql = "UPDATE `std` SET `e`=? WHERE `username`="+Mobile;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,"900");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successful");
            payment();
            
        } catch (SQLException ex) {
            Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btEActionPerformed

    private void btDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDActionPerformed
        
         try {                                    
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(Mobile);
            String sql = "UPDATE `std` SET `d`=? WHERE `username`="+Mobile;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,"600");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successful");
            payment();
            
        } catch (SQLException ex) {
            Logger.getLogger(Unit_Apply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btDActionPerformed

    private void sBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sBActionPerformed

    private void sAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sAActionPerformed
        
        
    }//GEN-LAST:event_sAActionPerformed

    private void sAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sAMouseClicked
        new Payment(Mobile,"A").setVisible(true);
        
    }//GEN-LAST:event_sAMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        payment();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sBMouseClicked
        new Payment(Mobile,"B").setVisible(true);
        
    }//GEN-LAST:event_sBMouseClicked

    private void sCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sCMouseClicked
        new Payment(Mobile,"C").setVisible(true);
       
    }//GEN-LAST:event_sCMouseClicked

    private void sDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sDMouseClicked
        new Payment(Mobile,"D").setVisible(true);
        
    }//GEN-LAST:event_sDMouseClicked

    private void sEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sEMouseClicked
        new Payment(Mobile,"E").setVisible(true);
        
    }//GEN-LAST:event_sEMouseClicked

    private void sAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sAMouseEntered
        
    }//GEN-LAST:event_sAMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Unit_Apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unit_Apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unit_Apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unit_Apply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unit_Apply().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Header;
    private java.awt.Button btA;
    private java.awt.Button btB;
    private java.awt.Button btC;
    private java.awt.Button btD;
    private java.awt.Button btE;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextField pA;
    private java.awt.TextField pB;
    private java.awt.TextField pC;
    private java.awt.TextField pD;
    private java.awt.TextField pE;
    private javax.swing.JTextField sA;
    private javax.swing.JTextField sB;
    private javax.swing.JTextField sC;
    private javax.swing.JTextField sD;
    private javax.swing.JTextField sE;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtE;
    // End of variables declaration//GEN-END:variables
}
