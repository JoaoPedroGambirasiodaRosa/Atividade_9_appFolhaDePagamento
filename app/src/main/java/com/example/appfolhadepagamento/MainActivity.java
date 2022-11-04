package com.example.appfolhadepagamento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText salarioBruto, numeroFilhos;
    private Button btn_calcular;
    private TextView desconto_inss, desconto_ir, desconto_vt, plus_familia, salario_liquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        salarioBruto = findViewById(R.id.salario_bruto);
        numeroFilhos = findViewById(R.id.filhos);

        desconto_inss = findViewById(R.id.inss);
        desconto_ir = findViewById(R.id.IR);
        desconto_vt = findViewById(R.id.VT);
        plus_familia = findViewById(R.id.familia);
        salario_liquido = findViewById(R.id.liquido);

        btn_calcular = findViewById(R.id.calc);
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!plus_familia.getText().toString().isEmpty() || !salarioBruto.getText().toString().isEmpty()){
                    int children = Integer.parseInt(plus_familia.getText().toString());
                    double cashBruto = Double.parseDouble(salarioBruto.getText().toString());

                    double INSS, IR, VT, FAMILY, MONEY;

                    if (cashBruto <= 1212.00) {
                        INSS = cashBruto * 00.75;
                    } else if (cashBruto >=1212.01 && cashBruto <= 2427.35) {
                        INSS = cashBruto * 0.09;
                    } else if (cashBruto >= 2427.36 && cashBruto <= 3641.03) {
                        INSS = cashBruto * 0.12;
                    } else {
                        INSS = cashBruto * 0.14;
                    }

                    if (cashBruto <= 1903.98) {
                        IR = 0;
                    } else if (cashBruto >= 1903.99 && cashBruto <= 2826.65) {
                        IR = cashBruto * 0.075;
                    } else if (cashBruto >= 2826.66 && cashBruto <= 3751.05) {
                        IR = cashBruto * 0.15;
                    } else {
                        IR = cashBruto * 0.225;
                    }

                    if (cashBruto <= 1212.00) {
                        FAMILY = children * 56.47;
                    } else {
                        FAMILY = 0.00;
                    }

                    VT = cashBruto * 0.025;

                    MONEY = (cashBruto - INSS - IR - VT) + FAMILY;

                    desconto_inss.setText("Desconto do INSS: R$ " + INSS);
                    desconto_ir.setText("Desconto do imposto de renda: R$ " + IR);
                    desconto_vt.setText("Desconto do Vale transporte: R$ " + VT);
                    plus_familia.setText("Acréscimo salário familia: +R$ " + FAMILY);
                    salario_liquido.setText("Salario liquido: R$ " + MONEY);

                }
            }
        });
    }
}