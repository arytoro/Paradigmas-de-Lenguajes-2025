/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author aryto
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ExcepcionDeporte{
        
        List<Deportista> datosFutbol= Campeonato.leerArchivo("inscriptosFutbol.csv");
        List<Deportista> datosPinPon= Campeonato.leerArchivo("inscriptosPinPon.csv");
        
        List<IDeporte> equiposFutbol= Campeonato.creaEquipos(datosFutbol, 5);
        List<IDeporte> parejasPinPon= Campeonato.creaParejas(datosPinPon);
        
        Campeonato.numerar(equiposFutbol);
        Campeonato.mostrar(equiposFutbol);
        
        Campeonato.numerar(parejasPinPon);
        Campeonato.mostrar(parejasPinPon);
            /*System.out.println("--- Jugadores de fulbo ---");
            for (int i=0;i<datosFutbol.size();i++){
                System.out.println(datosFutbol.get(i).getNombre());
            }
            System.out.println("--- Jugadores de pinpon ---");
            for (int i=0;i<datosPinPon.size();i++){
                System.out.println(datosPinPon.get(i).getNombre*/
            
        
        
    }
    
}
