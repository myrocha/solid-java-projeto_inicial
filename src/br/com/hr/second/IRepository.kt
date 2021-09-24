package br.com.hr.second

import br.com.hr.model.Employee

interface IRepository {
    fun addEmployee(employee: Employee?): Boolean?
    fun removeEmployee(cpf: String): Boolean?
}
