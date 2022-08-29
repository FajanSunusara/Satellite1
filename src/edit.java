
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class edit extends javax.swing.JFrame {
    
   
    /**
     * Creates new form receipt
     */
    public edit() {
        initComponents();
        
      //getdata();
         //txt_gst.setVisible(false);
                   // lbl_gstno.setVisible(false);
                    
            
        
    }

    
 

    public void getdata(){
    
        try
        {
            int  invoice = Integer.parseInt(txt_invoice.getText());
             //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
         //java.sql.Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
        // PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limt 1");
         PreparedStatement pst = conn.prepareStatement("select * from entry where invoice =?");
          pst.setInt(1,invoice);
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {
          txt_date.setDate(rs.getDate("date"));
         txt_name.setText(rs.getString("name"));
         txt_nationality.setText(rs.getString("nationality"));
         txt_person.setText(rs.getString("persons"));
         txt_address.setText(rs.getString("address"));
         txt_state.setText(rs.getString("state"));
         txt_code.setText(rs.getString("code"));
         txt_gst.setText(rs.getString("gst"));
         txt_room.setText(rs.getString("room"));
         txt_Darrival.setDate(rs.getDate("Darrival"));
         txt_Tarrival.setText(rs.getString("Tarrival"));
        txt_Ddeparture.setDate(rs.getDate("Ddeparture"));
        txt_Tdeparture.setText(rs.getString("Tdeparture"));
        
        String lodging =rs.getString("lodging");
         txt_lodging.setText(lodging);
        String amount = rs.getString("amount");
         txt_amount.setText(amount);
         
         }
         
        }
        catch(Exception e)
        { 
            e.printStackTrace();
            
        } 
      
   }
    
    
        public String UpdateData()
 {  
     String status =""; 
     int invoice = Integer.parseInt(txt_invoice.getText());
     String studentName =txt_name.getText();
     String nationality =txt_nationality.getText();
     String address =txt_address.getText();
     String state =txt_state.getText();
     String gst =txt_gst.getText();
     String room =txt_room.getText();
     int persons = Integer.parseInt(txt_person.getText());
     int code = Integer.parseInt(txt_code.getText());
     int lodging = Integer.parseInt(txt_lodging.getText());
     int amount = Integer.parseInt(txt_amount.getText());
     
   SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
   String date =dateFormat.format(txt_date.getDate());
   String Darrival =dateFormat.format(txt_Darrival.getDate());
    String Ddeparture =dateFormat.format(txt_date.getDate());  
    String Tarrival =txt_Tarrival.getText();
     String Tdeparture =txt_Tdeparture.getText();
     try
     {
         //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
         // PreparedStatement pst = conn.prepareStatement("insert into entry(invoice,date) values(?,?)");
         //PreparedStatement pst = conn.prepareStatement("update entry set name = ? where invoice=? ");
         PreparedStatement pst = conn.prepareStatement("update entry set date = ?,name=?, nationality=?,persons=?,address=?,state=?,code=?,gst=?,room=?,Darrival=?,Tarrival=?,Ddeparture=?,Tdeparture=?,lodging=?,amount=? where invoice=? ");
         
         
        pst.setString(1, date);
         pst.setString(2, studentName);
         pst.setString(3, nationality);
         pst.setInt(4, persons);
         pst.setString(5, address);
         pst.setString(6, state);
         pst.setInt(7, code);
         pst.setString(8, gst);
         pst.setString(9, room);
         pst.setString(10, Darrival);
         pst.setString(11, Tarrival);
         pst.setString(12, Ddeparture);
        pst.setString(13, Tdeparture);
        pst.setInt(14, lodging);
        pst.setInt(15, amount);
        pst.setInt(16,invoice);
         int rowcount =pst.executeUpdate();
         if (rowcount == 1 )
         {
             status="success";
         }
         else
         {
            status ="failed";
         }
        
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
   
 return status;  
 } 

        
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_code = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_state = new javax.swing.JTextField();
        lbl_gstno = new javax.swing.JLabel();
        txt_gst = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_Tarrival = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_nationality = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_person = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_room = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_Darrival = new com.toedter.calendar.JDateChooser();
        txt_date = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_Tdeparture = new javax.swing.JTextField();
        txt_Ddeparture = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txt_lodging = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        txt_invoice = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Code :");
        jPanel21.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 100, 30));

        txt_code.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codeActionPerformed(evt);
            }
        });
        jPanel21.add(txt_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Date:");
        jPanel21.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 60, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Name   :");
        jPanel21.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 30));

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 650, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("Address :");
        jPanel21.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 30));

        txt_address.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 650, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel17.setText("Invoice No.");
        jPanel21.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel18.setText("State     :");
        jPanel21.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 100, 30));

        txt_state.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_state, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 220, 30));

        lbl_gstno.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_gstno.setText("GST No. :");
        jPanel21.add(lbl_gstno, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 90, 30));

        txt_gst.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_gst, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 200, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel27.setText("Date Of Arrival :");
        jPanel21.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 150, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel29.setText("Time of Arrival :");
        jPanel21.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 150, 30));

        txt_Tarrival.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_Tarrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 170, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel30.setText("Nationality");
        jPanel21.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        txt_nationality.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 220, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel31.setText("No. of person :");
        jPanel21.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 140, 30));

        txt_person.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_person, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 130, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel34.setText("Room No. :");
        jPanel21.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 30));

        txt_room.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_room, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 190, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel35.setText("Reg No.  :");
        jPanel21.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 100, 30));

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 170, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel36.setText("Amount in Rs :");
        jPanel21.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 150, 30));

        txt_amount.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel21.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 320, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel14.setText("Customer Deatails");
        jPanel21.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));
        jPanel21.add(txt_Darrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 180, 30));
        jPanel21.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 180, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel28.setText("Date Of Departure :");
        jPanel21.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 190, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel38.setText("Time of Departure:");
        jPanel21.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 180, 30));

        txt_Tdeparture.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel21.add(txt_Tdeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 140, 30));
        jPanel21.add(txt_Ddeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 140, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Lodging:");
        jPanel21.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 80, 30));

        txt_lodging.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_lodging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lodgingActionPerformed(evt);
            }
        });
        jPanel21.add(txt_lodging, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 150, 30));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jRadioButton1.setText("                GST  Applicable   ");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyPressed(evt);
            }
        });
        jPanel21.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 330, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/update1.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setBorder(null);
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, 140, 40));

        txt_invoice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_invoiceActionPerformed(evt);
            }
        });
        jPanel21.add(txt_invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 220, 30));

        getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 820, 590));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/back-button.png"))); // NOI18N
        jLabel24.setText("Back");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/home.png"))); // NOI18N
        jLabel23.setText("Home");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/logout.png"))); // NOI18N
        jLabel25.setText("Log Out");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/printer-.png"))); // NOI18N
        jLabel22.setText("Print");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jLabel22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel22KeyPressed(evt);
            }
        });
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/view all record.png"))); // NOI18N
        jLabel21.setText("Report");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 170, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/NW1.png"))); // NOI18N
        bg.setText("jLabel");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 750));

        setBounds(0, 0, 1386, 792);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codeActionPerformed

    private void txt_lodgingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lodgingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lodgingActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
          this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
                   if(jRadioButton1.isSelected()){
                       txt_gst.setVisible(true);
                    lbl_gstno.setVisible(true);
                   }
                    if(jRadioButton1.isSelected()== false){
                       txt_gst.setVisible(false);
                    lbl_gstno.setVisible(false);
                   }      // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyPressed
                              // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1KeyPressed

    private void jLabel22KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel22KeyPressed
         search sh = new search();
          sh.show();
              this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel22KeyPressed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
               int af =Integer.parseInt(  txt_invoice.getText());
              
                 print pt = new print();
                 //System.out.print(txt_gst.getText());
                 if(txt_gst.getText().equals("0"))
                 {//System.out.print("hello g3");
                     pt.al=af;
                 pt.getdata3();
                 pt.setVisible(true);
                 this.dispose();
                 }
                 else{
                    // System.out.print("hello g2");
                 pt.al=af;
                 pt.getdata2();
                 pt.setVisible(true);
                 this.dispose();
                 }
                 
                 
                 
           
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        JPanel panel = new JPanel();
JLabel label = new JLabel("Enter a password:");
JPasswordField pass = new JPasswordField(10);
panel.add(label);
panel.add(pass);

