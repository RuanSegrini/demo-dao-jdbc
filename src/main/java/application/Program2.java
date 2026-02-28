package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Program2 {

    public static void main(String[]args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: department findbyId ===");
        Department department = departmentDao.findById(3);
        System.out.print(department);

        System.out.println("=== TESTE 2: departmet delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.print("Delete completed! ");
        System.out.println(">>> DELETE CHAMADO com id: " + id);

        System.out.println("=== TEST 4: department insert === ");
        Department newDepartment = new Department(null, "Cars");
        departmentDao.insert(newDepartment);
        System.out.print("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 5: department update ===");
        department = departmentDao.findById(16);
        department.setName("Motors");
        departmentDao.update(department);
        System.out.println("Update completed");
        }

    }

