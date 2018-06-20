package br.com.estudo.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.estudo.listavip.model.Convidado;
import br.com.estudo.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	ConvidadoService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidado")
	public String listaconvidado(Model model) {
		model.addAttribute("convidados", service.obterTodos());
		return "listaconvidado";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {
		Convidado convidado = new Convidado(nome, email, telefone);
		service.salvarConvidado(convidado);
		model.addAttribute("convidados", service.obterTodos());
		return "listaconvidado";
	}
}
