/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Ary Toro
 */
public class Deportista {
    private String nombre;
    private String dni;
    private int numeroJugador;

    public Deportista(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.numeroJugador=-1;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }
    
    public void setNumeroJugador(int num){
        this.numeroJugador= num;
    }
    
    @Override
    public String toString() {
        return "DNI= " + dni + "\n"
             + "Nombre= " + nombre + "\n"
             + "Numero Jugador= " + numeroJugador + "\n";
    }
}
