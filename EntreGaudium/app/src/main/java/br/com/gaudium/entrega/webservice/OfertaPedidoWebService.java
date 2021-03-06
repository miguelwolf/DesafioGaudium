package br.com.gaudium.entrega.webservice;

import android.content.Context;
import android.widget.Toast;

import br.com.gaudium.entrega.Constants;
import br.com.gaudium.entrega.model.PedidoJsonObj;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfertaPedidoWebService {

	public void obterPedido(Context ctx, OfertaPedidoCallback callback){

		Call<PedidoJsonObj> call = WebRequest
				.getInstance(Constants.URL)
				.getApi()
				.getAll();

		call.enqueue(new Callback<PedidoJsonObj>() {
			public void onResponse(Call<PedidoJsonObj> call, Response<PedidoJsonObj> response) {
				PedidoJsonObj responseObj = response.body();
				if(responseObj.isSuccess()){
					callback.run(responseObj.getResponse());
				} else{
					Toast.makeText(ctx, "Erro ao obter pedido", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(Call<PedidoJsonObj> call, Throwable t) {
				Toast.makeText(ctx, "Erro ao obter pedido", Toast.LENGTH_SHORT).show();
			}
		});

	}


	public interface OfertaPedidoCallback{
		void run(PedidoJsonObj.PedidoObj ofertaPedido);
	}
}
