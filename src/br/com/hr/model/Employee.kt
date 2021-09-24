package br.com.hr.model

import br.com.hr.ValidationException
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

/*class Employee(private var name: String, var cpf: String, private var employeePositionEnum: EmployeePositionEnum, private var wage: BigDecimal) {

    var lastReadjustmentDate: LocalDate? = null

    fun salaryReadjustment(increase: BigDecimal) {
        val readjustmentPercentage = increase.divide(wage, RoundingMode.HALF_UP)
        if (readjustmentPercentage.compareTo(BigDecimal("0.4")) > 0) {
            throw ValidationException("Reajuste nao pode ser superior a 40% do salario!")
        }
        wage = wage.add(increase)
        lastReadjustmentDate = LocalDate.now()
    }


}*/
open class Employee (
    private var name:String,
    private var cpf: String,
    internal var employeePositionEnum: EmployeePositionEnum,
    internal var wage: BigDecimal,
    internal var lastReadjustment: LocalDate,

    )

fun main() {
    /*val temp = Employee("Isa","xxxx",EmployeePositionEnum.ANALISTA,BigDecimal(2000), LocalDate.now())
    val perm = Employee("Bel","xxxx",EmployeePositionEnum.ESPECIALISTA,BigDecimal(4000), LocalDate.now())

    val terc = Terceirizado(temp);
    val clt = CLT(perm);

    terc.readjustment(BigDecimal(0.3));
    terc.addInWage();

    clt.readjustment(BigDecimal(0.4));
    clt.addInWage();*/
}