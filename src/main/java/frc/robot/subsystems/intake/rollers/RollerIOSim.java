package frc.robot.subsystems.intake.rollers;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants.IntakeConstants;

public class RollerIOSim implements RollerIO {
  // For instructions on how to implement this class, refer to the README.md file

  private DCMotorSim m_sim;
  private double storedVoltage;
  // define more members here as necessary

  public RollerIOSim() {
    // TODO: Implement this constructor
    m_sim =
        new DCMotorSim(
            DCMotor.getKrakenX60(1),
            IntakeConstants.kRollerGearing,
            IntakeConstants.kRollerJKgMetersSquared);
    storedVoltage = 0;
  }

  @Override
  public void updateInputs(RollerInputs inputs) {
    m_sim.update(0.02);

    inputs.voltage = getVoltage();
    inputs.velocityRadPerSec = getVelocityRadPerSec();
  }

  @Override
  public void setVoltage(double voltage) {
    // TODO: Implement this method
    m_sim.setInputVoltage(voltage);
    storedVoltage = voltage;
  }

  @Override
  public double getVoltage() {
    // TODO: Implement this method
    return storedVoltage;
  }

  @Override
  public double getVelocityRadPerSec() {
    // TODO: Implement this method
    return m_sim.getAngularVelocityRadPerSec();
  }
}
