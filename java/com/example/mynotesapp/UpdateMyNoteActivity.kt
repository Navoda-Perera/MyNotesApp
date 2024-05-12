package com.example.mynotesapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mynotesapp.databinding.ActivityUpdateMyNoteBinding


class UpdateMyNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateMyNoteBinding
    private lateinit var db: MyNotesDatabasehelper
    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateMyNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MyNotesDatabasehelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if (noteId == -1){
            finish()
            return
        }

        val note = db.getNotesByID(noteId)
        binding.UpdateTitleEditText.setText(note.title)
        binding.UpdateContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener {
            val newTitle = binding.UpdateTitleEditText.text.toString()
            val newContent= binding.UpdateContentEditText.text.toString()
            val updatedNote = Mynote(noteId, newTitle, newContent)
            db.updateNote(updatedNote)
            finish()
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
        }

    }
}