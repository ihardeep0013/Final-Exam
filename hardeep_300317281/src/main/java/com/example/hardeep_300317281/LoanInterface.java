package com.example.hardeep_300317281;

import java.sql.SQLException;

public interface LoanInterface {
    public void add(Loan loan) throws ClassNotFoundException, SQLException;
    public Loan edit(Loan loan, String clientno) throws SQLException, ClassNotFoundException;
    public void delete(String clientno) throws SQLException;
    public void display() throws ClassNotFoundException, SQLException;


}
