package ADV;

 
import static org.junit.Assert.*;

import org.junit.Test;

public class ComputeSimulationStateTest {
	
	private void clearAlerts(Alerts alerts) {
		alerts.setESR(false);
		alerts.setESR_latch(false);
		alerts.setPWR60(false);
		alerts.setISRZ(false);
		alerts.setDC(false);
		alerts.setPD(false);
		alerts.setPOS(false);
		alerts.setPDMG(false);
		alerts.setPND(false);
		alerts.setshield_damage_count(0);
	}

	@Test
	public void test() {
		Alerts alerts = new Alerts();
		Measurements measurements = new Measurements();
		ComputeSimulationState state = new ComputeSimulationState();

		//test case 1 - Scenario 1a test alt BV of 249.9
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.805);
		measurements.setVd(-6.787);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(true,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(100.005,measurements.getVf(),0.0001);
		assertEquals(-6.667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 2 - Scenario 1a test alt BV of 50 and VF 100.001
		clearAlerts(alerts);
		measurements.setAltitude(53.2);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.801);
		measurements.setVd(-6.78673);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(true,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(50.0,measurements.getAltitude(),0.01);
		assertEquals(100.001,measurements.getVf(),0.0001);
		assertEquals(-6.6667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());

		//test case 3 - Scenario 2a test alt BV of 249.9 and Vf 100.0 
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.799);
		measurements.setVd(-6.78660);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(99.999,measurements.getVf(),0.0001);
		assertEquals(-6.6666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 4 - Scenario 2a test alt BV of 50 and VF 25.0
		clearAlerts(alerts);
		measurements.setAltitude(53.2);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(26.8);
		measurements.setVd(-1.78667);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(50.0,measurements.getAltitude(),0.01);
		assertEquals(25,measurements.getVf(),0.0001);
		assertEquals(-1.6667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());

		//test case 5 - Scenario 3a test alt BV of 49.9 and VF 100.0
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.800);
		measurements.setVd(-6.78667);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(100.000,measurements.getVf(),0.0001);
		assertEquals(-6.6667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 6 - Scenario 3a test alt BV of .1 and VF 25.0
		clearAlerts(alerts);
		measurements.setAltitude(1.5);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(26.455);
		measurements.setVd(-1.76367);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.1,measurements.getAltitude(),0.01);
		assertEquals(25.000,measurements.getVf(),0.0001);
		assertEquals(-1.6667,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(181,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 7 - Scenario 4a test alt BV of 49.9 and VF 100.0
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.800);
		measurements.setVd(-6.78667);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(100,measurements.getVf(),0.0001);
		assertEquals(-6.6667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(178,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 8 - Scenario 4a test alt BV of 0.1 and VF 25.0
		clearAlerts(alerts);
		measurements.setAltitude(1.5);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.455);
		measurements.setVd(-1.76367);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.1,measurements.getAltitude(),0.01);
		assertEquals(25.000,measurements.getVf(),0.0001);
		assertEquals(-1.6667,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 9 - Scenario 5a test alt BV of 49.9 and VF 24.999
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.799);
		measurements.setVd(-1.78660);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(24.999,measurements.getVf(),0.0001);
		assertEquals(-1.6666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(178,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 10 - Scenario 5a test alt BV of 0.1 and VF 15
		clearAlerts(alerts);
		measurements.setAltitude(1.5);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(16.455);
		measurements.setVd(-1.09700);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.1,measurements.getAltitude(),0.01);
		assertEquals(15.000,measurements.getVf(),0.0001);
		assertEquals(-1.0000,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 11 - Scenario 6a test alt BV of 49.9 and VF 14.998
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(16.799);
		measurements.setVd(-1.11993);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(true,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(14.999,measurements.getVf(),0.0001);
		assertEquals(-0.9999,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(178,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 12 - Scenario 6a test alt BV of .1 and VF 0.0 - issue
		clearAlerts(alerts);
		measurements.setAltitude(1.5);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(1.455);
		measurements.setVd(-0.09700);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(true,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.1,measurements.getAltitude(),0.01);
		assertEquals(0.000,measurements.getVf(),0.0001);
		assertEquals(0.0000,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 13 - Scenario 7a test alt BV of 0 and VF 0.0
		clearAlerts(alerts);
		measurements.setAltitude(0.0);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(0.0);
		measurements.setVd(0.0);
		measurements.setpower_remaining(179);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.0,measurements.getAltitude(),0.01);
		assertEquals(0.000,measurements.getVf(),0.0001);
		assertEquals(0.0000,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 14 - Scenario 7b test alt BV of 0, VF of 0.0, and cum att of 6 
		clearAlerts(alerts);
		measurements.setAltitude(0.0);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(0.0);
		measurements.setVd(0.0);
		measurements.setpower_remaining(179);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(6);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(true,alerts.isPND());
		assertEquals(true,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.0,measurements.getAltitude(),0.01);
		assertEquals(0.000,measurements.getVf(),0.0001);
		assertEquals(0.0000,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 15 - Scenario 7a test alt BV of 0, VF of 0.0, and check abs value of attitude 
		clearAlerts(alerts);
		measurements.setAltitude(0.0);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(0.0);
		measurements.setVd(0.0);
		measurements.setpower_remaining(179);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(-5);
		measurements.setTerr_attitude(1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.0,measurements.getAltitude(),0.01);
		assertEquals(0.000,measurements.getVf(),0.0001);
		assertEquals(0.0000,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 16 - Scenario 7b test alt BV of 0, VF of 0.0, and cum att of 6, check abs value of att
		clearAlerts(alerts);
		measurements.setAltitude(0.0);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(0.0);
		measurements.setVd(0.0);
		measurements.setpower_remaining(179);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(-6);
		measurements.setTerr_attitude(1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(true,alerts.isPND());
		assertEquals(true,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.0,measurements.getAltitude(),0.01);
		assertEquals(0.000,measurements.getVf(),0.0001);
		assertEquals(0.0000,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 17 - Scenario 1b test alt BV of 249.9
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.805);
		measurements.setVd(-6.78700);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(9);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(true,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(100.005,measurements.getVf(),0.0001);
		assertEquals(-6.6670,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 18 - Scenario 2b test alt BV of 249.9 and Vf of 100.0
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.799);
		measurements.setVd(-6.78660);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(99.999,measurements.getVf(),0.0001);
		assertEquals(-6.6667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 19 - Scenario 3b test alt BV of 49.9 and Vf of 100.0
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.800);
		measurements.setVd(-6.78667);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(100.000,measurements.getVf(),0.0001);
		assertEquals(-6.6667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 20 - Scenario 4b test alt BV of 49.9 and Vf of 100.0, battery value 180
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.800);
		measurements.setVd(-6.78667);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(100.000,measurements.getVf(),0.0001);
		assertEquals(-6.6667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(178,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 21 - Scenario 5b test alt BV of 49.9 and Vf of 24.999
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.799);
		measurements.setVd(-1.78660);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(24.999,measurements.getVf(),0.0001);
		assertEquals(-1.6666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(178,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//test case 22 - Scenario 6b test alt BV of 49.9 and Vf of 14.999
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(16.799);
		measurements.setVd(-1.11993);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(true,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(14.999,measurements.getVf(),0.0001);
		assertEquals(-0.9999,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(178,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 23 - Scenario 7c/7d test```````````````````````````` alt BV of 0 and Vf of 0  - issue
		clearAlerts(alerts);
		measurements.setAltitude(0.0);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(0.0);
		measurements.setVd(0.0);
		measurements.setpower_remaining(179);
		measurements.setRand(0.59);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.0,measurements.getAltitude(),0.01);
		assertEquals(0.0,measurements.getVf(),0.0001);
		assertEquals(0.0,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//test case 24 - Scenario 7c/7d test alt BV of 0 and Vf of 0
		clearAlerts(alerts);
		measurements.setAltitude(0.0);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(0.0);
		measurements.setVd(0.0);
		measurements.setpower_remaining(179);
		measurements.setRand(0.6);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(true,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.0,measurements.getAltitude(),0.01);
		assertEquals(0.0,measurements.getVf(),0.0001);
		assertEquals(0.0,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());

		//test case 25 - Scenario 7e test alt BV of 0 and Vf of 0
		clearAlerts(alerts);
		measurements.setAltitude(0.0);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(0.0);
		measurements.setVd(0.0);
		measurements.setpower_remaining(179);
		measurements.setRand(0.6);
		alerts.setShield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(6);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(true,alerts.isPND());
		assertEquals(true,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.0,measurements.getAltitude(),0.01);
		assertEquals(0.0,measurements.getVf(),0.0001);
		assertEquals(0.0,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
	}

}
