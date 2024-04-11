package br.com.book.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.book.entidades.Entidade;



@Repository
public interface LivroRepository extends JpaRepository<Entidade, Long>{
   public List<Entidade> findByTitulo(String titulo);
}
