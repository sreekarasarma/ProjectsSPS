package com.example.customalertdialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class CustomDialogFragment : DialogFragment() {

    // Define an interface to communicate with the Activity
    interface DialogListener {
        fun onSignIn(username: String, password: String)
        fun onSignUp()
    }

    private var listener: DialogListener? = null

    // Ensure the host activity implements the DialogListener interface
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DialogListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement DialogListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_custom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText = view.findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val signInButton = view.findViewById<Button>(R.id.signInButton)
        val signUpButton = view.findViewById<Button>(R.id.signUpButton)

        signInButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            listener?.onSignIn(username, password) // Notify the activity on SignIn
            dismiss()
        }

        signUpButton.setOnClickListener {
            listener?.onSignUp() // Notify the activity on SignUp
            dismiss()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null // Avoid memory leaks
    }
}
