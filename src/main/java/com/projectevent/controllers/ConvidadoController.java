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

import com.projectevent.models.ConvidadoModel;
import com.projectevent.models.EventoModel;
import com.projectevent.repositories.ConvidadoRepository;
import com.projectevent.repositories.EventoRepository;

@CrossOrigin("*")
@Controller
public class ConvidadoController {

    private EventoRepository eventoRepository;
    private ConvidadoRepository convidadoRepository;

    public ConvidadoController(EventoRepository eventoRepository, ConvidadoRepository convidadoRepository) {
        this.eventoRepository = eventoRepository;
        this.convidadoRepository = convidadoRepository;
    }

    @GetMapping("evento/{id}")
    public ModelAndView detalhesEventoGet(@PathVariable("id") long id) {
        EventoModel evento = eventoRepository.findById(id);
        ModelAndView mv = new ModelAndView("evento/cadastrarConvidado");
        mv.addObject("evento", evento);
        List<ConvidadoModel> convidados = convidadoRepository.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

    @PostMapping("cadastrarconvidado/{id}")
    public String detalhesEventoPost(@PathVariable("id") Long id, @Valid ConvidadoModel convidado,
            BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os Campos");
            return "redirect:/evento/{id}";
        }

        EventoModel evento = eventoRepository.findById(id);
        convidado.setEvento(evento);
        convidadoRepository.save(convidado);
        attributes.addFlashAttribute("mensagem", "Convidado adicinado com sucesso!!");
        return "redirect:/evento/{id}";

    }

    @GetMapping("deletarconvidado/{cpf}")
    public String deletar(@PathVariable("cpf") String cpf) {
        ConvidadoModel convidado = convidadoRepository.findByCpf(cpf);
        convidadoRepository.delete(convidado);
        EventoModel evento = convidado.getEvento();
        Long idLong = evento.getId();
        String id = "" + idLong;
        return "redirect:/evento/" + id;

    }

    @GetMapping("atualizarconvidado/{id}/{cpf}")
    public ModelAndView atualizar(@PathVariable("id") Long id, @PathVariable("cpf") String cpf) {

        ModelAndView mv = new ModelAndView("evento/cadastrarConvidado");
        EventoModel evento = eventoRepository.findById(id);
        mv.addObject("evento", evento);
        List<ConvidadoModel> convidados = convidadoRepository.findByEvento(evento);
        mv.addObject("convidados", convidados);
        ConvidadoModel convidado = convidadoRepository.findByCpf(cpf);
        mv.addObject("convidado", convidado);
        return mv;
    }

}
