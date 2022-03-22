/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Nahuel
 */
public class HammingDecodificacion extends javax.swing.JFrame {

    /**
     * Creates new form Hamming
     */
    public HammingDecodificacion() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Decodificacion Hamming V1.0 - By Nahuel Martinez");

        int a = (int) Math.pow(2, 3); //Para las potencias
        

    }
    public void limpiar(){
        DefaultTableModel modelo = (DefaultTableModel) tbtTabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
 
        TableColumnModel modCol = tbtTabla.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
        
        txtBitOriginal1.setText(null);
        txtBitOriginal2.setText(null);
        txtBitOriginal3.setText(null);
        txtBitOriginal4.setText(null);
        txtBitOriginal5.setText(null);
        txtBitOriginal6.setText(null);
        txtBitOriginal7.setText(null);
        txtBitParidad1.setText(null);
        txtBitParidad2.setText(null);
        txtBitParidad3.setText(null);
        txtBitParidad4.setText(null);
    }
    ArrayList<Integer> codigo = new ArrayList<>();
    ArrayList<Integer> codParidadP1 = new ArrayList<>();
    ArrayList<Integer> codParidadP2 = new ArrayList<>();
    ArrayList<Integer> codParidadP3 = new ArrayList<>();
    ArrayList<Integer> codParidadP4 = new ArrayList<>();
    ArrayList<Integer> codResultado = new ArrayList<>();

    public void cargarCodigo(ArrayList<Integer> codigo){
        DefaultTableModel model = (DefaultTableModel) tbtTabla.getModel();
        model.setColumnCount(0);
        model.setNumRows(6);
       /*
        codigo.add(Integer.parseInt(txtBit1.getText())); //Posicion 1
        codigo.add(Integer.parseInt(txtBit2.getText())); //Posicion 2
        codigo.add(Integer.parseInt(txtBit3.getText())); //Posicion 3
        codigo.add(Integer.parseInt(txtBit4.getText())); //Posicion 4
        codigo.add(Integer.parseInt(txtBit5.getText())); //Posicion 5
        codigo.add(Integer.parseInt(txtBit6.getText())); //Posicion 6
        codigo.add(Integer.parseInt(txtBit7.getText())); //Posicion 7
        codigo.add(Integer.parseInt(txtBit8.getText())); //Posicion 8
        codigo.add(Integer.parseInt(txtBit9.getText())); //Posicion 9
        codigo.add(Integer.parseInt(txtBit10.getText())); //Posicion 10
        codigo.add(Integer.parseInt(txtBit11.getText())); //Posicion 11
        */
        txtBit1.setText(String.valueOf(codigo.get(0)));
        txtBit2.setText(String.valueOf(codigo.get(1)));
        txtBit3.setText(String.valueOf(codigo.get(2)));
        txtBit4.setText(String.valueOf(codigo.get(3)));
        txtBit5.setText(String.valueOf(codigo.get(4)));
        txtBit6.setText(String.valueOf(codigo.get(5)));
        txtBit7.setText(String.valueOf(codigo.get(6)));
        txtBit8.setText(String.valueOf(codigo.get(7)));
        txtBit9.setText(String.valueOf(codigo.get(8)));
        txtBit10.setText(String.valueOf(codigo.get(9)));
        txtBit11.setText(String.valueOf(codigo.get(10)));
        
        
        
        if (model.getColumnCount() == 0) {
            for (int i = 0; i < codigo.size(); i++) {

                model.addColumn(codigo.get(i));

            }
            
            
        }
        decodificar();
    }
    public void decodificar() {

        int contadorP1 = 0;
        int contadorP2 = 0;
        int contadorP3 = 0;
        int contadorP4 = 0;

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

        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(0)), 0, 0);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(1)), 0, 2);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(2)), 0, 4);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(3)), 0, 6);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(4)), 0, 8);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(5)), 0, 10);

        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(0)), 1, 1);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(1)), 1, 2);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(2)), 1, 5);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(3)), 1, 6);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(4)), 1, 9);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(5)), 1, 10);

        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(0)), 2, 3);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(1)), 2, 4);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(2)), 2, 5);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(3)), 2, 6);

        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(0)), 3, 7);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(1)), 3, 8);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(2)), 3, 9);
        tbtTabla.setValueAt(String.valueOf(codParidadP1.get(3)), 3, 10);

        for (Integer integer : codParidadP1) {
            if (integer.equals(1)) {
                contadorP1++;
            }
        }
        for (Integer integer : codParidadP2) {
            if (integer.equals(1)) {
                contadorP2++;
            }
        }
        for (Integer integer : codParidadP3) {
            if (integer.equals(1)) {
                contadorP3++;
            }
        }
        for (Integer integer : codParidadP4) {
            if (integer.equals(1)) {
                contadorP4++;
            }

        }
        if (contadorP4 % 2 == 0) {
            codResultado.add(0);
        } else if (contadorP4 % 2 != 0) {
            codResultado.add(1);
        }
        if (contadorP3 % 2 == 0) {
            codResultado.add(0);
        } else if (contadorP3 % 2 != 0) {
            codResultado.add(1);
        }
        if (contadorP2 % 2 == 0) {
            codResultado.add(0);
        } else if (contadorP2 % 2 != 0) {
            codResultado.add(1);
        }
        if (contadorP1 % 2 == 0) {
            codResultado.add(0);

        } else if (contadorP1 % 2 != 0) {
            codResultado.add(1);
        }

        txtBitParidad1.setText(String.valueOf(codResultado.get(3)));
        txtBitParidad2.setText(String.valueOf(codResultado.get(2)));
        txtBitParidad3.setText(String.valueOf(codResultado.get(1)));
        txtBitParidad4.setText(String.valueOf(codResultado.get(0)));
        
        if(codResultado.get(0) == 0 && codResultado.get(1) == 0 && codResultado.get(2) == 0 && codResultado.get(3) == 0){
            txtBitOriginal1.setText(String.valueOf(codigo.get(2)));
            txtBitOriginal2.setText(String.valueOf(codigo.get(4)));
            txtBitOriginal3.setText(String.valueOf(codigo.get(5)));
            txtBitOriginal4.setText(String.valueOf(codigo.get(6)));
            txtBitOriginal5.setText(String.valueOf(codigo.get(8)));
            txtBitOriginal6.setText(String.valueOf(codigo.get(9)));
            txtBitOriginal7.setText(String.valueOf(codigo.get(10)));
        }
    }

    /*public void limpiarArrays() {
        for (int i = 0; i < codigo.size(); i++) {
            codigo.remove(i);
        }
        for (int i = 0; i < codParidadP1.size(); i++) {
            codParidadP1.remove(i);
        }
        for (int i = 0; i < codParidadP2.size(); i++) {
            codParidadP2.remove(i);
        }
        for (int i = 0; i < codParidadP3.size(); i++) {
            codParidadP3.remove(i);
        }
        for (int i = 0; i < codParidadP4.size(); i++) {
            codParidadP4.remove(i);
        }
        for (int i = 0; i < codResultado.size(); i++) {
            codResultado.remove(i);
        }
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbtTabla = new javax.swing.JTable();
        txtBitParidad4 = new javax.swing.JTextField();
        txtBitParidad3 = new javax.swing.JTextField();
        txtBitParidad2 = new javax.swing.JTextField();
        txtBitParidad1 = new javax.swing.JTextField();
        txtBit1 = new javax.swing.JTextField();
        txtBit2 = new javax.swing.JTextField();
        txtBit3 = new javax.swing.JTextField();
        txtBit4 = new javax.swing.JTextField();
        txtBit5 = new javax.swing.JTextField();
        txtBit6 = new javax.swing.JTextField();
        txtBit7 = new javax.swing.JTextField();
        txtBit8 = new javax.swing.JTextField();
        txtBit9 = new javax.swing.JTextField();
        txtBit10 = new javax.swing.JTextField();
        txtBit11 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtBitOriginal1 = new javax.swing.JTextField();
        txtBitOriginal2 = new javax.swing.JTextField();
        txtBitOriginal3 = new javax.swing.JTextField();
        txtBitOriginal4 = new javax.swing.JTextField();
        txtBitOriginal5 = new javax.swing.JTextField();
        txtBitOriginal6 = new javax.swing.JTextField();
        txtBitOriginal7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnDecodificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tbtTabla);

        txtBit9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBit9ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Mensaje Codificado");

        jLabel2.setText("Pos.1");

        jLabel3.setText("Pos.2");

        jLabel4.setText("Pos.3");

        jLabel5.setText("Pos.4");

        jLabel6.setText("Pos.5");

        jLabel7.setText("Pos.6");

        jLabel8.setText("Pos.7");

        jLabel9.setText("Pos.8");

        jLabel10.setText("Pos.9");

        jLabel11.setText("Pos.10");

        jLabel12.setText("Pos.11");

        jLabel13.setText("8");

        jLabel14.setText("4");

        jLabel15.setText("2");

        jLabel16.setText("1");

        txtBitOriginal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBitOriginal1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Mensaje Original:");

        btnDecodificar.setText("Decodificar");
        btnDecodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecodificarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtBit1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(45, 45, 45)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtBit9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBit10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtBit11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnVolver)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(40, 40, 40)
                                    .addComponent(txtBitOriginal1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtBitOriginal2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtBitOriginal3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(txtBitOriginal4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(txtBitOriginal5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(txtBitOriginal6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtBitOriginal7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtBitParidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtBitParidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtBitParidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtBitParidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnDecodificar)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(btnLimpiar))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBit11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(btnDecodificar)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBitParidad4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBitParidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBitParidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBitParidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBitOriginal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBitOriginal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBitOriginal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBitOriginal4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBitOriginal5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBitOriginal6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBitOriginal7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBit9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBit9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBit9ActionPerformed

    private void txtBitOriginal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBitOriginal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBitOriginal1ActionPerformed

    private void btnDecodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecodificarActionPerformed
        
        codigo.add(Integer.parseInt(txtBit1.getText()));
        codigo.add(Integer.parseInt(txtBit2.getText()));
        codigo.add(Integer.parseInt(txtBit3.getText()));
        codigo.add(Integer.parseInt(txtBit4.getText()));
        codigo.add(Integer.parseInt(txtBit5.getText()));
        codigo.add(Integer.parseInt(txtBit6.getText()));
        codigo.add(Integer.parseInt(txtBit7.getText()));
        codigo.add(Integer.parseInt(txtBit8.getText()));
        codigo.add(Integer.parseInt(txtBit9.getText()));
        codigo.add(Integer.parseInt(txtBit10.getText()));
        codigo.add(Integer.parseInt(txtBit11.getText()));
        cargarCodigo(codigo);
        codigo.clear();
        codParidadP1.clear();
        codParidadP2.clear();
        codParidadP3.clear();
        codParidadP4.clear();
        codResultado.clear();
        
    }//GEN-LAST:event_btnDecodificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(HammingDecodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HammingDecodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HammingDecodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HammingDecodificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HammingDecodificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecodificar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtTabla;
    private javax.swing.JTextField txtBit1;
    private javax.swing.JTextField txtBit10;
    private javax.swing.JTextField txtBit11;
    private javax.swing.JTextField txtBit2;
    private javax.swing.JTextField txtBit3;
    private javax.swing.JTextField txtBit4;
    private javax.swing.JTextField txtBit5;
    private javax.swing.JTextField txtBit6;
    private javax.swing.JTextField txtBit7;
    private javax.swing.JTextField txtBit8;
    private javax.swing.JTextField txtBit9;
    private javax.swing.JTextField txtBitOriginal1;
    private javax.swing.JTextField txtBitOriginal2;
    private javax.swing.JTextField txtBitOriginal3;
    private javax.swing.JTextField txtBitOriginal4;
    private javax.swing.JTextField txtBitOriginal5;
    private javax.swing.JTextField txtBitOriginal6;
    private javax.swing.JTextField txtBitOriginal7;
    private javax.swing.JTextField txtBitParidad1;
    private javax.swing.JTextField txtBitParidad2;
    private javax.swing.JTextField txtBitParidad3;
    private javax.swing.JTextField txtBitParidad4;
    // End of variables declaration//GEN-END:variables
}
