package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
    public static final double maxEncoderValue = 0.0;

    private final ClimberIO climberIO;

    public Climber(ClimberIO climberIO) {
        this.climberIO = climberIO;
    }

    public void setVelocity(double velocity) {
        climberIO.setVelocity(velocity);
    }

    public void setUpVelocity(double velocity) {
        climberIO.setUpVelocity(velocity);
    }

    public void setDownVelocity(double velocity) {
        climberIO.setDownVelocity(velocity);
    }

    public void stop() {
        climberIO.stop();
    }

}
