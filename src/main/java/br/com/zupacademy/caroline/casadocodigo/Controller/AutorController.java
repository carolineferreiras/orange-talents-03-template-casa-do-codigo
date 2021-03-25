package br.com.zupacademy.caroline.casadocodigo.Controller;


import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Form.AutorForm;
import br.com.zupacademy.caroline.casadocodigo.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<HttpStatus> cadastrar(@Valid @RequestBody AutorForm autorForm) {
        Autor autor = autorForm.converter();
        autorRepository.save(autor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
