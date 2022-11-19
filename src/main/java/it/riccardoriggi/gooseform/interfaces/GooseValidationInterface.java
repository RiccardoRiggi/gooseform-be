package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

public interface GooseValidationInterface {

	ResponseEntity<Object> verificaAttributoPerComponente(String type, String k);

	ResponseEntity<Object> listaAttributiPerComponente(String type);

	ResponseEntity<Object> verificaTipoControllo(String type, String k);

	ResponseEntity<Object> listaTipoControlliSpecificoDatoControllo(String type);

	ResponseEntity<Object> verificaTipoRender(String type, String k);

	ResponseEntity<Object> listaTipoRenderSpecificoDatoRender(String type);

	ResponseEntity<Object> getPlaceholder(String type);

	boolean esisteTipoComponente(String type);

	boolean esisteAttributoPerComponente(String type, String k);

	boolean esisteTipoControllo(String type, String typeSpecific);

	boolean esisteTipoRender(String type, String typeSpecific);




}
