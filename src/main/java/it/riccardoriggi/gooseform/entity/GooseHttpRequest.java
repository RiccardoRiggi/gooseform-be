package it.riccardoriggi.gooseform.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseHttpRequest {

	private String url;
    private String method;
    private List<GooseKeyValue> headers = new ArrayList<>();
    private String body;

}
