/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author gabri
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    // Configurações do banco direto no código
    private static final String URL = "jdbc:postgresql://localhost:5432/nome_do_banco";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    // Método para retornar a conexão
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
