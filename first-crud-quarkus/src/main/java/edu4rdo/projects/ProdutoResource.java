package edu4rdo.projects;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarTodosProtudos(){
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void adicionarProdutos(CadastrarProdutoDTO dto){
        Produto produto = new Produto();
        produto.nome = dto.nome;
        produto.valor = dto.valor;
        produto.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void editarProtudo(@PathParam("id") Long id, CadastrarProdutoDTO dto){
        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);
        if(produtoOptional.isPresent()){
            Produto produto = produtoOptional.get();
            produto.valor = dto.valor;
            produto.nome = dto.nome;
            produto.persist();
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("{id}")
        @Transactional
    public void removerProduto(@PathParam("id") Long id){
        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);
        produtoOptional.ifPresentOrElse(Produto::delete, () -> {
            throw new NotFoundException();
        });
    }

}
