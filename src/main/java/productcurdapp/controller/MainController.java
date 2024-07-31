package productcurdapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;
import productcurdapp.entities.Product;
import productcurdapp.repository.ProductRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    private ProductRepository productRepository;



    @RequestMapping("/")
    public String homeHandler(){

        return "index";
    }

    @RequestMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("title", "add Product");

        return "add_product_form";
    }

    @RequestMapping(path = "/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request){
        System.out.println(product);
        productRepository.addProduct(product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;


    }
}
