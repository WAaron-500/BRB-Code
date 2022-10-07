package frc.robot.subsystems.drivetrain;

import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {

    private final DriveIO driveIO;
    private final VictorSP left;
    private final VictorSP right;

    public DifferentialDrive driveBase;

    public DriveBase(DriveIO driveIO) {
        this.driveIO = driveIO;

        this.left = driveIO.getLeftMotor();
        this.right = driveIO.getRightMotor();

        this.driveBase = new DifferentialDrive(left, right);
    }

    @Override
    public void periodic() {
    }

    public void driveSpeed(double leftSpeed, double rightSpeed) {
        driveIO.setSpeed(leftSpeed, rightSpeed);
    }

    public void stop() {
        driveIO.setSpeed(0, 0);
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds();
    }
}
