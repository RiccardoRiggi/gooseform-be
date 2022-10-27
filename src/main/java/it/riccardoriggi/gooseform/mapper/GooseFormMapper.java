package it.riccardoriggi.gooseform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.db.GooseFormDb;

@Mapper
public interface GooseFormMapper {

	@Insert("INSERT INTO goose_form(formId, title, icon, description) VALUES (#{formId},#{title},#{icon},#{description})")
	void inserisciForm(GooseFormDb gooseFormDb);

	@Select("SELECT * FROM goose_form where pk = #{pk}")
	GooseFormDb getFormByPk(int pk);

	@Select("SELECT * FROM goose_form where formId = #{formId}")
	GooseFormDb getFormById(String formId);

}
