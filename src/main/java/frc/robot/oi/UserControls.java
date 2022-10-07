package frc.robot.oi;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface UserControls {
    public default double getLeftDriveX() {
        return 0.0;
    }

    public default double getLeftDriveY() {
        return 0.0;
    }

    public default double getRightDriveX() {
        return 0.0;
    }

    public default double getRightDriveY() {
        return 0.0;
    }

    public default Trigger ClimbUpButton() {
        return new Trigger();
    }

    public default Trigger ClimbDownButton() {
        return new Trigger();
    }

    public default Trigger ClimbLeftButton() {
        return new Trigger();
    }

    public default Trigger ClimbRightButton() {
        return new Trigger();
    }

    public default Trigger getIntakeRunInButton() {
        return new Trigger();
    }

    public default Trigger getIntakeRunOutButton() {
        return new Trigger();
    }
}
