package persson.berthie2.foodme.data

import persson.berthie2.foodme.data.network.FoodRecipesApi
import persson.berthie2.foodme.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor (
        private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}