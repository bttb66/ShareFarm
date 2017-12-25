package model.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.DispatcherServlet;
import model.Machine;
import model.dao.MachineDAO;

public class MachineManager {
    
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private static MachineManager machineMan = new MachineManager();
	private MachineDAO machineDAO;

	private MachineManager() {
		try {
			machineDAO = new MachineDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MachineManager getInstance() {
		return machineMan;
	}
	
	// 1.
	public List<Machine> findTotalMachineList() throws SQLException {
		return machineDAO.findTotalMachineList();
	}
	
	//2.
	public List<Machine> findMachine(String machineName)
		throws SQLException, MachineNameNotFoundException{
            List<Machine> FindMachine = null;
		    FindMachine = MachineDAO.findMachine(machineName);
		
		if (FindMachine == null) {
			throw new MachineNameNotFoundException(machineName + "is null");
		}		
		return FindMachine;
	}
	
    //3.
    public Machine findDetailMachine(int machineId)
    throws SQLException, MachineIdNotFoundException{
        Machine Findmachine = MachineDAO.findDetailMachine(machineId);
        
         logger.info("Machine Detailmachine: {}", Findmachine);
        if (Findmachine == null) {
            throw new MachineIdNotFoundException(machineId + "is null");
        }
        return Findmachine;
    }
    
    
    public MachineDAO getUserDAO() {
        return this.machineDAO;
    }
    
 
    public int registMachine(Machine machine) throws SQLException, ExistingUserException {
        //if (machineDAO.existingFarm(machine.getMachineName()) == true) {
        // throw new ExistingUserException(farm.getMachineName() + "�뒗 議댁?���븯�뒗 �냽�옣�엯�땲�떎.");
        //}
        return machineDAO.registMachine(machine);
    }
}
