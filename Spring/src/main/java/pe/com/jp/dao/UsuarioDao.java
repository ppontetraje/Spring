package pe.com.jp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.jp.domain.Usuario;

public interface UsuarioDao  extends JpaRepository<Usuario,Long>{
    Usuario findByUserName(String username);
}
