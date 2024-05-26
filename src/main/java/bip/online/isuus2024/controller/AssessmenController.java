package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.entity.GroupsEntity;
import bip.online.isuus2024.entity.LessonsEntity;
import bip.online.isuus2024.entity.StudentsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.AssessmenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Оценки", description="Содержит методы для работы с оценками ")
@RestController
@RequestMapping("api/v1/assessmen")
@AllArgsConstructor
public class AssessmenController {
    private final AssessmenService service;
    @Operation(
            summary = "Вывод Всех оценок",
            description = "Позволяет вывести все оценки, что есть в базе"
    )
    @GetMapping("/all")// работает
    public ResponseEntity<ListResponse<AssessmenEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AssessmenEntity>(true, "Список оценок", service.findAll()));
    }

//    @Operation(
//            summary = "Вывод средней оценки",
//            description = "Позволяет вывести среднюю оценку студента"
//    )
//    @GetMapping("/avg")// работает
//    public ResponseEntity<Long> seredka() {
//        return ResponseEntity.ok( service.sredniy());
//    }

        @Operation(
            summary = "Вывод средней оценки",
            description = "Позволяет вывести среднюю оценку студента"
    )
    @GetMapping("/avg")// работает
    public ResponseEntity<Double> seredka(Long groupId) {
        return ResponseEntity.ok( service.findAverageAss(groupId));
    }

    @Operation(
            summary = "Добавить оценку",
            description = "Позволяет добавлять оценку в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody AssessmenEntity assessmen) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<AssessmenEntity>(true, "Оценка сохранена", service.save(assessmen)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
 @Operation(
        summary = "Изменить оценку",
        description = "Позволяет редактировать и изменять оценку"
)
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

    @Operation(
            summary = "Удалить  оценку",
            description = "Позволяет удалить оценку из базы"
    )
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
