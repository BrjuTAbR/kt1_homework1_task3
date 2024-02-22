import java.util.Random

fun main() {
    val isRegularCustomer: Boolean = (Math.round(Math.random())).toInt() == 1
    val amount: Int = 100 * Random().nextInt(150)


    val AMOUNT_FOR_MIN_DISCOUNT = 1_000
    val AMOUNT_FOR_DISCOUNT = 10_000
    val MIN_DISCOUNT = 100
    val DISCOUNT = 0.05
    val DISCOUNT_FOR_REGULARS = 0.01

    val discount: Double
    val discountAmount: Int

    if (amount > AMOUNT_FOR_DISCOUNT) {
        discount =
            (if (amount > AMOUNT_FOR_DISCOUNT) DISCOUNT else 0.0) + (if (isRegularCustomer) DISCOUNT_FOR_REGULARS else 0.0)
        discountAmount = (amount * discount).toInt()
    } else {
        discount = if (isRegularCustomer) DISCOUNT_FOR_REGULARS else 0.0
        discountAmount = (amount * discount).toInt() + (if (amount > AMOUNT_FOR_MIN_DISCOUNT) MIN_DISCOUNT else 0)
    }
    val finalAmount = amount - discountAmount


    println("Сумма покупки:\t$amount р.")
    print("Скидка:")
    if (isRegularCustomer) {
        println("\n\tкак постоянному клиенту:\t${(amount * DISCOUNT_FOR_REGULARS).toInt()} р.")
        print("\tобщщая сумма скидки:\t  ")
    }
    print("\t$discountAmount р.\n")
    println("Сумма с учетом скидки:\t$finalAmount р.")
}