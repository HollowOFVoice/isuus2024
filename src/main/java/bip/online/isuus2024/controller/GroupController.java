package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.entity.GroupsEntity;
import bip.online.isuus2024.entity.StudentsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;

import bip.online.isuus2024.service.GroupsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Группы", description="Содержит методы для работы с группами")
@RestController
@RequestMapping("api/v1/group")
@AllArgsConstructor

public class GroupController {

    private final GroupsService service;
    @Operation(
            summary = "Вывод Всех групп",
            description = "Позволяет вывести все группы, что есть в базе"
    )
    @GetMapping("/all") // Работоает
    public ResponseEntity<ListResponse<GroupsEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<GroupsEntity>(true, "Список групп", service.findAll()));
    }

//    @GetMapping
//    public ResponseEntity<DataResponse<GroupsEntity>> by_id(@RequestParam Long id) {
//        return ResponseEntity.ok(
//                new DataResponse<GroupsEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
//    }
@Operation(
        summary = "Добавить группу",
        description = "Позволяет добавлять группу в базу"
)
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody GroupsEntity group) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<GroupsEntity>(true, "Группа сохранена", service.save(group)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить группу",
            description = "Позволяет редактировать и изменять группу"
    )
    @PutMapping// Работоает
    public ResponseEntity<BaseResponse> update(@RequestBody GroupsEntity group) {
        try {
        service.update(group);
        return ResponseEntity.ok(
                new BaseResponse(true, "Группа сохранена и обновлена"));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
    @Operation(
            summary = "Удалить  группу",
            description = "Позволяет удалить группу из базы"
    )
    @DeleteMapping("/{id}")// Работоает
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
