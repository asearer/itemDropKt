import kotlin.random.Random

// Define a data class to represent an item
data class Item(val name: String, val rarity: Int)

// Define a function to simulate dropping random items
fun dropRandomItems(enemyLevel: Int): List<Item> {
    // Define a list of possible items and their rarities
    val possibleItems = listOf(
        Item("Health Potion", 50),
        Item("Mana Potion", 40),
        Item("Gold Coin", 90),
        Item("Sword", 10),
        Item("Shield", 20)
    )

    // Initialize a list to store the dropped items
    val droppedItems = mutableListOf<Item>()

    // Determine the number of items to drop based on enemy level
    val numberOfItemsToDrop = when (enemyLevel) {
        in 1..5 -> 1
        in 6..10 -> 2
        else -> 3
    }

    // Randomly select items to drop based on rarity
    for (i in 1..numberOfItemsToDrop) {
        val randomValue = Random.nextInt(100) // Generate a random value between 0 and 99

        // Filter items based on their rarity
        val filteredItems = possibleItems.filter { item ->
            randomValue < item.rarity
        }

        // If there are filtered items, randomly select one and add it to the droppedItems list
        if (filteredItems.isNotEmpty()) {
            val randomIndex = Random.nextInt(filteredItems.size)
            droppedItems.add(filteredItems[randomIndex])
        }
    }

    return droppedItems
}

fun main() {
    val enemyLevel = 8 // Replace with the actual enemy level
    val droppedItems = dropRandomItems(enemyLevel)

    println("Dropped Items:")
    for (item in droppedItems) {
        println("${item.name} (${item.rarity} rarity)")
    }
}
