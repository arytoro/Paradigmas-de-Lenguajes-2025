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
public class Gestor {
    private Integer cantidad;
    private ViajeroFrecuente[] viajeros;
    public Gestor(Integer longitud) {
        this.cantidad= 0;
        this.viajeros = new ViajeroFrecuente[longitud];
    }
    
    public void CargarViajero() throws ExcViajeroExistente{
        if (this.cantidad == this.viajeros.length){
            System.out.print("No es posible registrar mas viajeros, el maximo es "+this.viajeros.length+"\n");
        }else{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el numero de viajero: ");
            Integer numero = scanner.nextInt();
            scanner.nextLine();
            if (this.BuscarViajeroPorNumero(numero)!= -1){
                throw new ExcViajeroExistente("Error. El viajero con el numero "+numero+" ya esta registrado");
            } else {
                System.out.print("Ingrese su dni: ");
                String dni = scanner.nextLine();
                if (this.BuscarViajeroPorDni(dni)!= -1){
                    throw new ExcViajeroExistente("Error. El viajero con dni "+dni+" ya esta registrado");
                } else {
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese su apellido: ");
                    String apellido = scanner.nextLine();        
                    System.out.print("Ingrese las millas: ");
                    Integer millas = scanner.nextInt();
                    scanner.nextLine();
                    this.viajeros[cantidad]=(new ViajeroFrecuente(numero,dni,nombre,apellido,millas));
                    this.cantidad+=1;
                    System.out.print("Viajero "+numero+ " cargado exitosamenete \n");
                }
            }
        }
    }
    
    public int BuscarViajeroPorDni(String dni){
        /* Si el viajero con ese dni existe, devuleve su posicion en el arreglo, 
        caso contrario devuelve -1*/
        int pos=-1;
        int i=0;
        while (i<this.cantidad && !(this.viajeros[i].getDni().equals(dni))){
            i+=1;
        }
        if (i!=this.cantidad){
            pos= i;
        }
        return pos;
    }
    
    public int BuscarViajeroPorNumero(Integer numero){
        /* Si el viajero con ese numero existe, devuleve su posicion en el arreglo, 
        caso contrario devuelve -1*/
        int pos=-1;
        int i=0;
        while (i<this.cantidad && this.viajeros[i].getNumero()!=numero){
            i+=1;
        }
        if (i!=this.cantidad){
            pos= i;
        }
        return pos;
    }
    
    public void MostrarViajero(Integer numViajero) throws ExcViajeroInexistente{
        int indice= this.BuscarViajeroPorNumero(numViajero);
        if (indice!=-1){
            System.out.print(this.viajeros[indice]);
        }else{
            throw new ExcViajeroInexistente("Error. El viajero no existe");
        }
    }
    
    public Integer ConsultarCantidadMillas(String dni) throws ExcViajeroInexistente{
        int indice= this.BuscarViajeroPorDni(dni);
        if (indice== -1){
            throw new ExcViajeroInexistente("Error. El viajero no existe");
        }
        return this.viajeros[indice].getMillas();
    }
    
    public Integer AcumularMillas(String dni, Integer millas) throws ExcViajeroInexistente{
        int indice= this.BuscarViajeroPorDni(dni);
        if (indice==-1){
            throw new ExcViajeroInexistente("Error. El viajero no existe");
        }
        return this.viajeros[indice].acumularMillas(millas);
    }
    
    public Integer CanjearMillas(String dni, Integer millas) throws ExcViajeroInexistente{
        int indice= this.BuscarViajeroPorDni(dni);
        if (indice==-1){
            throw new ExcViajeroInexistente("Error. El viajero no existe");
        }
        try{
            Integer devolver= this.viajeros[indice].canjearMillas(millas);
            return devolver;
        }catch (ExcMillasInsuficientes e){
            System.err.println(e.getMessage());
            return this.viajeros[indice].getMillas();
        }
    }
    
    public void MejorViajero(){
        int max=-1;
        System.out.println("--- Mostrando Mejor/es Viajero/s---");
        for (int i=0;i<this.cantidad;i++){
            if (this.viajeros[i].getMillas()>=max){
                max= this.viajeros[i].getMillas();
            }
        }
        for (int i=0;i<this.cantidad;i++){
            if (this.viajeros[i].getMillas()==max){
                System.out.println("------");
                System.out.print(this.viajeros[i]);
            }
        }
    }
    
    public void MostrarViajerosCargados(){
        for (int i=0;i<this.cantidad;i++){
            System.out.println("----- En posicion "+i+" -----");
            System.out.println(this.viajeros[i]);
        }
    }
}
