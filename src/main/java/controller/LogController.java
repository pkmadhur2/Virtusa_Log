package controller;

import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.LogModel;
import repo.LogRepo;

@RestController
public class LogController 
{
	@Autowired
	LogRepo logRepo;
	
	@GetMapping("/")
	public String Home() {
		return "Rest Server Started ";
	}
	
	@GetMapping("/getAllLog")
	public List<LogModel> allLogs(){
		return logRepo.findAll();
	}

	@GetMapping("/checkIn")
	public LogModel checkIn(@RequestParam String name)
	{
		LogModel logm=new LogModel();
		logm.setName(name);
		logm.setId(java.time.LocalTime.now().toString()+logm.getName()); //Set New Id
		String date=java.time.LocalDate.now().toString();
		String strDate=date.replace("-","/"); 
		logm.setDate(strDate); //auto
		logm.setTime(java.time.LocalTime.now().toString()); //auto
		logm.setLogType("CheckIn"); //auto
		return logRepo.save(logm);
	}
	
	@GetMapping("/checkOut")
	public LogModel checkOut(@RequestParam String name)
	{
		LogModel logm=new LogModel();
		logm.setName(name);
		logm.setId(java.time.LocalTime.now().toString()+logm.getName()); //Set New Id
		String date=java.time.LocalDate.now().toString();
		String strDate=date.replace("-","/"); 
		logm.setDate(strDate); //auto
		logm.setTime(java.time.LocalTime.now().toString()); //auto
		logm.setLogType("CheckOut"); //auto
		return logRepo.save(logm);
	}
	
	@GetMapping(path="/log" , produces={"application/json"})
	public List<LogModel> logBydate(@RequestParam String date)
	{
		return logRepo.findByDate(date);
	}
//	//Update
//	

//	@DeleteMapping("/delete/{id}")
//	public String deleteProduct(@RequestParam String id)
//	{
//		logRepo.deleteById(id);
//		return "Success";
//	}
}
