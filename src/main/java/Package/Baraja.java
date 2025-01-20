/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
/**
 *
 * @author PC
 */
public class Baraja {
    public List<Carta> baraja = new ArrayList();
    //<>

    public Baraja(int n) {
        for(int i=0;i<n;i++)
            crear_baraja();
    }
    
    public Baraja() {
        
    }
    
    public void crear_baraja(){// O añadir baraja 0
        Carta aux = new Carta();
        for(int j=1;j<5;j++){
            for(int i=1;i<14;i++){
                aux = new Carta(i,j);
                this.baraja.add(aux);
            }   
        }
        Carta joker = new Carta(0,5);
        this.baraja.add(joker);
        this.baraja.add(joker);
        
    }
    
    public void mostrar_baraja(){
        System.out.println("Numero de cartas: "+this.baraja.size());
        String info= "";
        for(int i=0;i<this.baraja.size();i++)
            info = info+baraja.get(i).mostrar()+"\n";
        
        
        System.out.println(info);
    }
    public void mostrar_baraja(Baraja a){
        String info= "mostrar";
        for(int i=0;i<a.baraja.size();i++)
            if(a.baraja.get(i)!=null)
            info = info+a.baraja.get(i).mostrar()+"\n";
        
        
        System.out.println(info);
    }
    public void unir_barajas(Baraja a, Baraja b, Baraja c, Baraja joker){
        this.baraja.addAll(a.baraja);
        a.baraja.clear();
        this.baraja.addAll(b.baraja);
        b.baraja.clear();
        this.baraja.addAll(c.baraja);
        c.baraja.clear();
        
        this.baraja.addAll(joker.baraja);
        joker.baraja.clear();
        
    }
    
    public void repartir_barajas(Baraja a){
        this.baraja.addAll(a.baraja);
        a.baraja.clear();
    }
    public void recivir_carta(List<Carta> b, Carta a){
        this.baraja.add(a);
       // b.remove(a);
        
    }
    
    //<>
    public void ordenar_secuencial(){
        long startTime = System.currentTimeMillis();
        
        Baraja a = new Baraja();
        Baraja b = new Baraja();
        Baraja c = new Baraja();
        Baraja d = new Baraja();
        Baraja joker = new Baraja();
        //52 - cartas
   
        this.baraja.stream()
            .forEach(Carta -> {
                 if(Carta!=null){
                    switch (Carta.getCode()) {

                        case 1:
                            d.recivir_carta(this.baraja,Carta );//esa de corazones
                            break;

                        case 2:
                            a.recivir_carta(this.baraja,Carta );//espadas
                            //System.out.println("mostrar\n"+Carta.getCode());
                            break;
                        case 3:
                            b.recivir_carta(this.baraja,Carta );//treboles
                            break;
                        case 4:
                            c.recivir_carta(this.baraja,Carta );//diamante
                            break;
                        case 5:
                            joker.recivir_carta(this.baraja,Carta );//diamante
                            break;
                        default:
                            System.out.println("No hay orden para este valor");
                    }
                    }
                });
           d.ordenarPorNumero();
           a.ordenarPorNumero();
           b.ordenarPorNumero();
           c.ordenarPorNumero();
           this.baraja = d.baraja;
           //unir this.baraja con a
           // unir b con c
           //luego unir this.baraja con b
           unir_barajas(a,b,c,d);
           
        long endTime = System.currentTimeMillis();  // Marca el tiempo después de ejecutar el método

        // Calcular el tiempo transcurrido
        long duration = endTime - startTime;

        // Mostrar el tiempo de ejecución en consola (en milisegundos)
        System.out.println("El método tardó " + duration + " milisegundos.");
        }
    
     public void ordenar_Paralelo(){
         
        long startTime = System.currentTimeMillis();
        
        Baraja a = new Baraja();
        Baraja b = new Baraja();
        Baraja c = new Baraja();
        Baraja d = new Baraja();
        Baraja joker = new Baraja();
        //52 - cartas
   
        this.baraja.stream()
            .forEach(Carta -> {
                 if(Carta!=null){
                    switch (Carta.getCode()) {

                        case 1:
                            d.recivir_carta(this.baraja,Carta );//esa de corazones
                            break;

                        case 2:
                            a.recivir_carta(this.baraja,Carta );//espadas
                            //System.out.println("mostrar\n"+Carta.getCode());
                            break;
                        case 3:
                            b.recivir_carta(this.baraja,Carta );//treboles
                            break;
                        case 4:
                            c.recivir_carta(this.baraja,Carta );//diamante
                            break;
                        case 5:
                            joker.recivir_carta(this.baraja,Carta );//diamante
                            break;
                        default:
                            System.out.println("No hay orden para este valor");
                    }
                    }
                });
        
                ///BLOQUE PARALELO
           CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> d.ordenarPorNumero());
           CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> a.ordenarPorNumero());
           CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> b.ordenarPorNumero());
           CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> c.ordenarPorNumero());

            // Esperamos que todas las tareas terminen
           CompletableFuture.allOf(future1, future2, future3, future4).join();
           
           
           this.baraja = d.baraja;
           unir_barajas(a,b,c,joker);
           
           
         long endTime = System.currentTimeMillis();  // Marca el tiempo después de ejecutar el método

        // Calcular el tiempo transcurrido
        long duration = endTime - startTime;

        // Mostrar el tiempo de ejecución en consola (en milisegundos)
        System.out.println("El método tardó " + duration + " milisegundos.");
        
        }
     
    public void mostrarStream() {
        System.out.println("Stream out\n");
        baraja.stream()
              .limit(5) // Limitar a los 5 primeros elementos
              .forEach(carta -> System.out.println(carta.getCode())); // Imprimir el 'code' de cada carta
        System.out.println("\nStream fin\n");
    }
    
    private void ordenarPorNumero() {
        this.baraja = this.baraja.stream()
                       .sorted(Comparator.comparingInt(Carta::getNumero))  // Ordenamos por numero
                       .collect(Collectors.toList());  // Recogemos el resultado de vuelta en una nueva lista
    }
    
    public void desordenarBaraja() {
        // Usamos Collections.shuffle() para mezclar aleatoriamente los elementos de la lista
        Collections.shuffle(baraja);
    }
}
