package br.senac.pa4.helper;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RatingBar;
import br.senac.pa4.Cadastro;
import br.senac.pa4.EdicaoAluno;
import br.senac.pa4.R;
import br.senac.pa4.model.Aluno;


public class AlunoHelper {

    private EditText txtNome;
    private EditText txtTelefone;
    private EditText txtEmail;
    private EditText txtSite;
    private RatingBar rbarNota;
    private Aluno aluno;

    public AlunoHelper(Cadastro activity) {
        carregaCampos(activity);
    }

    public AlunoHelper(EdicaoAluno activity) {
        carregaCampos(activity);
    }

    public void carregaCampos(Activity activity) {
        txtNome = activity.findViewById(R.id.cadAlunoTxtNome);
        txtTelefone = activity.findViewById(R.id.cadAlunoTxtTelefone);
        txtEmail = activity.findViewById(R.id.cadAlunoTxtEmail);
        txtSite = activity.findViewById(R.id.cadAlunoTxtSite);
        rbarNota = activity.findViewById(R.id.cadAlunoRBarNota);
    }

    public Aluno getAluno() {
        String nome = txtNome.getText().toString();
        String telefone = txtTelefone.getText().toString();
        String email = txtEmail.getText().toString();
        String site = txtSite.getText().toString();
        float nota = rbarNota.getRating();
        return new Aluno(aluno.getIdAluno(), nome, telefone, email, site, nota);
    }

    public void carregaCampos(Aluno aluno) {
        this.aluno = aluno;
        txtNome.setText(aluno.getNome());
        txtTelefone.setText(aluno.getTelefone());
        txtEmail.setText(aluno.getEmail());
        txtSite.setText(aluno.getSite());
        rbarNota.setRating(aluno.getNota());
    }


}
