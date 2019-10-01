
package br.com.lcmleao.desafiopan.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StateModel {

    @JsonProperty("id")
    private Long mId;
    @JsonProperty("nome")
    private String mNome;
    @JsonProperty("regiao")
    private RegionModel mRegiao;
    @JsonProperty("sigla")
    private String mSigla;


}
