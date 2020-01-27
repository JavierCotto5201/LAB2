package com.example.laboratorio2

//Se importan las librerias a utilizar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import androidx.annotation.VisibleForTesting
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
    var cont = 0 //Variable para utilizar contador
    var res = 20 //Variable para realizar una resta entre este dato y el contador
    var respu=""//Variable para mostrar el Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Metodo para el boton, que cuando se presione; a contador se le aumente un valor y se realice la resta de res - cont
        this.BotonVuelta.setOnClickListener{
            cont++
            this.TVcontador.setText(cont.toString())
            res=20
            res=res-cont
            felicitaciones.setImageDrawable(null)

            //metodo que cuando llegue a 10 el contador, mostrara el mensaje de felicitaciones y una imagen relacionada
            if (cont==10){
                Toast.makeText(applicationContext, "¡¡¡Felicitaciones!!!", Toast.LENGTH_SHORT).show()
                felicitaciones.setImageResource(R.drawable.applab2)
            }
            //Cuando el contador sobrepase 10, se removera la imagen y le pondra un valor null
            if (cont>10){
                felicitaciones.setImageDrawable(null)
            }
            //Cuando llegue a 20 el contador, mostrara una imagen y un mensaje de que se ha logrado el objetivo
            if(cont==20){
                felicitaciones.setImageResource(R.drawable.felicitacioneslab2)
                Toast.makeText(applicationContext, "Lo Has Logrado", Toast.LENGTH_SHORT).show()
                cont=0
                res=0
            }
        }
        //Reinciar las variables cont y res a su valor original, 0 y 20 respectivamente. Tambien al TextView le asigna en su atributo text el 0
        this.BotonReiniciar.setOnClickListener{
            cont=0
            res=20
            this.TVcontador.setText("0")
            felicitaciones.setImageDrawable(null)
        }
        //Si se mantiene el boton vuelta, este mostrara un toast con las vueltas que hacen falta para el objetivo
        this.BotonVuelta.setOnLongClickListener{
            Toast.makeText(this, "Faltan " + res + " vueltas para el objetivo", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true


        }


        }
    }

