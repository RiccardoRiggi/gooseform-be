# Goose Form BE
###### *"Alla Goose più coraggiosa che io conosca"*
 
Goose Form BE è la componente di backend sviluppata in Spring Boot che si occupa di gestire le informazioni recuperate da [Goose Form Manager](https://github.com/RiccardoRiggi/gooseform-manager), salvarle su un database relazionale e generare l'oggetto JSON compatibile con il motore di [Goose Form](https://github.com/RiccardoRiggi/gooseform). Di seguito la documentazione che illustra la struttura del database e il funzionamento delle API Rest. L'applicazione necessità di un server Tomcat correttamente configurato con un database relazione MySQL. All'interno di questo repository sono presenti tutti gli script SQL e le insert per popolare le tavole di configurazione. Si rimanda comunque alla documentazione del motore di [Goose Form](https://github.com/RiccardoRiggi/gooseform) e alla guida all'utilizzo di [Goose Form Manager](https://github.com/RiccardoRiggi/gooseform-manager)  

---
# Database
#### GOOSE_BUTTON
|Nome      |Tipo    |   	 
|---	   |---	    |
|formId	   |  varchar  	|  
|type  	   |  varchar  	| 
|title 	   |  varchar  	| 
|icon  	   |  varchar  	| 

---

#### GOOSE_COMPONENT
|Nome      |Tipo    |   	 
|---	   |---	    |
|formId	   |  varchar  	|  
|id  	   |  varchar  	| 
|type 	   |  varchar  	| 
|label  	   |  varchar  	| 
|widthXl  	   |  varchar  	| 
|widthLg  	   |  varchar  	| 
|widthMd  	   |  varchar  	| 
|widthSm  	   |  varchar  	| 
|width  	   |  varchar  	| 
|requiredMark  	   |  tinyint  	| 

---

#### GOOSE_COMPONENT_SPECIFIC
|Nome      |Tipo    |   	 
|---	   |---	    |
|formId	   |  varchar  	|  
|id  	   |  varchar  	| 
|nomeAttributo 	   |  varchar  	| 
|valoreAttributo  	   |  varchar  	| 

---

#### GOOSE_CONTROL
|Nome      |Tipo    |   	 
|---	   |---	    |
|pk        |int     |
|formId	   |  varchar  	|  
|type  	   |  varchar  	| 
|typeSpecific 	   |  varchar  	| 
|idComponentA  	   |  varchar  	| 
|idComponentB  	   |  varchar  	| 
|idComponentC  	   |  varchar  	| 
|referenceValue  	   |  varchar  	| 
|errorMessage  	   |  varchar  	| 

---

#### GOOSE_FORM
|Nome      |Tipo    |   	 
|---	   |---	    |
|formId	   |  varchar  	|  
|description  	   |  varchar  	| 
|title 	   |  varchar  	| 
|icon  	   |  varchar  	| 

---

#### GOOSE_HTTP_REQUEST
|Nome      |Tipo    |   	 
|---	   |---	    |
|pk        |int     |
|formId	   |  varchar  	|  
|componentId  	   |  varchar  	| 
|url 	   |  varchar  	| 
|method  	   |  varchar  	| 
|body  	   |  varchar  	| 
|typeSpecific  	   |  varchar  	| 

--- 

#### GOOSE_KV_COMPONENT
|Nome      |Tipo    |   	 
|---	   |---	    |
|formId	   |  varchar  	|  
|componentId  	   |  varchar  	| 
|k 	   |  varchar  	| 
|v  	   |  varchar  	|

---

#### GOOSE_KV_COMPONENT
|Nome      |Tipo    |   	 
|---	   |---	    |
|pkHttp	   |  int  	|  
|k 	   |  varchar  	| 
|v  	   |  varchar  	|

---

#### GOOSE_K_CONTROL
|Nome      |Tipo    |   	 
|---	   |---	    |
|pkControl	   |  int  	|  
|k 	   |  varchar  	| 

---

#### GOOSE_POPUP
|Nome      |Tipo    |   	 
|---	   |---	    |
|pk        |int     |
|formId	   |  varchar  	|  
|componentId  	   |  varchar  	| 
|icon 	   |  varchar  	| 
|textTooltip  	   |  varchar  	| 
|title  	   |  varchar  	| 
|description  	   |  varchar  	| 

---

#### GOOSE_RENDER
|Nome      |Tipo    |   	 
|---	   |---	    |
|pk        |int     |
|formId	   |  varchar  	|  
|type  	   |  varchar  	| 
|typeSpecific 	   |  varchar  	| 
|idComponentA  	   |  varchar  	| 
|idComponentB  	   |  varchar  	| 
|idComponentC  	   |  varchar  	| 
|value  	   |  varchar  	| 

---

#### GOOSE_TOOLTIP
|Nome      |Tipo    |   	 
|---	   |---	    |
|pk        |int     |
|formId	   |  varchar  	|  
|componentId  	   |  varchar  	| 
|icon 	   |  varchar  	| 
|tooltip  	   |  varchar  	| 

---

#### T_COMPONENT_SPECIFIC
|Nome      |Tipo    |   	 
|---	   |---	    |
|type	   |  varchar  	|  
|k 	   |  varchar  	| 
|v  	   |  varchar  	|

---

#### T_CONTROL
|Nome      |Tipo    |   	 
|---	   |---	    |
|type	   |  varchar  	|  
|k 	   |  varchar  	| 
|description  	   |  varchar  	|

---

#### T_PLACEHOLDER
|Nome      |Tipo    |   	 
|---	   |---	    |
|type	   |  varchar  	|  
|placeholder  	   |  varchar  	|

---

#### T_RENDER
|Nome      |Tipo    |   	 
|---	   |---	    |
|type	   |  varchar  	|  
|k 	   |  varchar  	| 
|description  	   |  varchar  	|

---

# Endpoint

## Anteprima

Endpoint: http://localhost:8080/gooseform/manager/anteprima/{formId} <br/>
Method: GET <br/>
Body: nessuno <br/>
Response:
``` 
{ 	
    "formId": "anagraficaForm", 	
    "title": "Inserimento di un'anagrafica",
	"icon": "fa-solid fa-hat-cowboy",
	"sendButton": { ...	},
	"resetButton": {...},
	"description": "Descrizione di un form",
	"popup": {...},
	"autocomplete": true,
	"destinationUrl": {...},
	"originUrl": null,
	"components": [],
	"controls": [],
	"renders": []
} 
```
## Goose Form

Endpoint: http://localhost:8080/gooseform/manager/form/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
  "formId": "formId",
  "title": "Titolo",
  "icon": "icona",
  "description": "Descrizione"
} 
```
Response:
``` 
```

---

Endpoint: http://localhost:8080/gooseform/manager/form/{formId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"formId": "formId",
	"title": "Titolo",
	"icon": "fa-solid fa-hat-cowboy",
	"description": "Descrizione"
}
```
---

