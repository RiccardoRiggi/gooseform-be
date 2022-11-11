package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

public interface ValidationInterface {

	ResponseEntity<Object> verificaAttributoPerComponente(String type, String k);

	ResponseEntity<Object> listaAttributiPerComponente(String type);

	ResponseEntity<Object> verificaTipoControllo(String type, String k);

	ResponseEntity<Object> listaTipoControlliSpecificoDatoControllo(String type);

	ResponseEntity<Object> verificaTipoRender(String type, String k);

	ResponseEntity<Object> listaTipoRenderSpecificoDatoRender(String type);




}
