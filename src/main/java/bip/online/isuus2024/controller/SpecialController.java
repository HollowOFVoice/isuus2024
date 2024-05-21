package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.LessonsEntity;
import bip.online.isuus2024.entity.SpecialsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.LessonsService;
import bip.online.isuus2024.service.SpecialsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Специальности", description="Содержит методы для работы со специальностями")
@RestController
@RequestMapping("api/v1/special")
@AllArgsConstructor
public class SpecialController {

    private final SpecialsService service;

    @Operation(
            summary = "Вывод Всех специальностей",
            description = "Позволяет вывести все спеуиальности, что есть в базе"
    )
    @GetMapping("/all")// работает
    public ResponseEntity<ListResponse<SpecialsEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<SpecialsEntity>(true, "Список спецальностей", service.findAll()));
    }

//    @GetMapping
//    public ResponseEntity<DataResponse<GroupsEntity>> by_id(@RequestParam Long id) {
//        return ResponseEntity.ok(
//                new DataResponse<GroupsEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
//    }

    @Operation(
            summary = "Добавить специальность",
            description = "Позволяет добавлять новую специальность в базу"
    )
    @PostMapping// работает
    public ResponseEntity<DataResponse<SpecialsEntity>>save(@RequestBody SpecialsEntity special) {
        return ResponseEntity.ok(
                new DataResponse<SpecialsEntity>(true, "Специальность сохранена", service.save(special)));
    }

    @Operation(
            summary = "Изменить специальность",
            description = "Позволяет редактировать и изменять специальность"
    )
    @PutMapping// работает
    public ResponseEntity<BaseResponse> update(@RequestBody SpecialsEntity special) {
        try {
            service.update(special);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Специальность сохранена и обновлена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @Operation(
            summary = "Удалить  специальность",
            description = "Позволяет удалить специальность из базы"
    )
    @DeleteMapping("/{id}")// работает
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Специальность удалена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }

}
