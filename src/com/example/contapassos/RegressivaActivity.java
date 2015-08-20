package com.example.contapassos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegressivaActivity extends Activity {

	private Integer passos = 0;
	private Integer limite = 0;
	private Integer resultado = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regressiva);
		Intent intent = getIntent();
		this.resultado = intent.getIntExtra("resultado", 0);
	}
	
	public void contagemRegressiva(View view) {
		if (this.limite == 0) {
			capturarLimite();
		}
		if (this.passos > 0) {
			this.passos--;
			this.resultado++;
			mostrarPassos(); 
		}
	}
	
	private void capturarLimite() {
		EditText etLimite = (EditText)findViewById(R.id.et_limite);
		String stringLimite = etLimite.getText().toString();
		stringLimite = "".equals(stringLimite) ? "0" : stringLimite;
		this.limite = Integer.parseInt(stringLimite);
		this.passos = this.limite;
	}
	
	public void reiniciar(View view) {
		capturarLimite();
		mostrarPassos();
	}
	
	private void mostrarPassos() {
		Button btnContagemRegressiva = (Button)findViewById(R.id.btn_contagem_regressiva);
		btnContagemRegressiva.setText(this.passos.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.regressiva, menu);
		return true;
	}
	
	private void abrirContagemProgressiva() {
		Intent i = new Intent(this, ProgressivaActivity.class);
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
		if (id == R.id.acao_progressiva) {
			abrirContagemProgressiva();
		} else if (id == R.id.acao_resultados) {
			abrirResultados();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
