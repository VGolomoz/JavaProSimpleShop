package simpleshop.service;

import simpleshop.entity.User;

public class Autorization {

    DAO dao;

    public Autorization(DAO dao) {
        this.dao = dao;
    }

    public String autorization(String login, String password) {

        String result = "wrong";

        User user = dao.findUserByNameAndPass(login, password);
        if (user != null) {
            switch (user.getRole()) {
                case "client":
                    result = "/client";
                    break;
                case "manager":
                    result = "/manager";
                    break;
            }
        }

        return result;
    }
}
