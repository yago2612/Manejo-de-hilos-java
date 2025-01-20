/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;

/**
 *
 * @author PC
 */
public class Carta {
    public int numero;
    public int code;
    public String Simbolo;
    //simbolos del 1 al 4 donde 
    // 1 - corazon
    // 2 - espadas
    // 4 - trebol
    // 5 - diamante

    public Carta(int numero, String Simbolo) {
        this.numero = numero;
        this.Simbolo = Simbolo;
    }
    public Carta() {
        
    }
    
    
    public Carta(int numero, int code) {
      
        this.numero = numero;
        this.code = code;
        switch(code){
        case 1: this.Simbolo = "Corazon";break;
        
        case 2: this.Simbolo = "Espadas";break;
        
        case 3: this.Simbolo = "Trebol";break;
        
        case 4: this.Simbolo = "Diamantes";break;
        
        case 5: this.Simbolo = "JOKER";break;
        }
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setSimbolo(String Simbolo) {
        this.Simbolo = Simbolo;
    }

    
    public int getNumero() {
        return numero;
    }

    public int getCode() {
        return code;
    }

    public String getSimbolo() {
        return Simbolo;
    }

    
    public void mostrar(Carta a){
        String b = "Carta \n"+"Simbolo: "+this.Simbolo+"\nNumero:"+this.numero+"\n";
        System.out.println(b);
    }
    
     public String mostrar(){
        String b = "Carta \n"+"Simbolo: "+this.Simbolo+"\nNumero:"+this.numero+"\n";
        return b;
    }
}
