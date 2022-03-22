package paquete;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class HammingCodificacion extends javax.swing.JFrame {

    public HammingCodificacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    ArrayList<Integer> codigo = new ArrayList<>();
    ArrayList<String> codigoNPbits = new ArrayList<>();
    ArrayList<Integer> paridadP0 = new ArrayList<>();
    ArrayList<Integer> paridadP1 = new ArrayList<>();
    ArrayList<Integer> paridadP2 = new ArrayList<>();
    ArrayList<Integer> paridadP3 = new ArrayList<>();
    int contadorP0=0;
    int contadorP1=0;
    int contadorP2=0;
    int contadorP3=0;
    
    ArrayList<Integer> mensajeCodificado = new ArrayList<>();
  //  DefaultTableModel modelo;

    public void cargar(ArrayList<Integer> codigo) {
       DefaultTableModel modelo = (DefaultTableModel) tbtTabla.getModel();
        modelo.setColumnCount(0);
        modelo.setNumRows(6);
        
        
        /*
        codigo.add(1);
        codigo.add(0);
        codigo.add(1);
        codigo.add(1);
        codigo.add(0);
        codigo.add(1);
        codigo.add(0);
        */
        
        
        //modelo = (DefaultTableModel) tbtTabla.getModel();
        //Cuando la cantidad de bits son 4
        if (codigo.size() == 4) {
            codigoNPbits.add("P" + 0);
            codigoNPbits.add("P" + 1);
            codigoNPbits.add("" + codigo.get(0));
            codigoNPbits.add("P" + 2);
            codigoNPbits.add("" + codigo.get(1));
            codigoNPbits.add("" + codigo.get(2));
            codigoNPbits.add("" + codigo.get(3));
            for (String codigoNPbit : codigoNPbits) {
                modelo.addColumn(codigoNPbit);
            }
            
            //Para obtener el valor de paridad P0
            tbtTabla.setValueAt(codigo.get(0), 0, 2);
            tbtTabla.setValueAt(codigo.get(1), 0, 4);
            tbtTabla.setValueAt(codigo.get(3), 0, 6);
            
            paridadP0.add(codigo.get(0));
            paridadP0.add(codigo.get(1));
            paridadP0.add(codigo.get(3));
            
            for (Integer integer : paridadP0) {
                if( integer == 1){
                    contadorP0++;
                }
            }
            
            if(contadorP0%2==0){
                tbtTabla.setValueAt(0, 0, 0);
                tbtTabla.setValueAt(0, 5, 0);
                
            }else if(contadorP0%2!=0){
                tbtTabla.setValueAt(1, 0, 0);
                tbtTabla.setValueAt(1, 5, 0);
                
            }
            //Para obtener el valor de paridad P1
            tbtTabla.setValueAt(codigo.get(0), 1, 2);
            tbtTabla.setValueAt(codigo.get(2), 1, 5);
            tbtTabla.setValueAt(codigo.get(3), 1, 6);
            paridadP1.add(codigo.get(0));
            paridadP1.add(codigo.get(2));
            paridadP1.add(codigo.get(3));
            
           for (Integer integer : paridadP1) {
                if( integer == 1){
                    contadorP1++;
                }
            }
            
            if(contadorP1%2==0){
                tbtTabla.setValueAt(0, 1, 1);
                tbtTabla.setValueAt(0, 5, 1);
                
            }else if(contadorP1%2!=0){
                tbtTabla.setValueAt(1, 1, 1);
                tbtTabla.setValueAt(1, 5, 1);
                
            }
            
            
            //Para obtener el valor de paridad P2
            tbtTabla.setValueAt(codigo.get(1), 2, 4);
            tbtTabla.setValueAt(codigo.get(2), 2, 5);
            tbtTabla.setValueAt(codigo.get(3), 2, 6);
            paridadP2.add(codigo.get(1));
            paridadP2.add(codigo.get(2));
            paridadP2.add(codigo.get(3));
            
            for (Integer integer : paridadP2) {
                if( integer == 1){
                    contadorP2++;
                }
            }
            
            if(contadorP2%2==0){
                tbtTabla.setValueAt(0, 2, 3);
                tbtTabla.setValueAt(0, 5, 3);
                
            }else if(contadorP2%2!=0){
                tbtTabla.setValueAt(1, 2, 3);
                tbtTabla.setValueAt(1, 5, 3);
                
            }
            //Mensaje CODIFICADO
        
        
        
            tbtTabla.setValueAt(codigo.get(0), 5, 2);
            tbtTabla.setValueAt(codigo.get(1), 5, 4);
            tbtTabla.setValueAt(codigo.get(2), 5, 5);
            tbtTabla.setValueAt(codigo.get(3), 5, 6);
            Renderer r = new Renderer();
            tbtTabla.setDefaultRenderer(Object.class,r);
        }
        
        
     
        
        
        
        //Cuando al cantidad de bits son 3
        else if (codigo.size() == 3 ) {
            codigoNPbits.add("P" + 0);
            codigoNPbits.add("P" + 1);
            codigoNPbits.add("" + codigo.get(0));
            codigoNPbits.add("P" + 2);
            codigoNPbits.add("" + codigo.get(1));
            codigoNPbits.add("" + codigo.get(2));
            for (String codigoNPbit : codigoNPbits) {
                modelo.addColumn(codigoNPbit);
            }
            //Para obtener el valor de paridad P0
            tbtTabla.setValueAt(codigo.get(0), 0, 2);
            tbtTabla.setValueAt(codigo.get(1), 0, 4);
            tbtTabla.setValueAt(codigo.get(2), 0, 5);
            
            paridadP0.add(codigo.get(0));
            paridadP0.add(codigo.get(1));
            paridadP0.add(codigo.get(2));
            
            for (Integer integer : paridadP0) {
                if( integer == 1){
                    contadorP0++;
                }
            }
            
            if(contadorP0%2==0){
                tbtTabla.setValueAt(0, 0, 0);
                tbtTabla.setValueAt(0, 5, 0);
            }else if(contadorP0%2!=0){
                tbtTabla.setValueAt(1, 0, 0);
                tbtTabla.setValueAt(1, 5, 0);
            }
            //Para obtener el valor de paridad P1
            tbtTabla.setValueAt(codigo.get(0), 1, 2);
            tbtTabla.setValueAt(codigo.get(2), 1, 5);
            paridadP1.add(codigo.get(0));
            paridadP1.add(codigo.get(2));
            
           for (Integer integer : paridadP1) {
                if( integer == 1){
                    contadorP1++;
                }
            }
            
            if(contadorP1%2==0){
                tbtTabla.setValueAt(0, 1, 1);
                tbtTabla.setValueAt(0, 5, 1);
            }else if(contadorP1%2!=0){
                tbtTabla.setValueAt(1, 1, 1);
                tbtTabla.setValueAt(1, 5, 1);
            }
            
            //Para obtener el valor de paridad P2
            tbtTabla.setValueAt(codigo.get(1), 2, 4);
            tbtTabla.setValueAt(codigo.get(2), 2, 5);
            paridadP2.add(codigo.get(1));
            paridadP2.add(codigo.get(2));
            
            for (Integer integer : paridadP2) {
                if( integer == 1){
                    contadorP2++;
                }
            }
            
            if(contadorP2%2==0){
                tbtTabla.setValueAt(0, 2, 3);
                tbtTabla.setValueAt(0, 5, 3);
            }else if(contadorP2%2!=0){
                tbtTabla.setValueAt(1, 2, 3);
                tbtTabla.setValueAt(1, 5, 3);
                
            }
            
            tbtTabla.setValueAt(codigo.get(0), 5, 2);
            tbtTabla.setValueAt(codigo.get(1), 5, 4);
            tbtTabla.setValueAt(codigo.get(2), 5, 5);
            Renderer r = new Renderer();
            tbtTabla.setDefaultRenderer(Object.class,r);
            
            
        }
        
            
            //Cuando la cantidad de bits son 2
        else if (codigo.size() == 2) {
            codigoNPbits.add("P" + 0);
            codigoNPbits.add("P" + 1);
            codigoNPbits.add("" + codigo.get(0));
            codigoNPbits.add("P" + 2);
            codigoNPbits.add("" + codigo.get(1));
            for (String codigoNPbit : codigoNPbits) {
                modelo.addColumn(codigoNPbit);
            }
        //Para obtener el valor de paridad P0
            tbtTabla.setValueAt(codigo.get(0), 0, 2);
            tbtTabla.setValueAt(codigo.get(1), 0, 4);
            
            paridadP0.add(codigo.get(0));
            paridadP0.add(codigo.get(1));
            
            for (Integer integer : paridadP0) {
                if( integer == 1){
                    contadorP0++;
                }
            }
            
            if(contadorP0%2==0){
                tbtTabla.setValueAt(0, 0, 0);
                tbtTabla.setValueAt(0, 5, 0);
            }else if(contadorP0%2!=0){
                tbtTabla.setValueAt(1, 0, 0);
                tbtTabla.setValueAt(1, 5, 0);
            }
            //Para obtener el valor de paridad P1
            tbtTabla.setValueAt(codigo.get(0), 1, 2);
            paridadP1.add(codigo.get(0));
            
           for (Integer integer : paridadP1) {
                if( integer == 1){
                    contadorP1++;
                }
            }
            
            if(contadorP1%2==0){
                tbtTabla.setValueAt(0, 1, 1);
                tbtTabla.setValueAt(0, 5, 1);
            }else if(contadorP1%2!=0){
                tbtTabla.setValueAt(1, 1, 1);
                tbtTabla.setValueAt(1, 5, 1);
            }
            
            //Para obtener el valor de paridad P2
            tbtTabla.setValueAt(codigo.get(1), 2, 4);
            paridadP2.add(codigo.get(1));
            
            
            for (Integer integer : paridadP2) {
                if( integer == 1){
                    contadorP2++;
                }
            }
            
            if(contadorP2%2==0){
                tbtTabla.setValueAt(0, 2, 3);
                tbtTabla.setValueAt(0, 5, 3);
            }else if(contadorP2%2!=0){
                tbtTabla.setValueAt(1, 2, 3);
                tbtTabla.setValueAt(1, 5, 3);
                
            }
            tbtTabla.setValueAt(codigo.get(0), 5, 2);
            tbtTabla.setValueAt(codigo.get(1), 5, 4);
            Renderer r = new Renderer();
            tbtTabla.setDefaultRenderer(Object.class,r);
        
        }
        
        
        //Cuando la cantidad de bits a codificar es 5
        else if (codigo.size() == 5) {
            codigoNPbits.add("P" + 0);
            codigoNPbits.add("P" + 1);
            codigoNPbits.add("" + codigo.get(0));
            codigoNPbits.add("P" + 2);
            codigoNPbits.add("" + codigo.get(1));
            codigoNPbits.add("" + codigo.get(2));
            codigoNPbits.add("" + codigo.get(3));
            codigoNPbits.add("P" + 3);
            codigoNPbits.add("" + codigo.get(4));
            
            
            for (String codigoNPbit : codigoNPbits) {
                modelo.addColumn(codigoNPbit);
            }
           
            //Para obtener el valor de paridad P0
            tbtTabla.setValueAt(codigo.get(0), 0, 2);
            tbtTabla.setValueAt(codigo.get(1), 0, 4);
            tbtTabla.setValueAt(codigo.get(3), 0, 6);
            tbtTabla.setValueAt(codigo.get(4), 0, 8);
            
            
            paridadP0.add(codigo.get(0));
            paridadP0.add(codigo.get(1));
            paridadP0.add(codigo.get(3));
            paridadP0.add(codigo.get(4));
            
            for (Integer integer : paridadP0) {
                if( integer == 1){
                    contadorP0++;
                }
            }
            
            if(contadorP0%2==0){
                tbtTabla.setValueAt(0, 0, 0);
                tbtTabla.setValueAt(0, 5, 0);
                
            }else if(contadorP0%2!=0){
                tbtTabla.setValueAt(1, 0, 0);
                tbtTabla.setValueAt(1, 5, 0);
                
            }
            //Para obtener el valor de paridad P1
            tbtTabla.setValueAt(codigo.get(0), 1, 2);
            tbtTabla.setValueAt(codigo.get(2), 1, 5);
            tbtTabla.setValueAt(codigo.get(3), 1, 6);
            paridadP1.add(codigo.get(0));
            paridadP1.add(codigo.get(2));
            paridadP1.add(codigo.get(3));
            
           for (Integer integer : paridadP1) {
                if( integer == 1){
                    contadorP1++;
                }
            }
            
            if(contadorP1%2==0){
                tbtTabla.setValueAt(0, 1, 1);
                tbtTabla.setValueAt(0, 5, 1);
                
            }else if(contadorP1%2!=0){
                tbtTabla.setValueAt(1, 1, 1);
                tbtTabla.setValueAt(1, 5, 1);
                
            }
            
            
            //Para obtener el valor de paridad P2
            tbtTabla.setValueAt(codigo.get(1), 2, 4);
            tbtTabla.setValueAt(codigo.get(2), 2, 5);
            tbtTabla.setValueAt(codigo.get(3), 2, 6);
            paridadP2.add(codigo.get(1));
            paridadP2.add(codigo.get(2));
            paridadP2.add(codigo.get(3));
            
            for (Integer integer : paridadP2) {
                if( integer == 1){
                    contadorP2++;
                }
            }
            
            if(contadorP2%2==0){
                tbtTabla.setValueAt(0, 2, 3);
                tbtTabla.setValueAt(0, 5, 3);
                
            }else if(contadorP2%2!=0){
                tbtTabla.setValueAt(1, 2, 3);
                tbtTabla.setValueAt(1, 5, 3);
                
            }
            //Para obtener el valor de paridad P3
            tbtTabla.setValueAt(codigo.get(4), 3, 8);
            paridadP3.add(codigo.get(4));
            
            for (Integer integer : paridadP3) {
                if( integer == 1){
                    contadorP3++;
                }
            }
            
            if(contadorP3%2==0){
                tbtTabla.setValueAt(0, 3, 7);
                tbtTabla.setValueAt(0, 5, 7);
                
            }else if(contadorP3%2!=0){
                tbtTabla.setValueAt(1, 3, 7);
                tbtTabla.setValueAt(1, 5, 7);
                
            }
            //Mensaje CODIFICADO
        
        
        
            tbtTabla.setValueAt(codigo.get(0), 5, 2);
            tbtTabla.setValueAt(codigo.get(1), 5, 4);
            tbtTabla.setValueAt(codigo.get(2), 5, 5);
            tbtTabla.setValueAt(codigo.get(3), 5, 6);
            tbtTabla.setValueAt(codigo.get(4), 5, 8);
            
            Renderer r = new Renderer();
            tbtTabla.setDefaultRenderer(Object.class, r);
        
            
            
            
           
        }
        else if (codigo.size() == 6) {
            codigoNPbits.add("P" + 0);
            codigoNPbits.add("P" + 1);
            codigoNPbits.add("" + codigo.get(0));
            codigoNPbits.add("P" + 2);
            codigoNPbits.add("" + codigo.get(1));
            codigoNPbits.add("" + codigo.get(2));
            codigoNPbits.add("" + codigo.get(3));
            codigoNPbits.add("P" + 3);
            codigoNPbits.add("" + codigo.get(4));
            codigoNPbits.add("" + codigo.get(5));
            for (String codigoNPbit : codigoNPbits) {
                modelo.addColumn(codigoNPbit);
            }
            
            //Para obtener el valor de paridad P0
            tbtTabla.setValueAt(codigo.get(0), 0, 2);
            tbtTabla.setValueAt(codigo.get(1), 0, 4);
            tbtTabla.setValueAt(codigo.get(3), 0, 6);
            tbtTabla.setValueAt(codigo.get(4), 0, 8);
            
            
            paridadP0.add(codigo.get(0));
            paridadP0.add(codigo.get(1));
            paridadP0.add(codigo.get(3));
            paridadP0.add(codigo.get(4));
            
            for (Integer integer : paridadP0) {
                if( integer == 1){
                    contadorP0++;
                }
            }
            
            if(contadorP0%2==0){
                tbtTabla.setValueAt(0, 0, 0);
                tbtTabla.setValueAt(0, 5, 0);
                
            }else if(contadorP0%2!=0){
                tbtTabla.setValueAt(1, 0, 0);
                tbtTabla.setValueAt(1, 5, 0);
                
            }
            
            //Para obtener el valor de paridad P1
            tbtTabla.setValueAt(codigo.get(0), 1, 2);
            tbtTabla.setValueAt(codigo.get(2), 1, 5);
            tbtTabla.setValueAt(codigo.get(3), 1, 6);
            tbtTabla.setValueAt(codigo.get(5), 1, 9);
            paridadP1.add(codigo.get(0));
            paridadP1.add(codigo.get(2));
            paridadP1.add(codigo.get(3));
            paridadP1.add(codigo.get(5));
            
            
           for (Integer integer : paridadP1) {
                if( integer == 1){
                    contadorP1++;
                }
            }
            
            if(contadorP1%2==0){
                tbtTabla.setValueAt(0, 1, 1);
                tbtTabla.setValueAt(0, 5, 1);
                
            }else if(contadorP1%2!=0){
                tbtTabla.setValueAt(1, 1, 1);
                tbtTabla.setValueAt(1, 5, 1);
                
            }
            
            
            //Para obtener el valor de paridad P2
            tbtTabla.setValueAt(codigo.get(1), 2, 4);
            tbtTabla.setValueAt(codigo.get(2), 2, 5);
            tbtTabla.setValueAt(codigo.get(3), 2, 6);
            paridadP2.add(codigo.get(1));
            paridadP2.add(codigo.get(2));
            paridadP2.add(codigo.get(3));
            
            for (Integer integer : paridadP2) {
                if( integer == 1){
                    contadorP2++;
                }
            }
            
            if(contadorP2%2==0){
                tbtTabla.setValueAt(0, 2, 3);
                tbtTabla.setValueAt(0, 5, 3);
                
            }else if(contadorP2%2!=0){
                tbtTabla.setValueAt(1, 2, 3);
                tbtTabla.setValueAt(1, 5, 3);
                
            }
            
            
            
            //Para obtener el valor de paridad P3
            tbtTabla.setValueAt(codigo.get(4), 3, 8);
            tbtTabla.setValueAt(codigo.get(5), 3, 9);
            paridadP3.add(codigo.get(4));
            paridadP3.add(codigo.get(5));
            
            
            for (Integer integer : paridadP3) {
                if( integer == 1){
                    contadorP3++;
                }
            }
            
            if(contadorP3%2==0){
                tbtTabla.setValueAt(0, 3, 7);
                tbtTabla.setValueAt(0, 5, 7);
                
            }else if(contadorP3%2!=0){
                tbtTabla.setValueAt(1, 3, 7);
                tbtTabla.setValueAt(1, 5, 7);
                
            }
            
            //Mensaje CODIFICADO
        
        
        
            tbtTabla.setValueAt(codigo.get(0), 5, 2);
            tbtTabla.setValueAt(codigo.get(1), 5, 4);
            tbtTabla.setValueAt(codigo.get(2), 5, 5);
            tbtTabla.setValueAt(codigo.get(3), 5, 6);
            tbtTabla.setValueAt(codigo.get(4), 5, 8);
            tbtTabla.setValueAt(codigo.get(5), 5, 9);
            
            Renderer r = new Renderer();
            tbtTabla.setDefaultRenderer(Object.class, r);
            
            
            
            
        }
        else if (codigo.size() == 7) {
            codigoNPbits.add("P" + 0);
            codigoNPbits.add("P" + 1);
            codigoNPbits.add("" + codigo.get(0));
            codigoNPbits.add("P" + 2);
            codigoNPbits.add("" + codigo.get(1));
            codigoNPbits.add("" + codigo.get(2));
            codigoNPbits.add("" + codigo.get(3));
            codigoNPbits.add("P" + 3);
            codigoNPbits.add("" + codigo.get(4));
            codigoNPbits.add("" + codigo.get(5));
            codigoNPbits.add("" + codigo.get(6));
            for (String codigoNPbit : codigoNPbits) {
                modelo.addColumn(codigoNPbit);
            }
            //Para obtener el valor de paridad P0
            tbtTabla.setValueAt(codigo.get(0), 0, 2);
            tbtTabla.setValueAt(codigo.get(1), 0, 4);
            tbtTabla.setValueAt(codigo.get(3), 0, 6);
            tbtTabla.setValueAt(codigo.get(4), 0, 8);
            tbtTabla.setValueAt(codigo.get(6), 0, 10);
            
            
            paridadP0.add(codigo.get(0));
            paridadP0.add(codigo.get(1));
            paridadP0.add(codigo.get(3));
            paridadP0.add(codigo.get(4));
            paridadP0.add(codigo.get(6));
            
            for (Integer integer : paridadP0) {
                if( integer == 1){
                    contadorP0++;
                }
            }
            
            if(contadorP0%2==0){
                tbtTabla.setValueAt(0, 0, 0);
                tbtTabla.setValueAt(0, 5, 0);
                
            }else if(contadorP0%2!=0){
                tbtTabla.setValueAt(1, 0, 0);
                tbtTabla.setValueAt(1, 5, 0);
                
            }
            
            //Para obtener el valor de paridad P1
            tbtTabla.setValueAt(codigo.get(0), 1, 2);
            tbtTabla.setValueAt(codigo.get(2), 1, 5);
            tbtTabla.setValueAt(codigo.get(3), 1, 6);
            tbtTabla.setValueAt(codigo.get(5), 1, 9);
            tbtTabla.setValueAt(codigo.get(6), 1, 10);
            paridadP1.add(codigo.get(0));
            paridadP1.add(codigo.get(2));
            paridadP1.add(codigo.get(3));
            paridadP1.add(codigo.get(5));
            paridadP1.add(codigo.get(6));
            
            
           for (Integer integer : paridadP1) {
                if( integer == 1){
                    contadorP1++;
                }
            }
            
            if(contadorP1%2==0){
                tbtTabla.setValueAt(0, 1, 1);
                tbtTabla.setValueAt(0, 5, 1);
                
            }else if(contadorP1%2!=0){
                tbtTabla.setValueAt(1, 1, 1);
                tbtTabla.setValueAt(1, 5, 1);
                
            }
            
            
            //Para obtener el valor de paridad P2
            tbtTabla.setValueAt(codigo.get(1), 2, 4);
            tbtTabla.setValueAt(codigo.get(2), 2, 5);
            tbtTabla.setValueAt(codigo.get(3), 2, 6);
            paridadP2.add(codigo.get(1));
            paridadP2.add(codigo.get(2));
            paridadP2.add(codigo.get(3));
            
            for (Integer integer : paridadP2) {
                if( integer == 1){
                    contadorP2++;
                }
            }
            
            if(contadorP2%2==0){
                tbtTabla.setValueAt(0, 2, 3);
                tbtTabla.setValueAt(0, 5, 3);
                
            }else if(contadorP2%2!=0){
                tbtTabla.setValueAt(1, 2, 3);
                tbtTabla.setValueAt(1, 5, 3);
                
            }
            
            
            
            //Para obtener el valor de paridad P3
            tbtTabla.setValueAt(codigo.get(4), 3, 8);
            tbtTabla.setValueAt(codigo.get(5), 3, 9);
            tbtTabla.setValueAt(codigo.get(6), 3, 10);
            paridadP3.add(codigo.get(4));
            paridadP3.add(codigo.get(5));
            paridadP3.add(codigo.get(6));
            
            
            
            for (Integer integer : paridadP3) {
                if( integer == 1){
                    contadorP3++;
                }
            }
            
            if(contadorP3%2==0){
                tbtTabla.setValueAt(0, 3, 7);
                tbtTabla.setValueAt(0, 5, 7);
                
            }else if(contadorP3%2!=0){
                tbtTabla.setValueAt(1, 3, 7);
                tbtTabla.setValueAt(1, 5, 7);
                
            }
            
            //Mensaje CODIFICADO
        
        
        
            tbtTabla.setValueAt(codigo.get(0), 5, 2);
            tbtTabla.setValueAt(codigo.get(1), 5, 4);
            tbtTabla.setValueAt(codigo.get(2), 5, 5);
            tbtTabla.setValueAt(codigo.get(3), 5, 6);
            tbtTabla.setValueAt(codigo.get(4), 5, 8);
            tbtTabla.setValueAt(codigo.get(5), 5, 9);
            tbtTabla.setValueAt(codigo.get(6), 5, 10);
            
            Renderer r = new Renderer();
            tbtTabla.setDefaultRenderer(Object.class, r);
        
            
        }
        
        
            
            
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbtTabla = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt2Bit1 = new javax.swing.JTextField();
        txt2Bit2 = new javax.swing.JTextField();
        txt3Bit1 = new javax.swing.JTextField();
        txt3Bit2 = new javax.swing.JTextField();
        txt3Bit3 = new javax.swing.JTextField();
        txt4Bit1 = new javax.swing.JTextField();
        txt4Bit2 = new javax.swing.JTextField();
        txt4Bit3 = new javax.swing.JTextField();
        txt6Bit4 = new javax.swing.JTextField();
        txt5Bit1 = new javax.swing.JTextField();
        txt5Bit2 = new javax.swing.JTextField();
        txt5Bit3 = new javax.swing.JTextField();
        txt5Bit4 = new javax.swing.JTextField();
        txt5Bit5 = new javax.swing.JTextField();
        txt6Bit1 = new javax.swing.JTextField();
        txt6Bit2 = new javax.swing.JTextField();
        txt6Bit3 = new javax.swing.JTextField();
        txt4Bit4 = new javax.swing.JTextField();
        txt6Bit5 = new javax.swing.JTextField();
        txt6Bit6 = new javax.swing.JTextField();
        txt7Bit1 = new javax.swing.JTextField();
        txt7Bit2 = new javax.swing.JTextField();
        txt7Bit3 = new javax.swing.JTextField();
        txt7Bit4 = new javax.swing.JTextField();
        txt7Bit5 = new javax.swing.JTextField();
        txt7Bit6 = new javax.swing.JTextField();
        txt7Bit7 = new javax.swing.JTextField();
        btnCodificar2Bits = new javax.swing.JButton();
        btnCodificar3Bits = new javax.swing.JButton();
        btnCodificar4Bits = new javax.swing.JButton();
        btnCodificar5Bits = new javax.swing.JButton();
        btnCodificar6Bits = new javax.swing.JButton();
        btnCodificar7Bits = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnLimpiarBits = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbtTabla);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("2 Bits");

        jLabel2.setText("3 Bits");

        jLabel3.setText("4 Bits");

        jLabel4.setText("5 Bits");

        jLabel5.setText("6 Bits");

        jLabel6.setText("7 Bits");

        btnCodificar2Bits.setText("Codificar 2Bits");
        btnCodificar2Bits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodificar2BitsActionPerformed(evt);
            }
        });

        btnCodificar3Bits.setText("Codificar 3Bits");
        btnCodificar3Bits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodificar3BitsActionPerformed(evt);
            }
        });

        btnCodificar4Bits.setText("Codificar 4Bits");
        btnCodificar4Bits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodificar4BitsActionPerformed(evt);
            }
        });

        btnCodificar5Bits.setText("Codificar 5Bits");
        btnCodificar5Bits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodificar5BitsActionPerformed(evt);
            }
        });

        btnCodificar6Bits.setText("Codificar 6Bits");
        btnCodificar6Bits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodificar6BitsActionPerformed(evt);
            }
        });

        btnCodificar7Bits.setText("Codificar 7Bits");
        btnCodificar7Bits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodificar7BitsActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Tabla");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnLimpiarBits.setText("Limpiar Todo");
        btnLimpiarBits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarBitsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt5Bit1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4Bit1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3Bit1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2Bit1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt6Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt7Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt2Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt7Bit2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt5Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt4Bit2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt3Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt6Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt3Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txt4Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt6Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(25, 25, 25)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txt6Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt4Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txt5Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(25, 25, 25)
                                                        .addComponent(txt5Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txt7Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(25, 25, 25)
                                                        .addComponent(txt7Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt5Bit5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt6Bit5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt7Bit5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(btnLimpiar))
                                            .addComponent(btnLimpiarBits, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt6Bit6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt7Bit6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addComponent(txt7Bit7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCodificar2Bits)
                            .addComponent(btnCodificar3Bits)
                            .addComponent(btnCodificar4Bits)
                            .addComponent(btnCodificar5Bits)
                            .addComponent(btnCodificar6Bits)
                            .addComponent(btnCodificar7Bits))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpiarBits)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt2Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodificar2Bits))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt3Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodificar3Bits))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt4Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodificar4Bits))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt5Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5Bit5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodificar5Bits))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt6Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6Bit5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6Bit6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodificar6Bits))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt7Bit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7Bit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7Bit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7Bit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7Bit5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7Bit6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7Bit7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCodificar7Bits))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        VentanaPrincipal ven = new VentanaPrincipal();
        ven.setVisible(true);
        ven.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void btnCodificar2BitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodificar2BitsActionPerformed
        
        codigo.add(Integer.parseInt(txt2Bit1.getText()));
        codigo.add(Integer.parseInt(txt2Bit2.getText()));
        cargar(codigo);
        codigo.clear();
        codigoNPbits.clear();
        paridadP0.clear();
        paridadP1.clear();
        paridadP2.clear();
        paridadP3.clear();
        mensajeCodificado.clear();
        contadorP0=0;
        contadorP1=0;
        contadorP2=0;
        contadorP3=0;
        
        
    }//GEN-LAST:event_btnCodificar2BitsActionPerformed
    public void limpiar(){
        DefaultTableModel modelo = (DefaultTableModel) tbtTabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
 
        TableColumnModel modCol = tbtTabla.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
    }
    private void btnCodificar3BitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodificar3BitsActionPerformed
        
        
        codigo.add(Integer.parseInt(txt3Bit1.getText()));
        codigo.add(Integer.parseInt(txt3Bit2.getText()));
        codigo.add(Integer.parseInt(txt3Bit3.getText()));
        cargar(codigo);
        
        codigo.clear();
        codigoNPbits.clear();
        paridadP0.clear();
        paridadP1.clear();
        paridadP2.clear();
        paridadP3.clear();
        mensajeCodificado.clear();
        contadorP0=0;
        contadorP1=0;
        contadorP2=0;
        contadorP3=0;
    }//GEN-LAST:event_btnCodificar3BitsActionPerformed

    private void btnCodificar4BitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodificar4BitsActionPerformed
        codigo.add(Integer.parseInt(txt4Bit1.getText()));
        codigo.add(Integer.parseInt(txt4Bit2.getText()));
        codigo.add(Integer.parseInt(txt4Bit3.getText()));
        codigo.add(Integer.parseInt(txt4Bit4.getText()));
            
        cargar(codigo);
        codigo.clear();
        codigoNPbits.clear();
        paridadP0.clear();
        paridadP1.clear();
        paridadP2.clear();
        paridadP3.clear();
        mensajeCodificado.clear();
        contadorP0=0;
        contadorP1=0;
        contadorP2=0;
        contadorP3=0;
    }//GEN-LAST:event_btnCodificar4BitsActionPerformed

    private void btnCodificar5BitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodificar5BitsActionPerformed
        codigo.add(Integer.parseInt(txt5Bit1.getText()));
        codigo.add(Integer.parseInt(txt5Bit2.getText()));
        codigo.add(Integer.parseInt(txt5Bit3.getText()));
        codigo.add(Integer.parseInt(txt5Bit4.getText()));
        codigo.add(Integer.parseInt(txt5Bit5.getText()));
       
        cargar(codigo);
        codigo.clear();
        codigoNPbits.clear();
        paridadP0.clear();
        paridadP1.clear();
        paridadP2.clear();
        paridadP3.clear();
        mensajeCodificado.clear();
        contadorP0=0;
        contadorP1=0;
        contadorP2=0;
        contadorP3=0;
    }//GEN-LAST:event_btnCodificar5BitsActionPerformed

    private void btnCodificar6BitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodificar6BitsActionPerformed
        codigo.add(Integer.parseInt(txt6Bit1.getText()));
        codigo.add(Integer.parseInt(txt6Bit2.getText()));
        codigo.add(Integer.parseInt(txt6Bit3.getText()));
        codigo.add(Integer.parseInt(txt6Bit4.getText()));
        codigo.add(Integer.parseInt(txt6Bit5.getText()));
        codigo.add(Integer.parseInt(txt6Bit6.getText()));
      
        cargar(codigo);
        codigo.clear();
        codigoNPbits.clear();
        paridadP0.clear();
        paridadP1.clear();
        paridadP2.clear();
        paridadP3.clear();
        mensajeCodificado.clear();
        contadorP0=0;
        contadorP1=0;
        contadorP2=0;
        contadorP3=0;
    }//GEN-LAST:event_btnCodificar6BitsActionPerformed

    private void btnCodificar7BitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodificar7BitsActionPerformed
        codigo.add(Integer.parseInt(txt7Bit1.getText()));
        codigo.add(Integer.parseInt(txt7Bit2.getText()));
        codigo.add(Integer.parseInt(txt7Bit3.getText()));
        codigo.add(Integer.parseInt(txt7Bit4.getText()));
        codigo.add(Integer.parseInt(txt7Bit5.getText()));
        codigo.add(Integer.parseInt(txt7Bit6.getText()));
        codigo.add(Integer.parseInt(txt7Bit7.getText()));
       
        cargar(codigo);
        codigo.clear();
        codigoNPbits.clear();
        paridadP0.clear();
        paridadP1.clear();
        paridadP2.clear();
        paridadP3.clear();
        mensajeCodificado.clear();
        contadorP0=0;
        contadorP1=0;
        contadorP2=0;
        contadorP3=0;
    }//GEN-LAST:event_btnCodificar7BitsActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnLimpiarBitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarBitsActionPerformed
        txt2Bit1.setText(null);
        txt2Bit2.setText(null);
        txt3Bit1.setText(null);
        txt3Bit2.setText(null);
        txt3Bit3.setText(null);
        txt4Bit1.setText(null);
        txt4Bit2.setText(null);
        txt4Bit3.setText(null);
        txt4Bit4.setText(null);
        txt5Bit1.setText(null);
        txt5Bit2.setText(null);
        txt5Bit3.setText(null);
        txt5Bit4.setText(null);
        txt5Bit5.setText(null);
        txt6Bit1.setText(null);
        txt6Bit2.setText(null);
        txt6Bit3.setText(null);
        txt6Bit4.setText(null);
        txt6Bit5.setText(null);
        txt6Bit6.setText(null);
        txt7Bit1.setText(null);
        txt7Bit2.setText(null);
        txt7Bit3.setText(null);
        txt7Bit4.setText(null);
        txt7Bit5.setText(null);
        txt7Bit6.setText(null);
        txt7Bit7.setText(null);
        
    }//GEN-LAST:event_btnLimpiarBitsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HammingCodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HammingCodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HammingCodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HammingCodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HammingCodificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCodificar2Bits;
    private javax.swing.JButton btnCodificar3Bits;
    private javax.swing.JButton btnCodificar4Bits;
    private javax.swing.JButton btnCodificar5Bits;
    private javax.swing.JButton btnCodificar6Bits;
    private javax.swing.JButton btnCodificar7Bits;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarBits;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtTabla;
    private javax.swing.JTextField txt2Bit1;
    private javax.swing.JTextField txt2Bit2;
    private javax.swing.JTextField txt3Bit1;
    private javax.swing.JTextField txt3Bit2;
    private javax.swing.JTextField txt3Bit3;
    private javax.swing.JTextField txt4Bit1;
    private javax.swing.JTextField txt4Bit2;
    private javax.swing.JTextField txt4Bit3;
    private javax.swing.JTextField txt4Bit4;
    private javax.swing.JTextField txt5Bit1;
    private javax.swing.JTextField txt5Bit2;
    private javax.swing.JTextField txt5Bit3;
    private javax.swing.JTextField txt5Bit4;
    private javax.swing.JTextField txt5Bit5;
    private javax.swing.JTextField txt6Bit1;
    private javax.swing.JTextField txt6Bit2;
    private javax.swing.JTextField txt6Bit3;
    private javax.swing.JTextField txt6Bit4;
    private javax.swing.JTextField txt6Bit5;
    private javax.swing.JTextField txt6Bit6;
    private javax.swing.JTextField txt7Bit1;
    private javax.swing.JTextField txt7Bit2;
    private javax.swing.JTextField txt7Bit3;
    private javax.swing.JTextField txt7Bit4;
    private javax.swing.JTextField txt7Bit5;
    private javax.swing.JTextField txt7Bit6;
    private javax.swing.JTextField txt7Bit7;
    // End of variables declaration//GEN-END:variables
}
