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

    //Function getInfoUnicas(Integer id)
    public static AlunoEspecializacao getInfoUnicas(Integer id) {
        Connection con = PostgreSQLConnection.getConnection();
        AlunoEspecializacao ae = new AlunoEspecializacao();
        String sql = "SELECT * FROM getInfoUnicas(?);";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setInt(1, id);
                ResultSet result = stm.executeQuery();
                while(result.next()){
                    AlunoProfessorISF apISF = new AlunoProfessorISF();
                    MembroAcademico ma = new MembroAcademico();
                    
                    ma.setNomeCompleto(result.getString("nomeCompleto"));
                    ma.setNacionalidade(result.getString("nacionalidade"));
                    ma.setIdentidade(result.getString("identidade"));
                    ma.setNomeDaMae(result.getString("nome_da_mae"));
                    ma.setDataNascimento(result.getDate("data_nascimento"));
                    ma.setGenero(result.getString("genero"));
                    ma.setPaisDeResidencia(result.getString("pais_de_residencia"));
                    ae.setDataIngresso(result.getDate("DataIngresso"));
                    ae.setDataConclusao(result.getDate("DataConclusao"));
                    apISF.setMembroAcademico(ma);
                    ae.setAlunoProfessorISF(apISF);
                    
                }

            }catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        return ae;
    }    
    //Function GetProfData
    public static AlunoProfessorISF GetProfData() {
        Connection con = PostgreSQLConnection.getConnection();
        AlunoProfessorISF apISF = new AlunoProfessorISF();
        List<MembroAcademicoTelefone> tel = new ArrayList<>();
        String sql = "SELECT * FROM GetProfData();";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
                ResultSet result = stm.executeQuery();
                while(result.next()){
                    
                    MembroAcademico ma = new MembroAcademico();
                    MembroAcademicoTelefone mat = new MembroAcademicoTelefone();
                    MembroAcademicoEmail maEmail = new MembroAcademicoEmail();
                    
                    apISF.setId(result.getInt("aluno_professor_id"));
                    
                    ma.setNomeCompleto(result.getString("nome_completo"));
                    ma.setPaisDeResidencia(result.getString("pais_de_residencia"));
                    ma.setDataNascimento(result.getDate("data_nascimento"));
                    
                    mat.setDdi(result.getInt("codigo_pais_telefone"));
                    mat.setDdd(result.getInt("codigo_area_telefone"));
                    mat.setNumero(result.getString("numero_telefone"));
                    
                    tel.add(mat);
                    
                    
                    maEmail.setTipo(result.getString("tipo"));
                    maEmail.setValor(result.getString("email"));
                    email.add(maEmail);
                    
                    ma.setTelefones(tel);
                    ma.addEmail(maEmail);
                    
                    apISF.setMembroAcademico(ma);
                }

            }catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        return apISF;
    }  
    
}
