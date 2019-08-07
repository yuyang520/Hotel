package com.javaee.hotel.controller;
import com.javaee.hotel.domain.Customer;
import com.javaee.hotel.domain.CustomerInfo;
import com.javaee.hotel.domain.Hotel;
import com.javaee.hotel.domain.PriceChange;
import com.javaee.hotel.mapper.PriceChangeMapper;
import com.javaee.hotel.service.CustomerListService;
import com.javaee.hotel.service.PriceChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/priceChange")
public class PriceChangeController {
    @Autowired
    private PriceChangeService priceChangeService;

    @GetMapping("")
    public String customerListHtml(HttpServletResponse response,
                                   HttpServletRequest request,
                                   Model model){

        Boolean isLogin = request.getSession().getAttribute("username") !=null ;
        model.addAttribute("isLogin",isLogin);
        return "/priceChange";
    }

    @GetMapping(value = "/priceChange.json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PriceChange> getPriceChangeJson(){
        return priceChangeService.priceChangeRespond();
    }

    @InitBinder
    protected void init( HttpServletRequest request, ServletRequestDataBinder binder ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        dateFormat.setLenient( false );
        binder.registerCustomEditor( Date.class, new CustomDateEditor( dateFormat, false ) );
    }

    @GetMapping("/add")
    public String goCustomerAddPage(Model model){
        model.addAttribute("PriceChange",new PriceChange());
        return "priceChange-add";
    }

    @PostMapping("/add")
    public String savePriceChange(PriceChange priceChange){
        priceChangeService.savePriceChange(priceChange);
        return "redirect:/priceChange";
    }


    @GetMapping("/edit")
    public String goorderEditPage(@RequestParam("priceChangeId") String priceChangeId, Model model){
        PriceChange priceChange = priceChangeService.findPriceChangeByPrimaryKey(priceChangeId);
        model.addAttribute("priceChange",priceChange);
        return "priceChange-edit";
    }

    @PostMapping("/deletePriceChange")
    @ResponseBody
    public boolean deleteRoom(@RequestParam("priceChangeId") String priceChangeId){
        priceChangeService.deletePriceChangeById(priceChangeId);
        return true;
    }


    @PostMapping("/exit")
    @ResponseBody
    public Boolean LogOut(HttpServletResponse response,
                          HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }

}
