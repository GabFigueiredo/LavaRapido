/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lavarapido;

import java.sql.SQLException;
import lavarapido.view.TelaPrincipal;

/**
 *
 * @author gabri
 */
public class LavaRapido {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        TelaPrincipal principal = new TelaPrincipal();
        principal.pack();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
    
}
