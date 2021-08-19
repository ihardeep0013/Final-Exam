package com.example.hardeep_300317281;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{
    Connection con;
    public DatabaseService(Connection con)
    {
        this.con=con;
    }
    @Override
    public void add(Loan loan) throws ClassNotFoundException, SQLException {
        String query1="INSERT INTO loantable VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement=con.prepareStatement(query1);
        preparedStatement.setString(1,loan.getClientno());
        preparedStatement.setString(2,loan.getClientname());
        preparedStatement.setDouble(3,loan.getLoanamount());
        preparedStatement.setInt(4,loan.getYears());
        preparedStatement.setString(5,loan.getLoantype());
        preparedStatement.executeUpdate();
    }

    @Override
    public Loan edit(Loan loan, String clientno) throws SQLException, ClassNotFoundException {



        String query2="UPDATE loantable set clientno=?, clientname=?,loanamount=?, years=?, loantype=? where clientno=?";
        PreparedStatement preparedStatement2=con.prepareStatement(query2);
        preparedStatement2.setString(1,loan.getClientno());
        preparedStatement2.setString(2,loan.getClientname());
        preparedStatement2.setDouble(3,loan.getLoanamount());
        preparedStatement2.setInt(4,loan.getYears());
        preparedStatement2.setString(5,loan.getLoantype());
        preparedStatement2.setString(6,loan.getClientno());
        preparedStatement2.executeUpdate();
        return loan;
    }

    @Override
    public void delete(String clientno) throws SQLException {
        String quer1 = "Delete from loantable where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        query.executeUpdate();
    }

    @Override
    public List<Loan> display() throws ClassNotFoundException, SQLException {
        String quer1 = "Select * from loantable";
        List<Loan> loanrecords = new ArrayList<Loan>();
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        if(!rs.first()){
            System.out.print("Record not exist");
            return null;
        }
        Loan obj1=null;
        while (rs.next()) 
        {
            obj1 = new Loan(rs.getString("clientno"), rs.getString("clientname"),rs.getDouble("loanamount"), rs.getInt("years"), rs.getString("loantype"));
            loanrecords.add(obj1);
        }
       
         return loanrecords;
    }

    public boolean search(String clientno)  throws ClassNotFoundException, SQLException{
        String quer1 = "Select * from loantable";
        List<Loan> loanrecords = new ArrayList<Loan>();
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        if(!rs.first()){
            System.out.print("Record not exist");
            return false;
        }
        Loan obj1=null;
        while (rs.next())
        {
            if(rs.getString("clientno").equalsIgnoreCase(clientno))
            {
                return true;
            }
        }

        return false;
    }
}
