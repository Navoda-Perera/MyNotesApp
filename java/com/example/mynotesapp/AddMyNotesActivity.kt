package com.example.mynotesapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import com.example.mynotesapp.databinding.ActivityAddMyNotesBinding

class AddMyNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMyNotesBinding
    private lateinit var db: MyNotesDatabasehelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMyNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MyNotesDatabasehelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Mynote(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Your Note Saved Succefully", Toast.LENGTH_SHORT).show()
        }

    }
}