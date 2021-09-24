package br.com.hr.first

import br.com.hr.ValidationException
import br.com.hr.model.Employee
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class EmployeeReadjust (employee: Employee): ICalculatePorcent {
    lateinit var readjusmentPercent: BigDecimal;
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


    override fun readjustment(increase: BigDecimal) {
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

    override fun addInWage(): BigDecimal {
        if(compareReadjustment() && compareLastReadjst()){
            return employee.wage.add(increased);
        }
        return BigDecimal(0);
    }
}