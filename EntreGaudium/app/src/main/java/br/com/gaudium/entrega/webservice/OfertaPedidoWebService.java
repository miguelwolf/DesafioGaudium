package br.com.gaudium.entrega.webservice;

import android.content.Context;
import android.widget.Toast;

import br.com.gaudium.entrega.model.PedidoJsonObj;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfertaPedidoWebService {
//	String URL = "https://dbgapi-desenv.taximachine.com.br/ps/ofertaPedido.php";
	String URL = "https://dbgapi-desenv.taximachine.com.br/";

	public void obterPedido(Context ctx, OfertaPedidoCallback callback){
		//TODO: Trocar pedido hard-coded por chamada ao backend
//		PedidoJsonObj.PedidoObj p = new PedidoJsonObj.PedidoObj();
//		p.setLat_coleta(-22.910112);
//		p.setLng_coleta(-43.173913);
//		p.setEndereco_coleta("Av. Graça Aranha, 26 - Centro");

//		PedidoJsonObj.EntregaObj[] destino = new PedidoJsonObj.EntregaObj[3];
//		destino[0] = new PedidoJsonObj.EntregaObj("#1", -22.910852, -43.185296);
//		destino[1] = new PedidoJsonObj.EntregaObj("#2", -22.903223, -43.103135);
//		destino[2] = new PedidoJsonObj.EntregaObj("#3", -22.955188, -43.193763);
//		p.setEntrega(destino);
//
//		callback.run(p);

		//TODO: Trocar código abaixo por uma requisição GET para a URL do método
		Call<PedidoJsonObj> call = WebRequest
				.getInstance(URL)
				.getApi()
				.getAll();

		call.enqueue(new Callback<PedidoJsonObj>() {
			public void onResponse(Call<PedidoJsonObj> call, Response<PedidoJsonObj> response) {
//				PedidoJsonObj responseObj = (PedidoJsonObj) WebRequest.parse(response);
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
