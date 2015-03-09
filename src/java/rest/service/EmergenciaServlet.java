/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import com.google.gson.Gson;
import entities.Emergencia;
import entities.Persona;
import entities.Unidad;
import entities.session.EmergenciaFacade;
import entities.session.PersonaFacade;
import entities.session.UnidadFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import rest.service.auxiliar.EmergenciaAuxiliar;

/**
 *
 * @author gurzaf
 */
@ManagedBean
public class EmergenciaServlet extends HttpServlet {

    @EJB
    private EmergenciaFacade ejbFacade;
    @EJB
    private UnidadFacade unidadFacade;
    @EJB
    private PersonaFacade personaFacade;
    
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
//        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String body = convertInputStreamToString(request.getReader());
            String dispositivo = request.getParameter("dispositivo");
            if(dispositivo==null || dispositivo.trim().isEmpty()){
                dispositivo = "PRUEBA";
            }
            try {
                EmergenciaAuxiliar[] emergencias = new Gson().fromJson(body,EmergenciaAuxiliar[].class);
                
                for (EmergenciaAuxiliar temp : emergencias) {
                    //Definicion del Objeto emergencia
                    Emergencia emergencia = new Emergencia();                    
                    //Id
                    emergencia.setEmeId(dispositivo+"-"+temp.getEmeId());
                    //Fecha
                    //Casting de emeFecha
                    SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
                    Date emeFecha = formateadorFecha.parse(temp.getEmeFecha()); 
                    emergencia.setEmeFecha(emeFecha);                    
                    //Hora
                    //Casting de emeHora
                    SimpleDateFormat formateadorHora = new SimpleDateFormat("HH:mm:ss");
                    Date emeHora =  formateadorHora.parse(temp.getEmeHora().concat(":00"));
                    emergencia.setEmeHora(emeHora);                    
                    //Informante 
                    //Casting de Informate al tipo de Objeto Persona
                    String idPersona = temp.getEmeInformante().toString();
                    if(idPersona.equals("1"))
                        idPersona="001";
                    Persona persona = personaFacade.find(idPersona);
                    emergencia.setEmeInformante(persona);
                    //Informacion Recibida
                    emergencia.setEmeInformacionRecibida(temp.getEmeInformacionRecibida());
                    //Medio de Informacion
                    emergencia.setEmeMedioInformacion(temp.getEmeMedioInformacion());
                    //Descripcion otro Medio de Informacion
                    emergencia.setEmeDescripcionOtroMedio(temp.getEmeDescripcionOtroMedio());
                    //Persona confirmacion
                    emergencia.setEmePersonaConfirmacion(temp.getEmePersonaConfirmacion());
                    //Medio de Confirmacion
                    emergencia.setEmeMedioConfirmacion(temp.getEmeMedioConfirmacion());
                    //Descripcion otro Medio de Confirmacion
                    emergencia.setEmeDescripcionOtroMedioC(temp.getEmeDescripcionOtroMedioC());
                    //Direccion
                    emergencia.setEmeDireccion(temp.getEmeDireccion());
                    //Inmueble Clase
                    emergencia.setEmeInmuebleClase(temp.getEmeInmuebleClase());
                    //Inmueble Propietario
                    emergencia.setEmeInmueblePropietario(temp.getEmeInmueblePropietario());
                    //Inmueble Administrador
                    emergencia.setEmeInmuebleAdministrador(temp.getEmeInmuebleAdministrador());
                    //Inmueble Arrendatario
                    emergencia.setEmeInmuebleArrendatario(temp.getEmeInmuebleArrendatario());
                    //Novedades                    
                    emergencia.setEmeNovedades(temp.getEmeNovedades());                                                                                                                            
                    //Informante 
                    //Casting de Comandante al tipo de Objeto Unidad
                    String idComandante = temp.getEmeComandante().toString();
                    if(idComandante.equals("1"))
                        idComandante="12cvb";
                    Unidad unidad = unidadFacade.find(idComandante);
                    emergencia.setEmeComandante(unidad);
                    //Estado                    
                    emergencia.setEmeEstado(temp.getEmeEstado());                                                                                                                            
                    //Tipo de Emergencia                    
                    emergencia.setEmeTipoe(temp.getEmeTipoe());                                                                                                                                                                                      
                    ejbFacade.create(emergencia);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
//            out.write("lol");
        }
    }
    
    private String convertInputStreamToString(BufferedReader reader) throws IOException{
        String line;
        String result = "";
        while((line = reader.readLine()) != null)
            result += line;
        return result;
 
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
