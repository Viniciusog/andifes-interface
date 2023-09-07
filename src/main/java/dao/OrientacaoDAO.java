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
import entities.Orientacao;
import entities.TabelaAvisosOrientadoPossuiOrientador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    //Function getOrientados
    public static List<Orientacao> getOrientados(String nomeOrientador, String nomeOrientado){
        Connection con = PostgreSQLConnection.getConnection();
        String sql = "SELECT * FROM get_orientados(?,?)";
        List<Orientacao> orientacoes = new ArrayList<>();
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, nomeOrientador);
            stm.setString(2, nomeOrientado);
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
                
                orientador.setIdentidade(result.getString("orientador_identidade"));
                orientador.setNomeCompleto(result.getString("orientador_nome"));
                orientador.setId(result.getInt("orientador_id"));
                
                orientado.setIdentidade(result.getString("orientado_identidade"));
                orientado.setNomeCompleto(result.getString("orientado_nome"));
                orientado.setId(result.getInt("orientado_id"));
                
                MembroAcademicoEmail email = new MembroAcademicoEmail(null, null, result.getString("email"), null);
                orientado.addEmail(email);                     
                           
                especialista.setId(orientador.getId());
                especialista.setMembroAcademico(orientador);
                
                aluno_prof.setId(orientado.getId());
                aluno_prof.setMembroAcademico(orientado);
                aluno_prof.setTipo(result.getString("tipo")); //aluno_esp ou aluno_grad
                
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

    public static void procEditaOrientador(
        String chaveEspecialista,
        String novo_Biodata,
        Boolean novo_DispoMinistrar,
        String novo_Titulacao,
        String novo_Lingua,
        String novo_DeclaracaoProficiencia,
        Boolean novo_DispoOriEsp,
        String novo_VinculoFile,
        String novo_Curriculo,
        Date novo_DataCredenciamento,
        String novo_DisponibilidadeAutor,
        String novo_Papeis,
        Boolean novo_ResetNeed,
        String novo_DiplomaFile,
        String novo_LinkCnpq,
        String novo_PocaFile,
        String novo_RegistroAutoria,
        String novo_identidade,
        String novo_nacionalidade,
        String novo_pais_de_residencia,
        String novo_nome_completo,
        Date novo_data_nascimento,
        String novo_nome_da_mae,
        String novo_genero,
        String novo_email_valor,
        String novo_email_tipo,
        String novo_endereco_complemento,
        String novo_endereco_codigo_postal,
        String novo_endereco_pais,
        String novo_endereco_estado,
        String novo_endereco_cidade,
        String novo_endereco_bairro,
        String novo_endereco_rua,
        int novo_endereco_numero,
        String novo_telefone_ddi,
        String novo_telefone_ddd,
        String novo_telefone_numero) {
        Connection con = PostgreSQLConnection.getConnection();
        String sql = "CALL procEditaOrientador(?,?,?,?,?,?,?,?,?,?,?"
                + "?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?);"; //37
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, chaveEspecialista);
            stm.setString(2, novo_Biodata);
            stm.setBoolean(3, novo_DispoMinistrar);
            stm.setString(4, novo_Titulacao);
            stm.setString(5, novo_Lingua);
            stm.setString(6, novo_DeclaracaoProficiencia);
            stm.setBoolean(7, novo_DispoOriEsp);
            stm.setString(8, novo_VinculoFile);
            stm.setString(9, novo_Curriculo);
            stm.setDate(10, novo_DataCredenciamento);
            stm.setString(11, novo_DisponibilidadeAutor);
            stm.setString(12, novo_Papeis);
            stm.setBoolean(13, novo_ResetNeed);
            stm.setString(14, novo_DiplomaFile);
            stm.setString(15, novo_LinkCnpq);
            stm.setString(16, novo_PocaFile);
            stm.setString(17, novo_RegistroAutoria);
            stm.setString(18, novo_identidade);
            stm.setString(19, novo_nacionalidade);
            stm.setString(20, novo_pais_de_residencia);
            stm.setString(21, novo_nome_completo);
            stm.setDate(22, novo_data_nascimento);
            stm.setString(23, novo_nome_da_mae);
            stm.setString(24, novo_genero);
            stm.setString(25, novo_email_valor);
            stm.setString(26, novo_email_tipo);
            stm.setString(27, novo_endereco_complemento);
            stm.setString(28, novo_endereco_codigo_postal);
            stm.setString(29, novo_endereco_pais);
            stm.setString(30, novo_endereco_estado);
            stm.setString(31, novo_endereco_cidade);
            stm.setString(32, novo_endereco_bairro);
            stm.setString(33, novo_endereco_rua);
            stm.setInt(34, novo_endereco_numero);
            stm.setString(35, novo_telefone_ddi);
            stm.setString(36, novo_telefone_ddd);
            stm.setString(37, novo_telefone_numero);
            stm.executeUpdate();
            con.close();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
