
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class print extends javax.swing.JFrame {
int al = 0;
    /**
     * Creates new form print
     */
    public print() {
        initComponents();
        receipt rp =new receipt();
        
      
       // getdata();
       
        
           
         
            
        
      
        
    }
   public void gstcheck( String b )
    {   try{ 
        java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
         //java.sql.Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         //PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limt 1");
         PreparedStatement pst = conn.prepareStatement("select * from where invoice= ?"); 
         pst.setString(1, b);
         ResultSet rs = pst.executeQuery();
         while(rs.next()){ 
         String tgs =rs.getString("gst");
         int tds =Integer.parseInt(tgs);
    
     
       
        
    
    
            if(tds == 0){
        
            
            }else{
                
            }
        
            
            
            
         }
    
    
    }
    catch(Exception e){
        e.printStackTrace();
    }
          
          
    }
    public void getdata(){
    receipt rp = new receipt();
        try
        {
            
             //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
         //java.sql.Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         //PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limt 1");
         PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limit 1"); 
         ResultSet rs = pst.executeQuery();
         while(rs.next()){
             String inv =rs.getString("invoice");
         txt_invoice.setText(inv);
        txt_date.setText(rs.getString("date"));
         txt_name.setText(rs.getString("name"));
         txt_nationality.setText(rs.getString("nationality"));
         txt_persons.setText(rs.getString("persons"));
         txt_address.setText(rs.getString("address"));
         txt_state.setText(rs.getString("state"));
         txt_code.setText(rs.getString("code"));
          String gs = rs.getString("gst");
         txt_gst.setText(gs);
         txt_room.setText(rs.getString("room"));
         txt_darrival.setText(rs.getString("Darrival"));
         txt_tarrival.setText(rs.getString("Tarrival"));
       
        txt_departure.setText(rs.getString("Ddeparture") + "               "+"At  : "+rs.getString("Tdeparture"));
        String lodging =rs.getString("lodging");
         txt_lodging.setText(lodging);
        String amount1 = rs.getString("amount");
         txt_price.setText(amount1);
        int lodg =rs.getInt("lodging");
        int price =rs.getInt("amount"); 
        int amount = price*lodg;
        int gst =  (6*amount)/100;
        int total = amount+(2*gst); 
        txt_amount.setVisible(true);
        txt_sgst.setVisible(true);
        txt_cgst.setVisible(true);
        txt_amount.setText(Integer.toString(amount));
        txt_cgst.setText(Integer.toString(gst));
        txt_sgst.setText(Integer.toString(gst));
        txt_total.setText(Integer.toString(total));
        String word =NumberToWordsConverter.convert((total));        
        txt_word.setText(word);
        lbl_amount.setVisible(true);
            lbl_sgst.setVisible(true);
            lbl_cgst.setVisible(true);
            txt_amount.setVisible(true);
            txt_sgst.setVisible(true);
            lbl_cgst.setVisible(true);
            txt_cgst.setVisible(true);
         
            
         
           
           
         }
          
        }
        catch(Exception e)
        { 
            
        } 
      
   }
       public void getdata1(){
    receipt rp = new receipt();
        try
        {
            
             //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
         //java.sql.Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         //PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limt 1");
         PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limit 1"); 
         ResultSet rs = pst.executeQuery();
         while(rs.next()){
             String inv =rs.getString("invoice");
         txt_invoice.setText(inv);
        txt_date.setText(rs.getString("date"));
         txt_name.setText(rs.getString("name"));
         txt_nationality.setText(rs.getString("nationality"));
         txt_persons.setText(rs.getString("persons"));
         txt_address.setText(rs.getString("address"));
         txt_state.setText(rs.getString("state"));
         txt_code.setText(rs.getString("code"));
          String gs = rs.getString("gst");
         txt_gst.setText(gs);
         txt_room.setText(rs.getString("room"));
         txt_darrival.setText(rs.getString("Darrival"));
         txt_tarrival.setText(rs.getString("Tarrival"));
        txt_departure.setText(rs.getString("Ddeparture") + "               "+"At  : "+rs.getString("Tdeparture"));
        String lodging =rs.getString("lodging");
         txt_lodging.setText(lodging);
        String amount1 = rs.getString("amount");
         txt_price.setText(amount1);
        int lodg =rs.getInt("lodging");
        int price =rs.getInt("amount"); 
        int amount = price*lodg;
        
           
            txt_total.setText(Integer.toString(amount));
            String word =NumberToWordsConverter.convert((amount));
            txt_word.setText(word);
             lbl_amount.setVisible(false);
            lbl_sgst.setVisible(false);
            lbl_cgst.setVisible(false);
            txt_amount.setVisible(false);
            txt_sgst.setVisible(false);
            //lbl_cgst.setVisible(false);
            txt_cgst.setVisible(false);
         
           
           
         }
          
        }
        catch(Exception e)
        { 
            
        } 
      
   }
    
     public void getdata2(){
    
        try
        {  String st = Integer.toString(al);
             //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
         //java.sql.Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         //PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limt 1");
         PreparedStatement pst = conn.prepareStatement("select * from entry where invoice = ?"); 
         pst.setString(1, st);
         ResultSet rs = pst.executeQuery();
         
         rs.next();
         txt_invoice.setText(st);
        txt_date.setText(rs.getString("date"));
         txt_name.setText(rs.getString("name"));
         txt_nationality.setText(rs.getString("nationality"));
         txt_persons.setText(rs.getString("persons"));
         txt_address.setText(rs.getString("address"));
         txt_state.setText(rs.getString("state"));
         txt_code.setText(rs.getString("code"));
         txt_gst.setText(rs.getString("gst"));
         txt_room.setText(rs.getString("room"));
         txt_darrival.setText(rs.getString("Darrival"));
         txt_tarrival.setText(rs.getString("Tarrival"));
         
        
        txt_departure.setText(rs.getString("Ddeparture") + "               "+"At  : "+rs.getString("Tdeparture"));
        String lodging =rs.getString("lodging");
         txt_lodging.setText(lodging);
        String amount = rs.getString("amount");
         txt_price.setText(amount);
         
         int price = rs.getInt("amount");
         int lodg = rs.getInt("lodging");
         int amt = price*lodg;
          int gst =(6*amt)/100   ;
          int total1 = 2*gst+amt;
           String gst1 = String.valueOf(gst);
            String tots = String.valueOf(amt);
            String total2 = String.valueOf(total1);
           txt_amount.setText(tots);
           txt_cgst.setText(gst1);
           txt_sgst.setText(gst1);
            txt_total.setText(total2);
            String word =NumberToWordsConverter.convert((total1));
            txt_word.setText(word);
        }
        catch(Exception e)
        { 
            
        } 
      
     
     }

      
     public void getdata3(){
    
        try
        {  String st = Integer.toString(al);
             //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/satellite","root","root");
         //java.sql.Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         //PreparedStatement pst = conn.prepareStatement("select * from entry order by invoice desc limt 1");
         PreparedStatement pst = conn.prepareStatement("select * from entry where invoice = ?"); 
         pst.setString(1, st);
         ResultSet rs = pst.executeQuery();
         
         rs.next();
         txt_invoice.setText(st);
        txt_date.setText(rs.getString("date"));
         txt_name.setText(rs.getString("name"));
         txt_nationality.setText(rs.getString("nationality"));
         txt_persons.setText(rs.getString("persons"));
         txt_address.setText(rs.getString("address"));
         txt_state.setText(rs.getString("state"));
         txt_code.setText(rs.getString("code"));
         txt_gst.setText(rs.getString("gst"));
         txt_room.setText(rs.getString("room"));
         txt_darrival.setText(rs.getString("Darrival"));
         txt_tarrival.setText(rs.getString("Tarrival"));
         
        
        txt_departure.setText(rs.getString("Ddeparture") + "               "+"At  : "+rs.getString("Tdeparture"));
        String lodging =rs.getString("lodging");
         txt_lodging.setText(lodging);
        String amount1 = rs.getString("amount");
         txt_price.setText(amount1);
         int lodg =rs.getInt("lodging");
        int price =rs.getInt("amount"); 
        int amount = price*lodg;
        
           
            txt_total.setText(Integer.toString(amount));
            String word =NumberToWordsConverter.convert((amount));
            txt_word.setText(word);
             lbl_amount.setVisible(false);
            lbl_sgst.setVisible(false);
            lbl_cgst.setVisible(false);
            txt_amount.setVisible(false);
            txt_sgst.setVisible(false);
            //lbl_cgst.setVisible(false);
            txt_cgst.setVisible(false);
         
        }
        catch(Exception e)
        { 
            
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

        print2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        txt_nationality = new javax.swing.JLabel();
        txt_persons = new javax.swing.JLabel();
        txt_address = new javax.swing.JLabel();
        txt_state = new javax.swing.JLabel();
        txt_code = new javax.swing.JLabel();
        txt_gst = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_invoice = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_cgst = new javax.swing.JLabel();
        lbl_sgst = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_room = new javax.swing.JLabel();
        txt_darrival = new javax.swing.JLabel();
        txt_tarrival = new javax.swing.JLabel();
        txt_departure = new javax.swing.JLabel();
        txt_lodging = new javax.swing.JLabel();
        txt_price = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        txt_total = new javax.swing.JLabel();
        txt_word = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txt_cgst = new javax.swing.JLabel();
        txt_amount = new javax.swing.JLabel();
        txt_sgst = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        print2.setBackground(new java.awt.Color(255, 255, 255));
        print2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 770, 10));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 770, 10));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 770, 10));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 20, 280));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nationality:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("GST No. :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("No.of persons :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("State :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Address :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Code:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_name.setText("Name :");
        jPanel2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 350, -1));

        txt_nationality.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nationality.setText("Name :");
        jPanel2.add(txt_nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 180, -1));

        txt_persons.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_persons.setText("Name :");
        jPanel2.add(txt_persons, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 100, -1));

        txt_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_address.setText("Name :");
        jPanel2.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 680, -1));

        txt_state.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_state.setText("Name :");
        jPanel2.add(txt_state, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 150, -1));

        txt_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_code.setText("Name :");
        jPanel2.add(txt_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 90, -1));

        txt_gst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_gst.setText("Name :");
        jPanel2.add(txt_gst, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 150, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("27AAAFH3747D1ZN");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, 20));

        txt_invoice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_invoice.setText("jLabel9");
        jPanel2.add(txt_invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        txt_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_date.setText("jLabel20");
        jPanel2.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 130, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText("213/214, Dixit Road, Vile Parle (East), Mumbai - 400 057");
        jTextField1.setBorder(null);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 470, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 40, 250));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 860, 10));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 570, 260, 10));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 260, 10));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 260, 10));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 10, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Rs. (in words) :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lodging :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 70, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("hrs.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("At  :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Room No. :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 80, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("days @ Rs :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Date & Time of  Departure :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 170, -1));

        lbl_cgst.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_cgst.setText("CGST 6%");
        jPanel2.add(lbl_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, -1));

        lbl_sgst.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_sgst.setText("SGST  6%");
        jPanel2.add(lbl_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("Manager/Receptionist");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 680, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("TOTAL Rs");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Date & Time of  Arrival :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, -1));

        txt_room.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_room.setText("Name :");
        jPanel2.add(txt_room, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 190, -1));

        txt_darrival.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_darrival.setText("Name :");
        jPanel2.add(txt_darrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 150, -1));

        txt_tarrival.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_tarrival.setText("Name :");
        jPanel2.add(txt_tarrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 110, -1));

        txt_departure.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_departure.setText("Name :");
        jPanel2.add(txt_departure, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 280, -1));

        txt_lodging.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_lodging.setText("Name :");
        jPanel2.add(txt_lodging, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 170, -1));

        txt_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_price.setText("Name :");
        jPanel2.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 130, -1));

        lbl_amount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_amount.setText("AMOUNT");
        jPanel2.add(lbl_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        txt_total.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_total.setText("AMOUNT");
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 580, -1, -1));

        txt_word.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_word.setText("AMOUNT");
        jPanel2.add(txt_word, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel40.setText("Rs.");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel41.setText("AMOUNT");
        jPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setText("WISH YOU A HAPPY JOURNEY");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel43.setText("PLEASE VISIT AGAIN");
        jPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));

        txt_cgst.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_cgst.setText("AMOUNT");
        jPanel2.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 540, -1, -1));

        txt_amount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_amount.setText("AMOUNT");
        jPanel2.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, -1, -1));

        txt_sgst.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_sgst.setText("AMOUNT");
        jPanel2.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Name :");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("GST  :");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("Invoice  NO. :");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Date :");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/LOGO1 (2).png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 130));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Tel.:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("022  26117452/0459");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 180, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Mob.:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("+91 7666605059");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("E-mail.:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 60, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("hotelsatellite123@gmail.com");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 180, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel29.setText("Website");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 60, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel30.setText(" www.hotelsatellite.co.in");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 180, 20));

        print2.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 770, 710));

        getContentPane().add(print2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 830, 770));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/view all record.png"))); // NOI18N
        jLabel21.setText("Report");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 170, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/search2.png"))); // NOI18N
        jLabel22.setText("Search ");
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
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 180, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/printer-.png"))); // NOI18N
        jLabel23.setText(" Print");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/back-button.png"))); // NOI18N
        jLabel24.setText("Back");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/logout.png"))); // NOI18N
        jLabel25.setText("Log Out");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MY ICONS/NW1.png"))); // NOI18N
        bg.setText("jLabel");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 750));

        setBounds(0, 0, 1386, 813);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        search sh = new search();
        sh.show();
        this.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel22KeyPressed
        search sh = new search();
        sh.show();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel22KeyPressed

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
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
                g2.scale(0.72,1.07);
                
                
                print2.print(g2);
         
               
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
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
       Report rp = new Report();
       rp.show();
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
          edit ed = new edit();
            ed.txt_invoice.setText(txt_invoice.getText());
           ed.getdata();
         
         //  ed.txt_invoice.setText(ln);
             this.dispose();
             ed.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

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
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_cgst;
    private javax.swing.JLabel lbl_sgst;
    private javax.swing.JPanel print2;
    private javax.swing.JLabel txt_address;
    private javax.swing.JLabel txt_amount;
    private javax.swing.JLabel txt_cgst;
    private javax.swing.JLabel txt_code;
    private javax.swing.JLabel txt_darrival;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_departure;
    private javax.swing.JLabel txt_gst;
    private javax.swing.JLabel txt_invoice;
    private javax.swing.JLabel txt_lodging;
    private javax.swing.JLabel txt_name;
    private javax.swing.JLabel txt_nationality;
    private javax.swing.JLabel txt_persons;
    private javax.swing.JLabel txt_price;
    private javax.swing.JLabel txt_room;
    private javax.swing.JLabel txt_sgst;
    private javax.swing.JLabel txt_state;
    private javax.swing.JLabel txt_tarrival;
    private javax.swing.JLabel txt_total;
    private javax.swing.JLabel txt_word;
    // End of variables declaration//GEN-END:variables
}
