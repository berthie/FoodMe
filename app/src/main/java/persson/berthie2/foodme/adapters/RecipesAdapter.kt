package persson.berthie2.foodme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import persson.berthie2.foodme.databinding.RecipesRowLayoutBinding
import persson.berthie2.foodme.models.FoodRecipe
import persson.berthie2.foodme.models.Result
import persson.berthie2.foodme.utils.RecipesDifUtils

class RecipesAdapter: RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    private var recipes = emptyList<Result>()

    class MyViewHolder(private val binding: RecipesRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind (result: Result) {
            binding.result = result
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRecipe = recipes[position]
        holder.bind(currentRecipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun setData(newData: FoodRecipe) {
        val recipeDiffUtil = RecipesDifUtils(recipes, newData.results)
        val diffUtilsResult = DiffUtil.calculateDiff(recipeDiffUtil)
        recipes = newData.results
        diffUtilsResult.dispatchUpdatesTo(this)
    }


}