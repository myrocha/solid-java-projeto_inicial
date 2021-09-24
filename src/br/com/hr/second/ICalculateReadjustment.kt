package br.com.hr.second

import java.math.BigDecimal

interface ICalculateReadjustment {

    fun newWage(wage:BigDecimal, increase:BigDecimal);
}