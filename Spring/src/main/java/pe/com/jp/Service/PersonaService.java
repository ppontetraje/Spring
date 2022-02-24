package pe.com.jp.Service;

import java.util.List;
import pe.com.jp.domain.Persona;

public interface PersonaService {
    public List<Persona> listaPersonas();
    public void guardar(Persona personas);
    public void eliminar (Persona persona);
    public Persona encontrarpersona(Persona persona);
}
