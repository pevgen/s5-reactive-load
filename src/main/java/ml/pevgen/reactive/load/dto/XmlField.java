package ml.pevgen.reactive.load.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlField {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String value;

    List<XmlField> field;

}
