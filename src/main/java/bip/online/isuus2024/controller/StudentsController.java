package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.StudentsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.StudentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Студенты", description="Содержит методы для работы со студентами")
@RestController
@RequestMapping("api/v1/student")
@AllArgsConstructor
public class StudentsController {

    private final StudentsService service;

    @Operation(
            summary = "Вывод Всех студентов",
            description = "Позволяет вывести информацию о всех студентах, что есть в базе"
    )
    @GetMapping("/all")// Работает
    public ResponseEntity<ListResponse<StudentsEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<StudentsEntity>(true, "Список изучаемых предметов", service.findAll()));
    }










    @PostMapping
    public ResponseEntity<BaseResponse> save( StudentsEntity student) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<StudentsEntity>(true, "Студент сохранена", service.save(student)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }


    @Operation(
            summary = "Изменить информацию о студенте",
            description = "Позволяет редактировать и изменять информацию о студентах"
    )
    @PutMapping// Работает
    public ResponseEntity<BaseResponse> update(@RequestBody StudentsEntity student) {
        try {
            service.update(student);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Изучаемый предмет сохранен и обновлен"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Удалить  специальность",
            description = "Позволяет удалить специальность из базы"
    )
    @DeleteMapping("/{id}")// Работает
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
