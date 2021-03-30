package com.rocketpowers.heroesapi.controller;


import com.rocketpowers.heroesapi.document.Heroes;
import com.rocketpowers.heroesapi.repository.HeroesRepository;
import com.rocketpowers.heroesapi.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.rocketpowers.heroesapi.constans.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {

    HeroesService heroesService;
    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
        this.heroesService = heroesService;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux<Heroes> getAllItems(){
        log.info("resquesting the list off heroes");
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/id")
    public Mono <ResponseEntity<Heroes>> findByIdHero(@PathVariable String id){
        log.info("requesting the hero with id {}", id);
        return heroesService.findBYIdHero(id)
                .map((item)-> new ResponseEntity<>(item,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code =HttpStatus.CREATED)
    public  Mono<Heroes> createHero(@RequestBody Heroes heroes){
        log.info("a new hero was created");
        return  heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/id")
    @ResponseStatus(code = HttpStatus.CONTINUE)
    public  Mono <HttpStatus> deletebyIdHero(@PathVariable String id){
        heroesService.deleteByIdHero(id);
        log.info("deleting a hero a with id {}", id);
        return Mono.just(HttpStatus.CONTINUE);



    }
    }