package com.denreyes.clink.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DrinkResponse(
    val drinks: List<Drink>
)

@Serializable
data class Drink(
    @SerialName("idDrink")
    val idDrink: String,
    @SerialName("strDrink")
    val strDrink: String,
    @SerialName("strDrinkThumb")
    val strDrinkThumb: String? = null,

    @SerialName("strDrinkAlternate")
    val strDrinkAlternate: String? = null,
    @SerialName("strTags")
    val strTags: String? = null,
    @SerialName("strVideo")
    val strVideo: String? = null,
    @SerialName("strCategory")
    val strCategory: String? = null,
    @SerialName("strIBA")
    val strIBA: String? = null,
    @SerialName("strAlcoholic")
    val strAlcoholic: String? = null,
    @SerialName("strGlass")
    val strGlass: String? = null,
    @SerialName("strInstructions")
    val strInstructions: String? = null,
    @SerialName("strInstructionsES")
    val strInstructionsES: String? = null,
    @SerialName("strInstructionsDE")
    val strInstructionsDE: String? = null,
    @SerialName("strInstructionsFR")
    val strInstructionsFR: String? = null,
    @SerialName("strInstructionsIT")
    val strInstructionsIT: String? = null,
    @SerialName("strInstructionsZH-HANS")
    val strInstructionsZH_HANS: String? = null,
    @SerialName("strInstructionsZH-HANT")
    val strInstructionsZH_HANT: String? = null,
    @SerialName("strIngredient1")
    val strIngredient1: String? = null,
    @SerialName("strIngredient2")
    val strIngredient2: String? = null,
    @SerialName("strIngredient3")
    val strIngredient3: String? = null,
    @SerialName("strIngredient4")
    val strIngredient4: String? = null,
    @SerialName("strIngredient5")
    val strIngredient5: String? = null,
    @SerialName("strIngredient6")
    val strIngredient6: String? = null,
    @SerialName("strIngredient7")
    val strIngredient7: String? = null,
    @SerialName("strIngredient8")
    val strIngredient8: String? = null,
    @SerialName("strIngredient9")
    val strIngredient9: String? = null,
    @SerialName("strIngredient10")
    val strIngredient10: String? = null,
    @SerialName("strIngredient11")
    val strIngredient11: String? = null,
    @SerialName("strIngredient12")
    val strIngredient12: String? = null,
    @SerialName("strIngredient13")
    val strIngredient13: String? = null,
    @SerialName("strIngredient14")
    val strIngredient14: String? = null,
    @SerialName("strIngredient15")
    val strIngredient15: String? = null,
    @SerialName("strMeasure1")
    val strMeasure1: String? = null,
    @SerialName("strMeasure2")
    val strMeasure2: String? = null,
    @SerialName("strMeasure3")
    val strMeasure3: String? = null,
    @SerialName("strMeasure4")
    val strMeasure4: String? = null,
    @SerialName("strMeasure5")
    val strMeasure5: String? = null,
    @SerialName("strMeasure6")
    val strMeasure6: String? = null,
    @SerialName("strMeasure7")
    val strMeasure7: String? = null,
    @SerialName("strMeasure8")
    val strMeasure8: String? = null,
    @SerialName("strMeasure9")
    val strMeasure9: String? = null,
    @SerialName("strMeasure10")
    val strMeasure10: String? = null,
    @SerialName("strMeasure11")
    val strMeasure11: String? = null,
    @SerialName("strMeasure12")
    val strMeasure12: String? = null,
    @SerialName("strMeasure13")
    val strMeasure13: String? = null,
    @SerialName("strMeasure14")
    val strMeasure14: String? = null,
    @SerialName("strMeasure15")
    val strMeasure15: String? = null,
    @SerialName("strImageSource")
    val strImageSource: String? = null,
    @SerialName("strImageAttribution")
    val strImageAttribution: String? = null,
    @SerialName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String? = null,
    @SerialName("dateModified")
    val dateModified: String? = null
)

