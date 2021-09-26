package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.Usuario;
import br.com.fiap.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("buscar")
    public String buscar(String nomeBusca, Model model ){
        model.addAttribute("usuarios", usuarioRepository.findByNomeContainsIgnoreCase(nomeBusca));
        return "usuario/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuario/lista";
    }


    @PostMapping("cadastrar")
    public String cadastrar(Usuario usuario, RedirectAttributes redirect){
        usuarioRepository.save(usuario);
        redirect.addFlashAttribute("msg", "Cadastrado");
	return "usuario/lista";
    }

}
