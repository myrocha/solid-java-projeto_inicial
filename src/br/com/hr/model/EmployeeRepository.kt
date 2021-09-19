package br.com.hr.model

interface IRepository {
    fun addEmployee(employee: Employee?): Boolean?
    fun getEmployee(cpf: String): Employee?
    fun setEmployee(employee: Employee?): Boolean?
    fun removeEmployee(cpf: String): Boolean?
}
class EmployeeRepository {

}