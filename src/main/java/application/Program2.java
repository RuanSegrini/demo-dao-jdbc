package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[]args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: department findbyId ===");
        Department department = departmentDao.findById(3);
        System.out.print(department);

        System.out.println("=== TEST 2: department findall ===");
        List<Department> list = departmentDao.findall();
        for(Department obj : list){
            System.out.print(obj);
        }

        System.out.println("=== TEST 3: department insert === ");
        Department newDepartment = new Department(null, "Cars");
        departmentDao.insert(newDepartment);
        System.out.print("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update ===");
        department = departmentDao.findById(16);
        department.setName("Motors");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("=== TESTE 5: departmet delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.print("Delete completed! ");
        System.out.println(">>> DELETE CHAMADO com id: " + id);
        }
    }

