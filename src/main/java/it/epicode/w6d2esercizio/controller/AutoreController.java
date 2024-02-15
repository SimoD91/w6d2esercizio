package it.epicode.w6d2esercizio.controller;

import com.cloudinary.Cloudinary;
import it.epicode.w6d2esercizio.exception.NotFoundException;
import it.epicode.w6d2esercizio.model.Autore;
import it.epicode.w6d2esercizio.model.AutoreRequest;
import it.epicode.w6d2esercizio.model.CustomResponse;
import it.epicode.w6d2esercizio.repository.AutoreRepository;
import it.epicode.w6d2esercizio.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoreService;
    private Cloudinary cloudinary;
    @Autowired
    private AutoreRepository autoreRepository;
    @GetMapping("/autori")
    public Page<Autore> getAll(Pageable pageable){

        return autoreService.cercaTuttiGliAutori(pageable);
    }
    @GetMapping("/autori/{id}")
    public Autore getAutoreById(@PathVariable int id){
        return autoreService.cercaAutorePerId(id);

    }
    @PostMapping("/autori")
    public Autore saveAutore(@RequestBody @Validated AutoreRequest autoreRequest, BindingResult bindingResult){
        return autoreService.salvaAutore(autoreRequest);
    }
    @PutMapping("/autori/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody AutoreRequest autoreRequest){
        return autoreService.aggiornaAutore(id, autoreRequest);
    }

    @DeleteMapping("/autori/{id}")
    public void deleteAutore(@PathVariable int id){
        autoreService.cancellaAutore(id);
    }

    @PatchMapping("/autori/{id}/upload")
    public ResponseEntity<CustomResponse> uploadAvatar(@PathVariable int id, @RequestParam("upload") MultipartFile file){
        try {
            Autore autore = autoreService.uploadAvatar(id, (String)cloudinary.uploader().upload(file.getBytes(), new HashMap()).get("url"));
            return CustomResponse.success(HttpStatus.OK.toString(), autore, HttpStatus.OK);
        }
        catch (IOException e){
            return CustomResponse.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}