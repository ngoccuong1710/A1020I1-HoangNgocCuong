<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container-fluid">
        <div class="col-12">
            <div class="row">
                <div class="col-2">
                    <div class="row">
                        <div class="col-12 img_logo">
                        <img style="width: 20%"
                        src="https://mondayvietnam.com/wp-content/uploads/2018/11/quyen-tac-gia-logo.jpg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 name_logo">
                            <div class="h6">Logo</div>
                        </div>
                    </div>
                    </div>
                <div class="col-8"></div>
                <div class="col-2">
                <div class="h5">Hoàng Ngọc Cường</div>
                </div>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <div class="col-2"> </div>
            <div class="col-10 text-center">
                <div class="collapse navbar-collapse" id="navbarScroll">
                    <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll col-9 justify-content-center"
                    style="--bs-scroll-height: 100px;">
                        <li class="nav-item col-2">
                            <a class="nav-link text-center text-dark" href="customer?action=home">Home</a>
                        </li>
                        <li class="nav-item col-2">
                            <a class="nav-link text-center text-dark" href="customer?action=list-employee">Employee</a>
                        </li>
                        <li class="nav-item col-2">
                            <a class="nav-link text-center text-dark" href="customer?action=list-customer">Customer</a>
                        </li>
                        <li class="nav-item col-2">
                            <a class="nav-link text-center text-dark" href="customer?action=list-service">Service</a>
                        </li>
                        <li class="nav-item col-2">
                            <a class="nav-link text-center text-dark" href="customer?action=list-contract">Contract</a>
                        </li>
                    </ul>

                    <form class="d-flex m-0 col-3">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </div>
    </nav>
</body>
</html>
