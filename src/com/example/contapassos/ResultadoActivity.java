package com.example.contapassos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultadoActivity extends Activity {
	
	private Integer resultado = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		Intent intent = getIntent();
		this.resultado = intent.getIntExtra("resultado", 0);
		mostrarResultado();
	}
	
	private void mostrarResultado() {
		TextView tvResultado = (TextView)findViewById(R.id.tv_resultado);
		tvResultado.setText(this.resultado.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.resultado, menu);
		return true;
	}
	
	private void abrirContagemProgressiva() {
		Intent i = new Intent(this, ProgressivaActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}
	
	private void abrirContagemRegressiva() {
		Intent i = new Intent(this, RegressivaActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.acao_regressiva) {
			abrirContagemRegressiva();
		} else if (id == R.id.acao_progressiva) {
			abrirContagemProgressiva();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
