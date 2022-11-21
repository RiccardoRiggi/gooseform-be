package it.riccardoriggi.gooseform.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;

@Mapper
public interface GooseHttpRequestMapper {

	@Insert("INSERT INTO goose_http_request(formId, componentId, url, method, body, typeSpecific) VALUES (#{formId},#{componentId},#{url},#{method},#{body},#{typeSpecific})")
	void inserisciChiamata(GooseHttpRequestDb chiamata);

	@Select("SELECT * FROM goose_http_request WHERE pk = #{pk} ")
	GooseHttpRequestDb getChiamataByPk(int pk);

	@Select("SELECT * FROM goose_http_request WHERE formId = #{formId} AND componentId = #{componentId} ")
	GooseHttpRequestDb getChiamataById(String formId, String componentId);

	@Select("SELECT * FROM goose_http_request WHERE formId = #{formId} AND componentId = '' ")
	GooseHttpRequestDb getChiamataByFormId(String formId);

	@Update("UPDATE goose_http_request SET url=#{url}, method=#{method} ,body=#{body} WHERE pk = #{pk}")
	void updateChiamata(String url, String method, String body, int pk);

	@Delete("DELETE FROM goose_http_request WHERE pk = #{pk}")
	void deleteChiamata(int pk);

	@Delete("DELETE FROM goose_http_request WHERE formId = #{formId}")
	void deleteChiamataByFormId(String formId);

	@Delete("DELETE FROM goose_http_request WHERE formId = #{formId} AND componentId = #{componentId}")
	void deleteChiamataByComponentId(String formId, String componentId);
}
