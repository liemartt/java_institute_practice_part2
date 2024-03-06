package com.liemartt.pr_6;

public class AbstractFactory {
    interface Button {
        void paint();
    }

    interface Checkbox {
        void paint();
    }

    class WinButton implements Button {
        public void paint() {
            System.out.println("Render a button in a Windows style");
        }
    }

    class MacButton implements Button {
        public void paint() {
            System.out.println("Render a button in a MacOS style");
        }
    }

    class WinCheckbox implements Checkbox {
        public void paint() {
            System.out.println("Render a checkbox in a Windows style");
        }
    }

    class MacCheckbox implements Checkbox {
        public void paint() {
            System.out.println("Render a checkbox in a MacOS style");
        }
    }

    interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    class WinFactory implements GUIFactory {
        public Button createButton() {
            return new WinButton();
        }

        public Checkbox createCheckbox() {
            return new WinCheckbox();
        }
    }

    class MacFactory implements GUIFactory {
        public Button createButton() {
            return new MacButton();
        }

        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }


}
