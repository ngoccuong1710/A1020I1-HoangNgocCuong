import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "/img/hinh1.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "/img/hinh2.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "/img/hinh3.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "/img/hinh4.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "/img/hinh5.jpg"));

        request.setAttribute("customerListServlet", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
