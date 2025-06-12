/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;
import java.util.List;
/**
 *
 * @author aryto
 */
public interface IDeporte {
    int CANTIDAD_MINIMA=2;
    boolean conformar(List<Deportista> integrantes);
    void mostrar();
    void numeroDeportista();
}
