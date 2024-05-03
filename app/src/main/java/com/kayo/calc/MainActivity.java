package com.kayo.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		Resources resources = getResources();

		DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
		char decimalSeparator = format.getDecimalFormatSymbols().getDecimalSeparator();

		EditText numero1Elemento = findViewById(R.id.numero1),
		numero2Elemento = findViewById(R.id.numero2);

		RadioButton soma = findViewById(R.id.soma),
		subtracao = findViewById(R.id.subtracao),
		divisao = findViewById(R.id.divisao),
		multiplicacao = findViewById(R.id.multiplicacao);

		Button calcular = findViewById(R.id.calcular);

		TextView resultadoElemento = findViewById(R.id.resultado);

		calcular.setOnClickListener(view -> {
			String numero1Text = numero1Elemento.getText().toString(),
			numero2Text = numero2Elemento.getText().toString();

			if(numero1Text.trim().isEmpty()){
				numero1Elemento.setError(resources.getString(R.string.invalid_first_number));
				return;
			}

			if(numero2Text.trim().isEmpty()){
				numero2Elemento.setError(resources.getString(R.string.invalid_second_number));
				return;
			}

			double numero1, numero2;

			try{
				if(decimalSeparator != '.'){
					if(numero1Text.indexOf(decimalSeparator) != -1) numero1Text = numero1Text.replace(decimalSeparator, '.');
					if(numero2Text.indexOf(decimalSeparator) != -1) numero2Text = numero2Text.replace(decimalSeparator, '.');
				}

				numero1 = Double.parseDouble(numero1Text);
				numero2 = Double.parseDouble(numero2Text);
			}catch(Exception error){
				resultadoElemento.setText(error.toString());
				return;
			}

			boolean somaChecked = soma.isChecked(),
			subtracaoChecked = subtracao.isChecked(),
			divisaoChecked = divisao.isChecked(),
			multiplicacaoChecked = multiplicacao.isChecked();

			String resultado;

			if(somaChecked) resultado = String.valueOf(numero1 + numero2);
			else if(subtracaoChecked) resultado = String.valueOf(numero1 - numero2);
			else if(divisaoChecked){
				if(numero2 == 0){
					resultadoElemento.setText(R.string.cant_divide_by_zero);
					return;
				}

				resultado = String.valueOf(numero1 / numero2);
			}else if(multiplicacaoChecked) resultado = String.valueOf(numero1 * numero2);
			else{
				resultadoElemento.setText(R.string.no_options_checked);
				return;
			}

			// Remover decimais
			if(resultado.endsWith(".0")) resultado = String.valueOf(Integer.parseInt(resultado.substring(0, resultado.indexOf("."))));

			resultadoElemento.setText(resultado);
		});

		soma.setOnCheckedChangeListener((view, checked) -> {
			if(checked){
				if(divisao.isChecked()) divisao.setChecked(false);
				if(subtracao.isChecked()) subtracao.setChecked(false);
				if(multiplicacao.isChecked()) multiplicacao.setChecked(false);
			}
		});

		subtracao.setOnCheckedChangeListener((view, checked) -> {
			if(checked){
				if(soma.isChecked()) soma.setChecked(false);
				if(divisao.isChecked()) divisao.setChecked(false);
				if(multiplicacao.isChecked()) multiplicacao.setChecked(false);
			}
		});

		multiplicacao.setOnCheckedChangeListener((view, checked) -> {
			if(checked){
				if(soma.isChecked()) soma.setChecked(false);
				if(divisao.isChecked()) divisao.setChecked(false);
				if(subtracao.isChecked()) subtracao.setChecked(false);
			}
		});

		divisao.setOnCheckedChangeListener((view, checked) -> {
			if(checked){
				if(soma.isChecked()) soma.setChecked(false);
				if(subtracao.isChecked()) subtracao.setChecked(false);
				if(multiplicacao.isChecked()) multiplicacao.setChecked(false);
			}
		});
	}
}
