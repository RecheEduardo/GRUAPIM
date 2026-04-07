package AcademiaDev;

public class PremiumPlan implements SubscriptionPlan {

    @Override
    public int getMaxActiveEnrollments() {
        return Integer.MAX_VALUE;
    }
}
