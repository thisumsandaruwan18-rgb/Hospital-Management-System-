package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Department;
import com.smartcare.hospital.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department){
        if (departmentRepository.existsById(department.getDeId())) {
            throw new IllegalArgumentException("Department already exists");
        }
        return  departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id){
        return departmentRepository.findById(id).get();
    }

    public Department updateDepartment(int id, Department updatedepartment){
        Department existingDepartment = getDepartmentById(id);

        existingDepartment.setDeId(updatedepartment.getDeId());
        existingDepartment.setDeName(updatedepartment.getDeName());
        existingDepartment.setHeadDoctor(updatedepartment.getHeadDoctor());
        existingDepartment.setLocation(updatedepartment.getLocation());

        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }
}
