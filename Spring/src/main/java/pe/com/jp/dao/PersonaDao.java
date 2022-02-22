package pe.com.jp.dao;

import pe.com.jp.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
    
}
