package br.com.api.fatec.apifatec;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaService;
import br.com.api.fatec.apifatec.entities.PedidoVenda;
import br.com.api.fatec.apifatec.entities.PedidoVendaItem;
import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;

import br.com.api.fatec.apifatec.entities.Produto;

@SpringBootApplication
public class ApiFatecApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository,
								 @Autowired ProdutoRepository produtoRepository,
								 @Autowired PedidoVendaRepository pedidoVendaRepository
								 ) {
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Danilo");
			cliente.setEmail("h2danilofatec@hotmail.com");
			cliente.setEndereco("Rua xxx, 126");
			cliente.setRazaoSocial("Danilo");
			clienteRepository.save(cliente);
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Arthur");
			cliente2.setEmail("h2danilosfatec@hotmail.com");
			cliente2.setEndereco("Rua xxx, 126");
			cliente2.setRazaoSocial("Arthur");
			clienteRepository.save(cliente2);

			Cliente cliente3 = new Cliente();
			cliente3.setNome("Maria");
			cliente3.setEmail("maria@email.com");
			cliente3.setEndereco("Rua Y, 123");
			cliente3.setRazaoSocial("Maria LTDA");
			clienteRepository.save(cliente3);

			Cliente cliente4 = new Cliente();
			cliente4.setNome("José");
			cliente4.setEmail("jose@email.com");
			cliente4.setEndereco("Av. Principal, 456");
			cliente4.setRazaoSocial("José & Cia");
			clienteRepository.save(cliente4);

			Cliente cliente5 = new Cliente();
			cliente5.setNome("Ana");
			cliente5.setEmail("ana@email.com");
			cliente5.setEndereco("Rua Z, 789");
			cliente5.setRazaoSocial("Ana Silva ME");
			clienteRepository.save(cliente5);

			Cliente cliente6 = new Cliente();
			cliente6.setNome("Pedro");
			cliente6.setEmail("pedro@email.com");
			cliente6.setEndereco("Av. Central, 987");
			cliente6.setRazaoSocial("Pedro Comércio");
			clienteRepository.save(cliente6);

			Cliente cliente7 = new Cliente();
			cliente7.setNome("Carla");
			cliente7.setEmail("carla@email.com");
			cliente7.setEndereco("Rua W, 654");
			cliente7.setRazaoSocial("Carla e Filhos Ltda");
			clienteRepository.save(cliente7);
			
			Produto produto = new Produto();
			produto.setDescricao("teste");
			produto.setPreco(new BigDecimal(100));
			produto.setAtivo("SIM");
			produto.setQuantidadeEstoque(null);
			produtoRepository.save(produto);

			Produto produto1 = new Produto();
			produto1.setDescricao("Produto 1");
			produto1.setPreco(new BigDecimal(50));
			produto1.setAtivo("SIM");
			produto1.setQuantidadeEstoque(100);
			produtoRepository.save(produto1);

			Produto produto2 = new Produto();
			produto2.setDescricao("Produto 2");
			produto2.setPreco(new BigDecimal(70));
			produto2.setAtivo("SIM");
			produto2.setQuantidadeEstoque(80);
			produtoRepository.save(produto2);

			Produto produto3 = new Produto();
			produto3.setDescricao("Produto 3");
			produto3.setPreco(new BigDecimal(120));
			produto3.setAtivo("SIM");
			produto3.setQuantidadeEstoque(60);
			produtoRepository.save(produto3);

			Produto produto4 = new Produto();
			produto4.setDescricao("Produto 4");
			produto4.setPreco(new BigDecimal(90));
			produto4.setAtivo("SIM");
			produto4.setQuantidadeEstoque(70);
			produtoRepository.save(produto4);

			Produto produto5 = new Produto();
			produto5.setDescricao("Produto 5");
			produto5.setPreco(new BigDecimal(80));
			produto5.setAtivo("SIM");
			produto5.setQuantidadeEstoque(85);
			produtoRepository.save(produto5);

			Produto produto6 = new Produto();
			produto6.setDescricao("Produto 6");
			produto6.setPreco(new BigDecimal(60));
			produto6.setAtivo("SIM");
			produto6.setQuantidadeEstoque(95);
			produtoRepository.save(produto6);
			
			PedidoVenda ped = new PedidoVenda();
			ped.setCliente(cliente2);
			ped.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			LocalDate data = LocalDate.now();
			ped.setEmissao(data);

			//Instanciando PedidoVendaItem na variavel item1
			PedidoVendaItem item1 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item1.setProduto(produto);
			item1.setQuantidade(10);
			item1.setValorUnitario(new BigDecimal(10));
			item1.setValorTotal(item1.getValorUnitario().multiply(BigDecimal.valueOf(item1.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped.addItem(item1);

			//Instanciando PedidoVendaItem na variavel item2
			PedidoVendaItem item2 = new PedidoVendaItem();

			//Inserindo valores nas propriedades de PedidoVendaItem
			item2.setProduto(produto);
			item2.setQuantidade(10);
			item2.setValorUnitario(new BigDecimal(10));
			item2.setValorTotal(item2.getValorUnitario().multiply(BigDecimal.valueOf(item2.getQuantidade())));

			//Adicionando Item no Pedido Venda
			ped.addItem(item2);

			//Calculando total dos itens do Pedido Venda
			ped.setTotal();

			//Salvando Pedido Venda
			pedidoVendaRepository.save(ped);

			// Pedido de Venda 1 para cliente2
			PedidoVenda ped1 = new PedidoVenda();
			ped1.setCliente(cliente2);
			ped1.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			ped1.setEmissao(LocalDate.now());

			// Item 1 do Pedido 1
			PedidoVendaItem item1_1 = new PedidoVendaItem();
			item1_1.setProduto(produto);
			item1_1.setQuantidade(10);
			item1_1.setValorUnitario(new BigDecimal(10));
			item1_1.setValorTotal(item1_1.getValorUnitario().multiply(BigDecimal.valueOf(item1_1.getQuantidade())));
			ped1.addItem(item1_1);

			// Item 2 do Pedido 1
			PedidoVendaItem item1_2 = new PedidoVendaItem();
			item1_2.setProduto(produto);
			item1_2.setQuantidade(10);
			item1_2.setValorUnitario(new BigDecimal(10));
			item1_2.setValorTotal(item1_2.getValorUnitario().multiply(BigDecimal.valueOf(item1_2.getQuantidade())));
			ped1.addItem(item1_2);

			// Calculando total dos itens do Pedido 1
			ped1.setTotal();

			// Salvando Pedido 1
			pedidoVendaRepository.save(ped1);

			// Pedido de Venda 2 para cliente3
			PedidoVenda ped2 = new PedidoVenda();
			ped2.setCliente(cliente3);
			ped2.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			ped2.setEmissao(LocalDate.now());

			// Item 1 do Pedido 2
			PedidoVendaItem item2_1 = new PedidoVendaItem();
			item2_1.setProduto(produto);
			item2_1.setQuantidade(5);
			item2_1.setValorUnitario(new BigDecimal(15));
			item2_1.setValorTotal(item2_1.getValorUnitario().multiply(BigDecimal.valueOf(item2_1.getQuantidade())));
			ped2.addItem(item2_1);

			// Item 2 do Pedido 2
			PedidoVendaItem item2_2 = new PedidoVendaItem();
			item2_2.setProduto(produto);
			item2_2.setQuantidade(8);
			item2_2.setValorUnitario(new BigDecimal(12));
			item2_2.setValorTotal(item2_2.getValorUnitario().multiply(BigDecimal.valueOf(item2_2.getQuantidade())));
			ped2.addItem(item2_2);

			// Calculando total dos itens do Pedido 2
			ped2.setTotal();

			// Salvando Pedido 2
			pedidoVendaRepository.save(ped2);

			// Pedido de Venda 3 para cliente4
			PedidoVenda ped3 = new PedidoVenda();
			ped3.setCliente(cliente4);
			ped3.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			ped3.setEmissao(LocalDate.now());

// Item 1 do Pedido 3
			PedidoVendaItem item3_1 = new PedidoVendaItem();
			item3_1.setProduto(produto);
			item3_1.setQuantidade(7);
			item3_1.setValorUnitario(new BigDecimal(20));
			item3_1.setValorTotal(item3_1.getValorUnitario().multiply(BigDecimal.valueOf(item3_1.getQuantidade())));
			ped3.addItem(item3_1);

// Item 2 do Pedido 3
			PedidoVendaItem item3_2 = new PedidoVendaItem();
			item3_2.setProduto(produto);
			item3_2.setQuantidade(12);
			item3_2.setValorUnitario(new BigDecimal(8));
			item3_2.setValorTotal(item3_2.getValorUnitario().multiply(BigDecimal.valueOf(item3_2.getQuantidade())));
			ped3.addItem(item3_2);

// Calculando total dos itens do Pedido 3
			ped3.setTotal();

// Salvando Pedido 3
			pedidoVendaRepository.save(ped3);

// Pedido de Venda 4 para cliente5
			PedidoVenda ped4 = new PedidoVenda();
			ped4.setCliente(cliente5);
			ped4.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			ped4.setEmissao(LocalDate.now());

// Item 1 do Pedido 4
			PedidoVendaItem item4_1 = new PedidoVendaItem();
			item4_1.setProduto(produto);
			item4_1.setQuantidade(15);
			item4_1.setValorUnitario(new BigDecimal(18));
			item4_1.setValorTotal(item4_1.getValorUnitario().multiply(BigDecimal.valueOf(item4_1.getQuantidade())));
			ped4.addItem(item4_1);

// Item 2 do Pedido 4
			PedidoVendaItem item4_2 = new PedidoVendaItem();
			item4_2.setProduto(produto);
			item4_2.setQuantidade(5);
			item4_2.setValorUnitario(new BigDecimal(25));
			item4_2.setValorTotal(item4_2.getValorUnitario().multiply(BigDecimal.valueOf(item4_2.getQuantidade())));
			ped4.addItem(item4_2);

// Calculando total dos itens do Pedido 4
			ped4.setTotal();

// Salvando Pedido 4
			pedidoVendaRepository.save(ped4);

// Pedido de Venda 5 para cliente6
			PedidoVenda ped5 = new PedidoVenda();
			ped5.setCliente(cliente6);
			ped5.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			ped5.setEmissao(LocalDate.now());

// Item 1 do Pedido 5
			PedidoVendaItem item5_1 = new PedidoVendaItem();
			item5_1.setProduto(produto);
			item5_1.setQuantidade(20);
			item5_1.setValorUnitario(new BigDecimal(12));
			item5_1.setValorTotal(item5_1.getValorUnitario().multiply(BigDecimal.valueOf(item5_1.getQuantidade())));
			ped5.addItem(item5_1);

// Item 2 do Pedido 5
			PedidoVendaItem item5_2 = new PedidoVendaItem();
			item5_2.setProduto(produto);
			item5_2.setQuantidade(3);
			item5_2.setValorUnitario(new BigDecimal(30));
			item5_2.setValorTotal(item5_2.getValorUnitario().multiply(BigDecimal.valueOf(item5_2.getQuantidade())));
			ped5.addItem(item5_2);

// Calculando total dos itens do Pedido 5
			ped5.setTotal();

// Salvando Pedido 5
			pedidoVendaRepository.save(ped5);

// Pedido de Venda 6 para cliente7
			PedidoVenda ped6 = new PedidoVenda();
			ped6.setCliente(cliente7);
			ped6.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
			ped6.setEmissao(LocalDate.now());

// Item 1 do Pedido 6
			PedidoVendaItem item6_1 = new PedidoVendaItem();
			item6_1.setProduto(produto);
			item6_1.setQuantidade(8);
			item6_1.setValorUnitario(new BigDecimal(22));
			item6_1.setValorTotal(item6_1.getValorUnitario().multiply(BigDecimal.valueOf(item6_1.getQuantidade())));
			ped6.addItem(item6_1);

// Item 2 do Pedido 6
			PedidoVendaItem item6_2 = new PedidoVendaItem();
			item6_2.setProduto(produto);
			item6_2.setQuantidade(10);
			item6_2.setValorUnitario(new BigDecimal(15));
			item6_2.setValorTotal(item6_2.getValorUnitario().multiply(BigDecimal.valueOf(item6_2.getQuantidade())));
			ped6.addItem(item6_2);

// Calculando total dos itens do Pedido 6
			ped6.setTotal();

// Salvando Pedido 6
			pedidoVendaRepository.save(ped6);

		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}
}
