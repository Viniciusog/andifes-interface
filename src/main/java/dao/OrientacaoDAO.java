/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import configuration.PostgreSQLConnection;
import entities.AlunoProfessorISF;
import entities.Especialista;
import entities.Documentos;
import entities.MembroAcademico;
import entities.MembroAcademicoEmail;
import entities.MembroAcademicoEndereco;
import entities.MembroAcademicoTelefone;
import entities.AlunoGrad;
import entities.TabelaAvisosOrientadoPossuiOrientador;
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
    
    //Function getOrientados
    public static List<Orientacao> getOrientados(String nomeOrientador, String nomeOrientado){
        Connection con = postgresql.getConnection();
        String sql = "SELECT * FROM get_orientados WHERE (@nomeOrientador IS NULL OR nomeOrientador = @nomeOrientador) AND (@nomeOrientado IS NULL OR nomeOrientado = @nomeOrientado);";
        List<Orientacao> orientacoes = new ArrayList<>();
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            ResultSet result = stm.executeQuery();
            while(result.next()){
                //Caminho a ser percorrido pelo Orientador
                //orientacao => Especialista => MembroAcademico
                //Caminho a ser percorrido pelo orientado
                //orientacao => AlunoProfessor_ISF => MembroAcademico
                MembroAcademico orientador = new MembroAcademico();
                MembroAcademico orientado = new MembroAcademico();
                Especialista especialista = new Especialista();
                AlunoProfessorISF aluno_prof = new AlunoProfessorISF();
                Orientacao o = new Orientacao();
                
                orientador.setIdentidade(result.getString("idOrientador"));
                orientador.setNomeCompleto(result.getString("orientador_nome"));
                orientador.setId(1);
                orientado.setIdentidade(result.getString("idOrientado"));
                orientado.setNomeCompleto(result.getString("orientado_nome"));
                orientado.setId(2);
                
                especialista.setId(1);
                especialista.setMembroAcademico(orientador);
                
                aluno_prof.setId(2);
                aluno_prof.setMembroAcademico(orientado);
                
                o.setEspecialista(especialista); 
                o.setAlunoProfessorISF(aluno_prof); 
                o.setStatus(result.getString("status"));
                orientacoes.add(o);
            }
        
        }catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
        return orientacoes;
    }

    public static Documentos getDocumentos(String identidade) {
        Connection con = PostgreSQLConnection.getConnection();
        Documentos d = new Documentos();
        String sql = "SELECT * getDocumentos(?);";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, identidade);
                ResultSet result = stm.executeQuery();
                while(result.next()){
                    d.setTitulacao(result.getString("Titulacao"));
                    d.setProficiencia(result.getString("declaracao_proficiencia"));
                    d.setNivel(result.getString("nivel_proficiencia"));
                    d.setDiploma(result.getString("diploma"));
                    d.setComprov_prof(result.getString("comprovacao_profissional"));
                    d.setComprov_vinc(result.getString("comprovacao_vinculo"));
                }

            }catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        return d;
    }

    public static TabelaAvisosOrientadoPossuiOrientador getTabelaAvisos() {
        Connection con = PostgreSQLConnection.getConnection();
        TabelaAvisosOrientadoPossuiOrientador t = new TabelaAvisosOrientadoPossuiOrientador();
        String sql = "SELECT * FROM avisos_orientados;";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
                ResultSet result = stm.executeQuery();
                while(result.next()){
                    t.setQuando(result.getDate("quando"));
                    t.setQuem(result.getString("quem"));
                }

            }catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        return t;
    }

    public static List<AlunoGrad> getGradSemOrientador() {
        Connection con = PostgreSQLConnection.getConnection();
        List<AlunoGrad> Alunos = new ArrayList<>();
        String sql = "SELECT * FROM getGradSemOrientador();";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
                ResultSet result = stm.executeQuery();
                while(result.next()){
                    AlunoGrad a = new AlunoGrad();
                    a.setProfessor_isf_id(result.getInt("Professor_isf_id"));
                    a.setPoca_file(result.getString("Poca_file"));
                    a.setEdital_Selecao_File(result.getString("Edital_Selecao_File"));
                    a.setResultado_Selecao_File(result.getString("Resultado_Selecao_File"));
                    a.setTermo_Turma_Compromisso_File(result.getString("Termo_Turma_Compromisso_File"));
                    a.setVinculo_File(result.getString("Vinculo_File"));
                    
                    
                    Alunos.add(a);
                }

            }catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        return Alunos;
    }    
}
