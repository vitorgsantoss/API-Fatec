package br.com.api.fatec.apifatec.shared.dto;

import br.com.api.fatec.apifatec.entities.Cliente;

import java.math.BigDecimal;

public class TotalValorPorClienteDto {

    private Cliente cliente;
    private BigDecimal total;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public TotalValorPorClienteDto(Cliente cliente, BigDecimal total){
        this.cliente = cliente;
        this.total = total;

    }
}
