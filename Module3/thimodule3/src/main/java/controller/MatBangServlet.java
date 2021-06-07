package controller;

import model.bean.MatBang;
import model.service.MatBangService;
import model.service.MatBangServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = {"","/matbang"})
public class MatBangServlet extends HttpServlet {
    private MatBangService matBangService;
    public void init(){
        matBangService = new MatBangServiceImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "them":
                try {
                    them(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case "xoa":
                try {
                    xoa(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "them":
                formThem(request, response);
                break;
            case "xoa":
                try {
                    xoa(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    list(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<MatBang> matBangList = matBangService.selectAllMatBang();
        request.setAttribute("matBangList", matBangList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void formThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("them.jsp").forward(request, response);
    }

    private void them(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String ma = request.getParameter("ma");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        int tang = Integer.parseInt(request.getParameter("tang"));
        int loai = Integer.parseInt(request.getParameter("loai"));
        String moTa = request.getParameter("moTa");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String ngayChoThue = request.getParameter("ngaybatdau");
        String ngayKetThuc = request.getParameter("ngayketthuc");

        MatBang matBang = new MatBang(ma, dienTich, trangThai, tang, loai, moTa, gia, ngayChoThue, ngayKetThuc);

        matBangService.createMatBang(matBang);
        request.getRequestDispatcher("them.jsp").forward(request, response);
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        matBangService.deleteMatBang(id);
        List<MatBang> matBangList = matBangService.selectAllMatBang();

        request.setAttribute("matBangList", matBangList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
