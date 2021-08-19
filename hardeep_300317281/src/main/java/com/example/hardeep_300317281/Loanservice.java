package com.example.hardeep_300317281;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Loanservice {
    private static List<Loan> todos=new ArrayList<>();
    private static int todoCount=5;

    public List<Loan> getLoanRecord(){
        List<Loan> loanRecords=new ArrayList<>();
        for(Loan l: loanRecords)
        {
//            loanRecords.add()
        }
        return loanRecords;
    }
}
