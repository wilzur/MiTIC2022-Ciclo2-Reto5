package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.Requerimiento_1Dao;
import model.dao.Requerimiento_2Dao;
import model.dao.Requerimiento_3Dao;
import model.vo.Requerimiento1;
import model.vo.Requerimiento2;
import model.vo.Requerimiento3;


//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {   

    private final Requerimiento_1Dao Requerimiento1Dao;
    private final Requerimiento_2Dao Requerimiento2Dao;
    private final Requerimiento_3Dao Requerimiento3Dao;
    
    public ControladorRequerimientosReto4(){
        this.Requerimiento1Dao = new Requerimiento_1Dao();
        this.Requerimiento2Dao = new Requerimiento_2Dao();
        this.Requerimiento3Dao = new Requerimiento_3Dao();

    }

    public ArrayList<Requerimiento1> consultarRequerimiento_1() throws SQLException {
        return this.Requerimiento1Dao.rankingAsesorPorCiudad();
    }
    
    public ArrayList<Requerimiento2> consultarRequerimiento_2() throws SQLException {
        return this.Requerimiento2Dao.rankingCompraPorProveedor();
    }

    public ArrayList<Requerimiento3> consultarRequerimiento_3() throws SQLException {
        return this.Requerimiento3Dao.rankingProyectosCasaCampestres();
    }

}