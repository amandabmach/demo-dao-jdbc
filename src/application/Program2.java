package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n1) TEST: findById ");
		Department dep = departmentDao.findById(4);
		System.out.println(dep);
		
		System.out.println("\n2) TEST: findAll ");
		List<Department> list = departmentDao.findAll();
		for (Department x: list) {
			System.out.println(x);
		}

		System.out.println("\n3) TEST: insert ");
		Department newDep= new Department(null, "Computing");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id: " + newDep.getId());

		System.out.println("\n4) TEST: update ");
		Department department = departmentDao.findById(1);
		department.setName("Audio");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n5) TEST 5: delete ");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();
	}
}