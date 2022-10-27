package com.example.lab4

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import java.util.*

class task2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view1, Task2Fragment1())
            }
        }
    }
}

class Task2Fragment1 : Fragment() {
    private var f: Fragment? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.first_fragment, container, false)

        view.findViewById<Button>(R.id.button_add).setOnClickListener {
            if (f == null) {
                f = Task2Fragment2()
            }
        }

        view.findViewById<Button>(R.id.button_delete).setOnClickListener {
            if (f != null) {
                parentFragmentManager.commit {
                    remove(f!!)
                }
                f = null
            }
        }

        view.findViewById<Button>(R.id.button_next).setOnClickListener {
            if (f != null) {
                parentFragmentManager.commit {
                    replace(R.id.fragment_container_view1, f!!)
                    addToBackStack(null)
                }
            }
        }

        return view
    }
}

class Task2Fragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.second_fragment, container, false)

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}