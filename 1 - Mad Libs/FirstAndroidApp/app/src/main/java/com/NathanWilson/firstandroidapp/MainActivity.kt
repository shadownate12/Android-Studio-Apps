package com.NathanWilson.firstandroidapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.text.TextRunShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Text View
        val textView = TextView(this)
        val textView2 = TextView(this)
        val textView3 = TextView(this)
        val textView4 = TextView(this)
        val textView5 = TextView(this)
        val storyBody = TextView(this)
        textView.setText("Enter a Name")
        //textView.setBackgroundColor(Color.BLUE)

        //Edit Text
        val firstText = EditText(this)
        LinearLayout.LayoutParams(100, 100)

        textView2.setText("Enter an adjective")
        val secondText = EditText(this)
        LinearLayout.LayoutParams(100, 100)

        textView3.setText("Enter a place")
        val thirdText = EditText(this)
        LinearLayout.LayoutParams(100, 100)

        textView4.setText("Enter a noun")
        val fourthText = EditText(this)
        LinearLayout.LayoutParams(100, 100)

        textView5.setText("Enter a season")
        val fifthText = EditText(this)
        LinearLayout.LayoutParams(100, 100)

        //Message View
        val messageView = TextView(this)
        val messageView2 = TextView(this)
        val messageView3 = TextView(this)
        val messageView4 = TextView(this)
        val messageView5 = TextView(this)




        //Story

        //Layout Stuff
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        //Button Magic
        val button = Button(this)
        button.text = "Generate Your Story!"

        button.setOnClickListener{
            messageView.text = firstText.text
            messageView2.text = secondText.text
            messageView3.text = thirdText.text
            messageView4.text = fourthText.text
            messageView5.text = fifthText.text

            storyBody.setText("" + firstText.text + " was walking down the road one day when they saw a " + secondText.text.toString() + " "
                    + messageView4.text + ". " + "It reminded them of " + messageView3.text + " in " + messageView5.text + ".")

            layout.addView(storyBody)
            /* val messageView = TextView()
            messageView.setText("Hey," + firstText + "Welcome to our App!") */

        }
        layout.addView(textView)
        layout.addView(firstText)

        layout.addView(textView2)
        layout.addView(secondText)

        layout.addView(textView3)
        layout.addView(thirdText)

        layout.addView(textView4)
        layout.addView(fourthText)

        layout.addView(textView5)
        layout.addView(fifthText)



        layout.addView(button)
        setContentView(layout)


    }
}
