package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class ClimberIOBRB implements ClimberIO {

    private final VictorSP upControl;
    private final Spark downControl;

    public ClimberIOBRB() {
        this.upControl = new VictorSP(3);
        this.downControl = new Spark(4);
    }

    @Override
    public void setVelocity(double velocity) {
        if (velocity >= 0) {
            upControl.set(velocity);
            downControl.set(velocity);
        } else if (velocity < 0) {
            downControl.set(velocity);
        }
    }

    @Override
    public void setUpVelocity(double velocity) {
        upControl.set(velocity);
    }

    @Override
    public void setDownVelocity(double velocity) {
        downControl.set(velocity);
    }

    @Override
    public void stop() {
        upControl.set(0);
        downControl.set(0);
    }
}
