package br.com.gaudium.entrega;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import br.com.gaudium.entrega.webservice.OfertaPedidoWebService;
import br.com.gaudium.entrega.webservice.PerfilWebService;

public class ProfileActivity extends AppCompatActivity {

    private PerfilWebService webService;

    private TextView tvNome;
    private TextView tvCargo;
    private TextView tvDescricao;
    private TextView tvEntrega;
    private TextView tvSaldo;
    private TextView tvNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvNome = findViewById(R.id.tvNome);
        tvCargo = findViewById(R.id.tvCargo);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvEntrega = findViewById(R.id.tvEntrega);
        tvSaldo = findViewById(R.id.tvSaldo);
        tvNota = findViewById(R.id.tvNota);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (webService == null) {
            webService = new PerfilWebService();
        }

        webService.obterPerfil(this, perfil -> {
            tvNome.setText(perfil.getNome());
            tvCargo.setText(perfil.getCargo());
            tvDescricao.setText(perfil.getDescricao());
            tvEntrega.setText(String.valueOf(perfil.getEntregasTotal()));
            tvSaldo.setText(perfil.getSaldoTotal());
            tvNota.setText(String.format("%.1f", perfil.getNotaTotal(), Locale.ENGLISH));
        });
    }
}
