
package br.com.lcmleao.desafiopan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CityModel {

    @JsonProperty("id")
    private Long mId;
    @JsonProperty("microrregiao")
    private MicroRegionModel mMicroRegionModel;
    @JsonProperty("nome")
    private String mNome;


}
