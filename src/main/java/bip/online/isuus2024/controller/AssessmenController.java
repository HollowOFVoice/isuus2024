package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.entity.GroupsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.AssessmenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/assessmen")
@AllArgsConstructor
public class AssessmenController {
    private final AssessmenService service;

    @GetMapping("/all")// работает
    public ResponseEntity<ListResponse<AssessmenEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AssessmenEntity>(true, "Список оценок", service.findAll()));
    }

    @PostMapping//работает
    public ResponseEntity<DataResponse<AssessmenEntity>> save(@RequestBody AssessmenEntity assessmen) {
        return ResponseEntity.ok(
                new DataResponse<AssessmenEntity>(true, "Группа сохранена", service.save(assessmen)));
    }

    @PutMapping//работает
    public ResponseEntity<BaseResponse> update(@RequestBody AssessmenEntity assessmen) {
        try {
        service.update(assessmen);
        return ResponseEntity.ok(
                new BaseResponse(true, "Оценка по предмету сохранена и обновлена"));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }


    @DeleteMapping("/{id}")//работает
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "оценка удалена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}
