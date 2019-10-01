
package br.com.lcmleao.desafiopan.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MicroRegionModel {

    @JsonProperty("id")
    private Long mId;
    @JsonProperty("mesorregiao")
    private MesoRegionModel mMesoRegionModel;
    @JsonProperty("nome")
    private String mNome;

}
