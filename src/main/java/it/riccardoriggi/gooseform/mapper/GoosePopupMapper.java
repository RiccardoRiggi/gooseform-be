package it.riccardoriggi.gooseform.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;

@Mapper
public interface GoosePopupMapper {

	@Insert("INSERT INTO goose_popup(formId, componentId, title, icon, textTooltip, description) VALUES (#{formId},#{componentId},#{title},#{icon},#{textTooltip},#{description})")
	void inserisciPopup(GoosePopupDb gooseFormDb);


	@Select("SELECT * FROM goose_popup where formId = #{formId} AND componentId = #{componentId}")
	GoosePopupDb getPopupById(String formId, String componentId);

	@Select("SELECT * FROM goose_popup where formId = #{formId} AND componentId = '' ")
	GoosePopupDb getPopupByFormId(String formId);

	@Update("UPDATE goose_popup SET title=#{title}, icon=#{icon}, textTooltip=#{textTooltip}, description=#{description} WHERE pk = #{pk} ")
	void updatPopup(String title, String icon, String textTooltip, String description, int pk);

	@Delete("DELETE FROM goose_popup WHERE pk = #{pk}")
	void deletePopup(int pk);

	@Delete("DELETE FROM goose_popup WHERE formId = #{formId} AND componentId = #{componentId}")
	void deletePopupByComponentId(String formId, String componentId);

	@Delete("DELETE FROM goose_popup WHERE formId = #{formId}")
	void deletePopupByFormId(String formId);
}
