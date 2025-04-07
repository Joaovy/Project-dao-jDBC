package Aplication;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        SellerDao sellerDao = DaoFactory.creatSellerDao();

        System.out.println(" --- TEST 1: seller findbyId --- ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n --- TEST 2: seller findbyDepartment --- ");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n --- TEST 3: seller findAl --- ");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n --- TEST 4: seller insert --- ");
        Seller newSeller = new Seller(null, "Greg", "greg@email.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inseted new id = "+ newSeller.getID());


        System.out.println("\n --- TEST 5: seller update --- ");
        seller = sellerDao.findById(1);
        seller.setName("Matha Waine");
        sellerDao.update(seller);
        System.out.println("update completed");

        System.out.println("\n --- TEST 6: seller delet --- ");
        System.out.println("Informe um id para teste de deleção: ");
        int id = scanner.nextInt();
        sellerDao.deleById(id);

        System.out.println("Delete completed");

        scanner.close();

    }

}
