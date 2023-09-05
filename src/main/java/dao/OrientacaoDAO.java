/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import configuration.PostgreSQLConnection;
import entities.AlunoProfessorISF;
import entities.Especialista;
import entities.MembroAcademico;
import entities.MembroAcademicoEmail;
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
    
    
    
    public static void procOrientGrad(Especialista e, AlunoProfessorISF a) {
        Connection con = PostgreSQLConnection.getConnection();
        Integer idEsp = e.getId();
        Integer idAlunoProfISF = a.getId();
        
        String sql = "CALL procOrientGrad(?,?);";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, idEsp);
            stm.setInt(2, idAlunoProfISF);
            stm.executeUpdate();
            con.close();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    
    // Estou esperando arrumarem essa procedure ainda
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
        Connection con = PostgreSQLConnection.getConnection();
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
                e.setTitulacao(result.getString("Titulacao"));
                e.setLingua(result.getString("Lingua"));
                e.setDeclaracaoProficiencia(result.getString("DeclaracaoProficiencia"));
                e.setDispoOriEsp(result.getBoolean("DispoOriEsp"));
                e.setVinculoFile(result.getString("VinculoFile"));
                e.setCurriculo(result.getString("Curriculo"));
                e.setDataCredenciamento(result.getDate("DataCredenciamento"));
                e.setDisponibilidadeAutor(result.getBoolean("DisponibilidadeAutor"));
                e.setPapeis(result.getString("Papeis"));
                e.setResetNeed(result.getBoolean("ResetNeed"));
                e.setDiplomaFile(result.getString("DiplomaFile"));
                e.setLinkCnpq(result.getString("LinkCnpq"));
                e.setPocaFile(result.getString("PocaFile"));
                e.setRegistroAutoria(result.getString("RegistroAutoria"));
                e.setRegistroMinistrante(result.getString("RegistroMinistrante "));
                
                m.setNacionalidade(result.getString("MA.nacionalidade"));
                m.setIdentidade(result.getString("MA.identidade"));
                m.setPaisDeResidencia(result.getString("MA.pais_de_residencia"));
                m.setNomeCompleto(result.getString("MA.nome_completo"));
                m.setDataNascimento(result.getDate("MA.data_nascimento"));
                m.setNomeDaMae(result.getString("MA.nome_da_mae"));
                m.setGenero(result.getString("MA.genero"));
                
                MembroAcademicoEmail email = new MembroAcademicoEmail();
                
                
                m.setEm(result.getInt("email"));
                m.setId(result.getInt("tipo_email"));
                m.setId(result.getInt("ddi"));
                m.setId(result.getInt("ddd"));
                m.setId(result.getInt("numero"));
                m.setId(result.getInt("complemento"));
                m.setId(result.getInt("codigo_postal"));
                m.setId(result.getInt("pais"));
                m.setId(result.getInt("estado"));
                m.setId(result.getInt("cidade"));
                m.setId(result.getInt("bairro"));
                m.setId(result.getInt("rua"));
                m.setId(result.getInt("num_endereco"));
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } 
        return e;
    }
}