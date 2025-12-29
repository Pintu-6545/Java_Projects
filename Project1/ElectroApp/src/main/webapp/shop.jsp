<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body>

    <!-- Single Page Header start -->
    <div class="container-fluid page-header py-5">
        <h1 class="text-center text-white display-6 wow fadeInUp" data-wow-delay="0.1s">Shop Page</h1>
        <ol class="breadcrumb justify-content-center mb-0 wow fadeInUp" data-wow-delay="0.3s">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Pages</a></li>
            <li class="breadcrumb-item active text-white">Shop</li>
        </ol>
    </div>
    <!-- Single Page Header End -->

    <!-- Searvices Start -->
    <div class="container-fluid px-0">
        <div class="row g-0">
            <div class="col-6 col-md-4 col-lg-2 border-start border-end wow fadeInUp" data-wow-delay="0.1s">
                <div class="p-4">
                    <div class="d-inline-flex align-items-center">
                        <i class="fa fa-sync-alt fa-2x text-primary"></i>
                        <div class="ms-4">
                            <h6 class="text-uppercase mb-2">Free Return</h6>
                            <p class="mb-0">30 days money back guarantee!</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6 col-md-4 col-lg-2 border-end wow fadeInUp" data-wow-delay="0.2s">
                <div class="p-4">
                    <div class="d-flex align-items-center">
                        <i class="fab fa-telegram-plane fa-2x text-primary"></i>
                        <div class="ms-4">
                            <h6 class="text-uppercase mb-2">Free Shipping</h6>
                            <p class="mb-0">Free shipping on all order</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6 col-md-4 col-lg-2 border-end wow fadeInUp" data-wow-delay="0.3s">
                <div class="p-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-life-ring fa-2x text-primary"></i>
                        <div class="ms-4">
                            <h6 class="text-uppercase mb-2">Support 24/7</h6>
                            <p class="mb-0">We support online 24 hrs a day</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6 col-md-4 col-lg-2 border-end wow fadeInUp" data-wow-delay="0.4s">
                <div class="p-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-credit-card fa-2x text-primary"></i>
                        <div class="ms-4">
                            <h6 class="text-uppercase mb-2">Receive Gift Card</h6>
                            <p class="mb-0">Recieve gift all over oder $50</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6 col-md-4 col-lg-2 border-end wow fadeInUp" data-wow-delay="0.5s">
                <div class="p-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-lock fa-2x text-primary"></i>
                        <div class="ms-4">
                            <h6 class="text-uppercase mb-2">Secure Payment</h6>
                            <p class="mb-0">We Value Your Security</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6 col-md-4 col-lg-2 border-end wow fadeInUp" data-wow-delay="0.6s">
                <div class="p-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-blog fa-2x text-primary"></i>
                        <div class="ms-4">
                            <h6 class="text-uppercase mb-2">Online Service</h6>
                            <p class="mb-0">Free return products in 30 days</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Searvices End -->




    <!-- Shop Page Start -->
    <div class="container-fluid shop py-5">
        <div class="container py-5">
            <div class="row g-4">
                <div class="col-lg-3 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="product-categories mb-4">
                        <h4>Products Categories</h4>
                        <ul class="list-unstyled">
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i class="fas fa-apple-alt text-secondary me-2"></i>
                                        Phone</a>
                                    <span>(3)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i class="fas fa-apple-alt text-secondary me-2"></i>
                                        Laptop</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Tablet</a>
                                    <span>(2)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Computer</a>
                                    <span>(8)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Headphone</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Smart Watch</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Fridge</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Cooler</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Fan</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Watching Machine</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                            <li>
                                <div class="categories-item">
                                    <a href="#" class="text-dark"><i
                                            class="fas fa-apple-alt text-secondary me-2"></i>Digital Light</a>
                                    <span>(5)</span>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="row g-4">
                        <div class="col-xl-7">
                            <div class="input-group w-100 mx-auto d-flex">
                                <input type="search" class="form-control p-3" placeholder="keywords"
                                    aria-describedby="search-icon-1">
                                <span id="search-icon-1" class="input-group-text p-3"><i
                                        class="fa fa-search"></i></span>
                            </div>
                        </div>
                        <div class="col-xl-3 text-end">
                            <div class="bg-light ps-3 py-3 rounded d-flex justify-content-between">
                                <label for="electronics">Sort By:</label>
                                <select id="electronics" name="electronicslist"
                                    class="border-0 form-select-sm bg-light me-3" form="electronicsform">
                                    <option value="volvo">Default Sorting</option>
                                    <option value="volv">Nothing</option>
                                    <option value="sab">Popularity</option>
                                    <option value="saab">Newness</option>
                                    <option value="opel">Average Rating</option>
                                    <option value="audio">Low to high</option>
                                    <option value="audi">High to low</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-xl-2">
                            <ul class="nav nav-pills d-inline-flex text-center py-2 px-2 rounded bg-light mb-4">
                                <li class="nav-item me-4">
                                    <a class="bg-light" data-bs-toggle="pill" href="#tab-5">
                                        <i class="fas fa-th fa-3x text-primary"></i>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="bg-light" data-bs-toggle="pill" href="#tab-6">
                                        <i class="fas fa-bars fa-3x text-primary"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div id="tab-5" class="tab-pane fade show p-0 active">
                            <div class="row g-4 product">
                                <%
                                   List<Product> list = ProductDao.getAllProducts();
                                  for(Product p : list)
                                  {
                             
                                %>
                                <div class="col-lg-4">
                                    <div class="product-item rounded wow fadeInUp" data-wow-delay="0.1s">
                                        <div class="product-item-inner border rounded">
                                            <div class="product-item-inner-item">
                                                <img src="product_image/<%=p.getProduct_image() %>" class="img-fluid w-100 rounded-top" style="height:240px;" alt="">
                                                <div class="product-new">New</div>
                                                <div class="product-details">
                                                    <a href="#"><i class="fa fa-eye fa-1x"></i></a>
                                                </div>
                                            </div>
                                            <div class="text-center rounded-bottom p-4">
                                               <!--   <a href="#" class="d-block mb-2">SmartPhone</a> -->
                                               
                                                <a href="#" class="d-block h4"><%=p.getProduct_name() %></a>
                                                
                                                <!-- <del class="me-2 fs-5">$1,250.00</del> -->
                                                <span class="text-primary fs-5" style="font-weight: 600">₹ <%= p.getProduct_price() %></span>
                                                

												<div class="my-3">
                                               		<a href="product-detail.jsp?pid=<%= p.getPid() %>"
                                            class="btn btn-primary border-secondary rounded-pill py-2 px-2 mb-6" style="font-size:20px; font-weight: 600; margin:0 44px;">Product Details</a>
                                               </div>                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <%
                                  }
                                %>
                                <div class="col-12 wow fadeInUp" data-wow-delay="0.1s">
                                    <div class="pagination d-flex justify-content-center mt-5">
                                        <a href="#" class="rounded">&laquo;</a>
                                        <a href="#" class="active rounded">1</a>
                                        <a href="#" class="rounded">2</a>
                                        <a href="#" class="rounded">3</a>
                                        <a href="#" class="rounded">4</a>
                                        <a href="#" class="rounded">5</a>
                                        <a href="#" class="rounded">6</a>
                                        <a href="#" class="rounded">&raquo;</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Page End -->
    
    <!-- Related Product Start -->
    <div class="container-fluid related-product">
        <div class="container">
            <div class="mx-auto text-center pb-5" style="max-width: 700px;">
                <h4 class="text-primary mb-4 border-bottom border-primary border-2 d-inline-block p-2 title-border-radius wow fadeInUp"
                    data-wow-delay="0.1s">Related Products</h4>
                <p class="wow fadeInUp" data-wow-delay="0.2s">Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Modi, asperiores ducimus sint quos tempore officia similique quia? Libero, pariatur consectetur?</p>
            </div>
          
            <div class="related-carousel owl-carousel pt-4">
                             <%
                                   List<Product> list1 = ProductDao.getAllProducts();
                                  for(Product p1 : list1)
                                  {
                             
                            %>
                <div class="related-item rounded">
                    <div class="related-item-inner border rounded">
                        <div class="related-item-inner-item">
                            <img src="product_image/<%=p1.getProduct_image() %>"style="height:200px;" class="img-fluid w-100 rounded-top" alt="">
                            <div class="related-new">New</div>
                            <div class="related-details">
                                <a href="#"><i class="fa fa-eye fa-1x"></i></a>
                            </div>
                        </div>
                        <div class="text-center rounded-bottom p-4">
                            <a href="#" class="d-block h4"><%=p1.getProduct_name() %></a>
                            <span class="text-primary fs-5" style="font-weight: 600">₹ <%=p1.getProduct_price() %></span>
                        </div>
                    </div>
                    <div class="related-item-add border border-top-0 rounded-bottom  text-center p-4 pt-0">
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="d-flex">
								<a href="product-detail.jsp?pid=<%= p1.getPid() %>" style="font-weight: 600" class="btn btn-primary border-secondary rounded-pill py-2 px-4 mb-2">Product Details</a>
                            </div>
                            <div class="d-flex">
                                <a href="#"
                                    class="text-primary d-flex align-items-center justify-content-center me-3"><span
                                        class="rounded-circle btn-sm-square border"><i
                                            class="fas fa-random"></i></i></a>
                                <a href="#"
                                    class="text-primary d-flex align-items-center justify-content-center me-0"><span
                                        class="rounded-circle btn-sm-square border"><i class="fas fa-heart"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                                  }
            %>
            </div>
        </div>
    </div>
    <!-- Related Product End -->

    <!-- Product Banner Start -->
    <div class="container-fluid py-5">
        <div class="container pb-5">
            <div class="row g-4">
                <div class="col-lg-6 wow fadeInLeft" data-wow-delay="0.1s">
                    <a href="#">
                        <div class="bg-primary rounded position-relative">
                            <img src="img/product-banner.jpg" class="img-fluid w-100 rounded" alt="">
                            <div class="position-absolute top-0 start-0 w-100 h-100 d-flex flex-column justify-content-center rounded p-4"
                                style="background: rgba(255, 255, 255, 0.5);">
                                <h3 class="display-5 text-primary">EOS Rebel <br> <span>T7i Kit</span></h3>
                                <p class="fs-4 text-muted">$899.99</p>
                                <a href="#" class="btn btn-primary rounded-pill align-self-start py-2 px-4">Shop Now</a>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-6 wow fadeInRight" data-wow-delay="0.2s">
                    <a href="#">
                        <div class="text-center bg-primary rounded position-relative">
                            <img src="img/product-banner-2.jpg" class="img-fluid w-100" alt="">
                            <div class="position-absolute top-0 start-0 w-100 h-100 d-flex flex-column justify-content-center rounded p-4"
                                style="background: rgba(242, 139, 0, 0.5);">
                                <h2 class="display-2 text-secondary">SALE</h2>
                                <h4 class="display-5 text-white mb-4">Get UP To 50% Off</h4>
                                <a href="#" class="btn btn-secondary rounded-pill align-self-center py-2 px-4">Shop
                                    Now</a>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- Product Banner End -->

    <!-- Footer Start -->
    <div class="container-fluid footer py-5 wow fadeIn" data-wow-delay="0.2s">
        <div class="container py-5">
            <div class="row g-4 rounded mb-5" style="background: rgba(255, 255, 255, .03);">
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="rounded p-4">
                        <div class="rounded-circle bg-secondary d-flex align-items-center justify-content-center mb-4"
                            style="width: 70px; height: 70px;">
                            <i class="fas fa-map-marker-alt fa-2x text-primary"></i>
                        </div>
                        <div>
                            <h4 class="text-white">Address</h4>
                            <p class="mb-2">123 Street New York.USA</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="rounded p-4">
                        <div class="rounded-circle bg-secondary d-flex align-items-center justify-content-center mb-4"
                            style="width: 70px; height: 70px;">
                            <i class="fas fa-envelope fa-2x text-primary"></i>
                        </div>
                        <div>
                            <h4 class="text-white">Mail Us</h4>
                            <p class="mb-2">info@example.com</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="rounded p-4">
                        <div class="rounded-circle bg-secondary d-flex align-items-center justify-content-center mb-4"
                            style="width: 70px; height: 70px;">
                            <i class="fa fa-phone-alt fa-2x text-primary"></i>
                        </div>
                        <div>
                            <h4 class="text-white">Telephone</h4>
                            <p class="mb-2">(+012) 3456 7890</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="rounded p-4">
                        <div class="rounded-circle bg-secondary d-flex align-items-center justify-content-center mb-4"
                            style="width: 70px; height: 70px;">
                            <i class="fab fa-firefox-browser fa-2x text-primary"></i>
                        </div>
                        <div>
                            <h4 class="text-white">Yoursite@ex.com</h4>
                            <p class="mb-2">(+012) 3456 7890</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row g-5">
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="footer-item d-flex flex-column">
                        <div class="footer-item">
                            <h4 class="text-primary mb-4">Newsletter</h4>
                            <p class="text-white mb-3">Dolor amet sit justo amet elitr clita ipsum elitr est.Lorem ipsum
                                dolor sit amet, consectetur adipiscing elit consectetur adipiscing elit.</p>
                            <div class="position-relative mx-auto rounded-pill">
                                <input class="form-control rounded-pill w-100 py-3 ps-4 pe-5" type="text"
                                    placeholder="Enter your email">
                                <button type="button"
                                    class="btn btn-primary rounded-pill position-absolute top-0 end-0 py-2 mt-2 me-2">SignUp</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="footer-item d-flex flex-column">
                        <h4 class="text-primary mb-4">Customer Service</h4>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Contact Us</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Returns</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Order History</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Site Map</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Testimonials</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> My Account</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Unsubscribe Notification</a>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="footer-item d-flex flex-column">
                        <h4 class="text-primary mb-4">Information</h4>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> About Us</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Delivery infomation</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Privacy Policy</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Terms & Conditions</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Warranty</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> FAQ</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Seller Login</a>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6 col-xl-3">
                    <div class="footer-item d-flex flex-column">
                        <h4 class="text-primary mb-4">Extras</h4>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Brands</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Gift Vouchers</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Affiliates</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Wishlist</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Order History</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Track Your Order</a>
                        <a href="#" class=""><i class="fas fa-angle-right me-2"></i> Track Your Order</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Copyright Start -->
    <div class="container-fluid copyright py-4">
        <div class="container">
            <div class="row g-4 align-items-center">
                <div class="col-md-6 text-center text-md-start mb-md-0">
                    <span class="text-white"><a href="#" class="border-bottom text-white"><i
                                class="fas fa-copyright text-light me-2"></i>Your Site Name</a>, All right
                        reserved.</span>
                </div>
                <div class="col-md-6 text-center text-md-end text-white">

                    <!--/*** This template is free as long as you keep the below author’s credit link/attribution link/backlink. ***/-->
                    <!--/*** If you'd like to use the template without the below author’s credit link/attribution link/backlink, ***/-->
                    <!--/*** you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". ***/-->
                    Designed By <a class="border-bottom text-white" href="https://htmlcodex.com">HTML Codex</a>.
                    Distributed By <a class="border-bottom text-white" href="https://themewagon.com">ThemeWagon</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Copyright End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary btn-lg-square back-to-top"><i class="fa fa-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>


    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>