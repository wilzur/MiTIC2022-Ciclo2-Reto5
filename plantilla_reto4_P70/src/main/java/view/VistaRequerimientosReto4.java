package view;

import controller.ControladorRequerimientosReto4;

import model.vo.Requerimiento1;
import model.vo.Requerimiento2;
import model.vo.Requerimiento3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientosReto4 extends JFrame{
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800,610);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setTitle("MisionTIC 2022 - Ciclo 2");

        JLabel lbltitulo = new JLabel("Programación Básica grupo 70:");
        lbltitulo.setBounds(28, 6, 200, 16);
        contentPane.add(lbltitulo);

        JLabel lblsubtitulo = new JLabel("Reto 5");
        lblsubtitulo.setBounds(28, 22, 200, 16);
        contentPane.add(lblsubtitulo);

        JLabel lblautor = new JLabel("Willian Humberto Sanchez Mora");
        lblautor.setBounds(28, 37, 200, 16);
        contentPane.add(lblautor);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 751, 455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("Requerimiento 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsulta1.setBounds(28, 537, 137, 29);
        contentPane.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("Requerimiento 2");
        btnConsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsulta2.setBounds(170, 537, 137, 29);
        contentPane.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("Requerimiento 3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsulta3.setBounds(312, 537, 137, 29);
        contentPane.add(btnConsulta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);

    }

    public void requerimiento1(){
        try{
            ArrayList<Requerimiento1> rankingAsesorPorCiudad = controlador.consultarRequerimiento_1();
            String salida = "*** Asesor por Ciudad *** \n\nID_Lider\tNombre\tPrimer_Apellido\tResidencia\n\n";
            for (Requerimiento1 asesorPorCiudad : rankingAsesorPorCiudad){
                    salida += asesorPorCiudad.getIdLider();
                    salida += "\t";
                    salida += asesorPorCiudad.getNombre();
                    salida += "\t";
                    salida += asesorPorCiudad.getPrimerApellido();
                    salida += "\t\t";
                    salida += asesorPorCiudad.getCiudadResidencia();
                    salida += "\n";
            }
                textArea.setText(salida);
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento2(){ 
        try{
            ArrayList<Requerimiento2> rankingCompraPorProveedor = controlador.consultarRequerimiento_2();
            String salida = "*** Compras por Proveedor *** \n\nID_Compra\tProveedor\tConstructora\t\tBanco\t\tCiudad\n\n";
            for (Requerimiento2 compraPorProveedor : rankingCompraPorProveedor){
                    salida += compraPorProveedor.getID_Compra();
                    salida += "\t";
                    salida += compraPorProveedor.getProveedor();
                    salida += "\t";
                    salida += compraPorProveedor.getConstructora();
                    if(compraPorProveedor.getConstructora().length() <= 11){
                        salida += "\t\t";
                    } else {
                        salida += "\t";
                    }
                    if(compraPorProveedor.getConstructora().length() <= 11){
                    salida += "\t\t";
                    } else {
                        salida += "\t";
                    }
                    salida += compraPorProveedor.getBanco_Vinculado();
                        if(compraPorProveedor.getBanco_Vinculado().length() <= 15){
                            salida += "\t\t";
                        } else {
                            salida += "\t";    
                    };
                    salida += compraPorProveedor.getCiudad();
                    salida += "\n";
            }
            textArea.setText(salida);
                
        
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento3(){
        try{
            ArrayList<Requerimiento3> rankingProyectosCasaCampestre = controlador.consultarRequerimiento_3();
            String salida = "*** Proyectos Casa Campestre *** \n\nID_Proyecto\tConstructora\t\tHabitaciones\tCiudad\n\n";
            for (Requerimiento3 proyectosCasaCampestre : rankingProyectosCasaCampestre){
                salida += proyectosCasaCampestre.getID_Proyecto();
                salida += "\t";
                salida += proyectosCasaCampestre.getConstructora();
                if(proyectosCasaCampestre.getConstructora().length() <= 11){
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += proyectosCasaCampestre.getNumero_Habitaciones();
                salida += "\t";
                salida += proyectosCasaCampestre.getCiudad();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}