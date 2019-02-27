package br.senac.pa4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.senac.pa4.dao.AlunoDAO;
import br.senac.pa4.helper.AlunoHelper;
import br.senac.pa4.model.Aluno;

public class Cadastro extends AppCompatActivity {

    private AlunoHelper helper;
    private AlunoDAO alunoDAO;
    private Button btnCadastrarAluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastrarAluno = findViewById(R.id.btnCadastroAluno);
        helper = new AlunoHelper(this);
        alunoDAO = new AlunoDAO(this);

        btnCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = helper.getAluno();
                alunoDAO.inserir(aluno);
                if (alunoDAO.inserir(aluno) == -1) {
                    Toast.makeText(Cadastro.this,"Cadastro com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    finish();
                }
            }
        });


    }
}
