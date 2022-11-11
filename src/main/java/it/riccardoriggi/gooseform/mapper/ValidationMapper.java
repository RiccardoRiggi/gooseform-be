package it.riccardoriggi.gooseform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.GooseKeyValue;

@Mapper
public interface ValidationMapper {

	@Select("SELECT type as key, k as value FROM t_component_specific WHERE type = #{type} AND k = #{k} ")
	GooseKeyValue verificaAttributoPerComponente(String type, String k);

	@Select("SELECT type as key, k as value FROM t_component_specific WHERE type = #{type}")
	GooseKeyValue listaAttributiPerComponente(String type);

	@Select("SELECT type as key, k as value FROM t_control WHERE type = #{type} AND k = #{k} ")
	GooseKeyValue verificaTipoControllo(String type, String k);

	@Select("SELECT type as key, k as value FROM t_control WHERE type = #{type}")
	GooseKeyValue listaTipoControlliSpecificoDatoControllo(String type);

	@Select("SELECT type as key, k as value FROM t_render WHERE type = #{type} AND k = #{k} ")
	GooseKeyValue verificaTipoRender(String type, String k);

	@Select("SELECT type as key, k as value FROM t_render WHERE type = #{type}")
	GooseKeyValue listaTipoRenderSpecificoDatoRender(String type);
}
