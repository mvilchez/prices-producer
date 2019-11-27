package es.eci.firefly.pricesproducer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder
public class Price implements Serializable {

    private String item;
    private String company;
    private String commercialCenterCode;

    private Double value;

    @JsonProperty(defaultValue = "null")
    private Date priceUpdateDate;

    @JsonProperty(defaultValue = "null")
    private Date priceCreationDate;

}

