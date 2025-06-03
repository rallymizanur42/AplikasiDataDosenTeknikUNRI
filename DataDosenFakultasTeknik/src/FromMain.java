import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.*;
import koneksi.koneksi;
import net.proteanit.sql.DbUtils;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class FromMain extends javax.swing.JFrame {

    public static Connection con;
    public static java.sql.Statement stm;
    public static ResultSet res;
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:8111/db_dosenteknik";
        String username = "root";
        String password = "";
        return DriverManager.getConnection(url, username, password);
    }
    
    public FromMain() {
        initComponents();
        dataTable();
        dataTable2();
        dataTable3();
        dataTable4();
        dataTable5();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Mendapatkan jumlah tab yang ada di JTabbedPane
        int tabCount = jTabbedPane1.getTabCount();
        // Menggunakan loop untuk mengatur komponen tab header menjadi kosong atau tidak terlihat
        for (int i = 0; i < tabCount; i++) {
            jTabbedPane1.setTabComponentAt(i, new JLabel()); // Menjadikan label kosong
        }
    }
    private void dataTable(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nama Dosen");
        tb.addColumn("NIP");
        tb.addColumn("Riwayat Pendidikan");
        tb.addColumn("Email");
        tb.addColumn("Bidang Keahlian");
        tb.addColumn("Jabatan");
        tblelektro.setModel(tb);
        try{
            Connection connection = koneksi.getKoneksi();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM jurusanelektro");
            while (res.next()){
                tb.addRow(new Object[]{
                    res.getString("Nama Dosen"),
                    res.getString("NIP"),
                    res.getString("Riwayat Pendidikan"),
                    res.getString("Email"),
                    res.getString("Bidang Keahlian"),
                    res.getString("Jabatan"),
                });
                tblelektro.setModel(tb);
            }
        }catch (Exception e){
            
        }
    }
    private void dataTable2(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nama Dosen");
        tb.addColumn("NIP");
        tb.addColumn("Riwayat Pendidikan");
        tb.addColumn("Email");
        tb.addColumn("Bidang Keahlian");
        tb.addColumn("Jabatan");
        tblmesin.setModel(tb);
        try{
            Connection connection = koneksi.getKoneksi();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM jurusanmesin");
            while (res.next()){
                tb.addRow(new Object[]{
                    res.getString("Nama Dosen"),
                    res.getString("NIP"),
                    res.getString("Riwayat Pendidikan"),
                    res.getString("Email"),
                    res.getString("Bidang Keahlian"),
                    res.getString("Jabatan"),
                });
                tblmesin.setModel(tb);
            }
        }catch (Exception e){
            
        }
    }
    private void dataTable3(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nama Dosen");
        tb.addColumn("NIP");
        tb.addColumn("Riwayat Pendidikan");
        tb.addColumn("Email");
        tb.addColumn("Bidang Keahlian");
        tb.addColumn("Jabatan");
        tblsipil.setModel(tb);
        try{
            Connection connection = koneksi.getKoneksi();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM jurusansipil");
            while (res.next()){
                tb.addRow(new Object[]{
                    res.getString("Nama Dosen"),
                    res.getString("NIP"),
                    res.getString("Riwayat Pendidikan"),
                    res.getString("Email"),
                    res.getString("Bidang Keahlian"),
                    res.getString("Jabatan"),
                });
                tblsipil.setModel(tb);
            }
        }catch (Exception e){
            
        }
    }
    private void dataTable4(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nama Dosen");
        tb.addColumn("NIP");
        tb.addColumn("Riwayat Pendidikan");
        tb.addColumn("Email");
        tb.addColumn("Bidang Keahlian");
        tb.addColumn("Jabatan");
        tblarsitektur.setModel(tb);
        try{
            Connection connection = koneksi.getKoneksi();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM jurusanarsitektur");
            while (res.next()){
                tb.addRow(new Object[]{
                    res.getString("Nama Dosen"),
                    res.getString("NIP"),
                    res.getString("Riwayat Pendidikan"),
                    res.getString("Email"),
                    res.getString("Bidang Keahlian"),
                    res.getString("Jabatan"),
                });
                tblarsitektur.setModel(tb);
            }
        }catch (Exception e){
            
        }
    }
    private void dataTable5(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Nama Dosen");
        tb.addColumn("NIP");
        tb.addColumn("Riwayat Pendidikan");
        tb.addColumn("Email");
        tb.addColumn("Bidang Keahlian");
        tb.addColumn("Jabatan");
        tblkimia.setModel(tb);
        try{
            Connection connection = koneksi.getKoneksi();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM jurusankimia");
            while (res.next()){
                tb.addRow(new Object[]{
                    res.getString("Nama Dosen"),
                    res.getString("NIP"),
                    res.getString("Riwayat Pendidikan"),
                    res.getString("Email"),
                    res.getString("Bidang Keahlian"),
                    res.getString("Jabatan"),
                });
                tblkimia.setModel(tb);
            }
        }catch (Exception e){
            
        }
    }
    private void showDataInTable() {
    DefaultTableModel model = (DefaultTableModel) tblelektro.getModel(); // yourJTable adalah nama dari tabel yang Anda gunakan
    
    try {
        Connection conn = koneksi.getKoneksi();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM jurusanelektro");

        // Membersihkan isi tabel sebelum menampilkan data yang baru
        model.setRowCount(0);
       
        while (resultSet.next()) {
            String namadosen = resultSet.getString("Nama Dosen");
            String nip = resultSet.getString("NIP");
            String riwayatPendidikan = resultSet.getString("Riwayat Pendidikan");
            String email = resultSet.getString("Email");
            String bidangKeahlian = resultSet.getString("Bidang Keahlian");
            String jabatan = resultSet.getString("Jabatan");

            // Menambahkan data ke dalam tabel
            model.addRow(new Object[]{namadosen, nip, riwayatPendidikan, email, bidangKeahlian, jabatan});
        }

        statement.close();
        conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    private void showDataInTable2() {
    DefaultTableModel model = (DefaultTableModel) tblelektro.getModel(); // yourJTable adalah nama dari tabel yang Anda gunakan
    
    try {
        Connection conn = koneksi.getKoneksi();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM jurusanelektro");

        // Membersihkan isi tabel sebelum menampilkan data yang baru
        model.setRowCount(0);
       
        while (resultSet.next()) {
            String namadosen = resultSet.getString("Nama Dosen");
            String nip = resultSet.getString("NIP");
            String riwayatPendidikan = resultSet.getString("Riwayat Pendidikan");
            String email = resultSet.getString("Email");
            String bidangKeahlian = resultSet.getString("Bidang Keahlian");
            String jabatan = resultSet.getString("Jabatan");

            // Menambahkan data ke dalam tabel
            model.addRow(new Object[]{namadosen, nip, riwayatPendidikan, email, bidangKeahlian, jabatan});
        }

        statement.close();
        conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nav = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        side = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        main = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        elektro1 = new javax.swing.JLabel();
        elektro2 = new javax.swing.JLabel();
        elektro3 = new javax.swing.JLabel();
        elektro4 = new javax.swing.JLabel();
        elektro5 = new javax.swing.JLabel();
        elektro6 = new javax.swing.JLabel();
        txtelektro1 = new javax.swing.JTextField();
        txtelektro2 = new javax.swing.JTextField();
        txtelektro3 = new javax.swing.JTextField();
        txtelektro4 = new javax.swing.JTextField();
        txtelektro5 = new javax.swing.JTextField();
        txtelektro6 = new javax.swing.JTextField();
        btnsimpanelektro = new javax.swing.JButton();
        btnedit1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btncari1 = new javax.swing.JButton();
        txtcari1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblelektro = new javax.swing.JTable();
        btnhapus1 = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        mesin6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnsimpanmesin = new javax.swing.JButton();
        bedit2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        mesin1 = new javax.swing.JTextField();
        mesin2 = new javax.swing.JTextField();
        mesin3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        mesin4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        mesin5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblmesin = new javax.swing.JTable();
        btnhapus2 = new javax.swing.JButton();
        btnclear2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        sipil6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnsimpansipil = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jTextField19 = new javax.swing.JTextField();
        sipil1 = new javax.swing.JTextField();
        sipil2 = new javax.swing.JTextField();
        sipil3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        sipil4 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        sipil5 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblsipil = new javax.swing.JTable();
        btnhapus3 = new javax.swing.JButton();
        btnclear3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        arsi1 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        arsi2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        arsi3 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        arsi4 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jTextField29 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        arsi5 = new javax.swing.JTextField();
        arsi6 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblarsitektur = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        btnsimpanarsitektur = new javax.swing.JButton();
        btnhapus4 = new javax.swing.JButton();
        btnclear4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        kimia1 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        kimia2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        kimia3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        kimia4 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jTextField37 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        kimia5 = new javax.swing.JTextField();
        kimia6 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblkimia = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        btnsimpankimia = new javax.swing.JButton();
        btnhapus5 = new javax.swing.JButton();
        btnclear5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nav.setBackground(new java.awt.Color(18, 72, 107));

        jLabel46.setFont(new java.awt.Font("Poppins ExtraBold", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Data Dosen Fakultas Teknik");
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout navLayout = new javax.swing.GroupLayout(nav);
        nav.setLayout(navLayout);
        navLayout.setHorizontalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navLayout.createSequentialGroup()
                .addContainerGap(583, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(486, 486, 486))
        );
        navLayout.setVerticalGroup(
            navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(37, 37, 37))
        );

        getContentPane().add(nav, java.awt.BorderLayout.PAGE_START);

        side.setBackground(new java.awt.Color(255, 255, 255));
        side.setPreferredSize(new java.awt.Dimension(200, 313));

        jButton1.setBackground(new java.awt.Color(120, 214, 198));
        jButton1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton1.setText("Jurusan Elektro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(120, 214, 198));
        jButton2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton2.setText("Jurusan Mesin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(120, 214, 198));
        jButton3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton3.setText("Jurusan Sipil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(120, 214, 198));
        jButton4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton4.setText("Jurusan Arsitektur");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(120, 214, 198));
        jButton5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton5.setText("Jurusan Kimia");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideLayout = new javax.swing.GroupLayout(side);
        side.setLayout(sideLayout);
        sideLayout.setHorizontalGroup(
            sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        sideLayout.setVerticalGroup(
            sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(591, Short.MAX_VALUE))
        );

        getContentPane().add(side, java.awt.BorderLayout.LINE_START);

        main.setBackground(new java.awt.Color(65, 145, 151));

        jPanel1.setBackground(new java.awt.Color(65, 145, 151));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Dosen Jurusan Elektro");

        elektro1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        elektro1.setForeground(new java.awt.Color(255, 255, 255));
        elektro1.setText("Nama Dosen");

        elektro2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        elektro2.setForeground(new java.awt.Color(255, 255, 255));
        elektro2.setText("NIP");

        elektro3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        elektro3.setForeground(new java.awt.Color(255, 255, 255));
        elektro3.setText("Riwayat Pendidikan");

        elektro4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        elektro4.setForeground(new java.awt.Color(255, 255, 255));
        elektro4.setText("Email");

        elektro5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        elektro5.setForeground(new java.awt.Color(255, 255, 255));
        elektro5.setText("Bidang Keahlian");

        elektro6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        elektro6.setForeground(new java.awt.Color(255, 255, 255));
        elektro6.setText("Jabatan");

        txtelektro1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        txtelektro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelektro1ActionPerformed(evt);
            }
        });

        txtelektro2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        txtelektro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelektro2ActionPerformed(evt);
            }
        });

        txtelektro3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        txtelektro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelektro3ActionPerformed(evt);
            }
        });

        txtelektro4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        txtelektro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelektro4ActionPerformed(evt);
            }
        });

        txtelektro5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        txtelektro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelektro5ActionPerformed(evt);
            }
        });

        txtelektro6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        txtelektro6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelektro6ActionPerformed(evt);
            }
        });

        btnsimpanelektro.setBackground(new java.awt.Color(245, 252, 205));
        btnsimpanelektro.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnsimpanelektro.setText("Simpan");
        btnsimpanelektro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanelektroActionPerformed(evt);
            }
        });

        btnedit1.setBackground(new java.awt.Color(245, 252, 205));
        btnedit1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnedit1.setText("Edit");
        btnedit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedit1ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(120, 214, 198));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px.png"))); // NOI18N
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 31, -1));

        btncari1.setBackground(new java.awt.Color(245, 252, 205));
        btncari1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btncari1.setText("Cari");
        btncari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncari1ActionPerformed(evt);
            }
        });
        jPanel6.add(btncari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 7, -1, -1));

        txtcari1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jPanel6.add(txtcari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 9, 189, 24));

        tblelektro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Dosen", "NIP", "Riwayat Pendidikan", "Email", "Bidang Keahlian", "Jabatan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblelektro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblelektroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblelektro);

        btnhapus1.setBackground(new java.awt.Color(245, 252, 205));
        btnhapus1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnhapus1.setText("Hapus");
        btnhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus1ActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(245, 252, 205));
        btnclear.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnclear.setText("clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsimpanelektro)
                                .addGap(18, 18, 18)
                                .addComponent(btnedit1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(btnhapus1)
                                .addGap(18, 18, 18)
                                .addComponent(btnclear))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(elektro6)
                        .addGap(128, 128, 128)
                        .addComponent(txtelektro6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(elektro5)
                        .addGap(80, 80, 80)
                        .addComponent(txtelektro5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(elektro4)
                        .addGap(145, 145, 145)
                        .addComponent(txtelektro4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(elektro3)
                        .addGap(61, 61, 61)
                        .addComponent(txtelektro3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(elektro2)
                            .addComponent(elektro1))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtelektro1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                            .addComponent(txtelektro2))))
                .addGap(0, 622, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elektro1)
                    .addComponent(txtelektro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(elektro2))
                    .addComponent(txtelektro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(elektro3))
                    .addComponent(txtelektro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elektro4)
                    .addComponent(txtelektro4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elektro5)
                    .addComponent(txtelektro5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elektro6)
                    .addComponent(txtelektro6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpanelektro)
                    .addComponent(btnedit1)
                    .addComponent(btnhapus1)
                    .addComponent(btnclear))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Jurusan Elektro", jPanel1);

        jPanel2.setBackground(new java.awt.Color(65, 145, 151));

        mesin6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        mesin6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesin6ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Riwayat Pendidikan");

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email");

        btnsimpanmesin.setBackground(new java.awt.Color(245, 252, 205));
        btnsimpanmesin.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnsimpanmesin.setText("Simpan");
        btnsimpanmesin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanmesinActionPerformed(evt);
            }
        });

        bedit2.setBackground(new java.awt.Color(245, 252, 205));
        bedit2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        bedit2.setText("Edit");
        bedit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedit2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bidang Keahlian");

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Jabatan");

        jPanel7.setBackground(new java.awt.Color(120, 214, 198));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px.png"))); // NOI18N
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 31, -1));

        jButton13.setBackground(new java.awt.Color(245, 252, 205));
        jButton13.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton13.setText("Cari");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 7, -1, -1));

        jTextField11.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jPanel7.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 9, 189, 24));

        mesin1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        mesin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesin1ActionPerformed(evt);
            }
        });

        mesin2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        mesin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesin2ActionPerformed(evt);
            }
        });

        mesin3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        mesin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesin3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Data Dosen Jurusan Mesin");

        mesin4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        mesin4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesin4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nama Dosen");

        mesin5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        mesin5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesin5ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("NIP");

        tblmesin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Dosen", "NIP", "Riwayat Pendidikan", "Email", "Bidang Keahlian", "Jabatan"
            }
        ));
        tblmesin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmesinMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblmesin);

        btnhapus2.setBackground(new java.awt.Color(245, 252, 205));
        btnhapus2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnhapus2.setText("Hapus");
        btnhapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus2ActionPerformed(evt);
            }
        });

        btnclear2.setBackground(new java.awt.Color(245, 252, 205));
        btnclear2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnclear2.setText("clear");
        btnclear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(160, 160, 160)
                        .addComponent(mesin2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(61, 61, 61)
                        .addComponent(mesin3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(145, 145, 145)
                        .addComponent(mesin4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(80, 80, 80)
                        .addComponent(mesin5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(128, 128, 128)
                        .addComponent(mesin6))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(100, 100, 100)
                        .addComponent(mesin1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnsimpanmesin)
                                .addGap(18, 18, 18)
                                .addComponent(bedit2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(btnhapus2)
                                .addGap(29, 29, 29)
                                .addComponent(btnclear2)))))
                .addGap(599, 622, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(mesin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(mesin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(mesin3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(mesin4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(mesin5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(mesin6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpanmesin)
                    .addComponent(bedit2)
                    .addComponent(btnhapus2)
                    .addComponent(btnclear2))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jPanel3.setBackground(new java.awt.Color(65, 145, 151));

        sipil6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sipil6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipil6ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Riwayat Pendidikan");

        jLabel20.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Email");

        btnsimpansipil.setBackground(new java.awt.Color(245, 252, 205));
        btnsimpansipil.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnsimpansipil.setText("Simpan");
        btnsimpansipil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpansipilActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(245, 252, 205));
        jButton15.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton15.setText("Edit");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Bidang Keahlian");

        jLabel22.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Jabatan");

        jPanel8.setBackground(new java.awt.Color(120, 214, 198));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 31, -1));

        jButton17.setBackground(new java.awt.Color(245, 252, 205));
        jButton17.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton17.setText("Cari");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 7, -1, -1));

        jTextField19.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jPanel8.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 9, 189, 24));

        sipil1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sipil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipil1ActionPerformed(evt);
            }
        });

        sipil2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sipil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipil2ActionPerformed(evt);
            }
        });

        sipil3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sipil3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipil3ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Data Dosen Jurusan Sipil");

        sipil4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sipil4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipil4ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nama Dosen");

        sipil5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        sipil5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipil5ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("NIP");

        tblsipil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Dosen", "NIP", "Riwayat Pendidikan", "Email", "Bidang Keahlian", "Jabatan"
            }
        ));
        jScrollPane3.setViewportView(tblsipil);

        btnhapus3.setBackground(new java.awt.Color(245, 252, 205));
        btnhapus3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnhapus3.setText("Hapus");
        btnhapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus3ActionPerformed(evt);
            }
        });

        btnclear3.setBackground(new java.awt.Color(245, 252, 205));
        btnclear3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnclear3.setText("clear");
        btnclear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclear3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(160, 160, 160)
                        .addComponent(sipil2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(61, 61, 61)
                        .addComponent(sipil3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(145, 145, 145)
                        .addComponent(sipil4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(80, 80, 80)
                        .addComponent(sipil5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(128, 128, 128)
                        .addComponent(sipil6))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(100, 100, 100)
                        .addComponent(sipil1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnsimpansipil)
                                .addGap(18, 18, 18)
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnhapus3)
                                .addGap(29, 29, 29)
                                .addComponent(btnclear3)))))
                .addGap(599, 622, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel26))
                    .addComponent(sipil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel27))
                    .addComponent(sipil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addComponent(sipil3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(sipil4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(sipil5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(sipil6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpansipil)
                    .addComponent(jButton15)
                    .addComponent(btnhapus3)
                    .addComponent(btnclear3))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        jPanel4.setBackground(new java.awt.Color(65, 145, 151));

        arsi1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        arsi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsi1ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(245, 252, 205));
        jButton18.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton18.setText("Edit");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        arsi2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        arsi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsi2ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Bidang Keahlian");

        arsi3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        arsi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsi3ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Data Dosen Jurusan Arsitektur");

        jLabel30.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Jabatan");

        arsi4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        arsi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsi4ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(120, 214, 198));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px.png"))); // NOI18N
        jPanel9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 31, -1));

        jButton20.setBackground(new java.awt.Color(245, 252, 205));
        jButton20.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton20.setText("Cari");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 7, -1, -1));

        jTextField29.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jPanel9.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 9, 189, 24));

        jLabel32.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Nama Dosen");

        arsi5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        arsi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsi5ActionPerformed(evt);
            }
        });

        arsi6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        arsi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsi6ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("NIP");

        jLabel34.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Riwayat Pendidikan");

        tblarsitektur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Dosen", "NIP", "Riwayat Pendidikan", "Email", "Bidang Keahlian", "Jabatan"
            }
        ));
        jScrollPane4.setViewportView(tblarsitektur);

        jLabel35.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Email");

        btnsimpanarsitektur.setBackground(new java.awt.Color(245, 252, 205));
        btnsimpanarsitektur.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnsimpanarsitektur.setText("Simpan");
        btnsimpanarsitektur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanarsitekturActionPerformed(evt);
            }
        });

        btnhapus4.setBackground(new java.awt.Color(245, 252, 205));
        btnhapus4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnhapus4.setText("Hapus");
        btnhapus4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus4ActionPerformed(evt);
            }
        });

        btnclear4.setBackground(new java.awt.Color(245, 252, 205));
        btnclear4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnclear4.setText("clear");
        btnclear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclear4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(160, 160, 160)
                        .addComponent(arsi2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(61, 61, 61)
                        .addComponent(arsi3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(145, 145, 145)
                        .addComponent(arsi4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(80, 80, 80)
                        .addComponent(arsi5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(128, 128, 128)
                        .addComponent(arsi6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(100, 100, 100)
                        .addComponent(arsi1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnsimpanarsitektur)
                                .addGap(18, 18, 18)
                                .addComponent(jButton18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnhapus4)
                                .addGap(29, 29, 29)
                                .addComponent(btnclear4))))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(599, 622, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel32))
                    .addComponent(arsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel33))
                    .addComponent(arsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel34))
                    .addComponent(arsi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(arsi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(arsi5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(arsi6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpanarsitektur)
                    .addComponent(jButton18)
                    .addComponent(btnhapus4)
                    .addComponent(btnclear4))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        jPanel5.setBackground(new java.awt.Color(65, 145, 151));

        kimia1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        kimia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimia1ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(245, 252, 205));
        jButton22.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton22.setText("Edit");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        kimia2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        kimia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimia2ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel37.setText("Bidang Keahlian");

        kimia3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        kimia3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimia3ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel38.setText("Data Dosen Jurusan Kimia");

        jLabel39.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel39.setText("Jabatan");

        kimia4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        kimia4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimia4ActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(120, 214, 198));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px.png"))); // NOI18N
        jPanel10.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 31, -1));

        jButton24.setBackground(new java.awt.Color(245, 252, 205));
        jButton24.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton24.setText("Cari");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 7, -1, -1));

        jTextField37.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jPanel10.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 9, 189, 24));

        jLabel41.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel41.setText("Nama Dosen");

        kimia5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        kimia5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimia5ActionPerformed(evt);
            }
        });

        kimia6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        kimia6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kimia6ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel42.setText("NIP");

        jLabel43.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel43.setText("Riwayat Pendidikan");

        tblkimia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Dosen", "NIP", "Riwayat Pendidikan", "Email", "Bidang Keahilan", "Jabatan"
            }
        ));
        jScrollPane5.setViewportView(tblkimia);

        jLabel44.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel44.setText("Email");

        btnsimpankimia.setBackground(new java.awt.Color(245, 252, 205));
        btnsimpankimia.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnsimpankimia.setText("Simpan");
        btnsimpankimia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpankimiaActionPerformed(evt);
            }
        });

        btnhapus5.setBackground(new java.awt.Color(245, 252, 205));
        btnhapus5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnhapus5.setText("Hapus");
        btnhapus5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus5ActionPerformed(evt);
            }
        });

        btnclear5.setBackground(new java.awt.Color(245, 252, 205));
        btnclear5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnclear5.setText("clear");
        btnclear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclear5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(160, 160, 160)
                        .addComponent(kimia2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(61, 61, 61)
                        .addComponent(kimia3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(145, 145, 145)
                        .addComponent(kimia4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(80, 80, 80)
                        .addComponent(kimia5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(128, 128, 128)
                        .addComponent(kimia6))
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(100, 100, 100)
                        .addComponent(kimia1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnsimpankimia)
                                .addGap(18, 18, 18)
                                .addComponent(jButton22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnhapus5)
                                .addGap(29, 29, 29)
                                .addComponent(btnclear5)))))
                .addGap(599, 622, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel41))
                    .addComponent(kimia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel42))
                    .addComponent(kimia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel43))
                    .addComponent(kimia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(kimia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(kimia5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(kimia6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpankimia)
                    .addComponent(jButton22)
                    .addComponent(btnhapus5)
                    .addComponent(btnclear5))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab5", jPanel5);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtelektro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelektro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelektro1ActionPerformed

    private void txtelektro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelektro2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelektro2ActionPerformed

    private void txtelektro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelektro3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelektro3ActionPerformed

    private void txtelektro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelektro4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelektro4ActionPerformed

    private void txtelektro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelektro5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelektro5ActionPerformed

    private void txtelektro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelektro6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelektro6ActionPerformed

    private void btnsimpanelektroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanelektroActionPerformed
        try{
            String sql = "INSERT INTO jurusanelektro VALUES('"+txtelektro1.getText()+"','"+txtelektro2.getText()+"','"+txtelektro3.getText()+"','"+txtelektro4.getText()+"','"+txtelektro5.getText()+"','"+txtelektro6.getText()+"')";
            java.sql.Connection conn = (java.sql.Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Disimpan");
            
        }catch (SQLException | HeadlessException e ){
            JOptionPane.showMessageDialog(null,e);
        }
        dataTable();
    }//GEN-LAST:event_btnsimpanelektroActionPerformed

    private void btnedit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedit1ActionPerformed
        String nip = txtelektro2.getText();
    
        if (btnedit1.getText().equals("Edit")) {
            // Mode edit diaktifkan
            txtelektro1.setEnabled(true); // Enable text field for editing
            txtelektro3.setEnabled(true);
            txtelektro4.setEnabled(true);
            txtelektro5.setEnabled(true);
            txtelektro6.setEnabled(true);

            btnedit1.setText("Simpan"); // Change button label to "Simpan" (Save)
        } else if (btnedit1.getText().equals("Simpan")) {
            String namadosen = txtelektro1.getText();
            String RiwayatPendidikan = txtelektro3.getText();
            String Email = txtelektro4.getText();
            String BidangKeahlian = txtelektro5.getText();
            String Jabatan = txtelektro6.getText();

            try {
                Connection conn = koneksi.getKoneksi();
                PreparedStatement statement = conn.prepareStatement("UPDATE jurusanelektro SET `Nama Dosen` = ?, `Riwayat Pendidikan` = ?, `Email` = ?, `Bidang Keahlian` = ?, `Jabatan` = ? WHERE `NIP` = ?");
                statement.setString(1, namadosen);
                statement.setString(2, RiwayatPendidikan);
                statement.setString(3, Email);
                statement.setString(4, BidangKeahlian);
                statement.setString(5, Jabatan);
                statement.setString(6, nip);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                    showDataInTable(); // Panggil metode untuk menampilkan data yang sudah diubah di tabel
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal diubah");
                }
                statement.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
            }

            // Mode edit dinonaktifkan setelah penyimpanan
            txtelektro1.setEnabled(true); // Disable text field after saving
            txtelektro3.setEnabled(true);
            txtelektro4.setEnabled(true);
            txtelektro5.setEnabled(true);
            txtelektro6.setEnabled(true);

            btnedit1.setText("Edit"); // Change button label back to "Edit"
        }
    }//GEN-LAST:event_btnedit1ActionPerformed

    private void btncari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncari1ActionPerformed
        try {
            Statement statement = koneksi.getKoneksi().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM jurusanelektro "+"WHERE `Nama Dosen` LIKE '%" + txtcari1.getText() + "%' OR NIP LIKE '%" + txtcari1.getText() + "%'");

            DefaultTableModel tb = new DefaultTableModel();
            tb.addColumn("Nama Dosen");
            tb.addColumn("NIP");
            tb.addColumn("Riwayat Pendidikan");
            tb.addColumn("Email");
            tb.addColumn("Bidang Keahlian");
            tb.addColumn("Jabatan");

            while (res.next()) {
                tb.addRow(new Object[]{
                    res.getString("Nama Dosen"),
                    res.getString("NIP"),
                    res.getString("Riwayat Pendidikan"),
                    res.getString("Email"),
                    res.getString("Bidang Keahlian"),
                    res.getString("Jabatan")
                });
            }

            tblelektro.setModel(tb);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }   
    }//GEN-LAST:event_btncari1ActionPerformed

    private void mesin6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesin6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesin6ActionPerformed

    private void btnsimpanmesinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanmesinActionPerformed
        try{
            String sql = "INSERT INTO jurusanmesin VALUES('"+mesin1.getText()+"','"+mesin2.getText()+"','"+mesin3.getText()+"','"+mesin4.getText()+"','"+mesin5.getText()+"','"+mesin6.getText()+"')";
            java.sql.Connection conn = (java.sql.Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Disimpan");
            
        }catch (SQLException | HeadlessException e ){
            JOptionPane.showMessageDialog(null,e);
        }
        dataTable2();
    }//GEN-LAST:event_btnsimpanmesinActionPerformed

    private void bedit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedit2ActionPerformed
        String nip = txtelektro2.getText();
    
        if (bedit2.getText().equals("Edit")) {
            // Mode edit diaktifkan
            mesin1.setEnabled(true); // Enable text field for editing
            mesin3.setEnabled(true);
            mesin4.setEnabled(true);
            mesin5.setEnabled(true);
            mesin6.setEnabled(true);

            bedit2.setText("Simpan"); // Change button label to "Simpan" (Save)
        } else if (bedit2.getText().equals("Simpan")) {
            String namadosen = mesin1.getText();
            String RiwayatPendidikan = mesin3.getText();
            String Email = mesin4.getText();
            String BidangKeahlian = mesin5.getText();
            String Jabatan = mesin6.getText();

            try {
                Connection conn = koneksi.getKoneksi();
                PreparedStatement statement = conn.prepareStatement("UPDATE jurusanelektro SET `Nama Dosen` = ?, `Riwayat Pendidikan` = ?, `Email` = ?, `Bidang Keahlian` = ?, `Jabatan` = ? WHERE `NIP` = ?");
                statement.setString(1, namadosen);
                statement.setString(2, RiwayatPendidikan);
                statement.setString(3, Email);
                statement.setString(4, BidangKeahlian);
                statement.setString(5, Jabatan);
                statement.setString(6, nip);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                    showDataInTable2(); // Panggil metode untuk menampilkan data yang sudah diubah di tabel
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal diubah");
                }
                statement.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
            }

            // Mode edit dinonaktifkan setelah penyimpanan
            mesin1.setEnabled(true); // Enable text field for editing
            mesin3.setEnabled(true);
            mesin4.setEnabled(true);
            mesin5.setEnabled(true);
            mesin6.setEnabled(true);

            bedit2.setText("Edit"); // Change button label back to "Edit"
        }
    }//GEN-LAST:event_bedit2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void mesin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesin1ActionPerformed

    private void mesin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesin2ActionPerformed

    private void mesin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesin3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesin3ActionPerformed

    private void mesin4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesin4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesin4ActionPerformed

    private void mesin5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesin5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesin5ActionPerformed

    private void sipil6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipil6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sipil6ActionPerformed

    private void btnsimpansipilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpansipilActionPerformed
        try{
            String sql = "INSERT INTO jurusansipil VALUES('"+sipil1.getText()+"','"+sipil2.getText()+"','"+sipil3.getText()+"','"+sipil4.getText()+"','"+sipil5.getText()+"','"+sipil6.getText()+"')";
            java.sql.Connection conn = (java.sql.Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Disimpan");
            
        }catch (SQLException | HeadlessException e ){
            JOptionPane.showMessageDialog(null,e);
        }
        dataTable3();
    }//GEN-LAST:event_btnsimpansipilActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void sipil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipil1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sipil1ActionPerformed

    private void sipil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipil2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sipil2ActionPerformed

    private void sipil3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipil3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sipil3ActionPerformed

    private void sipil4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipil4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sipil4ActionPerformed

    private void sipil5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipil5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sipil5ActionPerformed

    private void arsi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arsi1ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void arsi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arsi2ActionPerformed

    private void arsi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arsi3ActionPerformed

    private void arsi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arsi4ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void arsi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arsi5ActionPerformed

    private void arsi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arsi6ActionPerformed

    private void btnsimpanarsitekturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanarsitekturActionPerformed
        try{
            String sql = "INSERT INTO jurusanarsitektur VALUES('"+arsi1.getText()+"','"+arsi2.getText()+"','"+arsi3.getText()+"','"+arsi4.getText()+"','"+arsi5.getText()+"','"+arsi6.getText()+"')";
            java.sql.Connection conn = (java.sql.Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Disimpan");
            
        }catch (SQLException | HeadlessException e ){
            JOptionPane.showMessageDialog(null,e);
        }
        dataTable4();
    }//GEN-LAST:event_btnsimpanarsitekturActionPerformed

    private void kimia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kimia1ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void kimia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimia2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kimia2ActionPerformed

    private void kimia3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimia3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kimia3ActionPerformed

    private void kimia4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimia4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kimia4ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void kimia5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimia5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kimia5ActionPerformed

    private void kimia6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kimia6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kimia6ActionPerformed

    private void btnsimpankimiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpankimiaActionPerformed
        try{
            String sql = "INSERT INTO jurusankimia VALUES('"+kimia1.getText()+"','"+kimia2.getText()+"','"+kimia3.getText()+"','"+kimia4.getText()+"','"+kimia5.getText()+"','"+kimia6.getText()+"')";
            java.sql.Connection conn = (java.sql.Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data Disimpan");
            
        }catch (SQLException | HeadlessException e ){
            JOptionPane.showMessageDialog(null,e);
        }
        dataTable5();
    }//GEN-LAST:event_btnsimpankimiaActionPerformed

    private void btnhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus1ActionPerformed
          try {
            int row = tblelektro.getSelectedRow();
            String eve = tblelektro.getModel().getValueAt(row, 1).toString();
            String deletrow = "DELETE FROM jurusanelektro WHERE NIP='" + eve + "'";

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                Connection conn = getConnection();
                Statement statement = conn.createStatement();
                int rowsAffected = statement.executeUpdate(deletrow);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                    // Lakukan tindakan lanjutan setelah penghapusan data jika diperlukan
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data.", "Hapus Data", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hapus Data", JOptionPane.ERROR_MESSAGE);
        }dataTable();
    }//GEN-LAST:event_btnhapus1ActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtelektro1.setText("");
        txtelektro2.setText("");
        txtelektro3.setText("");
        txtelektro4.setText("");
        txtelektro5.setText("");
        txtelektro6.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void tblelektroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblelektroMouseClicked
        int i = tblelektro.getSelectedRow();
        if (i == -1){
            return;
        }
        String namadosen =(String)tblelektro.getValueAt(i, 0);
        txtelektro1.setText(namadosen);
        String NIP =(String)tblelektro.getValueAt(i, 1);
        txtelektro2.setText(NIP);
        String RiwayatPendidikan =(String)tblelektro.getValueAt(i, 2);
        txtelektro3.setText(RiwayatPendidikan);
        String Email =(String)tblelektro.getValueAt(i, 3);
        txtelektro4.setText(Email);
        String BidangKeahlian =(String)tblelektro.getValueAt(i, 4);
        txtelektro5.setText(BidangKeahlian);
        String Jabatan =(String)tblelektro.getValueAt(i, 5);
        txtelektro6.setText(Jabatan);
    }//GEN-LAST:event_tblelektroMouseClicked

    private void btnhapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus3ActionPerformed
        try {
            int row = tblsipil.getSelectedRow();
            String eve = tblsipil.getModel().getValueAt(row, 1).toString();
            String deletrow = "DELETE FROM jurusansipil WHERE NIP='" + eve + "'";

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                Connection conn = getConnection();
                Statement statement = conn.createStatement();
                int rowsAffected = statement.executeUpdate(deletrow);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                    // Lakukan tindakan lanjutan setelah penghapusan data jika diperlukan
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data.", "Hapus Data", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hapus Data", JOptionPane.ERROR_MESSAGE);
        }dataTable3();
    }//GEN-LAST:event_btnhapus3ActionPerformed

    private void btnclear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclear3ActionPerformed
        sipil1.setText("");
        sipil2.setText("");
        sipil3.setText("");
        sipil4.setText("");
        sipil5.setText("");
        sipil6.setText("");
    }//GEN-LAST:event_btnclear3ActionPerformed

    private void btnhapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus2ActionPerformed
        try {
            int row = tblmesin.getSelectedRow();
            String eve = tblmesin.getModel().getValueAt(row, 1).toString();
            String deletrow = "DELETE FROM jurusanmesin WHERE NIP='" + eve + "'";

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                Connection conn = getConnection();
                Statement statement = conn.createStatement();
                int rowsAffected = statement.executeUpdate(deletrow);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                    // Lakukan tindakan lanjutan setelah penghapusan data jika diperlukan
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data.", "Hapus Data", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hapus Data", JOptionPane.ERROR_MESSAGE);
        }dataTable2();
    }//GEN-LAST:event_btnhapus2ActionPerformed

    private void btnclear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclear2ActionPerformed
        mesin1.setText("");
        mesin2.setText("");
        mesin3.setText("");
        mesin4.setText("");
        mesin5.setText("");
        mesin6.setText("");
    }//GEN-LAST:event_btnclear2ActionPerformed

    private void btnhapus4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus4ActionPerformed
        try {
            int row = tblarsitektur.getSelectedRow();
            String eve = tblarsitektur.getModel().getValueAt(row, 1).toString();
            String deletrow = "DELETE FROM jurusanarsitektur WHERE NIP='" + eve + "'";

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                Connection conn = getConnection();
                Statement statement = conn.createStatement();
                int rowsAffected = statement.executeUpdate(deletrow);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                    // Lakukan tindakan lanjutan setelah penghapusan data jika diperlukan
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data.", "Hapus Data", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hapus Data", JOptionPane.ERROR_MESSAGE);
        }dataTable4();
    }//GEN-LAST:event_btnhapus4ActionPerformed

    private void btnclear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclear4ActionPerformed
        arsi1.setText("");
        arsi2.setText("");
        arsi3.setText("");
        arsi4.setText("");
        arsi5.setText("");
        arsi6.setText("");
    }//GEN-LAST:event_btnclear4ActionPerformed

    private void btnhapus5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus5ActionPerformed
        try {
            int row = tblkimia.getSelectedRow();
            String eve = tblkimia.getModel().getValueAt(row, 1).toString();
            String deletrow = "DELETE FROM jurusankimia WHERE NIP='" + eve + "'";

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                Connection conn = getConnection();
                Statement statement = conn.createStatement();
                int rowsAffected = statement.executeUpdate(deletrow);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                    // Lakukan tindakan lanjutan setelah penghapusan data jika diperlukan
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data.", "Hapus Data", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Hapus Data", JOptionPane.ERROR_MESSAGE);
        }dataTable5();
    }//GEN-LAST:event_btnhapus5ActionPerformed

    private void btnclear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclear5ActionPerformed
        kimia1.setText("");
        kimia2.setText("");
        kimia3.setText("");
        kimia4.setText("");
        kimia5.setText("");
        kimia6.setText("");
    }//GEN-LAST:event_btnclear5ActionPerformed

    private void tblmesinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmesinMouseClicked
        int i = tblmesin.getSelectedRow();
        if (i == -1){
            return;
        }
        String namadosen =(String)tblmesin.getValueAt(i, 0);
        mesin1.setText(namadosen);
        String NIP =(String)tblmesin.getValueAt(i, 1);
        mesin2.setText(NIP);
        String RiwayatPendidikan =(String)tblmesin.getValueAt(i, 2);
        mesin3.setText(RiwayatPendidikan);
        String Email =(String)tblmesin.getValueAt(i, 3);
        mesin4.setText(Email);
        String BidangKeahlian =(String)tblmesin.getValueAt(i, 4);
        mesin5.setText(BidangKeahlian);
        String Jabatan =(String)tblmesin.getValueAt(i, 5);
        mesin6.setText(Jabatan);
    }//GEN-LAST:event_tblmesinMouseClicked

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
            java.util.logging.Logger.getLogger(FromMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arsi1;
    private javax.swing.JTextField arsi2;
    private javax.swing.JTextField arsi3;
    private javax.swing.JTextField arsi4;
    private javax.swing.JTextField arsi5;
    private javax.swing.JTextField arsi6;
    private javax.swing.JButton bedit2;
    private javax.swing.JButton btncari1;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnclear2;
    private javax.swing.JButton btnclear3;
    private javax.swing.JButton btnclear4;
    private javax.swing.JButton btnclear5;
    private javax.swing.JButton btnedit1;
    private javax.swing.JButton btnhapus1;
    private javax.swing.JButton btnhapus2;
    private javax.swing.JButton btnhapus3;
    private javax.swing.JButton btnhapus4;
    private javax.swing.JButton btnhapus5;
    private javax.swing.JButton btnsimpanarsitektur;
    private javax.swing.JButton btnsimpanelektro;
    private javax.swing.JButton btnsimpankimia;
    private javax.swing.JButton btnsimpanmesin;
    private javax.swing.JButton btnsimpansipil;
    private javax.swing.JLabel elektro1;
    private javax.swing.JLabel elektro2;
    private javax.swing.JLabel elektro3;
    private javax.swing.JLabel elektro4;
    private javax.swing.JLabel elektro5;
    private javax.swing.JLabel elektro6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField kimia1;
    private javax.swing.JTextField kimia2;
    private javax.swing.JTextField kimia3;
    private javax.swing.JTextField kimia4;
    private javax.swing.JTextField kimia5;
    private javax.swing.JTextField kimia6;
    private javax.swing.JPanel main;
    private javax.swing.JTextField mesin1;
    private javax.swing.JTextField mesin2;
    private javax.swing.JTextField mesin3;
    private javax.swing.JTextField mesin4;
    private javax.swing.JTextField mesin5;
    private javax.swing.JTextField mesin6;
    private javax.swing.JPanel nav;
    private javax.swing.JPanel side;
    private javax.swing.JTextField sipil1;
    private javax.swing.JTextField sipil2;
    private javax.swing.JTextField sipil3;
    private javax.swing.JTextField sipil4;
    private javax.swing.JTextField sipil5;
    private javax.swing.JTextField sipil6;
    private javax.swing.JTable tblarsitektur;
    private javax.swing.JTable tblelektro;
    private javax.swing.JTable tblkimia;
    private javax.swing.JTable tblmesin;
    private javax.swing.JTable tblsipil;
    private javax.swing.JTextField txtcari1;
    private javax.swing.JTextField txtelektro1;
    private javax.swing.JTextField txtelektro2;
    private javax.swing.JTextField txtelektro3;
    private javax.swing.JTextField txtelektro4;
    private javax.swing.JTextField txtelektro5;
    private javax.swing.JTextField txtelektro6;
    // End of variables declaration//GEN-END:variables
}