Endpoint: http://localhost:8080/gooseform/manager/form/ <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
    {
        "formId": "formId",
        "title": "Titolo",
        "icon": "fa-solid fa-hat-cowboy",
        "description": "Descrizione"
    }
]
```
---

Endpoint: http://localhost:8080/gooseform/manager/form/modifica/{formId} <br/>
Method: PUT <br/>
Body: 
``` 
{
	"title": "Titolo",
	"icon": "icona",
	"description": "Descrizioneeeeeee"
} 
```
Response:
``` 
```

---

Endpoint: http://localhost:8080/gooseform/manager/form/elimina/{formId} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```

## Goose Http Request

Endpoint: http://localhost:8080/gooseform/manager/http/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"componentId": "componentId",
	"url": "url",
	"method": "method",
	"body": "body",
	"typeSpecific": "SUBMIT"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/http/pk/{pk} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"pk": 31,
	"formId": "formId",
	"componentId": null,
	"url": "https://www.riccardoriggi.it",
	"method": "GET",
	"body": "",
	"typeSpecific": "SUBMIT"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/http/form/{type}/{formId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"pk": 31,
	"formId": "formId",
	"componentId": null,
	"url": "https://www.riccardoriggi.it",
	"method": "GET",
	"body": "",
	"typeSpecific": "SUBMIT"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/http/form/{formId}/{componentId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"pk": 31,
	"formId": "formId",
	"componentId": null,
	"url": "https://www.riccardoriggi.it",
	"method": "GET",
	"body": "",
	"typeSpecific": "SUBMIT"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/http/modifica/{pk} <br/>
Method: PUT <br/>
Body: 
``` 
{
	"url": "https://www.riccardoriggi.it",
	"method": "GET",
	"body": "",
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/http/elimina/{pk} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
## Goose KV Http Request

Endpoint: http://localhost:8080/gooseform/manager/kv-http/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"pkHttp":3,
	"k": "CHIAVE",
	"v": "VALORE"
}
```
Response:
``` 
```
---

Endpoint: http://localhost:8080/gooseform/manager/kv-http/{pk} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
	{
		"pkHttp": 38,
		"k": "Bareer",
		"v": "123"
	}
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/kv-http/{pk}/{k} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
---
## Goose Button
Endpoint: http://localhost:8080/gooseform/manager/button/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"type": "SEND",
	"title": "RESET",
	"icon": "fa-solid fa-undo"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/button/{formId}/{type} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"formId": "formId",
	"type": "SEND",
	"title": "RESET",
	"icon": "fa-solid fa-undo"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/button/modifica/{formId}/{type} <br/>
Method: PUT <br/>
Body: 
``` 
{
	"title": "RESET",
	"icon": "fa-solid fa-undo"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/button/elimina/{formId}/{type} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
## Goose Popup
Endpoint: http://localhost:8080/gooseform/manager/popup/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"componentId": "componentId",
	"icon": "icon",
	"textTooltip": "textTooltip",
	"title": "title",
	"description": "description"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/popup/{formId}/{componentId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"pk": 18,
	"formId": "formId",
	"componentId": "componentId",
	"icon": "icon",
	"textTooltip": "textTooltip",
	"title": "title",
	"description": "description"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/popup/{formId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"pk": 18,
	"formId": "formId",
	"componentId": "componentId",
	"icon": "icon",
	"textTooltip": "textTooltip",
	"title": "title",
	"description": "description"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/popup/modifica/{pk} <br/>
Method: PUT <br/>
Body: 
``` 
{
	"icon": "icon",
	"textTooltip": "textTooltip",
	"title": "title",
	"description": "description"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/popup/elimina/{pk} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
## Goose Tooltip
Endpoint: http://localhost:8080/gooseform/manager/tooltip/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"componentId": null,
	"icon": "icon",
	"tooltip": "tooltip"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/tooltip/{formId}/{componentId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"pk": 1,
	"formId": "formId",
	"componentId": "componentId",
	"icon": "icon",
	"tooltip": "tooltip"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/tooltip/{formId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"pk": 1,
	"formId": "formId",
	"componentId": "componentId",
	"icon": "icon",
	"tooltip": "tooltip"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/tooltip/modifica/{pk} <br/>
Method: PUT <br/>
Body: 
``` 
{
	"icon": "icon",
	"tooltip": "textTooltip",
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/tooltip/elimina/{pk} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
## Goose Component
Endpoint: http://localhost:8080/gooseform/manager/component/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
    "formId": "formId",
    "id": "componentId",
    "type": "GOOSE_TEXT_FIELD",
    "label": "Esempio Text Field - gooseTextField",
    "widthXl": "12",
    "widthLg": "12",
    "widthMd": "12",
    "widthSm": "12",
    "width": "12",
    "requiredMark": true
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/component/{formId}/{componentId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"formId": "formId",
	"id": "componentId",
	"type": "GOOSE_TEXT_FIELD",
	"label": "Esempio Text Field - gooseTextField",
	"widthXl": "12",
	"widthLg": "12",
	"widthMd": "12",
	"widthSm": "12",
	"width": "12",
	"requiredMark": true
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/component/{formId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
    {
        "formId": "formId",
        "id": "componentId",
        "type": "GOOSE_TEXT_FIELD",
        "label": "Esempio Text Field - gooseTextField",
        "widthXl": "12",
        "widthLg": "12",
        "widthMd": "12",
        "widthSm": "12",
        "width": "12",
        "requiredMark": true
    }
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/component/modifica/{formId}/{componentId} <br/>
Method: PUT <br/>
Body: 
``` 
{
	"label": "Esempio Text Field - gooseTextField",
	"widthXl": "12",
	"widthLg": "12",
	"widthMd": "12",
	"widthSm": "12",
	"width": "12",
	"requiredMark": true
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/component/elimina/{formId}/{componentId} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```

## Goose Component Specific
Endpoint: http://localhost:8080/gooseform/manager/component-specific/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"id": "selectId",
	"nomeAttributo": "size",
	"valoreAttributo": "1"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/component-specific/{formId}/{componentId}/{k} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"formId": "idForm",
	"id": "gooseTextField",
	"nomeAttributo": "required",
	"valoreAttributo": "true"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/component-specific/{formId}/{componentId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
    {
        "formId": "idForm",
        "id": "gooseTextField",
        "nomeAttributo": "required",
        "valoreAttributo": "true"
    }
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/component-specific/elimina/{formId}/{componentId}/{k} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
---
## Goose KV Component

Endpoint: http://localhost:8080/gooseform/manager/kv-component/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"componentId": "gooseSelect",
	"k": "GE",
	"v": "GENOVA"
}
```
Response:
``` 
```
---

Endpoint: http://localhost:8080/gooseform/manager/kv-component/{formId}/{componentId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
	{
        "formId": "formId",
        "componentId": "gooseSelect",
        "k": "GE",
        "v": "GENOVA"
    }
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/kv-component/{pk}/{k} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
---
## Goose Control
Endpoint: http://localhost:8080/gooseform/manager/control/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"type": "STANDARD",
	"typeSpecific": "REQUIRED",
	"idComponentA": "componentId",
	"referenceValue": "",
	"errorMessage": "Messaggio di errore"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/control/{pk} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
    "pk": 2,
	"formId": "formId",
	"type": "STANDARD",
	"typeSpecific": "REQUIRED",
	"idComponentA": "componentId",
	"idComponentB": "",
	"idComponentC": "",
	"referenceValue": "",
	"errorMessage": "Il campo è richiesto"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/control/lista/{formId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
    {
        "pk": 2,
        "formId": "formId",
        "type": "STANDARD",
        "typeSpecific": "REQUIRED",
        "idComponentA": "componentId",
        "idComponentB": "",
        "idComponentC": "",
        "referenceValue": "",
        "errorMessage": "Il campo è richiesto"
    }
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/control/modifica/{pk} <br/>
Method: PUT <br/>
Body: 
``` 
{
    "formId": "formId",
    "type": "STANDARD",
    "typeSpecific": "REQUIRED",
    "idComponentA": "componentId",
    "idComponentB": "",
    "idComponentC": "",
    "referenceValue": "",
    "errorMessage": "Il campo è richiesto"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/control/elimina/{pk} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
---
## Goose K Control

Endpoint: http://localhost:8080/gooseform/manager/k-control/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"pkHttp":3,
	"k": "CHIAVE",
}
```
Response:
``` 
```
---

Endpoint: http://localhost:8080/gooseform/manager/k-control/{pk} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
	{
		"pkHttp": 3,
		"k": "CHIAVE",
	}
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/k-control/{pk}/{k} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
---
## Goose Render
Endpoint: http://localhost:8080/gooseform/manager/render/inserisci <br/>
Method: POST <br/>
Body: 
``` 
{
	"formId": "formId",
	"type": "SIMPLE_RENDER",
	"typeSpecific": "HIDE_B_IF_A_MIN_X",
	"idComponentA": "componentId",
	"idComponentB": "componentId",
	"idComponentC": "",
	"value": "12"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/render/{pk} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
    "pk":1
	"formId": "formId",
	"type": "SIMPLE_RENDER",
	"typeSpecific": "HIDE_B_IF_A_MIN_X",
	"idComponentA": "componentId",
	"idComponentB": "componentId",
	"idComponentC": "",
	"value": "12"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/render/lista/{formId} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
    {
        "pk":1
        "formId": "formId",
        "type": "SIMPLE_RENDER",
        "typeSpecific": "HIDE_B_IF_A_MIN_X",
        "idComponentA": "componentId",
        "idComponentB": "componentId",
        "idComponentC": "",
        "value": "12"
    }
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/render/modifica/{pk} <br/>
Method: PUT <br/>
Body: 
``` 
{
    "formId": "formId",
    "type": "SIMPLE_RENDER",
    "typeSpecific": "HIDE_B_IF_A_MIN_X",
    "idComponentA": "componentId",
    "idComponentB": "componentId",
    "idComponentC": "",
    "value": "12"
}
```
Response:
``` 
```
---
Endpoint: http://localhost:8080/gooseform/manager/render/elimina/{pk} <br/>
Method: DELETE <br/>
Body: 
``` 
```
Response:
``` 
```
---
## Goose Utils
Endpoint: http://localhost:8080/gooseform/manager/validation/componente/{type} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
	{
		"type": "GOOSE_SELECT",
		"k": "valueName",
		"v": "String"
	}
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/validation/componente/{type}/{k} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"type": "GOOSE_SELECT",
	"k": "valueName",
	"v": "String"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/validation/control/{type} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
	{
		"type": "STANDARD",
		"k": "EQUAL",
		"description": "Verifica che il campo sia uguale ad un determinato valore"
	}
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/validation/control/{type}/{k} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"type": "STANDARD",
	"k": "EQUAL",
	"description": "Verifica che il campo sia uguale ad un determinato valore"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/validation/render/{type} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
[
	{
		"type": "SIMPLE_RENDER",
		"k": "DISABLED_B_IF_A_EQUAL_X",
		"description": "Disabilita B se A è uguale ad un determinato valore"
	}
]
```
---
Endpoint: http://localhost:8080/gooseform/manager/validation/render/{type}/{k} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"type": "SIMPLE_RENDER",
	"k": "DISABLED_B_IF_A_EQUAL_X",
	"description": "Disabilita B se A è uguale ad un determinato valore"
}
```
---
Endpoint: http://localhost:8080/gooseform/manager/validation/placeholder/{type} <br/>
Method: GET <br/>
Body: 
``` 
```
Response:
``` 
{
	"key": "GOOSE_DATE_TIME_FIELD",
	"value": "YYYY-MM-DDTHH:MM"
}
```
---
# Bom / Diba

[Spring Boot](https://spring.io/projects/spring-boot)

[MyBatis](https://mybatis.org/mybatis-3/)

[Lombok](https://projectlombok.org/)

[TomCat](https://tomcat.apache.org/)

[MySQL](https://www.mysql.com/it/)

---

# Licenza

Il codice sorgente da me scritto viene rilasciato con licenza [MIT](https://github.com/RiccardoRiggi/gooseform-manager/blob/main/LICENSE), framework, temi e librerie di terze parti mantengono le loro relative licenze. 