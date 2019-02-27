package br.senac.pa4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import br.senac.pa4.model.Aluno;

public class AlunoDAO extends SQLiteOpenHelper {

    public AlunoDAO(Context context) {
        super(context, "AgendaAlunos", null, 1);
    }

    // chamado quendo o BD é criado pela primeira vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table aluno(" +
                "idAluno INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT not null," +
                "telefone TEXT not null," +
                "email TEXT not null UNIQUE," +
                "site TEXT not null," +
                "nota DECIMAL not null)";
        db.execSQL(sql);
    }

    // chamado quendo o BD precisar ser atualizado
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long inserir(Aluno aluno) {

        //Inserir registros com rocedimento de segureança
        ContentValues dados = getContentValues(aluno);

        SQLiteDatabase db = getWritableDatabase();
        return db.insert("aluno", null, dados);

    }

    private ContentValues getContentValues(Aluno aluno) {
        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("Telefone", aluno.getTelefone());
        dados.put("Email", aluno.getEmail());
        dados.put("Site", aluno.getSite());
        dados.put("Nota", aluno.getNota());
        return dados;
    }

    public List<Aluno> listaTodosAlunos() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT 'idAluno', * FROM aluno";
        Cursor cursor = db.rawQuery(sql,null);

        List<Aluno> listaAlunos = new ArrayList<>();

        while(cursor.moveToNext()) {
            long idAluno= cursor.getLong(cursor.getColumnIndex("idAluno"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String site = cursor.getString(cursor.getColumnIndex("site"));
            float nota = cursor.getFloat(cursor.getColumnIndex("nota"));

            Aluno aluno = new Aluno(idAluno, nome, telefone, email, site, nota);
            listaAlunos.add(aluno);
        }
        return listaAlunos;
    }

    public int editar(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(aluno);
        String selection = "idAluno = ?";
        String[] args = {String.valueOf(aluno.getIdAluno())};

        int resultado = db.update("aluno", dados, selection, args);
        db.close();
        return resultado;
   }

    public int deletar(long idAluno) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "idAluno = ?";
        String[] args = {String.valueOf(idAluno)};

        int resultado = db.delete("aluno", selection, args);
        db.close();
        return resultado;

    }
}
