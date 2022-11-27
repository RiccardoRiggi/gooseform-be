package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.entity.db.TComponentSpecific;
import it.riccardoriggi.gooseform.entity.db.TControl;
import it.riccardoriggi.gooseform.entity.db.TRender;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseValidationInterface {

	TComponentSpecific verificaAttributoPerComponente(String type, String k) throws GooseFormException;

	List<TComponentSpecific> listaAttributiPerComponente(String type) throws GooseFormException;

	TControl verificaTipoControllo(String type, String k) throws GooseFormException;

	List<TControl> listaTipoControlliSpecificoDatoControllo(String type) throws GooseFormException;

	TRender verificaTipoRender(String type, String k) throws GooseFormException;

	List<TRender> listaTipoRenderSpecificoDatoRender(String type) throws GooseFormException;

	GooseKeyValue getPlaceholder(String type) throws GooseFormException;

	boolean esisteTipoComponente(String type) throws GooseFormException;

	boolean esisteAttributoPerComponente(String type, String k) throws GooseFormException;

	boolean esisteTipoControllo(String type, String typeSpecific) throws GooseFormException;

	boolean esisteTipoRender(String type, String typeSpecific) throws GooseFormException;




}
