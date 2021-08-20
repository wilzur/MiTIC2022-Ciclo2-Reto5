package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Requerimiento1;

public class Requerimiento_1Dao {
    
    public ArrayList<Requerimiento1> rankingAsesorPorCiudad() throws SQLException {

        ArrayList<Requerimiento1> respuesta = new ArrayList<Requerimiento1>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia "+
                                "FROM Lider "+
                                "WHERE Cargo = 'Asesor'"+
                                "ORDER BY Ciudad_Residencia ASC";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                Requerimiento1 asesorPorCiudad = new Requerimiento1();
                asesorPorCiudad.setIdLider(resultSet.getInt("ID_Lider"));
                asesorPorCiudad.setNombre(resultSet.getString("Nombre"));
                asesorPorCiudad.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                asesorPorCiudad.setCiudadResidencia(resultSet.getString("Ciudad_Residencia"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(asesorPorCiudad);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los Asesores: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
    }  
    
}