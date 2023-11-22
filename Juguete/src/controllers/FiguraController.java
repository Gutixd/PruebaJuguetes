
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.FiguraAccion;
import models.Juguete;


public class FiguraController
{
    public boolean ingresarJuguete(FiguraAccion objFigura)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="insert into tbColores (codigo,color,cantidad) values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            
            
           // ps.setString(1, col.getCodigo());
            //ps.setString(2, col.getColor());
            //ps.setInt(3, col.getCantidad());
            
            resultado=ps.executeUpdate()==1;
            ps.close();
            
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return resultado;
    }

    public boolean modificarColores(Juguete jug)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="update tbColores set Color=?,Cantidad=? where Codigo=?";
            PreparedStatement ps=con.prepareStatement(query);

            //ps.setString(1, col.getColor());
            //ps.setDouble(2, col.getCantidad());
            //ps.setString(3, col.getCodigo());

            resultado=ps.executeUpdate()==1;
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  resultado;
    }

    public boolean eliminarColor(String codigo)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="delete from tbColores where codigo='"+codigo+"'";
            PreparedStatement ps=con.prepareStatement(query);

          //  ps.setString(1, rut);
            resultado=ps.executeUpdate()==1;
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public ArrayList <Juguete> obtenerTodos()
    {
        ArrayList <Juguete> col=new ArrayList<>();
        try {
            Connection con=Conexion.getConexion();
            String query="Select * from tbColores";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Juguete cc;
            while(rs.next())
            {
                //cc=new Juguete(rs.getString(1),rs.getString(2),rs.getInt(3));
                //col.add(cc);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return col;
    }

    public Juguete buscarColor(String cod)
    {
        Juguete col=null;
        try {
            Connection con=Conexion.getConexion();
            String query="select * from tbColores where codigo='"+cod+"'";
            PreparedStatement ps=con.prepareStatement(query);
         //   ps.setString(1, rut);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
               // col=new Colores(rs.getString(2),rs.getString(1),rs.getInt(3));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FiguraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return col;
    }


}
