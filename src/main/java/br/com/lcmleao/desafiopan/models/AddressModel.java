
package br.com.lcmleao.desafiopan.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressModel {
    @JsonProperty("bairro")
    private String mBairro;
    @JsonProperty("cep")
    private String mCep;
    @JsonProperty("complemento")
    private String mComplemento;
    @JsonProperty("gia")
    private String mGia;
    @JsonProperty("ibge")
    private String mIbge;
    @JsonProperty("localidade")
    private String mLocalidade;
    @JsonProperty("logradouro")
    private String mLogradouro;
    @JsonProperty("uf")
    private String mUf;
    @JsonProperty("unidade")
    private String mUnidade;

}
