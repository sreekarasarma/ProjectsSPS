package com.example.alertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.io.File

class AlertDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())


        builder.setMessage("Are you sure you want to delete this media?")
            .setPositiveButton("Yes") { _, _ ->

                eraseMedia()
            }
            .setNegativeButton("No") { dialog, _ ->

                dialog.dismiss()
            }

        return builder.create()
    }


    private fun eraseMedia() {
        val file = File(requireContext().filesDir, "media_file.txt")

        if (file.exists()) {

            val isDeleted = file.delete()
            if (isDeleted) {
                Toast.makeText(requireContext(), "Media erased!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Failed to erase media!", Toast.LENGTH_SHORT).show()
            }
        } else {

            Toast.makeText(requireContext(), "No media found to erase!", Toast.LENGTH_SHORT).show()
        }
    }
}

