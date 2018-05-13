package ml.pevgen.reactive.load.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "msg")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRequestMsg {

    private String name;

    private String id;

    List<XmlField> field;

}
