package com.example.demo.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.example.demo.exceptions.ComplaintNotFoundException;
import com.example.demo.model.FarmerComplaints;
import com.example.demo.repository.farmerRepo;
import com.example.demo.service.farmerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/complaints")
@CrossOrigin(value="*")
public class farmerController {
    
    @Autowired
    private farmerService farmerService;
    @Autowired
    private farmerRepo farmerRepository;
    
    @PostMapping("/Complaints")
    public FarmerComplaints addComlaints(@Valid @RequestBody FarmerComplaints complaints){
        return farmerService.addComlaints(complaints);
    }
    
    @CrossOrigin(value="*")
    @GetMapping("/Complaints")
    public List<FarmerComplaints> getAllComplaints() {
        return farmerService.getAllComplaints();
    }
    
    @GetMapping("/Complaints/{id}")
    public FarmerComplaints getComplaintById(@PathVariable("id") Long id)throws ComplaintNotFoundException {
        return farmerService.getComplaintById(id);
    }
    
    @PutMapping("/Complaints/{id}")
    public FarmerComplaints updateComplaints(@PathVariable("id") Long id,@RequestBody FarmerComplaints complaints) throws ComplaintNotFoundException {
        return farmerService.updateComplaints(complaints);
    }
  
    @DeleteMapping("/Complaints/{id}")
    public Map<String, Boolean> deleteComplaints(@PathVariable("id") Long id) throws ComplaintNotFoundException {
        return farmerService.deleteComplaints(id);
    }
}


