/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Cart;
import model.Category;
import model.Product;
import model.Voucher;

/**
 *
 * @author chuva
 */
public class DAO extends DBContext{
    // select * from product
    public List<Product> getAllProduct(){
        List<Product> list=new ArrayList<>();
        String sql="select * from product";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setAmount(rs.getInt("quantity"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // select * from Category
    public List<Category> getAllCategory(){
        List<Category> list=new ArrayList<>();
        String sql="select * from Category";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {           
                Category c=new Category();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // select top 1 * from product order by id desc
    public Product getgetLast(){
        String sql = "select top 1 * from product order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setAmount(rs.getInt("quantity"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    // select * from product where cateID=1
    public List<Product> getProductByCID(String cid){
        List<Product> list=new ArrayList<>();
        String sql="select * from product where cateID=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setAmount(rs.getInt("quantity"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // select * from product where id=1
    public Product getProductByID(String id){
        String sql="select * from product where id=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setAmount(rs.getInt("quantity"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    // select * from product where [name] like '%adidas%'
    public List<Product> getProductByName(String txtSearch){
        List<Product> list=new ArrayList<>();
        String sql="select * from product where [name] like ?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, "%"+txtSearch+"%");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setAmount(rs.getInt("quantity"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // select * from account where [user]='adam' and pass='123456'
    public Account login(String user, String pass){
        String sql="select * from account where [user]=? and pass=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {   
                Account a=new Account();
                a.setId(rs.getInt("uID"));
                a.setUser(rs.getString("user"));
                a.setPass(rs.getString("pass"));
                a.setIsSell(rs.getInt("isSell"));
                a.setIsAdmin(rs.getInt("isAdmin"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    // select * from account where [user]='Adam'
    public Account checkAccountExist(String user){
        String sql="select * from account where [user]=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {   
                Account a=new Account();
                a.setId(rs.getInt("uID"));
                a.setUser(rs.getString("user"));
                a.setPass(rs.getString("pass"));
                a.setIsSell(rs.getInt("isSell"));
                a.setIsAdmin(rs.getInt("isAdmin"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    // insert into account values('phuccv','140',0,0)
    public void signup(String user, String pass){
        String sql="insert into account values(?,?,0,0)";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // delete from product where id=1
    public void deleteProduct(String pid){
        String sql="delete from Cart where ProductID=?; delete from product where id=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, pid);
            st.setString(2, pid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // select * from product where sell_ID=1
    public List<Product> getProductBySellID(int sid){
        List<Product> list=new ArrayList<>();
        String sql="select * from product where sell_ID=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, sid);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setAmount(rs.getInt("quantity"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // INSERT [dbo].[product] ([quantity], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (N'Giày đá bóng', N'https://canary.contestimg.wish.com/api/webimage/5f5ad3f3706bf3003d7acbd3-normal.jpg?cache_buster=10f7d3b88daf4019fa9d8be157793111', 100.0000, N'Giày thể thao nam Adidas Enerergy Falcon EE9844', N'Giày thể thao Adidas Advantage Clean sử dụng chất liệu cao cấp, thoáng khí cả mặt trong và mặt ngoài giúp bạn luôn dễ chịu và thoải mái dù mang trong thời gian dài. Giày Adidas VS Advantage có bộ đế êm ái giúp người đi tận hưởng cảm giác thoải mái cho cả ngày dài vận động. Thời trang vốn là sự quay vòng, và thiết kế đơn giản, cổ điển đại diện cho xu hướng thời trang hoài cổ đang quay trở lại và được giới trẻ đón nhận nồng nhiệt hơn bao giờ hết. Không giống như những loại giày thể thao thông thường, mẫu giày adidas Advantage có kiểu dáng "thon thả" hơn, khiến cho đôi chân không bị trở nên lạc lõng so với đôi giày thể thao vốn bị "mang tiếng" là thô kệch, không đẹp mắt. Thêm nữa, đế của loại giày này được thiết kế theo kiểu đế xuồng 3cm vừa tạo tính đàn hồi cho từng bước đi mà cũng "tiện tay" giúp cho người đi "ăn gian" chiều cao khá đáng kể. Và tất nhiên, điểm cộng tuyệt vời nhất chính là sự phối hợp tuyệt vời từ kiểu dáng đến màu sắc của các nhà thiết kế tài hoa đã làm cho đôi giày phù hợp với mọi giới tính, mọi lứa tuổi, mix được với rất nhiều phong cách khác nhau', 1, 1)
    public void insertProduct(String amount, String name, String image, String price, String title, String description, String category, int sid){
        String sql="INSERT [dbo].[product] ([quantity], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, amount);
            st.setString(2, name);
            st.setString(3, image);
            st.setString(4, price);
            st.setString(5, title);
            st.setString(6, description);
            st.setString(7, category);
            st.setInt(8, sid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // update product set [name]='', [image]='', price='', title='', [description]='', cateID='' where id='' 
    public void editProduct(String name, String image, String price, String title, String quantity, String description, String category, String pid){
        String sql="update product set [name]=?, [image]=?, price=?, title=?, [description]=?, cateID=? , quantity=? where id=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setString(3, price);
            st.setString(4, title);
            st.setString(5, description);
            st.setString(6, category);
            st.setString(7, quantity);
            st.setString(8, pid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // select top 3 * from product
    public List<Product> getTop3(){
        List<Product> list=new ArrayList<>();
        String sql="select top 3 * from product";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // select * from product order by id offset 3 rows fetch next 3 rows only
    public List<Product> getNext3Product(int amount){
        List<Product> list=new ArrayList<>();
        String sql="select * from product order by id offset ? rows fetch next 3 rows only";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, amount);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // 
    public Product getProduct(String id){
        String sql="select * from product where id=?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));
                p.setAmount(1);
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    // insert into Cart values(1,2,20,'')
    public void insertBuyProduct(int AcountID, int ProductID, int quantity, LocalDateTime buyDateTime){
        String sql="insert into Cart values(?,?,?,?)";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, AcountID);
            st.setInt(2, ProductID);
            st.setInt(3, quantity);
            st.setTimestamp(4, Timestamp.valueOf(buyDateTime));
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // SELECT P.name AS ProductName, C.Amount, P.price * C.Amount AS TotalPayment, P.image AS ProductImage, C.byDateTime AS PurchaseDate FROM Cart C JOIN product P ON C.ProductID = P.id WHERE C.AccountID = 1
    public List<Cart> getPurchasedProduct(int id){
        List<Cart> list=new ArrayList<>();
        String sql="SELECT P.name AS ProductName, C.Amount, P.price * C.Amount AS TotalPayment, P.image AS ProductImage, C.byDateTime AS PurchaseDate FROM Cart C JOIN product P ON C.ProductID = P.id WHERE C.AccountID = ?";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Cart c=new Cart();
                c.setProductName(rs.getString("ProductName"));
                c.setQuantity(rs.getInt("Amount"));
                c.setTotalPayment(rs.getDouble("TotalPayment"));
                c.setProductImage(rs.getString("ProductImage"));
                c.setPurchasedDate(rs.getString("PurchaseDate"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    /*
    SELECT A.uID AS ID, A.[user] AS Tên, COALESCE(SUM(COALESCE(C.Amount, 0)), 0) AS 'Số lượng đã mua', COALESCE(SUM(COALESCE(CASE WHEN P.price IS NOT NULL THEN P.price * C.Amount ELSE 0 END, 0)), 0) AS 'Số tiền đã thanh toán'
FROM Account A LEFT JOIN Cart C ON A.uID = C.AccountID LEFT JOIN product P ON C.ProductID = P.id WHERE A.isSell = 0 AND A.isAdmin = 0 GROUP BY A.uID, A.[user]
ORDER BY COALESCE(SUM(COALESCE(CASE WHEN P.price IS NOT NULL THEN P.price * C.Amount ELSE 0 END, 0)), 0) DESC, COALESCE(SUM(COALESCE(C.Amount, 0)), 0) DESC;
    */
    public List<Account> getAllClient(){
        List<Account> list=new ArrayList<>();
        String sql="SELECT A.uID AS ID, A.[user] AS Tên, COALESCE(SUM(COALESCE(C.Amount, 0)), 0) AS 'Số lượng đã mua', COALESCE(SUM(COALESCE(CASE WHEN P.price IS NOT NULL THEN P.price * C.Amount +  P.price * C.Amount * 0.1 ELSE 0 END, 0)), 0) AS 'Số tiền đã thanh toán'\n" +
"FROM Account A LEFT JOIN Cart C ON A.uID = C.AccountID LEFT JOIN product P ON C.ProductID = P.id WHERE A.isAdmin = 0 GROUP BY A.uID, A.[user]\n" +
"ORDER BY COALESCE(SUM(COALESCE(CASE WHEN P.price IS NOT NULL THEN P.price * C.Amount ELSE 0 END, 0)), 0) DESC, COALESCE(SUM(COALESCE(C.Amount, 0)), 0) DESC;";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Account a=new Account();
                a.setId(rs.getInt("ID"));
                a.setUser(rs.getString("Tên"));
                a.setDaMua(rs.getInt("Số lượng đã mua"));
                a.setDaThanhToan(rs.getDouble("Số tiền đã thanh toán"));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // update account set isSell=1 where [uID]=1
    public void registerSales(String id){
        String sql = "update account set isSell=1 where [uID]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // delete from account where [uID]=0
    public void deleteClient(String id){
        String sql = "delete from Cart where AccountID=?; delete from account where [uID]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // select * from Account where [uID]=1
    public Account getClientByID(String id) {
        String sql = "select * from Account where [uID]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a=new Account();
                a.setId(rs.getInt("uID"));
                a.setUser(rs.getString("user"));
                a.setPass(rs.getString("pass"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    /*
    SELECT A.uID AS AccountID, A.[user] AS UserName, COUNT(P.id) AS NumberOfProductsToSell, ISNULL(SUM(C.Amount), 0) AS NumberOfProductsSold, ISNULL(SUM(P.price * ISNULL(C.Amount, 0)), 0) AS TotalRevenue
FROM Account A JOIN product P ON A.uID = P.sell_ID LEFT JOIN Cart C ON P.id = C.ProductID WHERE A.isSell = 1 AND A.isAdmin = 0
GROUP BY A.uID, A.[user] ORDER BY TotalRevenue DESC, AccountID;
    */
    public List<Account> getAllSalesman(){
        List<Account> list=new ArrayList<>();
        String sql="SELECT A.uID AS AccountID, A.[user] AS UserName, COUNT(P.id) AS NumberOfProductsToSell, ISNULL(SUM(C.Amount), 0) AS NumberOfProductsSold, ISNULL(SUM(P.price * ISNULL(C.Amount, 0) + P.price * ISNULL(C.Amount, 0)*0.1), 0) AS TotalRevenue\n" +
"FROM Account A JOIN product P ON A.uID = P.sell_ID LEFT JOIN Cart C ON P.id = C.ProductID WHERE A.isSell = 1 AND A.isAdmin = 0\n" +
"GROUP BY A.uID, A.[user] ORDER BY TotalRevenue DESC, AccountID;";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {                
                Account a=new Account();
                a.setId(rs.getInt("AccountID"));
                a.setUser(rs.getString("UserName"));
                a.setCanBan(rs.getInt("NumberOfProductsToSell"));
                a.setDaBan(rs.getInt("NumberOfProductsSold"));
                a.setTienThuVe(rs.getDouble("TotalRevenue"));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    /*
    DELETE FROM product WHERE sell_ID = 0;
    DELETE FROM Account WHERE uID = 0;
    */
    public void deleteSalesman(String id){
        String sql = "DELETE FROM Cart WHERE ProductID IN (SELECT id FROM product WHERE sell_ID = ?);\n" +
"DELETE FROM product WHERE sell_ID =?;\n" +
"DELETE FROM Account WHERE uID =?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id);
            st.setString(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // insert into account values('phuccv','140',1,0)
    public void addSalesman(String user, String pass){
        String sql="insert into account values(?,?,1,0)";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // update account set [pass]=23 where [user]='Quân'
    public void updateClient(String user, String pass){
        String sql = "update account set [pass]=? where [user]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, user);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // SELECT [quantity] FROM product WHERE [id] = 10;
    public int getProductQuantity(String id){
        String sql = "SELECT [quantity] FROM product WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    // UPDATE product SET quantity = quantity - 1 WHERE id = 1
    public void updateProductQuantity(int pID, int buyProduct){
        String sql = "UPDATE product SET quantity = quantity - ? WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, buyProduct);
            st.setInt(2, pID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // select * from Voucher where id='dfghj'
    public Voucher getVoucher(String id){
        String sql="select * from Voucher where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Voucher v=new Voucher();
                v.setId(rs.getString("id"));
                v.setMoneyVoucher(rs.getDouble("moneyVoucher"));
                return v;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    // SELECT * FROM voucher ORDER BY moneyVoucher DESC;
    public List<Voucher> getVoucherAll(){
        List<Voucher> list=new ArrayList<>();
        String sql="SELECT * FROM voucher ORDER BY moneyVoucher DESC;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Voucher v=new Voucher();
                v.setId(rs.getString("id"));
                v.setMoneyVoucher(rs.getDouble("moneyVoucher"));
                list.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // delete Voucher where id=''
    public void deleteVoucher(String id){
        String sql = "delete Voucher where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // insert into Voucher values('hihi',10.000)
    public void insertVoucher(String id, double money){
        String sql="insert into Voucher values(?,?)";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, id);
            st.setDouble(2, money);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // update Voucher set moneyVoucher=3 where id='dfghj'
    public void editVoucher(String id, double money){
        String sql = "update Voucher set moneyVoucher=? where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, money);
            st.setString(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /*
    SELECT P.name AS ProductName, C.Amount AS QuantitySold, P.price * C.Amount AS TotalPayment, P.image AS ProductImage, C.byDateTime AS PurchaseDate
FROM Cart C JOIN product P ON C.ProductID = P.id JOIN Account A ON P.sell_ID = A.uID WHERE A.uID = 1;
    */
    public List<Product> getSold(int id){
        List<Product> list=new ArrayList<>();
        String sql="SELECT P.name AS ProductName, C.Amount AS QuantitySold, P.price * C.Amount AS TotalPayment, P.image AS ProductImage, C.byDateTime AS PurchaseDate\n" +
"FROM Cart C JOIN product P ON C.ProductID = P.id JOIN Account A ON P.sell_ID = A.uID WHERE A.uID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Product p=new Product();
                p.setName(rs.getString("ProductName"));
                p.setAmount(rs.getInt("QuantitySold"));
                p.setToltal(rs.getDouble("TotalPayment"));
                p.setImage(rs.getString("ProductImage"));
                p.setTimeBuy(rs.getString("PurchaseDate"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        DAO d=new DAO();
        List<Product> listp=d.getAllProduct();
        List<Category> listc=d.getAllCategory();
        List<Account> lista=d.getAllClient();
//        for(Product i:listp){
//            System.out.println(i);
//        }
        for(Category i:listc){
            System.out.println(i);
        }
//        System.out.println(d.getgetLast());
//        System.out.println(d.getProductByID("1"));
//        for(Account i:lista){
//            System.out.println(i.getId()+" "+i.getUser()+" "+i.getDaMua()+" "+i.getDaThanhToan());
//        }
    }

    public void insertVoucher(String id, String money) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
