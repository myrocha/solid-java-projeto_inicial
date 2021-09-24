package br.com.hr.second

import br.com.hr.model.EmployeePositionEnum
import java.math.BigDecimal
import java.time.LocalDate

open class Employee (
    private var name:String,
    private var cpf: String,
    internal var employeePositionEnum: EmployeePositionEnum,
    internal var wage: BigDecimal,
    internal var lastReadjustment: LocalDate,
    )