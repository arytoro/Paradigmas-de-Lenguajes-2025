/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author aryto
 */
public class Campeonato {
    private static final String SEPARADOR=",";
    
    
    public static List<Deportista> leerArchivo(String nombreArchivo)throws IOException, ExcepcionDeporte{
        BufferedReader bufferLectura = null;
        List<Deportista> datos = new ArrayList<>();
        try {
            bufferLectura = new BufferedReader(new FileReader(nombreArchivo));
            String linea;                  

            while ((linea=bufferLectura.readLine()) != null) {
             // Sepapar la linea leída con el separador definido previamente
             String[] campos = linea.split(SEPARADOR); 
             if (campos[0].equals(""))
                 throw new ExcepcionDeporte("nombre vacio");
             Deportista d = new Deportista(campos[0],campos[1]);
             datos.add(d);           
            }
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
         // Cierro el buffer de lectura
         if (bufferLectura != null) {
             bufferLectura.close();
         }
        }
        return datos;
    }
    /*
    public static List<IDeporte> creaEquipos(List<Deportista> datos, int cantidadJugadores){
        List<IDeporte> equipos= new ArrayList<> ();
        int numE=1;
        for (int i=0;i<datos.size();i+=cantidadJugadores){
            List<Deportista> deportistas= new ArrayList<> ();
            Equipo equipo= new Equipo("Equipo "+numE);
            int cont=0;
            int j=i;
            while (cont<cantidadJugadores){
                deportistas.add(datos.get(j));
                j++;
                cont++;
            }
            equipo.conformar(deportistas);
            equipos.add(equipo);
            numE++;
        }
        return equipos;
    }*/
    public static List<IDeporte> creaEquipos(List<Deportista> datos, int cantidadJugadores){
        AtomicInteger numE = new AtomicInteger(1); // Es el numero que se asociara a cada Equipo
    
        List<IDeporte> equipos = IntStream.range(0, datos.size() / cantidadJugadores)  //Lista con Iteracion desde 0 hasta Cantidad de Equipos que se pueden armar
            .mapToObj(i -> { //
                List<Deportista> deportistas = IntStream.range(i * cantidadJugadores, (i + 1) * cantidadJugadores) // Desde que indice hasta que indice estará formado un equipo
                        .mapToObj(datos::get) //Recupera una coleccion de los Deportistas de la lista Datos recibida por parametros
                        .collect(Collectors.toList()); //Transforma la coleccion a una lista
                
                Equipo equipo = new Equipo("Equipo " + numE.getAndIncrement()); //Devuelve el numE definido al inicio y lo incrementa en 1
                equipo.conformar(deportistas);
                
                return equipo; //En el indice "i" de la cabecera de la lambda se guarda un Equipo.
            })
            .collect(Collectors.toList()); //Convierte la coleccion a lista
    
        return equipos;
    }
    
    
    /**
    Crea los equipos con los datos pasados como parámetro
     * @param datos es una lista con todos los deportitas inscriptos
     * @return una lista de Parejas formadas
    */
    /*public static List<IDeporte> creaParejas(List<Deportista> datos){
        List<IDeporte> parejas= new ArrayList<> ();
        for (int i=0;i<datos.size();i+=2){
            List<Deportista> deportistas= new ArrayList<> ();
            Pareja pareja= new Pareja();
            int cont=0;
            int j=i;
            while (cont<2){
                deportistas.add(datos.get(j));
                j++;
                cont++;
            }
            pareja.conformar(deportistas);
            parejas.add(pareja);
        }
        return parejas;
    }*/
    
    public static List<IDeporte> creaParejas(List<Deportista> datos){
        List<IDeporte> parejas= IntStream.range(0, datos.size()/2)
                .mapToObj(i -> {
                    List<Deportista> deportistas= IntStream.range(i*2, (i+1)*2)
                            .mapToObj(datos::get)
                            .collect(Collectors.toList());
                    
                    Pareja pareja= new Pareja();
                    pareja.conformar(deportistas);
                    return pareja;  
                })
                .collect(Collectors.toList());
        
        return parejas;
    }

    
    /**
    * Numera cada integrante del equipo o de la pareja
     * @param datos 
    */
    public static void numerar(List<IDeporte> datos){
        datos.stream()
        .forEach(IDeporte::numeroDeportista);
        /*
         for (int i=0;i<datos.size();i++){
             datos.get(i).numeroDeportista();
         }*/
    }
    /**
    * Muestra los datos de cada equipo o de cada pareja
     * @param datos
    */
    public static void mostrar(List<IDeporte> datos){
        datos.stream()
                .forEach(IDeporte::mostrar);
    }
    /*
        for (int i=0;i<datos.size();i++){
            System.out.println("---- Equipo/Pareja ----");
            datos.get(i).mostrar();
        }
    }*/
    /*
    public static void main(String[] args) throws IOException, ExcepcionDeporte {
        List<Deportista> datosFutbol= leerArchivo("inscriptosFutbol.csv");
        List<Deportista> datosPinPon= leerArchivo("inscriptosPinPon.csv");
    }
    */
}
