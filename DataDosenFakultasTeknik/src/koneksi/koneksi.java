package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.cj.jdbc.Driver;


public class koneksi {
    private static Connection koneksi;
    
    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:8111/db_dosenteknik";
                String username = "root";
                String password = "";
                
                // Gantilah penggunaan com.mysql.jdbc.Driver yang lama menjadi com.mysql.cj.jdbc.Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                koneksi = DriverManager.getConnection(url, username, password);
            } catch (SQLException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
}
