package br.com.hr.second

import br.com.hr.model.Employee

class Repository:IRepository {
    override fun addEmployee(employee: Employee?): Boolean? {
        return true;
    }

    override fun removeEmployee(cpf: String): Boolean? {
       return true;
    }
}