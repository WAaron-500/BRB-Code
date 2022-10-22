package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public interface DriveIO {

    public default WPI_TalonSRX getLeftMotors() {
        return null;
    }

    public default WPI_TalonSRX getRightMotors() {
        return null;
    }

    /** Sets the velocity of the drivetrain motors (closed loop) */
    public default void setVelocity(double leftSpeed,
            double rightSpeed) {
    }

    public default void setSpeed(double leftSpeed, double rightSpeed) {

    }
}
