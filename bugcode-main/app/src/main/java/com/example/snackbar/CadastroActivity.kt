package com.example.snackbar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.snackbar.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.cadastro_body.*
import kotlinx.android.synthetic.main.login_body.*
import kotlinx.android.synthetic.main.login_body.edUserName

class CadastroActivity : AppCompatActivity() {

    val TAG = "CadastroActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
//        showToast("Faça o cadastro")
        var contextView = findViewById<View>(R.id.home)

        btnCadastrar.setOnClickListener() {
            getInformationUserCadastro()
        }
    }


    fun callActivity(){
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun getInformationUserCadastro(): Usuario {
        val userName = edUserNameC.text.toString()
        val email = edEmailC.text.toString()
        val senha1 = edPassword1C.text.toString()
        val senha2 = edPassword2C.text.toString()


        if (checkPassword(senha1, senha2)){
//            showToast("Senhas iguais")
            callActivity()
        }
        else{
//            showToast("Senhas diferentes")
            showSnackbar("As senhas não estão iguais.")
        }

            return Usuario(1, userName, senha1)
    }

    fun checkPassword(s1: String, s2: String): Boolean {
        return s1 == s2
    }


    fun showSnackbar(msg: String){
        var snack = Snackbar.make(home,msg, Snackbar.LENGTH_LONG)
        snack.setAction("ok", View.OnClickListener {
//            Log.i(TAG,"Clicando em ok")

        })

        snack.show()

    }

//    fun showToast(msg: String) {
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
//    }

}
