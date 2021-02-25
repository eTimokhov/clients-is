package com.etimokhov.clients.controller;

import com.etimokhov.clients.model.Client;
import com.etimokhov.clients.service.ClientService;
import com.etimokhov.clients.validation.ClientValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final ClientValidator clientValidator;

    public ClientController(ClientService clientService, ClientValidator clientValidator) {
        this.clientService = clientService;
        this.clientValidator = clientValidator;
    }

    @GetMapping("/clients/{clientId}")
    public String getClientInfo(@PathVariable Long clientId, Model model) {
        model.addAttribute("client", clientService.getClient(clientId));
        return "clientInfo";
    }

    @GetMapping("/clients/{clientId}/edit")
    public String editClient(@PathVariable Long clientId, Model model) {
        model.addAttribute("client", clientService.getClient(clientId));
        model.addAttribute("dictionary", clientService.getDictionary());
        return "clientEdit";
    }

    @GetMapping("/clients")
    public String getClients(Model model) {
        model.addAttribute("clients", clientService.getClients());
        return "clientList";
    }

    @GetMapping("/clients/new")
    public String newClient(Model model) {
        model.addAttribute("client", clientService.getEmptyClientStub());
        model.addAttribute("dictionary", clientService.getDictionary());
        return "clientEdit";
    }

    @PostMapping("/clients/save")
    public String saveClient(@ModelAttribute @Valid Client client, BindingResult bindingResult, Model model) {
        clientValidator.validate(client, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("dictionary", clientService.getDictionary());
            return "clientEdit";
        }
        Long clientId = clientService.saveClient(client);
        return "redirect:/clients/" + clientId;
    }

    @PostMapping("/clients/{clientId}/delete")
    public String deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return "redirect:/clients";
    }

}
