package it.riccardoriggi.gooseform.constants;

public class GooseErrors {

	/* GOOSE_FORM */

	public static final String FORM_DUPLICATO = "L'identificativo del formId è già utilizzato da un altro form";

	public static final String FORM_NON_ESISTENTE = "Il formId inserito non esiste";

	/* GOOSE_COMPONENT */

	public static final String COMPONENTE_NON_ESISTENTE = "Il componentId inserito non esiste";
	public static final String TIPO_COMPONENTE_NON_ESISTENTE = "Il type inserito non esiste";
	public static final String ATTRIBUTO_NON_ESISTENTE = "Il nomeAttributo inserito non esiste per il tipo componente indicato";


	/* GOOSE_HTTP_REQUEST */

	public static final String CHIAMATA_HTTP_NON_ESISTENTE = "La chiamata http di riferimento non esiste";

	/* GOOSE_POPUP */

	public static final String POPUP_ESISTENTE = "Esiste già un popup per l'oggeto selezionato";

	public static final String CONTROLLO_NON_ESISTENTE = "Il type e il typeSpecific inseriti non esistono";

	public static final String COMPONENTE_NON_ESISTENTE_X = "Non è stato trovato nel form un componente corrispondente al componentId";

}
