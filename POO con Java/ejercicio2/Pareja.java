/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author aryto
 */
public class Pareja implements IDeporte{
    private List<Deportista> integrantes;
    
    @Override
    public boolean conformar(List<Deportista> integrantes){
        this.integrantes= integrantes;
        return true;
    }
    
    @Override
    public void mostrar(){
        System.out.println("Datos de una pareja");
        this.integrantes.stream()
                .forEach(integrante -> {
                    System.out.println(integrante);
                });
        /*
        for (int i=0;i<this.integrantes.size();i++){
            System.out.println(this.integrantes.get(i)+"\n------");
        }*/
    }
    
    @Override
    public void numeroDeportista(){
        // System.out.println("No entiendo que hacer");
        AtomicInteger numDep= new AtomicInteger(1);
        this.integrantes.stream()
                .forEach(integrante ->{
                    integrante.setNumeroJugador(numDep.getAndIncrement());
                });
        /*for (int i=0;i<this.integrantes.size();i++){
            this.integrantes.get(i).setNumeroJugador(i+1);
        }*/
    }

}
