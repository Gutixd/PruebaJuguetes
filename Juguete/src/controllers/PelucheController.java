
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Peluche;
import models.Juguete;


public class PelucheController
{
    public boolean ingresarJuguete(Peluche objFigura)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="insert into peluche (codigo,color,nombre,precio,tipopeluche) values(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            
            
            ps.setInt(1, objFigura.getCodigo());
            ps.setString(2, objFigura.getColor());
            ps.setString(3, objFigura.getNombre());
            ps.setDouble(4, objFigura.getPrecio());
            ps.setString(5, objFigura.getTipoPeluche());
            
            resultado=ps.executeUpdate()==1;
            ps.close();
            
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return resultado;
    }

    public boolean modificarColores(Peluche pel)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="update peluche set Color=?,precio=? where Codigo=?";
            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1, pel.getColor());
            ps.setDouble(2, pel.getPrecio());
            ps.setInt(3, pel.getCodigo());

            resultado=ps.executeUpdate()==1;
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  resultado;
    }

    public boolean eliminarColor(int codigo)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="delete from peluche where codigo="+codigo;
            PreparedStatement ps=con.prepareStatement(query);

          //  ps.setString(1, rut);
            resultado=ps.executeUpdate()==1;
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public ArrayList <Peluche> obtenerTodos()
    {
        ArrayList <Peluche> col=new ArrayList<>();
        try {
            Connection con=Conexion.getConexion();
            String query="Select * from peluche";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Peluche pel;
            while(rs.next())
            {
                //cc=new Juguete(rs.getString(1),rs.getString(2),rs.getInt(3));
                pel = new Peluche();
                pel.setCodigo(rs.getInt(1));
                pel.setNombre(rs.getString(2));
                pel.setTipoPeluche(rs.getString(3));
                pel.setColor(rs.getString(4));
                pel.setPrecio(rs.getDouble(5));
                
                col.add(pel);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return col;
    }

    public Peluche buscarPeluche(int cod)
    {
        Peluche pel=null;
        try {
            Connection con=Conexion.getConexion();
            String query="select * from peluche where codigo="+cod;
            PreparedStatement ps=con.prepareStatement(query);
         //   ps.setString(1, rut);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               // col=new Colores(rs.getString(2),rs.getString(1),rs.getInt(3));
                pel = new Peluche();
                pel.setCodigo(rs.getInt(1));
                pel.setNombre(rs.getString(2));
                pel.setTipoPeluche(rs.getString(3));
                pel.setColor(rs.getString(4));
                pel.setPrecio(rs.getDouble(5));    
            } 
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PelucheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pel;
    }


}
