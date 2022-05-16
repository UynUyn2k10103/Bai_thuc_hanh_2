package entity;

import dao.ProductIO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class main {
    public static void main(String[] args) {
        ProductIO p = new ProductIO();
        try{
            // Test sửa sản phẩm
            Product product = new Product(1, "123", "345", 12);
            p.updateProduct(product);

//            // Test thêm sản phẩm
//            Product product = new Product(1, "123", "345", 12);
//            p.addProduct(product);
//            System.out.println(product.getId());

//            // xóa thử sản phẩm 
//            Product product = new Product(5, "123", "345", 12);
//            p.deleteProduct(product);
            // Test xem lấy được sản phẩm theo id chưa
//            String p_code = "2206";
//            Product product = p.getProductById("1");
//            if (product != null) {
//                System.out.println(product.getCode());
//                System.out.println(product.getDescription());
//                System.out.println(product.getPrice());
//            } else System.out.println("Khong tim thay san pham");
//            // Test xem lấy được list sản phẩm chưa
//            ArrayList<Product> products = p.getListProduct();
//            for (int i = 0; i < products.size(); i++) {
//                Product product = products.get(i);
//                System.out.println(product.getCode());
//                System.out.println(product.getDescription());
//                System.out.println(product.getPrice());
//            }

        }
        catch(Exception e){
            System.out.println("oki");
        }
        
    }
        
}
