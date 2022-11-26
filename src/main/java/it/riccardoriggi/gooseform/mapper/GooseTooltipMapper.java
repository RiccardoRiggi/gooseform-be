package it.riccardoriggi.gooseform.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GooseTooltipDb;

@Mapper
public interface GooseTooltipMapper {

	@Insert("INSERT INTO goose_tooltip(formId, componentId, icon, tooltip) VALUES (#{formId},#{componentId},#{icon},#{tooltip})")
	void inserisciTooltip(GooseTooltipDb gooseFormDb);


	@Select("SELECT * FROM goose_tooltip where formId = #{formId} AND componentId = #{componentId}")
	GooseTooltipDb getTooltipById(String formId, String componentId);

	@Select("SELECT * FROM goose_tooltip where formId = #{formId} AND componentId IS NULL ")
	GooseTooltipDb getTooltipByFormId(String formId);

	@Update("UPDATE goose_tooltip SET icon=#{icon}, tooltip=#{tooltip} WHERE pk = #{pk} ")
	void updatTooltip(String icon, String tooltip, int pk);

	@Delete("DELETE FROM goose_tooltip WHERE pk = #{pk}")
	void deleteTooltip(int pk);

	@Delete("DELETE FROM goose_tooltip WHERE formId = #{formId} AND componentId = #{componentId}")
	void deleteTooltipByComponentId(String formId, String componentId);

	@Delete("DELETE FROM goose_tooltip WHERE formId = #{formId}")
	void deleteTooltipByFormId(String formId);
}
