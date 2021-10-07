package br.java.app_android_firebaseusuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import br.java.app_android_firebaseusuario.datamodels.Cursos;

public class MainActivity extends AppCompatActivity {

    // criando variáveis para o nosso texto de edição
    private EditText cursoNomeEdt;
    private EditText cursoDescricaoEdt;
    private EditText cursoDuracaoEdt;

    // criando variável para o botão
    private Button submeterCursoBtn;

    // criando strings para armazenar
    // nossos valores dos campos de texto de edição.
    private String cursoNome;
    private String cursoDescricao;
    private String cursoDuracao;

    // criando uma variavel
    // para o firebase
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtendo nossa instância
        // do Firebase Firestore.
        db = FirebaseFirestore.getInstance();

        // inicializando nosso texto de edição e botões
        cursoNomeEdt = findViewById(R.id.idEdtCursoNome);
        cursoDescricaoEdt = findViewById(R.id.idEdtCursoDescricao);
        cursoDuracaoEdt = findViewById(R.id.idEdtCursoDuracao);
        submeterCursoBtn = findViewById(R.id.idBtnSubmeterCurso);

        //adicionando um ouvinte de clique para o botão
        submeterCursoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // obtendo dados de campos de texto de edição.
                cursoNome = cursoNomeEdt.getText().toString();
                cursoDescricao = cursoDescricaoEdt.getText().toString();
                cursoDuracao = cursoDuracaoEdt.getText().toString();

                // validando os campos de texto se estão vazios ou não.
                if (TextUtils.isEmpty(cursoNome)) {
                    cursoNomeEdt.setError("Por favor digite o nome");
                } else if (TextUtils.isEmpty(cursoDescricao)) {
                    cursoDescricaoEdt.setError("Por favor digite a descrição");
                } else if (TextUtils.isEmpty(cursoDuracao)) {
                    cursoDuracaoEdt.setError("Por favor digite a duração");
                } else {
                    // método de chamada para adicionar dados ao Firebase Firestore.
                    adicionarDadosNoFirestore(cursoNome, cursoDescricao, cursoDuracao);
                }
            }
        });
    }
    public void adicionarDadosNoFirestore(String cursoNome, String cursoDescricao, String cursoDuracao) {

        // criando uma referência de coleção
        // para nosso banco de dados Firebase Firetore.
        CollectionReference dbCursos = db.collection("Cursos");

        // adicionando nossos dados à nossa classe de objeto de cursos.
        Cursos cursos = new Cursos(cursoNome, cursoDescricao, cursoDuracao);

        // O método abaixo é usado para adicionar dados ao Firebase Firestore.
        dbCursos.add(cursos).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

                // depois que a adição de dados for bem-sucedida
                // estamos exibindo uma mensagem de sucesso.
                Toast.makeText(MainActivity.this, "Seu curso foi adicionado ao Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                // este método é chamado quando o processo de adição de dados falha.
                // exibindo uma mensagem de erro quando a adição de dados falha.
                Toast.makeText(MainActivity.this, "Falha ao adicionar curso \n", Toast.LENGTH_SHORT).show();
            }
        });
    }
}