fun getFakeDrink(): Drink {
    return Drink("17194", "White Lady", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Cocktail glass",
        "Add all ingredients into cocktail shaker filled with ice. Shake well and strain into large cocktail glass.",
        null, "Alle Zutaten in den mit Eis gefüllten Cocktailshaker geben. Gut schütteln und in ein großes Cocktailglas abseihen.",
        null, "Aggiungere tutti gli ingredienti in uno shaker pieno di ghiaccio.Shakerare bene e filtrare in una coppetta da cocktail grande.",
        null, null, "https://www.thecocktaildb.com/images/media/drink/juhcuu1504370685.jpg",
        "Gin", "Triple Sec", "Lemon Juice", null, null, null, null, null, null, null, null, null, null, null, null, "4cl", "3cl", "2cl",
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "2017-09-02 12:49:52"
    );
}

fun getFakeDrinks(): List<Drink> {
    return listOf(
        Drink("17194", "White Lady", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Cocktail glass",
            "Add all ingredients into cocktail shaker filled with ice. Shake well and strain into large cocktail glass.",
            null, "Alle Zutaten in den mit Eis gefüllten Cocktailshaker geben. Gut schütteln und in ein großes Cocktailglas abseihen.",
            null, "Aggiungere tutti gli ingredienti in uno shaker pieno di ghiaccio.Shakerare bene e filtrare in una coppetta da cocktail grande.",
            null, null, "https://www.thecocktaildb.com/images/media/drink/juhcuu1504370685.jpg",
            "Gin", "Triple Sec", "Lemon Juice", null, null, null, null, null, null, null, null, null, null, null, null, "4cl", "3cl", "2cl",
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "2017-09-02 12:49:52"),

        Drink("11007", "Margarita", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Cocktail glass",
            "Rub the rim of the glass with the lime slice, then dip into the salt. Shake all ingredients with ice and strain into the glass.",
            null, "Reiben Sie den Rand des Glases mit der Limettenscheibe ab und tauchen Sie ihn dann in das Salz. Schütteln Sie alle Zutaten mit Eis und sieben Sie sie in das Glas.",
            null, "Strofina il bordo del bicchiere con la fetta di lime, quindi immergilo nel sale. Shakerare tutti gli ingredienti con ghiaccio e filtrare nel bicchiere.",
            null, null, "https://www.thecocktaildb.com/images/media/drink/juhcuu1504370685.jpg",
            "Tequila", "Triple Sec", "Lime Juice", null, null, null, null, null, null, null, null, null, null, null, null, "5cl", "2cl", "2cl",
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "2015-08-27 16:22:19"),

        Drink("11000", "Bloody Mary", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Highball glass",
            "Stir all ingredients in a highball glass. Fill with ice cubes and garnish with a lime wedge.",
            null, "Rühren Sie alle Zutaten in einem Highball-Glas. Mit Eiswürfeln füllen und mit einer Limettenscheibe garnieren.",
            null, "Mescolare tutti gli ingredienti in un bicchiere highball. Riempire con cubetti di ghiaccio e guarnire con uno spicchio di lime.",
            null, null, "https://www.thecocktaildb.com/images/media/drink/juhcuu1504370685.jpg",
            "Vodka", "Tomato Juice", "Lemon Juice", "Worcestershire Sauce", "Tabasco", "Celery", "Salt", "Pepper",
            null, null, null, null, null, null, null, "4.5cl", "9cl", "1.5cl", "2 dashes", "2 dashes", "1 stalk", "Pinch", "Pinch",
            null, null, null, null, null, null, null, null, null,  null, "2017-08-28 11:47:23"),

        Drink("14145", "Piña Colada", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Cocktail glass",
            "Add all ingredients into a blender and blend until smooth. Pour into a cocktail glass and garnish with a pineapple slice.",
            null, "Alle Zutaten in einen Mixer geben und bis zur Glätte mixen. In ein Cocktailglas gießen und mit einer Ananasscheibe garnieren.",
            null, "Aggiungere tutti gli ingredienti in un frullatore e frullare fino a ottenere un composto liscio. Versare in un bicchiere da cocktail e guarnire con una fetta di ananas.",
            null, null, "https://www.thecocktaildb.com/images/media/drink/juhcuu1504370685.jpg",
            "Rum", "Coconut Cream", "Pineapple Juice", null, null, null, null, null, null, null, null, null, null, null, null, "5cl", "5cl", "10cl",
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "2017-09-02 12:42:00")
    )
}