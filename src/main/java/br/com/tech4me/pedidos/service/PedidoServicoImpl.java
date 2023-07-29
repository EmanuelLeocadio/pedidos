package br.com.tech4me.pedidos.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tech4me.pedidos.model.Pedido;
import br.com.tech4me.pedidos.repository.PedidoRepository;
import br.com.tech4me.pedidos.shared.PedidoCompletoDto;
import br.com.tech4me.pedidos.shared.PedidoDto;

@Service
public class PedidoServicoImpl implements PedidoServico{
    @Autowired
    private PedidoRepository repositorio;

 @Autowired
    private PizzariaClient PizzariaClient;

@Override
    public PedidoCompletoDto CadastrarPedido(PedidoCompletoDto dto) {
        Pedido pedido = new Pedido(dto);
        repositorio.save(pedido);
        return new PedidoCompletoDto(pedido.getId(), pedido.getNomeCliente(), pedido.getIdPizza(), pedido.getValor());
    }
    @Override
    public List<PedidoCompletoDto> obterPedidos() {
        return repositorio.findAll()
            .stream()
            .map(p -> new PedidoCompletoDto(p.getId(), p.getNomeCliente(), p.getIdPizza(), p.getValor()))
            .toList();
    }

    @Override
    public Optional<PedidoDto> obterPedidosPorId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterPedidosPorId'");
    }

    @Override
    public void excluirPedido(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluirPedido'");
    }

    @Override
    public Optional<PedidoDto> atualizarPedidoPorId(String id, PedidoDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarPedidoPorId'");
    }
    
}
