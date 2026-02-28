package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

    public static void main(String[]args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findbyId ===");
        Department department = departmentDao.findById(3);
        System.out.print(department);

        System.out.print("=== TEST 4: department insert === ");
        Department newDepartment = new Department(null, "Cars");
        departmentDao.insert(newDepartment);
        System.out.print("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 5: department update ===");
        department = departmentDao.findById(8);
        department.setName("Motors");
        departmentDao.update(department);
        System.out.println("Update completed");
        }

    }

