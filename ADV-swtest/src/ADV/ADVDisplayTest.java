package ADV; 

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ADVDisplayTest {

	public ADVDisplayTest() {

	}

	private static final long serialVersionUID = 1L;

	private void clear_alerts(Alerts alerts) {
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
	private void initialize_objects (Measurements measurements, Alerts alerts) {
		measurements.setVd(-10.0);
   		measurements.setVf(150.0);
		measurements.setAltitude(225.0);
		measurements.setpower_remaining(300.0);
		alerts.setRand_value(-0.1);
		alerts.setshield_damage_count(0);
		alerts.setEsr_persistence_count(0);
		alerts.setPDMG(false); 
		alerts.setESR_latch(false);
		measurements.setCum_attitude(0);
		measurements.setshield_position("D");
		measurements.setshield_cmd(measurements.getshield_position());
		measurements.setAttitude_cmd("0");
		measurements.setCum_attitude(0); 
		measurements.setMotor_state("MP1");
	}

	@Test
	public void test() {
		int time = 5000; //time to sleep in milliseconds 
		ComputeSimulationState compState = new ComputeSimulationState() ;
		Measurements measurements = new Measurements();
    	Alerts alerts = new Alerts();
        ADVDisplay display = new ADVDisplay(measurements,alerts);

        display.setVisible(false);
        initialize_objects(measurements,alerts);
		clear_alerts(alerts);

        //Test Case 1
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(249.9);
		measurements.setVd(-6.667);
		measurements.setVf(100.005);
		measurements.setpower_remaining(180);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
        display.toggleR(true, measurements);
        compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
        {
            Thread.sleep(time);
        } catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
		
		//Test Case 2
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(249.9);
		measurements.setVd(-6.667);
		measurements.setVf(100.005);
		measurements.setpower_remaining(180);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleR(true, measurements);
		alerts.setshield_damage_count(10);
        compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
        {
            Thread.sleep(time);
        } catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
		
		//Test Case 3
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(249.9);
		measurements.setVd(-6.666);
		measurements.setVf(99.990);
		measurements.setpower_remaining(180);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleR(true, measurements);
        compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
        {
            Thread.sleep(time);
        } catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
		
		//Test Case 4
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(49.9);
		measurements.setVd(-6.666);
		measurements.setVf(99.990);
		measurements.setpower_remaining(180);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleR(true, measurements);
		compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
		{
			Thread.sleep(time);
		} catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}


		//Test Case 5
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		display.toggleD(false, measurements);
		measurements.setAltitude(0.1);
		measurements.setVd(-1.667);
		measurements.setVf(25.005);
		measurements.setpower_remaining(179);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleD(true, measurements);
		compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
		{
			Thread.sleep(time);
		} catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}

		//Test Case 6
		clear_alerts(alerts);
		display.toggleD(false, measurements);
		measurements.setAltitude(23.8);
		measurements.setVd(-1.666);
		measurements.setVf(24.990);
		measurements.setpower_remaining(172);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleD(true, measurements);
		compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
		{
			Thread.sleep(time);
		} catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}

		//Test Case 7
		clear_alerts(alerts);
		display.toggleD(false, measurements);
		measurements.setAltitude(14.0);
		measurements.setVd(-.999);
		measurements.setVf(14.985);
		measurements.setpower_remaining(165);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleD(true, measurements);
		compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
		{
			Thread.sleep(time);
		} catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}


		//Test Case 8
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(0.0);
		measurements.setVd(-.005);
		measurements.setVf(.075);
		measurements.setpower_remaining(155);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleR(true, measurements);
		compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
		{
			Thread.sleep(time);
		} catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
		
		//Test Case 9
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(0.0);
		measurements.setVd(-0.005);
		measurements.setVf(0.075);
		measurements.setpower_remaining(155);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(6);
		alerts.setRand_value(0.3);
		display.toggleR(true, measurements);
		compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
		{
			Thread.sleep(time);
		} catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
				
		//Test Case 10
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(0.0);
		measurements.setVd(-0.005);
		measurements.setVf(0.075);
		measurements.setpower_remaining(155);
		measurements.setTerr_attitude(5);
		measurements.setCum_attitude(-1);
		for(int i=0;i<=11;i++){
			alerts.setshield_damage_count(i);
		}
		alerts.setRand_value(0.3);
		display.toggleR(true, measurements);
		compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
		{
			Thread.sleep(time);
		} catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
				
		//Test Case 11
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(0.0);
		measurements.setVd(-0.005);
		measurements.setVf(0.075);
		measurements.setpower_remaining(155);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		alerts.setRand_value(0.4);
		display.toggleR(true, measurements);
		for(int i=0;i<=11;i++){
			alerts.setshield_damage_count(i);
		}
        compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
        {
            Thread.sleep(time);
        } catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
		
		//Test Case 12
		clear_alerts(alerts);
		display.toggleR(false, measurements);
		measurements.setAltitude(0.0);
		measurements.setVd(-0.005);
		measurements.setVf(0.075);
		measurements.setpower_remaining(155);
		measurements.setTerr_attitude(6);
		measurements.setCum_attitude(-1);
		alerts.setRand_value(0.3);
		display.toggleR(true, measurements);
		for(int i=0;i<=11;i++){
			alerts.setshield_damage_count(i);
		}
        compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
        {
            Thread.sleep(time);
        } catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }		
		
		//Test Case 13
		clear_alerts(alerts);
		alerts.setRand_value(-0.1);
		display.toggleR(false, measurements);
		display.toggleD(false, measurements);
		measurements.setAltitude(49.9);
		measurements.setVd(-6.666);
		measurements.setVf(99.990);
		measurements.setpower_remaining(180);
		measurements.setTerr_attitude(-1);
		measurements.setCum_attitude(5);
		display.toggleD(true, measurements);
        compState.compute_state(measurements, alerts, 0);
		display.updateDisplay(measurements, alerts);
		try 
        {
            Thread.sleep(time);
        } catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }	
		
	}

}
