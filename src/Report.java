 
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Report extends javax.swing.JFrame {
  

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
    }
    public void createExcel()
    { XSSFWorkbook wb = new XSSFWorkbook();
      XSSFSheet ws = wb.createSheet(); 
      DefaultTableModel model = (DefaultTableModel)tbl_feesDetails.getModel();
    
      TreeMap<String,Object[]>map = new TreeMap<String,Object[]>();
      map.put("0",new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),
          model.getColumnName(4),model.getColumnName(5),model.getColumnName(6),model.getColumnName(7),model.getColumnName(8),
          model.getColumnName(9),model.getColumnName(10),model.getColumnName(11),model.getColumnName(12),model.getColumnName(13)
              ,model.getColumnName(14),model.getColumnName(15)
      });
      
      for(int i = 1;i<model.getRowCount();i++)
      {
          map.put(Integer.toString(i),new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3),
          model.getValueAt(i, 4),model.getValueAt(i, 5),model.getValueAt(i, 6),model.getValueAt(i,7),model.getValueAt(i, 8),
                  model.getValueAt(i, 9),model.getValueAt(i, 10),model.getValueAt(i, 11),model.getValueAt(i, 12),model.getValueAt(i, 13),
                  model.getValueAt(i, 14),model.getValueAt(i, 15)
      });
      }
      Set<String>id =map.keySet();
      XSSFRow fRow;
      int rowId =0;
      for (String Key:id)
      {
          fRow =ws.createRow(rowId++);
          Object []value =map.get(Key); 
          int cellId = 0;
          for(Object object:value)
          {
          XSSFCell cell =fRow.createCell(cellId++);
          cell.setCellValue(object.toString());
          }
          
          try(FileOutputStream fos =new FileOutputStream(new File(jTextField1.getText()) ) )
          {
              wb.write(fos);
              JOptionPane.showMessageDialog(this, "File exported successfully"+jTextField1.getText());
          }catch(Exception e){e.printStackTrace();}
          
      }
    }
public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tbl_feesDetails.getModel();
        model.setRowCount(1);
    }
 
