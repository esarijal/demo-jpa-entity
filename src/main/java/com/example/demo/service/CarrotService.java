package com.example.demo.service;

import com.example.demo.model.Basket;
import com.example.demo.model.Carrot;
import com.example.demo.model.Freezer;
import com.example.demo.repository.BasketRepository;
import com.example.demo.repository.CarrotRepository;
import com.example.demo.repository.FreezerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarrotService {

    private final BasketRepository basketRepository;
    private final CarrotRepository carrotRepository;
    private final FreezerRepository freezerRepository;

    public CarrotService(BasketRepository basketRepository,
                         CarrotRepository carrotRepository,
                         FreezerRepository freezerRepository) {
        this.basketRepository = basketRepository;
        this.carrotRepository = carrotRepository;
        this.freezerRepository = freezerRepository;
    }

    @Transactional
    public void addCarrotIntoBasket(Basket basket, Carrot carrot){
        Freezer freezer = carrot.getFreezer();
        freezer.removeCarrot(carrot);
        freezerRepository.save(freezer);

        basket.addCarrot(carrot);
        basketRepository.save(basket);
    }

    @Transactional
    public void removeCarrotFromBasket(Basket basket, int carrotId){
        Carrot carrot = carrotRepository.findById(carrotId)
                            .orElse(new Carrot());
        basket.removeCarrot(carrot);
    }
}
