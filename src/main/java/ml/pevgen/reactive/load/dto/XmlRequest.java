package ml.pevgen.reactive.load.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
public class XmlRequest {

    private String name;

    private String id;


}
