package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class task1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, NewFragment())
                addToBackStack(null)
            }
        }
    }
}

class NewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_task1, container, false)

        val nextButton = view.findViewById<Button>(R.id.button6)
        val backButton = view.findViewById<Button>(R.id.button5)
        val textView = view.findViewById<TextView>(R.id.textView)

        textView.text = "Stack size = " + parentFragmentManager.backStackEntryCount

        nextButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, NewFragment())
                addToBackStack(null)
            }
        }

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return view
    }
}
