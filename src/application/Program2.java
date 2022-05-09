package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TESTE 1: department insert ===");
        Department department = new Department(null, "Music");
        departmentDao.insert(department);
        System.out.println("Inserted! New Department ID = " + department.getId());

        System.out.println("=== TESTE 2: department update ===");
        Department department2 = departmentDao.findById(3);
        department2.setName("Comida");
        departmentDao.update(department2);
        System.out.println("Update completed!");

        System.out.println("=== TESTE 3: department delete ===");
        System.out.println("Enter ID for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletion completed!");

        System.out.println("=== TESTE 4: department findByID ===");
        Department department1 = departmentDao.findById(2);
        System.out.println(department1);

        System.out.println("=== TESTE 5: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }
        
        sc.close();
    }
}
