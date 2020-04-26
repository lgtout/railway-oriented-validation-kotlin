/* gakshintala created on 4/12/20 */
package app.imperative

import app.common.MAX_DAYS_TO_HATCH
import app.common.MAX_DAYS_TO_SHIP
import app.common.MIN_DAYS_TO_HATCH
import app.domain.Color
import app.domain.Condition
import app.domain.Egg
import app.domain.Yolk
import app.domain.validation.THROWABLE_NESTED_OPERATION_31
import app.domain.validation.THROWABLE_NESTED_OPERATION_32
import app.domain.validation.THROWABLE_OPERATION_2
import app.domain.validation.THROWABLE_VALIDATION_3

fun simpleOperation1(eggToBeValidated: Egg?): Boolean = eggToBeValidated != null

// These check positive cases, true = success ; false = ValidationFailure
// -----------------------|5----------------|15-------------------|21-------------------
// ----About to hatch----|------Valid-------|--Might never hatch--|--Too late to hatch--|

fun throwableOperation2(eggToBeValidated: Egg): Boolean = if (eggToBeValidated.daysToHatch >= MAX_DAYS_TO_HATCH) {
    // Unchecked Exception. Caller would have no clue of this.
    throw IllegalArgumentException(THROWABLE_OPERATION_2)
} else {
    eggToBeValidated.daysToHatch <= MIN_DAYS_TO_HATCH // Otherwise, Too late to hatch
}

fun throwableOperation3(eggToBeValidated: Egg): Boolean = if (eggToBeValidated.daysToHatch <= 0) {
    throw IllegalArgumentException(THROWABLE_VALIDATION_3)
} else {
    eggToBeValidated.daysToHatch >= MAX_DAYS_TO_SHIP // Otherwise, Might hatch too soon
}

fun throwableNestedOperation(yolkTobeValidated: Yolk?): Boolean = when {
    yolkTobeValidated == null -> throw IllegalArgumentException(THROWABLE_NESTED_OPERATION_31)
    yolkTobeValidated.condition === Condition.BAD -> throw IllegalArgumentException(THROWABLE_NESTED_OPERATION_32)
    else -> yolkTobeValidated.color === Color.GOLD || yolkTobeValidated.color === Color.YELLOW
}
