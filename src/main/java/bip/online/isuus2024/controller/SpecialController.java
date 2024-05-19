package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.LessonsEntity;
import bip.online.isuus2024.entity.SpecialsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.LessonsService;
import bip.online.isuus2024.service.SpecialsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/special")
@AllArgsConstructor
public class SpecialController {

    private final SpecialsService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<SpecialsEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<SpecialsEntity>(true, "Список спецальностей", service.findAll()));
    }

//    @GetMapping
//    public ResponseEntity<DataResponse<GroupsEntity>> by_id(@RequestParam Long id) {
//        return ResponseEntity.ok(
//                new DataResponse<GroupsEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
//    }

    @PostMapping
    public ResponseEntity<DataResponse<SpecialsEntity>>save(@RequestBody SpecialsEntity special) {
        return ResponseEntity.ok(
                new DataResponse<SpecialsEntity>(true, "Специальность сохранена", service.save(special)));
    }
    @PutMapping
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
    @DeleteMapping("/{id}")
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
