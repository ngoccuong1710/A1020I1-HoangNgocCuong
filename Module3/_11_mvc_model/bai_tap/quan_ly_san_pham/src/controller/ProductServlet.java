package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/products"})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("action");
        if (actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                searchProduct(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("action");
        if (actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteFrom(request, response);
                break;
            case "show":
                showInforProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = this.productService.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void showInforProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        request.setAttribute("productShow", product);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int)(Math.random() * 1000);
        String name = request.getParameter("name");
        double price = Integer.parseInt(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String productionCompany = request.getParameter("productionCompany");

        Product product = new Product(id, name, price, describe, productionCompany);
        this.productService.save(product);
        request.setAttribute("msg", "New product was created");
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        request.setAttribute("productUpdate", product);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String productionCompany = request.getParameter("productionCompany");

        Product product = this.productService.findById(id);

        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescribe(describe);
        product.setProductionCompany(productionCompany);

        this.productService.update(id, product);

        request.setAttribute("productUpdate", product);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        request.setAttribute("productDelete", product);
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        this.productService.remove(id);
        response.sendRedirect("/products");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("search");
        List<Product> product = this.productService.findAll();
        for (Product productList: product){
            if (nameSearch.equals(productList.getName())){
                request.setAttribute("msg", "Detail");
                request.setAttribute("productSearch", productList);
                request.getRequestDispatcher("search.jsp").forward(request, response);
                break;
            }
        }
        request.setAttribute("msg","Not found");
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
