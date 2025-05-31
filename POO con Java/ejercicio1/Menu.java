/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;
import java.util.Scanner;
/**
 *
 * @author Ary Toro
 */
public class Menu {
    private int opcion;

    public Menu(Gestor g){
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== MENU DE OPCIONES ===");
            System.out.println("1. Cargar Viajero");
            System.out.println("2. Mostrar Viajero por Numero");
            System.out.println("3. Acumular Millas");
            System.out.println("4. Canjear Millas");
            System.out.println("5. Listar Mejor/es Viajero/s");
            System.out.println("6. Mostrar Viajeros Cargados");
            System.out.println("7. SALIR");
            System.out.print("> ");
            
            this.opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    try {
                    g.CargarViajero();
                    }
                    catch (ExcViajeroExistente e){
                        System.err.println(e.getMessage());
                    }
                    catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingresa el Numero del Viajero: ");
                    try{
                        g.MostrarViajero(scanner.nextInt());
                        scanner.nextLine();
                    }
                    catch (ExcViajeroInexistente e){
                        System.err.println(e.getMessage());
                    }
                    catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Ingresa el DNI del Viajero: ");
                    String dni3= scanner.nextLine();
                    System.out.println("Ingresa las millas a acumular: ");
                    Integer millas3= scanner.nextInt();
                    scanner.nextLine();
                    try{
                        System.out.println("Ahora tiene: "+g.AcumularMillas(dni3,millas3));
                    }
                    catch (ExcViajeroInexistente e){
                        System.err.println(e.getMessage());
                    }
                    catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Ingresa el DNI del Viajero: ");
                    String dni4= scanner.nextLine();
                    System.out.println("Ingresa las millas a canjear: ");
                    Integer millas4= scanner.nextInt();
                    scanner.nextLine();
                    try{
                        System.out.println("Ahora tiene: "+g.CanjearMillas(dni4,millas4));
                    }
                    catch (ExcViajeroInexistente e){
                        System.err.println(e.getMessage());
                    }
                    catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    g.MejorViajero();
                    break;
                case 6:
                    g.MostrarViajerosCargados();
                    break;
                case 7:
                    System.out.println("Cerrando Sistema....");
                    break;
                default:
                    System.out.println("Opcion invalida, intenta de nuevo.");
            }
        } while (opcion != 7);
    }
}