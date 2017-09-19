package com.group2.controler;

import com.group2.model.Reservation;
import com.group2.model.Transport;
import com.group2.model.User;
import com.group2.repository.TransportRepository;
import com.group2.repository.UserRepository;
import com.group2.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebControler {
    private static final String NOBODY = "NOBODY";
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String LOGIN_VIEW = "redirect:login";

    private String currentUser = NOBODY;

    @Autowired
    private UserRepository userData;
    @Autowired
    private TransportRepository transportData;
    @Autowired
    private ReservationRepository reservationData;

    @RequestMapping("/")
    public ModelAndView webRoot() {
        if (currentUser.equals(NOBODY))
            return new ModelAndView("emptyWeb");
        if (currentUser.equals(ADMIN_LOGIN))
            return new ModelAndView("admin");
        long id = 0L;
        for (User u : userData.findAll()) {
            if (currentUser.equals(u.getLogin())) {
                id = u.getId();
                break;
            }
        }
        return new ModelAndView("loginsucc", "id", id);
    }

    @RequestMapping("register")
    public ModelAndView addNewUserView() {
        return new ModelAndView("newUser");
    }

    @PostMapping("register")
    public String addNewUser(@Valid User user) {
        user.setPassword(cryptPasswd(user.getPassword()));
        userData.save(user);
        return ("redirect:/");
    }

    @RequestMapping("login")
    public ModelAndView loginView() {
        return new ModelAndView("login");
    }

    @PostMapping("login")
    public String loginUser(@Valid User user) {
        if (user.getLogin().equals(ADMIN_LOGIN) && user.getPassword().equals(ADMIN_PASSWORD)) {
            currentUser = ADMIN_LOGIN;
            return ("redirect:/");
        }
        for (User u : userData.findAll()) {
            if (user.getLogin().equals(u.getLogin()) && cryptPasswd(user.getPassword()).equals(u.getPassword())) {
                currentUser = user.getLogin();
                return ("redirect:/");
            }
        }
        return LOGIN_VIEW;
    }


    @RequestMapping("logout")
    public ModelAndView logout() {
        currentUser = NOBODY;
        return webRoot();
    }

    @RequestMapping("listUsers")
    public ModelAndView listUsers() {
        if (currentUser.equals(ADMIN_LOGIN))
            return new ModelAndView("allUsers", "users", userData.findAll());
        return loginView();
    }

    @PostMapping("listUsers")
    public String deleteUser(@Valid long id) {
        if (currentUser.equals(ADMIN_LOGIN)) {
            userData.delete(id);
            return ("redirect:listUsers");
        }
        return LOGIN_VIEW;
    }

    @RequestMapping("updateUser")
    public ModelAndView UpdateUserForm(@Valid long id) {
        if (currentUser.equals(ADMIN_LOGIN)) {
            if (userData.findOne(id) == null)
                return listUsers();
            return new ModelAndView("updateUser", "user", userData.findOne(id));
        }
        User user = userData.findOne(id);
        if (currentUser.equals(user.getLogin())) {
            return new ModelAndView("updateUser", "user", user);
        }
        return loginView();
    }

    @PostMapping("updateUser")
    public String updateUser(@Valid User user) {
        user.setPassword(cryptPasswd(user.getPassword()));
        if (currentUser.equals(ADMIN_LOGIN)) {
            userData.save(user);
            return ("redirect:listUsers");
        }
        for (User u : userData.findAll()) {
            if (currentUser.equals(u.getLogin()) && u.getId() == user.getId()) {
                currentUser = user.getLogin();
                userData.save(user);
                return "redirect:/";
            }
        }
        return LOGIN_VIEW;
    }

    @PostMapping("addNewRoute")
    public String addNewRoute(Transport transport) {
        if (currentUser.equals(ADMIN_LOGIN)) {
            transportData.save(transport);
            return ("redirect:/");
        }
        return LOGIN_VIEW;
    }

    @RequestMapping("addNewRoute")
    public ModelAndView addNewTransportView() {
        if (currentUser.equals(ADMIN_LOGIN))
            return new ModelAndView("newTransport");
        return loginView();
    }

    @RequestMapping("listTransports")
    public ModelAndView listTransports() {
        if (currentUser.equals(NOBODY))
            return loginView();
        if (currentUser.equals(ADMIN_LOGIN))
            return new ModelAndView("listOfTransports", "transports", transportData.findAll());
        return new ModelAndView("listTransportForUser", "transports", transportData.findAll());

    }

    @PostMapping("listTransports")
    public String deleteTransport(@Valid long id) {
        if (currentUser.equals(ADMIN_LOGIN)) {
            transportData.delete(id);
            return ("redirect:listTransports");
        }
        return LOGIN_VIEW;
    }

    @PostMapping("listTransports/update")
    public String updateTransport(@Valid Transport transport) {
        if (currentUser.equals(ADMIN_LOGIN)) {
            Transport CurrentTransport = transportData.findOne(transport.getId());
            transport.setDateOfFlight(CurrentTransport.getDateOfFlight());
            transport.setDeparture(CurrentTransport.getDeparture());
            transport.setDestiny(CurrentTransport.getDestiny());
            transportData.save(transport);
            return ("redirect:/listTransports");
        }
        return LOGIN_VIEW;
    }

    @RequestMapping("listTransports/update")
    public ModelAndView updateTransportView(@Valid long id) {
        if (currentUser.equals(ADMIN_LOGIN))
            return new ModelAndView("updateTransport", "transport", transportData.findOne(id));
        return loginView();
    }



    @RequestMapping("listTransport/reservation")
    public String transport(@Valid Long id) {
        if (currentUser.equals(NOBODY))
            return LOGIN_VIEW;
        for (User u : userData.findAll()) {
            if (u.getLogin().equals(currentUser)) {
                Reservation reservation = new Reservation();
                reservation.setUserId(u.getId());
                reservation.setTransportId(id);
                reservationData.save(reservation);
                break;
            }
        }
        return ("redirect:/reservations");
    }

    @RequestMapping("reservations")
    public ModelAndView reservatonList() {
        if (currentUser.equals(NOBODY))
            return loginView();
        long userId = 0L;
        for (User u : userData.findAll()) {
            if (currentUser.equals(u.getLogin())) {
                userId = u.getId();
                break;
            }
        }
        List<Transport> reservedTransportByUser = new ArrayList<>();
        for (Reservation r : reservationData.findAll()) {
            if (r.getUserId() == userId) {
                reservedTransportByUser.add(transportData.findOne(r.getTransportId()));
            }
        }
        return new ModelAndView("userReservations", "transports", reservedTransportByUser);
    }

    @PostMapping("reservations")
    public String cancelReservation(@Valid Long id) {
        if (currentUser.equals(NOBODY))
            return LOGIN_VIEW;
        Long userId = 0L;
        for (User u : userData.findAll()) {
            if (currentUser.equals(u.getLogin())) {
                userId = u.getId();
                break;
            }
        }
        for (Reservation r : reservationData.findAll()) {
            if (r.getUserId() == userId) {
                if (r.getTransportId() == id) {
                    reservationData.delete(r.getId());
                    break;
                }
            }
        }
        return ("redirect:/reservations");
    }

    @PostMapping("findRoute")
    public ModelAndView findRoutes(Transport transport) {
        if (currentUser.equals(NOBODY))
            return loginView();
        List<Transport> newRouteList = new ArrayList<>();
        for (Transport e : transportData.findAll()) {
            if (transport.getDeparture().equals(e.getDeparture()) &&
                    transport.getDestiny().equals(e.getDestiny())) {
                newRouteList.add(e);
            }
        }
        return new ModelAndView("listTransportForUser", "transports", newRouteList);
    }

    private String cryptPasswd(String passwd) {
        StringBuilder result = new StringBuilder();
        result.append(passwd);
        return result.reverse().toString();
    }
}
