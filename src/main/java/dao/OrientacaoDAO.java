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
import entities.MembroAcademicoEndereco;
import entities.MembroAcademicoTelefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    /*public static void procEditaOrientador(Especialista e) {
        String sql = "CALL procOrientGrad(?,?);";
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, idEsp);
            stm.setInt(2, idAlunoProfISF);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }*/
    
    public static Especialista getOrientador(int idOrientador) {
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
                e.setRegistroMinistrante(result.getString("RegistroMinistrante"));
                
                m.setNacionalidade(result.getString("nacionalidade"));
                m.setIdentidade(result.getString("identidade"));
                m.setPaisDeResidencia(result.getString("pais_de_residencia"));
                m.setNomeCompleto(result.getString("nome_completo"));
                m.setDataNascimento(result.getDate("data_nascimento"));
                m.setNomeDaMae(result.getString("nome_da_mae"));
                m.setGenero(result.getString("genero"));
                
                MembroAcademicoEmail email = new MembroAcademicoEmail();                            
                email.setValor(result.getString("email"));
                email.setTipo(result.getString("tipo_email"));
                
                m.addEmail(email);
                
                MembroAcademicoTelefone telefone = new MembroAcademicoTelefone();
                telefone.setDdi(result.getString("ddi"));
                telefone.setDdd(result.getString("ddd"));
                telefone.setNumero(result.getString("numero"));
                m.addTelefone(telefone);
                
                MembroAcademicoEndereco endereco = new MembroAcademicoEndereco();
                
                endereco.setComplemento(result.getString("complemento"));
                endereco.setCodigoPostal(result.getString("codigo_postal"));
                endereco.setPais(result.getString("pais"));
                endereco.setEstado(result.getString("estado"));
                endereco.setCidade(result.getString("cidade"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getInt("num_endereco"));
                m.addEndereco(endereco);
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } 
        e.setMembroAcademico(m);
        return e;
    }
    
    public static void procEditGenero(Integer id_aluno_professor_isf, String genero) {
        Connection con = PostgreSQLConnection.getConnection();
        
        String sql = "CALL procEditGenero3(?, ?);";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id_aluno_professor_isf);
            stm.setString(2, genero);
            int n = stm.executeUpdate();
            System.out.println("n: " + n);
            JOptionPane.showMessageDialog(null, "Gênero editado com sucesso!");
            con.close();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }
    
    // Ação: 'inserir', 'editar', ou 'excluir'
    public static void procEditTelefone(Integer id_membro_academico, MembroAcademicoTelefone telefone, String acao) {
        Connection con = PostgreSQLConnection.getConnection();
        
        String sql = "SELECT procEditTelefone(?, ?, ?, ?, ?);";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id_membro_academico);
            stm.setString(2, telefone.getDdi());
            stm.setString(3, telefone.getDdd());
            stm.setString(4, telefone.getNumero());
            stm.setString(5, acao);
            
            stm.executeQuery();
            JOptionPane.showMessageDialog(null, "Telefone salvo com sucesso!");
            con.close();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Erro: " + exc.getMessage());
        }
    }

    
    // public static void 
    
    //Function getOrientados - dahiwa
    /*public static List<Orientacao> getOrientados(Integer idOrientador, Integer idOrientado){
        Connection con = PostgreSQLConnection.getConnection();
        String sql = "SELECT * FROM get_orientados(?,?);";
        List<Orientacao> orientacoes = new ArrayList<>();
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, idOrientador);
            stm.setInt(2, idOrientado);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                Orientacao o = new Orientacao();
                o.setEspecialista(result.getInt("orientador_id")); //Deve remeter ao MembroAcademico [ta errado ainda]
                o.setAlunoProfessorISF(result.getInt("orientado_id")); //Deve remeter ao AlunoProfessorISF [ta errado ainda~]
                o.setStatus(result.getString("status"));
                orientacoes.add(o);
            }
        
        }catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
        return orientacoes;
    }*/
    
}
