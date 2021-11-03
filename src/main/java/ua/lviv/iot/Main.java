package ua.lviv.iot;

import org.hibernate.Session;
import ua.lviv.iot.view.MyView;

import static ua.lviv.iot.HibernateUtil.getSession;

public class Main {


    public static void main(final String[] args) throws Exception {

        final Session session = getSession();

        try {
            new MyView().show();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}