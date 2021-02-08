package persson.berthie2.foodme.utils

import androidx.datastore.preferences.core.preferencesOf
import androidx.recyclerview.widget.DiffUtil
import persson.berthie2.foodme.models.Result

class RecipesDifUtils(
    private val oldList: List<Result>,
    private val newList: List<Result>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}