package com.example.hardeep_300317281;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@RequestMapping
@Controller
public class loanController {
//    Github link
//    https://github.com/ihardeep0013/Final-Exam.git

    DatabaseService service1;
    @Autowired
    Loanservice service;
    @Autowired
    Connection123 connect;
    @RequestMapping(value = "/loanrecords",method = RequestMethod.GET)
    public String showLoanPage(ModelMap model) throws SQLException, ClassNotFoundException {
        service1=new DatabaseService(connect.connect());

        model.addAttribute("todos",service.getLoanRecord());

        return "loanrecords";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showLoanPage2(ModelMap model) throws SQLException, ClassNotFoundException
    {
        return "loanrecords";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String addLoanRecordPage(ModelMap model) throws SQLException, ClassNotFoundException
    {
        return "addloanrecord";
    }
//    private String clientno;
//    private String clientname;
//    private double loanamount;
//    private int years;
//    private String loantype;

    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addLoanRecord(ModelMap model, @RequestParam String clientno,@RequestParam String clientname,@RequestParam  double loanamount,@RequestParam int years,@RequestParam String loantype) throws SQLException, ClassNotFoundException
    {
        if(((service1.search(clientno))))
        {
            model.put("errormessage","Record Exists");
            return "redirect:/loanrecords";
        }
        Loan l=new Loan(clientno,clientname,loanamount,years,loantype);
        service1.add(l);
        model.clear();

        return "redirect:/loanrecords";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String updateLoanRecordPage(ModelMap model) throws SQLException, ClassNotFoundException
    {
        return "updateloanrecord";
    }

    @RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
    public String deleteLoanRecordPage(ModelMap model,@RequestParam String clientno) throws SQLException, ClassNotFoundException
    {
        service1=new DatabaseService(connect.connect());
        service1.delete(clientno);
        model.clear();
        return "redirect:/";
    }


}
