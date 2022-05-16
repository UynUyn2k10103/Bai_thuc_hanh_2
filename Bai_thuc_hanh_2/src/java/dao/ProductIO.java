/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.Product;
import java.sql.Date;
import java.sql.Statement;
/**
 *
 * @author hp
 */
public class ProductIO extends DAO{

    public ProductIO() {
        super();
    }
    
    public ArrayList <Product> getListProduct() {
        String sql = "SELECT * FROM product";
        ArrayList <Product> Products = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("p_id"));
                product.setCode(rs.getString("p_code"));
                product.setDescription(rs.getString("p_description"));
                product.setPrice(Double.parseDouble(rs.getString("p_price")));
                Products.add(product);
            }
        }catch(Exception e) {
                e.printStackTrace();
        }
        return Products;
    }

    public Product getProductById(String id){
        Product product = null;
        id =  id.trim();
        String sql = "SELECT * FROM product WHERE p_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                product = new Product();
                product.setId(rs.getInt("p_id"));
                product.setCode(rs.getString("p_code"));
                product.setDescription(rs.getString("p_description"));
                product.setPrice(Double.parseDouble(rs.getString("p_price")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }	
        return product;
    }

    public Product getProductByCode(String p_code){
        Product product = null;
        p_code =  p_code.trim();
        String sql = "SELECT * FROM product WHERE p_code = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p_code);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                product = new Product();
                product.setId(rs.getInt("p_id"));
                product.setCode(rs.getString("p_code"));
                product.setDescription(rs.getString("p_description"));
                product.setPrice(Double.parseDouble(rs.getString("p_price")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }	
        return product;
    }
    public void updateProduct(Product product){
        String sql = "UPDATE product SET p_code = ?, p_description = ?, p_price = ? WHERE p_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getPrice() + "");
            ps.setString(4, product.getId() + "");
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }   
    }

    public void addProduct(Product product){
        String sql = "INSERT INTO product(p_code, p_description, p_price) VALUES(?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getPrice() + "");
            ps.executeUpdate();
            con.setAutoCommit(true);
            //get id of the new inserted client
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteProduct(Product product){
        String sql = "DELETE FROM product WHERE p_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getId() + "");
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
