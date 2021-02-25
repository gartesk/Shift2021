package ru.ftc.bender.shift2021.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.ftc.bender.shift2021.Person
import ru.ftc.bender.shift2021.R

class PeopleAdapter(private val onItemClick: (Person) -> Unit) : RecyclerView.Adapter<PersonHolder>() {

	var people: List<Person> = emptyList()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
		return PersonHolder(view, onItemClick)
	}

	override fun onBindViewHolder(holder: PersonHolder, position: Int) {
		val person = people[position]
		holder.bind(person)
	}

	override fun getItemCount(): Int = people.count()
}

class PersonHolder(itemView: View, private val onItemClick: (Person) -> Unit) : RecyclerView.ViewHolder(itemView) {

	private val nameText = itemView.findViewById<TextView>(R.id.name_text)
	private val occupationText = itemView.findViewById<TextView>(R.id.occupation_text)

	fun bind(person: Person) {
		nameText.text = itemView.context.getString(R.string.person_format, person.name, person.surname)
		occupationText.text = person.occupation ?: itemView.context.getString(R.string.occupation_absent)
		itemView.setOnClickListener { onItemClick(person) }
	}
}