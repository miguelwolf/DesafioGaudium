package br.com.gaudium.entrega.maps;

import br.com.gaudium.entrega.Constants;
import br.com.gaudium.entrega.model.PedidoJsonObj;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestAPI {

    @GET(Constants.api_oferta_pedido)
    Call<PedidoJsonObj> getAll();

}
