package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.AssessmenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/assessmen")
@AllArgsConstructor
public class AssessmenController {
    private final AssessmenService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<AssessmenEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AssessmenEntity>(true, "Список оценок", service.findAll()));
    }

}
