package alura.com.br.calculanotaskotlin

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = calcular
        val resultado = textResultado

        btnCalcular.setOnClickListener {

            var notaUm = (nota1.text.toString()).toDouble()
            var notadois = (nota1.text.toString()).toDouble()
            var notatres = (nota1.text.toString()).toDouble()
            var notaquatro = (nota1.text.toString()).toDouble()
            val media =  (notaUm+notadois+notatres+notaquatro)/4

            if (media >=7){
                resultado.setText("Aluno foi aprovado! \nNota final:  $media")
                resultado.setTextColor(Color.GREEN)
            }else if (media > 5 && media < 7){
                resultado.setText("Aluno ficou em recuperação! \nNota final:  $media")
                resultado.setTextColor(Color.YELLOW)
            }else{
                resultado.setText("Aluno foi reprovado! \nNota final:  $media")
                resultado.setTextColor(Color.RED)
            }

            closeKeyBoard()
            nota1.setText("")
            nota2.setText("")
            nota3.setText("")
            nota4.setText("")

        }

    }

    private fun closeKeyBoard() {
        val view: View? = currentFocus
        view?.let {
            val imm:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken,0)
        }
    }
}