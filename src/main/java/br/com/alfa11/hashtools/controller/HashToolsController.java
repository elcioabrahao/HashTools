package br.com.alfa11.hashtools.controller;

import br.com.alfa11.hashtools.service.HashToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/hash")
public class HashToolsController {

    @Autowired
    HashToolsService hashToolsService;

    @GetMapping(path = {"/sha256", "/sha256/{plainText}"})
    public String getSHA256(@PathVariable(required=false,name="plainText") String plainText,
                     @RequestParam(required=false,name="texto") String texto) {
        if(texto != null) {
            return hashToolsService.getHash("SHA-256",texto);
        }
        if(plainText != null) {
            return hashToolsService.getHash("SHA-256",plainText);
        }
        return "Erro: Parâmetros não encotrados!";
    }

    @GetMapping(path = {"/sha3256", "/sha3256/{plainText}"})
    public String getSHA3256(@PathVariable(required=false,name="plainText") String plainText,
                            @RequestParam(required=false,name="texto") String texto) {
        if(texto != null) {
            return hashToolsService.getHash("SHA3-256",texto);
        }
        if(plainText != null) {
            return hashToolsService.getHash("SHA3-256",plainText);
        }
        return "Erro: Parâmetros não encotrados!";
    }

    @GetMapping(path = {"/md5", "/md5/{plainText}"})
    public String getMD5(@PathVariable(required=false,name="plainText") String plainText,
                            @RequestParam(required=false,name="texto") String texto) {
        if(texto != null) {
            return hashToolsService.getHash("MD5",texto);
        }
        if(plainText != null) {
            return hashToolsService.getHash("MD5",plainText);
        }
        return "Erro: Parâmetros não encotrados!";
    }


}
