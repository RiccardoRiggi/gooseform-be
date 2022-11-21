package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.db.GooseKvHttpRequestDb;

@Mapper
public interface GooseKvHttpRequestMapper {

	@Insert("INSERT INTO goose_kv_http_request(pkHttp, k, v) VALUES (#{pkHttp},#{k},#{v})")
	void inserisci(GooseKvHttpRequestDb chiamata);

	@Select("SELECT * FROM goose_kv_http_request WHERE pkHttp = #{pkHttp} ")
	List<GooseKvHttpRequestDb> getLista(int pkHttp);

	@Delete("DELETE FROM goose_kv_http_request WHERE pkHttp = #{pkHttp} AND k = #{k}")
	void eliminaById(int pkHttp, String k);

	@Delete("DELETE FROM goose_kv_http_request WHERE pkHttp = #{pkHttp} ")
	void elimina(int pkHttp);
}