public void setRecordsToTable(){
        int total ;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String fromDate= dateFormat.format(DCfrom.getDate());
        String toDate= dateFormat.format(DCto.getDate());
           int gts=0;
        Float amountTotal = 0.0f;
        
        int np=0;
    
        try {
           java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
            PreparedStatement pst = conn.prepareStatement("select * from entry where dATE between ? and ?");
            pst.setString(1, fromDate);
            pst.setString(2,toDate);
            
            
            
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                
                String invoice= rs.getString("invoice");
                String date = rs.getString("date");
                String Name = rs.getString("name");
                String nationality = rs.getString("nationality");
                String person = rs.getString("persons");
                String room = rs.getString("room");
                String Darrival = rs.getString("Darrival");
                String Ddeparture = rs.getString("Ddeparture");
                String Tarrival = rs.getString("Tarrival");
                String Tdeparture = rs.getString("Tdeparture");
                
                String gst = rs.getString("gst");
                int lodging = rs.getInt("lodging");
                 int amount = rs.getInt("amount");
                 
                 
                    
                   gts = (6*(lodging*amount)/100);   
                  total=lodging*amount+2*gts; 
               int price =  lodging*amount; 
               String  s =Integer.toString(lodging); 
               String  L =Integer.toString(amount);
               String  p =Integer.toString(total);
               String  k =Integer.toString(price);
            
               String  g =Integer.toString(gts);
                 Object Tdata[] = {invoice,date,Name,room,s,L,person,Darrival,Ddeparture,gst,Tarrival,Tdeparture,k,g,g,p};
                
             
              DefaultTableModel sa;
                sa = (DefaultTableModel)tbl_feesDetails.getModel();
              sa.addRow(Tdata);
               amountTotal = amountTotal + amount;
              
            }
            
        }

       catch (Exception e) {
            e.printStackTrace(); }

} 
/*public void setRecordsToTable(){
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String fromDate= dateFormat.format(DCfrom.getDate());
        String toDate= dateFormat.format(DCto.getDate());
        
        Float amountTotal = 0.0f;
        
        int np=0;
    
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
            PreparedStatement pst = conn.prepareStatement("select * from FEES_DETAILS where DATE between ? and ? " );
            pst.setString(1, fromDate);
            pst.setString(2,toDate);
            
            
            
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                
                String ReceiptNo= rs.getString("RECIEPT_NO");
                String RollNo = rs.getString("ROLL_NO");
                String StudentName = rs.getString("STUDENT_NAME");
                String course = rs.getString("COURSE_NAME");
                Float amount = rs.getFloat("TOTAL_AMOUNT");
                String remark = rs.getString("REMARK");
                 int remaining = rs.getInt("REMIANING");
               
               String  s =Float.toString(amountTotal); 
               String  L =Integer.toString(remaining);
                 Object Tdata[] = {ReceiptNo,RollNo,StudentName,course,amount,L};
                
             
              DefaultTableModel sa;
                sa = (DefaultTableModel)tbl_feesDetails.getModel();
              sa.addRow(Tdata);
               
            }
            
        }

       catch (Exception e) {
            e.printStackTrace(); }

} */

 public void DeleteTable(String a,String b )
    {
     try
     {   
         java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
            PreparedStatement pst = conn.prepareStatement("delete from entry where dATE between ? and ?");
            pst.setString(1, a);
            pst.setString(2,b);
            
            
            
            int rowCount =pst.executeUpdate();
            System.out.print(rowCount);
         
        if(rowCount == 1)
        {  clearTable();
            JOptionPane.showMessageDialog(this," Course Deleted Successfully"); 
            
           // fillTable();
            //setRecordsToTable();
        }
        else
        {
            JOptionPane.showMessageDialog(this," Dish deletion Unsuccessfull");
        }
         
     
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        DCto = new com.toedter.calendar.JDateChooser();
        DCfrom = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_feesDetails = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel14.setText("To :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 40, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel16.setText("Select Path & Folder :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel17.setText("From :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 50, 40));

        DCto.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPanel1.add(DCto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 180, 40));

        DCfrom.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPanel1.add(DCfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 170, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/folder.png"))); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 140, 40));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 140, 40));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 410, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/104853_excel_icon.png"))); // NOI18N
        jButton3.setText("Import To Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 190, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/delete.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 190, 40));

        tbl_feesDetails.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbl_feesDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "invoice No.", "date", "name", "room", "lodging", "price", "persons", "Date arrival", "Date departure", "Gst No.", "Tarrival", "Tdeparture", "amount", "CGST", "SGST", "total"
            }
        ));
        jScrollPane1.setViewportView(tbl_feesDetails);
        if (tbl_feesDetails.getColumnModel().getColumnCount() > 0) {
            tbl_feesDetails.getColumnModel().getColumn(0).setMinWidth(10);
            tbl_feesDetails.getColumnModel().getColumn(0).setMaxWidth(70);
            tbl_feesDetails.getColumnModel().getColumn(1).setMinWidth(100);
            tbl_feesDetails.getColumnModel().getColumn(2).setMinWidth(200);
            tbl_feesDetails.getColumnModel().getColumn(3).setMinWidth(30);
            tbl_feesDetails.getColumnModel().getColumn(4).setMinWidth(10);
            tbl_feesDetails.getColumnModel().getColumn(4).setMaxWidth(50);
            tbl_feesDetails.getColumnModel().getColumn(5).setMinWidth(70);
            tbl_feesDetails.getColumnModel().getColumn(6).setMinWidth(30);
            tbl_feesDetails.getColumnModel().getColumn(6).setMaxWidth(50);
            tbl_feesDetails.getColumnModel().getColumn(8).setMaxWidth(100);
            tbl_feesDetails.getColumnModel().getColumn(12).setMinWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 930, 410));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel18.setText("Select Date :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 1010, 620));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 0));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/report.png"))); // NOI18N
        jLabel21.setText("Report");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 170, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/search2.png"))); // NOI18N
        jLabel22.setText("Search ");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 180, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/home.png"))); // NOI18N
        jLabel23.setText("Home");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/back-button.png"))); // NOI18N
        jLabel24.setText("Back");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/logout.png"))); // NOI18N
        jLabel25.setText("Log Out");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/NW1.png"))); // NOI18N
        bg.setText("jLabel");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 750));

        setSize(new java.awt.Dimension(1401, 784));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new   JFileChooser ();
        fileChooser.showOpenDialog(this);
        SimpleDateFormat dateFormate = new  SimpleDateFormat ("YYY-MM-dd");
        String date = dateFormate.format(new Date());
        try{
            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            path = path+""+date+".xlsx";
            jTextField1.setText(path);

        }catch(Exception e){}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clearTable();
        setRecordsToTable();
        //selectTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        
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
        createExcel();
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
               
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
        int input = JOptionPane.showOptionDialog(this, "Confirm you  want to delete data", "Warning",0 , JOptionPane.WARNING_MESSAGE, null, null, null);
        
     if(input == JOptionPane.OK_OPTION)
{
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String fromDate= dateFormat.format(DCfrom.getDate());
        String toDate= dateFormat.format(DCto.getDate());
       DeleteTable(fromDate,toDate);
}
     else
     {//jTextField1.setText("0");
         
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
       
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
               receipt rp =new receipt();
               rp.show();
                this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
          search sh =new search();
          sh.show();
               this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCfrom;
    private com.toedter.calendar.JDateChooser DCto;
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_feesDetails;
    // End of variables declaration//GEN-END:variables
}
