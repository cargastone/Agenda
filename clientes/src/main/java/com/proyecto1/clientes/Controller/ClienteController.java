package com.proyecto1.clientes.Controller;

import com.proyecto1.clientes.Dto.ClienteDto;
import com.proyecto1.clientes.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/listar",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClienteDto> getClientes(){
        return service.getClientes();
    }

    @GetMapping("/{id}")
    public Mono<ClienteDto> getClientesId(@PathVariable String id){
        return service.getCliente(id);
    }

    @PostMapping("/create")
    public Mono<ClienteDto> saveCliente(@RequestBody Mono<ClienteDto> clienteDtoMono){
       
        return service.saveCliente(clienteDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ClienteDto> updateCliente(@RequestBody Mono<ClienteDto> clienteDtoMono,@PathVariable String id){
        return service.updateCliente(clienteDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCliente(@PathVariable String id){
        return service.deleteCliente(id);
    }
}
