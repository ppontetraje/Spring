
package pe.com.jp.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.jp.dao.PersonaDao;
import pe.com.jp.domain.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaDao personaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional()
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional()
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarpersona(Persona persona) {
        return personaDao.findById(persona.getId_persona()).orElse(null);
    }
    
}
