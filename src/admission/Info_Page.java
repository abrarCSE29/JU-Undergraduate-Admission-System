/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admission;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author abrar
 */
public class Info_Page extends javax.swing.JFrame {

    /**
     * Creates new form Info_Page
     */
    
    String Mobile;
    public Info_Page() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    
    public void setName()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            String sql = "SELECT name FROM std WHERE username= ?";
        
            PreparedStatement st;
            
            st=con.prepareStatement(sql);
            st.setString(1,Mobile);
            ResultSet  rs = st.executeQuery();
            
            
            while(rs.next())
            {
                String x = rs.getString("name");
                txtName.setText(x);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public void setFname()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/std_info","root","");
            String sql = "SELECT fname FROM std WHERE username= ?";
            
            PreparedStatement st;
            
            st=con.prepareStatement(sql);
            st.setString(1,Mobile);
            ResultSet  rs = st.executeQuery();
            
            
            while(rs.next())
            {
                String x = rs.getString("fname");
                txtFname.setText(x);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     public void setMname()
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
                String x = rs.getString("Mname");
                txtMname.setText(x);
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
     public void setallotherval()
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
                String x = rs.getString("dob");
                txtDob.setText(x);
                
                x = rs.getString("email");
                txtEmail.setText(x);
                
                 x = rs.getString("mobile");
                txtAux.setText(x);
                
                 x = rs.getString("gender");
                txtGender.setText(x);
                
                scroll.setText(rs.getString("scroll"));
                screg.setText(rs.getString("screg"));
                scboard.setText(rs.getString("scboard"));
                scyear.setText(rs.getString("scyear"));
                scgpa.setText(rs.getString("scgpa"));
                scfac.setText(rs.getString("scfac"));
                
                hcroll.setText(rs.getString("hcroll"));
                hcreg.setText(rs.getString("hcreg"));
                hcboard.setText(rs.getString("hcboard"));
                hcyear.setText(rs.getString("hcyear"));
                hcgpa.setText(rs.getString("hcgpa"));
                hcfac.setText(rs.getString("hcfac"));
                
                ImageIcon i =new ImageIcon(rs.getString("image"));
                Image img = i.getImage().getScaledInstance(iBox.getWidth(), iBox.getHeight(), Image.SCALE_SMOOTH);
                iBox.setIcon(new ImageIcon(img));
                
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Info_Page.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    public Info_Page(String s) {
        initComponents();
        setLocationRelativeTo(null);
        Mobile=s;

        setName();
        setFname();
        setMname();
        setallotherval();
        
    }
    
    
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtMname = new javax.swing.JTextField();
        txtDob = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        txtAux = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        scboard = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        scyear = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        scgpa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        scroll = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        screg = new javax.swing.JTextField();
        hcboard = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        hcyear = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        hcgpa = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        hcroll = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        hcreg = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        iBox = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        hcfac = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        scfac = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Applicant's Info");
        setMaximumSize(new java.awt.Dimension(2000, 2000));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(1650, 1000));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 183, 122, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Father's Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 223, 158, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mother's Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 267, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("DOB");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 307, 118, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 132, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Auxiliary Contact");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Gender");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 347, 118, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("APPLICANT DETAILS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 281, 41));

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setBorder(new javax.swing.border.MatteBorder(null));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 183, 290, -1));

        txtFname.setEditable(false);
        txtFname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFname.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 225, 290, -1));

        txtMname.setEditable(false);
        txtMname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMname.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(txtMname, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 267, 290, -1));

        txtDob.setEditable(false);
        txtDob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDob.setBorder(new javax.swing.border.MatteBorder(null));
        txtDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDobActionPerformed(evt);
            }
        });
        jPanel1.add(txtDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 309, 290, -1));

        txtGender.setEditable(false);
        txtGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGender.setBorder(new javax.swing.border.MatteBorder(null));
        txtGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenderActionPerformed(evt);
            }
        });
        jPanel1.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 351, 290, -1));

        txtAux.setEditable(false);
        txtAux.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAux.setBorder(new javax.swing.border.MatteBorder(null));
        txtAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuxActionPerformed(evt);
            }
        });
        jPanel1.add(txtAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 230, -1));

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 370, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("ACADEMIC INFO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 484, 242, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("PERSONAL INFO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 106, 242, -1));

        scboard.setEditable(false);
        scboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scboard.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(scboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 631, 220, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("BOARD");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 632, 118, -1));

        scyear.setEditable(false);
        scyear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scyear.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(scyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 547, 220, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("YEAR");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 545, 118, -1));

        scgpa.setEditable(false);
        scgpa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scgpa.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(scgpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 589, 220, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("GPA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 585, 118, -1));

        scroll.setEditable(false);
        scroll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scroll.setBorder(new javax.swing.border.MatteBorder(null));
        scroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrollActionPerformed(evt);
            }
        });
        jPanel1.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 545, 220, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("SSC ROLL");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 549, 122, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("SSC REGISTRATION");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 589, 170, -1));

        screg.setEditable(false);
        screg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        screg.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(screg, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 587, 220, -1));

        hcboard.setEditable(false);
        hcboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcboard.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(hcboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 825, 220, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("BOARD");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 825, 118, -1));

        hcyear.setEditable(false);
        hcyear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcyear.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(hcyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 745, 220, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("YEAR");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 745, 118, -1));

        hcgpa.setEditable(false);
        hcgpa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcgpa.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(hcgpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 785, 220, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("GPA");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 785, 118, -1));

        hcroll.setEditable(false);
        hcroll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcroll.setBorder(new javax.swing.border.MatteBorder(null));
        hcroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hcrollActionPerformed(evt);
            }
        });
        jPanel1.add(hcroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 745, 220, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("HSC ROLL");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 745, 122, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("HSC REGISTRATION");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 785, 170, -1));

        hcreg.setEditable(false);
        hcreg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcreg.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(hcreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 785, 220, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 436, 1110, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("LOG OUT");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 20, 95, 41));

        panel.setBackground(new java.awt.Color(204, 204, 204));
        panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iBox, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 150, 210, 200));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 870, 950, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("PRINT INFO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 500, 210, -1));

        hcfac.setEditable(false);
        hcfac.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcfac.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(hcfac, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 830, 220, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("BACKGROUND");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 830, 140, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("BACKGROUND");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 630, 118, -1));

        scfac.setEditable(false);
        scfac.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scfac.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(scfac, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 630, 220, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("APPLY FOR UNITS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 450, 210, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1625, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuxActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        
       
        
    }//GEN-LAST:event_txtNameActionPerformed

    private void scrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollActionPerformed

    private void hcrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hcrollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hcrollActionPerformed

    private void txtDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDobActionPerformed

    private void txtGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        new Print_info(Mobile).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       new Unit_Apply(Mobile).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Info_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hcboard;
    private javax.swing.JTextField hcfac;
    private javax.swing.JTextField hcgpa;
    private javax.swing.JTextField hcreg;
    private javax.swing.JTextField hcroll;
    private javax.swing.JTextField hcyear;
    private javax.swing.JLabel iBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField scboard;
    private javax.swing.JTextField scfac;
    private javax.swing.JTextField scgpa;
    private javax.swing.JTextField screg;
    private javax.swing.JTextField scroll;
    private javax.swing.JTextField scyear;
    private javax.swing.JTextField txtAux;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtMname;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
