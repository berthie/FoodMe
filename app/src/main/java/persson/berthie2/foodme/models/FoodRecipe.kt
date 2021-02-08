package persson.berthie2.foodme.models

import com.google.gson.annotations.SerializedName

data class FoodRecipe(
        @SerializedName("results")
        val results: List<Result>
)
