package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GooseControlDb;

@Mapper
public interface GooseControlMapper {

	@Insert("INSERT INTO goose_control(formId, type, typeSpecific, idComponentA, idComponentB, idComponentC, referenceValue, errorMessage) VALUES (#{formId},#{type},#{typeSpecific},#{idComponentA},#{idComponentB},#{idComponentC},#{referenceValue},#{errorMessage})")
	void inserisciControllo(GooseControlDb gooseControl);

	@Select("SELECT * FROM goose_control where pk = #{pk}")
	GooseControlDb getControllo(int pk);

	@Select("SELECT * FROM goose_control where formId = #{formId}")
	List<GooseControlDb> getControlli(String formId);

	@Update("UPDATE goose_control SET type=#{type},typeSpecific=#{typeSpecific},idComponentA=#{idComponentA},idComponentB=#{idComponentB},idComponentC=#{idComponentC},referenceValue=#{referenceValue},errorMessage=#{errorMessage} WHERE pk = #{pk}")
	void modificaControllo(String type, String typeSpecific, String idComponentA, String idComponentB, String idComponentC, String referenceValue, String errorMessage, int pk);

	@Delete("DELETE FROM goose_control WHERE pk = #{pk}")
	void eliminaControllo(int pk);
}
