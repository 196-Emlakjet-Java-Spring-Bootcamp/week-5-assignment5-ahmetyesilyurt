package com.ysl.rabbitmq.controller;

import com.ysl.rabbitmq.dto.SaleAdvertisementDto;
import com.ysl.rabbitmq.model.SaleAdvertisement;
import com.ysl.rabbitmq.service.SaleAdvertisementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleAdvertisementController {

    private final SaleAdvertisementService saleAdvertisementService;

    public SaleAdvertisementController(SaleAdvertisementService saleAdvertisementService) {
        this.saleAdvertisementService = saleAdvertisementService;
    }

    @PostMapping("/sale-advertisement")
    public String createSaleAdvertisement(SaleAdvertisementDto saleAdvertisementDto) {
        saleAdvertisementService.createSaleAdvertisement(saleAdvertisementDto);
        return "İşleminiz başarıyla alınmıştır!";
    }

    @GetMapping("/sale-advertisement")
    public List<SaleAdvertisement> getAllSaleAdvertisements() {
        return saleAdvertisementService.getAllSaleAdvertisements();
    }

    @GetMapping("/created-at")
    public ResponseEntity<List<SaleAdvertisement>> findByCreatedAtAfter(@RequestParam Date date) {
        return new ResponseEntity<>(saleAdvertisementService.findByCreatedAtAfter(date), HttpStatus.OK);
    }

    @GetMapping("/get-sale")
    public ResponseEntity<List<SaleAdvertisement>> getSaleAdvertisementsByTitleOrDetailMessage(@RequestParam String title, @RequestParam String message) {
        return new ResponseEntity<>
                (saleAdvertisementService.getSaleAdvertisementsByTitleOrDetailMessage(title, message), HttpStatus.OK);

    }

    @GetMapping("/get-price")
    public ResponseEntity<List<SaleAdvertisement>> getByPriceGreaterThan(@RequestParam Long price) {
        return new ResponseEntity<>
                (saleAdvertisementService.findByPriceGreaterThan(price), HttpStatus.OK);
    }


}
