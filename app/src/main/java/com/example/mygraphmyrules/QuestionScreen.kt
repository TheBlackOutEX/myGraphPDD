package com.example.mygraphmyrules

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.question_screen.*

class QuestionScreen : AppCompatActivity() {

    private var ticket = 1
    private var ticketNum = 1
    private var questions : Array<String> = arrayOf()
    private val allTime = 20 * 60000L
    private var ticketTime = 20 * 60000L
    private lateinit var countdownTimer: CountDownTimer
    var isRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.question_screen)

        init()

        btnNext.setOnClickListener {
            if (btnNext.text == "Завершить экзамен") onBackPressed()
            nextQuestion()
        }
        back_stack.setOnClickListener { onBackPressed() }
    }

    private fun init() {
        startTimer(ticketTime)

        ticket = intent.extras?.getInt("id") ?: 1
        ticketNum = intent.extras?.getInt("number") ?: 1
        questions = setTicketList(ticketNum)
        question.text = questions[ticket]
        number.text = ("Билет №$ticketNum")
    }

    private fun nextQuestion() {
        if (ticket <= 19) {
            question.text = questions[ticket]
        }
        ticket++
        if (ticket == 20) {
            btnNext.text = "Завершить экзамен"
            return
        }

    }

    private fun setTicketList(ticket : Int) : Array<String> {
        return when (ticket) {
            1 -> resources.getStringArray(R.array.ticket_1)
            2 -> resources.getStringArray(R.array.ticket_2)
            3 -> resources.getStringArray(R.array.ticket_3)
            4 -> resources.getStringArray(R.array.ticket_4)
            5 -> resources.getStringArray(R.array.ticket_5)
            6 -> resources.getStringArray(R.array.ticket_6)
            7 -> resources.getStringArray(R.array.ticket_7)
            8 -> resources.getStringArray(R.array.ticket_8)
            else -> resources.getStringArray(R.array.ticket_1)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }


    fun startTimer(time_in_seconds: Long) {
        ticketTime = time_in_seconds
        countdownTimer = object : CountDownTimer(time_in_seconds, 1000) {
            override fun onFinish() {
                ticketTime = allTime
                startTimer(allTime)
            }

            override fun onTick(p0: Long) {
                ticketTime = p0
                updateTextUI()
            }
        }
        countdownTimer.start()
        isRunning = true
    }

    fun updateTextUI() {
        val minute = (ticketTime / 1000) / 60
        val seconds = (ticketTime / 1000) % 60

        chrono.text = "$minute:$seconds"
    }
}