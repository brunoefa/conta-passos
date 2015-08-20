package com.example.contapassos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ProgressivaActivity extends Activity {
	
	private Integer passos = 0;
	private Integer resultado = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progressiva);
		Intent intent = getIntent();
		this.resultado = intent.getIntExtra("resultado", 0);
	}
	
	public void contagemProgressiva(View view) {
		this.passos++;
		this.resultado++;
		mostrarPassos();
	}
	
	public void zerar(View view) {
		this.passos = 0;
		mostrarPassos();
	}
	
	private void mostrarPassos() {
		Button btnContagemProgressiva = (Button)findViewById(R.id.btn_contagem_progressiva);
		btnContagemProgressiva.setText(this.passos.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.progressiva, menu);
		return true;
	}
	
	private void abrirContagemRegressiva() {
		Intent i = new Intent(this, RegressivaActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}
	
	private void abrirResultados() {
		Intent i = new Intent(this, ResultadoActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.acao_regressiva) {
			abrirContagemRegressiva();
		} else if (id == R.id.acao_resultados) {
			abrirResultados();
		}
		return super.onOptionsItemSelected(item);
	}
}
