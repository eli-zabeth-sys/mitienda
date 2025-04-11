package com.mitienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mitienda.dto.UsuarioDTO;
import com.mitienda.repository.UsuarioDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping("/usuario")
    public ModelAndView usuario(@RequestParam(name = "id") String id,
    HttpServletRequest request) { // Cambié HttpRequest a HttpServletRequest

        ModelAndView mav = new ModelAndView("usuario");

        UsuarioDTO usuario = usuarioDAO.getUsuario(id); // Suponiendo que ya tienes usuarioDAO configurado

        mav.addObject("usuario", usuario); // Pasar el objeto usuario a la vista

        return mav;
    }
}