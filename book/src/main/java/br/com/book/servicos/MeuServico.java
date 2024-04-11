package br.com.book.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.book.entidades.Entidade;
import br.com.book.repositorio.LivroRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MeuServico {
    @Autowired
    private LivroRepository livroRepository;

    // Método para criar um livro

    public Entidade criarLivro(Entidade livro) {
        try {
            // criar um metodo que retorna um boolean, no metodo vai verificar se os campos
            // obrigatórios estão preenchidos, se sim, retorn true, se não retorna false.
            return livroRepository.save(livro);
        } catch (Exception e) {
            // Tratamento de exceção
            System.out.println("Erro ao criar livro" + e.getMessage());
            // Retorna null porde ser uma maneira simples de indicar que ocorreu um erro e
            // não foi possível retornar o valor desejado.
        }
        return null;
    }

    // Método para atualizar um livro existente
    public Entidade atualizaLivro(Entidade livro) {
        try {
            return livroRepository.save(livro);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar livro" + e.getMessage());
            return null;
        }
    }

    // Método para buscar livro pelo ID
    public Optional<Entidade> buscarLivroPorId(long id) {
        try {
            return livroRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Erro ao buscar livro" + e.getMessage());
            return Optional.empty(); // Quando é retornado um Optional vazio é útil em situações que um método espera
                                     // um Optional, mas ele não tem valor para retornar e indica que nenhum valor
                                     // foi encontrado.
        }
    }

    // Método para listar todos os livros
    public List<Entidade> listarLivros() {
        try {
            return livroRepository.findAll();
        } catch (Exception e) {
            System.out.println("Erro ao tentar listar todos os livros" + e.getMessage());
            return null;
        }
    }

    // Método para deletar um livro pelo ID
    public void deletarLivro(long id) {
        try {
            livroRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro ao tentar deletar livro" + e.getMessage());
            // void não retorna nada
        }
    }

}