String[] options = new String[]{"New Password","OK","Cancel"};
int option = JOptionPane.showOptionDialog(null, panel, "The title",
                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                         null, options, options[1]);
if(option == 1) // pressing OK button
{
    char[] password = pass.getPassword();
         String  pas = pass.getText();
         String pss = pas.trim();
         passwordCheck pc = new passwordCheck();
         int pk =pc.Pcheck(pss);
    //if(pas.trim().equals("faizan"))
    if(pk == 1)
    {
        
         String result = UpdateData();
             if(result.equals("success"))
             {
                 JOptionPane.showMessageDialog(this, "Record updated successfully");
                    
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "Record updatation  failed");
             }
             
    }else
    {
     JOptionPane.showMessageDialog(this,"Incorrect password ");
    
    }
    System.out.println("Your password is: " + new String(password));
}
  if (option == 0)
  {
      
      char[] password = pass.getPassword();
         String  pas = pass.getText();
         String pss = pas.trim();
         passwordCheck pc = new passwordCheck();
         int pk =pc.Pcheck(pss);
    //if(pas.trim().equals("faizan"))
    if(pk == 1)
    {
       
        NewPassword np =new NewPassword();
      np.show();
    }else
    {
     JOptionPane.showMessageDialog(this,"Incorrect password ");
    
    }
      
      
              
              
              }

        
       
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_invoiceActionPerformed
           getdata();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_invoiceActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        receipt rp = new receipt();
        rp.show();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
     search sh = new search();
          sh.show();
              this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
       Report rp = new Report();
       rp.show();
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

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
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JLabel lbl_gstno;
    private com.toedter.calendar.JDateChooser txt_Darrival;
    private com.toedter.calendar.JDateChooser txt_Ddeparture;
    private javax.swing.JTextField txt_Tarrival;
    private javax.swing.JTextField txt_Tdeparture;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_code;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_gst;
    public javax.swing.JTextField txt_invoice;
    private javax.swing.JTextField txt_lodging;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nationality;
    private javax.swing.JTextField txt_person;
    private javax.swing.JTextField txt_room;
    private javax.swing.JTextField txt_state;
    // End of variables declaration//GEN-END:variables
}
