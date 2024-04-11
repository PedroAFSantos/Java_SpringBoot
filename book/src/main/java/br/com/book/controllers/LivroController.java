package br.com.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.book.entidades.Entidade;
import br.com.book.servicos.MeuServico;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("biblioteca")
public class LivroController {

    @Autowired 
    private MeuServico meuServico; //Injeção de depedência de MeuServico => meuServico podendo utilizar as funções;

    //Método de cadastro de um livro
    @PostMapping("/livro")
    public ResponseEntity<Entidade> cadastrarLivro(@RequestBody Entidade livro) {
        Entidade livroSalvo = meuServico.criarLivro(livro); //livroSalvo tem o papel de armazenar o objeto Entidade retornado pela func criarLivro()
        return ResponseEntity.ok().body(livroSalvo);
    }

    //Método para alterar um livro existente
    @PutMapping("/livro/{idLivro}")
    public ResponseEntity<Entidade> atualizarLivro(@PathVariable long idLivro, @RequestBody Entidade livro) {
        livro.setId(idLivro);//Define o ID do livro com base na URL
        Entidade livroAtualizado = meuServico.atualizaLivro(livro);
        return ResponseEntity.ok(livroAtualizado);
    }

    //Método para exclusão de livro existente
    @DeleteMapping("/livro/{idLivro}")
    public ResponseEntity<Void> excluirLivro(@PathVariable long idLivro) {
        meuServico.deletarLivro(idLivro);
        return ResponseEntity.noContent().build();
    }

    //Método de buscar um livro apenas
    @GetMapping("/livro/{idLivro}")
    public ResponseEntity<Entidade> buscaLivroPorId(@PathVariable Long idLivro) {
        Optional<Entidade> livro = meuServico.buscarLivroPorId(idLivro);
        return livro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); //Busca o livro se achar trás, se não traz o Opitional vazio
    }


    //Método para listar todos os livros
    @GetMapping("/livros")
    public ResponseEntity<List<Entidade>> listarLivros() {
        List<Entidade> livros = meuServico.listarLivros();
        return ResponseEntity.ok(livros);
    }

 }
