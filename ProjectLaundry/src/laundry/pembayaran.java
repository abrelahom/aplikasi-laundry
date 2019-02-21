/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;
import java.awt.Desktop;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LENOVO
 */
public class pembayaran extends javax.swing.JFrame {
    model model = new model();
java.util.Date tglsekarang = new java.util.Date();
    private final SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private final String tanggal = smpdtfmt.format(tglsekarang);
    private Statement st;
    private Connection con;
    private ResultSet rs;
    public DefaultTableModel tabmodel;
    public DefaultTableModel tabmodel2;
    public DefaultTableModel tbldata;


    private Object displaytext;
    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_laundry3", "root", "");
            st = (Statement) con.createStatement();
            System.out.println("berhasil");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }
    }
    String hasil;
    /**
     * Creates new form pembayaran
     */
    public pembayaran() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        koneksi();
        judul();
        tampildata();
        judul1();
        tampildata1();
        tgl.setText(tanggal);
    }
    
    /**
     *
     * @throws SQLException
     */
    public void tampildata(){
        try{
           st = con.createStatement();
           tabmodel.getDataVector().removeAllElements();
           tabmodel.fireTableDataChanged();
           rs = st.executeQuery("SELECT * FROM tbl_pesan");
           while(rs.next()){
                Object[] data = {
                    rs.getString("no_antrian"),
                    rs.getString("nama"),
                    rs.getString("no_telp"),
                    rs.getString("alamat"),
                    rs.getString("j_pewangi"),
                    rs.getString("jumlah"),
                    rs.getString("harga"),
                    rs.getString("tanggal")
                };                
                tabmodel.addRow(data);
    }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    
    private void judul(){
        Object[] judul = {"No Antrian","Nama", "No Telepon", "Alamat", "Jenis Pewangi", "Jumlah", "Harga", "Tanggal"};
        tabmodel = new DefaultTableModel(null, judul);
        tabel1.setModel(tabmodel);
    }
    
    public void tampildata1(){
        try {
            st = con.createStatement();
            tabmodel2.getDataVector().removeAllElements();
            tabmodel2.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tbl_ambil");
            while (rs.next()) {                
                Object[] data = {
                    rs.getString("no_antrian"),
                    rs.getString("nama"),
                    rs.getString("no_telp"),
                    rs.getString("alamat"),
                    rs.getString("j_pewangi"),
                    rs.getString("jumlah"),
                    rs.getString("harga"),
                    rs.getString("tanggal"),
                    rs.getString("total"),
                    rs.getString("bayar"),
                    rs.getString("kembali")};
                tabmodel2.addRow(data);
            }
    } catch (Exception e) {
            e.printStackTrace();
    }
    }
    
    private void judul1(){ 
        Object[] judul = {"Nomor Antrian","Nama","No Telepon","Alamat","Jenis Pewangi","Jumlah","Harga","Tanggal","Total","Bayar","Kembalian"};
        tabmodel2 = new DefaultTableModel(null,judul);
        tabel2.setModel(tabmodel2);
}
    
    private void reset()
     { 
        no_transaksi.setText(""); 
        tgl.setText("");
        nama.setText("");
        j_pewangi.setSelectedIndex(-1); 
        jumlah.setText("");
        j_pewangi.setSelectedItem("");
        nama.setText("");
        no_telp.setText("");
        alamat.setText("");
        ttanggal.setText("");
        harga.setText("");
        totall.setText("");
        bayar.setText("");
        kembalian.setText("");
        no_transaksi.requestFocus();
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        no_transaksi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel2 = new javax.swing.JTable();
        Report = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        selesai = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totall = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        no_telp = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        ttanggal = new javax.swing.JTextField();
        j_pewangi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setForeground(new java.awt.Color(0, 255, 204));

        jPanel2.setBackground(new java.awt.Color(102, 204, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No Antrian");

        no_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_transaksiActionPerformed(evt);
            }
        });
        no_transaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_transaksiKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama");

        nama.setEnabled(false);
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        tabel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel2);
        if (tabel2.getColumnModel().getColumnCount() > 0) {
            tabel2.getColumnModel().getColumn(0).setResizable(false);
            tabel2.getColumnModel().getColumn(1).setResizable(false);
            tabel2.getColumnModel().getColumn(2).setResizable(false);
            tabel2.getColumnModel().getColumn(3).setResizable(false);
        }

        Report.setBackground(new java.awt.Color(0, 255, 204));
        Report.setForeground(new java.awt.Color(255, 255, 255));
        Report.setText("REPORT");
        Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportMouseClicked(evt);
            }
        });
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }
        });

        kembali.setBackground(new java.awt.Color(0, 255, 204));
        kembali.setForeground(new java.awt.Color(255, 255, 255));
        kembali.setText("KEMBALI");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        selesai.setBackground(new java.awt.Color(0, 255, 204));
        selesai.setForeground(new java.awt.Color(255, 255, 255));
        selesai.setText("SELESAI");
        selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiActionPerformed(evt);
            }
        });

        tgl.setText("jLabel13");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bayar");

        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kembalian");

        kembalian.setEnabled(false);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total");

        totall.setEnabled(false);

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel1);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("No Telepon");

        no_telp.setEnabled(false);

        alamat.setEnabled(false);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Alamat");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jenis Pewangi");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Jumlah");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Harga");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tanggal");

        jumlah.setEnabled(false);

        harga.setEnabled(false);

        ttanggal.setEnabled(false);

        j_pewangi.setForeground(new java.awt.Color(255, 255, 255));
        j_pewangi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Cair", "Bubuk" }));
        j_pewangi.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(nama)
                            .addComponent(no_transaksi)
                            .addComponent(no_telp))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ttanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(harga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j_pewangi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(selesai)
                                .addGap(16, 16, 16))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totall, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kembali))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(no_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kembali))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j_pewangi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(selesai)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dot.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VIVA LAUNDRY");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AMBIL DISINI");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Shop_48px.png"))); // NOI18N

        jLabel16.setBackground(new java.awt.Color(255, 102, 0));
        jLabel16.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Minimize_Window_48px.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Close_Window_48px.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(201, 201, 201)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
        // TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().browse(new URL("http://localhost/Laporanjava/laporan.php").toURI());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ReportActionPerformed

    private void selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiActionPerformed
        int a,b;
        a = Integer.parseInt(totall.getText());
        b = Integer.parseInt(bayar.getText());
        if (b < a) {
            JOptionPane.showMessageDialog(null, "Uang Anda Kurang");
        }else{
        String sql = "no_antrian ='"+ no_transaksi.getText() +"',nama='"+nama.getText()+"',no_telp='"+no_telp.getText()+"',alamat='"+ alamat.getText() +"',j_pewangi='"+j_pewangi.getSelectedItem()+"',jumlah='"+jumlah.getText()+"',harga='"+harga.getText()+"',tanggal='"+ttanggal.getText()+"',total='"+totall.getText()+"',bayar='"+bayar.getText()+"',kembali='"+kembalian.getText()+"'";
        if (model.hapus("tbl_pesan", "no_antrian", no_transaksi.getText())) {
            if (model.simpan("tbl_ambil", sql)) {
                JOptionPane.showMessageDialog(null, "Sudah Bayar");
                tampildata();
                tampildata1();
                if(Desktop.isDesktopSupported()){
                    try{
                        Desktop.getDesktop().browse(new URL("http://localhost/Laporanjava/struk.php?id="+ no_transaksi.getText()).toURI());
                } catch(Exception e){
                        e.printStackTrace();
                }
        }
                reset();
            }else{
                JOptionPane.showMessageDialog(null, "gagal simpan");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Hapus");
        }
        }
      

          
    }//GEN-LAST:event_selesaiActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        new home().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ReportMouseClicked

    private void tabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabel2MouseClicked

    private void no_transaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_transaksiKeyReleased
        if (!no_transaksi.getText().equals("")) {
            try {
                st = con.createStatement();
                rs = st.executeQuery("select * from tbl_pesan where no_antrian ='"+no_transaksi.getText()+"'");
                if (rs.next()) {
                    nama.setText(rs.getString("nama"));
                    no_telp.setText(rs.getString("no_telp"));
                    alamat.setText(rs.getString("alamat"));
                    j_pewangi.setSelectedItem(rs.getString("j_pewangi"));
                    jumlah.setText(rs.getString("jumlah"));
                    harga.setText(rs.getString("harga"));
                    ttanggal.setText(rs.getString("tanggal"));
                    totall.setText(rs.getString("harga"));
                }else{
                    nama.setText("");
                    no_telp.setText("");
                    alamat.setText("");
                    j_pewangi.setSelectedItem("");
                    jumlah.setText("");
                    harga.setText("");
                    ttanggal.setText("");
                    totall.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_no_transaksiKeyReleased

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        if (Integer.parseInt(totall.getText())>Integer.parseInt(bayar.getText())) {
            kembalian.setText("Uang Kurang!");
        }else{
            Integer kembali = Integer.parseInt(bayar.getText())-Integer.parseInt(totall.getText());
            kembalian.setText(kembali.toString());
        }
    }//GEN-LAST:event_bayarKeyReleased

    private void tabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabel1MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void no_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_transaksiActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

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
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new pembayaran().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Report;
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField bayar;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> j_pewangi;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField no_telp;
    private javax.swing.JTextField no_transaksi;
    private javax.swing.JButton selesai;
    private javax.swing.JTable tabel1;
    private javax.swing.JTable tabel2;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField totall;
    private javax.swing.JTextField ttanggal;
    // End of variables declaration//GEN-END:variables

//    private void judul() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void tampildata() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void judul1() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void tampildata1() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
