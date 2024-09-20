/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main.controlescolar2;


import java.util.Scanner;
import ConexionBD.GestionCarreras;

public class controlescolar2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionCarreras gestion = new GestionCarreras();
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de Carreras ---");
            System.out.println("1. Añadir Carrera");
            System.out.println("2. Actualizar Carrera");
            System.out.println("3. Ver Carrera por ID");
            System.out.println("4. Borrar Carrera");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestion.añadirCarrera(scanner);
                    break;
                case 2:
                    gestion.actualizarCarrera(scanner);
                    break;
                case 3:
                    gestion.verCarrera(scanner);
                    break;
                case 4:
                    gestion.borrarCarrera(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
