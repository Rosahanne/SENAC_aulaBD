package br.senac.pa4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import br.senac.pa4.dao.AlunoDAO;
import br.senac.pa4.helper.AlunoHelper;
import br.senac.pa4.model.Aluno;

public class EdicaoAluno extends AppCompatActivity {

    public static final double LINHA_AFETADA = 1;
    private TextView txtTitulo;
    private Button btnCadastrarAluno;
    private Button btnExcluirAluno;
    private AlunoHelper helper;
    private Aluno aluno;
    private AlunoDAO alunoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtTitulo = findViewById(R.id.txtTituloCadAluno);
        txtTitulo.setText("Dados do aluno");

        btnCadastrarAluno = findViewById(R.id.btnCadastroAluno);
        helper = new AlunoHelper(this);

        btnExcluirAluno = findViewById(R.id.btnExcluirAluno);
        btnExcluirAluno.setVisibility(View.VISIBLE);
        btnExcluirAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alunoDAO.deletar(aluno.getIdAluno()) == LINHA_AFETADA) {
                    finish();
                }

            }
        });

        //Recuperando a intent
        Intent intent = getIntent();
        //Recuperando o aluno que veio do listView - MainActivity
        aluno = (Aluno) intent.getSerializableExtra(MainActivity.MAIN_ALUNO);

        //Verificando se o aluno é nulo
        if (aluno != null) {
            //Carrega informações de alunos
            helper.carregaCampos(aluno);
        }

        //Edição dos dados do aluno
        btnCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aluno = helper.getAluno();
                if (alunoDAO.editar(aluno) == LINHA_AFETADA) {
                    finish();
                }
            }

        });


    }

}
