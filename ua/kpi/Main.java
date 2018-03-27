package ua.kpi;

import ua.kpi.controller.Controller;

public class Main {

    public static void main(String[] args) {
        // Initialization
        View view = new View();
        Controller controller = new Controller(view);

        // Run
        controller.processUser();
    }

}
