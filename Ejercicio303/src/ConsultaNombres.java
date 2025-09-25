import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConsultaNombres {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String usuario = "root";
        String clave = "abc123.";
        String url ="jdbc:mysql://localhost:3306/empleados";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario,clave);

            System.out.println("Introduzca la letra por la que querría buscar");

            String letra = "";
            while(letra.equals("") || letra.length() != 1)
                letra = scanner.next().toUpperCase();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from empleado where Nombre like '" + letra + "%'");

            while(rs.next()) {
                System.out.println("\tNSS: " + rs.getInt("NSS") +
                        ", Nombre: " + rs.getString("Nombre") +
                        ", Apellido 1: " + rs.getString("Apel1") +
                        ", Apellido 2 : " + rs.getString("Apel2") +
                        ", Sexo: " + rs.getString("Sexo") +
                        ", Dirección: " + rs.getString("Dirección") +
                        ", Fecha nacimiento: " + rs.getString("Fechanac") +
                        ", Salario: " + rs.getString("Salario") +
                        ", Núm. departamento: " + rs.getString("Numdept") +
                        ", NSSsup: " + rs.getString("NSSsup"));
            }

        } catch (SQLException ex) {
            System.out.println("Error");
        }finally {
            try {
                conn.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}