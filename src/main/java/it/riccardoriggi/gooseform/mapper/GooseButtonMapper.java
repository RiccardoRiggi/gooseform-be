package it.riccardoriggi.gooseform.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GooseButtonDb;

@Mapper
public interface GooseButtonMapper {

	@Insert("INSERT INTO goose_button(formId, title, icon, type) VALUES (#{formId},#{title},#{icon},#{type})")
	void inserisciButton(GooseButtonDb gooseFormDb);


	@Select("SELECT * FROM goose_button where formId = #{formId} AND type = #{type}")
	GooseButtonDb getButton(String formId, String type);

	@Update("UPDATE goose_button SET title=#{title}, icon=#{icon} WHERE formId = #{formId} AND type= #{type}")
	void updateButton(String title, String icon, String type, String formId);

	@Delete("DELETE FROM goose_button WHERE formId = #{formId} AND type = #{type}")
	void deleteButton(String formId, String type);
}
