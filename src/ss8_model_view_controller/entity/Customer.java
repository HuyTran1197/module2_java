package ss8_model_view_controller.entity;

public class Customer extends Person{
    public Customer() {
    }

    public Customer(int id, String name, String email, String address) {
        super(id, name, email, address);
    }
    @Override
    public String toString(){
        return "Customer "+
                " {"+super.toString()+
                "}";
    }
}
