package persson.berthie2.foodme.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import persson.berthie2.foodme.models.FoodRecipe
import persson.berthie2.foodme.utils.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
        var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}