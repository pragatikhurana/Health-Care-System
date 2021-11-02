package com.capgemini.healthcaresystem.serviceimpl;

/**
 * This class is to implement all methods from service layer related to Diagnostic Center
 * All business Logic related for Diagnostic Center is written in methods of this class
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.exceptions.DiagnosticCenterIDException;
import com.capgemini.healthcaresystem.exceptions.DiagnosticCenterNameException;
import com.capgemini.healthcaresystem.repository.AppointmentRepository;
import com.capgemini.healthcaresystem.repository.DiagnosticCenterRepository;
import com.capgemini.healthcaresystem.service.DiagnosticCenterService;
@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService {
	
	@Autowired
	DiagnosticCenterRepository diagnosticCenterRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	/**
	 * This method will get all Diagnostic Center
	 * */
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		return diagnosticCenterRepository.findAll();
	}

	/**
	 * This method will add Diagnostic Center by Center Name
	 * */
	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		try {
		diagnosticCenter.setName(diagnosticCenter.getName());
		return (DiagnosticCenter)diagnosticCenterRepository.save(diagnosticCenter);
		}catch(Exception ex) {
			throw new DiagnosticCenterIDException("Center name "+diagnosticCenter.getName()+" already exists");
		}
		
	}
	
	/**
	 * This method will get Diagnostic Center by Id
	 * */
	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		try {
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(diagnosticCenterId);
		return diagnosticCenter;
		}catch(Exception ex) {
			throw new DiagnosticCenterIDException("Center name "+diagnosticCenterId+" not exists");
		}
	}

	/**
	 * This method will update Diagnostic Center
	 * */
	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter,String centerName) {
		try {
		DiagnosticCenter existDiagnosticCenter=diagnosticCenterRepository.findByName(centerName);
		
		existDiagnosticCenter.setName(diagnosticCenter.getName());
		existDiagnosticCenter.setAddress(diagnosticCenter.getAddress());
		existDiagnosticCenter.setContactNo(diagnosticCenter.getContactNo());
		existDiagnosticCenter.setContactEmail((diagnosticCenter.getContactEmail()));
		existDiagnosticCenter.setServicesOffered(diagnosticCenter.getServicesOffered());
		DiagnosticCenter updateDiagnosticCenter=diagnosticCenterRepository.save(existDiagnosticCenter);
		return updateDiagnosticCenter;
		}catch(Exception ex) {
			throw new DiagnosticCenterNameException("Center name "+centerName+" doesn't exists");
		}
	}
	
	/**
	 * This method will get Diagnostic Center by Center Name
	 * */
	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerName) {
		try {
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findByName(centerName.toUpperCase());
		return diagnosticCenter;
	}catch(Exception ex) {
		throw new DiagnosticCenterNameException("Center name "+centerName+" doesn't exists");
	}
	}
	
	/**
	 * This method will delete Diagnostic Center by Id
	 * */
	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) {
		
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(id);
		diagnosticCenterRepository.delete(diagnosticCenter);
		return diagnosticCenter;
	
	}

}
