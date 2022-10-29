package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GooseFormDb;

@Mapper
public interface GooseFormMapper {

	@Insert("INSERT INTO goose_form(formId, title, icon, description) VALUES (#{formId},#{title},#{icon},#{description})")
	void inserisciForm(GooseFormDb gooseFormDb);

	@Select("SELECT * FROM goose_form ")
	List<GooseFormDb> getForms();

	@Select("SELECT * FROM goose_form where formId = #{formId}")
	GooseFormDb getFormById(String formId);

	@Update("UPDATE goose_form SET title=#{title}, icon=#{icon} ,description=#{description} WHERE formId = #{formId}")
	void updateForm(String title, String icon, String description, String formId);

	@Delete("DELETE FROM goose_form WHERE formId = #{formId}")
	void deleteForm(String formId);
}
