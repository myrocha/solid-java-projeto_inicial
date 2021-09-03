package br.com.hr.model

import java.math.BigDecimal
import java.time.LocalDate
import br.com.hr.ValidationException
import java.math.RoundingMode

class Employee(private var name: String, var cpf: String, private var employeePositionEnum: EmployeePositionEnum, private var wage: BigDecimal) {

    var lastReadjustmentDate: LocalDate? = null

    fun salaryReadjustment(increase: BigDecimal) {
        val readjustmentPercentage = increase.divide(wage, RoundingMode.HALF_UP)
        if (readjustmentPercentage.compareTo(BigDecimal("0.4")) > 0) {
            throw ValidationException("Reajuste nao pode ser superior a 40% do salario!")
        }
        wage = wage.add(increase)
        lastReadjustmentDate = LocalDate.now()
    }
}