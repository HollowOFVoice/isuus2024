package bip.online.isuus2024.controller;

import bip.online.isuus2024.entity.LessonsEntity;
import bip.online.isuus2024.entity.StudentsEntity;
import bip.online.isuus2024.responce.BaseResponse;
import bip.online.isuus2024.responce.DataResponse;
import bip.online.isuus2024.responce.ListResponse;
import bip.online.isuus2024.service.LessonsService;
import bip.online.isuus2024.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@AllArgsConstructor
public class StudentsController {

    private final StudentsService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<StudentsEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<StudentsEntity>(true, "Список изучаемых предметов", service.findAll()));
    }


    @GetMapping("/get")
    public  ResponseEntity<BaseResponse> getRecordBook(@RequestParam int recBook){
        return ResponseEntity.ok(new ListResponse(service.getStudByRecordBook(recBook)));
    }


//    @GetMapping
//    public ResponseEntity<DataResponse<GroupsEntity>> by_id(@RequestParam Long id) {
//        return ResponseEntity.ok(
//                new DataResponse<GroupsEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
//    }

    @PostMapping
    public ResponseEntity<DataResponse<StudentsEntity>>save(@RequestBody StudentsEntity student) {
        return ResponseEntity.ok(
                new DataResponse<StudentsEntity>(true, "Изучаемый предмет сохранен", service.save(student)));
    }
    @PutMapping
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
    @DeleteMapping("/{id}")
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
