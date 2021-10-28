package com.example.atv11armazenamentointerno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    final String PREF_NOME = "config";
    ToggleButton togReceber;
    CheckBox chkTodos;
    EditText edtNome;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        togReceber = findViewById(R.id.togReceber);
        chkTodos = findViewById(R.id.chkTodos);
        edtNome = findViewById(R.id.edtNome);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        salvarPreferencias();
    }
    private void salvarPreferencias() {
        SharedPreferences pref = getSharedPreferences(PREF_NOME, 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean("receber", togReceber.isChecked());
        editor.putBoolean("todos", chkTodos.isChecked());
        editor.putString("nome", edtNome.getText().toString());
        editor.commit();
    }

    private void carregarPreferencias() {
        SharedPreferences pref = getSharedPreferences(PREF_NOME, 0);

        togReceber.setChecked(pref.getBoolean("receber", false));
        chkTodos.setChecked(pref.getBoolean("todos", false));
        edtNome.setText(pref.getString("nome", ""));
    }


}