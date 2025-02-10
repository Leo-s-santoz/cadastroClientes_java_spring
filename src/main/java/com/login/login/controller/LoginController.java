package com.login.login.controller;

import com.login.login.model.Usuario;
import com.login.login.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //servir página web
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String logarUsuario(@Valid Usuario usuario, Model model, HttpServletResponse response) {
        Usuario usuarioLogado = this.usuarioRepository.login(usuario.getEmail(), usuario.getSenha());

        if (usuarioLogado != null) {
            return "redirect:/cadastroUsuario";
        }

        model.addAttribute("erro", "Usuario inválido!");
        return "login";
    }
}
