/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import ConexionBD.ConexionBD;
import modelo.Carrera;

import java.sql.*;
import java.util.Scanner;

public class GestionCarreras {

    public void añadirCarrera(Scanner scanner) {
        System.out.print("Introduce el nombre de la nueva carrera: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();

        String query = "INSERT INTO carreras (nombre) VALUES (?)";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            System.out.println("Carrera añadida con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al añadir carrera.");
            e.printStackTrace();
        }
    }

    public void actualizarCarrera(Scanner scanner) {
        System.out.print("Introduce el ID de la carrera que quieres actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Introduce el nuevo nombre para la carrera: ");
        scanner.nextLine(); // Limpiar buffer
        String nuevoNombre = scanner.nextLine();

        String query = "UPDATE carreras SET nombre = ? WHERE id = ?";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Carrera actualizada con éxito.");
            } else {
                System.out.println("No se encontró la carrera con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la carrera.");
            e.printStackTrace();
        }
    }

    public void verCarrera(Scanner scanner) {
        System.out.print("Introduce el ID de la carrera que quieres ver: ");
        int id = scanner.nextInt();

        String query = "SELECT * FROM carreras WHERE id = ?";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Carrera carrera = new Carrera(rs.getInt("id"), rs.getString("nombre"));
                System.out.println("ID: " + carrera.getId());
                System.out.println("Nombre: " + carrera.getNombre());
            } else {
                System.out.println("No se encontró ninguna carrera con ese ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la carrera.");
            e.printStackTrace();
        }
    }

    public void borrarCarrera(Scanner scanner) {
        System.out.print("Introduce el ID de la carrera que quieres borrar: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM carreras WHERE id = ?";
        try (Connection conn = ConexionBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Carrera borrada con éxito.");
            } else {
                System.out.println("No se encontró la carrera con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar la carrera.");
            e.printStackTrace();
        }
    }
}
