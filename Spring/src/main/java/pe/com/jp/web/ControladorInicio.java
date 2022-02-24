package pe.com.jp.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.jp.Service.PersonaService;


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
}