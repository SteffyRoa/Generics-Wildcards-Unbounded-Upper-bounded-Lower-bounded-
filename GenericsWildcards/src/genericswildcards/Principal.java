/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericswildcards;

import java.util.*;
import java.util.List;

/**
 *
 * @author sroa
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List <String> listaString = new ArrayList<>();
        listaString.add("Hello");
        listaString.add("World");
         imprmirObjetos(listaString); 
         //invocamos metodo IMPRIMIR FIGURAS
        // imprimirFiguras(listaString);NO SE PUEDE
//         insertarFiguras(listaString);NO SE PUEDE
         
         /**
          * NO NOS DEJARA IMPRIMIR LA LISTA CON OBJECT OCUPAMOS EL WILDCARD <?>
          */
      List<Circulo>listaCirculo = new ArrayList<>();
        listaCirculo.add(new Circulo(4.0));
        listaCirculo.add(new Circulo(2.0));
       imprmirObjetos(listaCirculo);
         //invocamos metodo IMPRIMIR FIGURAS
         imprimirFiguras(listaCirculo);
         //INVOCAMOS INSERTAR 
       //   insertarFiguras(listaCirculo); no me deja porque no tiene o es padre de figura
        
        List<Cuadrado>listaCuadrado = new ArrayList<>();
        listaCuadrado.add(new Cuadrado(4.0));
        listaCuadrado.add(new Cuadrado(2.0));
         imprmirObjetos(listaCuadrado);
        List<Triangulo>listaTriangulo = new ArrayList<>();
         listaTriangulo.add(new Triangulo(4.0));
         listaTriangulo.add(new Triangulo(4.0));
      imprmirObjetos(listaTriangulo);    
      
        //invocamos metodo IMPRIMIR FIGURAS
         imprimirFiguras(listaTriangulo);
        List<Figura>listaFigura = new ArrayList<>();
        listaFigura.add(new Circulo(4.0));
        listaFigura.add(new Cuadrado(4.0));
        listaFigura.add(new Triangulo(4.0));
   imprmirObjetos(listaFigura);      
     //invocamos metodo IMPRIMIR FIGURAS
         imprimirFiguras(listaFigura);
         //INVOCAMOS INSERTAR FIGURA
          insertarFiguras(listaFigura);
      
    }
    /******UNBONDED WILCARD**********/
    //metodo impimir objetos va a recibir una lista
    //NO IMPRIMIRA PORQUE EN EL CASO DE LOS GENERICS NO FUNCIONA CON object
    //static void imprmirObjetos(List<Object> lista)
    //TENDREMOS QUE USAR UN WILDCARD ?
    static void imprmirObjetos(List<?> lista){
        //listaCirculo.add(new Circulo(4.0));  no se puede agregar elementos que ya recibimos
        for(Object o: lista){
            System.out.println("ImprimirObjeto"+o);
        }
        
    }
    /****   UPPER UNBOUNDED WILDCARD      ***/
    /*
    Puedes pasar cualquier lista que tenga como lista figuras o cualquier clase herede de figura
    */
    static void imprimirFiguras(List<? extends Figura>lista){
        //listaCirculo.add(new Circulo(4.0));  no se puede agregar elementos que ya recibimos
        for(Figura fig:lista){
            System.out.println("Imprimir Figura"+fig);
        }
        //impimir lista de cualquiera
        
        
    }
    
    /***  UNBOUNDEND     LOWER WILDCAR 
     //te paso una lista de figura o cualquiera que tenga superclases de figura
     osea PAPA DE FIGURA***/
    static void insertarFiguras(List<? super Figura>lista){
        lista.add(new Circulo(6.0)); //SI SE PUEDE AGREGAR
        lista.add(new Circulo(7.0));
        lista.add(new Circulo(8.4));
        for(Object o:lista){
            System.out.println("ImprimirInsertarFigura"+o);
        }
        
    }
}
    
 class Figura {
    private double area;
    
    
 public Figura(double area){
        this.area=area;
    }
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Figura{" + "area=" + area + '}';
    }
    
    
}
    //**************CIRCULO*****************//
     class Circulo extends Figura {
    
    public Circulo(double area) {
        super(area);
    }
    
}
    
       //**************Cuadrado*****************//
    class Cuadrado extends Figura{
    
    public Cuadrado(double area) {
        super(area);
    }
    
}
    
       //**************triangulo*****************//
    class Triangulo extends Figura{
    
    public Triangulo(double area) {
        super(area);
    }
    
}


