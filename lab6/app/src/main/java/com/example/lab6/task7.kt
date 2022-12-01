package com.example.lab6

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class task7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task7)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        preferences.edit {
            putInt("count", 0)
            commit()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment, NewFragment())
                // addToBackStack(null)
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
        val view: View = inflater.inflate(R.layout.fragment_task7, container, false)

        val nextButton = view.findViewById<Button>(R.id.button_next)
        val backButton = view.findViewById<Button>(R.id.button_back)
        val textSize = view.findViewById<TextView>(R.id.stack_view)
        val textAdded = view.findViewById<TextView>(R.id.created_view)
        val textDeleted = view.findViewById<TextView>(R.id.deleted_view)

        val preferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val count = preferences.getInt("count", 0)

        textSize.text = "Stack size = " + parentFragmentManager.backStackEntryCount
        textAdded.text = "Added count = " + count.toString()
        textDeleted.text = "Deleted count = " + (count - parentFragmentManager.backStackEntryCount).toString()

        nextButton.setOnClickListener {
            preferences.edit {
                putInt("count", count + 1)
                commit()
            }
            parentFragmentManager.commit {
                replace(R.id.fragment, NewFragment())
                addToBackStack(null)
            }
        }

        backButton.setOnClickListener {
//            if (parentFragmentManager.backStackEntryCount == 1) {
//                requireActivity().finish()
//            }
            parentFragmentManager.popBackStack()
        }
        return view
    }
}