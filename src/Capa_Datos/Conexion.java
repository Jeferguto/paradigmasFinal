package Capa_Datos;

import java.sql.*;

public class Conexion {
    private final String url = "jdbc:mysql://localhost:3306/ventasprueba";
    private final String user = "root";
    private final String pwd = "";

    public Conexion() {
    }

    public ResultSet Listar(String cad) {
        try {
            Connection cn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement da = cn.prepareStatement(cad);
            ResultSet tbl = da.executeQuery();
            return tbl;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public String Ejecutar(String Cad) {
        try {
            Connection cn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement da = cn.prepareStatement(Cad);
            int r = da.executeUpdate();
            return "Se afectaron " + r + " filas";
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return "Error " + e.getMessage();
        }
    }
}
