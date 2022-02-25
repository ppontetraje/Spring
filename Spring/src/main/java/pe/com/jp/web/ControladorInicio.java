package pe.com.jp.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.jp.Service.PersonaService;
import pe.com.jp.domain.Persona;


@Controller
@Slf4j
public class ControladorInicio {
   @Autowired //injecta la interface en el controlador para utilizar los métodos principales de CRUD
   private PersonaService personaService;
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listaPersonas();
        log.info("Ejecutando el controlador SPRING MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarpersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}