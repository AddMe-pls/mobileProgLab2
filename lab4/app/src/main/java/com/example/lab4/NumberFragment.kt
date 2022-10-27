package com.example.lab4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

const val ARG_OBJ = "object"

class NumberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJ)}?.apply {
            val tasks: Array<String> = arrayOf("Monday: Do work", "Tuesday: Go walk",
                "Wednesday: Read book", "Thursday: Start teaching",
                "Friday: Go to shop", "Saturday: Relax all day", "Sunday: Do homework")

            val textView: TextView = view.findViewById(R.id.textView)
            textView.text = tasks[getInt(ARG_OBJ)]
        }
    }
}