import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animalinfoapp.R

data class Animal(val id: Int, val name: String, val scientificName: String, val family: String)

class AnimalAdapter(private val animals: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val scientificName: TextView = itemView.findViewById(R.id.tvScientificName)
        val family: TextView = itemView.findViewById(R.id.tvFamily)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]
        holder.name.text = animal.name
        holder.scientificName.text = animal.scientificName
        holder.family.text = animal.family
    }

    override fun getItemCount() = animals.size
}
