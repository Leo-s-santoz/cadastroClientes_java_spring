package com.login.login.controller;

import com.login.login.model.Usuario;
import com.login.login.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //servir página web
    @GetMapping("/cadastroUsuario")
    public String cadastroUsuario() {
        return "cadastro";
    }

    //cadastro
    @PostMapping("/cadastroUsuario")
    public String cadastrarUsuario(@Valid Usuario NovoUsuario, BindingResult result, Model model) {

        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("errors", result.getAllErrors());
            return "redirect:/cadastroUsuario";
        }

        System.out.println(NovoUsuario.getEmail());

        usuarioRepository.save(NovoUsuario);

        return "redirect:/login";
    }
}
