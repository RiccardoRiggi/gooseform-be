package it.riccardoriggi.gooseform.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseHttpRequest {

	private String url;
    private String method;
    private List<KeyValue> headers = new ArrayList<>();
    private String body;

}
