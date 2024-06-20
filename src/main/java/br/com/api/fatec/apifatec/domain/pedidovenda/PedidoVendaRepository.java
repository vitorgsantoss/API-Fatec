package br.com.api.fatec.apifatec.domain.pedidovenda;

import br.com.api.fatec.apifatec.entities.PedidoVenda;
import br.com.api.fatec.apifatec.shared.dto.TotalValorPorClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long>, JpaSpecificationExecutor<PedidoVenda> {
    @Query("SELECT new br.com.api.fatec.apifatec.shared.dto.TotalValorPorClienteDto(p.cliente, SUM(p.total)) " +
            "FROM PedidoVenda p " +
            "GROUP BY p.cliente.id")
    List<TotalValorPorClienteDto> calcularTotalPorCliente();
}

