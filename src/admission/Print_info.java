/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admission;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
public class Print_info extends javax.swing.JFrame {

    /**
     * Creates new form Info_Page
     */
    
    String Mobile="01521102764";
    public Print_info() {
        initComponents();
        setLocationRelativeTo(null);
        setName();
        setFname();
        setMname();
        setallotherval();
    }
    
    public Print_info(String s) {
        initComponents();
        setLocationRelativeTo(null);
        Mobile=s;

        setName();
        setFname();
        setMname();
        setallotherval();
        
    }
    
    
    
    public void setName()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public void setFname()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     public void setMname()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
     public void setallotherval()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
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
                
                
                if(rs.getString("pymA").equals("900"))
                {
                    apA.setText("YES");
                    apA.setForeground(Color.GREEN);
                }
                else
                {
                    apA.setText("NO");
                    apA.setForeground(Color.RED);
                }
                if(rs.getString("pymB").equals("900"))
                {
                    apB.setText("YES");
                    apB.setForeground(Color.GREEN);
                }
                else
                {
                    apB.setText("NO");
                    apB.setForeground(Color.RED);
                }
                if(rs.getString("pymC").equals("900"))
                {
                    apC.setText("YES");
                    apC.setForeground(Color.GREEN);
                }
                else
                {
                    apC.setText("NO");
                    apC.setForeground(Color.RED);
                }
                if(rs.getString("pymD").equals("600"))
                {
                    apD.setText("YES");
                    apD.setForeground(Color.GREEN);
                }
                else
                {
                    apD.setText("NO");
                    apD.setForeground(Color.RED);
                }
                if(rs.getString("pymE").equals("900"))
                {
                    apE.setText("YES");
                    apE.setForeground(Color.GREEN);
                }
                else
                {
                    apE.setText("NO");
                    apE.setForeground(Color.RED);
                }
                
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Print_info.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        panel_print = new javax.swing.JPanel();
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
        panel = new javax.swing.JPanel();
        iBox = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        hcfac = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        scfac = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        apA = new javax.swing.JTextField();
        apB = new javax.swing.JTextField();
        apC = new javax.swing.JTextField();
        apD = new javax.swing.JTextField();
        apE = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Applicant's Info");
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(1150, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel_print.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Father's Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mother's Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("DOB");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Auxiliary Contact");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("APPLICANT DETAILS");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setBorder(new javax.swing.border.MatteBorder(null));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtFname.setEditable(false);
        txtFname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFname.setBorder(new javax.swing.border.MatteBorder(null));

        txtMname.setEditable(false);
        txtMname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMname.setBorder(new javax.swing.border.MatteBorder(null));

        txtDob.setEditable(false);
        txtDob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDob.setBorder(new javax.swing.border.MatteBorder(null));
        txtDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDobActionPerformed(evt);
            }
        });

        txtGender.setEditable(false);
        txtGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGender.setBorder(new javax.swing.border.MatteBorder(null));
        txtGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenderActionPerformed(evt);
            }
        });

        txtAux.setEditable(false);
        txtAux.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAux.setBorder(new javax.swing.border.MatteBorder(null));
        txtAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuxActionPerformed(evt);
            }
        });

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("UNITS APPLIED");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("PERSONAL INFO");

        scboard.setEditable(false);
        scboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scboard.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("BOARD");

        scyear.setEditable(false);
        scyear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scyear.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("YEAR");

        scgpa.setEditable(false);
        scgpa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scgpa.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("GPA");

        scroll.setEditable(false);
        scroll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scroll.setBorder(new javax.swing.border.MatteBorder(null));
        scroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrollActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("SSC ROLL");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("SSC REGISTRATION");

        screg.setEditable(false);
        screg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        screg.setBorder(new javax.swing.border.MatteBorder(null));

        hcboard.setEditable(false);
        hcboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcboard.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("BOARD");

        hcyear.setEditable(false);
        hcyear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcyear.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("YEAR");

        hcgpa.setEditable(false);
        hcgpa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcgpa.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("GPA");

        hcroll.setEditable(false);
        hcroll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcroll.setBorder(new javax.swing.border.MatteBorder(null));
        hcroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hcrollActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("HSC ROLL");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("HSC REGISTRATION");

        hcreg.setEditable(false);
        hcreg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcreg.setBorder(new javax.swing.border.MatteBorder(null));

        panel.setBackground(new java.awt.Color(204, 204, 204));
        panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(iBox, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(iBox, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
        );

        hcfac.setEditable(false);
        hcfac.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hcfac.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("BACKGROUND");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("BACKGROUND");

        scfac.setEditable(false);
        scfac.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scfac.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setText("A");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setText("B");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setText("C");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel26.setText("D");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel27.setText("E");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("ACADEMIC INFO");

        apA.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        apA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apA.setText("\n");
        apA.setPreferredSize(new java.awt.Dimension(50, 22));
        apA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apAActionPerformed(evt);
            }
        });

        apB.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        apB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apB.setText("\n");
        apB.setPreferredSize(new java.awt.Dimension(50, 22));

        apC.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        apC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apC.setText("\n");
        apC.setPreferredSize(new java.awt.Dimension(50, 22));

        apD.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        apD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apD.setText("\n");
        apD.setPreferredSize(new java.awt.Dimension(50, 22));

        apE.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        apE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apE.setText("\n");
        apE.setPreferredSize(new java.awt.Dimension(50, 22));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admission/logo 160px.png"))); // NOI18N
        jLabel29.setText("JAHANGIRNAGAR UNIVERSITY UNDERGRADUATE ADMISSION 2022");

        javax.swing.GroupLayout panel_printLayout = new javax.swing.GroupLayout(panel_print);
        panel_print.setLayout(panel_printLayout);
        panel_printLayout.setHorizontalGroup(
            panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_printLayout.createSequentialGroup()
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(58, 58, 58)
                                .addComponent(txtAux, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMname, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(489, 489, 489))
            .addGroup(panel_printLayout.createSequentialGroup()
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(scyear, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(screg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(scgpa, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(scboard, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(scfac, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(hcroll, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(hcyear, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(hcreg, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(hcgpa, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(hcboard, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(hcfac, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel23)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel24)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel25)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel26)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel27))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addComponent(apA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(apB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(apC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(apD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(apE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_printLayout.setVerticalGroup(
            panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_printLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel10)
                        .addGap(69, 69, 69)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel4))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1)
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(txtMname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_printLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2)))
                        .addGap(10, 10, 10)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_printLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel28)
                .addGap(40, 40, 40)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(scyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(screg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(scgpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(scboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22)
                    .addComponent(scfac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(hcroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(hcyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(hcreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(hcgpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(hcboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(hcfac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(48, 48, 48)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(12, 12, 12)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(panel_print);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1290, 1310));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PRINT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 9, -1, -1));

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

    private void apAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apAActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47,0.47);
                
                panel_print.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }
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
            java.util.logging.Logger.getLogger(Print_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apA;
    private javax.swing.JTextField apB;
    private javax.swing.JTextField apC;
    private javax.swing.JTextField apD;
    private javax.swing.JTextField apE;
    private javax.swing.JTextField hcboard;
    private javax.swing.JTextField hcfac;
    private javax.swing.JTextField hcgpa;
    private javax.swing.JTextField hcreg;
    private javax.swing.JTextField hcroll;
    private javax.swing.JTextField hcyear;
    private javax.swing.JLabel iBox;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel_print;
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
