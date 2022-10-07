package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public interface DriveIO {

    public default VictorSP getLeftMotor() {
        return null;
    }

    public default VictorSP getRightMotor() {
        return null;
    }

    /** Sets the velocity of the drivetrain motors (closed loop) */
    public default void setVelocity(double leftSpeed,
            double rightSpeed) {
    }

    public default void setSpeed(double leftSpeed, double rightSpeed) {

    }
}
