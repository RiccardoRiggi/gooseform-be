package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;

@Mapper
public interface GooseComponentSpecificMapper {

	@Insert("INSERT INTO goose_component_specific(formId, id, nomeAttributo, valoreAttributo) VALUES (#{formId},#{id},#{nomeAttributo},#{valoreAttributo})")
	void inserisciRiga(GooseComponentSpecificDb gooseComponentSpecific);

	@Select("SELECT * FROM goose_component_specific where formId = #{formId} AND id = #{id} AND nomeAttributo = #{nomeAttributo}")
	GooseComponentSpecificDb getRiga(String formId, String id, String nomeAttributo);

	@Select("SELECT * FROM goose_component_specific where formId = #{formId} AND id = #{id}")
	List<GooseComponentSpecificDb> getRighe(String formId, String id);

	@Delete("DELETE FROM goose_component_specific WHERE formId = #{formId} AND id = #{id} AND nomeAttributo = #{nomeAttributo}")
	void deleteRiga(String formId, String id, String nomeAttributo);
}
