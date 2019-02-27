package br.senac.pa4;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import br.senac.pa4.dao.AlunoDAO;
import br.senac.pa4.model.Aluno;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ALUNO = "main_aluno";
    private ListView listViewAlunos;
    private FloatingActionButton fabAddAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewAlunos = findViewById(R.id.listViewAlunos);
        fabAddAluno = findViewById(R.id.fabAddAluno);

        fabAddAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });

        listViewAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EdicaoAluno.class);
                Aluno aluno = (Aluno)parent.getItemAtPosition(position);
                intent.putExtra(MAIN_ALUNO, aluno);
                startActivity(intent);
         }});

    }

    @Override
    protected void onResume() {
        super.onResume();
        AlunoDAO alunoDAO = new AlunoDAO(this);
        List<Aluno> aluno = alunoDAO.listaTodosAlunos();
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aluno);
        listViewAlunos.setAdapter(adapter);
    }


}
