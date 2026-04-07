package AcademiaDev;

public class BasicPlan implements SubscriptionPlan {

    @Override
    public int getMaxActiveEnrollments() {
        return 3;
    }
}
