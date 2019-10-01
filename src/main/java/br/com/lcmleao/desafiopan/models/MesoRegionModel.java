
package br.com.lcmleao.desafiopan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MesoRegionModel {

    @JsonProperty("id")
    private Long mId;
    @JsonProperty("nome")
    private String mNome;
    @JsonProperty("UF")
    private StateModel mUFModel;

}
