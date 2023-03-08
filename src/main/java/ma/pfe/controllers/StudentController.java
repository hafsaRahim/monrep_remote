package ma.pfe.controllers;

import ma.pfe.dots.StudentDto;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger LOG=LoggerFactory.getLogger(StudentController.class);
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto dto){
        LOG.debug("start methode save");
        StudentDto result = service.create(dto);
        LOG.debug("end methode save");
        return  result;
    }
    @PutMapping
    public StudentDto update(@RequestBody StudentDto dto){
        LOG.debug("start methode update");
        StudentDto result=service.update(dto);
        LOG.debug("end methode update");
        return result;
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){
        LOG.debug("start methode delete");
        boolean result = service.delete(id);
        LOG.debug("end methode delete");
        return  result;
    }
    @GetMapping("/read")
    public List<StudentDto> selectAll(){
        LOG.debug("start methode selectAll");
        List<StudentDto> lst=service.readAll();;
        LOG.debug("end methode selectAll");
        return lst;
    }
}
