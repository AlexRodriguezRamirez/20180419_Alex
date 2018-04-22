/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Libro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
@WebServlet(name = "Controlador", urlPatterns = {"/controlador"})
public class Controlador extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String url;
        HttpSession sesion = request.getSession(true);
        ArrayList<Libro> libros = new ArrayList();
        
        if (request.getParameter("Enviar") != null) {
            if (request.getParameter("titulo") == null) {
                request.setAttribute("mensajeError", "Debe seleccionar un libro.");
            }
            else {
                if (request.getParameter("cantidad").equals("") || Integer.parseInt(request.getParameter("cantidad")) <= 0) {
                    request.setAttribute("mensajeError", "La cantidad introducida es incorrecta.");
                }
                
                else {
                    
                    if(sesion.getAttribute("libros") != null){
                        libros = (ArrayList<Libro>)sesion.getAttribute("libros");
                    }

                    Libro libro;
                    int indice = -1;
                    Iterator<Libro> it = libros.iterator();

                    while(it.hasNext() && indice == -1){
                        libro = it.next();
                
                        if(request.getParameter("titulo").equals(libro.getTitulo())){
                            indice = libros.indexOf(libro);
                        }
                    }
            
                    if(indice != -1){
                        libro = libros.get(indice);
                
                        libro.setCantidad(libro.getCantidad() + Integer.parseInt(request.getParameter("cantidad")));
                        libros.remove(indice);
                    }
            
                    else {
                        libro = new Libro();
                        libro.setTitulo(request.getParameter("titulo"));
                        libro.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                    }
            
                    libros.add(libro);
                    request.setAttribute("mensaje", "Se han añadido " + request.getParameter("cantidad") + " unidades del libro \"" + request.getParameter("titulo") + "\"");
            
                    sesion.setAttribute("libros", libros);
                    
                   
                }
            }
            url = "index.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        
        if (request.getParameter("Finalizar") != null) {
            libros = (ArrayList<Libro>)sesion.getAttribute("libros");
            if (libros == null) {
                request.setAttribute("mensajeError", "El carrito está vacío, por lo que no puede finalizar su compra.");
                url = "index.jsp";
                request.getRequestDispatcher(url).forward(request, response);
            }
            
            else {
                url = "JSP/finalizar.jsp";
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
        
        if (request.getParameter("Volver") != null) {
            url = "index.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        
        if (request.getParameter("Pagar") != null) {
            sesion.setAttribute("libros", null);
            url= "JSP/salida.jsp";
            request.getRequestDispatcher(url).forward(request, response);
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
