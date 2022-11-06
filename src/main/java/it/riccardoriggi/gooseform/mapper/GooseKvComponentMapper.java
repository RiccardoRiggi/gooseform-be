package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;

@Mapper
public interface GooseKvComponentMapper {

	@Insert("INSERT INTO goose_kv_component(formId, componentId, k, v) VALUES (#{formId},#{componentId},#{k},#{v})")
	void inserisci(GooseKvComponentDb chiamata);

	@Select("SELECT * FROM goose_kv_component WHERE formId = #{formId} AND componentId = #{componentId} ")
	List<GooseKvComponentDb> getLista(String formId, String componentId);

	@Delete("DELETE FROM goose_kv_component WHERE formId = #{formId} AND componentId = #{componentId} AND k = #{k}")
	void elimina(String formId, String componentId, String k);
}
