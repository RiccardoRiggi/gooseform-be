package it.riccardoriggi.gooseform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.db.TComponentSpecific;
import it.riccardoriggi.gooseform.entity.db.TControl;
import it.riccardoriggi.gooseform.entity.db.TRender;

@Mapper
public interface ValidationMapper {

	@Select("SELECT * FROM t_component_specific WHERE type = #{type} AND k = #{k} ")
	TComponentSpecific verificaAttributoPerComponente(String type, String k);

	@Select("SELECT * FROM t_component_specific WHERE type = #{type}")
	List<TComponentSpecific> listaAttributiPerComponente(String type);

	@Select("SELECT * FROM t_control WHERE type = #{type} AND k = #{k} ")
	TControl verificaTipoControllo(String type, String k);

	@Select("SELECT * FROM t_control WHERE type = #{type}")
	List<TControl> listaTipoControlliSpecificoDatoControllo(String type);

	@Select("SELECT * FROM t_render WHERE type = #{type} AND k = #{k} ")
	TRender verificaTipoRender(String type, String k);

	@Select("SELECT * FROM t_render WHERE type = #{type}")
	List<TRender> listaTipoRenderSpecificoDatoRender(String type);
}
