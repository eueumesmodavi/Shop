

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	//Atividade Proposta Nélio Alves **Solucionada por mim**

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Product "+(i+1)+" data:");
			System.out.println("Common, used or imported (c/u/i)?");
			char resp = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(resp == 'i') {
				System.out.print("Customs fee: ");
				double customsFee =sc.nextDouble();
				
				Product prod = new ImportedProduct(name, price, customsFee);
				list.add(prod);
			}else if(resp == 'c'){
				Product prod = new Product(name,price);
				list.add(prod);
			}else if(resp == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product prod = new UsedProduct(name,price,manufactureDate);
				list.add(prod);
			}
			
		}
		
		System.out.println("PRICE TAGS: ");
		for(Product prod: list) {
			System.out.println(prod.priceTag());
		}

		
	}

}
