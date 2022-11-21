package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.db.GooseKControlDb;

@Mapper
public interface GooseKControlMapper {

	@Insert("INSERT INTO goose_k_control(pkControl, k) VALUES (#{pkControl},#{k})")
	void inserisci(GooseKControlDb chiamata);

	@Select("SELECT * FROM goose_k_control WHERE pkControl = #{pkControl} ")
	List<GooseKControlDb> getLista(int pkControl);

	@Delete("DELETE FROM goose_k_control WHERE pkControl = #{pkControl} AND k = #{k}")
	void elimina(int pkControl, String k);

	@Delete("DELETE FROM goose_k_control WHERE pkControl = #{pkControl}")
	void elimina(int pkControl);
}
