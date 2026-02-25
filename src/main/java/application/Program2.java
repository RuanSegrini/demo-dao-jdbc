package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

    public static void main(String[]args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.print("=== TEST 1: department insert === ");
        Department newDepartment = new Department(null, "Cars");
        departmentDao.insert(newDepartment);
        System.out.print("Inserted! New id = " + newDepartment.getId());

    }
}
