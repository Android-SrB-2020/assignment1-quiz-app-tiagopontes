package work.nbcc.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    private var questionIndex = 0
    private lateinit var questionView: TextView
    private  lateinit var nextButton: ImageButton
    private lateinit var previusButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        findViewById<TextView>(R.id.question_view).setText(questionBank[questionIndex].textResId)

        findViewById<ImageButton>(R.id.next_button).setOnClickListener{
            questionIndex = (questionIndex + 1) % 20
            findViewById<TextView>(R.id.question_view).setText(questionBank[questionIndex].textResId)
        }

        findViewById<ImageButton>(R.id.p_button).setOnClickListener{
            questionIndex = (questionIndex - 1) % 20
            findViewById<TextView>(R.id.question_view).setText(questionBank[questionIndex].textResId)
        }

        findViewById<Button>(R.id.true_button).setOnClickListener{
            if(questionBank.get(questionIndex).answer){
                val toast = Toast.makeText(applicationContext, "You are right!", Toast.LENGTH_SHORT)
                toast.show()
            }
            else
            {
                val toast = Toast.makeText(applicationContext, "You are wrong!", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        findViewById<Button>(R.id.false_button).setOnClickListener{
            if(!questionBank.get(questionIndex).answer){
                val toast = Toast.makeText(applicationContext, "You are right!", Toast.LENGTH_SHORT)
                toast.show()
            }
            else
            {
                val toast = Toast.makeText(applicationContext, "You are wrong!", Toast.LENGTH_SHORT)
                toast.show()
            }
        }


    }


}
