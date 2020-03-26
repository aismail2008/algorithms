package com.code.test.designpatterns.Builder;

/* "Product" */
public class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public Pizza() {
    }

    public Pizza(String dough, String sauce, String topping) {
        this.dough = dough;
        this.sauce = sauce;
        this.topping = topping;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public static class CustomPizzaBuilder {
        private String dough = "";
        private String sauce = "";
        private String topping = "";

//        public CustomPizzaBuilder(){};

        public CustomPizzaBuilder buildDough(String dough) {
            this.dough = dough;
            return this;
        }

        public CustomPizzaBuilder buildSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public CustomPizzaBuilder buildTopping(String topping) {
            this.topping = topping;
            return this;
        }

        public Pizza build() {
            return new Pizza(this.dough, this.sauce, this.topping);
        }
    }
}
