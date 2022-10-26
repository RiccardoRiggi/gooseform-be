package it.riccardoriggi.gooseform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import it.riccardoriggi.gooseform.entity.GooseForm;

@Mapper
public interface ProvaMapper {

	@Select("select curdate() as formId from dual")
	GooseForm prova();

}
