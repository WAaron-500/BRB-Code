package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.climber.Climber;

public class ClimberDownBitch extends CommandBase {

    private final Climber climber;
    private final double speed;

    public ClimberDownBitch(Climber climber, double speed) {

        this.speed = speed;
        this.climber = climber;

        addRequirements(climber);

    }

    @Override
    public void execute() {
        climber.setDownVelocity(speed);
    }

    @Override
    public void end(boolean interrupted) {
        climber.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
