package com.projectevent.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectevent.models.EventoModel;
import com.projectevent.repositories.EventoRepository;

@Controller
@CrossOrigin("*")
public class EventoController {

    private EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;

    }

    @GetMapping(value = "/cadastrar")
    public ModelAndView form() {
        return new ModelAndView("evento/cadastrarEvento");
    }

    @GetMapping(value = "/eventos")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("evento/listaEventos");
        List<EventoModel> eventos = eventoRepository.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @PostMapping(value = "/cadastrar")
    public String salvar(@Valid EventoModel evento, BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os Campos");
            return "redirect:/cadastrar";
        }
        eventoRepository.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento adicinado com sucesso!!");
        return "redirect:/eventos";
    }

    @GetMapping("deletar/{id}")
    public String deletar(@PathVariable("id") Long id) {
        EventoModel evento = eventoRepository.findById(id);
        eventoRepository.delete(evento);
        return "redirect:/eventos";
    }

    @GetMapping("atualizar/{id}")
    public ModelAndView atualizar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("evento/cadastrarEvento");
        EventoModel evento = eventoRepository.findById(id);
        mv.addObject("evento", evento);
        return mv;
    }

}
