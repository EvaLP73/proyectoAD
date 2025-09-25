import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BorradoEmpleados {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String usuario = "root";
        String clave = "abc123.";
        String url ="jdbc:mysql://localhost:3306/empleados";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario,clave);

            System.out.println("Introduzca el número de empleado a borrar");

            int numero= -1;
            while(numero < 0)
                numero = scanner.nextInt();

            // Desactivamos las foreign_key
            Statement stm = conn.createStatement();
            stm.execute("SET FOREIGN_KEY_CHECKS=0");

            PreparedStatement ps = conn.prepareStatement("DELETE FROM empleado WHERE NSS = ?");
            ps.setInt(1,  numero);
            int numTuplas = ps.executeUpdate();

            System.out.println("Sentencia: " + ps.toString());
            System.out.println("Tuplas afectadas: " + numTuplas);

            ps.close();

            // Volvemos a activarlas
            stm = conn.createStatement();
            stm.execute("SET FOREIGN_KEY_CHECKS=1");

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }finally {
            try {
                conn.close();
                scanner.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

