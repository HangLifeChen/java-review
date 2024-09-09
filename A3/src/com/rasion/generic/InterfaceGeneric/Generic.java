package com.rasion.generic.InterfaceGeneric;

public class Generic {
    public static void main(String[] args) {
        User user = new User();
        user.add(new User());
        Customer customer = new Customer();
        customer.add(new Customer());

        Data<User> data = new User();
        data.add(new User());
        data.get(0);

        Data<Customer> data2 = new Customer();
        data2.add(new Customer());
    }
}

class Customer implements Data<Customer>{
    @Override
    public void add(Customer e) { }
    @Override
    public void delete(Customer e) {}

    @Override
    public Customer get(int index) {return null;}

    @Override
    public void update(Customer e) {}
}

class User implements Data<User>{
    @Override
    public void add(User e) { }
    @Override
    public void delete(User e) {}

    @Override
    public User get(int index) {return null;}

    @Override
    public void update(User e) {}
}