package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.GroupsEntity;
import bip.online.isuus2024.entity.LessonsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.GroupsService;
import bip.online.isuus2024.service.LessonsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Изучамые предметы", description="Содержит методы для работы с изучаемыми предметами")
@RestController
@RequestMapping("api/v1/lesson")
@AllArgsConstructor
public class LessonsController {
    private final LessonsService service;

    @Operation(
            summary = "Вывод всех предметов",
            description = "Позволяет вывести все изучаемые предметы, что есть в базе"
    )
    @GetMapping("/all")//работает
    public ResponseEntity<ListResponse<LessonsEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<LessonsEntity>(true, "Список изучаемых предметов", service.findAll()));
    }


    @Operation(
            summary = "Добавить изучаемый предмет",
            description = "Позволяет добавлять изучаемый предмет в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody LessonsEntity lesson) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<LessonsEntity>(true, "Группа сохранена", service.save(lesson)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @Operation(
            summary = "Изменит предмет",
            description = "Позволяет редактировать и изменять изучаемый предмет"
    )
    @PutMapping//работает
    public ResponseEntity<BaseResponse> update(@RequestBody LessonsEntity group) {
        try {
        service.update(group);
        return ResponseEntity.ok(
                new BaseResponse(true, "Изучаемый предмет сохранен и обновлен"));
    } catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));
    }
}
    @Operation(
            summary = "Удалить  предмет",
            description = "Позволяет удалить изучаемый предмет из базы"
    )
    @DeleteMapping("/{id}")//работает
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Изучаемый предмет удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}
