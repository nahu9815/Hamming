/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.util.ArrayList;

/**
 *
 * @author Nahuel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> codigo = new ArrayList<>();
        ArrayList<Integer> codParidadP1 = new ArrayList<>();
        ArrayList<Integer> codParidadP2 = new ArrayList<>();
        ArrayList<Integer> codParidadP3 = new ArrayList<>();
        ArrayList<Integer> codParidadP4 = new ArrayList<>();
        ArrayList<Integer> codResultado = new ArrayList<>();
        
        
        int contadorP1 = 0;
        int contadorP2 = 0;
        int contadorP3 = 0;
        int contadorP4 = 0;
        
        codigo.add(1);
        codigo.add(0);
        codigo.add(0);
        codigo.add(0);
        codigo.add(1);
        codigo.add(1);
        codigo.add(0);
        codigo.add(0);
        codigo.add(1);
        codigo.add(0);
        codigo.add(1);
        
        
        codParidadP1.add(codigo.get(0));
        codParidadP1.add(codigo.get(2));
        codParidadP1.add(codigo.get(4));
        codParidadP1.add(codigo.get(6));
        codParidadP1.add(codigo.get(8));
        codParidadP1.add(codigo.get(10));
        
        codParidadP2.add(codigo.get(1));
        codParidadP2.add(codigo.get(2));
        codParidadP2.add(codigo.get(5));
        codParidadP2.add(codigo.get(6));
        codParidadP2.add(codigo.get(9));
        codParidadP2.add(codigo.get(10));
        
        
        codParidadP3.add(codigo.get(3));
        codParidadP3.add(codigo.get(4));
        codParidadP3.add(codigo.get(5));
        codParidadP3.add(codigo.get(6));
        
        codParidadP4.add(codigo.get(7));
        codParidadP4.add(codigo.get(8));
        codParidadP4.add(codigo.get(9));
        codParidadP4.add(codigo.get(10));
        
        
        
        for (Integer integer : codigo) {
            System.out.print(integer+"   ");
            
        }
        System.out.println("");
        System.out.println("");
        for (Integer integer : codParidadP1) {
            System.out.print(integer+"       ");
        }
        
        System.out.println("");
        System.out.println("");
        System.out.print("    ");
        System.out.print(codParidadP2.get(0));
        System.out.print("   ");
        System.out.print(codParidadP2.get(1));
        System.out.print("           ");
        System.out.print(codParidadP2.get(2));
        System.out.print("   ");
        System.out.print(codParidadP2.get(3));
        System.out.print("           ");
        System.out.print(codParidadP2.get(4));
        System.out.print("   ");
        System.out.print(codParidadP2.get(5));
        System.out.println("");
        System.out.println("");
        System.out.print("            ");
        /*for (Integer integer : codParidadP3) {
            System.out.print("   "+integer+"");
        }*/
        
        System.out.print(codParidadP3.get(0));
        System.out.print("   ");
        System.out.print(codParidadP3.get(1));
        System.out.print("   ");
        System.out.print(codParidadP3.get(2));
        System.out.print("   ");
        System.out.print(codParidadP3.get(3));
        System.out.print("                   ");
        System.out.println("");
        System.out.println("");
        System.out.print("                         ");
        for (Integer integer : codParidadP4) {
            System.out.print("   "+integer);
            
        }
        System.out.println("");
        
        
        for (Integer integer : codParidadP1) {
            if(integer.equals(1)){
                contadorP1++;
            }
        }
        for (Integer integer : codParidadP2) {
            if(integer.equals(1)){
                contadorP2++;
            }
        }
        for (Integer integer : codParidadP3) {
            if(integer.equals(1)){
                contadorP3++;
            }
        }
        for (Integer integer : codParidadP4) {
            if(integer.equals(1)){
                contadorP4++;
            }
            
        }
        if(contadorP4%2==0){
            codResultado.add(0);
        }
        else if(contadorP4%2!=0){
            codResultado.add(1);
        }
        if(contadorP3%2==0){
            codResultado.add(0);
        }
        else if(contadorP3%2!=0){
            codResultado.add(1);
        }
        if(contadorP2%2==0){
            codResultado.add(0);
        }
        else if(contadorP2%2!=0){
            codResultado.add(1);
        }
        if(contadorP1%2==0){
            codResultado.add(0);
            
        }
        else if(contadorP1%2!=0){
            codResultado.add(1);
        }
        
        System.out.println("");
        System.out.println("");
        System.out.print("Bits de Paridad ---> ");
        for (Integer integer : codResultado) {
            System.out.print("   "+integer);
        }
        System.out.println("\n\n");
        
        
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Hamming V1.0 - By Nahuel Martinez");
    }
    
}
