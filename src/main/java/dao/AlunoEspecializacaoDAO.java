/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import configuration.PostgreSQLConnection;
import entities.AlunoEspecializacao;
import entities.AlunoProfessorISF;
import entities.MembroAcademico;
import entities.MembroAcademicoEmail;
import entities.MembroAcademicoEndereco;
import entities.MembroAcademicoTelefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author vinij
 */
public class AlunoEspecializacaoDAO {
    
    public static AlunoEspecializacao getAlunoEspecializacao(Integer id) {
        Connection con = PostgreSQLConnection.getConnection();
        String sql = "SELECT * FROM valunoespecializacao where aluno_professor_isf_id = ?";
        
        AlunoEspecializacao aEsp = new AlunoEspecializacao();
        AlunoProfessorISF aProf = new AlunoProfessorISF();
        MembroAcademico m = new MembroAcademico();     
                
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();
            
            while (result.next()) {                
                aEsp.setId(result.getInt("aluno_professor_isf_id"));
                aProf.setId(result.getInt("aluno_professor_isf_id"));
                aEsp.setDataIngresso(result.getDate("DataIngresso"));
                aEsp.setDataConclusao(result.getDate("DataConclusao"));
                aEsp.setDiplomaFile(result.getString("DiplomaFile"));
                aEsp.setTitulacao(result.getString("Titulacao"));
                aEsp.setRegistroMinistrante(result.getString("RegistroMinistrante"));             
                aEsp.setAlunoProfessorISF(aProf);
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
                
                aProf.setMembroAcademico(m);
                
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        aEsp.setAlunoProfessorISF(aProf);
        if (aProf == null) {
            System.out.println("aprof é NUULL!");
        }
        System.out.println(aEsp.toString());
        return aEsp;
        
    }  
}
