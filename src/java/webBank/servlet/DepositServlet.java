/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webBank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import webBank.jpa.AccountJpaController;
import webBank.jpa.HistoryJpaController;
import webBank.jpa.exceptions.NonexistentEntityException;
import webBank.jpa.exceptions.RollbackFailureException;
import webBank.model.Account;
import webBank.model.History;

/**
 *
 * @author maysmiler
 */
public class DepositServlet extends HttpServlet {

    @Resource
    UserTransaction utx;
    @PersistenceUnit(unitName = "webBankPU")
    EntityManagerFactory emf;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
          session.setAttribute("messageDepo", "Enter money to deposit");
        String depotext = request.getParameter("deposit");
        Account acSession = (Account) session.getAttribute("account");
            if (acSession != null) {
                if (depotext != null) {
                    int deposit = Integer.parseInt(depotext);
                    AccountJpaController accountJpaCtrl = new AccountJpaController(utx, emf);
                    HistoryJpaController historyJpaCtrl = new HistoryJpaController(utx, emf);
                    Account account = accountJpaCtrl.findAccount(acSession.getAccountid());
                    account.setBalance(account.getBalance() + deposit);
                    History history = new History(account, "Deposit", deposit, new Date(), account.getBalance());
                    try {
                        accountJpaCtrl.edit(account);
                        historyJpaCtrl.create(history);
                        session.setAttribute("account", account);
                        session.setAttribute("messages", "Deposit Complete");
                        response.sendRedirect("MyAccount");
                        return;
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RollbackFailureException ex) {
                        Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(DepositServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            
             getServletContext().getRequestDispatcher("/Deposit.jsp").forward(request, response);    
        }else{
          getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
