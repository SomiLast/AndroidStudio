package com.example.a1lab_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Находим элементы интерфейса
        val ageInput = findViewById<EditText>(R.id.editTextText)
        val checkAgeButton = findViewById<Button>(R.id.button)
        val messageTextView = findViewById<TextView>(R.id.textViewMessage)

        // Устанавливаем обработчик нажатия на кнопку
        checkAgeButton.setOnClickListener {
            // Получаем введенное значение и проверяем его
            val ageText = ageInput.text.toString()
            val age = ageText.toIntOrNull()

            if (age != null) {
                // Проверяем возраст с помощью if-else
                val message = when {
                    age <= 20 -> "Вы слишком молоды!"
                    age == 30 || age == 40 || age == 50 || age == 60 -> "Поздравляем с повышением!"
                    age == 65 -> "Преподносим вам золотые часы!"
                    age > 65 -> "Вы слишком стары!"
                    else -> "Продолжайте накапливать опыт!"
                }

                // Выводим сообщение в TextView
                messageTextView.text = message
            } else {
                // Если возраст не введен или введен неправильно
                messageTextView.text = "Пожалуйста, введите корректный возраст!"
            }
        }
    }
}