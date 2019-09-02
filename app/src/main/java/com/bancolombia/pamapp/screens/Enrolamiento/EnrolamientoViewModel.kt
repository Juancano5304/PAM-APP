package com.bancolombia.pamapp.screens.Enrolamiento

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.telephony.TelephonyManager



class EnrolamientoViewModel(aplication:Application): AndroidViewModel(aplication){
    val state_login=MutableLiveData<String>()
    val devolucion:LiveData<String>
        get() =state_login
    lateinit var telefono:TelephonyManager
//    fun validateText(textEvaluate:String):Boolean{
//        var respuesta=true
//        if(textEvaluate.isEmpty()){
//            respuesta=false
//        }
//       return respuesta
//    }

    fun login(usuario:String,password:String){
        if(usuario.isNotEmpty()){
            if(password.isNotEmpty()){
                state_login.value="Ready"
                //ENVIAR PETICION HTTP
            }else{
                state_login.value="PasswordEmpty"
            }
        }else{
            state_login.value="UserEmpty"
        }

    }
}