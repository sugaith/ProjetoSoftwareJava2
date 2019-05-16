/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author admin
 */
public class DaoDesenho extends Conexao{


    public DaoDesenho(Connection c) {
        this.conexao = c;
    }


//    public List<Pagos> consulta(Date dataIni){
//        List<Pagos> lista = new ArrayList<Pagos>();
//        Pagos s;
//
//        String sql = "SELECT proveedores.cod_proveedor, proveedores.nombre_proveedor, Sum(pagos_doc.valor_pagado) AS saldo, pagos.cod_moneda, pagos.* "+
//            "FROM (((proveedores INNER JOIN pagos ON proveedores.cod_proveedor = pagos.cod_proveedor) INNER JOIN pagos_doc ON pagos.nro_pago = pagos_doc.nro_pago) "
//            + "INNER JOIN ctas_pagar ON (proveedores.cod_proveedor = ctas_pagar.cod_proveedor) AND (pagos_doc.nro_documento = ctas_pagar.num_doc)) "
//            + "INNER JOIN tipo_documentos ON (proveedores.tipo_documen = tipo_documentos.tipo_documen) AND (ctas_pagar.tipo_documen = tipo_documentos.tipo_documen) "+
//            "GROUP BY proveedores.cod_proveedor, proveedores.nombre_proveedor, pagos.cod_moneda, pagos.fecha_pago, ctas_pagar.tipo_compra, pagos_doc.finiquito "+
//            "HAVING (((pagos.fecha_pago)='"+Utilitarios.date2StrDate(dataIni)+"') AND ((ctas_pagar.tipo_compra)=3) AND ((pagos_doc.finiquito)=1)) AND ((pagos.total_pago + pagos.total_det)<>0);" ;
//
//        try {
//            Statement stmt = conexao.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                s = new Pagos();
//                s.setCod_proveedor(rs.getInt("cod_proveedor"));
//                s.setNombre_proveedor(rs.getString("nombre_proveedor"));
//                s.setValor_pagado(rs.getBigDecimal("saldo"));
//
//                lista.add(s);
//            }
//            stmt.close();
//            rs.close();
//            return lista;
//        } catch (SQLException E) {
//            System.out.println("Erro ao consultar Entradas");
//            E.printStackTrace();
//            return null;
//        }
//    }
//    public String inserir(List<Pagos> lista, int fk){
//        try {
//
//            for(Pagos c : lista)
//            {
//                String sql = "INSERT INTO pagos "
//                   + "(cod_provedor, nombre_provedor, valor_pagado, saldos_cab_idsaldos_cab) "
//                   + "VALUES('"+c.getCod_proveedor()+"','"+c.getNombre_proveedor()+"', '"+c.getValor_pagado()+"',"
//                   + "'"+fk+"');";
//
//                Statement stmt = conexao.createStatement();
//                stmt.execute(sql);
//                stmt.close();
//            }
//
//            return "true";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
//    }

}
