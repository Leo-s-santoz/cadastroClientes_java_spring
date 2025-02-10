package com.login.login.controller;

import com.login.login.model.Usuario;
import com.login.login.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastroUsuario")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/login")
    public String logarUsuario(Usuario usuario, Model model, HttpServletResponse response) {
        Usuario usuarioLogado = this.usuarioRepository.login(usuario.getEmail(), usuario.getSenha());

        if (usuarioLogado != null) {
            return "redirect:/cadastroUsuario";
        }

        model.addAttribute("erro", "Usuario inválido!");
        return "login";
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
