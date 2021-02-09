package persson.berthie2.foodme.data

import kotlinx.coroutines.flow.Flow
import persson.berthie2.foodme.data.database.RecipesDao
import persson.berthie2.foodme.data.database.RecipesEntity
import javax.inject.Inject


class LocalDataSource @Inject constructor(
        private val recipesDao: RecipesDao
) {

    fun readDatabase(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        recipesDao.insertRecipes(recipesEntity)
    }
}