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

public class FromMain2 extends javax.swing.JFrame {

    public static Connection con;
    public static java.sql.Statement stm;
    public static ResultSet res;
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:8111/db_dosenteknik";
        String username = "root";
        String password = "";
        return DriverManager.getConnection(url, username, password);
    }
    
    public FromMain2() {
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
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btncari1 = new javax.swing.JButton();
        txtcari1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblelektro = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblmesin = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jTextField19 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblsipil = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jTextField29 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblarsitektur = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jTextField37 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblkimia = new javax.swing.JTable();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Jurusan Elektro", jPanel1);

        jPanel2.setBackground(new java.awt.Color(65, 145, 151));

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

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Data Dosen Jurusan Mesin");

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
        jScrollPane2.setViewportView(tblmesin);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jPanel3.setBackground(new java.awt.Color(65, 145, 151));

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

        jLabel25.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Data Dosen Jurusan Sipil");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        jPanel4.setBackground(new java.awt.Color(65, 145, 151));

        jLabel29.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Data Dosen Jurusan Arsitektur");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        jPanel5.setBackground(new java.awt.Color(65, 145, 151));

        jLabel38.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Data Dosen Jurusan Kimia");

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel5);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
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

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void tblelektroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblelektroMouseClicked

    }//GEN-LAST:event_tblelektroMouseClicked

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
    private javax.swing.JButton btncari1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
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
    private javax.swing.JPanel main;
    private javax.swing.JPanel nav;
    private javax.swing.JPanel side;
    private javax.swing.JTable tblarsitektur;
    private javax.swing.JTable tblelektro;
    private javax.swing.JTable tblkimia;
    private javax.swing.JTable tblmesin;
    private javax.swing.JTable tblsipil;
    private javax.swing.JTextField txtcari1;
    // End of variables declaration//GEN-END:variables
}
