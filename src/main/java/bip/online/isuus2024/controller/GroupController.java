package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.entity.GroupsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;

import bip.online.isuus2024.service.GroupsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/group")
@AllArgsConstructor

public class GroupController {

    private final GroupsService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<GroupsEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<GroupsEntity>(true, "Список групп", service.findAll()));
    }

//    @GetMapping
//    public ResponseEntity<DataResponse<GroupsEntity>> by_id(@RequestParam Long id) {
//        return ResponseEntity.ok(
//                new DataResponse<GroupsEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
//    }

    @PostMapping
    public ResponseEntity<DataResponse<GroupsEntity>> save(@RequestBody GroupsEntity group) {
        return ResponseEntity.ok(
                new DataResponse<GroupsEntity>(true, "Группа сохранена", service.save(group)));
    }
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody GroupsEntity group) {
        service.update(group);
        return ResponseEntity.ok(
                new BaseResponse(true, "Группа сохранена и обновлена"));
    }
}
