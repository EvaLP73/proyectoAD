import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransaccionEmpleado {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String usuario = "root";
        String clave = "abc123.";
        String url ="jdbc:mysql://localhost:3306/empleados";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, clave);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO empleado(NSS, Nombre, Numdept) VALUES (?, ?, ?)");

            conn.setAutoCommit(false);

            ps.setInt(1, 6);
            ps.setString(2, "Amancio");
            ps.setInt(3, 1);
            ps.executeUpdate();

            ps.setInt(1, 5);
            ps.setString(2, "Lucas");
            ps.executeUpdate();



            conn.commit();

            System.out.println("Todos los datos han sido introducidos");

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }finally {
            try {
                conn.rollback();
                conn.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
