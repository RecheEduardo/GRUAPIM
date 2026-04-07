package AcademiaDev;

public class Student extends User {
    private SubscriptionPlan subscriptionPlan;

    // getters
    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    // setters
    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public Student(String name, String email, SubscriptionPlan subscriptionPlan) {
        super(name, email);
        this.subscriptionPlan = subscriptionPlan;
    }
}
