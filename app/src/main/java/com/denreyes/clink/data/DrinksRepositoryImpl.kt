package com.denreyes.clink.data

class DrinksRepositoryImpl : DrinksRepository {
    override fun getDrinks(): List<Drink> {
        return listOf(
            Drink("17194", "White Lady", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Cocktail glass",
                "Add all ingredients into cocktail shaker filled with ice. Shake well and strain into large cocktail glass.",
                null, "Alle Zutaten in den mit Eis gefüllten Cocktailshaker geben. Gut schütteln und in ein großes Cocktailglas abseihen.",
                null, "Aggiungere tutti gli ingredienti in uno shaker pieno di ghiaccio.Shakerare bene e filtrare in una coppetta da cocktail grande.",
                null, null, "https://www.thecocktaildb.com/images/media/drink/jofsaz1504352991.jpg",
                "Gin", "Triple Sec", "Lemon Juice", null, null, null, null, null, null, null, null, null, null, null, null, "4cl", "3cl", "2cl",
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "2017-09-02 12:49:52"),

            Drink("11007", "Margarita", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Cocktail glass",
                "Rub the rim of the glass with the lime slice, then dip into the salt. Shake all ingredients with ice and strain into the glass.",
                null, "Reiben Sie den Rand des Glases mit der Limettenscheibe ab und tauchen Sie ihn dann in das Salz. Schütteln Sie alle Zutaten mit Eis und sieben Sie sie in das Glas.",
                null, "Strofina il bordo del bicchiere con la fetta di lime, quindi immergilo nel sale. Shakerare tutti gli ingredienti con ghiaccio e filtrare nel bicchiere.",
                null, null, "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                "Tequila", "Triple Sec", "Lime Juice", null, null, null, null, null, null, null, null, null, null, null, null, "5cl", "2cl", "2cl",
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "2015-08-27 16:22:19"),

            Drink("11000", "Bloody Mary", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Highball glass",
                "Stir all ingredients in a highball glass. Fill with ice cubes and garnish with a lime wedge.",
                null, "Rühren Sie alle Zutaten in einem Highball-Glas. Mit Eiswürfeln füllen und mit einer Limettenscheibe garnieren.",
                null, "Mescolare tutti gli ingredienti in un bicchiere highball. Riempire con cubetti di ghiaccio e guarnire con uno spicchio di lime.",
                null, null, "https://www.thecocktaildb.com/images/media/drink/t6caa21582485702.jpg",
                "Vodka", "Tomato Juice", "Lemon Juice", "Worcestershire Sauce", "Tabasco", "Celery", "Salt", "Pepper",
                null, null, null, null, null, null, null, "4.5cl", "9cl", "1.5cl", "2 dashes", "2 dashes", "1 stalk", "Pinch", "Pinch",
                null, null, null, null, null, null, null, null, null,  null, "2017-08-28 11:47:23"),

            Drink("14145", "Piña Colada", null, "IBA,Classic", null, "Ordinary Drink", "Unforgettables", "Alcoholic", "Cocktail glass",
                "Add all ingredients into a blender and blend until smooth. Pour into a cocktail glass and garnish with a pineapple slice.",
                null, "Alle Zutaten in einen Mixer geben und bis zur Glätte mixen. In ein Cocktailglas gießen und mit einer Ananasscheibe garnieren.",
                null, "Aggiungere tutti gli ingredienti in un frullatore e frullare fino a ottenere un composto liscio. Versare in un bicchiere da cocktail e guarnire con una fetta di ananas.",
                null, null, "https://www.thecocktaildb.com/images/media/drink/upgsue1668419912.jpg",
                "Rum", "Coconut Cream", "Pineapple Juice", null, null, null, null, null, null, null, null, null, null, null, null, "5cl", "5cl", "10cl",
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "2017-09-02 12:42:00")
        )
    }
}
