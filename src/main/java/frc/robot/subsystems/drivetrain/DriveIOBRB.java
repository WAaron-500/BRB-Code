package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveIOBRB implements DriveIO {

    public WPI_TalonSRX leftLeader;
    public WPI_TalonSRX rightLeader;
    public WPI_TalonSRX leftFollower1;
    public WPI_TalonSRX rightFollower1;
    public WPI_TalonSRX leftFollower2;
    public WPI_TalonSRX rightFollower2;

    public DriveIOBRB() {
        this.leftLeader = new WPI_TalonSRX(0);
        this.rightLeader = new WPI_TalonSRX(1);
        this.leftLeader = new WPI_TalonSRX(2);
        this.rightLeader = new WPI_TalonSRX(3);
        this.leftLeader = new WPI_TalonSRX(4);
        this.rightLeader = new WPI_TalonSRX(5);

        leftFollower1.follow(leftLeader);
        leftFollower2.follow(leftLeader);
        rightFollower1.follow(rightLeader);
        rightFollower2.follow(rightLeader);

        leftLeader.setInverted(false);
        rightLeader.setInverted(true);
        rightFollower1.setInverted(InvertType.FollowMaster);
        leftFollower1.setInverted(InvertType.FollowMaster);
        rightFollower2.setInverted(InvertType.FollowMaster);
        leftFollower2.setInverted(InvertType.FollowMaster);
    }

    @Override
    public WPI_TalonSRX getLeftLeader() {
        return leftLeader;
    }

    @Override
    public WPI_TalonSRX getRightLeader() {
        return rightLeader;
    }

    @Override
    public void setSpeed(double leftSpeed, double rightSpeed) {
        // controlmode.setSpeed
        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);
    }

    @Override
    public void setBrakeMode(boolean enable) {
        NeutralMode mode = enable ? NeutralMode.Brake : NeutralMode.Coast;

    }
}
