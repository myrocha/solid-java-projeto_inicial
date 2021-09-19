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

interface ICalculatePorcent{
    //fun setIncrease();
    fun compareLastReadjst():Boolean
    fun readjustment(increase:BigDecimal);
    fun compareReadjustment():Boolean;
    fun addInWage(): BigDecimal;

}

class Terceirizado(employee: Employee): ICalculatePorcent{

    lateinit var readjusmentPercent:BigDecimal;
    val READJUST_LIMIT ="0.4";
     val employee = employee;

   lateinit var increased: BigDecimal;

    override fun compareLastReadjst(): Boolean {
        val hoje = LocalDateTime.now();
        val meses: Long = employee.lastReadjustment.until(hoje, ChronoUnit.MONTHS)

        if(meses >6){
            return true;
        }
        return false;
    }


    override fun readjustment(increase:BigDecimal) {
        increased = increase;
        readjusmentPercent = increase.divide(employee.wage, RoundingMode.HALF_UP);

    }

    override fun compareReadjustment():Boolean {
        if (readjusmentPercent.compareTo(BigDecimal(READJUST_LIMIT)) > 0) {
            return false;
            throw ValidationException("Reajuste nao pode ser superior a 40% do salario!")
        }
        return true;
    }

    override fun addInWage():BigDecimal {
        if(compareReadjustment() && compareLastReadjst()){
           return employee.wage.add(increased);
        }
        return BigDecimal(0);
    }

}

class CLT(employee: Employee): ICalculatePorcent{

    lateinit var readjusmentPercent:BigDecimal;

    val READJUST_LIMIT ="0.4";

    val employee = employee;

    lateinit var increased: BigDecimal;
    override fun compareLastReadjst(): Boolean {
        val hoje = LocalDateTime.now();
        val meses: Long = employee.lastReadjustment.until(hoje, ChronoUnit.MONTHS)

        if(meses >6){
            return true;
        }
        return false;
    }

    override fun readjustment(increase:BigDecimal) {
        increased = increase;
        readjusmentPercent = increase.divide(employee.wage, RoundingMode.HALF_UP);

    }

    override fun compareReadjustment():Boolean {
        if (readjusmentPercent.compareTo(BigDecimal(READJUST_LIMIT)) > 0) {
            return false;
            throw ValidationException("Reajuste nao pode ser superior a 40% do salario!")
        }
        return true;
    }

    override fun addInWage():BigDecimal {
        if(compareReadjustment() && compareLastReadjst()){
            return employee.wage.add(increased);
        }
        return BigDecimal(0);
    }

}

fun main() {
    val temp = Employee("Isa","xxxx",EmployeePositionEnum.ANALISTA,BigDecimal(2000), LocalDate.now())
    val perm = Employee("Bel","xxxx",EmployeePositionEnum.ESPECIALISTA,BigDecimal(4000), LocalDate.now())

    val terc = Terceirizado(temp);
    val clt = CLT(perm);

    terc.readjustment(BigDecimal(0.3));
    terc.addInWage();

    clt.readjustment(BigDecimal(0.4));
    clt.addInWage();
}