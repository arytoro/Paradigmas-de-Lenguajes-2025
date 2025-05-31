/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Ary Toro
 */
public class ViajeroFrecuente {
    private Integer numero;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer millas;

    /** Constructor **/
    public ViajeroFrecuente(Integer numero, String dni, String nombre, String apellido, Integer millas) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.millas = millas;
    }
    /** Getters **/
    public Integer getNumero() {
        return numero;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getMillas() {
        return millas;
    }
    /**Setters **/
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMillas(Integer millas) {
        this.millas = millas;
    }
    
    public Integer acumularMillas(Integer plusMillas){
        this.millas+=plusMillas;
        return this.millas;
    }
    
    public Integer canjearMillas(Integer canjMillas) throws ExcMillasInsuficientes{
        if (canjMillas <= this.getMillas()) {
            this.millas-=canjMillas;
        }else{
            throw new ExcMillasInsuficientes("Error. El viajero "+ numero + " no tiene millas suficientes");
        }
        return this.millas;
    }
    
    @Override
    public String toString() {
        return "Numero= " + numero + "\n"
             + "DNI= " + dni + "\n"
             + "Nombre= " + nombre + "\n"
             + "Apellido=" + apellido + "\n"
             + "Millas= " + millas + "\n";
    }
}
