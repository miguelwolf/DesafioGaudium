package br.com.gaudium.entrega.webservice;

import android.content.Context;
import android.widget.Toast;

import br.com.gaudium.entrega.Constants;
import br.com.gaudium.entrega.model.PerfilJsonObj;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilWebService {

	public void obterPerfil(Context ctx, PerfilCallback callback){

		Call<PerfilJsonObj> call = WebRequest
				.getInstance(Constants.URL)
				.getApi()
				.getPerfil();


		call.enqueue(new Callback<PerfilJsonObj>() {
			public void onResponse(Call<PerfilJsonObj> call, Response<PerfilJsonObj> response) {
				PerfilJsonObj responseObj = response.body();
				if(responseObj.isSuccess()){
					callback.run(responseObj.getResponse());
				} else{
					Toast.makeText(ctx, "Erro ao obter pedido", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(Call<PerfilJsonObj> call, Throwable t) {
				Toast.makeText(ctx, "Erro ao obter pedido", Toast.LENGTH_SHORT).show();
			}
		});

	}


	public interface PerfilCallback{
		void run(PerfilJsonObj.PerfilObj perfil);
	}
}
