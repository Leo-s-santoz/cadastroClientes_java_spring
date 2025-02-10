package com.login.login.controller;

import com.login.login.model.Usuario;
import com.login.login.repository.UsuarioRepository;
import com.login.login.service.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.UnsupportedEncodingException;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //servir página web
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
        return "index";
    }

    @PostMapping("/login")
    public String logarUsuario(Usuario usuario, Model model, HttpServletResponse response) throws Exception {
        Usuario usuarioLogado = this.usuarioRepository.login(usuario.getEmail(), usuario.getSenha());

        if (usuarioLogado != null) {
            CookieService.setCookie(response, "tipoUsuario", String.valueOf(usuarioLogado.getTipo()), 10000);
            CookieService.setCookie(response, "usuarioNome", String.valueOf(usuarioLogado.getNome()), 10000);
            return "redirect:/gestaoClientes";
        }

        model.addAttribute("erro", "Usuario inválido!");
        return "login";
    }

    @GetMapping("/sair")
    public String sair(HttpServletResponse response) throws Exception {
            CookieService.setCookie(response, "usuarioId", "", 10000);
            return "redirect:/";
    }

}
