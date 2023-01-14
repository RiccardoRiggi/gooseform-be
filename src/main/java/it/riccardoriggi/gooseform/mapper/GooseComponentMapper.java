package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;

@Mapper
public interface GooseComponentMapper {

	@Insert("INSERT INTO goose_component(formId, id, type, label, widthXl, widthLg, widthMd, widthSm, width, requiredMark, ordination, paddingBottom, paddingLeft, paddingRight, paddingTop) VALUES (#{formId},#{id},#{type},#{label},#{widthXl},#{widthLg},#{widthMd},#{widthSm},#{width},#{requiredMark},#{ordination},#{paddingBottom},#{paddingLeft},#{paddingRight},#{paddingTop})")
	void inserisciComponent(GooseComponentDb gooseComponent);

	@Select("SELECT * FROM goose_component where formId = #{formId} AND id = #{id} ORDER BY ordination")
	GooseComponentDb getComponent(String formId, String id);

	@Select("SELECT * FROM goose_component where formId = #{formId} ORDER BY ordination")
	List<GooseComponentDb> getComponents(String formId);

	@Update("UPDATE goose_component SET label=#{label}, widthXl=#{widthXl} ,widthLg=#{widthLg}, widthMd=#{widthMd} ,widthSm=#{widthSm}, width=#{width}, requiredMark=#{requiredMark}, ordination=#{ordination} , paddingBottom=#{paddingBottom}, paddingLeft=#{paddingLeft}, paddingRight=#{paddingRight}, paddingTop=#{paddingTop} WHERE formId = #{formId} AND id= #{id}")
	void updateComponent(String label, String widthXl, String widthLg, String widthMd, String widthSm, String width, boolean requiredMark, String formId, String id, int ordination, int paddingBottom, int paddingLeft, int paddingRight, int paddingTop);

	@Delete("DELETE FROM goose_component WHERE formId = #{formId} AND id = #{id}")
	void deleteComponent(String formId, String id);

	@Delete("DELETE FROM goose_component WHERE formId = #{formId}")
	void deleteComponentByFormId(String formId);
}
