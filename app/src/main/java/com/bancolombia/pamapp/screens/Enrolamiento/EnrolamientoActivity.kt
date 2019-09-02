package com.bancolombia.pamapp.screens.Enrolamiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bancolombia.pamapp.R
import kotlinx.android.synthetic.main.activity_enrolamiento.*

class EnrolamientoActivity : AppCompatActivity() {
    private lateinit var enrolVM:EnrolamientoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enrolamiento)
        enrolVM=ViewModelProviders.of(this).get(EnrolamientoViewModel::class.java)
        buttonIngresar.setOnClickListener {
            enrolVM.login(editTextUser.text.toString(),editTextPassword.text.toString())
        }
        adbObserver()
    }

    private fun adbObserver(){
        val observer= Observer<String>{
                valor->
            if (valor!=null){
                when(valor){
                    "UserEmpty"->editTextUser.error="Usuario invalido"
                    "PasswordEmpty"->editTextPassword.error="Contraseña invalida"
                    "Ready"->editTextPassword.error="Ha accedido correctamente"
                }
            }
        }
        enrolVM.devolucion.observe(this,observer)
    }

}
