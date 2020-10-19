package com.example.snackbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snackbar.domain.Usuario
import kotlinx.android.synthetic.main.login_body.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener(){
            callCadastro(getInformationUser())
        }

        tvCadastre.setOnClickListener(){
            callCriarConta()
        }
    }

//    Pegando informações do usuario
    fun getInformationUser():Usuario{
        val userName = edUserName.text.toString()
        val senha = edPassword.text.toString()

        return Usuario(1, userName, senha)
    }

    //Chamando a activity main
    fun callCadastro(usuario: Usuario){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("key", usuario)
        startActivity(intent)
    }

    fun callCriarConta(){
        var intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}