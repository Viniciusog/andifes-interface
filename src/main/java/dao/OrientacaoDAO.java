/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import configuration.PostgreSQLConnection;
import entities.AlunoProfessorISF;
import entities.Especialista;
import entities.MembroAcademico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinij
 */
public class OrientacaoDAO {
    
    protected static Connection con = PostgreSQLConnection.getConnection();
    
    public static void procOrientGrad(Especialista e, AlunoProfessorISF a) {
        Integer idEsp = e.getId();
        Integer idAlunoProfISF = a.getId();
        
        String sql = "CALL procOrientGrad(?,?);";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, idEsp);
            stm.setInt(2, idAlunoProfISF);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    
    public static void procEditaOrientador(Especialista e) {
        String sql = "CALL procOrientGrad(?,?);";
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, idEsp);
            stm.setInt(2, idAlunoProfISF);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    
    public static Especialista getOrientador(Integer idOrientador) {
        String sql = "SELECT * FROM getOrientador(?);";
        MembroAcademico m = new MembroAcademico();
        Especialista e = new Especialista();
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, idOrientador);
            ResultSet result = stm.executeQuery();
            
            while (result.next()) {
                 
                e.setId(result.getInt("orientador_id"));
                e.setBiodata(result.getString("Biodata"));
                e.setDispoMinitrar(result.getBoolean("DispoMinistrar"));
                e.setId(result.getInt("Titulacao"));
                e.setId(result.getInt("Lingua"));
                e.setId(result.getInt("DeclaracaoProficiencia"));
                e.setId(result.getInt("DispoOriEsp"));
                e.setId(result.getInt("VinculoFile"));
                e.setId(result.getInt("Curriculo"));
                e.setId(result.getInt("DataCredenciamento"));
                e.setId(result.getInt("DisponibilidadeAutor"));
                e.setId(result.getInt("Papeis"));
                e.setId(result.getInt("ResetNeed"));
                e.setId(result.getInt("DiplomaFile"));
                e.setId(result.getInt("LinkCnpq"));
                e.setId(result.getInt("PocaFile"));
                e.setId(result.getInt("RegistroAutoria"));
                e.setId(result.getInt("RegistroMinistrante "));
                e.setId(result.getInt("identidade "));
                e.setId(result.getInt("nacionalidade "));
                e.setId(result.getInt("pais_de_residencia "));
                e.setId(result.getInt("nome_completo "));
                e.setId(result.getInt("data_nascimento "));
                e.setId(result.getInt("nome_da_mae  "));
                e.setId(result.getInt("genero"));
                e.setId(result.getInt("email"));
                e.setId(result.getInt("tipo_email"));
                e.setId(result.getInt("ddi"));
                e.setId(result.getInt("ddd"));
                e.setId(result.getInt("numero"));
                e.setId(result.getInt("complemento"));
                e.setId(result.getInt("codigo_postal"));
                e.setId(result.getInt("pais"));
                e.setId(result.getInt("estado"));
                e.setId(result.getInt("cidade"));
                e.setId(result.getInt("bairro"));
                e.setId(result.getInt("rua"));
                e.setId(result.getInt("num_endereco"));
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } 
        return e;
    }
}