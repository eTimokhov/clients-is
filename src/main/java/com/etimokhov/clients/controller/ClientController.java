package com.etimokhov.clients.controller;

import com.etimokhov.clients.model.Client;
import com.etimokhov.clients.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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
    public String saveClient(@ModelAttribute Client client) {
        Long clientId = clientService.saveClient(client);
        return "redirect:/clients/" + clientId;
    }

    @PostMapping("/clients/{clientId}/delete")
    public String deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return "redirect:/clients";
    }

}
