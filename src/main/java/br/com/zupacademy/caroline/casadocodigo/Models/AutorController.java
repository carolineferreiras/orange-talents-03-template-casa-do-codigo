package br.com.zupacademy.caroline.casadocodigo.Models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<HttpStatus> cadastrar(@RequestBody AutorForm autorForm) {
        Autor  autor = autorForm.converter();
        autorRepository.save(autor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
