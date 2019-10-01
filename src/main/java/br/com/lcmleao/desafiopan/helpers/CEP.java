package br.com.lcmleao.desafiopan.helpers;

public final class CEP {
    public static String withHifen(String cep) {
        cep = cep.replaceAll("\\.", "");
        int idx = cep.indexOf('-');
        if ( idx == -1 ) {
            cep = cep.substring(0, cep.length() - 3) + "-" + cep.substring(cep.length() - 3);
        }
        return cep;
    }
}
