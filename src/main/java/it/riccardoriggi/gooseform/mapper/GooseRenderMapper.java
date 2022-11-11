package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;

@Mapper
public interface GooseRenderMapper {


	@Insert("INSERT INTO goose_render(formId, type, typeSpecific, idComponentA, idComponentB, idComponentC, value) VALUES (#{formId},#{type},#{typeSpecific},#{idComponentA},#{idComponentB},#{idComponentC},#{value})")
	void inserisciRender(GooseRenderDb gooseControl);

	@Select("SELECT * FROM goose_render where pk = #{pk}")
	GooseRenderDb getRender(int pk);

	@Select("SELECT * FROM goose_render where formId = #{formId}")
	List<GooseRenderDb> getRenders(String formId);

	@Update("UPDATE goose_render SET type=#{type},typeSpecific=#{typeSpecific},idComponentA=#{idComponentA},idComponentB=#{idComponentB},idComponentC=#{idComponentC},value=#{value} WHERE pk = #{pk}")
	void modificaRender(String type, String typeSpecific, String idComponentA, String idComponentB, String idComponentC, String value, int pk);

	@Delete("DELETE FROM goose_render WHERE pk = #{pk}")
	void eliminaRender(int pk);
}
