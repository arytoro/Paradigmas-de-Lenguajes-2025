/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Ary Toro
 */
public class ejercicio1{
    /* Punto de Entrada */
    public static void main(String[] args) {
        Gestor g= new Gestor(3); /*Como maximo almacenara 3 viajeros*/
        Menu m= new Menu(g);
        m.MostrarMenu();
    }
}
