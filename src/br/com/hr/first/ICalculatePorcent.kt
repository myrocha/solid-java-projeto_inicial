package br.com.hr.first

import java.math.BigDecimal

interface ICalculatePorcent {
    fun compareLastReadjst():Boolean
    fun readjustment(increase: BigDecimal);
    fun compareReadjustment():Boolean;
    fun addInWage(): BigDecimal;

}