CREATE OR REPLACE FUNCTION getInfoOrientador(orientador_id INTEGER)
RETURNS TABLE (
    orientador_nome_completo VARCHAR(70),
    orientador_data_nascimento DATE,
    orientador_genero VARCHAR(20),
    orientador_nacionalidade VARCHAR(20),
    orientador_pais_residencia VARCHAR(19),
    orientador_nome_mae VARCHAR(70),
    orientador_identidade INTEGER,
    especialista_biodata VARCHAR(200),
    especialista_dispo_ministrar BOOLEAN,
    especialista_titulacao VARCHAR(200),
    especialista_lingua VARCHAR(200),
    especialista_dispo_ori_esp BOOLEAN,
    especialista_curriculo VARCHAR(200),
    especialista_data_credenciamento DATE
)
AS $$
BEGIN
    RETURN QUERY
    SELECT
        vo.orientador_nome_completo,
        vo.orientador_data_nascimento,
        vo.orientador_genero,
        vo.orientador_nacionalidade,
        vo.orientador_pais_residencia,
        vo.orientador_nome_mae,
        vo.orientador_identidade,
        vo.especialista_biodata,
        vo.especialista_dispo_ministrar,
        vo.especialista_titulacao,
        vo.especialista_lingua,
        vo.especialista_dispo_ori_esp,
        vo.especialista_curriculo,
        vo.especialista_data_credenciamento
    FROM vInfoOrientador vo
    WHERE vo.membro_academico_id = orientador_id;
END;
$$ LANGUAGE PLPGSQL;
