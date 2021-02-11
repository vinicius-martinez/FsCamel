package br.com.impacta.camel.springboot.helloworld;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomerService {

    private static Set<Customer> customerSet = new HashSet<Customer>(0);

    public Customer addCustomer(Customer customer){
        if (customerSet.contains(customer)){
            for (Customer customerEntity : customerSet) {
                if (customerEntity.equals(customer)){
                    return customerEntity;
                }
            }
        }
        customerSet.add(customer);
        return customer;
    }

    public Customer getCustomer(Long customerid){
        Customer customer = new Customer();
        customer.setCustomerId(customerid);
        if (customerSet.contains(customer)){
            for (Customer customerEntity : customerSet) {
                if (customerEntity.equals(customer)){
                    return customerEntity;
                }
            }
        }
        return null;
    }
    public Set<Customer> listCustomer(){
        return customerSet;
    }

    public Customer deleteCustomer(Long customerid){
        Customer customer = new Customer();
        customer.setCustomerId(customerid);
        if (customerSet.contains(customer)){
            customerSet.remove(customer);
            return customer;
        }
        return null;
    }

    public Customer updateCustomer(Customer customer){
        if (customerSet.contains(customer)){
            for (Customer customerEntity : customerSet) {
                if (customerEntity.equals(customer)){
                    customerEntity.setCustomerId(customer.getCustomerId());
                    customerEntity.setFirstName(customer.getFirstName());
                    customerEntity.setLastName(customer.getLastName());
                    customerSet.remove(customer);
                    customerSet.add(customerEntity);
                    return customerEntity;
                }
            }
        }
        return null;
    }

}
