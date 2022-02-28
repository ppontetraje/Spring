package pe.com.jp.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var personas = personaService.listaPersonas();
        log.info("Usuario que accedió a la aplicación: " + user);
        log.info("Ejecutando el controlador SPRING MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errors){
        if(errors.hasErrors()){
            return "modificar";
        }
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