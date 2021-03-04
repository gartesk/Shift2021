package ru.ftc.bender.shift2021.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ru.ftc.bender.shift2021.R
import ru.ftc.bender.shift2021.domain.Person


class DetailActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val viewModel: DetailViewModel by viewModels {
        val id = intent.getLongExtra(EXTRA_ID, DetailViewModel.CREATION)
        DetailViewModelFactory(id)
    }

    private lateinit var nameText: EditText
    private lateinit var surnameText: EditText
    private lateinit var occupationInput: EditText
    private lateinit var ageText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initViews()

        viewModel.person.observe(this, ::renderPersonDetailsState)
        viewModel.closeScreenEvent.observe(this) { closeScreen() }
    }

    private fun renderPersonDetailsState(person: Person) {
        nameText.inputType = EditorInfo.TYPE_NULL
        surnameText.inputType = EditorInfo.TYPE_NULL
        occupationInput.inputType = EditorInfo.TYPE_NULL
        ageText.inputType = EditorInfo.TYPE_NULL
        saveButton.isVisible = false

        nameText.setText(getString(R.string.name_format, person.name))
        surnameText.setText(getString(R.string.surname_format, person.surname))
        occupationInput.setText(person.occupation ?: getString(R.string.occupation_absent))
        ageText.setText(person.age.toString())
    }

    private fun initViews() {
        nameText = findViewById(R.id.nameText)
        surnameText = findViewById(R.id.surnameText)
        occupationInput = findViewById(R.id.occupationInput)
        ageText = findViewById(R.id.ageText)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            viewModel.createPerson(
                nameText.text.toString(),
                surnameText.text.toString(),
                ageText.text.toString().toInt(),
                occupationInput.text.toString(),
            )
        }
    }

    private fun closeScreen() {
        finish()
    }

}